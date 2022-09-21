package io.quarkiverse.authzed.runtime.config;

import java.net.URL;
import java.util.Optional;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

@ConfigRoot(name = "authzed", phase = ConfigPhase.RUN_TIME)
public class AuthzedConfig {

    /**
     * Authzed URL.
     * Example: http://authzed:50051
     */
    @ConfigItem
    public URL url;

    /**
     * The token to use to connect.
     */
    @ConfigItem(defaultValue = "false")
    public Boolean tlsEnabled;

    /**
     * The path to the file that holds certificates from Certified Authorities.
     */
    @ConfigItem
    public Optional<String> tlsCaCertPath;

    /**
     * The path to the TLS certificate.
     */
    @ConfigItem
    public Optional<String> tlsCertPath;

    /**
     * The path to the TLS certificate.
     */
    @ConfigItem
    public Optional<String> tlsKeyPath;

    /**
     * The TLS key file passphrase.
     */
    @ConfigItem
    public Optional<String> tlsKeyPassphrase;

    /**
     * The TLS key file passphrase.
     */
    @ConfigItem
    public Optional<String> tlsKeyAlgo;

    /**
     * The token to use to connect.
     */
    @ConfigItem
    public String token;

    /**
     * Time in mills to wait without read activity before sending the keep alive
     * ping.
     */
    @ConfigItem
    public OptionalInt keepAliveTime;

    /**
     * Time in mills to wait without read activity after sending the keep alive
     * ping.
     */
    @ConfigItem
    public OptionalInt keepAliveTimeout;

    /**
     * Time in mills to wait before going to idle mode.
     */
    @ConfigItem
    public OptionalInt idleTimeout;

}
