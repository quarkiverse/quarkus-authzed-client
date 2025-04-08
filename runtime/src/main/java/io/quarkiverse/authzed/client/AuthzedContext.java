package io.quarkiverse.authzed.client;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jboss.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.*;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkiverse.authzed.utils.BearerToken;
import io.quarkus.grpc.runtime.supports.IOThreadClientInterceptor;
import io.quarkus.tls.TlsConfiguration;
import io.quarkus.tls.TlsConfigurationRegistry;

public class AuthzedContext implements AutoCloseable {

    private final ManagedChannel channel;

    private final BearerToken bearerToken;

    public AuthzedContext(ManagedChannel channel, BearerToken bearerToken) {
        this.channel = channel;
        this.bearerToken = bearerToken;
    }

    public static AuthzedContext create(AuthzedConfig config, TlsConfigurationRegistry tlsRegistry) {
        return new AuthzedContext(createChannel(config, tlsRegistry), createToken(config));
    }

    public static AuthzedContext create(URL url, String presharedKey) {
        Logger.getLogger(AuthzedContext.class).infof("Creating channel for Authzed with static url: %s", url);

        NettyChannelBuilder builder = NettyChannelBuilder.forAddress(url.getHost(), url.getPort())
                .intercept(new IOThreadClientInterceptor());
        try {
            if (url.getProtocol().equals("https")) {
                Logger.getLogger(AuthzedContext.class).infof("Using TLS configuration");
                builder.useTransportSecurity()
                        .sslContext(GrpcSslContexts.forClient()
                                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                                .build());
            } else {
                Logger.getLogger(AuthzedContext.class).infof("Using plaintext configuration");
                builder.usePlaintext();
            }

            return new AuthzedContext(builder.build(), presharedKey != null ? new BearerToken(presharedKey) : null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static ManagedChannel createChannel(AuthzedConfig config, TlsConfigurationRegistry tlsRegistry) {
        NettyChannelBuilder builder = NettyChannelBuilder.forAddress(config.url().getHost(), config.url().getPort())
                .intercept(new IOThreadClientInterceptor());

        if (config.url().getProtocol().equals("https")) {
            TlsConfiguration.from(tlsRegistry, config.tlsConfigurationName())
                    .or(tlsRegistry::getDefault)
                    .ifPresentOrElse(tlsConfig -> {
                        try {
                            builder.sslContext(createSslContext(tlsConfig));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }, () -> {
                        throw new RuntimeException("No TLS configuration found");
                    });
        } else {
            builder.usePlaintext();
        }

        if (config.keepAliveTime().isPresent()) {
            builder.keepAliveTime(config.keepAliveTime().getAsInt(), TimeUnit.MILLISECONDS);
        }

        if (config.keepAliveTimeout().isPresent()) {
            builder.keepAliveTimeout(config.keepAliveTimeout().getAsInt(), TimeUnit.MILLISECONDS);
        }

        if (config.idleTimeout().isPresent()) {
            builder.idleTimeout(config.idleTimeout().getAsInt(), TimeUnit.MILLISECONDS);
        }

        if (config.retry()) {
            builder.enableRetry()
                    .maxHedgedAttempts(config.maxHedgedAttempts())
                    .maxRetryAttempts(config.maxRetryAttempts());
        } else {
            builder.disableRetry();
        }

        return builder.build();
    }

    private static SslContext createSslContext(TlsConfiguration tlsConfig) throws Exception {

        var base = GrpcSslContexts.forClient().build();
        var sslOptions = tlsConfig.getSSLOptions();

        var cipherSuiteFilter = new CipherSuiteFilter() {
            @Override
            public String[] filterCipherSuites(Iterable<String> ciphers, List<String> defaultCiphers,
                    Set<String> supportedCiphers) {// Join default ciphers with supported ciphers, prioritizing supported ciphers
                var allCiphers = new ArrayList<>(supportedCiphers);
                for (var cipher : ciphers) {
                    if (cipher == null) {
                        continue;
                    }
                    if (supportedCiphers.contains(cipher)) {
                        allCiphers.add(cipher);
                    }
                }
                allCiphers.addAll(defaultCiphers);
                return allCiphers.toArray(new String[] {});
            }
        };

        return new JdkSslContext(tlsConfig.createSSLContext(), base.isClient(),
                sslOptions.getEnabledCipherSuites().isEmpty() ? base.cipherSuites() : sslOptions.getEnabledCipherSuites(),
                cipherSuiteFilter, new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.ALPN,
                        ApplicationProtocolConfig.SelectorFailureBehavior.FATAL_ALERT,
                        ApplicationProtocolConfig.SelectedListenerFailureBehavior.FATAL_ALERT,
                        ApplicationProtocolNames.HTTP_2),
                tlsConfig.getKeyStore() != null ? ClientAuth.REQUIRE : ClientAuth.NONE,
                sslOptions.getEnabledSecureTransportProtocols().isEmpty()
                        ? base.applicationProtocolNegotiator().protocols().toArray(new String[] {})
                        : sslOptions.getEnabledSecureTransportProtocols().toArray(new String[] {}),
                true);
    }

    private static BearerToken createToken(AuthzedConfig config) {
        return new BearerToken(config.token());
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
