package io.quarkiverse.authzed.client.deployment;

import java.util.Optional;
import java.util.OptionalInt;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.smallrye.config.WithDefault;

@ConfigGroup
public interface GrpcConfig {

    /**
     * Flag to enable grpc (defaults to true)
     */
    @WithDefault("true")
    Boolean enabled();

    /**
     * The container port the grpc will be bound to.
     */
    @WithDefault("50051")
    Integer port();

    /**
     * Optional host port the grpc will be bound to.
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
     * The preshared key used to initalize the server.
     * Corresponds to the value passed to the `--grpc-preshared-key` argument of the serve command.
     */
    @WithDefault("test")
    String presharedKey();

    /**
     * URL of the devservices GRPC endpoint.
     * <p>
     * Note: This is only used to report the URL to the user.
     */
    Optional<String> url();

}
