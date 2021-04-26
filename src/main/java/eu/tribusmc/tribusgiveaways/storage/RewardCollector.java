package eu.tribusmc.tribusgiveaways.storage;

import eu.tribusmc.tribusgiveaways.Core;
import eu.tribusmc.tribusgiveaways.WinnerPlace;
import eu.tribusmc.tribusgiveaways.objects.Reward;
import eu.tribusmc.tribusgiveaways.objects.Winner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RewardCollector {

    private final Core core;

    public RewardCollector(Core core) {
        this.core = core;
    }

    public List<Reward> getRewards() {
        return cast(core.getDataConfig().getCustomConfig().getList("Rewards"));
    }

    public Reward fetchByWinnerPlace(WinnerPlace winnerPlace) {
        return getRewards().stream().filter(self -> self.getWinnerPlace().equals(winnerPlace)).findFirst().orElse(null);
    }

    public boolean isCollected(WinnerPlace winnerPlace) {
        return fetchByWinnerPlace(winnerPlace) != null;
    }


    public void collect(Reward reward) {
        List<Reward> tmp = null;

        if(core.getDataConfig().getCustomConfig().get("Rewards") != null) {
            tmp = getRewards();
        }else{
            tmp = new ArrayList<>();
        }
        tmp.add(reward);
        core.getDataConfig().getCustomConfig().set("Rewards", tmp);
        core.getDataConfig().saveConfig();
    }


    @SuppressWarnings("unchecked")
    private <T extends List<Reward>> T cast(Object obj) {
        return (T) obj;
    }

}
