package com.authzed.api.v1;

import static com.authzed.api.v1.ExperimentalServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/experimental_service.proto")
public final class MutinyExperimentalServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyExperimentalServiceGrpc() {
    }

    public static MutinyExperimentalServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyExperimentalServiceStub(channel);
    }

    /**
     * <pre>
     *  ExperimentalService exposes a number of APIs that are currently being
     *  prototyped and tested for future inclusion in the stable API.
     * </pre>
     */
    public static class MutinyExperimentalServiceStub extends io.grpc.stub.AbstractStub<MutinyExperimentalServiceStub>
            implements io.quarkus.grpc.MutinyStub {

        private ExperimentalServiceGrpc.ExperimentalServiceStub delegateStub;

        private MutinyExperimentalServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = ExperimentalServiceGrpc.newStub(channel);
        }

        private MutinyExperimentalServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = ExperimentalServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyExperimentalServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyExperimentalServiceStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> bulkCheckPermission(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::bulkCheckPermission);
        }

        /**
         * <pre>
         *  BulkExportRelationships is the fastest path available to exporting
         *  relationships from the server. It is resumable, and will return results
         *  in an order determined by the server.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> bulkExportRelationships(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::bulkExportRelationships);
        }

        /**
         * <pre>
         *  BulkImportRelationships is a faster path to writing a large number of
         *  relationships at once. It is both batched and streaming. For maximum
         *  performance, the caller should attempt to write relationships in as close
         *  to relationship sort order as possible: (resource.object_type,
         *  resource.object_id, relation, subject.object.object_type,
         *  subject.object.object_id, subject.optional_relation)
         *
         *  EXPERIMENTAL
         *  https://github.com/authzed/spicedb/issues/1303
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> bulkImportRelationships(
                io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest> request) {
            return io.quarkus.grpc.stubs.ClientCalls.manyToOne(request, delegateStub::bulkImportRelationships);
        }
    }

    /**
     * <pre>
     *  ExperimentalService exposes a number of APIs that are currently being
     *  prototyped and tested for future inclusion in the stable API.
     * </pre>
     */
    public static abstract class ExperimentalServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public ExperimentalServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> bulkCheckPermission(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  BulkExportRelationships is the fastest path available to exporting
         *  relationships from the server. It is resumable, and will return results
         *  in an order determined by the server.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> bulkExportRelationships(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  BulkImportRelationships is a faster path to writing a large number of
         *  relationships at once. It is both batched and streaming. For maximum
         *  performance, the caller should attempt to write relationships in as close
         *  to relationship sort order as possible: (resource.object_type,
         *  resource.object_id, relation, subject.object.object_type,
         *  subject.object.object_id, subject.optional_relation)
         *
         *  EXPERIMENTAL
         *  https://github.com/authzed/spicedb/issues/1303
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> bulkImportRelationships(
                io.smallrye.mutiny.Multi<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(
                    com.authzed.api.v1.ExperimentalServiceGrpc.getBulkImportRelationshipsMethod(),
                    asyncClientStreamingCall(
                            new MethodHandlers<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse>(
                                    this, METHODID_BULK_IMPORT_RELATIONSHIPS, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getBulkExportRelationshipsMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse>(
                                            this, METHODID_BULK_EXPORT_RELATIONSHIPS, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getBulkCheckPermissionMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse>(
                                    this, METHODID_BULK_CHECK_PERMISSION, compression)))
                    .build();
        }
    }

    private static final int METHODID_BULK_IMPORT_RELATIONSHIPS = 0;

    private static final int METHODID_BULK_EXPORT_RELATIONSHIPS = 1;

    private static final int METHODID_BULK_CHECK_PERMISSION = 2;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final ExperimentalServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(ExperimentalServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_BULK_EXPORT_RELATIONSHIPS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany(
                            (com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse>) responseObserver,
                            compression, serviceImpl::bulkExportRelationships);
                    break;
                case METHODID_BULK_CHECK_PERMISSION:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse>) responseObserver,
                            compression, serviceImpl::bulkCheckPermission);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_BULK_IMPORT_RELATIONSHIPS:
                    return (io.grpc.stub.StreamObserver<Req>) io.quarkus.grpc.stubs.ServerCalls.manyToOne(
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse>) responseObserver,
                            serviceImpl::bulkImportRelationships);
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}
