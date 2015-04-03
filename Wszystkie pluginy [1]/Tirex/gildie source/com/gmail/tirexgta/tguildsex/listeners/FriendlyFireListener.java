package com.gmail.tirexgta.tguildsex.listeners;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import org.bukkit.event.*;

public class FriendlyFireListener implements Listener
{
    Main plugin;
    
    public FriendlyFireListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onDamage(final EntityDamageByEntityEvent e) {
        final Entity attackerNoPlayer = e.getDamager();
        final Entity victimNoPlayer = e.getEntity();
        if (victimNoPlayer instanceof Player && attackerNoPlayer instanceof Player) {
            final Player attacker = (Player)attackerNoPlayer;
            final Player victim = (Player)victimNoPlayer;
            final DataGuildUser userAttacker = this.plugin.data.getUserByPlayer(attacker);
            final DataGuildUser userVictim = this.plugin.data.getUserByPlayer(victim);
            if (userAttacker.getTag().toLowerCase().equals(userVictim.getTag().toLowerCase())) {
                final DataGuild gildia = this.plugin.data.getGuildByTag(userAttacker.getTag());
                if (gildia != null && gildia.getFriendlyFire() == 0) {
                    e.setDamage(0.0);
                }
            }
            else {
                final DataGuild gildiaAttacker = this.plugin.data.getGuildByTag(userAttacker.getTag());
                final DataGuild gildiaVictim = this.plugin.data.getGuildByTag(userVictim.getTag());
                if (gildiaAttacker != null && gildiaVictim != null && gildiaAttacker.getSojusze().contains(gildiaVictim.getTag())) {
                    e.setDamage(0.0);
                }
            }
        }
    }
}
