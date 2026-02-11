package com.authzed.api.materialize.v0;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/materialize/v0/watchpermissions.proto")
public class WatchPermissionsServiceBean extends MutinyWatchPermissionsServiceGrpc.WatchPermissionsServiceImplBase
        implements BindableService, MutinyBean {

    private final WatchPermissionsService delegate;

    WatchPermissionsServiceBean(@GrpcService WatchPermissionsService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionsResponse> watchPermissions(
            com.authzed.api.materialize.v0.WatchPermissionsRequest request) {
        try {
            return delegate.watchPermissions(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
