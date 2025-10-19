package dev.d3mohok.gastcore;

import dev.d3mohok.gastcore.listener.HeadPlaceListener;
import dev.d3mohok.gastcore.manager.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public void onEnable() {
        ConfigManager.loadYaml(this);
        this.getServer().getPluginManager().registerEvents(new HeadPlaceListener(), this);
    }
}