package eu.tribusmc.tribusgiveaways;

import eu.tribusmc.tribusgiveaways.config.DataConfig;
import eu.tribusmc.tribusgiveaways.reward.RewardHolder;
import eu.tribusmc.tribusgiveaways.reward.RewardHolderCollector;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Core extends JavaPlugin {


    private RewardHolderCollector rewardHolderCollector;
    private DataConfig dataConfig;



    @Override
    public void onEnable() {
        dataConfig = new DataConfig(this);
        dataConfig.reloadCustomConfig();


        rewardHolderCollector = new RewardHolderCollector(this);


    }

    @Override
    public void onDisable() {

    }


    public DataConfig getDataConfig() {
        return dataConfig;
    }





}
