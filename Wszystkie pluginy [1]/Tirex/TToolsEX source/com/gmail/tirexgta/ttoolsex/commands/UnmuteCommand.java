package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.ttoolsex.database.*;

public class UnmuteCommand implements CommandExecutor
{
    Main plugin;
    
    public UnmuteCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("unmute").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 1) {
            final String nick = args[0];
            final Player other = Bukkit.getPlayerExact(nick);
            final DataUser user = Datasource.getUserByNick(nick);
            if (user == null) {
                sender.sendMessage("§cNie znaleziono gracza!");
                return true;
            }
            if (user.getMute() == null) {
                sender.sendMessage("§cTen gracz nie ma mute!");
                return true;
            }
            user.setMute(null);
            user.setMuteTime(0L);
            if (other != null) {
                other.sendMessage("§7Zostales odciszony przez §c" + sender.getName());
            }
            Bukkit.broadcastMessage("§c" + args[0] + " §7zostal odciszony przez §c" + sender.getName());
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/unmute <gracz>");
        }
        return false;
    }
}
