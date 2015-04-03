package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.*;

public class GiveCommand implements CommandExecutor
{
    Main plugin;
    
    public GiveCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("give").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 3) {
            this.senderPlayerAndConsole(sender, args);
        }
        else if (args.length == 2) {
            if (sender instanceof Player) {
                this.senderOnlyPlayer(sender, args);
                return true;
            }
            this.senderPlayerAndConsole(sender, args);
        }
        else if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/give <gracz> <id> [ilosc]");
                return true;
            }
            this.senderOnlyPlayer(sender, args);
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/give <gracz> <id> [ilosc]");
        }
        return false;
    }
    
    public boolean senderOnlyPlayer(final CommandSender sender, final String[] args) {
        final Player player = (Player)sender;
        String[] idAndData = args[0].split(":");
        Material material = Main.getMaterial(idAndData[0]);
        Player other = null;
        if (material == null) {
            if (args.length == 2) {
                idAndData = args[1].split(":");
                other = Bukkit.getPlayerExact(args[0]);
            }
            material = Main.getMaterial(idAndData[0]);
            if (material == null) {
                player.sendMessage("§cNie rozpoznano nazwy przedmiotu!");
                return true;
            }
        }
        if (other == null) {
            if (!Main.isInteger(args[0])) {
                player.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            if (args.length == 2) {
                other = Bukkit.getPlayerExact(player.getName());
                if (other == null) {
                    player.sendMessage("§cTen gracz nie jest Online!");
                    return true;
                }
            }
        }
        Short data = 0;
        if (idAndData.length > 1) {
            data = Short.valueOf(idAndData[1]);
        }
        int amount = 64;
        if (Bukkit.getPlayerExact(args[0]) != other && args.length == 2 && Main.isInteger(args[1])) {
            amount = Integer.parseInt(args[1]);
        }
        if (args.length == 1) {
            other = Bukkit.getPlayerExact(player.getName());
        }
        final ItemStack item = new ItemStack(material, amount, (short)data);
        if (player.getInventory().firstEmpty() >= 0) {
            other.getInventory().addItem(new ItemStack[] { item });
            other.sendMessage("§6Otrzymales §c" + material.name() + "§6(§c" + amount + "§6).");
            player.sendMessage("§c" + other.getName() + " §6otrzymal §c" + material.name() + "§6(§c" + amount + "§6).");
        }
        else {
            player.sendMessage("§c" + player.getName() + " §6nie ma miejsca w swoim ekwipunku!");
        }
        return false;
    }
    
    public boolean senderPlayerAndConsole(final CommandSender sender, final String[] args) {
        final Player other = Bukkit.getPlayerExact(args[0]);
        if (other == null) {
            sender.sendMessage("§cTen gracz nie jest Online!");
            return true;
        }
        final String[] idAndData = args[1].split(":");
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
        if (args.length == 3 && Main.isInteger(args[2])) {
            amount = Integer.parseInt(args[2]);
        }
        final ItemStack item = new ItemStack(material, amount, (short)data);
        if (other.getInventory().firstEmpty() >= 0) {
            other.getInventory().addItem(new ItemStack[] { item });
            other.sendMessage("§6Otrzymales §c" + material.name() + "§6(§c" + amount + "§6).");
            sender.sendMessage("§c" + other.getName() + " §6otrzymal §c" + material.name() + "§6(§c" + amount + "§6).");
        }
        else {
            sender.sendMessage("§c" + other.getName() + " §6nie ma miejsca w swoim ekwipunku!");
        }
        return false;
    }
}
