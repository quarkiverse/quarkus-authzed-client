package com.authzed.api.v0;

import io.quarkus.grpc.MutinyService;

@io.quarkus.grpc.common.Generated(value = "by Mutiny Grpc generator", comments = "Source: authzed/api/v0/developer.proto")
public interface DeveloperService extends MutinyService {

    io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.EditCheckResponse> editCheck(
            com.authzed.api.v0.Developer.EditCheckRequest request);

    io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ValidateResponse> validate(
            com.authzed.api.v0.Developer.ValidateRequest request);

    io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.ShareResponse> share(com.authzed.api.v0.Developer.ShareRequest request);

    io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.LookupShareResponse> lookupShared(
            com.authzed.api.v0.Developer.LookupShareRequest request);

    io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.UpgradeSchemaResponse> upgradeSchema(
            com.authzed.api.v0.Developer.UpgradeSchemaRequest request);

    io.smallrye.mutiny.Uni<com.authzed.api.v0.Developer.FormatSchemaResponse> formatSchema(
            com.authzed.api.v0.Developer.FormatSchemaRequest request);
}
