package io.github.w1ll_du.MCUtilsBot;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bot {

    private Bot() throws LoginException {

        Map<String, String> conf = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            conf = mapper.readValue(Paths.get("MCUtilsConfig.json").toFile(), Map.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ObjectWriter writer = new ObjectMapper().writer(new DefaultPrettyPrinter());
            Map<String, String> map = new LinkedHashMap<>();
            // discord cfg
            map.put("token", "YOUR TOKEN HERE");
            map.put("prefix", "u!");
            map.put("owner_id", "1234567890");
            map.put("discord_server_id", "9012345678");
            map.put("bot_channel_id", "8901234567");
            map.put("changelog_channel_id", "3456789012");
            // minecraft cfg
            map.put("mc_server_ip", "5678901234");
            map.put("rcon_port", "25575");
            map.put("rcon_password", "password");
            // xisuma's vanillatweaks
            map.put("afkDis", "false");
            try {
                writer.writeValue(Paths.get("MCUtilsConfig.json").toFile(), map);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        assert conf != null;
        Utils.conf = conf;
        JDABuilder
        .createDefault(conf.get("token"),
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_BANS,
                GatewayIntent.GUILD_MESSAGES)
        .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE)
        .enableIntents(GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_BANS,
                GatewayIntent.GUILD_MESSAGES)
        .addEventListeners(new Listener(conf))
        .build();
    }

    public static void main(String[] args) throws LoginException {
        Bot bot = new Bot();
    }
}
