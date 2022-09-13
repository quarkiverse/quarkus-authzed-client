package io.quarkiverse.authzed.client.reactive;

import com.authzed.api.v1.*;

import io.quarkiverse.authzed.client.AuthzedContext;
import io.quarkiverse.authzed.client.WithContext;

public class AuthzedClientV1 extends WithContext {

    public AuthzedClientV1(AuthzedContext context) {
        super(context);
    }

    public MutinyPermissionsServiceGrpc.MutinyPermissionsServiceStub permissionService() {
        return MutinyPermissionsServiceGrpc.newMutinyStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }

    public MutinySchemaServiceGrpc.MutinySchemaServiceStub schemaService() {
        return MutinySchemaServiceGrpc.newMutinyStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }

    public MutinyWatchServiceGrpc.MutinyWatchServiceStub watchService() {
        return MutinyWatchServiceGrpc.newMutinyStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }
}
