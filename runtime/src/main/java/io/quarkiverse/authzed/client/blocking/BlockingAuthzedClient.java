package io.quarkiverse.authzed.client.blocking;

import io.quarkiverse.authzed.client.AuthzedContext;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.tls.TlsConfigurationRegistry;

public class BlockingAuthzedClient implements AutoCloseable {

    private final AuthzedContext context;

    public BlockingAuthzedClient(AuthzedConfig config, TlsConfigurationRegistry tlsRegistry) {
        this(AuthzedContext.create(config, tlsRegistry));
    }

    public BlockingAuthzedClient(AuthzedContext context) {
        this.context = context;
    }

    public AuthzedClientV1 v1() {
        return new AuthzedClientV1(context);
    }

    @Override
    public void close() throws Exception {
        context.close();
    }
}
