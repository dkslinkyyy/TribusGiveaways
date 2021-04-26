package eu.tribusmc.tribusgiveaways.lang;

import eu.tribusmc.tribusgiveaways.Core;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageManager {

    private HashMap<String, String> messages = new HashMap<>();

    public MessageManager(Core core) {

        for (String key : core.getConfig().getConfigurationSection("lang").getKeys(false)) {
            messages.put(key, core.getConfig().getString("lang." + key));
        }

    }

   public String getMessage(String key) {
        return messages.get(key);
   }

    public void sendMessage(Player p, String key) {
        p.sendMessage(getMessage(key));
    }

    public void sendMessage(CommandSender sender, String key) {
        sender.sendMessage(getMessage(key));
    }

}
