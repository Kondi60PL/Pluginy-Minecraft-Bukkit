package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class TpdenyCommand implements CommandExecutor
{
    Main plugin;
    
    public TpdenyCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("tpdeny").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        if (args.length == 0) {
            final Player p = (Player)sender;
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
            this.plugin.tpaCommand.tpaPlayer.remove(p);
            this.plugin.tpaCommand.tpaTime.remove(other);
            p.sendMessage("§6Odrzuciles teleportacji od gracza §c" + other.getName());
            other.sendMessage("§c" + p.getName() + " §6odrzucil prosbe teleportacji!");
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/tpdeny");
        }
        return false;
    }
}
