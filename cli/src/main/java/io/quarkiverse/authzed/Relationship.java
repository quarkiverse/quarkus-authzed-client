package io.quarkiverse.authzed;

import io.quarkiverse.authzed.relationship.Create;
import io.quarkiverse.authzed.relationship.Delete;
import picocli.CommandLine.Command;

@Command(name = "relationship", sortOptions = false, mixinStandardHelpOptions = false, header = "Authzed relationships", subcommands = {
        Create.class, Delete.class })
public class Relationship {

}
