package io.github.w1ll_du.MCUtilsBot.command.commands;

import io.github.w1ll_du.MCUtilsBot.command.CommandContext;
import io.github.w1ll_du.MCUtilsBot.command.ICommand;
import net.dv8tion.jda.api.JDA;

public class ticksToMinutes implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        ctx.getChannel().sendMessage(String.valueOf(Integer.valueOf(ctx.getArgs().get(0)) / 1200)).queue();
    }

    @Override
    public String getName() {
        return "ticksToMinutes";
    }
}