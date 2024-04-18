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
    io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.WriteRelationshipsResponse> writeRelationships(
            com.authzed.api.v1.PermissionService.WriteRelationshipsRequest request);

    /**
     * <pre>
     *  DeleteRelationships atomically bulk deletes all relationships matching the
     *  provided filter. If no relationships match, none will be deleted and the
     *  operation will succeed. An optional set of preconditions can be provided that must
     *  be satisfied for the operation to commit.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.DeleteRelationshipsResponse> deleteRelationships(
            com.authzed.api.v1.PermissionService.DeleteRelationshipsRequest request);

    /**
     * <pre>
     *  CheckPermission determines for a given resource whether a subject computes
     *  to having a permission or is a direct member of a particular relation.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.CheckPermissionResponse> checkPermission(
            com.authzed.api.v1.PermissionService.CheckPermissionRequest request);

    /**
     * <pre>
     *  ExpandPermissionTree reveals the graph structure for a resource&#39;s
     *  permission or relation. This RPC does not recurse infinitely deep and may
     *  require multiple calls to fully unnest a deeply nested graph.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.ExpandPermissionTreeResponse> expandPermissionTree(
            com.authzed.api.v1.PermissionService.ExpandPermissionTreeRequest request);

    /**
     * <pre>
     *  ReadRelationships reads a set of the relationships matching one or more
     *  filters.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.ReadRelationshipsResponse> readRelationships(
            com.authzed.api.v1.PermissionService.ReadRelationshipsRequest request);

    /**
     * <pre>
     *  LookupResources returns all the resources of a given type that a subject
     *  can access whether via a computed permission or relation membership.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupResourcesResponse> lookupResources(
            com.authzed.api.v1.PermissionService.LookupResourcesRequest request);

    /**
     * <pre>
     *  LookupSubjects returns all the subjects of a given type that
     *  have access whether via a computed permission or relation membership.
     * </pre>
     */
    io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupSubjectsResponse> lookupSubjects(
            com.authzed.api.v1.PermissionService.LookupSubjectsRequest request);
}
