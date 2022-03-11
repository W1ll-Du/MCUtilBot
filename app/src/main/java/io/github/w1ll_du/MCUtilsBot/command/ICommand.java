package io.github.w1ll_du.MCUtilsBot.command;

import io.github.w1ll_du.MCUtilsBot.command.commands.identityCommand;

import java.util.List;

public interface ICommand {
    void handle(CommandContext ctx);
    String getName();

    default List<String> getAliases() {
        return List.of();
    }

    default AConversionCommand getConverter() {
        return new identityCommand();
    }
}
