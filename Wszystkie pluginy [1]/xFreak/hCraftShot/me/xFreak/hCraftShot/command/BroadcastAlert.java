package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class BroadcastAlert implements CommandExecutor
{
    public BroadcastAlert(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("alert") && sender.hasPermission("hc.bc") && args.length == 0) {
            sender.sendMessage(ChatColor.BLUE + "Alert jest tymczasowo wylaczony");
            if (args.length == 1 && args[0].equals("lista")) {
                sender.sendMessage("test");
            }
        }
        return false;
    }
}
