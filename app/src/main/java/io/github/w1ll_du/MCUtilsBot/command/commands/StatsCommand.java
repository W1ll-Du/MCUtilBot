package io.github.w1ll_du.MCUtilsBot.command.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.w1ll_du.MCUtilsBot.Utils;
import io.github.w1ll_du.MCUtilsBot.command.CommandContext;
import io.github.w1ll_du.MCUtilsBot.command.ICommand;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class StatsCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        // [username] [stat type] [stat name]
        // the bots will need to be in [server folder]/MCUtils
        // get directly from world/stats/uuid.json
        // ../world/stats/uuid.json
        String username = ctx.getArgs().get(0);
        String type = ctx.getArgs().get(1);
        String name = ctx.getArgs().get(2);

        if (! isValidUsername(username)) {
            ctx.getChannel().sendMessage("Username invalid").queue();
            return;
        }

        try {
            // System.out.println(ctx.getArgs());
            JSONObject resp = Utils.getJSONObject("https://api.mojang.com/users/profiles/minecraft/" + username);
            String uuid = (String) resp.get("id");
            // System.out.println(uuid);
            // System.out.println(makeFancy(uuid));
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> stats = mapper.readValue(Paths.get("../world/stats/" + makeFancy(uuid) + ".json").toFile(), Map.class);
            /*
            System.out.println(
                ((Map<String, Map<String, Integer>>) stats
                .get("stats"))
                .get("minecraft:" + type)
                .get("minecraft:" + name)
            );
            */
            ctx.getChannel().sendMessage(
                String.valueOf(((Map<String, Map<String, Integer>>) stats
                .get("stats"))
                .get("minecraft:" + type)
                .get("minecraft:" + name))
            ).queue();
        } catch (IOException e) {
            ctx.getChannel().sendMessage("Something went wrong, please try again.").queue();
            e.printStackTrace();
        } catch (NullPointerException e) {
            ctx.getChannel().sendMessage("Something went wrong, please try again.").queue();
        }
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

    private static boolean isValidUsername(String name) {
        // https://help.mojang.com/customer/portal/articles/928638-minecraft-usernames
        String allowed_chars = "abcdefghijklmnopqrstuvwxyz1234567890_";
        name = name.toLowerCase();
        if (name.length() < 3 || name.length() > 16) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (! allowed_chars.contains(name.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    private static String makeFancy(String uuid) {
        // 8-4-4-4-12
        return uuid.substring(0, 8) + "-" + uuid.substring(8, 12) + "-" + uuid.substring(12, 16) + "-" + uuid.substring(16, 20) + "-" + uuid.substring(20, 32);
    }
}
