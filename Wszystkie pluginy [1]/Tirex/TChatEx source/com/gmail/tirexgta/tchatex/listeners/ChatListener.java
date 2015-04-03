package com.gmail.tirexgta.tchatex.listeners;

import com.gmail.tirexgta.tchatex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;

public class ChatListener implements Listener
{
    Main plugin;
    
    public ChatListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (this.plugin.chatCommand.mute && !p.hasPermission("tirex.chat.mute")) {
            final String msg = this.plugin.configManager.messageMuteSend;
            p.sendMessage(Main.fixMsg(msg));
            e.setCancelled(true);
            return;
        }
        if (this.plugin.chatCommand.slow.containsKey(p.getName().toLowerCase())) {
            final long czas = this.plugin.chatCommand.slow.get(p.getName().toLowerCase());
            if (czas > System.currentTimeMillis()) {
                if (!p.hasPermission("tirex.chat.slow")) {
                    final long slow = (czas - System.currentTimeMillis()) / 1000L;
                    if (slow != 0L) {
                        String msg2 = this.plugin.configManager.messageSlowSend;
                        msg2 = msg2.replace("%time%", Long.toString(slow));
                        p.sendMessage(Main.fixMsg(msg2));
                        e.setCancelled(true);
                        return;
                    }
                }
            }
            else {
                this.plugin.chatCommand.slow.remove(p.getName().toLowerCase());
            }
        }
        if (!p.hasPermission("tirex.chat.slow")) {
            this.plugin.chatCommand.slow.put(p.getName().toLowerCase(), System.currentTimeMillis() + 1000 * this.plugin.configManager.slowTime);
        }
        for (final String format : this.plugin.configManager.formats) {
            final String[] splitFormat = format.split("\\@");
            if (Main.setupPermission().playerInGroup(p, splitFormat[0])) {
                e.setFormat(splitFormat[1]);
            }
        }
        String format = e.getFormat();
        format = format.replace(">>", "»");
        format = format.replace("{MESSAGE}", "%2$s");
        format = format.replace("{NICK}", "%1$s");
        final String prefix = Main.setupChat().getPlayerPrefix(p);
        format = format.replace("{PREFIX}", (prefix != null) ? prefix : "");
        final String suffix = Main.setupChat().getPlayerSuffix(p);
        format = format.replace("{SUFFIX}", (suffix != null) ? suffix : "");
        e.setFormat(Main.fixMsg(format));
    }
}
