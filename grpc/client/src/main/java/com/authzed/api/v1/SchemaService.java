package com.authzed.api.v1;

import io.quarkus.grpc.MutinyService;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/schema_service.proto")
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
    io.smallrye.mutiny.Uni<com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaResponse> readSchema(
            com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaRequest request);

    /**
     * <pre>
     *  Write overwrites the current Object Definitions for a Permissions System.
     * </pre>
     */
    io.smallrye.mutiny.Uni<com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaResponse> writeSchema(
            com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaRequest request);
}
