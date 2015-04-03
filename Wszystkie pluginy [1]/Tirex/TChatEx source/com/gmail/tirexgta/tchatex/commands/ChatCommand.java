package com.gmail.tirexgta.tchatex.commands;

import com.gmail.tirexgta.tchatex.*;
import org.bukkit.command.*;
import org.bukkit.*;
import java.util.*;

public class ChatCommand implements CommandExecutor
{
    Main plugin;
    public boolean mute;
    public HashMap<String, Long> slow;
    
    public ChatCommand(final Main plugin, final String cmd) {
        super();
        this.mute = false;
        this.slow = new HashMap<String, Long>();
        this.plugin = plugin;
        this.plugin.getCommand(cmd).setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            this.info(sender);
            return true;
        }
        if (args[0].equalsIgnoreCase("mute")) {
            if (this.mute) {
                this.mute = false;
                String msg = this.plugin.configManager.messageMuteOn;
                msg = msg.replace("%player%", sender.getName());
                Bukkit.broadcastMessage(Main.fixMsg(msg));
            }
            else {
                this.mute = true;
                String msg = this.plugin.configManager.messageMuteOff;
                msg = msg.replace("%player%", sender.getName());
                Bukkit.broadcastMessage(Main.fixMsg(msg));
            }
        }
        else if (args[0].equalsIgnoreCase("clear")) {
            for (int i = 0; i < 100; ++i) {
                Bukkit.broadcastMessage("");
            }
            for (String msg : this.plugin.configManager.clearMessage) {
                msg = msg.replace("%player%", sender.getName());
                Bukkit.broadcastMessage(Main.fixMsg(msg));
            }
        }
        else if (args[0].equalsIgnoreCase("reload")) {
            this.plugin.configManager.reload();
            sender.sendMessage(Main.fixMsg("&aDone!"));
        }
        else {
            this.info(sender);
        }
        return false;
    }
    
    void info(final CommandSender sender) {
        sender.sendMessage("§3Dostepne komendy:");
        sender.sendMessage("§3/chat clear - §7Komenda od czyszczenia chatu");
        sender.sendMessage("§3/chat mute - §7Komenda od mutowania chatu");
        sender.sendMessage("§3/chat reload - §7Komenda od przeladowania konfiguracji");
    }
}
