package eu.tribusmc.tribusgiveaways.reward;

import eu.tribusmc.tribusgiveaways.Core;

import java.util.List;
import java.util.UUID;

public class RewardHolderCollector {

    private final Core core;

    public RewardHolderCollector(Core core) {
        this.core = core;
    }

    public List<RewardHolder> getRewardHolders() {
        return cast(core.getDataConfig().getCustomConfig().getList("Holders"));
    }

    public RewardHolder fetchByUUID(UUID uuid) {
        return getRewardHolders().stream().filter(self -> self.getPlayerUUID().equals(uuid)).findFirst().orElse(null);
    }

    public boolean isCollected(UUID uuid) {
        return fetchByUUID(uuid) != null;
    }


    public void collect(RewardHolder rewardHolder) {
        getRewardHolders().add(rewardHolder);
        core.getDataConfig().getCustomConfig().set("Holders", getRewardHolders());
        core.getDataConfig().saveConfig();
    }


    @SuppressWarnings("unchecked")
    private  <T extends List<RewardHolder>> T cast(Object obj) {
        return (T) obj;
    }
}
