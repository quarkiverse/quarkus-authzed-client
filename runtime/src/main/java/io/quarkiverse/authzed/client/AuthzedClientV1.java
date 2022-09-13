package io.quarkiverse.authzed.client;

import com.authzed.api.v1.PermissionsServiceGrpc;
import com.authzed.api.v1.SchemaServiceGrpc;
import com.authzed.api.v1.WatchServiceGrpc;

public class AuthzedClientV1 extends WithContext {

    public AuthzedClientV1(AuthzedContext context) {
        super(context);
    }

    public PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionService() {
        return PermissionsServiceGrpc.newBlockingStub(getContext().getChannel())
                .withCallCredentials(getContext().getBearerToken());
    }

    public SchemaServiceGrpc.SchemaServiceBlockingStub schemaService() {
        return SchemaServiceGrpc.newBlockingStub(getContext().getChannel()).withCallCredentials(getContext().getBearerToken());
    }

    public WatchServiceGrpc.WatchServiceBlockingStub watchService() {
        return WatchServiceGrpc.newBlockingStub(getContext().getChannel()).withCallCredentials(getContext().getBearerToken());
    }
}
