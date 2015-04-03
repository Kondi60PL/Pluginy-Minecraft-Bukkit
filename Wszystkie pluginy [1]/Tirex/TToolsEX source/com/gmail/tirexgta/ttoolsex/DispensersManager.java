package com.gmail.tirexgta.ttoolsex;

import org.bukkit.configuration.file.*;
import java.io.*;
import org.bukkit.*;
import java.util.*;

public class DispensersManager
{
    Main plugin;
    YamlConfiguration data;
    
    public DispensersManager(final Main plugin) {
        super();
        this.plugin = plugin;
        this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "dispensers.yml"));
        this.setupConfig();
    }
    
    public void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "dispensers.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku dispensers.yml");
        }
    }
    
    public void setupConfig() {
        if (!this.data.isConfigurationSection("data")) {
            this.data.createSection("data");
            final List<String> dispensers = new ArrayList<String>();
            this.data.set("data.dispensers", (Object)dispensers);
            this.saveData();
        }
    }
    
    public void addDispenser(final Location location) {
        final List<String> dispensers = (List<String>)this.data.getStringList("data.dispensers");
        dispensers.add(String.valueOf(location.getWorld().getName()) + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.data.set("data.dispensers", (Object)dispensers);
        this.saveData();
    }
    
    public void delDispenser(final Location location) {
        final List<String> dispensers = (List<String>)this.data.getStringList("data.dispensers");
        dispensers.remove(String.valueOf(location.getWorld().getName()) + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.data.set("data.dispensers", (Object)dispensers);
        this.saveData();
    }
    
    public boolean isUnlimitedDispenser(final Location location) {
        final List<String> dispensers = (List<String>)this.data.getStringList("data.dispensers");
        for (final String string : dispensers) {
            if (string.equalsIgnoreCase(String.valueOf(location.getWorld().getName()) + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ())) {
                return true;
            }
        }
        return false;
    }
}
