package io.quarkiverse.authzed.relationship;

import java.time.Duration;
import java.util.concurrent.Callable;

import com.authzed.api.v1.Relationship;
import com.authzed.api.v1.RelationshipUpdate;
import com.authzed.api.v1.RelationshipUpdate.Operation;
import com.authzed.api.v1.WriteRelationshipsRequest;
import com.authzed.api.v1.WriteRelationshipsResponse;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.utils.Tuples;
import picocli.CommandLine.Command;
import picocli.CommandLine.ExitCode;
import picocli.CommandLine.Parameters;

@Command(name = "delete")
public class Delete implements Callable<Integer> {

    private AuthzedClient client;

    public Delete(AuthzedClient client) {
        this.client = client;
    }

    @Parameters(arity = "1", paramLabel = "RESOURCE", description = "The resource (e.g. document:expenses)")
    String resource;

    @Parameters(arity = "1", paramLabel = "PERMISSION", description = "The permission (e.g. write)")
    String permission;

    @Parameters(arity = "1", paramLabel = "SUBJECT", description = "The subject (e.g. user:jane)")
    String subject;

    @Override
    public Integer call() throws Exception {
        WriteRelationshipsResponse response = client
                .v1().permissionService().writeRelationships(WriteRelationshipsRequest.newBuilder()
                        .addUpdates(RelationshipUpdate.newBuilder().setOperation(Operation.OPERATION_DELETE)
                                .setRelationship(Relationship.newBuilder()
                                        .setSubject(Tuples.parseUser(subject))
                                        .setResource(Tuples.parseObject(resource))
                                        .setRelation(permission)
                                        .build())
                                .build())
                        .build())
                .await()
                .atMost(Duration.ofSeconds(10L));

        return ExitCode.OK;
    }

}
