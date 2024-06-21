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
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> bulkCheckPermission(
            com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request) {
        return stub.bulkCheckPermission(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> bulkExportRelationships(
            com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest request) {
        return stub.bulkExportRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> bulkImportRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest> request) {
        return stub.bulkImportRelationships(request);
    }
}
