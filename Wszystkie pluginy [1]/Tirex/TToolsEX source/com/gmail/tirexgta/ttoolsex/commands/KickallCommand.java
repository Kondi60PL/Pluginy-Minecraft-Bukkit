package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class KickallCommand implements CommandExecutor
{
    Main plugin;
    
    public KickallCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("kickall").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final StringBuilder sb = new StringBuilder("§8[§9Kick§aAll§8]§r\n");
        for (int i = 0; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
        }
        final String arg = sb.toString();
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
            final Player online = onlinePlayers[j];
            if (!online.hasPermission("tirex.kickall.bypass")) {
                online.kickPlayer(this.plugin.fix(arg));
            }
        }
        return false;
    }
}
