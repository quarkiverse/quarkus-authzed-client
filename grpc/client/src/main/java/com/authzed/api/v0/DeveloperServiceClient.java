package com.authzed.api.v0;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v0/developer.proto")
public class DeveloperServiceClient
        implements DeveloperService, MutinyClient<MutinyDeveloperServiceGrpc.MutinyDeveloperServiceStub> {

    private final MutinyDeveloperServiceGrpc.MutinyDeveloperServiceStub stub;

    public DeveloperServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinyDeveloperServiceGrpc.MutinyDeveloperServiceStub, MutinyDeveloperServiceGrpc.MutinyDeveloperServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyDeveloperServiceGrpc.newMutinyStub(channel));
    }

    private DeveloperServiceClient(MutinyDeveloperServiceGrpc.MutinyDeveloperServiceStub stub) {
        this.stub = stub;
    }

    public DeveloperServiceClient newInstanceWithStub(MutinyDeveloperServiceGrpc.MutinyDeveloperServiceStub stub) {
        return new DeveloperServiceClient(stub);
    }

    @Override
    public MutinyDeveloperServiceGrpc.MutinyDeveloperServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.EditCheckResponse> editCheck(
            com.authzed.api.v0.Developer.EditCheckRequest request) {
        return stub.editCheck(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ValidateResponse> validate(
            com.authzed.api.v0.Developer.ValidateRequest request) {
        return stub.validate(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ShareResponse> share(
            com.authzed.api.v0.Developer.ShareRequest request) {
        return stub.share(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.LookupShareResponse> lookupShared(
            com.authzed.api.v0.Developer.LookupShareRequest request) {
        return stub.lookupShared(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.UpgradeSchemaResponse> upgradeSchema(
            com.authzed.api.v0.Developer.UpgradeSchemaRequest request) {
        return stub.upgradeSchema(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.FormatSchemaResponse> formatSchema(
            com.authzed.api.v0.Developer.FormatSchemaRequest request) {
        return stub.formatSchema(request);
    }
}
