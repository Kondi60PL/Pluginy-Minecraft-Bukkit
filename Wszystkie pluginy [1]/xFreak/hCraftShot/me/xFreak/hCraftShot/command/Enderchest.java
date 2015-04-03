package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Enderchest implements CommandExecutor
{
    public Enderchest(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("enderchest") && args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "=-=-=-=-=-=-=-=" + ChatColor.RED + "Crafting" + ChatColor.YELLOW + "=-=-=-=-=-=-=-=");
            sender.sendMessage(ChatColor.YELLOW + "Enderchesta robisz w craftingu");
            sender.sendMessage(ChatColor.YELLOW + "W kolo dajesz obsidian, a w srodku ender pearl");
        }
        return false;
    }
}
