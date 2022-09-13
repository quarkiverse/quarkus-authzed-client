package io.quarkiverse.authzed.client.blocking;

import io.quarkiverse.authzed.client.AuthzedContext;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;

public class BlockingAuthzedClient implements AutoCloseable {

    private final AuthzedContext context;

    public BlockingAuthzedClient(AuthzedConfig config) {
        this(AuthzedContext.create(config));
    }

    public BlockingAuthzedClient(AuthzedContext context) {
        this.context = context;
    }

    public AuthzedClientV0 v0() {
        return new AuthzedClientV0(context);
    }

    public AuthzedClientV1 v1() {
        return new AuthzedClientV1(context);
    }

    public AuthzedClientV1Alpha1 v1alpha1() {
        return new AuthzedClientV1Alpha1(context);
    }

    @Override
    public void close() throws Exception {
        context.close();
    }
}
