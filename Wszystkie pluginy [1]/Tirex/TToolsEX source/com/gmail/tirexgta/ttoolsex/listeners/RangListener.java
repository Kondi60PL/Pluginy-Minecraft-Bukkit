package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import net.milkbowl.vault.permission.*;
import org.bukkit.event.*;

public class RangListener implements Listener
{
    Main plugin;
    
    public RangListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        final OfflinePlayer offlineP = Bukkit.getOfflinePlayer(p.getName());
        if (this.plugin.rangManager.playerByList.contains(offlineP) && this.plugin.rangManager.rangaCzas.containsKey(offlineP)) {
            final long czasRangi = this.plugin.rangManager.rangaCzas.get(offlineP);
            if (czasRangi > System.currentTimeMillis()) {
                final Permission chat = Main.chat;
                final String ranga = this.plugin.rangManager.rangaNazwa.get(offlineP);
                String groupsPlayer = null;
                String[] playerGroups;
                for (int length = (playerGroups = chat.getPlayerGroups(p)).length, i = 0; i < length; ++i) {
                    final String groupPlayer = playerGroups[i];
                    if (groupPlayer.equals(ranga)) {
                        groupsPlayer = groupPlayer;
                    }
                }
                if (groupsPlayer == null) {
                    chat.playerAddGroup(p, ranga);
                }
            }
            else {
                final Permission chat = Main.chat;
                chat.playerRemoveGroup(p, (String)this.plugin.rangManager.rangaNazwa.get(offlineP));
                this.plugin.rangManager.removeRang(p);
            }
        }
    }
}
