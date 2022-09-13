package io.quarkiverse.authzed.client.deployment;

import static io.quarkiverse.authzed.client.deployment.AuthzedClientProcessor.FEATURE;
import static java.lang.String.format;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.jboss.logging.Logger;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

import com.authzed.api.v1.SchemaServiceOuterClass;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
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
import io.quarkus.deployment.dev.devservices.GlobalDevServicesConfig;
import io.quarkus.deployment.logging.LoggingSetupBuildItem;
import io.quarkus.devservices.common.ContainerLocator;
import io.quarkus.runtime.configuration.ConfigUtils;
import io.quarkus.runtime.util.ClassPathUtils;

public class DevServicesAuthzedProcessor {

    private static final Logger log = Logger.getLogger(DevServicesAuthzedProcessor.class);
    static final String CONFIG_PREFIX = "quarkus.authzed.";

    static final String URL_CONFIG_KEY = CONFIG_PREFIX + "url";

    static final String TOKEN_CONFIG_KEY = CONFIG_PREFIX + "token";

    static final int AUTHZED_EXPOSED_PORT = 50051;
    static final String DEV_SERVICE_LABEL = "quarkus-dev-service-authzed";
    static final ContainerLocator authzedContainerLocator = new ContainerLocator(DEV_SERVICE_LABEL, AUTHZED_EXPOSED_PORT);

    private static volatile RunningDevService devService;
    private static volatile DevServicesAuthzedConfig capturedDevServicesConfiguration;
    private static volatile boolean first = true;

    @BuildStep(onlyIfNot = IsNormal.class, onlyIf = GlobalDevServicesConfig.Enabled.class)
    public DevServicesResultBuildItem startContainers(
            AuthzedBuildTimeConfig config,
            Optional<ConsoleInstalledBuildItem> consoleInstalledBuildItem,
            LaunchModeBuildItem launchMode,
            DockerStatusBuildItem dockerStatusBuildItem,
            CuratedApplicationShutdownBuildItem closeBuildItem,
            LoggingSetupBuildItem loggingSetupBuildItem,
            GlobalDevServicesConfig devServicesConfig,
            BuildProducer<DevServicesResultBuildItem> devServicesResults) {
        DevServicesAuthzedConfig currentDevServicesConfiguration = config.devServices;

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
                    devServicesConfig.timeout);
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
        if (!devServicesConfig.enabled.orElse(true)) {
            // explicitly disabled
            log.debug("Not starting devservices for authzed as it has been disabled in the config");
            return null;
        }

        boolean needToStart = !ConfigUtils.isPropertyPresent(URL_CONFIG_KEY);
        if (!needToStart) {
            log.debug("Not starting devservices for default authzed client as url has been provided");
            return null;
        }

        if (!dockerStatusBuildItem.isDockerAvailable()) {
            log.warn("Please configure " + URL_CONFIG_KEY + " or get a working docker instance");
            return null;
        }

        DockerImageName dockerImageName = DockerImageName
                .parse(devServicesConfig.imageName.orElse(DevServicesAuthzedConfig.DEFAULT_IMAGE))
                .asCompatibleSubstituteFor(DevServicesAuthzedConfig.DEFAULT_IMAGE);

