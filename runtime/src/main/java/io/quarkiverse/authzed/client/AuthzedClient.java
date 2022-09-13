package io.quarkiverse.authzed.client;

import io.quarkiverse.authzed.runtime.config.AuthzedConfig;

public class AuthzedClient implements AutoCloseable {

    private final AuthzedContext context;

    public AuthzedClient(AuthzedConfig config) {
        this.context = AuthzedContext.create(config);
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
