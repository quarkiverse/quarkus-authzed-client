package com.authzed.api.materialize.v0;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/materialize/v0/watchpermissionsets.proto")
public class WatchPermissionSetsServiceClient implements WatchPermissionSetsService,
        MutinyClient<MutinyWatchPermissionSetsServiceGrpc.MutinyWatchPermissionSetsServiceStub> {

    private final MutinyWatchPermissionSetsServiceGrpc.MutinyWatchPermissionSetsServiceStub stub;

    public WatchPermissionSetsServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinyWatchPermissionSetsServiceGrpc.MutinyWatchPermissionSetsServiceStub, MutinyWatchPermissionSetsServiceGrpc.MutinyWatchPermissionSetsServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyWatchPermissionSetsServiceGrpc.newMutinyStub(channel));
    }

    private WatchPermissionSetsServiceClient(MutinyWatchPermissionSetsServiceGrpc.MutinyWatchPermissionSetsServiceStub stub) {
        this.stub = stub;
    }

    public WatchPermissionSetsServiceClient newInstanceWithStub(
            MutinyWatchPermissionSetsServiceGrpc.MutinyWatchPermissionSetsServiceStub stub) {
        return new WatchPermissionSetsServiceClient(stub);
    }

    @Override
    public MutinyWatchPermissionSetsServiceGrpc.MutinyWatchPermissionSetsServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.authzed.api.materialize.v0.DownloadPermissionSetsResponse> downloadPermissionSets(
            com.authzed.api.materialize.v0.DownloadPermissionSetsRequest request) {
        return stub.downloadPermissionSets(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionSetsResponse> watchPermissionSets(
            com.authzed.api.materialize.v0.WatchPermissionSetsRequest request) {
        return stub.watchPermissionSets(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.LookupPermissionSetsResponse> lookupPermissionSets(
            com.authzed.api.materialize.v0.LookupPermissionSetsRequest request) {
        return stub.lookupPermissionSets(request);
    }
}
