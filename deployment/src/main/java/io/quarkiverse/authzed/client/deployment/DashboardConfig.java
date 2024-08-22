
package io.quarkiverse.authzed.client.deployment;

import java.util.Optional;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.smallrye.config.WithDefault;

@ConfigGroup
public interface DashboardConfig {

    /**
     * Flag to enable dashboard (defaults to true)
     */
    @WithDefault("true")
    Boolean enabled();

    /**
     * The container port the dashboard will be bound to.
     */
    @WithDefault("8443")
    Integer port();

    /**
     * Optional host port the dashboard will be bound to.
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
     * URL of the devservices Dashboard endpoint.
     * <p>
     * Note: This is only used to report the URL to the user.
     */
    Optional<String> url();

}
