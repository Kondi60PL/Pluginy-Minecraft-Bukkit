package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.*;
import java.util.*;
import java.text.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.ttoolsex.database.*;

public class BanCommand implements CommandExecutor
{
    Main plugin;
    
    public BanCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("ban").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length <= 2) {
            sender.sendMessage("§cPoprawne uzycie: §6/ban <nick> <czas> <powod>");
            return true;
        }
        final Player other = Bukkit.getPlayer(args[0]);
        if (other != null && other.hasPermission("tirex.ban.bypass")) {
            sender.sendMessage("§cTego gracze nie mozesz zbanowac!");
            return true;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 2; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
        }
        final String banReason = sb.toString();
        String bannedDisplayName = args[0];
        if (other != null) {
            bannedDisplayName = other.getDisplayName();
        }
        DataBan ban = this.plugin.data.getBanData(args[0]);
        final boolean isBanned = ban != null;
        if (ban != null && ban.getTime() != 0L) {
            sender.sendMessage("§cGracz o podanym nicku jest juz zbanowany!");
            return true;
        }
        DataUser user = Datasource.getUserByNick(args[0]);
        if (user == null) {
            user = this.plugin.data.createUser();
            user.setNick(args[0]);
            user.setFly(false);
            user.setGod(false);
            user.setGamemode(GameMode.SURVIVAL);
            user.setWorld("world");
            user.setX(0);
            user.setY(0);
            user.setZ(0);
            user.insert();
        }
        if (!isBanned) {
            ban = this.plugin.data.createBan();
        }
        final long banTime = System.currentTimeMillis() + Main.stringToTime(args[1]);
        ban.setReason(banReason);
        ban.setTime(banTime);
        ban.setUser(user);
        final DataUser admin = Datasource.getUserByNick(sender.getName());
        if (admin != null) {
            ban.setAdmin(admin);
        }
        if (isBanned) {
            ban.update();
        }
        else {
            ban.insert();
        }
        final Date date = new Date(ban.getTime());
        final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String timeShow = dt.format(date);
        String displayName = "CONSOLE";
        if (sender instanceof Player) {
            displayName = sender.getName();
        }
        if (other != null) {
            other.kickPlayer("§cZostales zbanowany do §6" + timeShow + "§c.\n§cPowod: §6" + banReason + "\n§cPrzez: §6" + displayName);
        }
        Bukkit.broadcastMessage("§c" + bannedDisplayName + " §7zostal zbanowany przez §c" + displayName + "§7. Powod: §c" + banReason + "§7. Do: §c" + timeShow);
        return false;
    }
}
