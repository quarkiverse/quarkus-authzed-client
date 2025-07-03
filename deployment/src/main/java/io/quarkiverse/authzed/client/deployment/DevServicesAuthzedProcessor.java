package io.quarkiverse.authzed.client.deployment;

import static io.quarkiverse.authzed.client.deployment.AuthzedClientProcessor.FEATURE;
import static java.lang.String.format;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jboss.logging.Logger;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import com.authzed.api.v1.Core.RelationshipUpdate;
import com.authzed.api.v1.Core.RelationshipUpdate.Operation;
import com.authzed.api.v1.PermissionService.WriteRelationshipsRequest;
import com.authzed.api.v1.PermissionService.WriteRelationshipsResponse;
import com.authzed.api.v1.SchemaServiceOuterClass;
import com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaResponse;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.utils.Tuples;
import io.quarkus.deployment.IsNormal;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.CuratedApplicationShutdownBuildItem;
import io.quarkus.deployment.builditem.DevServicesResultBuildItem;
import io.quarkus.deployment.builditem.DevServicesResultBuildItem.RunningDevService;
import io.quarkus.deployment.builditem.DockerStatusBuildItem;
import io.quarkus.deployment.builditem.LaunchModeBuildItem;
import io.quarkus.deployment.console.ConsoleInstalledBuildItem;
import io.quarkus.deployment.console.StartupLogCompressor;
import io.quarkus.deployment.dev.devservices.DevServicesConfig;
import io.quarkus.deployment.logging.LoggingSetupBuildItem;
import io.quarkus.devservices.common.ContainerLocator;
import io.quarkus.runtime.configuration.ConfigUtils;
import io.smallrye.mutiny.Uni;

public class DevServicesAuthzedProcessor {

    private static final Logger log = Logger.getLogger(DevServicesAuthzedProcessor.class);

    static final String DEFAULT_IMAGE_TAG = "v1.35.2";
    static final String DEFAULT_IMAGE = "authzed/spicedb:" + DEFAULT_IMAGE_TAG;

    static final String CONFIG_PREFIX = "quarkus.authzed.";
    static final String OPERATION = "OPERATION_";

    static final String URL_CONFIG_KEY = CONFIG_PREFIX + "url";
    static final String TOKEN_CONFIG_KEY = CONFIG_PREFIX + "token";

    static final String DS_CONFIG_PREFIX = "quarkus.authzed.devservices.";
    static final String GRPC_URL_CONFIG_KEY = DS_CONFIG_PREFIX + "grpc.url";
    static final String HTTP_URL_CONFIG_KEY = DS_CONFIG_PREFIX + "http.url";
    static final String METRICS_URL_CONFIG_KEY = DS_CONFIG_PREFIX + "metrics.url";

    static final int AUTHZED_EXPOSED_PORT = 50051;
    static final String DEV_SERVICE_LABEL = "quarkus-dev-service-authzed";
    static final ContainerLocator authzedContainerLocator = new ContainerLocator(DEV_SERVICE_LABEL, AUTHZED_EXPOSED_PORT);

    private static volatile RunningDevService devService;
    private static volatile DevServicesAuthzedConfig capturedDevServicesConfiguration;
    private static volatile boolean first = true;

