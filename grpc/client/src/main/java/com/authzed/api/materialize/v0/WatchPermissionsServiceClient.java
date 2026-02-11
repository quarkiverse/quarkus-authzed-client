package com.authzed.api.materialize.v0;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/materialize/v0/watchpermissions.proto")
public class WatchPermissionsServiceClient
        implements WatchPermissionsService, MutinyClient<MutinyWatchPermissionsServiceGrpc.MutinyWatchPermissionsServiceStub> {

    private final MutinyWatchPermissionsServiceGrpc.MutinyWatchPermissionsServiceStub stub;

    public WatchPermissionsServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinyWatchPermissionsServiceGrpc.MutinyWatchPermissionsServiceStub, MutinyWatchPermissionsServiceGrpc.MutinyWatchPermissionsServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyWatchPermissionsServiceGrpc.newMutinyStub(channel));
    }

    private WatchPermissionsServiceClient(MutinyWatchPermissionsServiceGrpc.MutinyWatchPermissionsServiceStub stub) {
        this.stub = stub;
    }

    public WatchPermissionsServiceClient newInstanceWithStub(
            MutinyWatchPermissionsServiceGrpc.MutinyWatchPermissionsServiceStub stub) {
        return new WatchPermissionsServiceClient(stub);
    }

    @Override
    public MutinyWatchPermissionsServiceGrpc.MutinyWatchPermissionsServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionsResponse> watchPermissions(
            com.authzed.api.materialize.v0.WatchPermissionsRequest request) {
        return stub.watchPermissions(request);
    }
}
