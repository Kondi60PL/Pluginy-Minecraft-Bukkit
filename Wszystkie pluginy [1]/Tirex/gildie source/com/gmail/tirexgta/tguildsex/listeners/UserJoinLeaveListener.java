package com.gmail.tirexgta.tguildsex.listeners;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;
import java.util.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import org.bukkit.*;
import org.bukkit.scoreboard.*;

public class UserJoinLeaveListener implements Listener
{
    Main plugin;
    
    public UserJoinLeaveListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player p = event.getPlayer();
        DataGuildUser user = this.plugin.data.getUserByPlayer(p);
        if (user == null) {
            user = this.plugin.data.createUser();
            user.setNick(p.getName());
            user.setTag("");
            user.setNazwa("");
            user.setRanga(0);
            user.setKills(0);
            user.setDeaths(0);
            user.setPoints(this.plugin.configManager.userStartPoints);
            user.setLastAttack(0L);
            user.setLastAttacker("");
            user.insert();
        }
        joinPlayer(p);
        this.plugin.tabListener.refresh(p);
    }
    
    @EventHandler
    public void onPlayerLeave(final PlayerQuitEvent event) {
        this.leftGame(event.getPlayer());
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerKick(final PlayerKickEvent event) {
        this.leftGame(event.getPlayer());
    }
    
    void leftGame(final Player player) {
        final DataGuildUser user = this.plugin.data.getUserByPlayer(player);
        if (user != null) {
            for (final String team : user.getTeams()) {
                final Team t = TabListener.createTeam(team);
                if (t != null) {
                    t.unregister();
                }
            }
        }
    }
    
    public static void joinPlayer(final Player player) {
        final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        final DataGuildUser user = Main.pluginn.data.getUserByPlayer(player);
        if (user.getTeams().size() > 0) {
            for (final String team : user.getTeams()) {
                final Team t = sb.getTeam(team);
                if (t != null) {
                    t.unregister();
                }
            }
        }
        final DataGuild g = Main.pluginn.data.getGuildByTag(user.getTag());
        for (final DataGuild gildia : Main.pluginn.data.getGuilds()) {
            Team t2 = sb.getTeam(gildia.getTag());
            if (t2 == null) {
                t2 = sb.registerNewTeam(gildia.getTag());
            }
            user.addTeams(t2.getName());
            if (g == null) {
                t2.setPrefix("§c[" + gildia.getTag() + "] ");
            }
            else if (gildia.equals(g)) {
                t2.setPrefix("§a[" + gildia.getTag() + "] ");
            }
            else if (gildia.getSojusze().contains(g.getTag())) {
                t2.setPrefix("§6[" + gildia.getTag() + "] ");
            }
            else {
                t2.setPrefix("§c[" + gildia.getTag() + "] ");
            }
        }
        Team noguild = sb.getTeam("noguild");
        if (noguild == null) {
            noguild = sb.registerNewTeam("noguild");
            noguild.setPrefix("");
        }
        player.setScoreboard(sb);
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player online = onlinePlayers[i];
            if (online.getScoreboard().getTeam((g != null) ? g.getTag() : "noguild") != null && !online.getScoreboard().getTeam((g != null) ? g.getTag() : "noguild").hasPlayer((OfflinePlayer)player)) {
                online.getScoreboard().getTeam((g != null) ? g.getTag() : "noguild").addPlayer((OfflinePlayer)player);
            }
            final DataGuildUser userOnline = Main.pluginn.data.getUserByPlayer(online);
            final DataGuild onlineguild = Main.pluginn.data.getGuildByTag(userOnline.getTag());
            if (player.getScoreboard().getTeam((onlineguild != null) ? onlineguild.getTag() : "noguild") != null && !player.getScoreboard().getTeam((onlineguild != null) ? onlineguild.getTag() : "noguild").hasPlayer((OfflinePlayer)player)) {
                player.getScoreboard().getTeam((onlineguild != null) ? onlineguild.getTag() : "noguild").addPlayer((OfflinePlayer)online);
            }
        }
        TabListener.tabRefresh();
        TabListener.timeRefresh();
    }
    
    public static void refresh(final Player player) {
        final Scoreboard sb = player.getScoreboard();
        final DataGuildUser user = Main.pluginn.data.getUserByPlayer(player);
        if (user.getTeams().size() > 0) {
            for (final String team : user.getTeams()) {
                final Team t = sb.getTeam(team);
                if (t != null) {
                    t.unregister();
                }
            }
        }
        final DataGuild g = Main.pluginn.data.getGuildByTag(user.getTag());
        for (final DataGuild gildia : Main.pluginn.data.getGuilds()) {
            Team t2 = sb.getTeam(gildia.getTag());
            if (t2 == null) {
                t2 = sb.registerNewTeam(gildia.getTag());
            }
            user.addTeams(t2.getName());
            if (g == null) {
                t2.setPrefix("§c[" + gildia.getTag() + "] ");
            }
            else if (gildia.equals(g)) {
                t2.setPrefix("§a[" + gildia.getTag() + "] ");
            }
            else if (gildia.getSojusze().contains(g.getTag())) {
                t2.setPrefix("§6[" + gildia.getTag() + "] ");
            }
            else {
                t2.setPrefix("§c[" + gildia.getTag() + "] ");
            }
        }
        Team noguild = sb.getTeam("noguild");
        if (noguild == null) {
            noguild = sb.registerNewTeam("noguild");
            noguild.setPrefix("");
        }
        player.setScoreboard(sb);
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player online = onlinePlayers[i];
            if (online.getScoreboard().getTeam((g != null) ? g.getTag() : "noguild") != null && !online.getScoreboard().getTeam((g != null) ? g.getTag() : "noguild").hasPlayer((OfflinePlayer)player)) {
                online.getScoreboard().getTeam((g != null) ? g.getTag() : "noguild").addPlayer((OfflinePlayer)player);
            }
            final DataGuildUser userOnline = Main.pluginn.data.getUserByPlayer(online);
            final DataGuild onlineguild = Main.pluginn.data.getGuildByTag(userOnline.getTag());
            if (player.getScoreboard().getTeam((onlineguild != null) ? onlineguild.getTag() : "noguild") != null && !player.getScoreboard().getTeam((onlineguild != null) ? onlineguild.getTag() : "noguild").hasPlayer((OfflinePlayer)player)) {
                player.getScoreboard().getTeam((onlineguild != null) ? onlineguild.getTag() : "noguild").addPlayer((OfflinePlayer)online);
            }
        }
        TabListener.tabRefresh();
        TabListener.timeRefresh();
    }
}
