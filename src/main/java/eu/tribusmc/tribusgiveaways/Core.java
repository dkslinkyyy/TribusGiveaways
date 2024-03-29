package eu.tribusmc.tribusgiveaways;

import eu.tribusmc.tribusgiveaways.commands.GiveawayCommand;
import eu.tribusmc.tribusgiveaways.config.DataConfig;
import eu.tribusmc.tribusgiveaways.listener.PlayerJoinListener;
import eu.tribusmc.tribusgiveaways.objects.Winner;
import eu.tribusmc.tribusgiveaways.storage.RewardCollector;
import eu.tribusmc.tribusgiveaways.storage.WinnerCollector;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {


    public static Core i;

    private WinnerCollector winnerCollector;
    private RewardCollector rewardCollector;
    private DataConfig dataConfig;



    static {
        ConfigurationSerialization.registerClass(Winner.class);
    }

    @Override
    public void onEnable() {
        i = this;
        dataConfig = new DataConfig(this);
        dataConfig.reloadCustomConfig();


        winnerCollector = new WinnerCollector(this);
        rewardCollector = new RewardCollector(this);

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

        new GiveawayCommand();
    }

    @Override
    public void onDisable() {

    }






    public DataConfig getDataConfig() {
        return dataConfig;
    }


    public WinnerCollector getWinnerCollector() {
        return winnerCollector;
    }

    public RewardCollector getRewardCollector() {
        return rewardCollector;
    }
}
