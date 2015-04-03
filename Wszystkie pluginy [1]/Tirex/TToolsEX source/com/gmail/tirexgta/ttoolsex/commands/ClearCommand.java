package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class ClearCommand implements CommandExecutor
{
    Main plugin;
    
    public ClearCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("clear").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GOLD + " /clear <gracz>");
                return true;
            }
            final Player other = Bukkit.getPlayerExact(sender.getName());
            other.getInventory().clear();
            other.getInventory().setHelmet((ItemStack)null);
            other.getInventory().setChestplate((ItemStack)null);
            other.getInventory().setLeggings((ItemStack)null);
            other.getInventory().setBoots((ItemStack)null);
            other.getInventory().setHeldItemSlot(0);
            other.sendMessage("§6Twoj ekwipunek zostal wyczyszczony!");
            return true;
        }
        else {
            if (args.length != 1) {
                return false;
            }
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            other.getInventory().clear();
            other.getInventory().setHelmet((ItemStack)null);
            other.getInventory().setChestplate((ItemStack)null);
            other.getInventory().setLeggings((ItemStack)null);
            other.getInventory().setBoots((ItemStack)null);
            other.getInventory().setHeldItemSlot(0);
            other.sendMessage("§6Twoj ekwipunek zostal wyczyszczony przez gracza §c" + sender.getName() + "§6!");
            sender.sendMessage(ChatColor.GOLD + "Ekwipunek gracza " + ChatColor.RED + other.getName() + ChatColor.GOLD + " zostal wyczyszczony!");
            return true;
        }
    }
}
