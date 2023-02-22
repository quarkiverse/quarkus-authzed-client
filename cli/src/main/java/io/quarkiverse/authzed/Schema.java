package io.quarkiverse.authzed;

import java.util.concurrent.Callable;

import io.quarkiverse.authzed.schema.Read;
import io.quarkiverse.authzed.schema.Write;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

@Command(name = "schema", sortOptions = false, mixinStandardHelpOptions = false, header = "Authzed schema", subcommands = {
        Read.class, Write.class })
public class Schema implements Callable<Integer> {

    @Spec
    protected CommandSpec spec;

    @Override
    public Integer call() {
        CommandLine readCommand = spec.subcommands().get("read");
        return readCommand.execute();
    }
}
