package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TpposCommand implements CommandExecutor
{
    Main plugin;
    
    public TpposCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("tppos").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        if (args.length == 2) {
            final Player p = (Player)sender;
            if (!Main.isInteger(args[0])) {
                sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <z>");
                return true;
            }
            if (!Main.isInteger(args[1])) {
                sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <z>");
                return true;
            }
            final int x = Integer.parseInt(args[0]);
            final int z = Integer.parseInt(args[1]);
            final int y = p.getWorld().getHighestBlockYAt(x, z);
            final Location loc = new Location(p.getWorld(), x + 0.5, (double)y, z + 0.5);
            if (p.hasPermission("tirex.tppos.nodelay")) {
                p.teleport(loc);
                p.sendMessage("§6Przeteleportowales sie na koordynaty\n§6x: §c" + x + " §6y: §c" + y + " §6z: §c" + z);
                return true;
            }
            p.sendMessage("§6Teleport rozgrzewa sie...");
            Main.teleportPlayerWithDelay(p, this.plugin.config.teleportDelay, loc, "§6Przeteleportowales sie na koordynaty\n§6x: §c" + x + " §6y: §c" + y + " §6z: §c" + z, null);
        }
        else if (args.length == 3) {
            final Player p = (Player)sender;
            if (!Main.isInteger(args[0])) {
                sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <y> <z>");
                return true;
            }
            if (!Main.isInteger(args[1])) {
                sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <y> <z>");
                return true;
            }
            if (!Main.isInteger(args[2])) {
                sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <y> <z>");
                return true;
            }
            final int x = Integer.parseInt(args[0]);
            final int y2 = Integer.parseInt(args[1]);
            final int z2 = Integer.parseInt(args[2]);
            final Location loc = new Location(p.getWorld(), x + 0.5, (double)y2, z2 + 0.5);
            if (p.hasPermission("tirex.tppos.nodelay")) {
                p.teleport(loc);
                p.sendMessage("§6Przeteleportowales sie na koordynaty\n§6x: §c" + x + " §6y: §c" + y2 + " §6z: §c" + z2);
                return true;
            }
            p.sendMessage("§6Teleport rozgrzewa sie...");
            Main.teleportPlayerWithDelay(p, this.plugin.config.teleportDelay, loc, "§6Przeteleportowales sie na koordynaty\n§6x: §c" + x + " §6y: §c" + y2 + " §6z: §c" + z2, null);
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> [y] <z>");
        }
        return false;
    }
}
