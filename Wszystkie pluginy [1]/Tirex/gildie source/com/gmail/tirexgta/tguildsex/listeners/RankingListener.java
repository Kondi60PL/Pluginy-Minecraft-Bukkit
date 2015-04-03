package com.gmail.tirexgta.tguildsex.listeners;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;

public class RankingListener implements Listener
{
    Main plugin;
    
    public RankingListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
        this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player online = onlinePlayers[i];
                    final DataGuildUser user = plugin.data.getUserByPlayer(online);
                    if (user.getLastAttack() != 0L && user.getLastAttack() < System.currentTimeMillis()) {
                        user.setLastAttack(0L);
                        online.sendMessage("§aSkonczyles Walczyc! Mozesz sie Wylogowac!");
                    }
                }
            }
        }, 20L, 20L);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(final PlayerDeathEvent e) {
        final Player attackerNoPlayer = e.getEntity().getKiller();
        final Player victimNoPlayer = e.getEntity();
        if (!(victimNoPlayer instanceof Player)) {
            return;
        }
        final Player victim = victimNoPlayer.getPlayer();
        final DataGuildUser vUser = this.plugin.data.getUserByPlayer(victim);
        vUser.setDeaths(vUser.getDeaths() + 1);
        vUser.setLastAttack(0L);
        vUser.update();
        final DataGuild vGildia = this.plugin.data.getGuildByTag(vUser.getTag());
        if (vGildia != null) {
            vGildia.setZgony(vGildia.getZgony() + 1);
            vGildia.update();
        }
        if (!(attackerNoPlayer instanceof Player)) {
            return;
        }
        final Player attacker = attackerNoPlayer.getPlayer();
        if (victim.equals(attacker)) {
            return;
        }
        final DataGuildUser aUser = this.plugin.data.getUserByPlayer(attacker);
        final int aPoint = aUser.getPoints();
        final int vPoint = vUser.getPoints();
        final int pointFinal = vPoint / 6 - aPoint / 8;
        aUser.setPoints(aPoint + pointFinal);
        aUser.setKills(aUser.getKills() + 1);
        aUser.update();
        vUser.setPoints(vPoint - pointFinal);
        vUser.update();
        final DataGuild aGildia = this.plugin.data.getGuildByTag(aUser.getTag());
        if (aGildia != null) {
            aGildia.setPunkty(aGildia.getPunkty() + pointFinal);
            aGildia.setZabicia(aGildia.getZabicia() + 1);
            aGildia.update();
        }
        if (vGildia != null) {
            vGildia.setPunkty(vGildia.getPunkty() - pointFinal);
            vGildia.update();
        }
        e.setDeathMessage("§c" + victim.getName() + " §6zostal zabity przez §c" + attacker.getName() + "§6  §c" + Integer.toString(pointFinal) + "§6");
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (e.isCancelled()) {
            return;
        }
        final double dmg = e.getDamage();
        if (dmg == 0.0) {
            return;
        }
        final Entity victimNoPlayer = e.getEntity();
        if (!(victimNoPlayer instanceof Player)) {
            return;
        }
        final Entity attackerNoPlayer = e.getDamager();
        if (!(attackerNoPlayer instanceof Player)) {
            return;
        }
        final Player victim = ((Player)victimNoPlayer).getPlayer();
        final Player attacker = ((Player)attackerNoPlayer).getPlayer();
        if (victim.equals(attacker)) {
            return;
        }
        final DataGuildUser vUser = this.plugin.data.getUserByPlayer(victim);
        final long time = System.currentTimeMillis();
        if (vUser.getLastAttack() < time) {
            victim.sendMessage("§4Zostales zaatakowany przez 10 sekund nie mozesz sie wylogowac!");
        }
        vUser.setLastAttack(time + 10000L);
        vUser.setLastAttacker(attacker.getName());
    }
    
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
        final long time = System.currentTimeMillis();
        if (user.getLastAttack() > time) {
            p.setHealth(0.0);
            Bukkit.broadcastMessage("§7Gracz §3" + p.getName() + " §7wylogowal sie Podczas Walki! §3- 50 pkt§7!");
            Bukkit.broadcastMessage("§7Ostatni Atakujacy: §3" + user.getLastAttacker());
            final DataGuildUser aUser = this.plugin.data.getUserByNickName(user.getLastAttacker());
            final int aPoint = aUser.getPoints();
            final int vPoint = user.getPoints();
            final int pointFinal = vPoint / 6 - aPoint / 8;
            aUser.setPoints(aPoint + pointFinal);
            aUser.setKills(aUser.getKills() + 1);
            user.setPoints(vPoint - pointFinal - 50);
            user.setDeaths(user.getDeaths() + 1);
            user.setLastAttack(0L);
            aUser.update();
            user.update();
            final DataGuild aGildia = this.plugin.data.getGuildByTag(aUser.getTag());
            if (aGildia != null) {
                aGildia.setPunkty(aGildia.getPunkty() + pointFinal);
                aGildia.setZabicia(aGildia.getZabicia() + 1);
                aGildia.update();
            }
            final DataGuild vGildia = this.plugin.data.getGuildByTag(user.getTag());
            if (vGildia != null) {
                vGildia.setPunkty(vGildia.getPunkty() - pointFinal - 50);
                vGildia.setZgony(vGildia.getZgony() + 1);
                vGildia.update();
            }
        }
    }
}
