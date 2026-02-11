package io.quarkiverse.quarkus.authzed.client.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
public class AuthzedClientResourceIT {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/authzed-client")
                .then()
                .statusCode(200)
                .body(is("Hello authzed-client"));
    }
}
