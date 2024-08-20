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
     * The token to use to connect.
     */
    @WithDefault("false")
    boolean tlsEnabled();

    /**
     * The path to the file that holds certificates from Certified Authorities.
     */
    Optional<String> tlsCaCertPath();

    /**
     * The path to the TLS certificate.
     */
    Optional<String> tlsCertPath();

    /**
     * The path to the TLS certificate.
     */
    Optional<String> tlsKeyPath();

    /**
     * The TLS key file passphrase.
     */
    Optional<String> tlsKeyPassphrase();

    /**
     * The TLS key file passphrase.
     */
    Optional<String> tlsKeyAlgo();

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

}
