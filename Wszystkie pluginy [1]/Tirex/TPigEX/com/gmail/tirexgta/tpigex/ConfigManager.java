package com.gmail.tirexgta.tpigex;

import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.configuration.*;
import java.util.*;

public class ConfigManager
{
    Main plugin;
    public Set<PigManager> pigs;
    public HashMap<String, PigManager> pigByName;
    public HashMap<Location, List<PigManager>> pigByLocation;
    
    public ConfigManager() {
        super();
        this.pigs = new HashSet<PigManager>();
        this.pigByName = new HashMap<String, PigManager>();
        this.pigByLocation = new HashMap<Location, List<PigManager>>();
        this.plugin = Main.getInstance();
        this.plugin.getConfig().options().copyDefaults(true);
        this.plugin.saveConfig();
        this.load();
    }
    
    public void load() {
        if (!this.plugin.getConfig().isConfigurationSection("spawned")) {
            this.plugin.getConfig().createSection("spawned");
        }
        final ConfigurationSection cs$1 = this.plugin.getConfig().getConfigurationSection("spawned");
        final Iterator<String> it$1 = cs$1.getKeys(false).iterator();
        while (it$1.hasNext()) {
            final ConfigurationSection cs$2 = cs$1.getConfigurationSection((String)it$1.next());
            final PigManager pm = new PigManager(cs$2);
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    pm.insert();
                }
            }, 1L);
        }
        this.plugin.saveConfig();
    }
    
    public void save() {
        for (final PigManager pm : this.pigs) {
            pm.save();
        }
        this.plugin.saveConfig();
    }
}
