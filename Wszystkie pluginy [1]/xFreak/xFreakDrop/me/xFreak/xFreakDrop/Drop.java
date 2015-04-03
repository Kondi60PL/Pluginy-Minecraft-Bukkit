package me.xFreak.xFreakDrop;

import java.util.*;
import org.apache.commons.lang.*;
import org.bukkit.event.block.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class Drop implements Listener
{
    Random rand;
    
    public Drop(final Main instance) {
        super();
        this.rand = new Random();
    }
    
    public double getRandomDouble(final double min, final double max) throws IllegalArgumentException {
        Validate.isTrue(max > min, "Max nie moze byc mniejszy niz min");
        return this.rand.nextDouble() * (max - min) + min;
    }
    
    public boolean getChance(final double chance) {
        return chance >= 100.0 || chance >= this.getRandomDouble(0.0, 100.0);
    }
    
    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        final Block b = e.getBlock();
        if (b.getType() == Material.STONE) {
            if (p.getLocation().getBlockY() <= 55 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(2.0)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.IRON_ORE, 1));
                BarAPI.setMessage(p, "§6Znalazles: §7Zelazo §0| §61 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 55 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(1.0)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.IRON_ORE, 3));
                BarAPI.setMessage(p, "§6Znalazles: §7Zelazo §0| §63 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 55 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.5)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.IRON_ORE, 2));
                BarAPI.setMessage(p, "§6Znalazles: §7Zelazo §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.3)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.APPLE, 1));
                BarAPI.setMessage(p, "§6Znalazles: §4Jablka §0| §61 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.2)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.APPLE, 2));
                BarAPI.setMessage(p, "§6Znalazles: §4Jablka §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.1)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.APPLE, 3));
                BarAPI.setMessage(p, "§6Znalazles: §4Jablka §0| §63 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(2.0)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.EMERALD, 1));
                BarAPI.setMessage(p, "§6Znalazles: §aEmerald §0| §61 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.2)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.EMERALD, 2));
                BarAPI.setMessage(p, "§6Znalazles: §aEmerald §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.1)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.EMERALD, 3));
                BarAPI.setMessage(p, "§6Znalazles: §aEmerald §0| §63 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(2.0)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.REDSTONE, 1));
                BarAPI.setMessage(p, "§6Znalazles: §cRedstone §0| §61 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.2)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.REDSTONE, 2));
                BarAPI.setMessage(p, "§6Znalazles: §cRedstone §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.3)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.REDSTONE, 3));
                BarAPI.setMessage(p, "§6Znalazles: §cRedstone §0| §63 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.3)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.ENDER_PEARL, 1));
                BarAPI.setMessage(p, "§6Znalazles: §bPerle §0| §61 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.2)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.ENDER_PEARL, 2));
                BarAPI.setMessage(p, "§6Znalazles: §bPerle §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.1)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.ENDER_PEARL, 3));
                BarAPI.setMessage(p, "§6Znalazles: §bPerle §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.8)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.DIAMOND, 1));
                BarAPI.setMessage(p, "§6Znalazles: §3Diament §0| §61 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.2)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.DIAMOND, 2));
                BarAPI.setMessage(p, "§6Znalazles: §3Diament §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.1)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.DIAMOND, 3));
                BarAPI.setMessage(p, "§6Znalazles: §3Diament §0| §63 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 64 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(2.0)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COAL, 1));
                BarAPI.setMessage(p, "§6Znalazles: §8Wegiel §0| §61 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 64 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(1.0)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COAL, 2));
                BarAPI.setMessage(p, "§6Znalazles: §8Wegiel §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 64 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.5)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COAL, 3));
                BarAPI.setMessage(p, "§6Znalazles: §8Wegiel §0| §63 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(2.0)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.GOLD_ORE, 1));
                BarAPI.setMessage(p, "§6Znalazles: §eZloto §0| §61 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.2)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.GOLD_ORE, 2));
                BarAPI.setMessage(p, "§6Znalazles: §eZloto §0| §62 szt.", 5);
            }
            if (p.getLocation().getBlockY() <= 25 && p.getGameMode() == GameMode.SURVIVAL && this.getChance(0.1)) {
                b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.GOLD_ORE, 3));
                BarAPI.setMessage(p, "§6Znalazles: §eZloto §0| §63 szt.", 5);
            }
        }
        if (b.getType() == Material.IRON_ORE || b.getType() == Material.LAPIS_ORE || b.getType() == Material.EMERALD_ORE || b.getType() == Material.REDSTONE_ORE || b.getType() == Material.COAL_ORE || b.getType() == Material.GOLD_ORE || b.getType() == Material.DIAMOND_ORE) {
            b.setType(Material.AIR);
            p.sendMessage(ChatColor.GOLD + "§6*" + " §cTa rude wydobedziesz tylko z kamienia!");
        }
    }
}
