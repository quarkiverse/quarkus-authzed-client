package com.authzed.api.v1;

import io.quarkus.grpc.MutinyService;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/watch_service.proto")
public interface WatchService extends MutinyService {

    io.smallrye.mutiny.Multi<com.authzed.api.v1.WatchServiceOuterClass.WatchResponse> watch(
            com.authzed.api.v1.WatchServiceOuterClass.WatchRequest request);
}
