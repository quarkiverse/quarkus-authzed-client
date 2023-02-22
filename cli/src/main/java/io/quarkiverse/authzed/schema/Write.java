package io.quarkiverse.authzed.schema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.Callable;

import com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaRequest;
import com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaResponse;

import io.quarkiverse.authzed.client.AuthzedClient;
import io.quarkus.runtime.util.StringUtil;
import picocli.CommandLine.Command;
import picocli.CommandLine.ExitCode;
import picocli.CommandLine.Parameters;

@Command(name = "write", description = "Write the schema")
public class Write implements Callable<Integer> {

    private AuthzedClient client;

    public Write(AuthzedClient client) {
        this.client = client;
    }

    @Parameters(arity = "1", paramLabel = "SCHEMA_LOCATION", description = "The location to read the schema from.")
    String location;

    @Override
    public Integer call() throws Exception {
        createPath(location).flatMap(Write::readSchema).ifPresent(schema -> {
            WriteSchemaResponse response = client.v1().schemaService()
                    .writeSchema(WriteSchemaRequest.newBuilder()
                            .setSchema(schema)
                            .build())
                    .await()
                    .atMost(Duration.ofSeconds(10L));
        });
        return ExitCode.OK;
    }

    private static Optional<Path> createPath(String location) {
        try {
            return Optional.of(Path.of(location));
        } catch (InvalidPathException e) {
            System.out.println("Path: " + location + " is not valid!");
            return Optional.empty();
        }
    }

    private static Optional<String> readSchema(Path path) {
        try {
            return Optional.of(Files.readString(path));
        } catch (IOException e) {
            System.out.print("Failed to read schema from: " + path.toAbsolutePath().toString() + "!"
                    + (StringUtil.isNullOrEmpty(e.getMessage()) ? "" : "Due to: " + e.getMessage()));
            return Optional.empty();
        }
    }
}
