package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class BroadcastLive2 implements CommandExecutor
{
    public BroadcastLive2(final Main Plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("liveseby") && sender.hasPermission("hc.liveseby") && args.length == 0) {
            Bukkit.broadcastMessage(String.valueOf(Main.getPrefix) + ChatColor.GOLD + "Zapraszamy bardzo serdecznie na livestream:" + ChatColor.AQUA + " www.twitch.tv/xsebaplaygames");
        }
        return false;
    }
}
