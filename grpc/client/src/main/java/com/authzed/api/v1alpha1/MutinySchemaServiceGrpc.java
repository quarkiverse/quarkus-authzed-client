package com.authzed.api.v1alpha1;

import static com.authzed.api.v1alpha1.SchemaServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1alpha1/schema.proto")
public final class MutinySchemaServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinySchemaServiceGrpc() {
    }

    public static MutinySchemaServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinySchemaServiceStub(channel);
    }

    /**
     * <pre>
     *  SchemaService implements operations on a Permissions System&#39;s Schema.
     * </pre>
     */
    public static class MutinySchemaServiceStub extends io.grpc.stub.AbstractStub<MutinySchemaServiceStub>
            implements io.quarkus.grpc.MutinyStub {

        private SchemaServiceGrpc.SchemaServiceStub delegateStub;

        private MutinySchemaServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = SchemaServiceGrpc.newStub(channel);
        }

        private MutinySchemaServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = SchemaServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinySchemaServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinySchemaServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         *  Read returns the current Object Definitions for a Permissions System.
         *
         *  Errors include:
         *  - INVALID_ARGUMENT: a provided value has failed to semantically validate
         *  - NOT_FOUND: one of the Object Definitions being requested does not exist
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1alpha1.Schema.ReadSchemaResponse> readSchema(
                com.authzed.api.v1alpha1.Schema.ReadSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::readSchema);
        }

        /**
         * <pre>
         *  Write overwrites the current Object Definitions for a Permissions System.
         *
         *  Any Object Definitions that exist, but are not included will be deleted.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1alpha1.Schema.WriteSchemaResponse> writeSchema(
                com.authzed.api.v1alpha1.Schema.WriteSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::writeSchema);
        }
    }

    /**
     * <pre>
     *  SchemaService implements operations on a Permissions System&#39;s Schema.
     * </pre>
     */
    public static abstract class SchemaServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public SchemaServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        /**
         * <pre>
         *  Read returns the current Object Definitions for a Permissions System.
         *
         *  Errors include:
         *  - INVALID_ARGUMENT: a provided value has failed to semantically validate
         *  - NOT_FOUND: one of the Object Definitions being requested does not exist
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1alpha1.Schema.ReadSchemaResponse> readSchema(
                com.authzed.api.v1alpha1.Schema.ReadSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  Write overwrites the current Object Definitions for a Permissions System.
         *
         *  Any Object Definitions that exist, but are not included will be deleted.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1alpha1.Schema.WriteSchemaResponse> writeSchema(
                com.authzed.api.v1alpha1.Schema.WriteSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(com.authzed.api.v1alpha1.SchemaServiceGrpc.getReadSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1alpha1.Schema.ReadSchemaRequest, com.authzed.api.v1alpha1.Schema.ReadSchemaResponse>(
                                    this, METHODID_READ_SCHEMA, compression)))
                    .addMethod(com.authzed.api.v1alpha1.SchemaServiceGrpc.getWriteSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1alpha1.Schema.WriteSchemaRequest, com.authzed.api.v1alpha1.Schema.WriteSchemaResponse>(
                                    this, METHODID_WRITE_SCHEMA, compression)))
                    .build();
        }
    }

    private static final int METHODID_READ_SCHEMA = 0;

    private static final int METHODID_WRITE_SCHEMA = 1;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final SchemaServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(SchemaServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_READ_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1alpha1.Schema.ReadSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1alpha1.Schema.ReadSchemaResponse>) responseObserver,
                            compression, serviceImpl::readSchema);
                    break;
                case METHODID_WRITE_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1alpha1.Schema.WriteSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1alpha1.Schema.WriteSchemaResponse>) responseObserver,
                            compression, serviceImpl::writeSchema);
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
