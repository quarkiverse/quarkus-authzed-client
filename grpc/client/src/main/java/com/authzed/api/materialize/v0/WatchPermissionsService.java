package com.authzed.api.materialize.v0;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/materialize/v0/watchpermissions.proto")
public interface WatchPermissionsService extends MutinyService {

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
    io.smallrye.mutiny.Multi<com.authzed.api.materialize.v0.WatchPermissionsResponse> watchPermissions(
            com.authzed.api.materialize.v0.WatchPermissionsRequest request);
}
