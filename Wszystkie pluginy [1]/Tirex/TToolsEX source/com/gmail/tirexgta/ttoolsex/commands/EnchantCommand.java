package com.gmail.tirexgta.ttoolsex.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;

public class EnchantCommand implements CommandExecutor
{
    Main plugin;
    
    public EnchantCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("enchant").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wykonana z konsoli!");
            return true;
        }
        if (args.length < 1 || args.length > 2) {
            sender.sendMessage("§cPoprawne uzycie: §6/enchant <enchant> [poziom]");
            return true;
        }
        final Player player = (Player)sender;
        final ItemStack item = player.getItemInHand();
        final String enchantmentName = args[0];
        final Enchantment enchant = Enchantments.getEnchantment(enchantmentName);
        if (enchant == null) {
            player.sendMessage("§cNie znaleziono podanego enchantu!");
            return true;
        }
        int level = enchant.getMaxLevel();
        if (args.length == 2) {
            level = Integer.parseInt(args[1]);
        }
        item.addUnsafeEnchantment(enchant, level);
        player.sendMessage(ChatColor.GOLD + "Zaklecie " + ChatColor.RED + enchant.getName() + ChatColor.GOLD + " zostalo nalozone na przedmiot w rece.");
        return false;
    }
}
