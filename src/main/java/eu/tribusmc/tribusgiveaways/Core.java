package eu.tribusmc.tribusgiveaways;

import eu.tribusmc.tribusgiveaways.config.DataConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {


    private DataConfig dataConfig;

    @Override
    public void onEnable() {

         dataConfig = new DataConfig(this);

         dataConfig.reloadCustomConfig();

    }

    @Override
    public void onDisable() {

    }





}
