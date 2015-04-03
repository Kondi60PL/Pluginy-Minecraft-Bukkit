package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.*;

public class ItemCommand implements CommandExecutor
{
    Main plugin;
    
    public ItemCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("item").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        final Player player = (Player)sender;
        if (args.length == 1 || args.length == 2) {
            final String[] idAndData = args[0].split(":");
            final Material material = Main.getMaterial(idAndData[0]);
            if (material == null) {
                sender.sendMessage("§cNie rozpoznano nazwy przedmiotu!");
                return true;
            }
            Short data = 0;
            if (idAndData.length > 1) {
                data = Short.valueOf(idAndData[1]);
            }
            int amount = 64;
            if (args.length == 2 && Main.isInteger(args[1])) {
                amount = Integer.parseInt(args[1]);
            }
            final ItemStack item = new ItemStack(material, amount, (short)data);
            if (player.getInventory().firstEmpty() < 0) {
                sender.sendMessage("§cNie masz miejsca w swoim ekwipunku!");
                return true;
            }
            player.getInventory().addItem(new ItemStack[] { item });
            player.sendMessage("§6Otrzymales §c" + material.name() + "§6:§c" + data + "§6(§c" + amount + "§6)");
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/item <id> [ilosc]");
        }
        return false;
    }
}
