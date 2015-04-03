package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.*;

public class SkinCommand implements CommandExecutor
{
    Main plugin;
    private SkinChangeManager factory;
    
    public SkinCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("skin").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/skin <gracz> <skinGracza>");
                return true;
            }
            final Player p = (Player)sender;
            (this.factory = new SkinChangeManager((Plugin)this.plugin)).changeDisplay(p.getName(), "MrTrolekk", args[0]);
            sender.sendMessage("§aMasz teraz skin gracza §e" + args[0]);
        }
        else if (args.length == 2) {
            if (!sender.hasPermission("tirex.skin.other")) {
                sender.sendMessage("§cPoprawne uzycie: §6/skin <skinGracza>");
                return true;
            }
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen Gracz nie jest Online!");
                return true;
            }
            (this.factory = new SkinChangeManager((Plugin)this.plugin)).changeDisplay("dada", "Dinnerbone", "Any name here");
            sender.sendMessage("§aUstawiles skin gracza §e" + args[1] + " §adla §e" + other.getName());
        }
        else if (!(sender instanceof Player)) {
            sender.sendMessage("§cPoprawne uzycie: §6/skin <gracz> <skinGracza>");
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/skin <skinGracza>");
        }
        return false;
    }
}
