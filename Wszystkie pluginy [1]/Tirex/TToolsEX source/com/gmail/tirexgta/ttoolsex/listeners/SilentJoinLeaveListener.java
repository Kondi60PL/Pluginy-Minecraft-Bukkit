package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class SilentJoinLeaveListener implements Listener
{
    Main plugin;
    
    public SilentJoinLeaveListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        if (this.plugin.config.silentJoinLeave) {
            event.setJoinMessage((String)null);
        }
    }
    
    @EventHandler
    public void onPlayerLeave(final PlayerQuitEvent event) {
        if (this.plugin.config.silentJoinLeave) {
            event.setQuitMessage((String)null);
        }
    }
    
    @EventHandler
    public void onPlayerKick(final PlayerKickEvent event) {
        if (this.plugin.config.silentJoinLeave) {
            event.setLeaveMessage((String)null);
        }
    }
}
