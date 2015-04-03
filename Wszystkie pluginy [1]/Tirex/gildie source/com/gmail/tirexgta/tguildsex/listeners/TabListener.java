package com.gmail.tirexgta.tguildsex.listeners;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.tguildsex.packet.*;
import java.text.*;
import java.util.*;
import org.bukkit.scoreboard.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import org.bukkit.*;

public class TabListener
{
    Main plugin;
    static HashMap<String, List<String>> packets;
    static HashMap<String, List<String>> packetsGuild;
    static HashMap<String, List<String>> topPlayer;
    static HashMap<String, List<String>> topGuild;
    static List<String> time;
    static List<Team> team;
    
    static {
        TabListener.packets = new HashMap<String, List<String>>();
        TabListener.packetsGuild = new HashMap<String, List<String>>();
        TabListener.topPlayer = new HashMap<String, List<String>>();
        TabListener.topGuild = new HashMap<String, List<String>>();
        TabListener.time = new ArrayList<String>();
        TabListener.team = new ArrayList<Team>();
    }
    
    public TabListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getScheduler().runTaskTimerAsynchronously((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                TabListener.timeRefresh();
            }
        }, 20L, 20L);
        this.plugin.getServer().getScheduler().runTaskTimerAsynchronously((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                TabListener.tabRefresh();
            }
        }, 20L, 400L);
    }
    
    public void refresh(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player online = onlinePlayers[i];
            final WrapperPlayServerPlayerInfo tabPacket = new WrapperPlayServerPlayerInfo();
            tabPacket.setPlayerName(online.getName());
            tabPacket.setOnline(false);
            tabPacket.setPing((short)5);
            tabPacket.sendPacket(p);
        }
        final List<String> tab = this.plugin.tabManager.tab;
        int x = 1;
        int y = 1;
        int size = 1;
        for (String s : tab) {
            if (size > 60) {
                s = null;
            }
            else {
                s = this.plugin.fixMsg(s);
                if (containsString(s, tab)) {
                    s = replaceContains(x, y, s);
                }
                else {
                    s = replaceTab(p, s, x, y);
                }
                s = cutString(s, 16);
                final WrapperPlayServerPlayerInfo tabPacket2 = new WrapperPlayServerPlayerInfo();
                tabPacket2.setPlayerName(s);
                tabPacket2.setOnline(true);
                tabPacket2.setPing((short)5);
                tabPacket2.sendPacket(p);
                if (y == 3) {
                    y = 1;
                    ++x;
                }
                else {
                    ++y;
                }
                ++size;
            }
        }
    }
    
    static String[] getLabelString(final List<String> list) {
        final String[] a = { "" };
        return list.toArray(a);
    }
    
    static String cutString(String s, final int maxChar) {
        if (s.length() > maxChar) {
            s = s.substring(0, maxChar);
        }
        return s;
    }
    
    static boolean containsString(final String s, final List<String> list) {
        if (list.contains(s)) {
            int size = 0;
            for (final String string : list) {
                if (string.equals(s)) {
                    if (size == 1) {
                        return true;
                    }
                    ++size;
                }
            }
        }
        return false;
    }
    
    static boolean containsPlayerPacket(final Player p, final WrapperPlayServerPlayerInfo packet) {
        return TabListener.packets.containsKey(p.getName()) && TabListener.packets.get(p.getName()).contains(packet);
    }
    
    static String replaceTab(final Player p, String s, final int x, final int y) {
        final Scoreboard sb = p.getScoreboard();
        final DataGuildUser user = Datasource.getUserByNick(p.getName());
        s = replace(sb, s, "%kills%", p, user, Main.pluginn.tabManager.kills, 1, Integer.toString(user.getKills()));
        s = replace(sb, s, "%deaths%", p, user, Main.pluginn.tabManager.deaths, 2, Integer.toString(user.getDeaths()));
        s = replace(sb, s, "%points%", p, user, Main.pluginn.tabManager.points, 3, Integer.toString(user.getPoints()));
        s = replace(sb, s, "%nick%", p, user, Main.pluginn.tabManager.nick, 4, user.getNick());
        final DataGuild gildia = Datasource.getGuildByName(user.getNazwa());
        s = guildReplace(s, "%guildTag%", Main.pluginn.tabManager.guildTag, gildia, p, sb, x, y, 1, (gildia != null) ? gildia.getTag() : "");
        s = guildReplace(s, "%guildKills%", Main.pluginn.tabManager.guildKills, gildia, p, sb, x, y, 2, (gildia != null) ? Integer.toString(gildia.getZabicia()) : "");
        s = guildReplace(s, "%guildDeaths%", Main.pluginn.tabManager.guildDeaths, gildia, p, sb, x, y, 3, (gildia != null) ? Integer.toString(gildia.getZgony()) : "");
        s = guildReplace(s, "%guildPoints%", Main.pluginn.tabManager.guildPoints, gildia, p, sb, x, y, 4, (gildia != null) ? Integer.toString(gildia.getPunkty()) : "");
        final String variableTime = "%time%";
        if (s.contains(variableTime)) {
            s = s.replace(variableTime, Main.pluginn.tabManager.time);
            final String[] split = s.split(variableTime);
            final String player = split[0];
            final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            final Date data = new Date(System.currentTimeMillis());
            final String suffix = format.format(data).toString();
            if (!TabListener.time.contains(p.getName())) {
                TabListener.time.add(p.getName());
            }
            final Team team = createTeam(sb, "%time%");
            addPlayer(team, Main.pluginn.fixMsg(player));
            setSuffix(team, suffix);
            s = player;
        }
        final List<String> topPlayers = Datasource.top10Players;
        final List<String> topGuilds = Datasource.top10Guilds;
        s = replaceTopPlayers(p, sb, s, "%topPlayer", topPlayers);
        s = replaceTopGuilds(p, sb, s, "%topGuild", topGuilds);
        s = Main.pluginn.fixMsg(s);
        return s;
    }
    
    static String guildReplace(String s, final String variable, final String replace, final DataGuild gildia, final Player p, final Scoreboard sb, final int x, final int y, final int i, String suffix) {
        if (s.contains(variable)) {
            if (gildia != null) {
                s = s.replace(variable, replace);
                final String[] split = s.split(variable);
                final String player = split[0];
                if (split.length == 2) {
                    suffix = String.valueOf(suffix) + split[1];
                }
                List<String> variables = new ArrayList<String>();
                if (TabListener.packetsGuild.containsKey(p.getName())) {
                    variables = TabListener.packetsGuild.get(p.getName());
                    TabListener.packetsGuild.remove(p.getName());
                }
                if (!variables.contains(variable)) {
                    variables.add(variable);
                }
                TabListener.packetsGuild.put(p.getName(), variables);
                final Team team = createTeam(sb, Integer.toString(i));
                addPlayer(team, Main.pluginn.fixMsg(player));
                setSuffix(team, Main.pluginn.fixMsg(suffix));
                return Main.pluginn.fixMsg(player);
            }
            s = replaceContains(x, y, s);
        }
        return s;
    }
    
    static String replaceTopPlayers(final Player p, final Scoreboard sb, String s, final String variable, final List<String> top) {
        if (s.contains(variable)) {
            for (int i = 0; i <= 20; ++i) {
                if (s.contains(String.valueOf(variable) + i + "%")) {
                    s = s.replace(String.valueOf(variable) + i + "%", Main.pluginn.tabManager.topPlayer);
                    final String[] split = s.split("%player%");
                    String player = split[0];
                    String suffix = Main.pluginn.tabManager.noneTopPlayer;
                    if (top.size() >= i) {
                        suffix = top.get(i - 1);
                        if (split.length == 2) {
                            suffix = String.valueOf(suffix) + split[1];
                        }
                    }
                    player = player.replace("%value%", Integer.toString(i));
                    s = Main.pluginn.fixMsg(s);
                    player = Main.pluginn.fixMsg(player);
                    suffix = Main.pluginn.fixMsg(suffix);
                    final Team team = createTeam(sb, String.valueOf(variable) + i + "%");
                    addPlayer(team, player);
                    setSuffix(team, suffix);
                    List<String> variables = new ArrayList<String>();
                    if (TabListener.topPlayer.containsKey(p.getName())) {
                        variables = TabListener.topPlayer.get(p.getName());
                        TabListener.topPlayer.remove(p.getName());
                    }
                    if (!variables.contains(variable)) {
                        variables.add(String.valueOf(variable) + i + "%");
                    }
                    TabListener.topPlayer.put(p.getName(), variables);
                    return player;
                }
            }
        }
        return s;
    }
    
    static String replaceTopGuilds(final Player p, final Scoreboard sb, String s, final String variable, final List<String> top) {
        if (s.contains(variable)) {
            for (int i = 0; i <= 20; ++i) {
                if (s.contains(String.valueOf(variable) + i + "%")) {
                    s = s.replace(String.valueOf(variable) + i + "%", Main.pluginn.tabManager.topGuild);
                    final String[] split = s.split("%tag%");
                    String player = split[0];
                    String suffix = Main.pluginn.tabManager.noneTopGuild;
                    if (top.size() >= i) {
                        suffix = top.get(i - 1);
                        if (split.length == 2) {
                            suffix = String.valueOf(suffix) + split[1];
                            final DataGuild gildia = Main.pluginn.data.getGuildByTag(top.get(i - 1));
                            if (gildia != null) {
                                suffix = suffix.replace("%points%", Integer.toString(gildia.getPunkty()));
                            }
                        }
                    }
                    player = player.replace("%value%", Integer.toString(i));
                    s = Main.pluginn.fixMsg(s);
                    player = Main.pluginn.fixMsg(player);
                    suffix = Main.pluginn.fixMsg(suffix);
                    final Team team = createTeam(sb, String.valueOf(variable) + i + "%");
                    addPlayer(team, player);
                    setSuffix(team, suffix);
                    List<String> variables = new ArrayList<String>();
                    if (TabListener.topGuild.containsKey(p.getName())) {
                        variables = TabListener.topGuild.get(p.getName());
                        TabListener.topGuild.remove(p.getName());
                    }
                    if (!variables.contains(variable)) {
                        variables.add(String.valueOf(variable) + i + "%");
                    }
                    TabListener.topGuild.put(p.getName(), variables);
                    return player;
                }
            }
        }
        return s;
    }
    
    static String replace(final Scoreboard sb, String s, final String variable, final Player p, final DataGuildUser user, final String tab, final int i, String suffix) {
        if (s.contains(variable)) {
            s = s.replace(variable, tab);
            final String[] split = s.split(variable);
            String player = split[0];
            if (split.length == 2) {
                suffix = String.valueOf(suffix) + split[1];
            }
            List<String> variables = new ArrayList<String>();
            if (TabListener.packets.containsKey(p.getName())) {
                variables = TabListener.packets.get(p.getName());
                TabListener.packets.remove(p.getName());
            }
            if (!variables.contains(variable)) {
                variables.add(variable);
            }
            TabListener.packets.put(p.getName(), variables);
            player = Main.pluginn.fixMsg(player);
            suffix = Main.pluginn.fixMsg(suffix);
            final Team team = createTeam(sb, "|" + Integer.toString(i));
            addPlayer(team, player);
            setSuffix(team, suffix);
            s = player;
        }
        return s;
    }
    
    static String replaceContains(final int x, final int y, String s) {
        s = "";
        for (int i = 0; i < x; ++i) {
            if (x <= 8) {
                if (y == 1) {
                    s = String.valueOf(s) + "&1";
                }
                else if (y == 2) {
                    s = String.valueOf(s) + "&2";
                }
                else {
                    s = String.valueOf(s) + "&3";
                }
            }
            else if (x == 9) {
                if (y == 1) {
                    s = "&1&2";
                }
                else if (y == 2) {
                    s = "&2&3";
                }
                else {
                    s = "&3&4";
                }
            }
            else if (x == 10) {
                if (y == 1) {
                    s = "&4&5";
                }
                else if (y == 2) {
                    s = "&5&6";
                }
                else {
                    s = "&6&7";
                }
            }
            else if (x == 11) {
                if (y == 1) {
                    s = "&7&8";
                }
                else if (y == 2) {
                    s = "&8&9";
                }
                else {
                    s = "&9&0";
                }
            }
            else if (x == 12) {
                if (y == 1) {
                    s = "&0&e";
                }
                else if (y == 2) {
                    s = "&e&c";
                }
                else {
                    s = "&c&a";
                }
            }
            else if (x == 13) {
                if (y == 1) {
                    s = "&a&c";
                }
                else if (y == 2) {
                    s = "&c&e";
                }
                else {
                    s = "&e&0";
                }
            }
            else if (x == 14) {
                if (y == 1) {
                    s = "&0&9";
                }
                else if (y == 2) {
                    s = "&9&8";
                }
                else {
                    s = "&8&7";
                }
            }
            else if (x == 15) {
                if (y == 1) {
                    s = "&7&6";
                }
                else if (y == 2) {
                    s = "&6&5";
                }
                else {
                    s = "&4&3";
                }
            }
            else if (x == 16) {
                if (y == 1) {
                    s = "&3&2";
                }
                else if (y == 2) {
                    s = "&2&1";
                }
                else {
                    s = "&1&a";
                }
            }
            else if (x == 17) {
                if (y == 1) {
                    s = "&2&a";
                }
                else if (y == 2) {
                    s = "&3&a";
                }
                else {
                    s = "&4&a";
                }
            }
            else if (x == 18) {
                if (y == 1) {
                    s = "&5&a";
                }
                else if (y == 2) {
                    s = "&6&a";
                }
                else {
                    s = "&7&a";
                }
            }
            else if (x == 19) {
                if (y == 1) {
                    s = "&1&c";
                }
                else if (y == 2) {
                    s = "&2&c";
                }
                else {
                    s = "&3&c";
                }
            }
            else if (x == 20) {
                if (y == 1) {
                    s = "&4&c";
                }
                else if (y == 2) {
                    s = "&5&c";
                }
                else {
                    s = "&6&c";
                }
            }
        }
        return Main.pluginn.fixMsg(s);
    }
    
    static Team createTeam(final String t) {
        final Team team = Main.sb.getTeam(t);
        if (team == null) {
            return Main.sb.registerNewTeam(t);
        }
        return team;
    }
    
    static Team createTeam(final Scoreboard sb, final String t) {
        final Team team = sb.getTeam(t);
        if (team == null) {
            return sb.registerNewTeam(t);
        }
        return team;
    }
    
    static Team setPreffix(final Team team, final String p) {
        if (team != null) {
            team.setPrefix(p);
            return team;
        }
        return null;
    }
    
    static Team setSuffix(final Team team, final String s) {
        if (team != null) {
            team.setSuffix(s);
            return team;
        }
        return null;
    }
    
    static Team addPlayer(final Team team, final String player) {
        if (team != null) {
            final OfflinePlayer offline = Bukkit.getOfflinePlayer(player);
            if (!team.getPlayers().contains(offline)) {
                team.addPlayer(offline);
                return team;
            }
        }
        return null;
    }
    
    static Team removePlayer(final Team team, final String player) {
        if (team != null) {
            final OfflinePlayer offline = Bukkit.getOfflinePlayer(player);
            if (team.getPlayers().contains(offline)) {
                team.removePlayer(offline);
                return team;
            }
        }
        return null;
    }
    
    public static void timeRefresh() {
        for (final String player : TabListener.time) {
            final Player other = Bukkit.getPlayerExact(player);
            if (other != null) {
                final Scoreboard sb = other.getScoreboard();
                final Team teamTime = createTeam(sb, "%time%");
                final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                final Date data = new Date(System.currentTimeMillis());
                final String suffix = format.format(data).toString();
                setSuffix(teamTime, suffix);
            }
        }
    }
    
    public static void tabRefresh() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
            final Player online = onlinePlayers[j];
            final DataGuildUser user = Datasource.getUserByNick(online.getName());
            final Scoreboard sb = online.getScoreboard();
            if (TabListener.packets.containsKey(online.getName())) {
                for (final String variable : TabListener.packets.get(online.getName())) {
                    if (variable.equals("%kills%")) {
                        final Team team = createTeam(sb, "|1");
                        team.setSuffix(Integer.toString(user.getKills()));
                    }
                    if (variable.equals("%deaths%")) {
                        final Team team = createTeam(sb, "|2");
                        team.setSuffix(Integer.toString(user.getDeaths()));
                    }
                    if (variable.equals("%points%")) {
                        final Team team = createTeam(sb, "|3");
                        team.setSuffix(Integer.toString(user.getPoints()));
                    }
                    if (variable.equals("%nick%")) {
                        final Team team = createTeam(sb, "|4");
                        team.setSuffix(online.getName());
                    }
                }
            }
            if (TabListener.packetsGuild.containsKey(online.getName())) {
                for (final String variable : TabListener.packetsGuild.get(online.getName())) {
                    final DataGuild gildia = Main.pluginn.data.getGuildByTag(user.getTag());
                    if (gildia != null) {
                        if (variable.equals("%guildTag%")) {
                            final Team team2 = createTeam(sb, "|11");
                            team2.setSuffix(gildia.getTag());
                        }
                        if (variable.equals("%guildKills%")) {
                            final Team team2 = createTeam(sb, "|12");
                            team2.setSuffix(Integer.toString(gildia.getZabicia()));
                        }
                        if (variable.equals("%guildDeaths%")) {
                            final Team team2 = createTeam(sb, "|13");
                            team2.setSuffix(Integer.toString(gildia.getZgony()));
                        }
                        if (!variable.equals("%guildPoints%")) {
                            continue;
                        }
                        final Team team2 = createTeam(sb, "|14");
                        team2.setSuffix(Integer.toString(gildia.getPunkty()));
                    }
                }
            }
            if (TabListener.topPlayer.containsKey(online.getName())) {
                for (String variable : TabListener.topPlayer.get(online.getName())) {
                    final Team team = createTeam(sb, variable);
                    variable = variable.replace("%topPlayer", "");
                    variable = variable.replace("%", "");
                    final int i = Integer.parseInt(variable);
                    final String s = Main.pluginn.tabManager.topPlayer;
                    final String[] split = s.split("%player%");
                    final List<String> top = Datasource.top10Players;
                    String suffix = Main.pluginn.tabManager.noneTopPlayer;
                    if (top.size() >= i) {
                        suffix = top.get(i - 1);
                        if (split.length == 2) {
                            suffix = String.valueOf(suffix) + split[1];
                        }
                    }
                    suffix = Main.pluginn.fixMsg(suffix);
                    setSuffix(team, suffix);
                }
            }
            if (TabListener.topGuild.containsKey(online.getName())) {
                for (String variable : TabListener.topGuild.get(online.getName())) {
                    final Team team = createTeam(sb, variable);
                    variable = variable.replace("%topGuild", "");
                    variable = variable.replace("%", "");
                    final int i = Integer.parseInt(variable);
                    final String s = Main.pluginn.tabManager.topGuild;
                    final String[] split = s.split("%tag%");
                    final List<String> top = Datasource.top10Guilds;
                    String suffix = Main.pluginn.tabManager.noneTopGuild;
                    if (top.size() >= i) {
                        suffix = top.get(i - 1);
                        if (split.length == 2) {
                            suffix = String.valueOf(suffix) + split[1];
                            final DataGuild gildia2 = Main.pluginn.data.getGuildByTag(top.get(i - 1));
                            if (gildia2 != null) {
                                suffix = suffix.replace("%points%", Integer.toString(gildia2.getPunkty()));
                            }
                            else {
                                suffix = suffix.replace("%points%", Integer.toString(69));
                            }
                        }
                    }
                    suffix = Main.pluginn.fixMsg(suffix);
                    setSuffix(team, suffix);
                }
            }
        }
    }
}
