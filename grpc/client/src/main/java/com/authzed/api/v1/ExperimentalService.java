package com.authzed.api.v1;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/experimental_service.proto")
public interface ExperimentalService extends MutinyService {

    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> bulkCheckPermission(
            com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request);

    /**
     * <pre>
     *  BulkExportRelationships is the fastest path available to exporting
     *  relationships from the server. It is resumable, and will return results
     *  in an order determined by the server.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> bulkExportRelationships(
            com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest request);

    /**
     * <pre>
     *  BulkImportRelationships is a faster path to writing a large number of
     *  relationships at once. It is both batched and streaming. For maximum
     *  performance, the caller should attempt to write relationships in as close
     *  to relationship sort order as possible: (resource.object_type,
     *  resource.object_id, relation, subject.object.object_type,
     *  subject.object.object_id, subject.optional_relation)
     *
     *  EXPERIMENTAL
     *  https://github.com/authzed/spicedb/issues/1303
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> bulkImportRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest> request);
}
