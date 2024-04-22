package com.authzed.api.v0;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v0/developer.proto")
public class DeveloperServiceBean extends MutinyDeveloperServiceGrpc.DeveloperServiceImplBase
        implements BindableService, MutinyBean {

    private final DeveloperService delegate;

    DeveloperServiceBean(@GrpcService DeveloperService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.EditCheckResponse> editCheck(
            com.authzed.api.v0.Developer.EditCheckRequest request) {
        try {
            return delegate.editCheck(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ValidateResponse> validate(
            com.authzed.api.v0.Developer.ValidateRequest request) {
        try {
            return delegate.validate(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ShareResponse> share(
            com.authzed.api.v0.Developer.ShareRequest request) {
        try {
            return delegate.share(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.LookupShareResponse> lookupShared(
            com.authzed.api.v0.Developer.LookupShareRequest request) {
        try {
            return delegate.lookupShared(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.UpgradeSchemaResponse> upgradeSchema(
            com.authzed.api.v0.Developer.UpgradeSchemaRequest request) {
        try {
            return delegate.upgradeSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.FormatSchemaResponse> formatSchema(
            com.authzed.api.v0.Developer.FormatSchemaRequest request) {
        try {
            return delegate.formatSchema(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
