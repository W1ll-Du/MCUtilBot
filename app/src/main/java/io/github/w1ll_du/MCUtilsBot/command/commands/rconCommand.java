package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.Utils;
import io.github.w1ll_du.MCUtilsBot.command.AAdminCommand;
import io.github.w1ll_du.MCUtilsBot.command.CommandContext;

public class rconCommand extends AAdminCommand  {
    protected void handle2(CommandContext ctx) {
        ctx.getChannel().sendMessage(Utils.rconCommand(Utils.compress(ctx.getArgs()))).queue();
    }

    public String getName() {
        return "rcon";
    }
}
