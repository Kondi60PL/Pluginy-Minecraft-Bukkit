package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import com.gmail.tirexgta.ttoolsex.database.*;

public class HomeCommand implements CommandExecutor
{
    Main plugin;
    
    public HomeCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("home").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
            return true;
        }
        final Player player = (Player)sender;
        final DataUser user = Datasource.getUserData(player);
        if (this.plugin.teleportCancelListener.teleport.contains(player)) {
            player.sendMessage("§cPoczekaj az sie steleportujesz!");
            return true;
        }
        if (user.getHomeWorld() == null) {
            player.sendMessage("§cNie ustawiles domu!");
            return true;
        }
        final Location homeLocation = new Location(Bukkit.getWorld(user.getHomeWorld()), user.getHomeX() + 0.5, (double)user.getHomeY(), user.getHomeZ() + 0.5);
        if (!player.hasPermission("tirex.home.teleport")) {
            player.sendMessage("§6Twoj kompas wskazuje teraz na dom.");
            player.sendMessage("§6Ranga ViP wymaga do teleportacji do domu!");
            player.setCompassTarget(homeLocation);
            return true;
        }
        if (player.hasPermission("tirex.home.nodelay")) {
            player.sendMessage("§6Przeteleportowano do domu!");
            player.teleport(homeLocation);
            return true;
        }
        player.sendMessage("§6Teleport rozgrzewa sie...");
        if (!this.plugin.teleportCancelListener.teleport.contains(player)) {
            this.plugin.teleportCancelListener.teleport.add(player);
        }
        Main.teleportPlayerWithDelay(player, this.plugin.config.teleportDelay, homeLocation, "§6Przeteleportowano do domu!", null);
        return false;
    }
}
