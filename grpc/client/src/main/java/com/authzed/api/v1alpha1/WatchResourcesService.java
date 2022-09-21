package com.authzed.api.v1alpha1;

import io.quarkus.grpc.MutinyService;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1alpha1/watchresources_service.proto")
public interface WatchResourcesService extends MutinyService {

    /**
     * <pre>
     *  WatchResources initiates a watch for permission changes for the provided
     *  (resource type, permission, subject) pair.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesResponse> watchResources(
            com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesRequest request);
}
