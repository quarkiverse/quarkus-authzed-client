package io.quarkiverse.authzed.client.deployment;

import static io.quarkiverse.authzed.client.deployment.AuthzedClientProcessor.FEATURE;
import static io.quarkiverse.authzed.client.deployment.DevServicesAuthzedProcessor.QuarkusAuthzedContainer.*;
import static java.lang.String.format;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jboss.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
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
import io.quarkus.bootstrap.classloading.QuarkusClassLoader;
import io.quarkus.deployment.IsDevServicesSupportedByLaunchMode;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.*;
import io.quarkus.deployment.dev.devservices.DevServicesConfig;
import io.quarkus.devservices.common.ComposeLocator;
import io.quarkus.devservices.common.ConfigureUtil;
import io.quarkus.devservices.common.ContainerLocator;
import io.quarkus.devservices.common.StartableContainer;
import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.configuration.ConfigUtils;
import io.smallrye.mutiny.Uni;

public class DevServicesAuthzedProcessor {

    private static final Logger log = Logger.getLogger(DevServicesAuthzedProcessor.class);

    static final String DEFAULT_IMAGE_TAG = "v1.35.2";
    static final String DEFAULT_IMAGE_NAME = "authzed/spicedb";
    static final String DEFAULT_IMAGE = DEFAULT_IMAGE_NAME + ":" + DEFAULT_IMAGE_TAG;

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
    static final ContainerLocator authzedContainerLocator = ContainerLocator.locateContainerWithLabels(AUTHZED_EXPOSED_PORT,
            DEV_SERVICE_LABEL);
    static final AtomicReference<ClassLoader> resourceClassLoader = new AtomicReference<>();

    @BuildStep(onlyIf = { IsDevServicesSupportedByLaunchMode.class, DevServicesConfig.Enabled.class })
    public void startContainers(AuthzedBuildTimeConfig config,
            LaunchModeBuildItem launchModeBuildItem,
            DockerStatusBuildItem dockerStatusBuildItem,
            List<DevServicesSharedNetworkBuildItem> sharedNetworkBuildItem,
            DevServicesComposeProjectBuildItem composeProjectBuildItem,
            DevServicesConfig devServicesConfig,
            BuildProducer<DevServicesResultBuildItem> devServicesResults) {

        resourceClassLoader.set(Thread.currentThread().getContextClassLoader());

        var launchMode = launchModeBuildItem.getLaunchMode();
        DevServicesAuthzedConfig authzedDevServiceConfig = config.devservices();

        if (!authzedDevServiceConfig.enabled()) {
            // explicitly disabled
            log.debug("Not starting devservices for AuthZed as it has been disabled in the config");
            return;
        }

        var useSharedNetwork = DevServicesSharedNetworkBuildItem.isSharedNetworkRequired(devServicesConfig,
                sharedNetworkBuildItem);

        boolean needToStart = !ConfigUtils.isPropertyNonEmpty(URL_CONFIG_KEY);
        if (!needToStart) {
            log.debug("Not starting devservices for default AuthZed client as url has been provided");
            return;
        }

        if (!dockerStatusBuildItem.isContainerRuntimeAvailable()) {
            log.warn("Requires configuration of '" + URL_CONFIG_KEY + "' or a working docker instance");
            return;
        }

        var dockerImageName = DockerImageName.parse(authzedDevServiceConfig.imageName().orElse(DEFAULT_IMAGE))
                .asCompatibleSubstituteFor(DEFAULT_IMAGE);

        final Supplier<DevServicesResultBuildItem> startSupplier = () -> DevServicesResultBuildItem.owned()
                .name(FEATURE)
                .serviceName(authzedDevServiceConfig.serviceName())
                .serviceConfig(config)
                .description("AuthZed DevServices Instance")
                .startable(() -> {
                    var container = new QuarkusAuthzedContainer(dockerImageName, authzedDevServiceConfig,
                            composeProjectBuildItem.getDefaultNetworkId(), useSharedNetwork, devServicesConfig.timeout());
                    if (authzedDevServiceConfig.shared()) {
                        container = container.withSharedServiceLabel(launchMode, DEV_SERVICE_LABEL,
                                authzedDevServiceConfig.serviceName());
                    }
                    return new StartableContainer<>(container);
                })
                .postStartHook(s -> {

                    withClient(
                            s.getContainer(),
                            authzedDevServiceConfig,
                            client -> {
                                loadSchema(authzedDevServiceConfig).ifPresentOrElse(schema -> {
                                    log.info("Initializing authorization schema ...");
                                    Uni<WriteSchemaResponse> writeSchemaResponse = client.v1().schemaService()
                                            .writeSchema(
                                                    SchemaServiceOuterClass.WriteSchemaRequest.newBuilder().setSchema(schema)
                                                            .build());
                                    writeSchemaResponse.await().indefinitely();

                                    loadAuthorizationTuples(authzedDevServiceConfig).forEach(tuple -> {
                                        log.debug(dockerImageName);
                                        Uni<WriteRelationshipsResponse> writeRelationshipRespone = client.v1()
                                                .permissionService()
                                                .writeRelationships(WriteRelationshipsRequest.newBuilder()
                                                        .addUpdates(RelationshipUpdate.newBuilder()
                                                                .setOperation(Operation.valueOf(OPERATION
                                                                        .concat(authzedDevServiceConfig.operationType()
                                                                                .toUpperCase())))
                                                                .setRelationship(Tuples.parseRelationship(tuple))
                                                                .build())
                                                        .build());
                                        writeRelationshipRespone.await().indefinitely();
                                    });

                                    log.info("Loaded tuples successfully");
                                }, () -> {
                                    log.warn("No schema configured");
                                });
                            });
                })
                .configProvider(getContainerConfigResolvers(authzedDevServiceConfig))
                .build();

        devServicesResults.produce(
                authzedContainerLocator
                        .locateContainer(authzedDevServiceConfig.serviceName(), authzedDevServiceConfig.shared(), launchMode)
                        .or(() -> ComposeLocator.locateContainer(composeProjectBuildItem,
                                List.of(authzedDevServiceConfig.imageName().orElse(DEFAULT_IMAGE_NAME)),
                                AUTHZED_EXPOSED_PORT, launchMode, useSharedNetwork))
                        .map(containerAddress -> {

                            var container = containerAddress.getRunningContainer();
                            var host = containerAddress.getHost();

                            var devServicesConfigProperties = new HashMap<String, String>();
                            container.getPortMapping(authzedDevServiceConfig.grpc().port())
                                    .ifPresentOrElse(grpcPort -> devServicesConfigProperties.put(GRPC_URL_CONFIG_KEY,
                                            getGrpcURL(isGrpcTLS(authzedDevServiceConfig), host, grpcPort).toExternalForm()),
                                            () -> {
                                                if (authzedDevServiceConfig.grpc().enabled()) {
                                                    log.warn("No grpc port mapping found for AuthZed container");
                                                }
                                            });
                            container.getPortMapping(authzedDevServiceConfig.http().port())
                                    .ifPresentOrElse(httpPort -> devServicesConfigProperties.put(HTTP_URL_CONFIG_KEY,
                                            getHttpURL(isHttpTLS(authzedDevServiceConfig), host, httpPort).toExternalForm()),
                                            () -> {
                                                if (authzedDevServiceConfig.http().enabled()) {
                                                    log.warn("No http port mapping found for AuthZed container");
                                                }
                                            });
                            container.getPortMapping(authzedDevServiceConfig.metrics().port())
                                    .ifPresentOrElse(metricsPort -> devServicesConfigProperties.put(METRICS_URL_CONFIG_KEY,
                                            getMetricsURL(isMetricsTLS(authzedDevServiceConfig), host, metricsPort)
                                                    .toExternalForm()),
                                            () -> {
                                                if (authzedDevServiceConfig.metrics().enabled()) {
                                                    log.warn("No metrics port mapping found for AuthZed container");
                                                }
                                            });
                            devServicesConfigProperties.put(TOKEN_CONFIG_KEY, authzedDevServiceConfig.grpc().presharedKey());

                            return DevServicesResultBuildItem.discovered()
                                    .name(FEATURE)
                                    .containerId(containerAddress.getId())
                                    .description("OpenFGA DevServices Services")
                                    .config(devServicesConfigProperties)
                                    .build();
                        })
                        .orElseGet(startSupplier));
    }

