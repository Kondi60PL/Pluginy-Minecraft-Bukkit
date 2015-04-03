package me.xFreak.xFreakDrop.command;

import me.xFreak.xFreakDrop.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Stone implements CommandExecutor
{
    public Stone(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("stone") && args.length == 0) {
            sender.sendMessage(ChatColor.BLACK + "==========================");
            sender.sendMessage(ChatColor.GRAY + "> Diamenty" + ChatColor.GOLD + " 0.8" + ChatColor.GRAY + " Wysokosc " + ChatColor.GOLD + "25");
            sender.sendMessage(ChatColor.GRAY + "> Wegiel" + ChatColor.GOLD + " 2" + ChatColor.GRAY + " Wysokosc " + ChatColor.GOLD + "64");
            sender.sendMessage(ChatColor.GRAY + "> Zelazo" + ChatColor.GOLD + " 2" + ChatColor.GRAY + " Wysokosc " + ChatColor.GOLD + "55");
            sender.sendMessage(ChatColor.GRAY + "> Perelki" + ChatColor.GOLD + " 0.3" + ChatColor.GRAY + " Wysokosc " + ChatColor.GOLD + "25");
            sender.sendMessage(ChatColor.GRAY + "> Zloto" + ChatColor.GOLD + " 2" + ChatColor.GRAY + " Wysokosc " + ChatColor.GOLD + "25");
            sender.sendMessage(ChatColor.GRAY + "> Redstone" + ChatColor.GOLD + " 2" + ChatColor.GRAY + " Wysokosc " + ChatColor.GOLD + "25");
            sender.sendMessage(ChatColor.GRAY + "> Emerald" + ChatColor.GOLD + " 2" + ChatColor.GRAY + " Wysokosc " + ChatColor.GOLD + "25");
            sender.sendMessage(ChatColor.GRAY + "> Jablka" + ChatColor.GOLD + " 0.3" + ChatColor.GRAY + " Wysokosc " + ChatColor.GOLD + "25");
            sender.sendMessage(ChatColor.BLACK + "==========================");
        }
        return false;
    }
}
