package com.gmail.tirexgta.ttoolsex;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;

public class IgnoredManager
{
    Main plugin;
    FileConfiguration data;
    
    public IgnoredManager(final Main plugin) {
        super();
        this.plugin = plugin;
        this.data = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "ignored.yml"));
        this.setupConfig();
    }
    
    public void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "ignored.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku ignored.yml");
        }
    }
    
    public void setupConfig() {
        if (!this.data.isConfigurationSection("ignored")) {
            this.data.createSection("ignored");
            this.saveData();
        }
    }
    
    public boolean isIgnoredByPlayer(final Player player, final OfflinePlayer ignored) {
        return this.getIgnored(player).contains(ignored);
    }
    
    public List<OfflinePlayer> getIgnored(final Player player) {
        final List<OfflinePlayer> ignored = new ArrayList<OfflinePlayer>();
        if (this.data.getStringList("ignored." + player.getName()) != null) {
            final List<String> ignoredStringList = (List<String>)this.data.getStringList("ignored." + player.getName());
            for (final String ignoredNickName : ignoredStringList) {
                ignored.add(Bukkit.getOfflinePlayer(ignoredNickName));
            }
        }
        return ignored;
    }
    
    public void removeIgnored(final Player player, final OfflinePlayer ignored) {
        if (!this.data.isList("ignored." + player.getName())) {
            this.data.set("ignored." + player.getName(), (Object)new ArrayList());
        }
        final List<String> ignoredList = (List<String>)this.data.getStringList("ignored." + player.getName());
        ignoredList.remove(ignored.getName());
        this.data.set("ignored." + player.getName(), (Object)ignoredList);
        this.saveData();
    }
    
    public void addIgnored(final Player player, final OfflinePlayer ignored) {
        if (!this.data.isList("ignored." + player.getName())) {
            this.data.set("ignored." + player.getName(), (Object)new ArrayList());
        }
        final List<String> ignoredList = (List<String>)this.data.getStringList("ignored." + player.getName());
        ignoredList.add(ignored.getName());
        this.data.set("ignored." + player.getName(), (Object)ignoredList);
        this.saveData();
    }
}
