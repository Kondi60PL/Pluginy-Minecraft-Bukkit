package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import java.util.*;
import java.text.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.ttoolsex.database.*;
import org.bukkit.event.*;

public class MuteListener implements Listener
{
    Main plugin;
    
    public MuteListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final DataUser user = Datasource.getUserData(player);
        if (user.getMute() != null && user.getMuteTime() != 0L) {
            if (user.getMuteTime() <= System.currentTimeMillis()) {
                player.sendMessage("§6Od tej pory mozesz juz pisac.\n§6Uwazaj, aby znow nie zostac wyciszonym!");
                user.setMute(null);
                user.setMuteTime(0L);
            }
            else {
                event.setCancelled(true);
                final Date date = new Date(user.getMuteTime());
                final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final String timeShow = dt.format(date);
                player.sendMessage("§7Zostales wyciszony do §c" + timeShow + "§7. Powod: §c" + user.getMute());
            }
        }
    }
}
