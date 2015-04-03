package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;

public class InvincibleListener implements Listener
{
    Main plugin;
    
    public InvincibleListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteractEntity(final PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Player) && this.interact(event.getPlayer(), event.getRightClicked())) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onEntityDamage(final EntityDamageEvent event) {
        if (event instanceof EntityDamageByEntityEvent) {
            return;
        }
        if (!(event.getEntity() instanceof Player) && this.interact(null, event.getEntity())) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) && event.getDamager() instanceof Player && this.interact((Player)event.getDamager(), event.getEntity())) {
            event.setCancelled(true);
        }
    }
    
    public boolean interact(final Player player, final Entity clicked) {
        if (player != null) {
            if (this.plugin.invincibleManager.isInCommand(player)) {
                this.plugin.invincibleManager.setInCommand(player, false);
                if (this.plugin.invincibleManager.isInvincible(clicked)) {
                    this.plugin.invincibleManager.setInvincible(clicked, false);
                    player.sendMessage("§9Ten mob nie jest juz niesmietelny!");
                }
                else {
                    this.plugin.invincibleManager.setInvincible(clicked, true);
                    player.sendMessage("§9Zrobiles tego moba niesmiertelnym!");
                }
                return true;
            }
            if (player.hasPermission("tirex.invincible.interact")) {
                return false;
            }
        }
        return this.plugin.invincibleManager.isInvincible(clicked);
    }
}
