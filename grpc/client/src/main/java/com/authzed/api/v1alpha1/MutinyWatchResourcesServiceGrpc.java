package com.authzed.api.v1alpha1;

import static com.authzed.api.v1alpha1.WatchResourcesServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1alpha1/watchresources_service.proto")
public final class MutinyWatchResourcesServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyWatchResourcesServiceGrpc() {
    }

    public static MutinyWatchResourcesServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyWatchResourcesServiceStub(channel);
    }

    /**
     * <pre>
     *  WatchResourcesService is used to receive a stream of updates for resources of a
     *  specific (resource type, permission, subject) combination.
     * </pre>
     */
    public static class MutinyWatchResourcesServiceStub extends io.grpc.stub.AbstractStub<MutinyWatchResourcesServiceStub>
            implements io.quarkus.grpc.MutinyStub {

        private WatchResourcesServiceGrpc.WatchResourcesServiceStub delegateStub;

        private MutinyWatchResourcesServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = WatchResourcesServiceGrpc.newStub(channel);
        }

        private MutinyWatchResourcesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = WatchResourcesServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyWatchResourcesServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyWatchResourcesServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         *  WatchResources initiates a watch for permission changes for the provided
         *  (resource type, permission, subject) pair.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesResponse> watchResources(
                com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::watchResources);
        }
    }

    /**
     * <pre>
     *  WatchResourcesService is used to receive a stream of updates for resources of a
     *  specific (resource type, permission, subject) combination.
     * </pre>
     */
    public static abstract class WatchResourcesServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public WatchResourcesServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        /**
         * <pre>
         *  WatchResources initiates a watch for permission changes for the provided
         *  (resource type, permission, subject) pair.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesResponse> watchResources(
                com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(
                    com.authzed.api.v1alpha1.WatchResourcesServiceGrpc.getWatchResourcesMethod(),
                    asyncServerStreamingCall(
                            new MethodHandlers<com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesRequest, com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesResponse>(
                                    this, METHODID_WATCH_RESOURCES, compression)))
                    .build();
        }
    }

    private static final int METHODID_WATCH_RESOURCES = 0;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final WatchResourcesServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(WatchResourcesServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_WATCH_RESOURCES:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany(
                            (com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesResponse>) responseObserver,
                            compression, serviceImpl::watchResources);
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
