package io.quarkiverse.authzed.client.reactive;

import com.authzed.api.v1alpha1.MutinySchemaServiceGrpc;
import com.authzed.api.v1alpha1.MutinyWatchResourcesServiceGrpc;

import io.quarkiverse.authzed.client.AuthzedContext;
import io.quarkiverse.authzed.client.WithContext;

public class AuthzedClientV1Alpha1 extends WithContext {

    public AuthzedClientV1Alpha1(AuthzedContext context) {
        super(context);
    }

    public MutinySchemaServiceGrpc.MutinySchemaServiceStub schemaService() {
        return MutinySchemaServiceGrpc.newMutinyStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }

    public MutinyWatchResourcesServiceGrpc.MutinyWatchResourcesServiceStub watchService() {
        return MutinyWatchResourcesServiceGrpc.newMutinyStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }

}
