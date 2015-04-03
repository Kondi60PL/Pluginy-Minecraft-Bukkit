package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Tp implements CommandExecutor
{
    public Tp(final Main Plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("tp")) {
            if (sender.hasPermission("hc.tp")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.YELLOW + "[TP] Did not spell too few arguments!");
                }
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        final Player p = (Player)sender;
                        if (p.getServer().getPlayer(args[0]) != null) {
                            final Player cel = p.getServer().getPlayer(args[0]);
                            final Location celLoc = cel.getLocation();
                            p.teleport(celLoc);
                            p.sendMessage(ChatColor.YELLOW + "[TP] Teleported to player " + ChatColor.YELLOW + cel.getName());
                        }
                        else {
                            p.sendMessage(ChatColor.YELLOW + "[TP] There is no such player!");
                        }
                    }
                    else {
                        sender.sendMessage(ChatColor.YELLOW + "[TP] You must be on a server!");
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getServer().getPlayer(args[0]) != null && Bukkit.getServer().getPlayer(args[1]) != null) {
                        final Player cel2 = Bukkit.getServer().getPlayer(args[0]);
                        final Player cel3 = Bukkit.getServer().getPlayer(args[1]);
                        final Location cel2Loc = cel3.getLocation();
                        cel2.teleport(cel2Loc);
                        cel2.sendMessage(ChatColor.YELLOW + "[TP] You have been teleported to the player " + ChatColor.GOLD + cel3.getName());
                    }
                    else {
                        sender.sendMessage(ChatColor.YELLOW + "[TP] There is no such player!");
                    }
                }
                else {
                    sender.sendMessage(ChatColor.YELLOW + "[TP] I do not have permission!");
                }
            }
            else if (args.length >= 3) {
                sender.sendMessage(ChatColor.YELLOW + "[TP] Too many arguments!");
            }
        }
        return false;
    }
}
