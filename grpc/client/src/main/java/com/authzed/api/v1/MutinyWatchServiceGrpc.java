package com.authzed.api.v1;

import static com.authzed.api.v1.WatchServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/watch_service.proto")
public final class MutinyWatchServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyWatchServiceGrpc() {
    }

    public static MutinyWatchServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyWatchServiceStub(channel);
    }

    public static class MutinyWatchServiceStub extends io.grpc.stub.AbstractStub<MutinyWatchServiceStub>
            implements io.quarkus.grpc.MutinyStub {

        private WatchServiceGrpc.WatchServiceStub delegateStub;

        private MutinyWatchServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = WatchServiceGrpc.newStub(channel);
        }

        private MutinyWatchServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = WatchServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyWatchServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyWatchServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         *  Watch returns a stream of events that occurred in the datastore in ascending timestamp order.
         *  The events can be relationship updates, schema updates, or checkpoints.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.WatchResponse> watch(com.authzed.api.v1.WatchRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::watch);
        }
    }

    public static abstract class WatchServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public WatchServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        /**
         * <pre>
         *  Watch returns a stream of events that occurred in the datastore in ascending timestamp order.
         *  The events can be relationship updates, schema updates, or checkpoints.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.v1.WatchResponse> watch(com.authzed.api.v1.WatchRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(com.authzed.api.v1.WatchServiceGrpc.getWatchMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<com.authzed.api.v1.WatchRequest, com.authzed.api.v1.WatchResponse>(this,
                                            METHODID_WATCH, compression)))
                    .build();
        }
    }

    private static final int METHODID_WATCH = 0;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final WatchServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(WatchServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_WATCH:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany((com.authzed.api.v1.WatchRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.v1.WatchResponse>) responseObserver, compression,
                            serviceImpl::watch);
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
