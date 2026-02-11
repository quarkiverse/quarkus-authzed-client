package com.authzed.api.v1;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/experimental_service.proto")
public class ExperimentalServiceClient
        implements ExperimentalService, MutinyClient<MutinyExperimentalServiceGrpc.MutinyExperimentalServiceStub> {

    private final MutinyExperimentalServiceGrpc.MutinyExperimentalServiceStub stub;

    public ExperimentalServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinyExperimentalServiceGrpc.MutinyExperimentalServiceStub, MutinyExperimentalServiceGrpc.MutinyExperimentalServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyExperimentalServiceGrpc.newMutinyStub(channel));
    }

    private ExperimentalServiceClient(MutinyExperimentalServiceGrpc.MutinyExperimentalServiceStub stub) {
        this.stub = stub;
    }

    public ExperimentalServiceClient newInstanceWithStub(MutinyExperimentalServiceGrpc.MutinyExperimentalServiceStub stub) {
        return new ExperimentalServiceClient(stub);
    }

    @Override
    public MutinyExperimentalServiceGrpc.MutinyExperimentalServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkCheckPermissionResponse> bulkCheckPermission(
            com.authzed.api.v1.BulkCheckPermissionRequest request) {
        return stub.bulkCheckPermission(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalReflectSchemaResponse> experimentalReflectSchema(
            com.authzed.api.v1.ExperimentalReflectSchemaRequest request) {
        return stub.experimentalReflectSchema(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalComputablePermissionsResponse> experimentalComputablePermissions(
            com.authzed.api.v1.ExperimentalComputablePermissionsRequest request) {
        return stub.experimentalComputablePermissions(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDependentRelationsResponse> experimentalDependentRelations(
            com.authzed.api.v1.ExperimentalDependentRelationsRequest request) {
        return stub.experimentalDependentRelations(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDiffSchemaResponse> experimentalDiffSchema(
            com.authzed.api.v1.ExperimentalDiffSchemaRequest request) {
        return stub.experimentalDiffSchema(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> experimentalRegisterRelationshipCounter(
            com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request) {
        return stub.experimentalRegisterRelationshipCounter(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalCountRelationshipsResponse> experimentalCountRelationships(
            com.authzed.api.v1.ExperimentalCountRelationshipsRequest request) {
        return stub.experimentalCountRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> experimentalUnregisterRelationshipCounter(
            com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request) {
        return stub.experimentalUnregisterRelationshipCounter(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkExportRelationshipsResponse> bulkExportRelationships(
            com.authzed.api.v1.BulkExportRelationshipsRequest request) {
        return stub.bulkExportRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkImportRelationshipsResponse> bulkImportRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkImportRelationshipsRequest> request) {
        return stub.bulkImportRelationships(request);
    }
}
