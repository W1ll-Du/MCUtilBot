package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.Utils;
import io.github.w1ll_du.MCUtilsBot.command.CommandContext;
import io.github.w1ll_du.MCUtilsBot.command.ICommand;

public class checkAFKCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        ctx.getChannel().sendMessage(Utils.rconCommand("team list afkDis.afk")).queue();
    }

    @Override
    public String getName() {
        return "checkAFK";
    }
}
