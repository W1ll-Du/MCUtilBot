package io.github.w1ll_du.mcUtilsBot.command.commands;

import io.github.w1ll_du.mcUtilsBot.command.CommandContext;
import io.github.w1ll_du.mcUtilsBot.command.ICommand;

import java.util.List;

public class StatsCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        // [username] [stat type] [stat name]
        // get directly from world/stats/uuid.json
        // ctx.getChannel().sendMessage(Utils.rconCommand(cmd)).queue();
    }

    @Override
    public String getName() {
        return "stats";
    }
    
    @Override
    public List<String> getAliases() {
        return List.of("statistics");
    }
}