        final Supplier<RunningDevService> defaultAuthzedInstanceSupplier = () -> {
            QuarkusAuthzedContainer container = new QuarkusAuthzedContainer(
                    dockerImageName,
                    devServicesConfig.port,
                    devServicesConfig.serviceName)
                    .withNetwork(Network.SHARED)
                    .waitingFor(Wait.forLogMessage(".*grpc server serving plaintext.*", 1));

            timeout.ifPresent(container::withStartupTimeout);
            log.info("Starting authzed...");
            container.start();

            var devServicesConfigProperties = new HashMap<String, String>();

            withClient(
                    container.getHost(),
                    container.getPort(),
                    client -> {
                        try {
                            devServicesConfigProperties.put(URL_CONFIG_KEY,
                                    new URL("https", container.getHost(), container.getPort(), "").toExternalForm());
                            devServicesConfigProperties.put(TOKEN_CONFIG_KEY, "test");
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                        loadSchema(devServicesConfig)
                                .ifPresentOrElse(schema -> {
                                    log.info("Initializing authorization schema ...");
                                    client.v1().schemaService().writeSchema(SchemaServiceOuterClass.WriteSchemaRequest
                                            .newBuilder().setSchema(schema).build());
                                },
                                        () -> {
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
                        devServicesConfig.serviceName,
                        devServicesConfig.shared,
                        launchMode.getLaunchMode())
                .map(containerAddress -> {
                    Map<String, String> devServicesConfigProperties = new HashMap<>();
                    devServicesConfigProperties.put(URL_CONFIG_KEY, containerAddress.getUrl());
                    devServicesConfigProperties.put(TOKEN_CONFIG_KEY, "test");
                    return new RunningDevService(
                            FEATURE,
                            containerAddress.getId(),
                            null,
                            devServicesConfigProperties);
                })
                .orElseGet(defaultAuthzedInstanceSupplier);
    }

    private static Optional<String> loadSchema(
            DevServicesAuthzedConfig devServicesConfig) {
        return devServicesConfig.schema
                .or(() -> {
                    return devServicesConfig.schemaLocation.map(location -> {
                        try {
                            var schemaPath = resolveSchemaPath(location);
                            return Files.readString(schemaPath);
                        } catch (Throwable x) {
                            throw new RuntimeException(
                                    format("Unable to load authorization model from '%s'", location));
                        }
                    });
                });
    }

    private static Path resolveSchemaPath(String location) throws IOException {
        location = normalizeLocation(location);
        if (location.startsWith("filesystem:")) {
            return Path.of(location.substring("filesystem:".length()));
        }

        var classpathPath = new AtomicReference<Path>();

        ClassPathUtils.consumeAsPaths(
                Thread.currentThread().getContextClassLoader(),
                location,
                classpathPath::set);

        return classpathPath.get();
    }

    private static String normalizeLocation(String location) {
        // Strip any 'classpath:' protocol prefixes because they are assumed
        // but not recognized by ClassLoader.getResources()
        if (location.startsWith("classpath:")) {
            location = location.substring("classpath:".length());
            if (location.startsWith("/")) {
                location = location.substring(1);
            }
        }
        if (!location.endsWith("/")) {
            location += "/";
        }
        return location;
    }

    private static void withClient(String host, Integer port, Consumer<AuthzedClient> consumer) {
        URL instanceURL;
        try {
            instanceURL = new URL("http", host, port, "");
        } catch (MalformedURLException e) {
            // Should not happen
            throw new RuntimeException(e);
        }
        AuthzedConfig config = new AuthzedConfig();
        config.url = instanceURL;
        config.token = "test";
        try (AuthzedClient client = new AuthzedClient(config)) {
            consumer.accept(client);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class QuarkusAuthzedContainer extends GenericContainer<QuarkusAuthzedContainer> {

        OptionalInt fixedExposedPort;

        public QuarkusAuthzedContainer(
                DockerImageName dockerImageName,
                OptionalInt fixedExposedPort,
                String serviceName) {
            super(dockerImageName);
            this.fixedExposedPort = fixedExposedPort;
            withCommand("serve", "--grpc-preshared-key", "\"test\"");
            withNetwork(Network.SHARED);
            if (serviceName != null) { // Only adds the label in dev mode.
                withLabel(DEV_SERVICE_LABEL, serviceName);
            }
        }

        @Override
        protected void configure() {
            super.configure();
            if (fixedExposedPort.isPresent()) {
                addFixedExposedPort(fixedExposedPort.getAsInt(), AUTHZED_EXPOSED_PORT);
            } else {
                addExposedPort(AUTHZED_EXPOSED_PORT);
            }
        }

        public int getPort() {
            if (fixedExposedPort.isPresent()) {
                return fixedExposedPort.getAsInt();
            }
            return super.getMappedPort(AUTHZED_EXPOSED_PORT);
        }
    }
}
