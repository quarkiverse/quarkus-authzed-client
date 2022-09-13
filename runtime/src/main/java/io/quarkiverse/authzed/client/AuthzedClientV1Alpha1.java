package io.quarkiverse.authzed.client;

import com.authzed.api.v1alpha1.SchemaServiceGrpc;
import com.authzed.api.v1alpha1.WatchResourcesServiceGrpc;

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
