package io.quarkiverse.authzed.runtime.config;

import java.net.URL;
import java.util.Optional;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigRoot(phase = ConfigPhase.RUN_TIME)
@ConfigMapping(prefix = AuthzedConfig.PREFIX)
public interface AuthzedConfig {

    String PREFIX = "quarkus.authzed";

    /**
     * Authzed URL.
     * Example: <a href="http://authzed:50051">http://authzed:50051</a>
     */
    URL url();

    /**
     * The name of the TLS configuration to use.
     * <p>
     * If not set and the default TLS configuration is configured ({@code quarkus.tls.*}) then that will be used.
     * If a name is configured, it uses the configuration from {@code quarkus.tls.<name>.*}
     * If a name is configured, but no TLS configuration is found with that name then an error will be thrown.
     */
    Optional<String> tlsConfigurationName();

    /**
     * The token to use to connect.
     */
    String token();

    /**
     * Time in mills to wait without read activity before sending the keep alive
     * ping.
     */
    OptionalInt keepAliveTime();

    /**
     * Time in mills to wait without read activity after sending the keep alive
     * ping.
     */
    OptionalInt keepAliveTimeout();

    /**
     * Time in mills to wait before going to idle mode.
     */
    OptionalInt idleTimeout();

    /**
     * Whether retry is enabled.
     * Note that retry is disabled by default.
     */
    @WithDefault("false")
    boolean retry();

    /**
     * The max number of hedged attempts.
     * Retry must be explicitly enabled.
     */
    @WithDefault("2")
    int maxHedgedAttempts();

    /**
     * The max number of retry attempts.
     * Retry must be explicitly enabled.
     */
    @WithDefault("2")
    int maxRetryAttempts();
}
