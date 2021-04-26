package eu.tribusmc.tribusgiveaways.objects;

import eu.tribusmc.tribusgiveaways.WinnerPlace;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reward implements Cloneable, ConfigurationSerializable {

    private WinnerPlace winnerPlace;
    private List<String> cmds;


    public Reward(WinnerPlace paramWinnerPlace, List<String> paramCommands) {
        this.winnerPlace = paramWinnerPlace;
        this.cmds = paramCommands;
    }


    public WinnerPlace getWinnerPlace() {
        return winnerPlace;
    }

    public List<String> getCommands() {
        return cmds;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serialized = new HashMap<>();
        serialized.put("winnerPlace", winnerPlace );
        serialized.put("commands", cmds);

        return serialized;
    }
}
