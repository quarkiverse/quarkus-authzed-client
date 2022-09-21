package com.authzed.api.v1;

import java.util.function.BiFunction;

import io.quarkus.grpc.MutinyClient;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v1/watch_service.proto")
public class WatchServiceClient implements WatchService, MutinyClient<MutinyWatchServiceGrpc.MutinyWatchServiceStub> {

    private final MutinyWatchServiceGrpc.MutinyWatchServiceStub stub;

    public WatchServiceClient(String name, io.grpc.Channel channel,
            BiFunction<String, MutinyWatchServiceGrpc.MutinyWatchServiceStub, MutinyWatchServiceGrpc.MutinyWatchServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyWatchServiceGrpc.newMutinyStub(channel));
    }

    private WatchServiceClient(MutinyWatchServiceGrpc.MutinyWatchServiceStub stub) {
        this.stub = stub;
    }

    public WatchServiceClient newInstanceWithStub(MutinyWatchServiceGrpc.MutinyWatchServiceStub stub) {
        return new WatchServiceClient(stub);
    }

    @Override
    public MutinyWatchServiceGrpc.MutinyWatchServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Multi<com.authzed.api.v1.WatchServiceOuterClass.WatchResponse> watch(
            com.authzed.api.v1.WatchServiceOuterClass.WatchRequest request) {
        return stub.watch(request);
    }
}
