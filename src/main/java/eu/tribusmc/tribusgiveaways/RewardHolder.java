package eu.tribusmc.tribusgiveaways;

import org.bukkit.entity.Player;

import java.util.UUID;

public class RewardHolder {


    private Player p;
    private UUID pUUID;


    public RewardHolder(Player paramPlayer) {
        this.p = paramPlayer;
        this.pUUID = p.getUniqueId();
    }





}
