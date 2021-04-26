package eu.tribusmc.tribusgiveaways.lang;

import eu.tribusmc.tribusgiveaways.Core;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageManager {

    /**
     * @Author Scarmo
     */

    private final HashMap<String, List<String>> messages;
    private final Core core;

    public MessageManager(Core core) {

        this.core = core;
        messages = new HashMap<>();

        for (String key : core.getConfig().getConfigurationSection("lang").getKeys(false)) {
            messages.put(key, core.getConfig().getStringList("lang." + key));
        }
    }


    /**
     * Gets a message from config
     *
     * @param key
     * @return message from key
     */


    public List<String> getMessage(String key) {
        return messages.get(key);
    }

    /**
     * Send a message to a Player
     *
     * @param p
     * @param key
     */

    public void sendMessage(Player p, String key) {

        if (getMessage(key) == null) {
            core.getLogger().info("§c" + key + " existerar inte i config.yml.");
            return;
        }

        for (String line : getMessage(key)) {
            p.sendMessage(line.replace('&', '§'));
        }

    }


    /**
     * Send a message to CommandSender
     *
     * @param sender
     * @param key
     */

    public void sendMessage( CommandSender sender, String key) {

        if (getMessage(key) == null) {
            core.getLogger().info("§c" + key + " existerar inte i config.yml.");
            return;
        }

        for (String line : getMessage(key)) {
            sender.sendMessage(line.replace('&', '§'));
        }

    }

}
