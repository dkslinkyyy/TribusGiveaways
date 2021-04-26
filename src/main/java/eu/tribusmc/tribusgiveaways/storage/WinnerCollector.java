package eu.tribusmc.tribusgiveaways.storage;

import eu.tribusmc.tribusgiveaways.Core;
import eu.tribusmc.tribusgiveaways.objects.Winner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WinnerCollector {

    private final Core core;

    public WinnerCollector(Core core) {
        this.core = core;
    }

    public List<Winner> getWinners() {
        return cast(core.getDataConfig().getCustomConfig().getList("Holders"));
    }

    public Winner fetchByUUID(UUID uuid) {
        return getWinners().stream().filter(self -> self.getPlayerUUID().equals(uuid)).findFirst().orElse(null);
    }

    public boolean isCollected(UUID uuid) {
        return fetchByUUID(uuid) != null;
    }


    public void collect(Winner winner) {
        List<Winner> tmp = null;

        if(core.getDataConfig().getCustomConfig().get("Holders") != null) {
            tmp = getWinners();
        }else{
            tmp = new ArrayList<>();
        }
        tmp.add(winner);
        core.getDataConfig().getCustomConfig().set("Holders", tmp);
        core.getDataConfig().saveConfig();
    }


    @SuppressWarnings("unchecked")
    private <T extends List<Winner>> T cast(Object obj) {
        return (T) obj;
    }
}
