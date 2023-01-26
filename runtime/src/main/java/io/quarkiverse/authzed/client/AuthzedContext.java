package io.quarkiverse.authzed.client;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.quarkiverse.authzed.BearerToken;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.grpc.runtime.supports.IOThreadClientInterceptor;
import io.smallrye.mutiny.infrastructure.Infrastructure;

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
        NettyChannelBuilder builder = NettyChannelBuilder.forAddress(config.url.getHost(), config.url.getPort())
                .directExecutor().offloadExecutor(Infrastructure.getDefaultExecutor())
                .intercept(new IOThreadClientInterceptor());

        if (config.tlsEnabled) {
            builder = builder.useTransportSecurity().sslContext(createSslContext(config));
        } else {
            builder = builder.usePlaintext();
        }

        if (config.keepAliveTime.isPresent()) {
            builder = builder.keepAliveTime(config.keepAliveTime.getAsInt(), TimeUnit.MILLISECONDS);
        }

        if (config.keepAliveTimeout.isPresent()) {
            builder = builder.keepAliveTimeout(config.keepAliveTimeout.getAsInt(), TimeUnit.MILLISECONDS);
        }

        if (config.idleTimeout.isPresent()) {
            builder = builder.idleTimeout(config.idleTimeout.getAsInt(), TimeUnit.MILLISECONDS);
        }
        return builder.build();
    }

    private static SslContext createSslContext(AuthzedConfig config) {
        SslContextBuilder builder = GrpcSslContexts.forClient();
        if (config.tlsCaCertPath.isPresent()) {
            builder = builder.trustManager(new File(config.tlsCaCertPath.get()));
        }

        if (config.tlsCertPath.isPresent() && config.tlsKeyPath.isPresent()) {
            if (config.tlsKeyPassphrase.isPresent()) {
                builder = builder.keyManager(new File(config.tlsCertPath.get()), new File(config.tlsKeyPath.get()),
                        config.tlsKeyPassphrase.get());
            } else {
                builder = builder.keyManager(new File(config.tlsCertPath.get()), new File(config.tlsKeyPath.get()));
            }
        }

        try {
            return builder.build();
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
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
