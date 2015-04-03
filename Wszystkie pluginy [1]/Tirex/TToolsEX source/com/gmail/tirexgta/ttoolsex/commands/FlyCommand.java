package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class FlyCommand implements CommandExecutor
{
    Main plugin;
    
    public FlyCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("fly").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/fly <gracz>");
                return true;
            }
            final Player player = (Player)sender;
            if (!player.getAllowFlight()) {
                player.setAllowFlight(true);
                player.sendMessage("§6Tryb latania §awlaczony§6!");
                return true;
            }
            player.setAllowFlight(false);
            player.sendMessage("§6Tryb latania §cwylaczony§6!");
            return true;
        }
        else {
            if (args.length != 1) {
                sender.sendMessage("§cPoprawne uzycie: §6/fly <gracz>");
                return true;
            }
            if (!sender.hasPermission("tirex.fly")) {
                sender.sendMessage("§cNie masz uprawnien!");
                return true;
            }
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            if (!other.getAllowFlight()) {
                other.setAllowFlight(true);
                other.sendMessage("§6Tryb latania §awlaczony §6przez §c" + sender.getName() + " §6!");
                sender.sendMessage("§6Tryb latania §awlaczony §6dla §c" + other.getName() + "§6!");
                return true;
            }
            other.setAllowFlight(false);
            other.sendMessage("§6Tryb latania §cwylaczony §6przez §c" + sender.getName() + " §6!");
            sender.sendMessage("§6Tryb latania §cwylaczony §6dla §c" + other.getName() + "§6!");
            return true;
        }
    }
}
