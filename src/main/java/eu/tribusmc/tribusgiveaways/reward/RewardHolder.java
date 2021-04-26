package eu.tribusmc.tribusgiveaways.reward;

import eu.tribusmc.tribusgiveaways.WinnerPlace;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class RewardHolder implements ConfigurationSerializable, Cloneable {


    private Player p;
    private final UUID pUUID;
    private WinnerPlace winnerPlace;


    public RewardHolder(Player paramPlayer, WinnerPlace winnerPlace) {
        this.p = paramPlayer;
        this.pUUID = p.getUniqueId();
        this.winnerPlace = winnerPlace;
    }


    public Player getPlayer() {
        return p;
    }

    public UUID getPlayerUUID() {
        return pUUID;
    }


    public void setWinnerPlace(WinnerPlace winnerPlace) {
        this.winnerPlace = winnerPlace;
    }

    public boolean isMatching(WinnerPlace w) {
        return winnerPlace.equals(w);
    }

    public WinnerPlace getWinnerPlace() {
        return winnerPlace;
    }

    @Override
    public Map<String, Object> serialize() {
        return null;
    }
}
