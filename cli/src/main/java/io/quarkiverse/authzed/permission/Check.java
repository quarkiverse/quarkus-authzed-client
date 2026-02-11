package io.quarkiverse.authzed.permission;

import java.time.Duration;
import java.util.concurrent.Callable;

import com.authzed.api.v1.CheckPermissionRequest;
import com.authzed.api.v1.CheckPermissionResponse;
import com.authzed.api.v1.Consistency;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.utils.Tuples;
import picocli.CommandLine.Command;
import picocli.CommandLine.ExitCode;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "check", description = "Check a permission")
public class Check implements Callable<Integer> {

    private AuthzedClient client;

    public Check(AuthzedClient client) {
        this.client = client;
    }

    @Option(order = 1, names = { "--explain" }, description = "Explain the result")
    public boolean explain;

    @Parameters(arity = "1", paramLabel = "RESOURCE", description = "The resource (e.g. document:expenses)")
    String resource;

    @Parameters(arity = "1", paramLabel = "PERMISSION", description = "The permission (e.g. write)")
    String permission;

    @Parameters(arity = "1", paramLabel = "SUBJECT", description = "The subject (e.g. user:jane)")
    String subject;

    @Override
    public Integer call() throws Exception {
        CheckPermissionResponse response = client.v1().permissionService()
                .checkPermission(CheckPermissionRequest.newBuilder()
                        .setSubject(Tuples.parseUser(subject))
                        .setResource(Tuples.parseObject(resource))
                        .setPermission(permission)
                        .setConsistency(Consistency.newBuilder().setFullyConsistent(true).build())
                        .build())
                .await()
                .atMost(Duration.ofSeconds(10L));

        if (explain) {
            switch (response.getPermissionship()) {
                case PERMISSIONSHIP_HAS_PERMISSION:
                    System.out.println(subject + " has " + permission + " permission on " + resource);
                    break;
                case PERMISSIONSHIP_NO_PERMISSION:
                    System.out.println(subject + " does not have " + permission + " permission on " + resource);
                    break;
                default:
                    System.out.println(
                            "It's unspecified wether " + subject + " has " + permission + " permission on " + resource);
            }
        }
        System.out.println("Result: " + response.getPermissionshipValue());
        return ExitCode.OK;
    }
}
