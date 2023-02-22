package io.quarkiverse.authzed.schema;

import java.time.Duration;
import java.util.concurrent.Callable;

import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaRequest;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaResponse;

import io.quarkiverse.authzed.client.AuthzedClient;
import picocli.CommandLine.Command;
import picocli.CommandLine.ExitCode;

@Command(name = "read", description = "Read the schema")
public class Read implements Callable<Integer> {

    private AuthzedClient client;

    public Read(AuthzedClient client) {
        this.client = client;
    }

    @Override
    public Integer call() throws Exception {
        ReadSchemaResponse response = client.v1().schemaService()
                .readSchema(ReadSchemaRequest.getDefaultInstance())
                .await()
                .atMost(Duration.ofSeconds(10L));

        System.out.println(response.getSchemaText());
        return ExitCode.OK;
    }
}
