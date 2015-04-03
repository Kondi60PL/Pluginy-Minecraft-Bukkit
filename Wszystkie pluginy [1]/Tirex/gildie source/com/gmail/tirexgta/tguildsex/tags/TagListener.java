package com.gmail.tirexgta.tguildsex.tags;

import com.gmail.tirexgta.tguildsex.*;
import com.comphenix.protocol.*;
import org.bukkit.plugin.*;
import com.gmail.tirexgta.tguildsex.packet.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import java.util.*;
import com.comphenix.protocol.events.*;

public class TagListener
{
    final Main main;
    static Datasource data;
    static PacketAdapter packet;
    public List<TagManager> wrapper;
    public HashMap<String, TagManager> wrapperByNick;
    
    public TagListener(final Main arg0) {
        super();
        this.wrapper = new ArrayList<TagManager>();
        this.wrapperByNick = new HashMap<String, TagManager>();
        this.main = arg0;
    }
    
    public TagManager createTagManager(final String nick) {
        if (this.wrapperByNick.containsKey(nick.toLowerCase())) {
            return this.wrapperByNick.get(nick.toLowerCase());
        }
        return new TagManager(this, nick);
    }
    
    public void packetListener() {
        TagListener.packet = new PacketAdapter(this.main, ListenerPriority.NORMAL, Arrays.asList(PacketType.Play.Server.SCOREBOARD_TEAM)) {
            public void onPacketSending(final PacketEvent e) {
                final WrapperPlayServerScoreboardTeam tag = new WrapperPlayServerScoreboardTeam(e.getPacket());
                final Player target = e.getPlayer();
                final String name = tag.getTeamName();
                final DataGuild user = TagListener.this.main.getDatasource().getGuildByTag(name);
                final DataGuildUser userTarget = Datasource.getUserByNick(target.getName());
                if (user != null && userTarget != null) {
                    if (!userTarget.getTag().equals("")) {
                        if (user.getTag().equals(userTarget.getTag())) {
                            tag.setTeamPrefix("§a[" + user.getTag() + "] ");
                        }
                        else if (!user.getTag().equals("")) {
                            tag.setTeamPrefix("§c[" + user.getTag() + "] ");
                        }
                        final DataGuild gildiaTarget = Datasource.getGuildByName(userTarget.getNazwa());
                        if (gildiaTarget != null && !user.getTag().equals("") && !userTarget.getTag().equals("")) {
                            for (final String sojusze : gildiaTarget.getSojusze()) {
                                if (user.getTag().contains(sojusze)) {
                                    tag.setTeamPrefix("§6[" + user.getTag() + "] ");
                                }
                            }
                        }
                    }
                    else {
                        tag.setTeamPrefix("§c[" + user.getTag() + "] ");
                    }
                }
                if (userTarget != null) {
                    if (name.equals(String.valueOf(target.getPlayer().getName()) + "|" + 1)) {
                        System.out.println(String.valueOf(target.getName()) + "           1");
                        tag.setTeamSuffix(Integer.toString(userTarget.getKills()));
                        if (target.getName().equals("Tirex_PL")) {
                            tag.setTeamPrefix("1");
                        }
                    }
                    else if (name.equals(String.valueOf(target.getPlayer().getName()) + "|" + 2)) {
                        tag.setTeamSuffix(Integer.toString(userTarget.getDeaths()));
                    }
                    else if (name.equals(String.valueOf(target.getPlayer().getName()) + "|" + 3)) {
                        tag.setTeamSuffix(Integer.toString(userTarget.getPoints()));
                    }
                    else if (name.equals(String.valueOf(target.getPlayer().getName()) + "|" + 4)) {
                        tag.setTeamSuffix(userTarget.getNick());
                    }
                }
            }
        };
        this.main.prot.addPacketListener((PacketListener)TagListener.packet);
    }
}
