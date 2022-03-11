package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.Utils;
import io.github.w1ll_du.MCUtilsBot.command.AAdminCommand;
import io.github.w1ll_du.MCUtilsBot.command.CommandContext;
import me.dilley.MineStat;

public class rconCommand extends AAdminCommand  {
    protected void handle2(CommandContext ctx) {
        // simulate ARconCommand
        if (!new MineStat(ctx.getConf().get("mc_server_ip"), 25565).isServerUp()) {
            ctx.getChannel().sendMessage("Could not execute command at the time.").queue();
            return;
        }

        ctx.getChannel().sendMessage(Utils.rconCommand(Utils.compress(ctx.getArgs()))).queue();
    }

    public String getName() {
        return "rcon";
    }
}
