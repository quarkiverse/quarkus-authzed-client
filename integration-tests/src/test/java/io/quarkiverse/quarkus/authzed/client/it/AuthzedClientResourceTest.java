package io.quarkiverse.quarkus.authzed.client.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import com.authzed.api.v1.PermissionService.CheckPermissionRequest;
import com.authzed.api.v1.PermissionService.CheckPermissionResponse;
import com.authzed.api.v1.PermissionService.CheckPermissionResponse.Permissionship;
import com.authzed.api.v1.PermissionService.Consistency;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaRequest;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaResponse;

import io.quarkiverse.authzed.Tuples;
import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;

@QuarkusTest
public class AuthzedClientResourceTest {

    private static final Consistency CONSISTENCY = Consistency.newBuilder().setFullyConsistent(true).build();

    @Inject
    AuthzedClient client;

    @Test
    public void shouldHaveSchema() {
        Uni<ReadSchemaResponse> response = client.v1().schemaService().readSchema(ReadSchemaRequest.newBuilder().build());
        String schemaText = response.await().indefinitely().getSchemaText();
        assertTrue(schemaText.contains("definition document"));
        assertTrue(schemaText.contains("definition user"));
    }

    @Test
    public void shouldHavePermission() {
        Uni<CheckPermissionResponse> response = client.v1().permissionService()
                .checkPermission(CheckPermissionRequest.newBuilder()
                        .setConsistency(CONSISTENCY)
                        .setSubject(Tuples.parseUser("user:somegal"))
                        .setResource(Tuples.parseObject("document:cv"))
                        .setPermission("view")
                        .build());
        assertEquals(Permissionship.PERMISSIONSHIP_HAS_PERMISSION, response.await().indefinitely().getPermissionship());

        response = client.v1().permissionService()
                .checkPermission(CheckPermissionRequest.newBuilder()
                        .setConsistency(CONSISTENCY)
                        .setSubject(Tuples.parseUser("user:anotherguy"))
                        .setResource(Tuples.parseObject("document:bio"))
                        .setPermission("view")
                        .build());
        assertEquals(Permissionship.PERMISSIONSHIP_HAS_PERMISSION, response.await().indefinitely().getPermissionship());

    }

    @Test
    public void shouldNotHavePermission() {
        Uni<CheckPermissionResponse> response = client.v1().permissionService()
                .checkPermission(CheckPermissionRequest.newBuilder()
                        .setConsistency(CONSISTENCY)
                        .setSubject(Tuples.parseUser("user:somegal"))
                        .setResource(Tuples.parseObject("document:notes"))
                        .setPermission("write")
                        .build());
        assertEquals(Permissionship.PERMISSIONSHIP_NO_PERMISSION, response.await().indefinitely().getPermissionship());

        response = client.v1().permissionService()
                .checkPermission(CheckPermissionRequest.newBuilder()
                        .setConsistency(CONSISTENCY)
                        .setSubject(Tuples.parseUser("user:anotherguy"))
                        .setResource(Tuples.parseObject("document:cv"))
                        .setPermission("view")
                        .build());
        assertEquals(Permissionship.PERMISSIONSHIP_NO_PERMISSION, response.await().indefinitely().getPermissionship());

    }

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/authzed-client")
                .then()
                .statusCode(200)
                .body(is("Hello authzed-client"));
    }
}
