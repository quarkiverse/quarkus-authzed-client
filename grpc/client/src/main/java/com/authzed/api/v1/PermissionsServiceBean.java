package com.authzed.api.v1;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/permission_service.proto")
public class PermissionsServiceBean extends MutinyPermissionsServiceGrpc.PermissionsServiceImplBase
        implements BindableService, MutinyBean {

    private final PermissionsService delegate;

    PermissionsServiceBean(@GrpcService PermissionsService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.WriteRelationshipsResponse> writeRelationships(
            com.authzed.api.v1.WriteRelationshipsRequest request) {
        try {
            return delegate.writeRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.DeleteRelationshipsResponse> deleteRelationships(
            com.authzed.api.v1.DeleteRelationshipsRequest request) {
        try {
            return delegate.deleteRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.CheckPermissionResponse> checkPermission(
            com.authzed.api.v1.CheckPermissionRequest request) {
        try {
            return delegate.checkPermission(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.CheckBulkPermissionsResponse> checkBulkPermissions(
            com.authzed.api.v1.CheckBulkPermissionsRequest request) {
        try {
            return delegate.checkBulkPermissions(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExpandPermissionTreeResponse> expandPermissionTree(
            com.authzed.api.v1.ExpandPermissionTreeRequest request) {
        try {
            return delegate.expandPermissionTree(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.ReadRelationshipsResponse> readRelationships(
            com.authzed.api.v1.ReadRelationshipsRequest request) {
        try {
            return delegate.readRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.LookupResourcesResponse> lookupResources(
            com.authzed.api.v1.LookupResourcesRequest request) {
        try {
            return delegate.lookupResources(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.LookupSubjectsResponse> lookupSubjects(
            com.authzed.api.v1.LookupSubjectsRequest request) {
        try {
            return delegate.lookupSubjects(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.ExportBulkRelationshipsResponse> exportBulkRelationships(
            com.authzed.api.v1.ExportBulkRelationshipsRequest request) {
        try {
            return delegate.exportBulkRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ImportBulkRelationshipsResponse> importBulkRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.ImportBulkRelationshipsRequest> request) {
        try {
            return delegate.importBulkRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
