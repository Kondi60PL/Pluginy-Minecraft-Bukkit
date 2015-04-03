package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.ttoolsex.database.*;
import org.bukkit.*;

public class GodCommand implements CommandExecutor
{
    Main plugin;
    
    public GodCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("god").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/god <gracz>");
                return true;
            }
            final Player player = (Player)sender;
            if (!Datasource.getUserData(player).getGod()) {
                Datasource.getUserData(player).setGod(true);
                player.sendMessage("§6GodMode §awlaczony§6!");
            }
            else if (Datasource.getUserData(player).getGod()) {
                Datasource.getUserData(player).setGod(false);
                player.sendMessage("§6GodMode §cwylaczony§6!");
            }
        }
        else if (args.length == 1) {
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            if (!Datasource.getUserData(other).getGod()) {
                Datasource.getUserData(other).setGod(true);
                other.sendMessage("§6GodMode §awlaczony §6przez gracza §c" + sender.getName());
                sender.sendMessage("§6GodMode §awlaczony §6dla gracza §c" + other.getName());
            }
            else if (Datasource.getUserData(other).getGod()) {
                Datasource.getUserData(other).setGod(false);
                other.sendMessage("§6GodMode §cwylaczony §6przez gracza §c" + sender.getName());
                sender.sendMessage("§6GodMode §cwylaczony §6dla gracza §c" + other.getName());
            }
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/god <gracz>");
        }
        return false;
    }
}
