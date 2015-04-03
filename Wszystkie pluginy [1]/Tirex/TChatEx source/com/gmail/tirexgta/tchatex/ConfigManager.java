package com.gmail.tirexgta.tchatex;

import org.bukkit.configuration.*;
import java.util.*;

public class ConfigManager
{
    Main plugin;
    Configuration config;
    public List<String> formats;
    public List<String> clearMessage;
    public int slowTime;
    public String messageMuteOn;
    public String messageMuteOff;
    public String messageMuteSend;
    public String messageSlowSend;
    
    public ConfigManager(final Main plugin) {
        super();
        this.formats = new ArrayList<String>();
        this.clearMessage = new ArrayList<String>();
        this.slowTime = 0;
        this.plugin = plugin;
        this.plugin.getConfig().options().copyDefaults(true);
        this.plugin.saveConfig();
        this.load();
    }
    
    public void load() {
        final ConfigurationSection formatSection = this.plugin.getConfig().getConfigurationSection("config.format");
        if (formatSection != null) {
            this.formats = new ArrayList<String>();
            for (final String format : formatSection.getKeys(false)) {
                this.formats.add(String.valueOf(format) + "@" + formatSection.getString(format));
            }
        }
        this.clearMessage = (List<String>)this.plugin.getConfig().getStringList("config.clear.message");
        this.slowTime = this.plugin.getConfig().getInt("config.slow.time");
        this.messageMuteOn = this.plugin.getConfig().getString("config.mute.message.wlacz");
        this.messageMuteOff = this.plugin.getConfig().getString("config.mute.message.wylacz");
        this.messageMuteSend = this.plugin.getConfig().getString("config.mute.message.send");
        this.messageSlowSend = this.plugin.getConfig().getString("config.slow.message.send");
    }
    
    public void reload() {
        this.load();
    }
}
