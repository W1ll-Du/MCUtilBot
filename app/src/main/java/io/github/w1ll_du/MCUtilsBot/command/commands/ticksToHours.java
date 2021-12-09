package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.CommandContext;
import io.github.w1ll_du.MCUtilsBot.command.ICommand;

public class ticksToHours implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        ctx.getChannel().sendMessage(String.valueOf(Integer.parseInt(ctx.getArgs().get(0)) / 72000.0)).queue();
    }

    @Override
    public String getName() {
        return "ticksToHours";
    }
}