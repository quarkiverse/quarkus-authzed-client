package com.authzed.api.v1;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/schema_service.proto")
public class SchemaServiceBean extends MutinySchemaServiceGrpc.SchemaServiceImplBase implements BindableService, MutinyBean {

    private final SchemaService delegate;

    SchemaServiceBean(@GrpcService SchemaService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaResponse> readSchema(
            com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaRequest request) {
        try {
            return delegate.readSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaResponse> writeSchema(
            com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaRequest request) {
        try {
            return delegate.writeSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
