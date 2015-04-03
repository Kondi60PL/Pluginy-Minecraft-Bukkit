package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.material.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.event.block.*;
import org.bukkit.event.*;
import java.util.*;

public class RandomTeleportListener implements Listener
{
    Main plugin;
    public HashMap<Player, String> hasTypedCommand;
    
    public RandomTeleportListener(final Main plugin) {
        super();
        this.hasTypedCommand = new HashMap<Player, String>();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(final PlayerInteractEvent event) {
        final Block block = event.getClickedBlock();
        if (event.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK) && block.getType().equals((Object)Material.STONE_BUTTON)) {
            final Player player = event.getPlayer();
            final Location location = block.getLocation();
            if (this.hasTypedCommand.get(player) != null) {
                if (this.hasTypedCommand.get(player).equalsIgnoreCase("addgroups")) {
                    event.setCancelled(true);
                    if (!this.plugin.randomTeleportManager.isRandomTpGroups(location) && !this.plugin.randomTeleportManager.isRandomTp(location)) {
                        this.plugin.randomTeleportManager.addRandomTpGroups(location);
                        player.sendMessage("§9Dodano grupowy losowy teleport!");
                        this.hasTypedCommand.remove(player);
                        return;
                    }
                    player.sendMessage("§cTen guzik jest ju\u017c losowym teleportem!");
                    this.hasTypedCommand.remove(player);
                    return;
                }
                else if (this.hasTypedCommand.get(player).equalsIgnoreCase("deletegroups")) {
                    event.setCancelled(true);
                    if (this.plugin.randomTeleportManager.isRandomTpGroups(location)) {
                        this.plugin.randomTeleportManager.delRandomTpGroups(location);
                        player.sendMessage("§9Usunieto grupowy losowy teleport!");
                        this.hasTypedCommand.remove(player);
                        return;
                    }
                    player.sendMessage("§cTen guzik nie jest losowym teleportem!");
                    this.hasTypedCommand.remove(player);
                    return;
                }
                else if (this.hasTypedCommand.get(player).equalsIgnoreCase("add")) {
                    event.setCancelled(true);
                    if (!this.plugin.randomTeleportManager.isRandomTp(location) && !this.plugin.randomTeleportManager.isRandomTpGroups(location)) {
                        this.plugin.randomTeleportManager.addRandomTp(location);
                        player.sendMessage("§9Dodano losowy teleport!");
                        this.hasTypedCommand.remove(player);
                        return;
                    }
                    player.sendMessage("§cTen guzik jest ju\u017c losowym teleportem!");
                    this.hasTypedCommand.remove(player);
                    return;
                }
                else if (this.hasTypedCommand.get(player).equalsIgnoreCase("delete")) {
                    event.setCancelled(true);
                    if (this.plugin.randomTeleportManager.isRandomTp(location)) {
                        this.plugin.randomTeleportManager.delRandomTp(location);
                        player.sendMessage("§9Usunieto losowy teleport!");
                        this.hasTypedCommand.remove(player);
                        return;
                    }
                    player.sendMessage("§cTen guzik nie jest losowym teleportem!");
                    this.hasTypedCommand.remove(player);
                    return;
                }
            }
            if (this.plugin.randomTeleportManager.isRandomTpGroups(location)) {
                final Button buton = (Button)block.getState().getData();
                for (final Player p : this.getPlayersInRadius(block.getRelative(buton.getAttachedFace()).getLocation(), this.plugin.config.randomGroupRadius)) {
                    final int x = this.getRandom(this.plugin.config.randomMin, this.plugin.config.randomMax);
                    final int z = this.getRandom(this.plugin.config.randomMin, this.plugin.config.randomMax);
                    final Location loc = new Location(block.getWorld(), (double)x, 0.0, (double)z);
                    final Location randomLoc = new Location(loc.getWorld(), loc.getBlockX() + 0.5, (double)loc.getWorld().getHighestBlockYAt(loc), loc.getBlockZ() + 0.5);
                    p.teleport(randomLoc);
                    p.sendMessage("§aZostales teleportowany w losowe kordy!");
                }
            }
            else if (this.plugin.randomTeleportManager.isRandomTp(location)) {
                final int x2 = this.getRandom(this.plugin.config.randomMin, this.plugin.config.randomMax);
                final int z2 = this.getRandom(this.plugin.config.randomMin, this.plugin.config.randomMax);
                final Location loc2 = new Location(block.getWorld(), (double)x2, 0.0, (double)z2);
                final Location randomLoc2 = new Location(loc2.getWorld(), loc2.getBlockX() + 0.5, (double)loc2.getWorld().getHighestBlockYAt(loc2), loc2.getBlockZ() + 0.5);
                player.teleport(randomLoc2);
                player.sendMessage("§aZostales teleportowany w losowe kordy!");
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockBreak(final BlockBreakEvent event) {
        final Location location = event.getBlock().getLocation();
        if (event.getBlock().getType().equals((Object)Material.STONE_BUTTON)) {
            final Player player = event.getPlayer();
            if (this.plugin.randomTeleportManager.isRandomTpGroups(location) || this.plugin.randomTeleportManager.isRandomTp(location)) {
                event.setCancelled(true);
                player.sendMessage("§9Nie mozesz zniszczyc losowego teleportu!");
            }
        }
    }
    
    public List<Player> getPlayersInRadius(final Location loc, final int size) {
        final List<Player> gracze = new ArrayList<Player>();
        for (final Player player : loc.getWorld().getPlayers()) {
            if (loc.distance(player.getLocation()) <= size) {
                gracze.add(player);
            }
        }
        return gracze;
    }
    
    public int getRandom(final int lower, final int upper) {
        final Random random = new Random();
        return random.nextInt(upper - lower + 1) + lower;
    }
}