    @BuildStep(onlyIfNot = IsNormal.class, onlyIf = DevServicesConfig.Enabled.class)
    public DevServicesResultBuildItem startContainers(
            AuthzedBuildTimeConfig config,
            Optional<ConsoleInstalledBuildItem> consoleInstalledBuildItem,
            LaunchModeBuildItem launchMode,
            DockerStatusBuildItem dockerStatusBuildItem,
            CuratedApplicationShutdownBuildItem closeBuildItem,
            LoggingSetupBuildItem loggingSetupBuildItem,
            DevServicesConfig devServicesConfig,
            BuildProducer<DevServicesResultBuildItem> devServicesResults) {

        DevServicesAuthzedConfig currentDevServicesConfiguration = config.devservices();

        // figure out if we need to shut down and restart any existing authzed container
        // if not and the authzed container have already started we just return
        if (devService != null) {
            boolean restartRequired = !currentDevServicesConfiguration.equals(
                    capturedDevServicesConfiguration);
            if (!restartRequired) {
                return devService.toBuildItem();
            }
            try {
                devService.close();
            } catch (Throwable e) {
                log.error("Failed to stop authzed container", e);
            }
            devService = null;
            capturedDevServicesConfiguration = null;
        }

        capturedDevServicesConfiguration = currentDevServicesConfiguration;

        StartupLogCompressor compressor = new StartupLogCompressor(
                (launchMode.isTest() ? "(test) " : "") + "Authzed Dev Services Starting:",
                consoleInstalledBuildItem,
                loggingSetupBuildItem);
        try {
            devService = startContainer(
                    dockerStatusBuildItem,
                    currentDevServicesConfiguration,
                    launchMode,
                    devServicesConfig.timeout());
            if (devService != null) {
                if (devService.isOwner()) {
                    log.info("Dev Services for authzed started.");
                    log.infof(
                            "Other Quarkus applications in dev mode will find the " +
                                    "instance automatically. For Quarkus applications in production mode, you can connect to" +
                                    " this by starting your application with -D%s=%s -D%s=%s",
                            URL_CONFIG_KEY,
                            devService.getConfig().get(URL_CONFIG_KEY),
                            TOKEN_CONFIG_KEY,
                            devService.getConfig().get(TOKEN_CONFIG_KEY));
                }
            } else {
                return null;
            }
        } catch (Throwable t) {
            compressor.closeAndDumpCaptured();
            throw new RuntimeException(t);
        } finally {
            compressor.close();
        }

        if (first) {
            first = false;
            Runnable closeTask = () -> {
                if (devService != null) {
                    try {
                        devService.close();
                    } catch (Throwable t) {
                        log.error("Failed to stop authzed container", t);
                    }
                    devService = null;
                    log.info("Dev Services for authzed shut down.");
                }
                first = true;
                capturedDevServicesConfiguration = null;
            };
            closeBuildItem.addCloseTask(closeTask, true);
        }

        return devService.toBuildItem();
    }

    private RunningDevService startContainer(
            DockerStatusBuildItem dockerStatusBuildItem,
            DevServicesAuthzedConfig devServicesConfig,
            LaunchModeBuildItem launchMode,
            Optional<Duration> timeout) {

        if (!devServicesConfig.enabled()) {
            // explicitly disabled
            log.debug("Not starting devservices for authzed as it has been disabled in the config");
            return null;
        }

        boolean needToStart = !ConfigUtils.isPropertyPresent(URL_CONFIG_KEY);
        if (!needToStart) {
            log.debug("Not starting devservices for default authzed client as url has been provided");
            return null;
        }

        if (!dockerStatusBuildItem.isContainerRuntimeAvailable()) {
            log.warn("Please configure " + URL_CONFIG_KEY + " or get a working docker instance");
            return null;
        }

        DockerImageName dockerImageName = DockerImageName
                .parse(devServicesConfig.imageName().orElse(DEFAULT_IMAGE))
                .asCompatibleSubstituteFor(DEFAULT_IMAGE);

        final Supplier<RunningDevService> defaultAuthzedInstanceSupplier = () -> {
            QuarkusAuthzedContainer container = new QuarkusAuthzedContainer(dockerImageName, devServicesConfig)
                    .withNetwork(Network.SHARED)
                    .waitingFor(Wait.forLogMessage(".*grpc server started serving.*", 1));

            timeout.ifPresent(container::withStartupTimeout);
            log.info("Starting authzed...");
            container.start();

            var devServicesConfigProperties = new HashMap<String, String>();

            withClient(
                    container,
                    devServicesConfig,
                    client -> {
                        devServicesConfigProperties.put(URL_CONFIG_KEY, container.getGrpcURL().toExternalForm());
                        devServicesConfigProperties.put(GRPC_URL_CONFIG_KEY, container.getGrpcURL().toExternalForm());
                        devServicesConfigProperties.put(HTTP_URL_CONFIG_KEY, container.getHttpURL().toExternalForm());
                        devServicesConfigProperties.put(METRICS_URL_CONFIG_KEY, container.getMetricsURL().toExternalForm());
                        devServicesConfigProperties.put(TOKEN_CONFIG_KEY, devServicesConfig.grpc().presharedKey());
                        loadSchema(devServicesConfig).ifPresentOrElse(schema -> {
                            log.info("Initializing authorization schema ...");
                            Uni<WriteSchemaResponse> writeSchemaResponse = client.v1().schemaService()
                                    .writeSchema(
                                            SchemaServiceOuterClass.WriteSchemaRequest.newBuilder().setSchema(schema).build());
                            writeSchemaResponse.await().indefinitely();

                            loadAuthorizationTuples(devServicesConfig).forEach(tuple -> {
                                log.debug(dockerImageName);
                                Uni<WriteRelationshipsResponse> writeRelationshipRespone = client.v1().permissionService()
                                        .writeRelationships(WriteRelationshipsRequest.newBuilder()
                                                .addUpdates(RelationshipUpdate.newBuilder()
                                                        .setOperation(Operation.valueOf(OPERATION
                                                                .concat(devServicesConfig.operationType().toUpperCase())))
                                                        .setRelationship(Tuples.parseRelationship(tuple))
                                                        .build())
                                                .build());
                                writeRelationshipRespone.await().indefinitely();
                            });
                            log.info("Loaded tuples succesfully");
                        }, () -> {
                            log.warn("No schema configured");
                        });
                    });

            return new RunningDevService(
                    FEATURE,
                    container.getContainerId(),
                    container::close,
                    devServicesConfigProperties);
        };

        return authzedContainerLocator
                .locateContainer(
                        devServicesConfig.serviceName(),
                        devServicesConfig.shared(),
                        launchMode.getLaunchMode())
                .map(containerAddress -> {
                    Map<String, String> devServicesConfigProperties = new HashMap<>();
                    devServicesConfigProperties.put(URL_CONFIG_KEY, containerAddress.getUrl());
                    devServicesConfigProperties.put(TOKEN_CONFIG_KEY, devServicesConfig.grpc().presharedKey());
                    return new RunningDevService(
                            FEATURE,
                            containerAddress.getId(),
                            null,
                            devServicesConfigProperties);
                })
                .orElseGet(defaultAuthzedInstanceSupplier);
    }

