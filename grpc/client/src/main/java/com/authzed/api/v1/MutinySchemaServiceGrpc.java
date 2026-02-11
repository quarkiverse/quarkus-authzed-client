package com.authzed.api.v1;

import static com.authzed.api.v1.SchemaServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/schema_service.proto")
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
         *  - NOT_FOUND: no schema has been defined
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ReadSchemaResponse> readSchema(
                com.authzed.api.v1.ReadSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::readSchema);
        }

        /**
         * <pre>
         *  Write overwrites the current Object Definitions for a Permissions System.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.WriteSchemaResponse> writeSchema(
                com.authzed.api.v1.WriteSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::writeSchema);
        }

        /**
         * <pre>
         *  ReflectSchema reflects the current schema stored in SpiceDB, returning a structural
         *  form of the schema for use by client tooling.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ReflectSchemaResponse> reflectSchema(
                com.authzed.api.v1.ReflectSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::reflectSchema);
        }

        /**
         * <pre>
         *  ComputablePermissions returns the set of permissions that compute based off a relation
         *  in the current schema. For example, if the schema has a relation `viewer` and a permission
         *  `view` defined as `permission view = viewer + editor`, then the
         *  computable permissions for the relation `viewer` will include `view`.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ComputablePermissionsResponse> computablePermissions(
                com.authzed.api.v1.ComputablePermissionsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::computablePermissions);
        }

        /**
         * <pre>
         *  DependentRelations returns the set of relations and permissions that used
         *  to compute a permission, recursively, in the current schema. It is the
         *  inverse of the ComputablePermissions API.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.DependentRelationsResponse> dependentRelations(
                com.authzed.api.v1.DependentRelationsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::dependentRelations);
        }

        /**
         * <pre>
         *  DiffSchema returns the difference between the specified schema and the current
         *  schema stored in SpiceDB.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.DiffSchemaResponse> diffSchema(
                com.authzed.api.v1.DiffSchemaRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::diffSchema);
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
         *  - NOT_FOUND: no schema has been defined
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ReadSchemaResponse> readSchema(
                com.authzed.api.v1.ReadSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  Write overwrites the current Object Definitions for a Permissions System.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.WriteSchemaResponse> writeSchema(
                com.authzed.api.v1.WriteSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  ReflectSchema reflects the current schema stored in SpiceDB, returning a structural
         *  form of the schema for use by client tooling.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ReflectSchemaResponse> reflectSchema(
                com.authzed.api.v1.ReflectSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  ComputablePermissions returns the set of permissions that compute based off a relation
         *  in the current schema. For example, if the schema has a relation `viewer` and a permission
         *  `view` defined as `permission view = viewer + editor`, then the
         *  computable permissions for the relation `viewer` will include `view`.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.ComputablePermissionsResponse> computablePermissions(
                com.authzed.api.v1.ComputablePermissionsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DependentRelations returns the set of relations and permissions that used
         *  to compute a permission, recursively, in the current schema. It is the
         *  inverse of the ComputablePermissions API.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.DependentRelationsResponse> dependentRelations(
                com.authzed.api.v1.DependentRelationsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DiffSchema returns the difference between the specified schema and the current
         *  schema stored in SpiceDB.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.DiffSchemaResponse> diffSchema(
                com.authzed.api.v1.DiffSchemaRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(com.authzed.api.v1.SchemaServiceGrpc.getReadSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.ReadSchemaRequest, com.authzed.api.v1.ReadSchemaResponse>(
                                    this, METHODID_READ_SCHEMA, compression)))
                    .addMethod(com.authzed.api.v1.SchemaServiceGrpc.getWriteSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.WriteSchemaRequest, com.authzed.api.v1.WriteSchemaResponse>(
                                    this, METHODID_WRITE_SCHEMA, compression)))
                    .addMethod(com.authzed.api.v1.SchemaServiceGrpc.getReflectSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.ReflectSchemaRequest, com.authzed.api.v1.ReflectSchemaResponse>(
                                    this, METHODID_REFLECT_SCHEMA, compression)))
                    .addMethod(com.authzed.api.v1.SchemaServiceGrpc.getComputablePermissionsMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.ComputablePermissionsRequest, com.authzed.api.v1.ComputablePermissionsResponse>(
                                    this, METHODID_COMPUTABLE_PERMISSIONS, compression)))
                    .addMethod(com.authzed.api.v1.SchemaServiceGrpc.getDependentRelationsMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.DependentRelationsRequest, com.authzed.api.v1.DependentRelationsResponse>(
                                    this, METHODID_DEPENDENT_RELATIONS, compression)))
                    .addMethod(com.authzed.api.v1.SchemaServiceGrpc.getDiffSchemaMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.DiffSchemaRequest, com.authzed.api.v1.DiffSchemaResponse>(
                                    this, METHODID_DIFF_SCHEMA, compression)))
                    .build();
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
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.ReadSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadSchemaResponse>) responseObserver, compression,
                            serviceImpl::readSchema);
                    break;
                case METHODID_WRITE_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.WriteSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteSchemaResponse>) responseObserver, compression,
                            serviceImpl::writeSchema);
                    break;
                case METHODID_REFLECT_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.ReflectSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ReflectSchemaResponse>) responseObserver,
                            compression, serviceImpl::reflectSchema);
                    break;
                case METHODID_COMPUTABLE_PERMISSIONS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.ComputablePermissionsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.ComputablePermissionsResponse>) responseObserver,
                            compression, serviceImpl::computablePermissions);
                    break;
                case METHODID_DEPENDENT_RELATIONS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.DependentRelationsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.DependentRelationsResponse>) responseObserver,
                            compression, serviceImpl::dependentRelations);
                    break;
                case METHODID_DIFF_SCHEMA:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.authzed.api.v1.DiffSchemaRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.DiffSchemaResponse>) responseObserver, compression,
                            serviceImpl::diffSchema);
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
