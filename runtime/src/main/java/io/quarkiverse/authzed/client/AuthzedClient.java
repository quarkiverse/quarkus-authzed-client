package io.quarkiverse.authzed.client;

import java.net.URL;

import io.quarkiverse.authzed.client.blocking.BlockingAuthzedClient;
import io.quarkiverse.authzed.client.reactive.AuthzedClientV1;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.tls.TlsConfigurationRegistry;

public class AuthzedClient implements AutoCloseable {

    private final AuthzedContext context;

    public AuthzedClient(AuthzedContext context) {
        this.context = context;
    }

    public AuthzedClient(AuthzedConfig config, TlsConfigurationRegistry tlsRegistry) {
        this(AuthzedContext.create(config, tlsRegistry));
    }

    public AuthzedClient(URL url, String presharedKey) {
        this(AuthzedContext.create(url, presharedKey));
    }

    public AuthzedClientV1 v1() {
        return new AuthzedClientV1(context);
    }

    public AuthzedContext getContext() {
        return context;
    }

    @Override
    public void close() throws Exception {
        context.close();
    }

    public BlockingAuthzedClient blocking() {
        return new BlockingAuthzedClient(context);
    }
}
