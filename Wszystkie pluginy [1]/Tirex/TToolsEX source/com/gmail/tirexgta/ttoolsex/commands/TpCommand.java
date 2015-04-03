package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TpCommand implements CommandExecutor
{
    Main plugin;
    
    public TpCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("tp").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/tp <gracz> <gracz>");
                return true;
            }
            final Player p = (Player)sender;
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            p.teleport(other.getLocation());
            sender.sendMessage("§6Steleportowales sie do §c" + other.getName());
        }
        else if (args.length == 2) {
            final Player p = Bukkit.getPlayerExact(args[0]);
            final Player other = Bukkit.getPlayerExact(args[1]);
            if (p == null) {
                sender.sendMessage("§c" + args[0] + " nie jest Online!");
                return true;
            }
            if (other == null) {
                sender.sendMessage("§c" + args[1] + " nie jest Online!");
                return true;
            }
            p.teleport(other.getLocation());
            other.sendMessage("§6Zostales steleportowany do §c" + other.getName() + " §6przez §c" + sender.getName());
            sender.sendMessage("§6Steleportowales §c" + p.getName() + " §6do §c" + other.getName());
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/tp <gracz> <gracz>");
        }
        return false;
    }
}