    private static @NotNull HashMap<String, Function<StartableContainer<QuarkusAuthzedContainer>, String>> getContainerConfigResolvers(
            DevServicesAuthzedConfig authzedDevServiceConfig) {
        var configPropertyResolvers = new HashMap<String, Function<StartableContainer<QuarkusAuthzedContainer>, String>>();
        configPropertyResolvers.put(URL_CONFIG_KEY, s -> s.getContainer().getGrpcURL().toExternalForm());
        configPropertyResolvers.put(GRPC_URL_CONFIG_KEY, s -> s.getContainer().getGrpcURL().toExternalForm());
        configPropertyResolvers.put(HTTP_URL_CONFIG_KEY, s -> s.getContainer().getHttpURL().toExternalForm());
        configPropertyResolvers.put(METRICS_URL_CONFIG_KEY, s -> s.getContainer().getMetricsURL().toExternalForm());
        configPropertyResolvers.put(TOKEN_CONFIG_KEY, ignored -> authzedDevServiceConfig.grpc().presharedKey());
        return configPropertyResolvers;
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
        var resCL = resourceClassLoader.get();
        var is = resCL != null ? resCL.getResourceAsStream(resource) : null;
        if (is == null) {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            if (is == null) {
                is = QuarkusClassLoader.getSystemResourceAsStream(resource);
            }
        }
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

    static class QuarkusAuthzedContainer extends GenericContainer<QuarkusAuthzedContainer> {

        private final String sharedHostName;
        private final List<String> command = new ArrayList<>();
        private final int grpcPort;
        private final OptionalInt fixedExposedGrpcPort;
        private final boolean grpcTlsEnabled;
        private final int httpPort;
        private final OptionalInt fixedExposedHttpPort;
        private final boolean httpTlsEnabled;
        private final int metricsPort;
        private final OptionalInt fixedExposedMetricsPort;
        private final boolean metrisTlsEnabled;
        boolean useSharedNetwork;

        public QuarkusAuthzedContainer(DockerImageName dockerImageName, DevServicesAuthzedConfig config,
                String defaultNetworkId, boolean useSharedNetwork, Optional<Duration> timeout) {
            super(dockerImageName);
            this.waitStrategy = Wait.forLogMessage(".*grpc server started serving.*", 1);
            timeout.ifPresent(this.waitStrategy::withStartupTimeout);
            this.grpcPort = config.grpc().port();
            this.fixedExposedGrpcPort = config.grpc().hostPort();
            this.grpcTlsEnabled = isGrpcTLS(config);
            this.httpPort = config.http().port();
            this.fixedExposedHttpPort = config.http().hostPort();
            this.httpTlsEnabled = isHttpTLS(config);
            this.metricsPort = config.metrics().port();
            this.fixedExposedMetricsPort = config.metrics().hostPort();
            this.metrisTlsEnabled = isMetricsTLS(config);
            this.useSharedNetwork = useSharedNetwork;
            this.sharedHostName = ConfigureUtil.configureNetwork(this, defaultNetworkId, useSharedNetwork, "authzed");

            configureCommand(config);
        }

        public QuarkusAuthzedContainer withSharedServiceLabel(LaunchMode launchMode, String serviceLabel, String serviceName) {
            return ConfigureUtil.configureSharedServiceLabel(this, launchMode, serviceLabel, serviceName);
        }

        private void configureCommand(DevServicesAuthzedConfig config) {
            var command = new ArrayList<String>();
            command.add("serve");

            if (config.grpc().enabled()) {
                configureGrpc(config, command);
            }

            if (config.http().enabled()) {
                configureHttp(config, command);
            }

            if (config.metrics().enabled()) {
                configureMetrics(config, command);
            }

            setCommand(command.toArray(String[]::new));
        }

        private void configureGrpc(DevServicesAuthzedConfig config, List<String> command) {
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

        private void configureHttp(DevServicesAuthzedConfig config, List<String> command) {
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

        private void configureMetrics(DevServicesAuthzedConfig config, List<String> command) {
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

        @Override
        protected void configure() {
            super.configure();
            if (useSharedNetwork) {
                return;
            }

            if (fixedExposedGrpcPort.isPresent()) {
                addFixedExposedPort(fixedExposedGrpcPort.getAsInt(), grpcPort);
            } else {
                addExposedPort(grpcPort);
            }

            if (fixedExposedHttpPort.isPresent()) {
                addFixedExposedPort(fixedExposedHttpPort.getAsInt(), httpPort);
            } else {
                addExposedPort(httpPort);
            }

            if (fixedExposedMetricsPort.isPresent()) {
                addFixedExposedPort(fixedExposedMetricsPort.getAsInt(), metricsPort);
            } else {
                addExposedPort(metricsPort);
            }
        }

        @Override
        public String getHost() {
            return useSharedNetwork ? sharedHostName : super.getHost();
        }

        public Integer getGrpcPort() {
            return fixedExposedGrpcPort.orElseGet(() -> super.getMappedPort(grpcPort));
        }

        public static URL getURL(boolean isTLS, String host, int port, String path) {
            try {
                return new URL(isTLS ? "https" : "http", host, port, path);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        public static URL getGrpcURL(boolean isTLS, String host, int port) {
            return getURL(isTLS, host, port, "");
        }

        public URL getGrpcURL() {
            return getGrpcURL(grpcTlsEnabled, getHost(), getGrpcPort());
        }

        public Integer getHttpPort() {
            return fixedExposedHttpPort.orElseGet(() -> super.getMappedPort(httpPort));
        }

        public static URL getHttpURL(boolean isTLS, String host, int port) {
            return getURL(isTLS, host, port, "/v1");
        }

        public URL getHttpURL() {
            return getHttpURL(httpTlsEnabled, getHost(), getHttpPort());
        }

        public Integer getMetricsPort() {
            return fixedExposedMetricsPort.orElseGet(() -> super.getMappedPort(metricsPort));
        }

        public static URL getMetricsURL(boolean isTLS, String host, int port) {
            return getURL(isTLS, host, port, "");
        }

        public URL getMetricsURL() {
            return getMetricsURL(metrisTlsEnabled, getHost(), getMetricsPort());
        }
    }

    private static boolean isGrpcTLS(DevServicesAuthzedConfig config) {
        return config.grpc().tlsCertPath().isPresent() && config.grpc().tlsKeyPath().isPresent();
    }

    private static boolean isHttpTLS(DevServicesAuthzedConfig config) {
        return config.http().tlsCertPath().isPresent() && config.http().tlsKeyPath().isPresent();
    }

    private static boolean isMetricsTLS(DevServicesAuthzedConfig config) {
        return config.metrics().tlsCertPath().isPresent() && config.metrics().tlsKeyPath().isPresent();
    }
}
