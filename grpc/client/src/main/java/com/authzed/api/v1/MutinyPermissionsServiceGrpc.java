package com.authzed.api.v1;

import static com.authzed.api.v1.PermissionsServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/permission_service.proto")
public final class MutinyPermissionsServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyPermissionsServiceGrpc() {
    }

    public static MutinyPermissionsServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyPermissionsServiceStub(channel);
    }

    /**
     * <pre>
     *  PermissionsService implements a set of RPCs that perform operations on
     *  relationships and permissions.
     * </pre>
     */
    public static class MutinyPermissionsServiceStub extends io.grpc.stub.AbstractStub<MutinyPermissionsServiceStub>
            implements io.quarkus.grpc.MutinyStub {

        private PermissionsServiceGrpc.PermissionsServiceStub delegateStub;

        private MutinyPermissionsServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = PermissionsServiceGrpc.newStub(channel);
        }

        private MutinyPermissionsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = PermissionsServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyPermissionsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyPermissionsServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         *  WriteRelationships atomically writes and/or deletes a set of specified
         *  relationships. An optional set of preconditions can be provided that must
         *  be satisfied for the operation to commit.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.WriteRelationshipsResponse> writeRelationships(
                com.authzed.api.v1.PermissionService.WriteRelationshipsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::writeRelationships);
        }

        /**
         * <pre>
         *  DeleteRelationships atomically bulk deletes all relationships matching the
         *  provided filter. If no relationships match, none will be deleted and the
         *  operation will succeed. An optional set of preconditions can be provided that must
         *  be satisfied for the operation to commit.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.DeleteRelationshipsResponse> deleteRelationships(
                com.authzed.api.v1.PermissionService.DeleteRelationshipsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::deleteRelationships);
        }

        /**
         * <pre>
         *  CheckPermission determines for a given resource whether a subject computes
         *  to having a permission or is a direct member of a particular relation.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.CheckPermissionResponse> checkPermission(
                com.authzed.api.v1.PermissionService.CheckPermissionRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::checkPermission);
        }

        /**
         * <pre>
         *  ExpandPermissionTree reveals the graph structure for a resource&#39;s
         *  permission or relation. This RPC does not recurse infinitely deep and may
         *  require multiple calls to fully unnest a deeply nested graph.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.ExpandPermissionTreeResponse> expandPermissionTree(
                com.authzed.api.v1.PermissionService.ExpandPermissionTreeRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::expandPermissionTree);
        }

        /**
         * <pre>
         *  ReadRelationships reads a set of the relationships matching one or more
         *  filters.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.ReadRelationshipsResponse> readRelationships(
                com.authzed.api.v1.PermissionService.ReadRelationshipsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::readRelationships);
        }

        /**
         * <pre>
         *  LookupResources returns all the resources of a given type that a subject
         *  can access whether via a computed permission or relation membership.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupResourcesResponse> lookupResources(
                com.authzed.api.v1.PermissionService.LookupResourcesRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::lookupResources);
        }

        /**
         * <pre>
         *  LookupSubjects returns all the subjects of a given type that
         *  have access whether via a computed permission or relation membership.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupSubjectsResponse> lookupSubjects(
                com.authzed.api.v1.PermissionService.LookupSubjectsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::lookupSubjects);
        }
    }

    /**
     * <pre>
     *  PermissionsService implements a set of RPCs that perform operations on
     *  relationships and permissions.
     * </pre>
     */
    public static abstract class PermissionsServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public PermissionsServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        /**
         * <pre>
         *  WriteRelationships atomically writes and/or deletes a set of specified
         *  relationships. An optional set of preconditions can be provided that must
         *  be satisfied for the operation to commit.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.WriteRelationshipsResponse> writeRelationships(
                com.authzed.api.v1.PermissionService.WriteRelationshipsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  DeleteRelationships atomically bulk deletes all relationships matching the
         *  provided filter. If no relationships match, none will be deleted and the
         *  operation will succeed. An optional set of preconditions can be provided that must
         *  be satisfied for the operation to commit.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.DeleteRelationshipsResponse> deleteRelationships(
                com.authzed.api.v1.PermissionService.DeleteRelationshipsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  CheckPermission determines for a given resource whether a subject computes
         *  to having a permission or is a direct member of a particular relation.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.CheckPermissionResponse> checkPermission(
                com.authzed.api.v1.PermissionService.CheckPermissionRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  ExpandPermissionTree reveals the graph structure for a resource&#39;s
         *  permission or relation. This RPC does not recurse infinitely deep and may
         *  require multiple calls to fully unnest a deeply nested graph.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.v1.PermissionService.ExpandPermissionTreeResponse> expandPermissionTree(
                com.authzed.api.v1.PermissionService.ExpandPermissionTreeRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  ReadRelationships reads a set of the relationships matching one or more
         *  filters.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.ReadRelationshipsResponse> readRelationships(
                com.authzed.api.v1.PermissionService.ReadRelationshipsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  LookupResources returns all the resources of a given type that a subject
         *  can access whether via a computed permission or relation membership.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupResourcesResponse> lookupResources(
                com.authzed.api.v1.PermissionService.LookupResourcesRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  LookupSubjects returns all the subjects of a given type that
         *  have access whether via a computed permission or relation membership.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.PermissionService.LookupSubjectsResponse> lookupSubjects(
                com.authzed.api.v1.PermissionService.LookupSubjectsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(com.authzed.api.v1.PermissionsServiceGrpc.getReadRelationshipsMethod(), asyncServerStreamingCall(
                            new MethodHandlers<com.authzed.api.v1.PermissionService.ReadRelationshipsRequest, com.authzed.api.v1.PermissionService.ReadRelationshipsResponse>(
                                    this, METHODID_READ_RELATIONSHIPS, compression)))
                    .addMethod(com.authzed.api.v1.PermissionsServiceGrpc.getWriteRelationshipsMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.PermissionService.WriteRelationshipsRequest, com.authzed.api.v1.PermissionService.WriteRelationshipsResponse>(
                                    this, METHODID_WRITE_RELATIONSHIPS, compression)))
                    .addMethod(com.authzed.api.v1.PermissionsServiceGrpc.getDeleteRelationshipsMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.PermissionService.DeleteRelationshipsRequest, com.authzed.api.v1.PermissionService.DeleteRelationshipsResponse>(
                                    this, METHODID_DELETE_RELATIONSHIPS, compression)))
                    .addMethod(com.authzed.api.v1.PermissionsServiceGrpc.getCheckPermissionMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.PermissionService.CheckPermissionRequest, com.authzed.api.v1.PermissionService.CheckPermissionResponse>(
                                    this, METHODID_CHECK_PERMISSION, compression)))
                    .addMethod(com.authzed.api.v1.PermissionsServiceGrpc.getExpandPermissionTreeMethod(), asyncUnaryCall(
                            new MethodHandlers<com.authzed.api.v1.PermissionService.ExpandPermissionTreeRequest, com.authzed.api.v1.PermissionService.ExpandPermissionTreeResponse>(
                                    this, METHODID_EXPAND_PERMISSION_TREE, compression)))
                    .addMethod(com.authzed.api.v1.PermissionsServiceGrpc.getLookupResourcesMethod(), asyncServerStreamingCall(
                            new MethodHandlers<com.authzed.api.v1.PermissionService.LookupResourcesRequest, com.authzed.api.v1.PermissionService.LookupResourcesResponse>(
                                    this, METHODID_LOOKUP_RESOURCES, compression)))
                    .addMethod(com.authzed.api.v1.PermissionsServiceGrpc.getLookupSubjectsMethod(), asyncServerStreamingCall(
                            new MethodHandlers<com.authzed.api.v1.PermissionService.LookupSubjectsRequest, com.authzed.api.v1.PermissionService.LookupSubjectsResponse>(
                                    this, METHODID_LOOKUP_SUBJECTS, compression)))
                    .build();
        }
    }

    private static final int METHODID_READ_RELATIONSHIPS = 0;

    private static final int METHODID_WRITE_RELATIONSHIPS = 1;

    private static final int METHODID_DELETE_RELATIONSHIPS = 2;

    private static final int METHODID_CHECK_PERMISSION = 3;

    private static final int METHODID_EXPAND_PERMISSION_TREE = 4;

    private static final int METHODID_LOOKUP_RESOURCES = 5;

    private static final int METHODID_LOOKUP_SUBJECTS = 6;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final PermissionsServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(PermissionsServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_READ_RELATIONSHIPS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany(
                            (com.authzed.api.v1.PermissionService.ReadRelationshipsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.PermissionService.ReadRelationshipsResponse>) responseObserver,
                            compression, serviceImpl::readRelationships);
                    break;
                case METHODID_WRITE_RELATIONSHIPS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.PermissionService.WriteRelationshipsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.PermissionService.WriteRelationshipsResponse>) responseObserver,
                            compression, serviceImpl::writeRelationships);
                    break;
                case METHODID_DELETE_RELATIONSHIPS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.PermissionService.DeleteRelationshipsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.PermissionService.DeleteRelationshipsResponse>) responseObserver,
                            compression, serviceImpl::deleteRelationships);
                    break;
                case METHODID_CHECK_PERMISSION:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.PermissionService.CheckPermissionRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.PermissionService.CheckPermissionResponse>) responseObserver,
                            compression, serviceImpl::checkPermission);
                    break;
                case METHODID_EXPAND_PERMISSION_TREE:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.v1.PermissionService.ExpandPermissionTreeRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.PermissionService.ExpandPermissionTreeResponse>) responseObserver,
                            compression, serviceImpl::expandPermissionTree);
                    break;
                case METHODID_LOOKUP_RESOURCES:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany(
                            (com.authzed.api.v1.PermissionService.LookupResourcesRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.PermissionService.LookupResourcesResponse>) responseObserver,
                            compression, serviceImpl::lookupResources);
                    break;
                case METHODID_LOOKUP_SUBJECTS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany(
                            (com.authzed.api.v1.PermissionService.LookupSubjectsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.PermissionService.LookupSubjectsResponse>) responseObserver,
                            compression, serviceImpl::lookupSubjects);
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