    private static Optional<String> loadSchema(DevServicesAuthzedConfig devServicesConfig) {
        return devServicesConfig.schema()
                .or(() -> {
                    return devServicesConfig.schemaLocation().map(location -> {
                        try {
                            return streamFileOrResource(location).collect(Collectors.joining("\n"));
                        } catch (Throwable x) {
                            throw new RuntimeException(format("Unable to load authorization model from '%s'", location), x);
                        }
                    });
                });
    }

    private static List<String> loadAuthorizationTuples(DevServicesAuthzedConfig devServicesConfig) {
        return devServicesConfig.authorizationTuples().map(lines -> Arrays.asList(lines.split("[\n\r]")))
                .orElseGet(() -> devServicesConfig.authorizationTuplesLocation().map(location -> {
                    try {
                        return streamFileOrResource(location)
                                .collect(Collectors.toList());
                    } catch (Throwable x) {
                        throw new RuntimeException(format("Unable to load authorization tuples from '%s'", location));
                    }
                }).orElseGet(Collections::emptyList));
    }

    private static Stream<String> streamFileOrResource(String location) {
        if (location.startsWith("classpath:")) {
            return streamClasspathResource(location.substring("classpath:".length()));
        } else if (location.startsWith("filesystem:")) {
            return streamFile(location.substring("filesystem:".length()));
        } else {
            return streamClasspathResource(location);
        }
    }

