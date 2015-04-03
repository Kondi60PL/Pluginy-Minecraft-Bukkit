package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

public class BlockedStrenghtListener implements Listener
{
    Main plugin;
    
    public BlockedStrenghtListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerInteract(final BlockDispenseEvent e) {
        final ItemStack item = e.getItem();
        if (item.getType().equals((Object)Material.POTION) && item.getData().getData() == 41) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerInteract(final PlayerItemConsumeEvent e) {
        final ItemStack item = e.getItem();
        if (item.getType().equals((Object)Material.POTION) && item.getData().getData() == 41) {
            final Player p = e.getPlayer();
            if (!p.hasPermission("tirex.potion")) {
                p.sendMessage("§cNie masz uprawnien, aby pic ta miksture!");
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent e) {
        if (e.getAction().equals((Object)Action.RIGHT_CLICK_AIR)) {
            final ItemStack item = e.getItem();
            if (item.getType().equals((Object)Material.POTION) && item.getData().getData() == 41) {
                final Player p = e.getPlayer();
                if (!p.hasPermission("tirex.potion")) {
                    p.sendMessage("§cNie masz uprawnien, aby pic ta miksture!");
                    e.setCancelled(true);
                }
            }
        }
    }
}
