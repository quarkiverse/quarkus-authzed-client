package io.quarkiverse.authzed;

import java.util.concurrent.Callable;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

@TopCommand
@Command(name = "authzed", sortOptions = false, mixinStandardHelpOptions = false, header = "Interact with authzed", subcommands = {
        Schema.class, Relationship.class, Permission.class })
public class AuthzedCommand implements Callable<Integer> {

    @Spec
    protected CommandSpec spec;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "Display this help message.")
    public boolean help;

    @Override
    public Integer call() {
        CommandLine schemaCommand = spec.subcommands().get("schema");
        return schemaCommand.execute();
    }

}
