package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class TpacceptCommand implements CommandExecutor
{
    Main plugin;
    
    public TpacceptCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("tpaccept").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        if (args.length == 0) {
            final Player p = (Player)sender;
            if (this.plugin.teleportCancelListener.teleport.contains(p)) {
                sender.sendMessage("§cPoczekaj az sie steleportujesz!");
                return true;
            }
            if (!this.plugin.tpaCommand.tpaPlayer.containsKey(p)) {
                sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
                return true;
            }
            final Player other = this.plugin.tpaCommand.tpaPlayer.get(p);
            if (other == null) {
                sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
                return true;
            }
            if (!this.plugin.tpaCommand.tpaTime.containsKey(other)) {
                sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
                return true;
            }
            if (System.currentTimeMillis() >= this.plugin.tpaCommand.tpaTime.get(other)) {
                sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
                return true;
            }
            if (other.hasPermission("tirex.spawn.nodelay")) {
                other.teleport(p.getLocation());
                other.sendMessage("§c" + other.getName() + " §6zaakceptowal prosbe teleportacji!");
                other.sendMessage("§6Przeteleportowano do §c" + p.getName() + "§6!");
                return true;
            }
            Main.teleportPlayerWithDelay(other, this.plugin.config.teleportDelay, p.getLocation(), "§6Przeteleportowano do §c + " + p.getName() + "§6!", null);
            other.sendMessage("§c" + other.getName() + " §6zaakceptowal prosbe teleportacji!");
            other.sendMessage("§6Teleport rozgrzewa sie...");
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/tpaccept");
        }
        return false;
    }
}
