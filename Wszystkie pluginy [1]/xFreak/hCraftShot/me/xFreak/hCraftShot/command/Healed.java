package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Healed implements CommandExecutor
{
    public Healed(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final double maxHP = 20.0;
        if (commandLabel.equalsIgnoreCase("heal")) {
            if (args.length == 0) {
                if (sender instanceof Player) {
                    final Player p = (Player)sender;
                    p.setHealth(maxHP);
                    p.setFoodLevel(20);
                    p.setFireTicks(0);
                    p.sendMessage(ChatColor.YELLOW + "Healed!");
                }
                else {
                    sender.sendMessage(ChatColor.DARK_RED + "Musisz byc na serwerze!");
                }
            }
            else if (args.length == 1) {
                if (Bukkit.getServer().getPlayer(args[0]) != null) {
                    final Player pTarget = Bukkit.getServer().getPlayer(args[0]);
                    pTarget.setHealth(maxHP);
                    pTarget.setFoodLevel(20);
                    pTarget.setFireTicks(0);
                    pTarget.sendMessage(ChatColor.YELLOW + "Healed!");
                    sender.sendMessage(ChatColor.GREEN + "Healed player " + pTarget.getName());
                }
                else {
                    sender.sendMessage(ChatColor.DARK_RED + "Nie ma takiego gracza !");
                }
            }
            else if (args.length >= 2) {
                sender.sendMessage(ChatColor.RED + "Za duzo argumentow. Poprawne uzycie: " + ChatColor.GREEN + "/heal <nick>");
            }
        }
        return false;
    }
}
