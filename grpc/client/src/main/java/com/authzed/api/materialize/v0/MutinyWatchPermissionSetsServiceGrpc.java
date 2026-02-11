package com.authzed.api.materialize.v0;

import static com.authzed.api.materialize.v0.WatchPermissionSetsServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/materialize/v0/watchpermissionsets.proto")
public final class MutinyWatchPermissionSetsServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyWatchPermissionSetsServiceGrpc() {
    }

    public static MutinyWatchPermissionSetsServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyWatchPermissionSetsServiceStub(channel);
    }

    public static class MutinyWatchPermissionSetsServiceStub
            extends io.grpc.stub.AbstractStub<MutinyWatchPermissionSetsServiceStub> implements io.quarkus.grpc.MutinyStub {

        private WatchPermissionSetsServiceGrpc.WatchPermissionSetsServiceStub delegateStub;

        private MutinyWatchPermissionSetsServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = WatchPermissionSetsServiceGrpc.newStub(channel);
        }

        private MutinyWatchPermissionSetsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = WatchPermissionSetsServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyWatchPermissionSetsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyWatchPermissionSetsServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         *  DownloadPermissionSets returns URLs to download permission sets data as Avro files.
         *  This provides an alternative to LookupPermissionSets for customers who need to download
         *  large datasets efficiently. The returned URLs point to compressed Avro files containing
         *  the permission sets data in a normalized format.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.materialize.v0.DownloadPermissionSetsResponse> downloadPermissionSets(
                com.authzed.api.materialize.v0.DownloadPermissionSetsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::downloadPermissionSets);
        }

        /**
         * <pre>
         *  WatchPermissionSets returns a stream of changes to the sets which can be used to compute the watched permissions.
         *
         *  WatchPermissionSets lets consumers achieve the same thing as WatchPermissions, but trades off a simpler usage model with
         *  significantly lower computational requirements. Unlike WatchPermissions, this method returns changes to the sets of permissions,
         *  rather than the individual permissions. Permission sets are a normalized form of the computed permissions, which
         *  means that the consumer must perform an extra computation over this representation to obtain the final computed
         *  permissions, typically by intersecting the provided sets.
         *
         *  For example, this would look like a JOIN between the
         *  materialize permission sets table in a target relation database, the table with the resources to authorize access
         *  to, and the table with the subject (e.g. a user).
         *
         *  In exchange, the number of changes issued by WatchPermissionSets will be several orders of magnitude less than those
         *  emitted by WatchPermissions, which has several implications:
         *  - significantly less resources to compute the sets
         *  - significantly less messages to stream over the network
         *  - significantly less events to ingest on the consumer side
         *  - less ingestion lag from the origin SpiceDB mutation
         *
         *  The type of scenarios WatchPermissionSets is particularly well suited is when a single change
         *  in the origin SpiceDB can yield millions of changes. For example, in the GitHub authorization model, assigning a role
         *  to a top-level team of an organization with hundreds of thousands of employees can lead to an explosion of
         *  permission change events that would require a lot of computational resources to process, both on Materialize and
         *  the consumer side.
         *
         *  WatchPermissionSets is thus recommended for any larger scale use case where the fan-out in permission changes that
         *  emerges from a specific schema and data shape is too large to handle effectively.
         *
         *  The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
         *  Implementing an active-active HA consumer setup over the same target system will require coordinating which
         *  revisions have been consumed in order to prevent transitioning to an inconsistent state.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionSetsResponse> watchPermissionSets(
                com.authzed.api.materialize.v0.WatchPermissionSetsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::watchPermissionSets);
        }

        /**
         * <pre>
         *  LookupPermissionSets returns the current state of the permission sets which can be used to derive the computed permissions.
         *  It&#39;s typically used to backfill the state of the permission sets in the consumer side.
         *
         *  It&#39;s a cursored API and the consumer is responsible to keep track of the cursor and use it on each subsequent call.
         *  Each stream will return &lt;N&gt; permission sets defined by the specified request limit. The server will keep streaming until
         *  the sets per stream is hit, or the current state of the sets is reached,
         *  whatever happens first, and then close the stream. The server will indicate there are no more changes to stream
         *  through the `completed_members` in the cursor.
         *
         *  There may be many elements to stream, and so the consumer should be prepared to resume the stream from the last
         *  cursor received. Once completed, the consumer may start streaming permission set changes using WatchPermissionSets
         *  and the revision token from the last LookupPermissionSets response.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.LookupPermissionSetsResponse> lookupPermissionSets(
                com.authzed.api.materialize.v0.LookupPermissionSetsRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::lookupPermissionSets);
        }
    }

    public static abstract class WatchPermissionSetsServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public WatchPermissionSetsServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        /**
         * <pre>
         *  DownloadPermissionSets returns URLs to download permission sets data as Avro files.
         *  This provides an alternative to LookupPermissionSets for customers who need to download
         *  large datasets efficiently. The returned URLs point to compressed Avro files containing
         *  the permission sets data in a normalized format.
         * </pre>
         */
        public io.smallrye.mutiny.Uni<com.authzed.api.materialize.v0.DownloadPermissionSetsResponse> downloadPermissionSets(
                com.authzed.api.materialize.v0.DownloadPermissionSetsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  WatchPermissionSets returns a stream of changes to the sets which can be used to compute the watched permissions.
         *
         *  WatchPermissionSets lets consumers achieve the same thing as WatchPermissions, but trades off a simpler usage model with
         *  significantly lower computational requirements. Unlike WatchPermissions, this method returns changes to the sets of permissions,
         *  rather than the individual permissions. Permission sets are a normalized form of the computed permissions, which
         *  means that the consumer must perform an extra computation over this representation to obtain the final computed
         *  permissions, typically by intersecting the provided sets.
         *
         *  For example, this would look like a JOIN between the
         *  materialize permission sets table in a target relation database, the table with the resources to authorize access
         *  to, and the table with the subject (e.g. a user).
         *
         *  In exchange, the number of changes issued by WatchPermissionSets will be several orders of magnitude less than those
         *  emitted by WatchPermissions, which has several implications:
         *  - significantly less resources to compute the sets
         *  - significantly less messages to stream over the network
         *  - significantly less events to ingest on the consumer side
         *  - less ingestion lag from the origin SpiceDB mutation
         *
         *  The type of scenarios WatchPermissionSets is particularly well suited is when a single change
         *  in the origin SpiceDB can yield millions of changes. For example, in the GitHub authorization model, assigning a role
         *  to a top-level team of an organization with hundreds of thousands of employees can lead to an explosion of
         *  permission change events that would require a lot of computational resources to process, both on Materialize and
         *  the consumer side.
         *
         *  WatchPermissionSets is thus recommended for any larger scale use case where the fan-out in permission changes that
         *  emerges from a specific schema and data shape is too large to handle effectively.
         *
         *  The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
         *  Implementing an active-active HA consumer setup over the same target system will require coordinating which
         *  revisions have been consumed in order to prevent transitioning to an inconsistent state.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionSetsResponse> watchPermissionSets(
                com.authzed.api.materialize.v0.WatchPermissionSetsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  LookupPermissionSets returns the current state of the permission sets which can be used to derive the computed permissions.
         *  It&#39;s typically used to backfill the state of the permission sets in the consumer side.
         *
         *  It&#39;s a cursored API and the consumer is responsible to keep track of the cursor and use it on each subsequent call.
         *  Each stream will return &lt;N&gt; permission sets defined by the specified request limit. The server will keep streaming until
         *  the sets per stream is hit, or the current state of the sets is reached,
         *  whatever happens first, and then close the stream. The server will indicate there are no more changes to stream
         *  through the `completed_members` in the cursor.
         *
         *  There may be many elements to stream, and so the consumer should be prepared to resume the stream from the last
         *  cursor received. Once completed, the consumer may start streaming permission set changes using WatchPermissionSets
         *  and the revision token from the last LookupPermissionSets response.
         * </pre>
         */
        public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.LookupPermissionSetsResponse> lookupPermissionSets(
                com.authzed.api.materialize.v0.LookupPermissionSetsRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(
                    com.authzed.api.materialize.v0.WatchPermissionSetsServiceGrpc.getWatchPermissionSetsMethod(),
                    asyncServerStreamingCall(
                            new MethodHandlers<com.authzed.api.materialize.v0.WatchPermissionSetsRequest, com.authzed.api.materialize.v0.WatchPermissionSetsResponse>(
                                    this, METHODID_WATCH_PERMISSION_SETS, compression)))
                    .addMethod(com.authzed.api.materialize.v0.WatchPermissionSetsServiceGrpc.getLookupPermissionSetsMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<com.authzed.api.materialize.v0.LookupPermissionSetsRequest, com.authzed.api.materialize.v0.LookupPermissionSetsResponse>(
                                            this, METHODID_LOOKUP_PERMISSION_SETS, compression)))
                    .addMethod(com.authzed.api.materialize.v0.WatchPermissionSetsServiceGrpc.getDownloadPermissionSetsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<com.authzed.api.materialize.v0.DownloadPermissionSetsRequest, com.authzed.api.materialize.v0.DownloadPermissionSetsResponse>(
                                            this, METHODID_DOWNLOAD_PERMISSION_SETS, compression)))
                    .build();
        }
    }

    private static final int METHODID_WATCH_PERMISSION_SETS = 0;

    private static final int METHODID_LOOKUP_PERMISSION_SETS = 1;

    private static final int METHODID_DOWNLOAD_PERMISSION_SETS = 2;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final WatchPermissionSetsServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(WatchPermissionSetsServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_WATCH_PERMISSION_SETS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany(
                            (com.authzed.api.materialize.v0.WatchPermissionSetsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.WatchPermissionSetsResponse>) responseObserver,
                            compression, serviceImpl::watchPermissionSets);
                    break;
                case METHODID_LOOKUP_PERMISSION_SETS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany(
                            (com.authzed.api.materialize.v0.LookupPermissionSetsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.LookupPermissionSetsResponse>) responseObserver,
                            compression, serviceImpl::lookupPermissionSets);
                    break;
                case METHODID_DOWNLOAD_PERMISSION_SETS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne(
                            (com.authzed.api.materialize.v0.DownloadPermissionSetsRequest) request,
                            (io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.DownloadPermissionSetsResponse>) responseObserver,
                            compression, serviceImpl::downloadPermissionSets);
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
