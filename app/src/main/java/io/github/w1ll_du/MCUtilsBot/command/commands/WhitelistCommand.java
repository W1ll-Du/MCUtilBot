package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.CommandContext;
import io.github.w1ll_du.MCUtilsBot.command.ICommand;
import io.github.w1ll_du.MCUtilsBot.Utils;

public class WhitelistCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        ctx.getChannel().sendMessage(Utils.rconCommand("/whitelist list")).queue();
    }

    @Override
    public String getName() {
        return "whitelist";
    }
}
