package io.quarkiverse.quarkus.authzed.client.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import jakarta.inject.Inject;

import org.eclipse.microprofile.config.ConfigProvider;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.authzed.api.v1.SchemaServiceOuterClass;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.test.QuarkusUnitTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.smallrye.mutiny.Uni;

public class DevServicesAuthzedClientTest {

    @Inject
    AuthzedClient client;

    @Inject
    AuthzedConfig config;

    // Start unit test with your extension loaded
    @RegisterExtension
    static final QuarkusUnitTest unitTest = new QuarkusUnitTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addAsResource(DevServicesAuthzedClientTest.class.getResource("/test-schema"), "/test-schema"));

    @Test
    public void shouldAccessDashboard() {
        Optional<String> dashboardUrl = ConfigProvider.getConfig().getOptionalValue("quarkus.authzed.dashboard.url",
                String.class);
        assertTrue(dashboardUrl.isPresent());
        final Response resp = RestAssured.given().get(dashboardUrl.get());
        assertEquals(200, resp.statusCode());
    }

    @Test
    public void shouldAccessHttp() {
        Optional<String> httpUrl = ConfigProvider.getConfig().getOptionalValue("quarkus.authzed.http.url", String.class);
        assertTrue(httpUrl.isPresent());
        final Response resp = RestAssured.given().get(httpUrl.get());
        //TODO: Fix the assertion below
        //assertEquals(200, resp.statusCode());
    }

    @Test
    public void shouldAccessMetrics() {
        Optional<String> metricsUrl = ConfigProvider.getConfig().getOptionalValue("quarkus.authzed.metrics.url",
                String.class);
        assertTrue(metricsUrl.isPresent());
        final Response resp = RestAssured.given().get(metricsUrl.get());
        //TODO: Fix the assertion below
        //assertEquals(200, resp.statusCode());
    }

    @Test
    public void shouldCreateSchema() {
        client.v1().schemaService()
                .writeSchema(SchemaServiceOuterClass.WriteSchemaRequest.newBuilder().setSchema(readSchema()).build());
        Uni<SchemaServiceOuterClass.ReadSchemaResponse> response = client.v1().schemaService()
                .readSchema(SchemaServiceOuterClass.ReadSchemaRequest.newBuilder().build());
        assertNotNull(response);
    }

    private String readSchema() {
        try {
            return Files.readString(Path.of(DevServicesAuthzedClientTest.class.getResource("/test-schema").getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
