package com.gmail.tirexgta.tguildsex.listeners;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.entity.*;
import org.bukkit.block.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.tguildsex.mysql.*;

public class ExplodeListener implements Listener
{
    Main plugin;
    
    public ExplodeListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onEntityExplode(final EntityExplodeEvent e) {
        for (final Block block : e.blockList()) {
            final DataGuild gildia = this.plugin.getGildiaByBlock(block);
            if (gildia != null) {
                gildia.setLastExplode(System.currentTimeMillis() + 1000 * this.plugin.configManager.guildExplodeTime);
            }
        }
    }
    
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
        if (user != null) {
            final DataGuild gildia = this.plugin.getGildiaByBlock(e.getBlock());
            if (gildia != null && user.getTag().toLowerCase().equals(gildia.getTag().toLowerCase())) {
                final long explode = gildia.getLastExplode();
                if (explode > System.currentTimeMillis()) {
                    e.setCancelled(true);
                    p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.regionBuildExplode).replace("%time%", Long.toString((explode - System.currentTimeMillis()) / 1000L)));
                }
            }
        }
    }
}
