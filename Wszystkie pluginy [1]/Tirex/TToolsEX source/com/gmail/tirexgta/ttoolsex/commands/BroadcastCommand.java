package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class BroadcastCommand implements CommandExecutor
{
    Main plugin;
    
    public BroadcastCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        plugin.getCommand("broadcast").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length < 0) {
            sender.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GOLD + "/broadcast <wiadomosc>");
            return true;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
        }
        final String message = sb.toString();
        Bukkit.broadcastMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Ogloszenie" + ChatColor.GOLD + "] " + ChatColor.GREEN + this.plugin.fix(message));
        return false;
    }
}
