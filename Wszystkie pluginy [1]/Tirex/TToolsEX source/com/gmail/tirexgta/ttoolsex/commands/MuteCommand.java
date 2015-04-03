package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.*;
import java.util.*;
import java.text.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.ttoolsex.database.*;

public class MuteCommand implements CommandExecutor
{
    Main plugin;
    
    public MuteCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("mute").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length <= 2) {
            sender.sendMessage("§cPoprawne uzycie: §6/mute <gracz> <czas> <powod>");
            return true;
        }
        final String nick = args[0];
        final Player other = Bukkit.getPlayerExact(nick);
        if (other != null && other.hasPermission("tirex.mute.bypass")) {
            sender.sendMessage("§cTego gracza nie mozna zmutowac!");
            return true;
        }
        final DataUser user = Datasource.getUserByNick(nick);
        if (user == null) {
            sender.sendMessage("§cNie znaleziono gracza!");
            return true;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 2; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
        }
        final String muteReason = sb.toString();
        final long muteTime = Main.stringToTime(args[1]) + System.currentTimeMillis();
        user.setMute(muteReason);
        user.setMuteTime(muteTime);
        user.update();
        final Date date = new Date(muteTime);
        final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String timeMuteShow = dt.format(date);
        if (other != null) {
            other.sendMessage("§7Zostales wyciszony przez §c" + sender.getName() + " §7do §c" + timeMuteShow + "§7. Powod: §c" + muteReason);
        }
        Bukkit.broadcastMessage("§c" + args[0] + " §7zostal wyciszony przez §c" + sender.getName() + " §7do §c" + timeMuteShow + "§7. Powod: §c" + muteReason);
        return false;
    }
}
