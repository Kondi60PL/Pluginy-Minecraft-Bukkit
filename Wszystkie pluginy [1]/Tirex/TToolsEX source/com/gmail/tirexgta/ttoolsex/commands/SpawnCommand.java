package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class SpawnCommand implements CommandExecutor
{
    Main plugin;
    
    public SpawnCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("spawn").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        final Player player = (Player)sender;
        if (this.plugin.teleportCancelListener.teleport.contains(player)) {
            sender.sendMessage("§cPoczekaj az sie steleportujesz!");
            return true;
        }
        final long lastTeleport = this.plugin.lastTeleportManager.getPlayerLastTeleport(player);
        final long waitTeleport = (lastTeleport - System.currentTimeMillis()) / 1000L;
        final Location spawnLocPlayer = player.getWorld().getSpawnLocation();
        final Location spawnLoc = new Location(player.getWorld(), spawnLocPlayer.getBlockX() + 0.5, (double)spawnLocPlayer.getBlockY(), spawnLocPlayer.getBlockZ() + 0.5);
        if (player.hasPermission("tirex.spawn.nocooldown")) {
            if (player.hasPermission("tirex.spawn.nodelay")) {
                player.teleport(spawnLoc);
                player.sendMessage("§6Przeteleportowano na spawn!");
            }
            else {
                Main.teleportPlayerWithDelay(player, this.plugin.config.teleportDelay, spawnLoc, "§6Przeteleportowano na spawn!", null);
                player.sendMessage("§6Teleport rozgrzewa sie...");
            }
        }
        else if (System.currentTimeMillis() - this.plugin.config.teleportSpawnCooldown * 1000 > lastTeleport) {
            if (player.hasPermission("tirex.spawn.nodelay")) {
                this.plugin.lastTeleportManager.setPlayerLastTeleport(player, System.currentTimeMillis());
                player.teleport(spawnLoc);
                player.sendMessage("§6Przeteleportowano na spawn!");
            }
            else {
                Main.teleportPlayerWithDelay(player, this.plugin.config.teleportDelay, spawnLoc, "§6Przeteleportowano na spawn!", new Runnable() {
                    @Override
                    public void run() {
                        SpawnCommand.this.plugin.lastTeleportManager.setPlayerLastTeleport(player, System.currentTimeMillis());
                    }
                });
                player.sendMessage("§6Teleport rozgrzewa sie...");
            }
        }
        else {
            player.sendMessage("§cNastepna teleporta na spawn za §6" + waitTeleport / 60L + " §cmin.");
            player.sendMessage("§6Koordynaty spawnu to: x: §c" + player.getWorld().getSpawnLocation().getBlockX() + " §6z: §c" + player.getWorld().getSpawnLocation().getBlockZ());
            player.sendMessage("§6Twoj kompas kieruje teraz na spawn!");
            player.setCompassTarget(player.getWorld().getSpawnLocation());
        }
        return false;
    }
}
