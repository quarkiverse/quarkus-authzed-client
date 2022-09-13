package io.quarkiverse.authzed.client.reactive;

import com.authzed.api.v0.MutinyDeveloperServiceGrpc;

import io.quarkiverse.authzed.client.AuthzedContext;
import io.quarkiverse.authzed.client.WithContext;

public class AuthzedClientV0 extends WithContext {

    public AuthzedClientV0(AuthzedContext context) {
        super(context);
    }

    public MutinyDeveloperServiceGrpc.MutinyDeveloperServiceStub developerService() {
        return MutinyDeveloperServiceGrpc.newMutinyStub(getContext().getChannel());
    }

}
