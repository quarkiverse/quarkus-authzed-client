package com.authzed.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * SchemaService implements operations on a Permissions System's Schema.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SchemaServiceGrpc {

    private SchemaServiceGrpc() {
    }

    public static final java.lang.String SERVICE_NAME = "authzed.api.v1.SchemaService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ReadSchemaRequest, com.authzed.api.v1.ReadSchemaResponse> getReadSchemaMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "ReadSchema", requestType = com.authzed.api.v1.ReadSchemaRequest.class, responseType = com.authzed.api.v1.ReadSchemaResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.ReadSchemaRequest, com.authzed.api.v1.ReadSchemaResponse> getReadSchemaMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.ReadSchemaRequest, com.authzed.api.v1.ReadSchemaResponse> getReadSchemaMethod;
        if ((getReadSchemaMethod = SchemaServiceGrpc.getReadSchemaMethod) == null) {
            synchronized (SchemaServiceGrpc.class) {
                if ((getReadSchemaMethod = SchemaServiceGrpc.getReadSchemaMethod) == null) {
                    SchemaServiceGrpc.getReadSchemaMethod = getReadSchemaMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.ReadSchemaRequest, com.authzed.api.v1.ReadSchemaResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadSchema"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ReadSchemaRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ReadSchemaResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("ReadSchema")).build();
                }
            }
        }
        return getReadSchemaMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.WriteSchemaRequest, com.authzed.api.v1.WriteSchemaResponse> getWriteSchemaMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "WriteSchema", requestType = com.authzed.api.v1.WriteSchemaRequest.class, responseType = com.authzed.api.v1.WriteSchemaResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.WriteSchemaRequest, com.authzed.api.v1.WriteSchemaResponse> getWriteSchemaMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.WriteSchemaRequest, com.authzed.api.v1.WriteSchemaResponse> getWriteSchemaMethod;
        if ((getWriteSchemaMethod = SchemaServiceGrpc.getWriteSchemaMethod) == null) {
            synchronized (SchemaServiceGrpc.class) {
                if ((getWriteSchemaMethod = SchemaServiceGrpc.getWriteSchemaMethod) == null) {
                    SchemaServiceGrpc.getWriteSchemaMethod = getWriteSchemaMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.WriteSchemaRequest, com.authzed.api.v1.WriteSchemaResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteSchema"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.WriteSchemaRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.WriteSchemaResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("WriteSchema")).build();
                }
            }
        }
        return getWriteSchemaMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ReflectSchemaRequest, com.authzed.api.v1.ReflectSchemaResponse> getReflectSchemaMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "ReflectSchema", requestType = com.authzed.api.v1.ReflectSchemaRequest.class, responseType = com.authzed.api.v1.ReflectSchemaResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.ReflectSchemaRequest, com.authzed.api.v1.ReflectSchemaResponse> getReflectSchemaMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.ReflectSchemaRequest, com.authzed.api.v1.ReflectSchemaResponse> getReflectSchemaMethod;
        if ((getReflectSchemaMethod = SchemaServiceGrpc.getReflectSchemaMethod) == null) {
            synchronized (SchemaServiceGrpc.class) {
                if ((getReflectSchemaMethod = SchemaServiceGrpc.getReflectSchemaMethod) == null) {
                    SchemaServiceGrpc.getReflectSchemaMethod = getReflectSchemaMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.ReflectSchemaRequest, com.authzed.api.v1.ReflectSchemaResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReflectSchema"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ReflectSchemaRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ReflectSchemaResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("ReflectSchema")).build();
                }
            }
        }
        return getReflectSchemaMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ComputablePermissionsRequest, com.authzed.api.v1.ComputablePermissionsResponse> getComputablePermissionsMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "ComputablePermissions", requestType = com.authzed.api.v1.ComputablePermissionsRequest.class, responseType = com.authzed.api.v1.ComputablePermissionsResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.ComputablePermissionsRequest, com.authzed.api.v1.ComputablePermissionsResponse> getComputablePermissionsMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.ComputablePermissionsRequest, com.authzed.api.v1.ComputablePermissionsResponse> getComputablePermissionsMethod;
        if ((getComputablePermissionsMethod = SchemaServiceGrpc.getComputablePermissionsMethod) == null) {
            synchronized (SchemaServiceGrpc.class) {
                if ((getComputablePermissionsMethod = SchemaServiceGrpc.getComputablePermissionsMethod) == null) {
                    SchemaServiceGrpc.getComputablePermissionsMethod = getComputablePermissionsMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.ComputablePermissionsRequest, com.authzed.api.v1.ComputablePermissionsResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputablePermissions"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ComputablePermissionsRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.ComputablePermissionsResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("ComputablePermissions")).build();
                }
            }
        }
        return getComputablePermissionsMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.DependentRelationsRequest, com.authzed.api.v1.DependentRelationsResponse> getDependentRelationsMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "DependentRelations", requestType = com.authzed.api.v1.DependentRelationsRequest.class, responseType = com.authzed.api.v1.DependentRelationsResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.DependentRelationsRequest, com.authzed.api.v1.DependentRelationsResponse> getDependentRelationsMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.DependentRelationsRequest, com.authzed.api.v1.DependentRelationsResponse> getDependentRelationsMethod;
        if ((getDependentRelationsMethod = SchemaServiceGrpc.getDependentRelationsMethod) == null) {
            synchronized (SchemaServiceGrpc.class) {
                if ((getDependentRelationsMethod = SchemaServiceGrpc.getDependentRelationsMethod) == null) {
                    SchemaServiceGrpc.getDependentRelationsMethod = getDependentRelationsMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.DependentRelationsRequest, com.authzed.api.v1.DependentRelationsResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DependentRelations"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.DependentRelationsRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.DependentRelationsResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("DependentRelations")).build();
                }
            }
        }
        return getDependentRelationsMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.DiffSchemaRequest, com.authzed.api.v1.DiffSchemaResponse> getDiffSchemaMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
            + "DiffSchema", requestType = com.authzed.api.v1.DiffSchemaRequest.class, responseType = com.authzed.api.v1.DiffSchemaResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.authzed.api.v1.DiffSchemaRequest, com.authzed.api.v1.DiffSchemaResponse> getDiffSchemaMethod() {
        io.grpc.MethodDescriptor<com.authzed.api.v1.DiffSchemaRequest, com.authzed.api.v1.DiffSchemaResponse> getDiffSchemaMethod;
        if ((getDiffSchemaMethod = SchemaServiceGrpc.getDiffSchemaMethod) == null) {
            synchronized (SchemaServiceGrpc.class) {
                if ((getDiffSchemaMethod = SchemaServiceGrpc.getDiffSchemaMethod) == null) {
                    SchemaServiceGrpc.getDiffSchemaMethod = getDiffSchemaMethod = io.grpc.MethodDescriptor.<com.authzed.api.v1.DiffSchemaRequest, com.authzed.api.v1.DiffSchemaResponse> newBuilder()
                            .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                            .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiffSchema"))
                            .setSampledToLocalTracing(true)
                            .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.DiffSchemaRequest.getDefaultInstance()))
                            .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                                    .marshaller(com.authzed.api.v1.DiffSchemaResponse.getDefaultInstance()))
                            .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("DiffSchema")).build();
                }
            }
        }
        return getDiffSchemaMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static SchemaServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<SchemaServiceStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceStub>() {

            @java.lang.Override
            public SchemaServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new SchemaServiceStub(channel, callOptions);
            }
        };
        return SchemaServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports all types of calls on the service
     */
    public static SchemaServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingV2Stub> factory = new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingV2Stub>() {

            @java.lang.Override
            public SchemaServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new SchemaServiceBlockingV2Stub(channel, callOptions);
            }
        };
        return SchemaServiceBlockingV2Stub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static SchemaServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingStub>() {

            @java.lang.Override
            public SchemaServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new SchemaServiceBlockingStub(channel, callOptions);
            }
        };
        return SchemaServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static SchemaServiceFutureStub newFutureStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<SchemaServiceFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceFutureStub>() {

            @java.lang.Override
            public SchemaServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new SchemaServiceFutureStub(channel, callOptions);
            }
        };
        return SchemaServiceFutureStub.newStub(factory, channel);
    }

    /**
     * <pre>
     * SchemaService implements operations on a Permissions System's Schema.
     * </pre>
     */
    public interface AsyncService {

        /**
         * <pre>
         * Read returns the current Object Definitions for a Permissions System.
         * Errors include:
         * - INVALID_ARGUMENT: a provided value has failed to semantically validate
         * - NOT_FOUND: no schema has been defined
         * </pre>
         */
        default void readSchema(com.authzed.api.v1.ReadSchemaRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadSchemaResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadSchemaMethod(), responseObserver);
        }

        /**
         * <pre>
         * Write overwrites the current Object Definitions for a Permissions System.
         * </pre>
         */
        default void writeSchema(com.authzed.api.v1.WriteSchemaRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteSchemaResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteSchemaMethod(), responseObserver);
        }

        /**
         * <pre>
         * ReflectSchema reflects the current schema stored in SpiceDB, returning a structural
         * form of the schema for use by client tooling.
         * </pre>
         */
        default void reflectSchema(com.authzed.api.v1.ReflectSchemaRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ReflectSchemaResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReflectSchemaMethod(), responseObserver);
        }

        /**
         * <pre>
         * ComputablePermissions returns the set of permissions that compute based off a relation
         * in the current schema. For example, if the schema has a relation `viewer` and a permission
         * `view` defined as `permission view = viewer + editor`, then the
         * computable permissions for the relation `viewer` will include `view`.
         * </pre>
         */
        default void computablePermissions(com.authzed.api.v1.ComputablePermissionsRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ComputablePermissionsResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputablePermissionsMethod(), responseObserver);
        }

        /**
         * <pre>
         * DependentRelations returns the set of relations and permissions that used
         * to compute a permission, recursively, in the current schema. It is the
         * inverse of the ComputablePermissions API.
         * </pre>
         */
        default void dependentRelations(com.authzed.api.v1.DependentRelationsRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.DependentRelationsResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDependentRelationsMethod(), responseObserver);
        }

        /**
         * <pre>
         * DiffSchema returns the difference between the specified schema and the current
         * schema stored in SpiceDB.
         * </pre>
         */
        default void diffSchema(com.authzed.api.v1.DiffSchemaRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.DiffSchemaResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDiffSchemaMethod(), responseObserver);
        }
    }

    /**
     * Base class for the server implementation of the service SchemaService.
     *
     * <pre>
     * SchemaService implements operations on a Permissions System's Schema.
     * </pre>
     */
    public static abstract class SchemaServiceImplBase implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return SchemaServiceGrpc.bindService(this);
        }
    }

    /**
     * A stub to allow clients to do asynchronous rpc calls to service SchemaService.
     *
     * <pre>
     * SchemaService implements operations on a Permissions System's Schema.
     * </pre>
     */
    public static class SchemaServiceStub extends io.grpc.stub.AbstractAsyncStub<SchemaServiceStub> {

        private SchemaServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SchemaServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SchemaServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * Read returns the current Object Definitions for a Permissions System.
         * Errors include:
         * - INVALID_ARGUMENT: a provided value has failed to semantically validate
         * - NOT_FOUND: no schema has been defined
         * </pre>
         */
        public void readSchema(com.authzed.api.v1.ReadSchemaRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadSchemaResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getReadSchemaMethod(), getCallOptions()), request,
                    responseObserver);
        }

        /**
         * <pre>
         * Write overwrites the current Object Definitions for a Permissions System.
         * </pre>
         */
        public void writeSchema(com.authzed.api.v1.WriteSchemaRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteSchemaResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getWriteSchemaMethod(), getCallOptions()), request,
                    responseObserver);
        }

        /**
         * <pre>
         * ReflectSchema reflects the current schema stored in SpiceDB, returning a structural
         * form of the schema for use by client tooling.
         * </pre>
         */
        public void reflectSchema(com.authzed.api.v1.ReflectSchemaRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ReflectSchemaResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getReflectSchemaMethod(), getCallOptions()), request,
                    responseObserver);
        }

        /**
         * <pre>
         * ComputablePermissions returns the set of permissions that compute based off a relation
         * in the current schema. For example, if the schema has a relation `viewer` and a permission
         * `view` defined as `permission view = viewer + editor`, then the
         * computable permissions for the relation `viewer` will include `view`.
         * </pre>
         */
        public void computablePermissions(com.authzed.api.v1.ComputablePermissionsRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.ComputablePermissionsResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getComputablePermissionsMethod(), getCallOptions()),
                    request, responseObserver);
        }

        /**
         * <pre>
         * DependentRelations returns the set of relations and permissions that used
         * to compute a permission, recursively, in the current schema. It is the
         * inverse of the ComputablePermissions API.
         * </pre>
         */
        public void dependentRelations(com.authzed.api.v1.DependentRelationsRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.DependentRelationsResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getDependentRelationsMethod(), getCallOptions()),
                    request, responseObserver);
        }

        /**
         * <pre>
         * DiffSchema returns the difference between the specified schema and the current
         * schema stored in SpiceDB.
         * </pre>
         */
        public void diffSchema(com.authzed.api.v1.DiffSchemaRequest request,
                io.grpc.stub.StreamObserver<com.authzed.api.v1.DiffSchemaResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getDiffSchemaMethod(), getCallOptions()), request,
                    responseObserver);
        }
    }

    /**
     * A stub to allow clients to do synchronous rpc calls to service SchemaService.
     *
     * <pre>
     * SchemaService implements operations on a Permissions System's Schema.
     * </pre>
     */
    public static class SchemaServiceBlockingV2Stub extends io.grpc.stub.AbstractBlockingStub<SchemaServiceBlockingV2Stub> {

        private SchemaServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SchemaServiceBlockingV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SchemaServiceBlockingV2Stub(channel, callOptions);
        }

        /**
         * <pre>
         * Read returns the current Object Definitions for a Permissions System.
         * Errors include:
         * - INVALID_ARGUMENT: a provided value has failed to semantically validate
         * - NOT_FOUND: no schema has been defined
         * </pre>
         */
        public com.authzed.api.v1.ReadSchemaResponse readSchema(com.authzed.api.v1.ReadSchemaRequest request)
                throws io.grpc.StatusException {
            return io.grpc.stub.ClientCalls.blockingV2UnaryCall(getChannel(), getReadSchemaMethod(), getCallOptions(), request);
        }

        /**
         * <pre>
         * Write overwrites the current Object Definitions for a Permissions System.
         * </pre>
         */
        public com.authzed.api.v1.WriteSchemaResponse writeSchema(com.authzed.api.v1.WriteSchemaRequest request)
                throws io.grpc.StatusException {
            return io.grpc.stub.ClientCalls.blockingV2UnaryCall(getChannel(), getWriteSchemaMethod(), getCallOptions(),
                    request);
        }

        /**
         * <pre>
         * ReflectSchema reflects the current schema stored in SpiceDB, returning a structural
         * form of the schema for use by client tooling.
         * </pre>
         */
        public com.authzed.api.v1.ReflectSchemaResponse reflectSchema(com.authzed.api.v1.ReflectSchemaRequest request)
                throws io.grpc.StatusException {
            return io.grpc.stub.ClientCalls.blockingV2UnaryCall(getChannel(), getReflectSchemaMethod(), getCallOptions(),
                    request);
        }

        /**
         * <pre>
         * ComputablePermissions returns the set of permissions that compute based off a relation
         * in the current schema. For example, if the schema has a relation `viewer` and a permission
         * `view` defined as `permission view = viewer + editor`, then the
         * computable permissions for the relation `viewer` will include `view`.
         * </pre>
         */
        public com.authzed.api.v1.ComputablePermissionsResponse computablePermissions(
                com.authzed.api.v1.ComputablePermissionsRequest request) throws io.grpc.StatusException {
            return io.grpc.stub.ClientCalls.blockingV2UnaryCall(getChannel(), getComputablePermissionsMethod(),
                    getCallOptions(), request);
        }

        /**
         * <pre>
         * DependentRelations returns the set of relations and permissions that used
         * to compute a permission, recursively, in the current schema. It is the
         * inverse of the ComputablePermissions API.
         * </pre>
         */
        public com.authzed.api.v1.DependentRelationsResponse dependentRelations(
                com.authzed.api.v1.DependentRelationsRequest request) throws io.grpc.StatusException {
            return io.grpc.stub.ClientCalls.blockingV2UnaryCall(getChannel(), getDependentRelationsMethod(), getCallOptions(),
                    request);
        }

        /**
         * <pre>
         * DiffSchema returns the difference between the specified schema and the current
         * schema stored in SpiceDB.
         * </pre>
         */
        public com.authzed.api.v1.DiffSchemaResponse diffSchema(com.authzed.api.v1.DiffSchemaRequest request)
                throws io.grpc.StatusException {
            return io.grpc.stub.ClientCalls.blockingV2UnaryCall(getChannel(), getDiffSchemaMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do limited synchronous rpc calls to service SchemaService.
     *
     * <pre>
     * SchemaService implements operations on a Permissions System's Schema.
     * </pre>
     */
    public static class SchemaServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SchemaServiceBlockingStub> {

        private SchemaServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SchemaServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SchemaServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * Read returns the current Object Definitions for a Permissions System.
         * Errors include:
         * - INVALID_ARGUMENT: a provided value has failed to semantically validate
         * - NOT_FOUND: no schema has been defined
         * </pre>
         */
        public com.authzed.api.v1.ReadSchemaResponse readSchema(com.authzed.api.v1.ReadSchemaRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getReadSchemaMethod(), getCallOptions(), request);
        }

        /**
         * <pre>
         * Write overwrites the current Object Definitions for a Permissions System.
         * </pre>
         */
        public com.authzed.api.v1.WriteSchemaResponse writeSchema(com.authzed.api.v1.WriteSchemaRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getWriteSchemaMethod(), getCallOptions(), request);
        }

        /**
         * <pre>
         * ReflectSchema reflects the current schema stored in SpiceDB, returning a structural
         * form of the schema for use by client tooling.
         * </pre>
         */
        public com.authzed.api.v1.ReflectSchemaResponse reflectSchema(com.authzed.api.v1.ReflectSchemaRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getReflectSchemaMethod(), getCallOptions(),
                    request);
        }

        /**
         * <pre>
         * ComputablePermissions returns the set of permissions that compute based off a relation
         * in the current schema. For example, if the schema has a relation `viewer` and a permission
         * `view` defined as `permission view = viewer + editor`, then the
         * computable permissions for the relation `viewer` will include `view`.
         * </pre>
         */
        public com.authzed.api.v1.ComputablePermissionsResponse computablePermissions(
                com.authzed.api.v1.ComputablePermissionsRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getComputablePermissionsMethod(), getCallOptions(),
                    request);
        }

        /**
         * <pre>
         * DependentRelations returns the set of relations and permissions that used
         * to compute a permission, recursively, in the current schema. It is the
         * inverse of the ComputablePermissions API.
         * </pre>
         */
        public com.authzed.api.v1.DependentRelationsResponse dependentRelations(
                com.authzed.api.v1.DependentRelationsRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getDependentRelationsMethod(), getCallOptions(),
                    request);
        }

        /**
         * <pre>
         * DiffSchema returns the difference between the specified schema and the current
         * schema stored in SpiceDB.
         * </pre>
         */
        public com.authzed.api.v1.DiffSchemaResponse diffSchema(com.authzed.api.v1.DiffSchemaRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getDiffSchemaMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do ListenableFuture-style rpc calls to service SchemaService.
     *
     * <pre>
     * SchemaService implements operations on a Permissions System's Schema.
     * </pre>
     */
    public static class SchemaServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SchemaServiceFutureStub> {

        private SchemaServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SchemaServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SchemaServiceFutureStub(channel, callOptions);
        }

        /**
         * <pre>
         * Read returns the current Object Definitions for a Permissions System.
         * Errors include:
         * - INVALID_ARGUMENT: a provided value has failed to semantically validate
         * - NOT_FOUND: no schema has been defined
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ReadSchemaResponse> readSchema(
                com.authzed.api.v1.ReadSchemaRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getReadSchemaMethod(), getCallOptions()),
                    request);
        }

        /**
         * <pre>
         * Write overwrites the current Object Definitions for a Permissions System.
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.WriteSchemaResponse> writeSchema(
                com.authzed.api.v1.WriteSchemaRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getWriteSchemaMethod(), getCallOptions()),
                    request);
        }

        /**
         * <pre>
         * ReflectSchema reflects the current schema stored in SpiceDB, returning a structural
         * form of the schema for use by client tooling.
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ReflectSchemaResponse> reflectSchema(
                com.authzed.api.v1.ReflectSchemaRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getReflectSchemaMethod(), getCallOptions()),
                    request);
        }

        /**
         * <pre>
         * ComputablePermissions returns the set of permissions that compute based off a relation
         * in the current schema. For example, if the schema has a relation `viewer` and a permission
         * `view` defined as `permission view = viewer + editor`, then the
         * computable permissions for the relation `viewer` will include `view`.
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ComputablePermissionsResponse> computablePermissions(
                com.authzed.api.v1.ComputablePermissionsRequest request) {
            return io.grpc.stub.ClientCalls
                    .futureUnaryCall(getChannel().newCall(getComputablePermissionsMethod(), getCallOptions()), request);
        }

        /**
         * <pre>
         * DependentRelations returns the set of relations and permissions that used
         * to compute a permission, recursively, in the current schema. It is the
         * inverse of the ComputablePermissions API.
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.DependentRelationsResponse> dependentRelations(
                com.authzed.api.v1.DependentRelationsRequest request) {
            return io.grpc.stub.ClientCalls
                    .futureUnaryCall(getChannel().newCall(getDependentRelationsMethod(), getCallOptions()), request);
        }

        /**
         * <pre>
         * DiffSchema returns the difference between the specified schema and the current
         * schema stored in SpiceDB.
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.DiffSchemaResponse> diffSchema(
                com.authzed.api.v1.DiffSchemaRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getDiffSchemaMethod(), getCallOptions()),
                    request);
        }
    }

    private static final int METHODID_READ_SCHEMA = 0;

    private static final int METHODID_WRITE_SCHEMA = 1;

    private static final int METHODID_REFLECT_SCHEMA = 2;

    private static final int METHODID_COMPUTABLE_PERMISSIONS = 3;

    private static final int METHODID_DEPENDENT_RELATIONS = 4;

    private static final int METHODID_DIFF_SCHEMA = 5;

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
                case METHODID_READ_SCHEMA:
                    serviceImpl.readSchema((com.authzed.api.v1.ReadSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadSchemaResponse>) responseObserver);
                    break;
                case METHODID_WRITE_SCHEMA:
                    serviceImpl.writeSchema((com.authzed.api.v1.WriteSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteSchemaResponse>) responseObserver);
                    break;
                case METHODID_REFLECT_SCHEMA:
                    serviceImpl.reflectSchema((com.authzed.api.v1.ReflectSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ReflectSchemaResponse>) responseObserver);
                    break;
                case METHODID_COMPUTABLE_PERMISSIONS:
                    serviceImpl.computablePermissions((com.authzed.api.v1.ComputablePermissionsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ComputablePermissionsResponse>) responseObserver);
                    break;
                case METHODID_DEPENDENT_RELATIONS:
                    serviceImpl.dependentRelations((com.authzed.api.v1.DependentRelationsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.DependentRelationsResponse>) responseObserver);
                    break;
                case METHODID_DIFF_SCHEMA:
                    serviceImpl.diffSchema((com.authzed.api.v1.DiffSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.DiffSchemaResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    public static io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getReadSchemaMethod(),
                io.grpc.stub.ServerCalls.asyncUnaryCall(
                        new MethodHandlers<com.authzed.api.v1.ReadSchemaRequest, com.authzed.api.v1.ReadSchemaResponse>(service,
                                METHODID_READ_SCHEMA)))
                .addMethod(getWriteSchemaMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(
                        new MethodHandlers<com.authzed.api.v1.WriteSchemaRequest, com.authzed.api.v1.WriteSchemaResponse>(
                                service, METHODID_WRITE_SCHEMA)))
                .addMethod(getReflectSchemaMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(
                        new MethodHandlers<com.authzed.api.v1.ReflectSchemaRequest, com.authzed.api.v1.ReflectSchemaResponse>(
                                service, METHODID_REFLECT_SCHEMA)))
                .addMethod(getComputablePermissionsMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(
                        new MethodHandlers<com.authzed.api.v1.ComputablePermissionsRequest, com.authzed.api.v1.ComputablePermissionsResponse>(
                                service, METHODID_COMPUTABLE_PERMISSIONS)))
                .addMethod(getDependentRelationsMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(
                        new MethodHandlers<com.authzed.api.v1.DependentRelationsRequest, com.authzed.api.v1.DependentRelationsResponse>(
                                service, METHODID_DEPENDENT_RELATIONS)))
                .addMethod(getDiffSchemaMethod(),
                        io.grpc.stub.ServerCalls.asyncUnaryCall(
                                new MethodHandlers<com.authzed.api.v1.DiffSchemaRequest, com.authzed.api.v1.DiffSchemaResponse>(
                                        service, METHODID_DIFF_SCHEMA)))
                .build();
    }

    private static abstract class SchemaServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {

        SchemaServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.authzed.api.v1.SchemaServiceOuterClass.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("SchemaService");
        }
    }

    private static final class SchemaServiceFileDescriptorSupplier extends SchemaServiceBaseDescriptorSupplier {

        SchemaServiceFileDescriptorSupplier() {
        }
    }

    private static final class SchemaServiceMethodDescriptorSupplier extends SchemaServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {

        private final java.lang.String methodName;

        SchemaServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
            synchronized (SchemaServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new SchemaServiceFileDescriptorSupplier()).addMethod(getReadSchemaMethod())
                            .addMethod(getWriteSchemaMethod()).addMethod(getReflectSchemaMethod())
                            .addMethod(getComputablePermissionsMethod()).addMethod(getDependentRelationsMethod())
                            .addMethod(getDiffSchemaMethod()).build();
                }
            }
        }
        return result;
    }
}
