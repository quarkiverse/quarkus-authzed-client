package io.quarkiverse.authzed.client.deployment;

import java.util.Optional;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.smallrye.config.WithDefault;

@ConfigGroup
public interface MetricsConfig {

    /**
     * Flag to enable metrics (defaults to true)
     */
    @WithDefault("true")
    public Boolean enabled();

    /**
     * The container port the metrics will be bound to.
     */
    @WithDefault("9090")
    Integer port();

    /**
     * Optional host port the metrics will be bound to.
     * <p>
     * If not defined, the port will be chosen randomly.
     */
    OptionalInt hostPort();

    /**
     * The path to the TLS certificate.
     */
    Optional<String> tlsCertPath();

    /**
     * The path to the TLS key.
     */
    Optional<String> tlsKeyPath();

    /**
     * URL of the devservices metrics endpoint.
     * <p>
     * Note: This is only used to report the URL to the user.
     */
    Optional<String> url();

}
