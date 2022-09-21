package com.authzed.api.v1alpha1;

import io.quarkus.grpc.MutinyService;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1alpha1/schema.proto")
public interface SchemaService extends MutinyService {

    /**
     * <pre>
     *  Read returns the current Object Definitions for a Permissions System.
     *
     *  Errors include:
     *  - INVALID_ARGUMENT: a provided value has failed to semantically validate
     *  - NOT_FOUND: one of the Object Definitions being requested does not exist
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1alpha1.Schema.ReadSchemaResponse> readSchema(
            com.authzed.api.v1alpha1.Schema.ReadSchemaRequest request);

    /**
     * <pre>
     *  Write overwrites the current Object Definitions for a Permissions System.
     *
     *  Any Object Definitions that exist, but are not included will be deleted.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1alpha1.Schema.WriteSchemaResponse> writeSchema(
            com.authzed.api.v1alpha1.Schema.WriteSchemaRequest request);
}
