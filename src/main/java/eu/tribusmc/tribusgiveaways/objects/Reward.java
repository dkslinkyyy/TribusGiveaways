package eu.tribusmc.tribusgiveaways.objects;

import eu.tribusmc.tribusgiveaways.WinnerPlace;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.ConfigurationSerialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reward implements Cloneable, ConfigurationSerializable {

    private WinnerPlace winnerPlace;
    private List<String> cmds;
    private String command;


    public Reward(WinnerPlace paramWinnerPlace, String paramCommand) {
        this.winnerPlace = paramWinnerPlace;
        this.command = paramCommand;

        cmds = new ArrayList<>();
        cmds.add(paramCommand);
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
