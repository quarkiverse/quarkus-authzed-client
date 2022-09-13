package io.quarkiverse.authzed.client;

import com.authzed.api.v0.DeveloperServiceGrpc;

public class AuthzedClientV0 extends WithContext {

    public AuthzedClientV0(AuthzedContext context) {
        super(context);
    }

    public DeveloperServiceGrpc.DeveloperServiceBlockingStub developerService() {
        return DeveloperServiceGrpc.newBlockingStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }

}
