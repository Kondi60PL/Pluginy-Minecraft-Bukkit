package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import java.util.*;
import java.text.*;
import com.gmail.tirexgta.ttoolsex.database.*;
import org.bukkit.event.*;

public class BanListener implements Listener
{
    final Main plugin;
    
    public BanListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerLogin(final PlayerLoginEvent event) {
        final DataUser user = Datasource.getUserData(event.getPlayer());
        final DataBan ban = this.plugin.data.getBanData(event.getPlayer());
        if (user != null && ban != null && !event.getPlayer().hasPermission("tools.ban.bypass")) {
            if (ban.getTime() <= System.currentTimeMillis()) {
                ban.delete();
            }
            else {
                final Date date = new Date(ban.getTime());
                final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final String timeShow = dt.format(date);
                final DataUser banAdmin = ban.admin;
                String banAdminString = "";
                if (banAdmin == null) {
                    banAdminString = "CONSOLE";
                }
                else {
                    banAdminString = banAdmin.getNick();
                }
                event.disallow(PlayerLoginEvent.Result.KICK_BANNED, "§cZostales zbanowany do: §6" + timeShow + "§c.\n§cPowod: §6" + ban.getReason() + "\n§cPrzez: §6" + banAdminString);
            }
        }
    }
}
