package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.help.*;
import org.bukkit.event.*;

public class PermissionsCommandsListener implements Listener
{
    Main plugin;
    Plugin[] plugins;
    
    public PermissionsCommandsListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent e) {
        final String msg = e.getMessage();
        if (msg.length() >= 1) {
            final String[] msgSplit = msg.split(" ");
            final String commandString = msgSplit[0].replace("/", "");
            final Player sender = e.getPlayer();
            final Command command = (Command)this.plugin.getServer().getPluginCommand(commandString);
            if (command == null) {
                final HelpTopic topic = this.plugin.getServer().getHelpMap().getHelpTopic(msgSplit[0]);
                if (topic == null) {
                    sender.sendMessage(" §9\u2299  §cNie odnaleziono komendy...");
                    sender.sendMessage(" §9\u2299  §cAby otrzymac pomoc uzyj: §7/pomoc§c.");
                    e.setCancelled(true);
                }
            }
            else {
                final String commandPermission = command.getPermission();
                if (commandPermission != null) {
                    command.setPermissionMessage(" §9\u2299  §cNie masz uprawnien. §7(" + commandPermission + "§7)");
                }
            }
        }
    }
}
