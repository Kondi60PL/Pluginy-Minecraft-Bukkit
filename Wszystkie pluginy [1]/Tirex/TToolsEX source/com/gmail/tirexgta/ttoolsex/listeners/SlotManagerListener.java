package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.server.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class SlotManagerListener implements Listener
{
    Main plugin;
    
    public SlotManagerListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onAsyncPlayerPreLogin(final AsyncPlayerPreLoginEvent e) {
        e.allow();
    }
    
    @EventHandler
    public void onServerListPing(final ServerListPingEvent e) {
        if (this.plugin.config.slotManagerSlots != 0) {
            e.setMaxPlayers(this.plugin.config.slotManagerSlots);
        }
        if (this.plugin.getConfig().isString("config.slotmanager.motd")) {
            final String motd = this.plugin.config.slotManagerMotd;
            e.setMotd(motd.replaceAll("&", "§"));
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (this.plugin.slot() >= this.plugin.config.slotManagerSlots && !p.hasPermission("tirex.joinfullserver")) {
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GOLD + "Serwer jest pelen. Sprobuj pozniej lub zakup range VIP!");
        }
    }
}
