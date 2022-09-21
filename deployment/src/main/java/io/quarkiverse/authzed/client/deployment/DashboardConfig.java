
package io.quarkiverse.authzed.client.deployment;

import java.util.Optional;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class DashboardConfig {

    /**
     * Flag to enable dashboard (defaults to true)
     */
    @ConfigItem(defaultValue = "true")
    public Boolean enabled;

    /**
     * The container port the dashboard will be bound to.
     */
    @ConfigItem(defaultValue = "8443")
    public Integer port;

    /**
     * Optional host port the dashboard will be bound to.
     * <p>
     * If not defined, the port will be chosen randomly.
     */
    @ConfigItem
    public OptionalInt hostPort;

    /**
     * The path to the TLS certificate.
     */
    @ConfigItem
    public Optional<String> tlsCertPath;

    /**
     * The path to the TLS key.
     */
    @ConfigItem
    public Optional<String> tlsKeyPath;

}
