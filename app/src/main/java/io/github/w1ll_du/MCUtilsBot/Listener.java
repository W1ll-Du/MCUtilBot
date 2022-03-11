package io.github.w1ll_du.MCUtilsBot;

import me.duncte123.botcommons.BotCommons;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.Map;

public class Listener extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
    private final CommandManager manager;
    Map<String, String> conf;
    private final String prefix;
    private final String owner_id;

    public Listener(Map<String, String> conf) {
        this.conf = conf;
        prefix = conf.get("prefix");
        owner_id = conf.get("owner_id");
        manager = new CommandManager(conf);
    }

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        LOGGER.info("{} is ready.", event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String raw = event.getMessage().getContentRaw();
        if (event.getChannel().getId().equals(conf.get("changelog_channel_id"))
            && ! event.getAuthor().getId().equals(owner_id)) {
            // TODO: only allow java and filter out bedrock
        }
        if (event.getAuthor().isBot()) {
            return;
        }
        if (event.isWebhookMessage()) {
            return;
        }
        if (! event.getGuild().getId().equals(conf.get("discord_server_id"))) {
            return;
        }
        if (! event.getChannel().getId().equals(conf.get("bot_channel_id"))) {
            return;
        }
        if (! raw.startsWith(prefix)) return;
        if (raw.equals(prefix + "shutdown") && event.getAuthor().getId().equals(owner_id)) {
            LOGGER.info("Shutting down");
            event.getJDA().shutdown();
            BotCommons.shutdown(event.getJDA());
        }
        try {
            manager.handle(event, prefix, conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
