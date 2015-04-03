package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.ttoolsex.database.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;

public class UserJoinLeaveListener implements Listener
{
    Main plugin;
    
    public UserJoinLeaveListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        DataUser user = Datasource.getUserData(player);
        if (user == null) {
            user = this.plugin.data.createUser();
            user.setNick(player.getName());
            this.plugin.exportPlayerData(user, player);
            user.insert();
        }
        else {
            this.plugin.importPlayerData(user, player);
        }
    }
    
    @EventHandler
    public void onPlayerLeave(final PlayerQuitEvent event) {
        this.leftGame(event.getPlayer());
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerKick(final PlayerKickEvent event) {
        this.leftGame(event.getPlayer());
    }
    
    void leftGame(final Player player) {
        final DataUser user = Datasource.getUserData(player);
        if (user != null) {
            this.plugin.exportPlayerData(user, player);
            user.update();
        }
    }
}
