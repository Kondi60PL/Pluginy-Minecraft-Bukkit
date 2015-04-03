package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class KickCommand implements CommandExecutor
{
    Main plugin;
    
    public KickCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("kick").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length <= 1) {
            sender.sendMessage("§cPoprawne uzycie: §6/kick <gracz> <powod>");
            return true;
        }
        final Player other = Bukkit.getPlayerExact(args[0]);
        if (other == null) {
            sender.sendMessage("§cTen gracz nie jest Online!");
            return true;
        }
        if (other.hasPermission("tirex.kick.bypass")) {
            sender.sendMessage("§cTen gracz nie moze byc wyrzucony!");
            return true;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
        }
        final String kickReason = sb.toString();
        other.kickPlayer("§cZostales wyrzucony z serwera.\n§cPowod: §6" + kickReason + "\n§cPrzez: §6" + sender.getName());
        Bukkit.broadcastMessage("§c" + other.getName() + "§7 zostal wyrzucony przez §c" + sender.getName() + "§7. Powod: §c" + kickReason);
        return false;
    }
}
