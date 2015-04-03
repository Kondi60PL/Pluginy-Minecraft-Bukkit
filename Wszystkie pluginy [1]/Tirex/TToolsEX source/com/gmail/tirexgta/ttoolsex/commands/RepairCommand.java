package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class RepairCommand implements CommandExecutor
{
    Main plugin;
    Material[] canRepair;
    
    public RepairCommand(final Main plugin) {
        super();
        this.canRepair = new Material[] { Material.DIAMOND_PICKAXE, Material.DIAMOND_SWORD, Material.DIAMOND_SPADE, Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.IRON_PICKAXE, Material.IRON_SWORD, Material.IRON_SPADE, Material.IRON_AXE, Material.IRON_HOE, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.GOLD_PICKAXE, Material.GOLD_SWORD, Material.GOLD_SPADE, Material.GOLD_AXE, Material.GOLD_HOE, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, Material.STONE_PICKAXE, Material.STONE_SWORD, Material.STONE_SPADE, Material.STONE_AXE, Material.STONE_HOE, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, Material.WOOD_PICKAXE, Material.WOOD_SWORD, Material.WOOD_SPADE, Material.WOOD_AXE, Material.WOOD_HOE, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.FLINT_AND_STEEL, Material.SHEARS, Material.BOW, Material.FISHING_ROD, Material.ANVIL };
        this.plugin = plugin;
        this.plugin.getCommand("repair").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        if (args.length == 0) {
            final Player p = (Player)sender;
            final ItemStack itemHand = p.getItemInHand();
            if (itemHand == null) {
                sender.sendMessage("§cNie masz zadnego przedmiotu w rece!");
                return true;
            }
            if (itemHand.getDurability() < 1) {
                sender.sendMessage("§cNie masz przedmiotu w rece, ktorego moglbys naprawic!");
                return true;
            }
            final short durability = 0;
            itemHand.setDurability(durability);
            sender.sendMessage("§6Pomyslnie naprawiono przedmiot, ktory trzymasz w rece!");
        }
        else if (args.length == 1) {
            final Player p = (Player)sender;
            if (args[0].equalsIgnoreCase("all")) {
                int ilosc = 0;
                ItemStack[] contents;
                for (int length = (contents = p.getInventory().getContents()).length, i = 0; i < length; ++i) {
                    final ItemStack item = contents[i];
                    if (item != null && item.getDurability() > 0) {
                        final short durability2 = 0;
                        item.setDurability(durability2);
                        ++ilosc;
                    }
                }
                ItemStack[] armorContents;
                for (int length2 = (armorContents = p.getInventory().getArmorContents()).length, j = 0; j < length2; ++j) {
                    final ItemStack item = armorContents[j];
                    if (item != null && item.getDurability() > 0) {
                        final short durability2 = 0;
                        item.setDurability(durability2);
                        ++ilosc;
                    }
                }
                if (ilosc != 0) {
                    sender.sendMessage("§6Pomyslnie naprawiono §c" + ilosc + " §6przedmiotow!");
                }
                else {
                    sender.sendMessage("§cNie masz przedmiotow, ktore moglbys naprawic!");
                }
            }
            else {
                sender.sendMessage("§cDostepne argumenty: §6all");
            }
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/repair [argument]");
        }
        return false;
    }
}
