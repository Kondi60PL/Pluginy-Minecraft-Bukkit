package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Broadcast implements CommandExecutor
{
    public Broadcast(final Main Plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("livenuse") && sender.hasPermission("hc.livenuse") && args.length == 0) {
            Bukkit.broadcastMessage(ChatColor.BLUE + "[" + ChatColor.GRAY + "Alert" + ChatColor.BLUE + "]" + ChatColor.GOLD + " Zapraszamy bardzo serdecznie na livestream:" + ChatColor.AQUA + " www.twitch.tv/xTheBitzer");
        }
        return false;
    }
}
