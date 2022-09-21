package com.authzed.api.v1alpha1;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1alpha1/watchresources_service.proto")
public class WatchResourcesServiceClient
        implements WatchResourcesService, MutinyClient<MutinyWatchResourcesServiceGrpc.MutinyWatchResourcesServiceStub> {

    private final MutinyWatchResourcesServiceGrpc.MutinyWatchResourcesServiceStub stub;

    public WatchResourcesServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinyWatchResourcesServiceGrpc.MutinyWatchResourcesServiceStub, MutinyWatchResourcesServiceGrpc.MutinyWatchResourcesServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyWatchResourcesServiceGrpc.newMutinyStub(channel));
    }

    private WatchResourcesServiceClient(MutinyWatchResourcesServiceGrpc.MutinyWatchResourcesServiceStub stub) {
        this.stub = stub;
    }

    public WatchResourcesServiceClient newInstanceWithStub(
            MutinyWatchResourcesServiceGrpc.MutinyWatchResourcesServiceStub stub) {
        return new WatchResourcesServiceClient(stub);
    }

    @Override
    public MutinyWatchResourcesServiceGrpc.MutinyWatchResourcesServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesResponse> watchResources(
            com.authzed.api.v1alpha1.WatchresourcesService.WatchResourcesRequest request) {
        return stub.watchResources(request);
    }
}
