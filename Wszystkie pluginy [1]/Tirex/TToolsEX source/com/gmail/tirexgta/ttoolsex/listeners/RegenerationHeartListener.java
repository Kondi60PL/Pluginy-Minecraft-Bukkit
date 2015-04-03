package com.gmail.tirexgta.ttoolsex.listeners;

import org.bukkit.plugin.*;
import org.bukkit.event.entity.*;
import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class RegenerationHeartListener implements Listener
{
    Main plugin;
    
    public RegenerationHeartListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onEntityRegainHealth(final EntityRegainHealthEvent e) {
        final Entity victimNoPlayer = e.getEntity();
        if (!(victimNoPlayer instanceof Player)) {
            return;
        }
        final Player victim = ((Player)victimNoPlayer).getPlayer();
        final Location loc = victim.getLocation();
        try {
            EffectManager.sendToLocation(EffectManager.HEART, loc, 0.5f, 1.0f, 0.5f, 0.1f, 2);
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
