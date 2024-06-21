package com.authzed.api.v1;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/experimental_service.proto")
public class ExperimentalServiceBean extends MutinyExperimentalServiceGrpc.ExperimentalServiceImplBase
        implements BindableService, MutinyBean {

    private final ExperimentalService delegate;

    ExperimentalServiceBean(@GrpcService ExperimentalService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> bulkCheckPermission(
            com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request) {
        try {
            return delegate.bulkCheckPermission(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> bulkExportRelationships(
            com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest request) {
        try {
            return delegate.bulkExportRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> bulkImportRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest> request) {
        try {
            return delegate.bulkImportRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
