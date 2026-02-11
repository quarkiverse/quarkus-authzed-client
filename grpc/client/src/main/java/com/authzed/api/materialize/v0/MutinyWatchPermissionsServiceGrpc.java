package com.authzed.api.materialize.v0;

import static com.authzed.api.materialize.v0.WatchPermissionsServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/materialize/v0/watchpermissions.proto")
public final class MutinyWatchPermissionsServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyWatchPermissionsServiceGrpc() {
    }

    public static MutinyWatchPermissionsServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyWatchPermissionsServiceStub(channel);
    }

    public static class MutinyWatchPermissionsServiceStub extends io.grpc.stub.AbstractStub<MutinyWatchPermissionsServiceStub>
            implements io.quarkus.grpc.MutinyStub {

        private WatchPermissionsServiceGrpc.WatchPermissionsServiceStub delegateStub;

        private MutinyWatchPermissionsServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = WatchPermissionsServiceGrpc.newStub(channel);
        }

        private MutinyWatchPermissionsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = WatchPermissionsServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyWatchPermissionsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyWatchPermissionsServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         *  WatchPermissions returns a stream of PermissionChange events for the given permissions.
         *
         *  WatchPermissions is a long-running RPC, and will stream events until the client
         *  closes the connection or the server terminates the stream. The consumer is responsible of
         *  keeping track of the last seen revision and resuming the stream from that point in the event
         *  of disconnection or client-side restarts.
         *
         *  The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
         *  Implementing an active-active HA consumer setup over the same target system will require coordinating which
         *  revisions have been consumed in order to prevent transitioning to an inconsistent state.
         *
         *  Usage of WatchPermissions requires to be explicitly enabled on the service, including the permissions to be
         *  watched. It requires more resources and is less performant than WatchPermissionsSets. It&#39;s usage
         *  is only recommended when performing the set intersections of WatchPermissionSets in the client side is not viable
         *  or there is a strict application requirement to use consume the computed permissions.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionsResponse> watchPermissions(
                com.authzed.api.materialize.v0.WatchPermissionsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::watchPermissions);
        }
    }

    public static abstract class WatchPermissionsServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public WatchPermissionsServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        /**
         * <pre>
         *  WatchPermissions returns a stream of PermissionChange events for the given permissions.
         *
         *  WatchPermissions is a long-running RPC, and will stream events until the client
         *  closes the connection or the server terminates the stream. The consumer is responsible of
         *  keeping track of the last seen revision and resuming the stream from that point in the event
         *  of disconnection or client-side restarts.
         *
         *  The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
         *  Implementing an active-active HA consumer setup over the same target system will require coordinating which
         *  revisions have been consumed in order to prevent transitioning to an inconsistent state.
         *
         *  Usage of WatchPermissions requires to be explicitly enabled on the service, including the permissions to be
         *  watched. It requires more resources and is less performant than WatchPermissionsSets. It&#39;s usage
         *  is only recommended when performing the set intersections of WatchPermissionSets in the client side is not viable
         *  or there is a strict application requirement to use consume the computed permissions.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionsResponse> watchPermissions(
                com.authzed.api.materialize.v0.WatchPermissionsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(
                    com.authzed.api.materialize.v0.WatchPermissionsServiceGrpc.getWatchPermissionsMethod(),
                    asyncServerStreamingCall(
                            new MethodHandlers<com.authzed.api.materialize.v0.WatchPermissionsRequest, com.authzed.api.materialize.v0.WatchPermissionsResponse>(
                                    this, METHODID_WATCH_PERMISSIONS, compression)))
                    .build();
        }
    }

    private static final int METHODID_WATCH_PERMISSIONS = 0;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final WatchPermissionsServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(WatchPermissionsServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_WATCH_PERMISSIONS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany(
                            (com.authzed.api.materialize.v0.WatchPermissionsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.WatchPermissionsResponse>) responseObserver,
                            compression, serviceImpl::watchPermissions);
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
