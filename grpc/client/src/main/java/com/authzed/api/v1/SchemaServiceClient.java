package com.authzed.api.v1;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/schema_service.proto")
public class SchemaServiceClient implements SchemaService, MutinyClient<MutinySchemaServiceGrpc.MutinySchemaServiceStub> {

    private final MutinySchemaServiceGrpc.MutinySchemaServiceStub stub;

    public SchemaServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinySchemaServiceGrpc.MutinySchemaServiceStub, MutinySchemaServiceGrpc.MutinySchemaServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinySchemaServiceGrpc.newMutinyStub(channel));
    }

    private SchemaServiceClient(MutinySchemaServiceGrpc.MutinySchemaServiceStub stub) {
        this.stub = stub;
    }

    public SchemaServiceClient newInstanceWithStub(MutinySchemaServiceGrpc.MutinySchemaServiceStub stub) {
        return new SchemaServiceClient(stub);
    }

    @Override
    public MutinySchemaServiceGrpc.MutinySchemaServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ReadSchemaResponse> readSchema(
            com.authzed.api.v1.ReadSchemaRequest request) {
        return stub.readSchema(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.WriteSchemaResponse> writeSchema(
            com.authzed.api.v1.WriteSchemaRequest request) {
        return stub.writeSchema(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ReflectSchemaResponse> reflectSchema(
            com.authzed.api.v1.ReflectSchemaRequest request) {
        return stub.reflectSchema(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ComputablePermissionsResponse> computablePermissions(
            com.authzed.api.v1.ComputablePermissionsRequest request) {
        return stub.computablePermissions(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.DependentRelationsResponse> dependentRelations(
            com.authzed.api.v1.DependentRelationsRequest request) {
        return stub.dependentRelations(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.DiffSchemaResponse> diffSchema(
            com.authzed.api.v1.DiffSchemaRequest request) {
        return stub.diffSchema(request);
    }
}
