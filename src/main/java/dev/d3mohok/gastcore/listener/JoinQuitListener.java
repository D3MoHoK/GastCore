// JoinQuitListener.java

package dev.d3mohok.gastcore.listener;

import dev.d3mohok.gastcore.manager.ConfigManager;
import lombok.NonNull;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {

    private final boolean hideDefaultMessages;

    public JoinQuitListener() {
        FileConfiguration config = ConfigManager.getConfig();
        hideDefaultMessages = config.getBoolean("settings.hide-default-join-quit");
    }

    @EventHandler
    public void onPlayerJoin(@NonNull PlayerJoinEvent event) {
        if (this.hideDefaultMessages) {
            event.setJoinMessage(null);
        }
    }

    @EventHandler
    public void onPlayerQuit(@NonNull PlayerQuitEvent event) {
        if (this.hideDefaultMessages) {
            event.setQuitMessage(null);
        }
    }
}