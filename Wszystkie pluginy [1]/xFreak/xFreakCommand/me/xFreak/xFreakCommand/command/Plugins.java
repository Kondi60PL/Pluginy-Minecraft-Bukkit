package me.xFreak.xFreakCommand.command;

import me.xFreak.xFreakCommand.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Plugins implements CommandExecutor
{
    public Plugins(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("pl") && args.length == 0) {
            sender.sendMessage(ChatColor.BLUE + "Sprawdzanie pluginow jest zabronione!");
        }
        return false;
    }
}
