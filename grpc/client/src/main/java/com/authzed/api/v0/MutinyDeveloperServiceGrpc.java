package com.authzed.api.v0;

import static com.authzed.api.v0.DeveloperServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v0/developer.proto")
public final class MutinyDeveloperServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyDeveloperServiceGrpc() {
    }

    public static MutinyDeveloperServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyDeveloperServiceStub(channel);
    }

    public static class MutinyDeveloperServiceStub extends io.grpc.stub.AbstractStub<MutinyDeveloperServiceStub>
            implements io.quarkus.grpc.MutinyStub {

        private DeveloperServiceGrpc.DeveloperServiceStub delegateStub;

        private MutinyDeveloperServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = DeveloperServiceGrpc.newStub(channel);
        }

        private MutinyDeveloperServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = DeveloperServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyDeveloperServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyDeveloperServiceStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.EditCheckResponse> editCheck(
                com.authzed.api.v0.Developer.EditCheckRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::editCheck);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ValidateResponse> validate(
                com.authzed.api.v0.Developer.ValidateRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::validate);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ShareResponse> share(
                com.authzed.api.v0.Developer.ShareRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::share);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.LookupShareResponse> lookupShared(
                com.authzed.api.v0.Developer.LookupShareRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::lookupShared);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.UpgradeSchemaResponse> upgradeSchema(
                com.authzed.api.v0.Developer.UpgradeSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::upgradeSchema);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.FormatSchemaResponse> formatSchema(
                com.authzed.api.v0.Developer.FormatSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::formatSchema);
        }
    }

    public static abstract class DeveloperServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public DeveloperServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.EditCheckResponse> editCheck(
                com.authzed.api.v0.Developer.EditCheckRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ValidateResponse> validate(
                com.authzed.api.v0.Developer.ValidateRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ShareResponse> share(
                com.authzed.api.v0.Developer.ShareRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.LookupShareResponse> lookupShared(
                com.authzed.api.v0.Developer.LookupShareRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.UpgradeSchemaResponse> upgradeSchema(
                com.authzed.api.v0.Developer.UpgradeSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.FormatSchemaResponse> formatSchema(
                com.authzed.api.v0.Developer.FormatSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(com.authzed.api.v0.DeveloperServiceGrpc.getEditCheckMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v0.Developer.EditCheckRequest, com.authzed.api.v0.Developer.EditCheckResponse>(
                                    this, METHODID_EDIT_CHECK, compression)))
                    .addMethod(com.authzed.api.v0.DeveloperServiceGrpc.getValidateMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v0.Developer.ValidateRequest, com.authzed.api.v0.Developer.ValidateResponse>(
                                    this, METHODID_VALIDATE, compression)))
                    .addMethod(com.authzed.api.v0.DeveloperServiceGrpc.getShareMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v0.Developer.ShareRequest, com.authzed.api.v0.Developer.ShareResponse>(
                                    this, METHODID_SHARE, compression)))
                    .addMethod(com.authzed.api.v0.DeveloperServiceGrpc.getLookupSharedMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v0.Developer.LookupShareRequest, com.authzed.api.v0.Developer.LookupShareResponse>(
                                    this, METHODID_LOOKUP_SHARED, compression)))
                    .addMethod(com.authzed.api.v0.DeveloperServiceGrpc.getUpgradeSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v0.Developer.UpgradeSchemaRequest, com.authzed.api.v0.Developer.UpgradeSchemaResponse>(
                                    this, METHODID_UPGRADE_SCHEMA, compression)))
                    .addMethod(com.authzed.api.v0.DeveloperServiceGrpc.getFormatSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v0.Developer.FormatSchemaRequest, com.authzed.api.v0.Developer.FormatSchemaResponse>(
                                    this, METHODID_FORMAT_SCHEMA, compression)))
                    .build();
        }
    }

    private static final int METHODID_EDIT_CHECK = 0;

    private static final int METHODID_VALIDATE = 1;

    private static final int METHODID_SHARE = 2;

    private static final int METHODID_LOOKUP_SHARED = 3;

    private static final int METHODID_UPGRADE_SCHEMA = 4;

    private static final int METHODID_FORMAT_SCHEMA = 5;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final DeveloperServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(DeveloperServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_EDIT_CHECK:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v0.Developer.EditCheckRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.EditCheckResponse>) responseObserver,
                            compression, serviceImpl::editCheck);
                    break;
                case METHODID_VALIDATE:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v0.Developer.ValidateRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.ValidateResponse>) responseObserver,
                            compression, serviceImpl::validate);
                    break;
                case METHODID_SHARE:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v0.Developer.ShareRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.ShareResponse>) responseObserver,
                            compression, serviceImpl::share);
                    break;
                case METHODID_LOOKUP_SHARED:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v0.Developer.LookupShareRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.LookupShareResponse>) responseObserver,
                            compression, serviceImpl::lookupShared);
                    break;
                case METHODID_UPGRADE_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v0.Developer.UpgradeSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.UpgradeSchemaResponse>) responseObserver,
                            compression, serviceImpl::upgradeSchema);
                    break;
                case METHODID_FORMAT_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v0.Developer.FormatSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.FormatSchemaResponse>) responseObserver,
                            compression, serviceImpl::formatSchema);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}
