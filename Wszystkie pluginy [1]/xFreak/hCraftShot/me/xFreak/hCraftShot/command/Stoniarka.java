package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Stoniarka implements CommandExecutor
{
    public Stoniarka(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("stoniarka") && args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "=-=-=-=-=-=-=-=" + ChatColor.RED + "Crafting" + ChatColor.YELLOW + "=-=-=-=-=-=-=-=");
            sender.sendMessage(ChatColor.YELLOW + "Stoniarke robisz w craftingu!");
            sender.sendMessage(ChatColor.YELLOW + "W kolo dajesz 8 stona, a na srodku piston");
        }
        return false;
    }
}
