package com.gmail.tirexgta.tchatex;

import org.bukkit.plugin.java.*;
import net.milkbowl.vault.permission.*;
import net.milkbowl.vault.chat.*;
import java.util.logging.*;
import com.gmail.tirexgta.tchatex.commands.*;
import com.gmail.tirexgta.tchatex.listeners.*;
import org.bukkit.plugin.*;
import org.bukkit.*;

public class Main extends JavaPlugin
{
    static Permission permission;
    static Chat chat;
    static Logger log;
    public ConfigManager configManager;
    public ChatCommand chatCommand;
    ChatListener chatListener;
    
    public void onEnable() {
        setupPermission();
        setupChat();
        Main.log = this.getLogger();
        this.configManager = new ConfigManager(this);
        this.chatCommand = new ChatCommand(this, "chat");
        this.chatListener = new ChatListener(this);
    }
    
    public void onDisable() {
    }
    
    public static Logger getLog() {
        return Main.log;
    }
    
    public static Permission setupPermission() {
        final RegisteredServiceProvider<Permission> chatProvider = (RegisteredServiceProvider<Permission>)Bukkit.getServicesManager().getRegistration((Class)Permission.class);
        if (chatProvider != null) {
            if (Main.permission == null) {
                Main.permission = (Permission)chatProvider.getProvider();
            }
        }
        else {
            getLog().info("§4Na serwerze nie ma pluginu §9Vault §4Plugin moze nie dzialac w 100% poprawnie!");
        }
        return Main.permission;
    }
    
    public static Chat setupChat() {
        final RegisteredServiceProvider<Chat> chatProvider = (RegisteredServiceProvider<Chat>)Bukkit.getServicesManager().getRegistration((Class)Chat.class);
        if (chatProvider != null) {
            if (Main.chat == null) {
                Main.chat = (Chat)chatProvider.getProvider();
            }
        }
        else {
            getLog().info("§4Na serwerze nie ma pluginu §9Vault §4Plugin moze nie dzialac w 100% poprawnie!");
        }
        return Main.chat;
    }
    
    public static String fixMsg(final String s) {
        if (s != null) {
            return ChatColor.translateAlternateColorCodes('&', s);
        }
        return null;
    }
}
