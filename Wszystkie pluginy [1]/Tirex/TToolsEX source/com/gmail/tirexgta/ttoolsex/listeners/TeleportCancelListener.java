package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.entity.*;
import org.bukkit.scheduler.*;
import java.util.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class TeleportCancelListener implements Listener
{
    Main plugin;
    public HashMap<Player, BukkitTask> playerTeleportLocation;
    public List<Player> teleport;
    
    public TeleportCancelListener(final Main plugin) {
        super();
        this.playerTeleportLocation = new HashMap<Player, BukkitTask>();
        this.teleport = new ArrayList<Player>();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerMove(final PlayerMoveEvent event) {
        final Location from = event.getFrom();
        final Location to = event.getTo();
        if (from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ() || from.getWorld() != to.getWorld()) {
            final Player player = event.getPlayer();
            if (this.playerTeleportLocation.get(player) != null) {
                this.playerTeleportLocation.remove(player).cancel();
                player.sendMessage("§cTeleportacja anulowana!");
                if (this.teleport.contains(player)) {
                    this.teleport.remove(player);
                }
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerDamage(final EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            final Player player = (Player)event.getEntity();
            if (this.playerTeleportLocation.get(player) != null) {
                this.playerTeleportLocation.remove(player).cancel();
                player.sendMessage("§cTeleportacja anulowana!");
                if (this.teleport.contains(player)) {
                    this.teleport.remove(player);
                }
            }
        }
    }
}
