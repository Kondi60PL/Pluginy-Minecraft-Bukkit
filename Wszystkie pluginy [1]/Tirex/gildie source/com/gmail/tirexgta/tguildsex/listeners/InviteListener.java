package com.gmail.tirexgta.tguildsex.listeners;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class InviteListener implements Listener
{
    Main plugin;
    
    public InviteListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (this.plugin.guildCommand.getInvites().containsKey(p)) {
            this.plugin.guildCommand.getInvites().remove(p);
        }
    }
}
