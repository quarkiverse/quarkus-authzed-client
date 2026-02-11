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
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkCheckPermissionResponse> bulkCheckPermission(
            com.authzed.api.v1.BulkCheckPermissionRequest request) {
        try {
            return delegate.bulkCheckPermission(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalReflectSchemaResponse> experimentalReflectSchema(
            com.authzed.api.v1.ExperimentalReflectSchemaRequest request) {
        try {
            return delegate.experimentalReflectSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalComputablePermissionsResponse> experimentalComputablePermissions(
            com.authzed.api.v1.ExperimentalComputablePermissionsRequest request) {
        try {
            return delegate.experimentalComputablePermissions(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDependentRelationsResponse> experimentalDependentRelations(
            com.authzed.api.v1.ExperimentalDependentRelationsRequest request) {
        try {
            return delegate.experimentalDependentRelations(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDiffSchemaResponse> experimentalDiffSchema(
            com.authzed.api.v1.ExperimentalDiffSchemaRequest request) {
        try {
            return delegate.experimentalDiffSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> experimentalRegisterRelationshipCounter(
            com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request) {
        try {
            return delegate.experimentalRegisterRelationshipCounter(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalCountRelationshipsResponse> experimentalCountRelationships(
            com.authzed.api.v1.ExperimentalCountRelationshipsRequest request) {
        try {
            return delegate.experimentalCountRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> experimentalUnregisterRelationshipCounter(
            com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request) {
        try {
            return delegate.experimentalUnregisterRelationshipCounter(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkExportRelationshipsResponse> bulkExportRelationships(
            com.authzed.api.v1.BulkExportRelationshipsRequest request) {
        try {
            return delegate.bulkExportRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkImportRelationshipsResponse> bulkImportRelationships(
            io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkImportRelationshipsRequest> request) {
        try {
            return delegate.bulkImportRelationships(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
