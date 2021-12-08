package io.github.w1ll_du.mcUtilsBot.command.commands;

import io.github.w1ll_du.mcUtilsBot.command.CommandContext;
import io.github.w1ll_du.mcUtilsBot.command.ICommand;
import net.dv8tion.jda.api.JDA;

public class PingCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();

        jda.getRestPing().queue(
            (ping) -> ctx.getChannel()
                .sendMessageFormat("Rest ping: %sms\nWS ping: %sms", ping, jda.getGatewayPing())
                .queue()
        );
    }

    @Override
    public String getName() {
        return "ping";
    }
}