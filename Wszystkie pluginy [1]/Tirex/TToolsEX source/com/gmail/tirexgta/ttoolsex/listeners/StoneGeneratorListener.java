package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

public class StoneGeneratorListener implements Listener
{
    Main plugin;
    
    public StoneGeneratorListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public static void onBlockBreak(final BlockBreakEvent e) {
        final Location loc = e.getBlock().getLocation();
        final Location locBlock = new Location(loc.getWorld(), loc.getX(), loc.getY() - 1.0, loc.getZ());
        if (locBlock.getBlock().getType().equals((Object)Material.DAYLIGHT_DETECTOR)) {
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getThis(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (loc.getBlock().getType().equals((Object)Material.AIR)) {
                        loc.getBlock().setType(Material.STONE);
                    }
                }
            }, 60L);
        }
    }
    
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {
        if (e.getItemInHand().getType().equals((Object)Material.DAYLIGHT_DETECTOR)) {
            final Location loc = e.getBlock().getLocation();
            final Location locBlock = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1.0, loc.getZ());
            if (locBlock.getBlock().getType().equals((Object)Material.AIR)) {
                Bukkit.getScheduler().runTaskLater((Plugin)Main.getThis(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (locBlock.getBlock().getType().equals((Object)Material.AIR)) {
                            locBlock.getBlock().setType(Material.STONE);
                        }
                    }
                }, 10L);
            }
        }
    }
}
