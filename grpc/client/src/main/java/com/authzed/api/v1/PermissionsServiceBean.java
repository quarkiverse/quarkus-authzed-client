package com.authzed.api.v1;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/permission_service.proto")
public class PermissionsServiceBean extends MutinyPermissionsServiceGrpc.PermissionsServiceImplBase
        implements BindableService, MutinyBean {

    private final PermissionsService delegate;

    PermissionsServiceBean(@GrpcService PermissionsService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.WriteRelationshipsResponse> writeRelationships(
            com.authzed.api.v1.PermissionService.WriteRelationshipsRequest request) {
        try {
            return delegate.writeRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.DeleteRelationshipsResponse> deleteRelationships(
            com.authzed.api.v1.PermissionService.DeleteRelationshipsRequest request) {
        try {
            return delegate.deleteRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.CheckPermissionResponse> checkPermission(
            com.authzed.api.v1.PermissionService.CheckPermissionRequest request) {
        try {
            return delegate.checkPermission(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.ExpandPermissionTreeResponse> expandPermissionTree(
            com.authzed.api.v1.PermissionService.ExpandPermissionTreeRequest request) {
        try {
            return delegate.expandPermissionTree(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.ReadRelationshipsResponse> readRelationships(
            com.authzed.api.v1.PermissionService.ReadRelationshipsRequest request) {
        try {
            return delegate.readRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupResourcesResponse> lookupResources(
            com.authzed.api.v1.PermissionService.LookupResourcesRequest request) {
        try {
            return delegate.lookupResources(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupSubjectsResponse> lookupSubjects(
            com.authzed.api.v1.PermissionService.LookupSubjectsRequest request) {
        try {
            return delegate.lookupSubjects(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
