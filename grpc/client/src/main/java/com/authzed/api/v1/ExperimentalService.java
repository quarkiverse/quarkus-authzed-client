package com.authzed.api.v1;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/experimental_service.proto")
public interface ExperimentalService extends MutinyService {

    /**
     * <pre>
     *  DEPRECATED: Promoted to CheckBulkPermission in the stable API.
     * </pre>
     */
    @Deprecated
    io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkCheckPermissionResponse> bulkCheckPermission(
            com.authzed.api.v1.BulkCheckPermissionRequest request);

    /**
     * <pre>
     *  DEPRECATED: Promoted to ReflectSchema in the stable API.
     * </pre>
     */
    @Deprecated
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalReflectSchemaResponse> experimentalReflectSchema(
            com.authzed.api.v1.ExperimentalReflectSchemaRequest request);

    /**
     * <pre>
     *  DEPRECATED: Promoted to ComputablePermissions in the stable API.
     * </pre>
     */
    @Deprecated
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalComputablePermissionsResponse> experimentalComputablePermissions(
            com.authzed.api.v1.ExperimentalComputablePermissionsRequest request);

    /**
     * <pre>
     *  DEPRECATED: Promoted to DependentRelations in the stable API.
     * </pre>
     */
    @Deprecated
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDependentRelationsResponse> experimentalDependentRelations(
            com.authzed.api.v1.ExperimentalDependentRelationsRequest request);

    /**
     * <pre>
     *  DEPRECATED: Promoted to DiffSchema in the stable API.
     * </pre>
     */
    @Deprecated
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDiffSchemaResponse> experimentalDiffSchema(
            com.authzed.api.v1.ExperimentalDiffSchemaRequest request);

    /**
     * <pre>
     *  EXPERIMENTAL: RegisterRelationshipCounter registers a new filter for counting relationships. A filter must be registered before
     *  a count can be requested.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> experimentalRegisterRelationshipCounter(
            com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request);

    /**
     * <pre>
     *  EXPERIMENTAL: CountRelationships returns the count of relationships for &#42;pre-registered&#42; filter.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalCountRelationshipsResponse> experimentalCountRelationships(
            com.authzed.api.v1.ExperimentalCountRelationshipsRequest request);

    /**
     * <pre>
     *  EXPERIMENTAL: UnregisterRelationshipCounter unregisters an existing filter for counting relationships.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> experimentalUnregisterRelationshipCounter(
            com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request);

    /**
     * <pre>
     *  DEPRECATED: Promoted to ExportBulkRelationships in the stable API.
     * </pre>
     */
    @Deprecated
    io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkExportRelationshipsResponse> bulkExportRelationships(
            com.authzed.api.v1.BulkExportRelationshipsRequest request);

    /**
     * <pre>
     *  DEPRECATED: Promoted to ImportBulkRelationships in the stable API.
     * </pre>
     */
    @Deprecated
    io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkImportRelationshipsResponse> bulkImportRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkImportRelationshipsRequest> request);
}
