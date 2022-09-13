package io.quarkiverse.authzed.client.blocking;

import com.authzed.api.v0.DeveloperServiceGrpc;

import io.quarkiverse.authzed.client.AuthzedContext;
import io.quarkiverse.authzed.client.WithContext;

public class AuthzedClientV0 extends WithContext {

    public AuthzedClientV0(AuthzedContext context) {
        super(context);
    }

    public DeveloperServiceGrpc.DeveloperServiceBlockingStub developerService() {
        return DeveloperServiceGrpc.newBlockingStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }

}
