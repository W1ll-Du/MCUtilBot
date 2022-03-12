package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.Utils;
import io.github.w1ll_du.MCUtilsBot.command.ARconCommand;
import io.github.w1ll_du.MCUtilsBot.command.CommandContext;

public class listAFKCommand extends ARconCommand {
    @Override
    protected void handle2(CommandContext ctx) {
        ctx.getChannel().sendMessage(Utils.rconCommand("team list afkDis.afk")).queue();
    }

    @Override
    public String getName() {
        return "listAFK";
    }
}
