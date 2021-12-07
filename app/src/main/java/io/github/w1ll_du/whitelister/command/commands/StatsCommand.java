package io.github.w1ll_du.whitelister.command.commands;

import io.github.w1ll_du.whitelister.command.CommandContext;
import io.github.w1ll_du.whitelister.command.ICommand;
import io.github.w1ll_du.whitelister.Utils;
import java.util.List;

public class StatsCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        // [username] [statistic name]
        String cmd;
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
