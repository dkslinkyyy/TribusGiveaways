package eu.tribusmc.tribusgiveaways.lang;

import com.sun.istack.internal.NotNull;
import eu.tribusmc.tribusgiveaways.Core;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageManager {

    /**
     * @Author Scarmo
     */

    private final HashMap<String, String> messages;


    public MessageManager(Core core) {
        messages = new HashMap<>();

        for (String key : core.getConfig().getConfigurationSection("lang").getKeys(false)) {
            messages.put(key, core.getConfig().getString("lang." + key));
        }
    }


    /**
     * Gets a message from config
     *
     * @param key
     * @return message from key
     */


    public String getMessage(@NotNull String key) {
        return messages.get(key);
    }

    /**
     * Send a message to a Player
     *
     * @param p
     * @param key
     */

    public void sendMessage(@NotNull Player p, @NotNull String key) {
        p.sendMessage(getMessage(key));
    }


    /**
     * Send a message to CommandSender
     *
     * @param sender
     * @param key
     */

    public void sendMessage(@NotNull CommandSender sender, @NotNull String key) {
        sender.sendMessage(getMessage(key));
    }

}
