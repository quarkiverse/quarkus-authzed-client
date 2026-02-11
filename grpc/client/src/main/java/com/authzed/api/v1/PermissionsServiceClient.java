package com.authzed.api.v1;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/permission_service.proto")
public class PermissionsServiceClient
        implements PermissionsService, MutinyClient<MutinyPermissionsServiceGrpc.MutinyPermissionsServiceStub> {

    private final MutinyPermissionsServiceGrpc.MutinyPermissionsServiceStub stub;

    public PermissionsServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinyPermissionsServiceGrpc.MutinyPermissionsServiceStub, MutinyPermissionsServiceGrpc.MutinyPermissionsServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyPermissionsServiceGrpc.newMutinyStub(channel));
    }

    private PermissionsServiceClient(MutinyPermissionsServiceGrpc.MutinyPermissionsServiceStub stub) {
        this.stub = stub;
    }

    public PermissionsServiceClient newInstanceWithStub(MutinyPermissionsServiceGrpc.MutinyPermissionsServiceStub stub) {
        return new PermissionsServiceClient(stub);
    }

    @Override
    public MutinyPermissionsServiceGrpc.MutinyPermissionsServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.WriteRelationshipsResponse> writeRelationships(
            com.authzed.api.v1.WriteRelationshipsRequest request) {
        return stub.writeRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.DeleteRelationshipsResponse> deleteRelationships(
            com.authzed.api.v1.DeleteRelationshipsRequest request) {
        return stub.deleteRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.CheckPermissionResponse> checkPermission(
            com.authzed.api.v1.CheckPermissionRequest request) {
        return stub.checkPermission(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.CheckBulkPermissionsResponse> checkBulkPermissions(
            com.authzed.api.v1.CheckBulkPermissionsRequest request) {
        return stub.checkBulkPermissions(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExpandPermissionTreeResponse> expandPermissionTree(
            com.authzed.api.v1.ExpandPermissionTreeRequest request) {
        return stub.expandPermissionTree(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.ReadRelationshipsResponse> readRelationships(
            com.authzed.api.v1.ReadRelationshipsRequest request) {
        return stub.readRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.LookupResourcesResponse> lookupResources(
            com.authzed.api.v1.LookupResourcesRequest request) {
        return stub.lookupResources(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.LookupSubjectsResponse> lookupSubjects(
            com.authzed.api.v1.LookupSubjectsRequest request) {
        return stub.lookupSubjects(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.ExportBulkRelationshipsResponse> exportBulkRelationships(
            com.authzed.api.v1.ExportBulkRelationshipsRequest request) {
        return stub.exportBulkRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ImportBulkRelationshipsResponse> importBulkRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.ImportBulkRelationshipsRequest> request) {
        return stub.importBulkRelationships(request);
    }
}
