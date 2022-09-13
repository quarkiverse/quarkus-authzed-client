package io.quarkiverse.authzed.client;

public class WithContext {

    private final AuthzedContext context;

    public WithContext(AuthzedContext context) {
        this.context = context;
    }

    public AuthzedContext getContext() {
        return context;
    }
}
