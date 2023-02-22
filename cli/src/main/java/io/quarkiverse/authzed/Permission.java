package io.quarkiverse.authzed;

import io.quarkiverse.authzed.permission.Check;
import picocli.CommandLine.Command;

@Command(name = "permission", sortOptions = false, mixinStandardHelpOptions = false, header = "Authzed permissions", subcommands = {
        Check.class })
public class Permission {

}
