package io.quarkiverse.authzed;

import java.net.URL;
import java.util.Optional;
import java.util.OptionalInt;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;

public class AuthzedClientCreator {

    public static AuthzedClient create() {
        Config config = ConfigProvider.getConfig();
        AuthzedConfig authzedConfig = new AuthzedConfig();

        Optional<URL> url = config.getOptionalValue("quarkus.authzed.url", URL.class);
        Optional<String> token = config.getOptionalValue("quarkus.authzed.token", String.class);

        authzedConfig.url = url.orElseThrow(() -> new IllegalStateException("Please provide QUARKUS_AUTHZED_URL"));
        authzedConfig.token = token.orElseThrow(() -> new IllegalStateException("Please provide QUARKUS_AUTHZED_TOKEN"));
        authzedConfig.tlsCertPath = config.getOptionalValue("quarkus.authzed.tls-cert-path", String.class);
        authzedConfig.tlsCaCertPath = config.getOptionalValue("quarkus.authzed.tls-ca-cert-path", String.class);
        authzedConfig.tlsKeyPath = config.getOptionalValue("quarkus.authzed.tls-key-path", String.class);
        authzedConfig.tlsKeyPassphrase = config.getOptionalValue("quarkus.authzed.tls-key-passphrase", String.class);
        authzedConfig.tlsKeyAlgo = config.getOptionalValue("quarkus.authzed.tls-key-algo", String.class);
        config.getOptionalValue("quarkus.authzed.tls-enabled", Boolean.class).ifPresent(e -> authzedConfig.tlsEnabled = e);

        authzedConfig.keepAliveTime = OptionalInt.empty();
        authzedConfig.keepAliveTimeout = OptionalInt.empty();
        authzedConfig.idleTimeout = OptionalInt.empty();

        return new AuthzedClient(authzedConfig);
    }
}
