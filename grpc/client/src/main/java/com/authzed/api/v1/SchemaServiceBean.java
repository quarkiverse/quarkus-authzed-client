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
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ReadSchemaResponse> readSchema(
            com.authzed.api.v1.ReadSchemaRequest request) {
        try {
            return delegate.readSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.WriteSchemaResponse> writeSchema(
            com.authzed.api.v1.WriteSchemaRequest request) {
        try {
            return delegate.writeSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ReflectSchemaResponse> reflectSchema(
            com.authzed.api.v1.ReflectSchemaRequest request) {
        try {
            return delegate.reflectSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ComputablePermissionsResponse> computablePermissions(
            com.authzed.api.v1.ComputablePermissionsRequest request) {
        try {
            return delegate.computablePermissions(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.DependentRelationsResponse> dependentRelations(
            com.authzed.api.v1.DependentRelationsRequest request) {
        try {
            return delegate.dependentRelations(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.DiffSchemaResponse> diffSchema(
            com.authzed.api.v1.DiffSchemaRequest request) {
        try {
            return delegate.diffSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
