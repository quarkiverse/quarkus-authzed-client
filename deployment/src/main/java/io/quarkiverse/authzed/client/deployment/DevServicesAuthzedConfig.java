package io.quarkiverse.authzed.client.deployment;

import java.util.Optional;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class DevServicesAuthzedConfig {

    static final String DEFAULT_IMAGE = "authzed/spicedb";

    static final String DEFAULT_IMAGE_TAG = "v1.11.0";

    static final String DEFAULT_SERVICE_NAME = "authzed";

    /**
     * If DevServices has been explicitly enabled or disabled. DevServices is generally enabled
     * by default, unless there is an existing configuration present.
     * <p>
     * When DevServices is enabled Quarkus will attempt to automatically configure and start
     * a database when running in 'dev' or 'test' mode.
     */
    @ConfigItem
    public Optional<Boolean> enabled;

    /**
     * The container image name to use, for container based DevServices providers.
     */
    @ConfigItem
    public Optional<String> imageName;

    /**
     * Indicates if the Authzed instance managed by Quarkus DevServices is shared.
     * When shared, Quarkus looks for running containers using label-based service discovery.
     * If a matching container is found, it is used, and so a second one is not started.
     * Otherwise, DevServices for Authzed starts a new container.
     * <p>
     * The discovery uses the {@code quarkus-dev-service-openfga} label.
     * The value is configured using the {@code service-name} property.
     * <p>
     * Container sharing is only used in 'dev' mode.
     */
    @ConfigItem(defaultValue = "true")
    public boolean shared;

    /**
     * The value of the {@code quarkus-dev-service-authzed} label attached to the started container.
     * This property is used when {@code shared} is set to {@code true}.
     * In this case, before starting a container, DevServices for Authzed looks for a container with the
     * {@code quarkus-dev-service-openfga} label
     * set to the configured value. If found, it will use this container instead of starting a new one, otherwise it
     * starts a new container with the {@code quarkus-dev-service-openfga} label set to the specified value.
     * <p>
     * This property is used when you need multiple shared Authzed instances.
     */
    @ConfigItem(defaultValue = "authzed")
    public String serviceName;

    /**
     * Optional fixed port the service will be bound to.
     * <p>
     * If not defined, the port will be chosen randomly.
     */
    @ConfigItem
    public OptionalInt port;

    /**
     * Name of authorization store to create for DevServices.
     * <p>
     * Defaults to "dev".
     */
    @ConfigItem(defaultValue = "dev")
    public String storeName;

    /**
     * Schema to upload during DevServices initialization.
     */
    @ConfigItem
    public Optional<String> schema;

    /**
     * Location of schema file to upload during DevServices initialization.
     * <p>
     * The location can be prefixed with {@code classpath:} or {@code filesystem:} to specify where the file
     * will be read from; if not prefixed, it will be read from the classpath.
     */
    @ConfigItem
    public Optional<String> schemaLocation;
}
