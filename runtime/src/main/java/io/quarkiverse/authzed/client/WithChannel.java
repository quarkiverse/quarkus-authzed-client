package io.quarkiverse.authzed.client;

import io.grpc.ManagedChannel;

public class WithChannel {

    private final ManagedChannel channel;

    public WithChannel(ManagedChannel channel) {
        this.channel = channel;
    }

    public ManagedChannel getChannel() {
        return channel;
    }
}
