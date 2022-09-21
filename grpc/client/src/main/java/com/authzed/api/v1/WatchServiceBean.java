package com.authzed.api.v1;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/watch_service.proto")
public class WatchServiceBean extends MutinyWatchServiceGrpc.WatchServiceImplBase implements BindableService, MutinyBean {

    private final WatchService delegate;

    WatchServiceBean(@GrpcService WatchService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.WatchServiceOuterClass.WatchResponse> watch(
            com.authzed.api.v1.WatchServiceOuterClass.WatchRequest request) {
        try {
            return delegate.watch(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
