package com.authzed.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ExperimentalService exposes a number of APIs that are currently being
 * prototyped and tested for future inclusion in the stable API.
 * </pre>
 */
@io.quarkus.grpc.common.Generated(value = "by gRPC proto compiler (version 1.54.0)", comments = "Source: authzed/api/v1/experimental_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExperimentalServiceGrpc {

    private ExperimentalServiceGrpc() {
    }

    public static final String SERVICE_NAME = "authzed.api.v1.ExperimentalService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> getBulkImportRelationshipsMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "BulkImportRelationships", requestType = com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest.class, responseType = com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> getBulkImportRelationshipsMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> getBulkImportRelationshipsMethod;
        if ((getBulkImportRelationshipsMethod = ExperimentalServiceGrpc.getBulkImportRelationshipsMethod) == null) {
            synchronized (ExperimentalServiceGrpc.class) {
                if ((getBulkImportRelationshipsMethod = ExperimentalServiceGrpc.getBulkImportRelationshipsMethod) == null) {
                    ExperimentalServiceGrpc.getBulkImportRelationshipsMethod = getBulkImportRelationshipsMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BulkImportRelationships"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest
                                            .getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse
                                            .getDefaultInstance()))
                            .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("BulkImportRelationships"))
                            .build();
                }
            }
        }
        return getBulkImportRelationshipsMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> getBulkExportRelationshipsMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "BulkExportRelationships", requestType = com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest.class, responseType = com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> getBulkExportRelationshipsMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> getBulkExportRelationshipsMethod;
        if ((getBulkExportRelationshipsMethod = ExperimentalServiceGrpc.getBulkExportRelationshipsMethod) == null) {
            synchronized (ExperimentalServiceGrpc.class) {
                if ((getBulkExportRelationshipsMethod = ExperimentalServiceGrpc.getBulkExportRelationshipsMethod) == null) {
                    ExperimentalServiceGrpc.getBulkExportRelationshipsMethod = getBulkExportRelationshipsMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BulkExportRelationships"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest
                                            .getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse
                                            .getDefaultInstance()))
                            .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("BulkExportRelationships"))
                            .build();
                }
            }
        }
        return getBulkExportRelationshipsMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> getBulkCheckPermissionMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "BulkCheckPermission", requestType = com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest.class, responseType = com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> getBulkCheckPermissionMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> getBulkCheckPermissionMethod;
        if ((getBulkCheckPermissionMethod = ExperimentalServiceGrpc.getBulkCheckPermissionMethod) == null) {
            synchronized (ExperimentalServiceGrpc.class) {
                if ((getBulkCheckPermissionMethod = ExperimentalServiceGrpc.getBulkCheckPermissionMethod) == null) {
                    ExperimentalServiceGrpc.getBulkCheckPermissionMethod = getBulkCheckPermissionMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BulkCheckPermission"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest
                                            .getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse
                                            .getDefaultInstance()))
                            .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("BulkCheckPermission"))
                            .build();
                }
            }
        }
        return getBulkCheckPermissionMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static ExperimentalServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceStub> factory = new io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceStub>() {

            @java.lang.Override
            public ExperimentalServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new ExperimentalServiceStub(channel, callOptions);
            }
        };
        return ExperimentalServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static ExperimentalServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceBlockingStub>() {

            @java.lang.Override
            public ExperimentalServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new ExperimentalServiceBlockingStub(channel, callOptions);
            }
        };
        return ExperimentalServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static ExperimentalServiceFutureStub newFutureStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceFutureStub>() {

            @java.lang.Override
            public ExperimentalServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new ExperimentalServiceFutureStub(channel, callOptions);
            }
        };
        return ExperimentalServiceFutureStub.newStub(factory, channel);
    }

    /**
     * <pre>
     * ExperimentalService exposes a number of APIs that are currently being
     * prototyped and tested for future inclusion in the stable API.
     * </pre>
     */
    public interface AsyncService {

        /**
         * <pre>
         * BulkImportRelationships is a faster path to writing a large number of
         * relationships at once. It is both batched and streaming. For maximum
         * performance, the caller should attempt to write relationships in as close
         * to relationship sort order as possible: (resource.object_type,
         * resource.object_id, relation, subject.object.object_type,
         * subject.object.object_id, subject.optional_relation)
         *
         * EXPERIMENTAL
         * https://github.com/authzed/spicedb/issues/1303
         * </pre>
         */
        default io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest> bulkImportRelationships(
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> responseObserver) {
            return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBulkImportRelationshipsMethod(),
                    responseObserver);
        }

        /**
         * <pre>
         * BulkExportRelationships is the fastest path available to exporting
         * relationships from the server. It is resumable, and will return results
         * in an order determined by the server.
         * </pre>
         */
        default void bulkExportRelationships(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBulkExportRelationshipsMethod(), responseObserver);
        }

        /**
         */
        default void bulkCheckPermission(com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBulkCheckPermissionMethod(), responseObserver);
        }
    }

    /**
     * Base class for the server implementation of the service ExperimentalService.
     *
     * <pre>
     * ExperimentalService exposes a number of APIs that are currently being
     * prototyped and tested for future inclusion in the stable API.
     * </pre>
     */
    public static abstract class ExperimentalServiceImplBase implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return ExperimentalServiceGrpc.bindService(this);
        }
    }

    /**
     * A stub to allow clients to do asynchronous rpc calls to service ExperimentalService.
     *
     * <pre>
     * ExperimentalService exposes a number of APIs that are currently being
     * prototyped and tested for future inclusion in the stable API.
     * </pre>
     */
    public static class ExperimentalServiceStub extends io.grpc.stub.AbstractAsyncStub<ExperimentalServiceStub> {

        private ExperimentalServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ExperimentalServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExperimentalServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * BulkImportRelationships is a faster path to writing a large number of
         * relationships at once. It is both batched and streaming. For maximum
         * performance, the caller should attempt to write relationships in as close
         * to relationship sort order as possible: (resource.object_type,
         * resource.object_id, relation, subject.object.object_type,
         * subject.object.object_id, subject.optional_relation)
         *
         * EXPERIMENTAL
         * https://github.com/authzed/spicedb/issues/1303
         * </pre>
         */
        public io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest> bulkImportRelationships(
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse> responseObserver) {
            return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
                    getChannel().newCall(getBulkImportRelationshipsMethod(), getCallOptions()), responseObserver);
        }

        /**
         * <pre>
         * BulkExportRelationships is the fastest path available to exporting
         * relationships from the server. It is resumable, and will return results
         * in an order determined by the server.
         * </pre>
         */
        public void bulkExportRelationships(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncServerStreamingCall(
                    getChannel().newCall(getBulkExportRelationshipsMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void bulkCheckPermission(com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getBulkCheckPermissionMethod(), getCallOptions()),
                    request, responseObserver);
        }
    }

    /**
     * A stub to allow clients to do synchronous rpc calls to service ExperimentalService.
     *
     * <pre>
     * ExperimentalService exposes a number of APIs that are currently being
     * prototyped and tested for future inclusion in the stable API.
     * </pre>
     */
    public static class ExperimentalServiceBlockingStub
            extends io.grpc.stub.AbstractBlockingStub<ExperimentalServiceBlockingStub> {

        private ExperimentalServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ExperimentalServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExperimentalServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * BulkExportRelationships is the fastest path available to exporting
         * relationships from the server. It is resumable, and will return results
         * in an order determined by the server.
         * </pre>
         */
        public java.util.Iterator<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse> bulkExportRelationships(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest request) {
            return io.grpc.stub.ClientCalls.blockingServerStreamingCall(getChannel(), getBulkExportRelationshipsMethod(),
                    getCallOptions(), request);
        }

        /**
         */
        public com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse bulkCheckPermission(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getBulkCheckPermissionMethod(), getCallOptions(),
                    request);
        }
    }

    /**
     * A stub to allow clients to do ListenableFuture-style rpc calls to service ExperimentalService.
     *
     * <pre>
     * ExperimentalService exposes a number of APIs that are currently being
     * prototyped and tested for future inclusion in the stable API.
     * </pre>
     */
    public static class ExperimentalServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ExperimentalServiceFutureStub> {

        private ExperimentalServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected ExperimentalServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExperimentalServiceFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse> bulkCheckPermission(
                com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest request) {
            return io.grpc.stub.ClientCalls
                    .futureUnaryCall(getChannel().newCall(getBulkCheckPermissionMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_BULK_EXPORT_RELATIONSHIPS = 0;

    private static final int METHODID_BULK_CHECK_PERMISSION = 1;

    private static final int METHODID_BULK_IMPORT_RELATIONSHIPS = 2;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final AsyncService serviceImpl;

        private final int methodId;

        MethodHandlers(AsyncService serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_BULK_EXPORT_RELATIONSHIPS:
                    serviceImpl.bulkExportRelationships(
                            (com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse>) responseObserver);
                    break;
                case METHODID_BULK_CHECK_PERMISSION:
                    serviceImpl.bulkCheckPermission(
                            (com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_BULK_IMPORT_RELATIONSHIPS:
                    return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bulkImportRelationships(
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse>) responseObserver);
                default:
                    throw new AssertionError();
            }
        }
    }

    public static io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                .addMethod(getBulkImportRelationshipsMethod(), io.grpc.stub.ServerCalls.asyncClientStreamingCall(
                        new MethodHandlers<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkImportRelationshipsResponse>(
                                service, METHODID_BULK_IMPORT_RELATIONSHIPS)))
                .addMethod(getBulkExportRelationshipsMethod(), io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                        new MethodHandlers<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkExportRelationshipsResponse>(
                                service, METHODID_BULK_EXPORT_RELATIONSHIPS)))
                .addMethod(getBulkCheckPermissionMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(
                        new MethodHandlers<com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionRequest, com.authzed.api.v1.ExperimentalServiceOuterClass.BulkCheckPermissionResponse>(
                                service, METHODID_BULK_CHECK_PERMISSION)))
                .build();
    }

    private static abstract class ExperimentalServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {

        ExperimentalServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.authzed.api.v1.ExperimentalServiceOuterClass.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("ExperimentalService");
        }
    }

    private static final class ExperimentalServiceFileDescriptorSupplier extends ExperimentalServiceBaseDescriptorSupplier {

        ExperimentalServiceFileDescriptorSupplier() {
        }
    }

    private static final class ExperimentalServiceMethodDescriptorSupplier extends ExperimentalServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {

        private final String methodName;

        ExperimentalServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (ExperimentalServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new ExperimentalServiceFileDescriptorSupplier())
                            .addMethod(getBulkImportRelationshipsMethod()).addMethod(getBulkExportRelationshipsMethod())
                            .addMethod(getBulkCheckPermissionMethod()).build();
                }
            }
        }
        return result;
    }
}
