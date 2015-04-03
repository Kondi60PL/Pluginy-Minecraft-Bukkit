package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

public class DispensersListener implements Listener
{
    Main plugin;
    public HashMap<Player, String> hasTypedCommand;
    
    public DispensersListener(final Main plugin) {
        super();
        this.hasTypedCommand = new HashMap<Player, String>();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(final PlayerInteractEvent event) {
        final Block block = event.getClickedBlock();
        if (event.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK) && block.getType().equals((Object)Material.DISPENSER)) {
            final Player player = event.getPlayer();
            if (this.hasTypedCommand.get(player) != null) {
                if (this.hasTypedCommand.get(player).equalsIgnoreCase("add")) {
                    event.setCancelled(true);
                    final Location location = block.getLocation();
                    if (!this.plugin.dispensersManager.isUnlimitedDispenser(location)) {
                        this.plugin.dispensersManager.addDispenser(location);
                        player.sendMessage(ChatColor.BLUE + "Dodano nieskonczony dispenser!");
                        this.hasTypedCommand.remove(player);
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "Ten dispenser jest juz nieskonczony!");
                        this.hasTypedCommand.remove(player);
                    }
                }
                else if (this.hasTypedCommand.get(player).equalsIgnoreCase("delete")) {
                    event.setCancelled(true);
                    final Location location = block.getLocation();
                    if (this.plugin.dispensersManager.isUnlimitedDispenser(location)) {
                        this.plugin.dispensersManager.delDispenser(location);
                        player.sendMessage(ChatColor.BLUE + "Usunieto nieskonczony dispenser!");
                        this.hasTypedCommand.remove(player);
                        final Dispenser dispenser = (Dispenser)event.getClickedBlock().getState();
                        dispenser.getInventory().clear();
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "Ten dispenser nie jest nieskonczony!");
                        this.hasTypedCommand.remove(player);
                    }
                }
                else if (!player.hasPermission("tools.dispensers.open")) {
                    event.setCancelled(true);
                }
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBlockDispense(final BlockDispenseEvent event) {
        final Location location = event.getBlock().getLocation();
        if (this.plugin.dispensersManager.isUnlimitedDispenser(location)) {
            final Dispenser dispenser = (Dispenser)event.getBlock().getState();
            final ItemStack item = event.getItem();
            dispenser.getInventory().addItem(new ItemStack[] { item.clone() });
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockBreak(final BlockBreakEvent event) {
        final Location location = event.getBlock().getLocation();
        if (event.getBlock().getType().equals((Object)Material.DISPENSER)) {
            final Player player = event.getPlayer();
            if (this.plugin.dispensersManager.isUnlimitedDispenser(location)) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "Nie mozesz znisczyc nieskonczonego dispenser'a!");
            }
        }
    }
}
