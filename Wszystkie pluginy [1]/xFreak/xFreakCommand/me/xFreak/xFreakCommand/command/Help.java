package me.xFreak.xFreakCommand.command;

import me.xFreak.xFreakCommand.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Help implements CommandExecutor
{
    public Help(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("help") && args.length == 0) {
            sender.sendMessage(ChatColor.BLUE + "Komenda jest zablokowana!");
            if (args.length == 1 && args[0].equals("lista")) {
                sender.sendMessage("test");
            }
        }
        return false;
    }
}
