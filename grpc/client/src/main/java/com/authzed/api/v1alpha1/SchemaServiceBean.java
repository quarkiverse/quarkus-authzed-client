package com.authzed.api.v1alpha1;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1alpha1/schema.proto")
public class SchemaServiceBean extends MutinySchemaServiceGrpc.SchemaServiceImplBase implements BindableService, MutinyBean {

    private final SchemaService delegate;

    SchemaServiceBean(@GrpcService SchemaService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1alpha1.Schema.ReadSchemaResponse> readSchema(
            com.authzed.api.v1alpha1.Schema.ReadSchemaRequest request) {
        try {
            return delegate.readSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1alpha1.Schema.WriteSchemaResponse> writeSchema(
            com.authzed.api.v1alpha1.Schema.WriteSchemaRequest request) {
        try {
            return delegate.writeSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
