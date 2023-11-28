package com.authzed.api.v1alpha1;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1alpha1/watchresources_service.proto")
public class WatchResourcesServiceBean extends MutinyWatchResourcesServiceGrpc.WatchResourcesServiceImplBase
        implements BindableService, MutinyBean {

    private final WatchResourcesService delegate;

    WatchResourcesServiceBean(@GrpcService WatchResourcesService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesResponse> watchResources(
            com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesRequest request) {
        try {
            return delegate.watchResources(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
