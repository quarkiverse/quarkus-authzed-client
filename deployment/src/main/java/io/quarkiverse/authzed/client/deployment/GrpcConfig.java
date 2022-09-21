package io.quarkiverse.authzed.client.deployment;

import java.util.Optional;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class GrpcConfig {

    /**
     * Flag to enable grpc (defaults to true)
     */
    @ConfigItem(defaultValue = "true")
    public Boolean enabled;

    /**
     * The container port the grpc will be bound to.
     */
    @ConfigItem(defaultValue = "50051")
    public Integer port;

    /**
     * Optional host port the grpc will be bound to.
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
     * The path to the TLS certificate.
     */
    @ConfigItem
    public Optional<String> tlsCertKey;

    /**
     * The preshared key used to initalize the server.
     * Corresponds to the value passed to the `--grpc-preshared-key` argument of the serve command.
     */
    @ConfigItem(defaultValue = "test")
    public String presharedKey;

}
