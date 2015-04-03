package com.gmail.tirexgta.tguildsex;

import org.bukkit.entity.*;
import org.bukkit.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import java.util.*;

public class InfoManager
{
    Main plugin;
    
    public InfoManager(final Main plugin) {
        super();
        this.plugin = plugin;
    }
    
    public boolean getPlayerGuild(final DataGuildUser user) {
        return user.getRanga() == 0;
    }
    
    public boolean getGuild(final DataGuild gildia) {
        return gildia == null;
    }
    
    public void info(final DataGuild gildia, final Player p, final String tag) {
        if (this.plugin.infoManager.getGuild(gildia)) {
            p.sendMessage("§4Blad: §cNie ma takiej Gildii!");
            return;
        }
        double kdr = 0.0;
        if (gildia.getZabicia() != 0) {
            kdr = gildia.getZabicia();
            if (gildia.getZgony() != 0) {
                kdr = gildia.getZabicia() / gildia.getZgony();
            }
        }
        final double rozmiar = gildia.getPromien() * 2;
        int online = 0;
        int iloscCzlonkow = 1;
        final StringBuilder sb = new StringBuilder();
        for (final String czlonek : gildia.getCzlonkowie()) {
            if (gildia.getCzlonkowie().size() == iloscCzlonkow) {
                final Player other = Bukkit.getPlayerExact(czlonek);
                if (other != null) {
                    sb.append("§a" + other.getName());
                    ++online;
                }
                else {
                    sb.append("§c" + czlonek);
                }
            }
            else {
                final Player other = Bukkit.getPlayerExact(czlonek);
                if (other != null) {
                    sb.append("§a" + other.getName()).append("§7,").append(" ");
                    ++online;
                }
                else {
                    sb.append("§c" + czlonek).append("§7,").append(" ");
                }
            }
            ++iloscCzlonkow;
        }
        final String onlineString = sb.toString();
        int iloscMistrzow = 1;
        final StringBuilder sbMistrzowie = new StringBuilder();
        for (final String mistrz : gildia.getMistrzowie()) {
            if (gildia.getMistrzowie().size() == iloscMistrzow) {
                final Player other2 = Bukkit.getPlayerExact(mistrz);
                if (other2 != null) {
                    sbMistrzowie.append("§a" + other2.getName());
                }
                else {
                    sbMistrzowie.append("§c" + mistrz);
                }
            }
            else {
                final Player other2 = Bukkit.getPlayerExact(mistrz);
                if (other2 != null) {
                    sbMistrzowie.append("§a" + other2.getName()).append("§7,").append(" ");
                }
                else {
                    sbMistrzowie.append("§c" + mistrz).append("§7,").append(" ");
                }
            }
            ++iloscMistrzow;
        }
        String mistrzowieString = sbMistrzowie.toString();
        if (gildia.getMistrzowie().size() == 0) {
            mistrzowieString = this.plugin.messageManager.infoNone;
        }
        for (String s : this.plugin.messageManager.infoMsg) {
            s = s.replace("%tag%", gildia.getTag());
            s = s.replace("%name%", gildia.getName());
            s = s.replace("%position%", Integer.toString(Datasource.getGuildPostionByTag(gildia.getTag())));
            s = s.replace("%points%", Integer.toString(gildia.getPunkty()));
            s = s.replace("%lider%", gildia.getLider());
            s = s.replace("%kills%", Integer.toString(gildia.getZabicia()));
            s = s.replace("%deaths%", Integer.toString(gildia.getZgony()));
            s = s.replace("%kdr%", Double.toString(kdr));
            s = s.replace("%size%", Double.toString(rozmiar));
            s = s.replace("%sizemembers%", Integer.toString(gildia.getCzlonkowie().size()));
            s = s.replace("%maxMembers%", Integer.toString(gildia.getMaxCzlonkow()));
            s = s.replace("%online%", Integer.toString(online));
            s = s.replace("%members%", onlineString);
            s = s.replace("%masters%", mistrzowieString);
            for (int i = 0; i <= this.plugin.configManager.guildSojuszMax; ++i) {
                if (gildia.getSojusze().size() <= i && gildia.getSojusze().size() > 0) {
                    final DataGuild sojusz = this.plugin.data.getGuildByTag(gildia.getSojusze().get(i - 1));
                    if (sojusz != null) {
                        s = s.replace("%alliance" + i + "%", this.plugin.messageManager.infoAlliances.replace("%tag%", sojusz.getTag()).replace("%name%", sojusz.getName()));
                    }
                    else {
                        s = s.replace("%alliance" + i + "%", this.plugin.messageManager.infoAlliances.replace("%tag%", "").replace("%name%", ""));
                    }
                }
                else if (i == 1) {
                    s = s.replace("%alliance" + i + "%", this.plugin.messageManager.infoNone);
                }
                else {
                    s = s.replace("%alliance" + i + "%", "");
                }
            }
            if (s.split("").length != 1 && s.split("").length != 2 && s.split("").length != 3) {
                p.sendMessage(this.plugin.fixMsg(s));
            }
        }
    }
}
