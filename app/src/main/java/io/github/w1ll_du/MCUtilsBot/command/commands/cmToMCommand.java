package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.CommandContext;
import io.github.w1ll_du.MCUtilsBot.command.ICommand;

public class cmToMCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        ctx.getChannel().sendMessage(String.valueOf(Integer.parseInt(ctx.getArgs().get(0)) / 100.0)).queue();
    }

    @Override
    public String getName() {
        return "cmToM";
    }
}