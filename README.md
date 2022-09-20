# Quarkus - Authzed Client

An early draft of quarkus extension for https://github.com/authzed/authzed-java

## Usage

To use the client add the following dependency to the pom.xml


```xml
<dependency>
    <groupId>io.quarkiverse.authzed</groupId>
    <artifactId>quarkus-authzed-client</artifactId>
</dependency>

```

### Injecting the client

To inject the client into your code:

```java
@Inject
private AuthzedClient client;
```

Then the client can be used:

```java
      Uni<ReadSchemaResponse> response = client.v1().schemaService().readSchema(ReadSchemaRequest.newBuilder().build());
      System.out.println(response.await().indefinitely().getSchemaText());

```


## Unifies imperative and reactive 

With Quarkus supporting both imperative and reactive styles it made sense to expose both the blocking and the reactive stubs.
Given the Quarkus favor Mutiny for reactive programming it made sense to generate everyting from scratch using the `quarkus-grpc` extension.
This means that https://github.com/authzed/authzed-java is not directly used in this project.

## Configuration Reference

See the [configuration reference](docs/config/quarkus-authzed.adoc) for the full list of supported configuration options.

## Credits
Heavily influeced by Kevin Wotten's (kdubb) work on https://github.com/quarkiverse/quarkus-openfga-client
