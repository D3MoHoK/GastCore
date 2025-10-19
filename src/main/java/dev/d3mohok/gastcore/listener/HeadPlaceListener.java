package dev.d3mohok.gastcore.listener;

import dev.d3mohok.gastcore.manager.ConfigManager;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class HeadPlaceListener implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Material placedType = event.getBlockPlaced().getType();
        if (placedType == Material.PLAYER_HEAD || placedType == Material.PLAYER_WALL_HEAD) {
            FileConfiguration config = ConfigManager.getConfig();
            if (config.getBoolean("head-protection")) {
                event.setCancelled(true);
            }
        }

    }
}