package com.authzed.api.v1;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/watch_service.proto")
public interface WatchService extends MutinyService {

    /**
     * <pre>
     *  Watch returns a stream of events that occurred in the datastore in ascending timestamp order.
     *  The events can be relationship updates, schema updates, or checkpoints.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.WatchResponse> watch(com.authzed.api.v1.WatchRequest request);
}
