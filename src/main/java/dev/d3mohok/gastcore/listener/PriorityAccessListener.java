package dev.d3mohok.gastcore.listener;

import dev.d3mohok.gastcore.manager.ConfigManager;
import dev.d3mohok.gastcore.utils.HexColor;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

@RequiredArgsConstructor
public class PriorityAccessListener implements Listener {

    private static final String FULL_PERMISSION = "gastcore.fullserver";

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        FileConfiguration config = ConfigManager.getConfig();

        if (!config.getBoolean("priority-access.enabled")) {
            return;
        }
        int normalLimit = config.getInt("priority-access.normal-limit");
        int maxLimit = config.getInt("priority-access.max-limit");

        String fullMessage = config.getString("messages.kick-full");
        String priorityMessage = config.getString("messages.priority");

        int online = Bukkit.getOnlinePlayers().size();

        if (online < normalLimit) return;

        if (online < maxLimit) {
            if (event.getPlayer().hasPermission(FULL_PERMISSION)) return;

            String message = priorityMessage.replace("{permission}", FULL_PERMISSION);
            event.disallow(PlayerLoginEvent.Result.KICK_FULL, HexColor.colorize(message));
            return;
        }
        event.disallow(PlayerLoginEvent.Result.KICK_FULL, HexColor.colorize(fullMessage));
    }
}