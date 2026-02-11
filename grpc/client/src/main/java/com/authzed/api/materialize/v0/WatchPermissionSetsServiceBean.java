package com.authzed.api.materialize.v0;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/materialize/v0/watchpermissionsets.proto")
public class WatchPermissionSetsServiceBean extends MutinyWatchPermissionSetsServiceGrpc.WatchPermissionSetsServiceImplBase
        implements BindableService, MutinyBean {

    private final WatchPermissionSetsService delegate;

    WatchPermissionSetsServiceBean(@GrpcService WatchPermissionSetsService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.materialize.v0.DownloadPermissionSetsResponse> downloadPermissionSets(
            com.authzed.api.materialize.v0.DownloadPermissionSetsRequest request) {
        try {
            return delegate.downloadPermissionSets(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionSetsResponse> watchPermissionSets(
            com.authzed.api.materialize.v0.WatchPermissionSetsRequest request) {
        try {
            return delegate.watchPermissionSets(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.LookupPermissionSetsResponse> lookupPermissionSets(
            com.authzed.api.materialize.v0.LookupPermissionSetsRequest request) {
        try {
            return delegate.lookupPermissionSets(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
