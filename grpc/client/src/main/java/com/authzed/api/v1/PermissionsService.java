package com.authzed.api.v1;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/permission_service.proto")
public interface PermissionsService extends MutinyService {

    /**
     * <pre>
     *  WriteRelationships atomically writes and/or deletes a set of specified
     *  relationships. An optional set of preconditions can be provided that must
     *  be satisfied for the operation to commit.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.WriteRelationshipsResponse> writeRelationships(
            com.authzed.api.v1.WriteRelationshipsRequest request);

    /**
     * <pre>
     *  DeleteRelationships atomically bulk deletes all relationships matching the
     *  provided filter. If no relationships match, none will be deleted and the
     *  operation will succeed. An optional set of preconditions can be provided that must
     *  be satisfied for the operation to commit.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.DeleteRelationshipsResponse> deleteRelationships(
            com.authzed.api.v1.DeleteRelationshipsRequest request);

    /**
     * <pre>
     *  CheckPermission determines for a given resource whether a subject computes
     *  to having a permission or is a direct member of a particular relation.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.CheckPermissionResponse> checkPermission(
            com.authzed.api.v1.CheckPermissionRequest request);

    /**
     * <pre>
     *  CheckBulkPermissions evaluates the given list of permission checks
     *  and returns the list of results.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.CheckBulkPermissionsResponse> checkBulkPermissions(
            com.authzed.api.v1.CheckBulkPermissionsRequest request);

    /**
     * <pre>
     *  ExpandPermissionTree reveals the graph structure for a resource&#39;s
     *  permission or relation. This RPC does not recurse infinitely deep and may
     *  require multiple calls to fully unnest a deeply nested graph.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExpandPermissionTreeResponse> expandPermissionTree(
            com.authzed.api.v1.ExpandPermissionTreeRequest request);

    /**
     * <pre>
     *  ReadRelationships reads a set of the relationships matching one or more
     *  filters.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.ReadRelationshipsResponse> readRelationships(
            com.authzed.api.v1.ReadRelationshipsRequest request);

    /**
     * <pre>
     *  LookupResources returns all the resources of a given type that a subject
     *  can access whether via a computed permission or relation membership.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.LookupResourcesResponse> lookupResources(
            com.authzed.api.v1.LookupResourcesRequest request);

    /**
     * <pre>
     *  LookupSubjects returns all the subjects of a given type that
     *  have access whether via a computed permission or relation membership.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.LookupSubjectsResponse> lookupSubjects(
            com.authzed.api.v1.LookupSubjectsRequest request);

    /**
     * <pre>
     *  ExportBulkRelationships is the fastest path available to exporting
     *  relationships from the server. It is resumable, and will return results
     *  in an order determined by the server.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.ExportBulkRelationshipsResponse> exportBulkRelationships(
            com.authzed.api.v1.ExportBulkRelationshipsRequest request);

    /**
     * <pre>
     *  ImportBulkRelationships is a faster path to writing a large number of
     *  relationships at once. It is both batched and streaming. For maximum
     *  performance, the caller should attempt to write relationships in as close
     *  to relationship sort order as possible: (resource.object_type,
     *  resource.object_id, relation, subject.object.object_type,
     *  subject.object.object_id, subject.optional_relation). All relationships
     *  written are done so under a single transaction.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ImportBulkRelationshipsResponse> importBulkRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.ImportBulkRelationshipsRequest> request);
}
