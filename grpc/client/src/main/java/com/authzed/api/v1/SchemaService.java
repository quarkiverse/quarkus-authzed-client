package com.authzed.api.v1;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/schema_service.proto")
public interface SchemaService extends MutinyService {

    /**
     * <pre>
     *  Read returns the current Object Definitions for a Permissions System.
     *
     *  Errors include:
     *  - INVALID_ARGUMENT: a provided value has failed to semantically validate
     *  - NOT_FOUND: no schema has been defined
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ReadSchemaResponse> readSchema(com.authzed.api.v1.ReadSchemaRequest request);

    /**
     * <pre>
     *  Write overwrites the current Object Definitions for a Permissions System.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.WriteSchemaResponse> writeSchema(com.authzed.api.v1.WriteSchemaRequest request);

    /**
     * <pre>
     *  ReflectSchema reflects the current schema stored in SpiceDB, returning a structural
     *  form of the schema for use by client tooling.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ReflectSchemaResponse> reflectSchema(
            com.authzed.api.v1.ReflectSchemaRequest request);

    /**
     * <pre>
     *  ComputablePermissions returns the set of permissions that compute based off a relation
     *  in the current schema. For example, if the schema has a relation `viewer` and a permission
     *  `view` defined as `permission view = viewer + editor`, then the
     *  computable permissions for the relation `viewer` will include `view`.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.ComputablePermissionsResponse> computablePermissions(
            com.authzed.api.v1.ComputablePermissionsRequest request);

    /**
     * <pre>
     *  DependentRelations returns the set of relations and permissions that used
     *  to compute a permission, recursively, in the current schema. It is the
     *  inverse of the ComputablePermissions API.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.DependentRelationsResponse> dependentRelations(
            com.authzed.api.v1.DependentRelationsRequest request);

    /**
     * <pre>
     *  DiffSchema returns the difference between the specified schema and the current
     *  schema stored in SpiceDB.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.DiffSchemaResponse> diffSchema(com.authzed.api.v1.DiffSchemaRequest request);
}
