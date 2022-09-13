package io.quarkiverse.authzed.client;

import com.authzed.grpcutil.BearerToken;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;

public class AuthzedContext implements AutoCloseable {

    private final AuthzedConfig config;

    private final ManagedChannel channel;

    private final BearerToken bearerToken;

    public AuthzedContext(AuthzedConfig config, ManagedChannel channel, BearerToken bearerToken) {
        this.config = config;
        this.channel = channel;
        this.bearerToken = bearerToken;
    }

    public static AuthzedContext create(AuthzedConfig config) {
        return new AuthzedContext(config, createChannel(config), createToken(config));
    }

    private static ManagedChannel createChannel(AuthzedConfig config) {
        return ManagedChannelBuilder
                .forAddress(config.url.getHost(), config.url.getPort())
                .usePlaintext()
                .build();
    }

    private static BearerToken createToken(AuthzedConfig config) {
        return new BearerToken(config.token);
    }

    public AuthzedConfig getConfig() {
        return config;
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    public BearerToken getBearerToken() {
        return bearerToken;
    }

    @Override
    public void close() throws Exception {
        channel.shutdown();
    }
}
