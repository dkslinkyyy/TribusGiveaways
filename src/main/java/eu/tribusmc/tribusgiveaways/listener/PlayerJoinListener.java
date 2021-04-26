package eu.tribusmc.tribusgiveaways.listener;

import eu.tribusmc.tribusgiveaways.Core;
import eu.tribusmc.tribusgiveaways.WinnerPlace;
import eu.tribusmc.tribusgiveaways.objects.Winner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    Core core;

    public PlayerJoinListener(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {



    }

}
