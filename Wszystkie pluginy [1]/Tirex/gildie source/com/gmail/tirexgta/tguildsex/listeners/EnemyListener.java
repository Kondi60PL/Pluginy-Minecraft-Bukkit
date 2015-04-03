package com.gmail.tirexgta.tguildsex.listeners;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

public class EnemyListener implements Listener
{
    Main plugin;
    
    public EnemyListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final DataGuild from = this.plugin.getGildiaByLocation(e.getFrom());
        final DataGuild to = this.plugin.getGildiaByLocation(e.getTo());
        if (from == null && to != null) {
            final List<String> czlonkowie = to.getCzlonkowie();
            if (!czlonkowie.contains(p.getName())) {
                final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
                final DataGuild guild = this.plugin.data.getGuildByTag(user.getTag());
                if (guild != null) {
                    final List<String> guildSojusze = guild.getSojusze();
                    if (guildSojusze.contains(guild.getTag())) {
                        for (final String czlonek : to.getCzlonkowie()) {
                            final Player other = Bukkit.getPlayerExact(czlonek);
                            if (other != null) {
                                other.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.regionJoinEnemy));
                            }
                        }
                    }
                }
                else {
                    for (final String czlonek2 : to.getCzlonkowie()) {
                        final Player other2 = Bukkit.getPlayerExact(czlonek2);
                        if (other2 != null) {
                            other2.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.regionJoinEnemy));
                        }
                    }
                }
            }
            p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.regionJoin).replace("%tag%", to.getTag()).replace("%name%", to.getName()));
        }
        else if (from != null && to == null) {
            p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.regionLeave).replace("%tag%", from.getTag()).replace("%name%", from.getName()));
        }
    }
    
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
        final DataGuild gildia = this.plugin.getGildiaByBlock(e.getBlock());
        if (gildia != null && !gildia.getTag().toLowerCase().equals(user.getTag().toLowerCase())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
        final DataGuild gildia = this.plugin.getGildiaByBlock(e.getBlock());
        if (gildia != null && !gildia.getTag().toLowerCase().equals(user.getTag().toLowerCase())) {
            e.setCancelled(true);
            p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.regionBreak));
        }
    }
}