    private static Stream<String> streamFile(String path) {
        try (InputStream is = new FileInputStream(path)) {
            return streamLines(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<String> streamClasspathResource(String resource) {
        InputStream is;
        is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        if (is == null) {
            throw new RuntimeException("Failed to read classpath resource:" + resource);
        }
        return streamLines(is);
    }

    private static Stream<String> streamLines(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines().map(String::trim).filter(s -> !s.isEmpty());
    }

    private static void withClient(QuarkusAuthzedContainer container, DevServicesAuthzedConfig devServicesAuthzedConfig,
            Consumer<AuthzedClient> consumer) {

        var url = container.getGrpcURL();
        var presharedKey = devServicesAuthzedConfig.grpc().presharedKey();

        try (AuthzedClient client = new AuthzedClient(url, presharedKey)) {
            consumer.accept(client);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class QuarkusAuthzedContainer extends GenericContainer<QuarkusAuthzedContainer> {

        DevServicesAuthzedConfig config;
        List<String> command = new ArrayList<>();

        public QuarkusAuthzedContainer(DockerImageName dockerImageName, DevServicesAuthzedConfig config) {
            super(dockerImageName);
            this.config = config;
        }

        @Override
        protected void configure() {
            super.configure();
            command.add("serve");

            configureGrpc();

            if (config.http().enabled()) {
                configureHttp();
            }

            if (config.metrics().enabled()) {
                configureMetrics();
            }

            withCommand(command.toArray(new String[command.size()]));
            withNetwork(Network.SHARED);

            if (config.serviceName() != null) { // Only adds the label in dev mode.
                withLabel(DEV_SERVICE_LABEL, config.serviceName());
            }
        }

        private void configureGrpc() {
            command.add("--grpc-preshared-key");
            command.add(config.grpc().presharedKey());
            command.add("--grpc-enabled");
            command.add("--grpc-addr");
            command.add(":" + config.grpc().port());
            config.grpc().tlsCertPath().ifPresent(path -> {
                var containerPath = "/certs/grpc/tls.crt";
                withFileSystemBind(path, containerPath, BindMode.READ_ONLY);
                command.add("--grpc-tls-cert-path");
                command.add(containerPath);
            });
            config.grpc().tlsKeyPath().ifPresent(path -> {
                var containerPath = "/certs/grpc/tls.key";
                withFileSystemBind(path, containerPath, BindMode.READ_ONLY);
                command.add("--grpc-tls-key-path");
                command.add(containerPath);
            });

            if (config.grpc().hostPort().isPresent()) {
                addFixedExposedPort(config.grpc().hostPort().getAsInt(), config.grpc().port());
            } else {
                addExposedPort(config.grpc().port());
            }
        }

        private void configureHttp() {
            command.add("--http-enabled");
            command.add("--http-addr");
            command.add(":" + config.http().port());
            config.http().tlsCertPath().ifPresent(path -> {
                var containerPath = "/certs/http/tls.crt";
                withFileSystemBind(path, containerPath, BindMode.READ_ONLY);
                command.add("--http-tls-cert-path");
                command.add(containerPath);
            });
            config.http().tlsKeyPath().ifPresent(path -> {
                var containerPath = "/certs/http/tls.key";
                withFileSystemBind(path, containerPath, BindMode.READ_ONLY);
                command.add("--http-tls-key-path");
                command.add(containerPath);
            });

            if (config.http().hostPort().isPresent()) {
                addFixedExposedPort(config.http().hostPort().getAsInt(), config.http().port());
            } else {
                addExposedPort(config.http().port());
            }
        }

        private void configureMetrics() {
            command.add("--metrics-enabled");
            command.add("--metrics-addr");
            command.add(":" + config.metrics().port());
            config.metrics().tlsCertPath().ifPresent(path -> {
                var containerPath = "/certs/metrics/tls.crt";
                withFileSystemBind(path, containerPath, BindMode.READ_ONLY);
                command.add("--metrics-tls-cert-path");
                command.add(containerPath);
            });
            config.metrics().tlsKeyPath().ifPresent(path -> {
                var containerPath = "/certs/metrics/tls.key";
                withFileSystemBind(path, containerPath, BindMode.READ_ONLY);
                command.add("--metrics-tls-key-path");
                command.add(containerPath);
            });

            if (config.metrics().hostPort().isPresent()) {
                addFixedExposedPort(config.metrics().hostPort().getAsInt(), config.metrics().port());
            } else {
                addExposedPort(config.metrics().port());
            }
        }

        public Integer getGrpcPort() {
            return config.grpc().hostPort().orElseGet(() -> super.getMappedPort(config.grpc().port()));
        }

        public URL getGrpcURL() {
            try {
                boolean useHttps = config.grpc().tlsCertPath().isPresent() && config.grpc().tlsKeyPath().isPresent();
                return new URL(useHttps ? "https" : "http", getHost(), getGrpcPort(), "");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        public Integer getHttpPort() {
            return config.http().hostPort().orElseGet(() -> super.getMappedPort(config.http().port()));
        }

        public URL getHttpURL() {
            try {
                boolean useHttps = config.http().tlsCertPath().isPresent() && config.http().tlsKeyPath().isPresent();
                return new URL(useHttps ? "https" : "http", getHost(), getHttpPort(), "/v1");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        public Integer getMetricsPort() {
            return config.metrics().hostPort().orElseGet(() -> super.getMappedPort(config.metrics().port()));
        }

        public URL getMetricsURL() {
            try {
                boolean useHttps = config.metrics().tlsCertPath().isPresent() && config.metrics().tlsKeyPath().isPresent();
                return new URL(useHttps ? "https" : "http", getHost(), getMetricsPort(), "");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
