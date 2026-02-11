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

        /**
         * <pre>
         *  DEPRECATED: Promoted to CheckBulkPermission in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkCheckPermissionResponse> bulkCheckPermission(
                com.authzed.api.v1.BulkCheckPermissionRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::bulkCheckPermission);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to ReflectSchema in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalReflectSchemaResponse> experimentalReflectSchema(
                com.authzed.api.v1.ExperimentalReflectSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::experimentalReflectSchema);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to ComputablePermissions in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalComputablePermissionsResponse> experimentalComputablePermissions(
                com.authzed.api.v1.ExperimentalComputablePermissionsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::experimentalComputablePermissions);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to DependentRelations in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDependentRelationsResponse> experimentalDependentRelations(
                com.authzed.api.v1.ExperimentalDependentRelationsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::experimentalDependentRelations);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to DiffSchema in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDiffSchemaResponse> experimentalDiffSchema(
                com.authzed.api.v1.ExperimentalDiffSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::experimentalDiffSchema);
        }

        /**
         * <pre>
         *  EXPERIMENTAL: RegisterRelationshipCounter registers a new filter for counting relationships. A filter must be registered before
         *  a count can be requested.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> experimentalRegisterRelationshipCounter(
                com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::experimentalRegisterRelationshipCounter);
        }

        /**
         * <pre>
         *  EXPERIMENTAL: CountRelationships returns the count of relationships for &#42;pre-registered&#42; filter.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalCountRelationshipsResponse> experimentalCountRelationships(
                com.authzed.api.v1.ExperimentalCountRelationshipsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::experimentalCountRelationships);
        }

        /**
         * <pre>
         *  EXPERIMENTAL: UnregisterRelationshipCounter unregisters an existing filter for counting relationships.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> experimentalUnregisterRelationshipCounter(
                com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::experimentalUnregisterRelationshipCounter);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to ExportBulkRelationships in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkExportRelationshipsResponse> bulkExportRelationships(
                com.authzed.api.v1.BulkExportRelationshipsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::bulkExportRelationships);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to ImportBulkRelationships in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkImportRelationshipsResponse> bulkImportRelationships(
                io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkImportRelationshipsRequest> request) {
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

        /**
         * <pre>
         *  DEPRECATED: Promoted to CheckBulkPermission in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkCheckPermissionResponse> bulkCheckPermission(
                com.authzed.api.v1.BulkCheckPermissionRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to ReflectSchema in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalReflectSchemaResponse> experimentalReflectSchema(
                com.authzed.api.v1.ExperimentalReflectSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to ComputablePermissions in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalComputablePermissionsResponse> experimentalComputablePermissions(
                com.authzed.api.v1.ExperimentalComputablePermissionsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to DependentRelations in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDependentRelationsResponse> experimentalDependentRelations(
                com.authzed.api.v1.ExperimentalDependentRelationsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to DiffSchema in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalDiffSchemaResponse> experimentalDiffSchema(
                com.authzed.api.v1.ExperimentalDiffSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  EXPERIMENTAL: RegisterRelationshipCounter registers a new filter for counting relationships. A filter must be registered before
         *  a count can be requested.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> experimentalRegisterRelationshipCounter(
                com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  EXPERIMENTAL: CountRelationships returns the count of relationships for &#42;pre-registered&#42; filter.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalCountRelationshipsResponse> experimentalCountRelationships(
                com.authzed.api.v1.ExperimentalCountRelationshipsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  EXPERIMENTAL: UnregisterRelationshipCounter unregisters an existing filter for counting relationships.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> experimentalUnregisterRelationshipCounter(
                com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to ExportBulkRelationships in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkExportRelationshipsResponse> bulkExportRelationships(
                com.authzed.api.v1.BulkExportRelationshipsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DEPRECATED: Promoted to ImportBulkRelationships in the stable API.
         * </pre>
         */
        @Deprecated
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.BulkImportRelationshipsResponse> bulkImportRelationships(
                io.smallrye.mutiny.Multi<com.authzed.api.v1.BulkImportRelationshipsRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(
                    com.authzed.api.v1.ExperimentalServiceGrpc.getBulkImportRelationshipsMethod(),
                    asyncClientStreamingCall(
                            new MethodHandlers<com.authzed.api.v1.BulkImportRelationshipsRequest, com.authzed.api.v1.BulkImportRelationshipsResponse>(
                                    this, METHODID_BULK_IMPORT_RELATIONSHIPS, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getBulkExportRelationshipsMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<com.authzed.api.v1.BulkExportRelationshipsRequest, com.authzed.api.v1.BulkExportRelationshipsResponse>(
                                            this, METHODID_BULK_EXPORT_RELATIONSHIPS, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getBulkCheckPermissionMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.BulkCheckPermissionRequest, com.authzed.api.v1.BulkCheckPermissionResponse>(
                                    this, METHODID_BULK_CHECK_PERMISSION, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getExperimentalReflectSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.ExperimentalReflectSchemaRequest, com.authzed.api.v1.ExperimentalReflectSchemaResponse>(
                                    this, METHODID_EXPERIMENTAL_REFLECT_SCHEMA, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getExperimentalComputablePermissionsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<com.authzed.api.v1.ExperimentalComputablePermissionsRequest, com.authzed.api.v1.ExperimentalComputablePermissionsResponse>(
                                            this, METHODID_EXPERIMENTAL_COMPUTABLE_PERMISSIONS, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getExperimentalDependentRelationsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<com.authzed.api.v1.ExperimentalDependentRelationsRequest, com.authzed.api.v1.ExperimentalDependentRelationsResponse>(
                                            this, METHODID_EXPERIMENTAL_DEPENDENT_RELATIONS, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getExperimentalDiffSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.ExperimentalDiffSchemaRequest, com.authzed.api.v1.ExperimentalDiffSchemaResponse>(
                                    this, METHODID_EXPERIMENTAL_DIFF_SCHEMA, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getExperimentalRegisterRelationshipCounterMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest, com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse>(
                                            this, METHODID_EXPERIMENTAL_REGISTER_RELATIONSHIP_COUNTER, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getExperimentalCountRelationshipsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<com.authzed.api.v1.ExperimentalCountRelationshipsRequest, com.authzed.api.v1.ExperimentalCountRelationshipsResponse>(
                                            this, METHODID_EXPERIMENTAL_COUNT_RELATIONSHIPS, compression)))
                    .addMethod(com.authzed.api.v1.ExperimentalServiceGrpc.getExperimentalUnregisterRelationshipCounterMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest, com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse>(
                                            this, METHODID_EXPERIMENTAL_UNREGISTER_RELATIONSHIP_COUNTER, compression)))
                    .build();
        }
    }

    private static final int METHODID_BULK_IMPORT_RELATIONSHIPS = 0;

    private static final int METHODID_BULK_EXPORT_RELATIONSHIPS = 1;

    private static final int METHODID_BULK_CHECK_PERMISSION = 2;

    private static final int METHODID_EXPERIMENTAL_REFLECT_SCHEMA = 3;

    private static final int METHODID_EXPERIMENTAL_COMPUTABLE_PERMISSIONS = 4;

    private static final int METHODID_EXPERIMENTAL_DEPENDENT_RELATIONS = 5;

    private static final int METHODID_EXPERIMENTAL_DIFF_SCHEMA = 6;

    private static final int METHODID_EXPERIMENTAL_REGISTER_RELATIONSHIP_COUNTER = 7;

    private static final int METHODID_EXPERIMENTAL_COUNT_RELATIONSHIPS = 8;

    private static final int METHODID_EXPERIMENTAL_UNREGISTER_RELATIONSHIP_COUNTER = 9;

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
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany((com.authzed.api.v1.BulkExportRelationshipsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkExportRelationshipsResponse>) responseObserver,
                            compression, serviceImpl::bulkExportRelationships);
                    break;
                case METHODID_BULK_CHECK_PERMISSION:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.BulkCheckPermissionRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkCheckPermissionResponse>) responseObserver,
                            compression, serviceImpl::bulkCheckPermission);
                    break;
                case METHODID_EXPERIMENTAL_REFLECT_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.ExperimentalReflectSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalReflectSchemaResponse>) responseObserver,
                            compression, serviceImpl::experimentalReflectSchema);
                    break;
                case METHODID_EXPERIMENTAL_COMPUTABLE_PERMISSIONS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.ExperimentalComputablePermissionsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalComputablePermissionsResponse>) responseObserver,
                            compression, serviceImpl::experimentalComputablePermissions);
                    break;
                case METHODID_EXPERIMENTAL_DEPENDENT_RELATIONS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.ExperimentalDependentRelationsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalDependentRelationsResponse>) responseObserver,
                            compression, serviceImpl::experimentalDependentRelations);
                    break;
                case METHODID_EXPERIMENTAL_DIFF_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.ExperimentalDiffSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalDiffSchemaResponse>) responseObserver,
                            compression, serviceImpl::experimentalDiffSchema);
                    break;
                case METHODID_EXPERIMENTAL_REGISTER_RELATIONSHIP_COUNTER:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse>) responseObserver,
                            compression, serviceImpl::experimentalRegisterRelationshipCounter);
                    break;
                case METHODID_EXPERIMENTAL_COUNT_RELATIONSHIPS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.ExperimentalCountRelationshipsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalCountRelationshipsResponse>) responseObserver,
                            compression, serviceImpl::experimentalCountRelationships);
                    break;
                case METHODID_EXPERIMENTAL_UNREGISTER_RELATIONSHIP_COUNTER:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse>) responseObserver,
                            compression, serviceImpl::experimentalUnregisterRelationshipCounter);
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
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkImportRelationshipsResponse>) responseObserver,
                            serviceImpl::bulkImportRelationships);
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}
