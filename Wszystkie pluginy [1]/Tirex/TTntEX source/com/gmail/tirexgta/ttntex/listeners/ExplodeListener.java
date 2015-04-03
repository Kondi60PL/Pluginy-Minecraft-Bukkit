package com.gmail.tirexgta.ttntex.listeners;

import com.gmail.tirexgta.ttntex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.entity.*;
import org.bukkit.block.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.apache.commons.lang.*;
import java.util.*;

public class ExplodeListener implements Listener
{
    Main plugin;
    
    public ExplodeListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityExplode(final EntityExplodeEvent e) {
        if (e.isCancelled()) {
            return;
        }
        final Location loc = e.getLocation();
        final World world = loc.getWorld();
        final double x = loc.getX();
        final double y = loc.getY();
        final double z = loc.getZ();
        final List<Block> list = new ArrayList<Block>();
        final int radius = this.plugin.getConfigManager().radius;
        final Location locB1 = new Location(world, x + radius, y + radius, z + radius);
        final Location locB2 = new Location(world, x - radius, y - radius, z - radius);
        final int maxX = locB1.getBlockX();
        final int maxY = locB1.getBlockY();
        final int maxZ = locB1.getBlockZ();
        final int minX = locB2.getBlockX();
        final int minY = locB2.getBlockY();
        final int minZ = locB2.getBlockZ();
        for (int x2 = minX; x2 <= maxX; ++x2) {
            for (int y2 = minY; y2 <= maxY; ++y2) {
                for (int z2 = minZ; z2 <= maxZ; ++z2) {
                    final Location locB3 = new Location(world, (double)x2, (double)y2, (double)z2);
                    list.add(locB3.getBlock());
                }
            }
        }
        for (final Block block : list) {
            if (block.getType().equals((Object)Material.STATIONARY_WATER)) {
                final double chance = this.plugin.getConfigManager().chanceWater;
                if (!this.getChance(chance)) {
                    continue;
                }
                block.setType(Material.AIR);
            }
            else if (block.getType().equals((Object)Material.STATIONARY_LAVA)) {
                final double chance = this.plugin.getConfigManager().chanceLava;
                if (!this.getChance(chance)) {
                    continue;
                }
                block.setType(Material.AIR);
            }
            else {
                if (!block.getType().equals((Object)Material.OBSIDIAN)) {
                    continue;
                }
                final double chance = this.plugin.getConfigManager().chanceObsidian;
                if (!this.getChance(chance)) {
                    continue;
                }
                block.setType(Material.AIR);
            }
        }
    }
    
    public double getRandpDouble(final double min, final double max) throws IllegalArgumentException {
        Validate.isTrue(max > min, "Max can't be smaller than min!");
        return new Random().nextDouble() * (max - min) + min;
    }
    
    public boolean getChance(final double chance) {
        return chance >= 100.0 || chance >= this.getRandpDouble(0.0, 100.0);
    }
}
