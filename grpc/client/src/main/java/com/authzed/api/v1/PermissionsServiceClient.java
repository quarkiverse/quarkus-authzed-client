package com.authzed.api.v1;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/permission_service.proto")
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
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.WriteRelationshipsResponse> writeRelationships(
            com.authzed.api.v1.PermissionService.WriteRelationshipsRequest request) {
        return stub.writeRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.DeleteRelationshipsResponse> deleteRelationships(
            com.authzed.api.v1.PermissionService.DeleteRelationshipsRequest request) {
        return stub.deleteRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.CheckPermissionResponse> checkPermission(
            com.authzed.api.v1.PermissionService.CheckPermissionRequest request) {
        return stub.checkPermission(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.ExpandPermissionTreeResponse> expandPermissionTree(
            com.authzed.api.v1.PermissionService.ExpandPermissionTreeRequest request) {
        return stub.expandPermissionTree(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.ReadRelationshipsResponse> readRelationships(
            com.authzed.api.v1.PermissionService.ReadRelationshipsRequest request) {
        return stub.readRelationships(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupResourcesResponse> lookupResources(
            com.authzed.api.v1.PermissionService.LookupResourcesRequest request) {
        return stub.lookupResources(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupSubjectsResponse> lookupSubjects(
            com.authzed.api.v1.PermissionService.LookupSubjectsRequest request) {
        return stub.lookupSubjects(request);
    }
}
