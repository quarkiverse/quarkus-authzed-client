package io.quarkiverse.authzed.client.blocking;

import com.authzed.api.v1alpha1.SchemaServiceGrpc;
import com.authzed.api.v1alpha1.WatchResourcesServiceGrpc;

import io.quarkiverse.authzed.client.AuthzedContext;
import io.quarkiverse.authzed.client.WithContext;

public class AuthzedClientV1Alpha1 extends WithContext {

    public AuthzedClientV1Alpha1(AuthzedContext context) {
        super(context);
    }

    public SchemaServiceGrpc.SchemaServiceBlockingStub schemaService() {
        return SchemaServiceGrpc.newBlockingStub(getContext().getChannel()).withCallCredentials(getContext().getBearerToken());
    }

    public WatchResourcesServiceGrpc.WatchResourcesServiceBlockingStub watchService() {
        return WatchResourcesServiceGrpc.newBlockingStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }

}
