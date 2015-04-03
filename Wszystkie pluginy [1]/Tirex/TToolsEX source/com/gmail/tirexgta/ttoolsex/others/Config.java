package com.gmail.tirexgta.ttoolsex.others;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.configuration.file.*;
import java.util.*;

public class Config
{
    public Main plugin;
    public static FileConfiguration config;
    public int autoSaveDelay;
    public List<String> autoMessageMessages;
    public int autoMessageDelay;
    public String autoMessagePrefix;
    public int slotManagerSlots;
    public String slotManagerMotd;
    public List<String> helpMessages;
    public int teleportDelay;
    public int teleportSpawnCooldown;
    public boolean silentJoinLeave;
    public List<String> welcomeMessage;
    public String mysqlHost;
    public String mysqlUser;
    public String mysqlPass;
    public String mysqlDb;
    public int randomMin;
    public int randomMax;
    public int randomGroupRadius;
    
    public Config(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getConfig().options().copyDefaults(true);
        this.plugin.saveConfig();
        this.load();
    }
    
    public void load() {
        this.autoSaveDelay = this.plugin.getConfig().getInt("config.auto-save.delay");
        this.autoMessageMessages = (List<String>)this.plugin.getConfig().getStringList("config.automessage.messages");
        this.autoMessageDelay = this.plugin.getConfig().getInt("config.automessage.delay");
        this.autoMessagePrefix = this.plugin.getConfig().getString("config.automessage.prefix");
        this.slotManagerSlots = this.plugin.getConfig().getInt("config.slotmanager.slots");
        this.slotManagerMotd = this.plugin.getConfig().getString("config.slotmanager.motd");
        this.helpMessages = (List<String>)this.plugin.getConfig().getStringList("config.helpMessages");
        this.teleportDelay = this.plugin.getConfig().getInt("config.teleport.delay");
        this.teleportSpawnCooldown = this.plugin.getConfig().getInt("config.teleport.spawn.cooldown");
        this.silentJoinLeave = this.plugin.getConfig().getBoolean("config.silentjoinleave");
        this.welcomeMessage = (List<String>)this.plugin.getConfig().getStringList("config.welcomemessage");
        this.mysqlHost = this.plugin.getConfig().getString("MySQL.Host");
        this.mysqlUser = this.plugin.getConfig().getString("MySQL.Username");
        this.mysqlPass = this.plugin.getConfig().getString("MySQL.Password");
        this.mysqlDb = this.plugin.getConfig().getString("MySQL.Database");
        this.randomMin = this.plugin.getConfig().getInt("config.randomtp.min");
        this.randomMax = this.plugin.getConfig().getInt("config.randomtp.max");
        this.randomGroupRadius = this.plugin.getConfig().getInt("config.randomtp.groups.radius");
    }
    
    public void save() {
        this.plugin.getConfig().set("config.auto-save.delay", (Object)this.autoSaveDelay);
        this.plugin.getConfig().set("config.automessage.messages", (Object)this.autoMessageMessages);
        this.plugin.getConfig().set("config.automessage.delay", (Object)this.autoMessageDelay);
        this.plugin.getConfig().set("config.automessage.prefix", (Object)this.autoMessagePrefix);
        this.plugin.getConfig().set("config.slotmanager.slots", (Object)this.slotManagerSlots);
        this.plugin.getConfig().set("config.slotmanager.motd", (Object)this.slotManagerMotd);
        this.plugin.getConfig().set("config.helpMessages", (Object)this.helpMessages);
        this.plugin.getConfig().set("config.teleport.delay", (Object)this.teleportDelay);
        this.plugin.getConfig().set("config.teleport.spawn.cooldown", (Object)this.teleportSpawnCooldown);
        this.plugin.getConfig().set("config.silentjoinleave", (Object)this.silentJoinLeave);
        this.plugin.getConfig().set("config.welcomemessage", (Object)this.welcomeMessage);
        this.plugin.getConfig().set("MySQL.Host", (Object)this.mysqlHost);
        this.plugin.getConfig().set("MySQL.Username", (Object)this.mysqlUser);
        this.plugin.getConfig().set("MySQL.Password", (Object)this.mysqlPass);
        this.plugin.getConfig().set("MySQL.Database", (Object)this.mysqlDb);
        this.plugin.getConfig().set("config.randomtp.min", (Object)this.randomMin);
        this.plugin.getConfig().set("config.randomtp.max", (Object)this.randomMax);
        this.plugin.getConfig().set("config.randomtp.groups.radius", (Object)this.randomGroupRadius);
        this.plugin.saveConfig();
    }
    
    public void reload() {
        this.load();
    }
}
