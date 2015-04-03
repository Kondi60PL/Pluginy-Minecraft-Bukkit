package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;

public class WelcomeMessageListener implements Listener
{
    Main plugin;
    
    public WelcomeMessageListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            player.teleport(player.getWorld().getSpawnLocation());
        }
        if (player.hasPermission("tirex.welcomemessage")) {
            for (String line : this.plugin.config.welcomeMessage) {
                line = line.replace("&", "§");
                line = line.replace("{odwiedzilo}", String.valueOf(this.plugin.data.users.size()));
                line = line.replace("{playername}", player.getName());
                line = line.replace("{online}", String.valueOf(this.plugin.slot()));
                player.sendMessage(line);
            }
        }
    }
}
