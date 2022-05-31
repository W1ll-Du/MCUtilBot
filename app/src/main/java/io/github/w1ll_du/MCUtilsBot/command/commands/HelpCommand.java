package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.CommandContext;
import io.github.w1ll_du.MCUtilsBot.command.ICommand;

public class HelpCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        ctx.getChannel().sendMessage("https://github.com/W1ll-Du/MCUtilBot/blob/master/README.md").queue();
    }

    @Override
    public String getName() {
        return null;
    }
}
