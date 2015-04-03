package com.gmail.tirexgta.ttoolsex;

import org.bukkit.configuration.file.*;
import java.io.*;
import org.bukkit.*;
import java.util.*;

public class RandomTeleportManager
{
    Main plugin;
    YamlConfiguration data;
    List<String> randoms;
    List<String> randomsGroup;
    
    public RandomTeleportManager(final Main plugin) {
        super();
        this.randoms = new ArrayList<String>();
        this.randomsGroup = new ArrayList<String>();
        this.plugin = plugin;
        this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "randomtp.yml"));
        this.setupConfig();
        this.getRandomsTp();
        this.getRandomsTpGroups();
    }
    
    public void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "randomtp.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku randomtp.yml");
        }
    }
    
    public void setupConfig() {
        if (!this.data.isConfigurationSection("data")) {
            this.data.createSection("data");
            final List<String> dispensers = new ArrayList<String>();
            this.data.set("data.randomtp", (Object)dispensers);
            this.data.set("data.randomtpGroups", (Object)dispensers);
            this.saveData();
        }
    }
    
    public void addRandomTp(final Location location) {
        final List<String> dispensers = (List<String>)this.data.getStringList("data.randomtp");
        dispensers.add(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.data.set("data.randomtp", (Object)dispensers);
        this.randoms.add(String.valueOf(location.getWorld().getName()) + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.saveData();
    }
    
    public void delRandomTp(final Location location) {
        final List<String> dispensers = (List<String>)this.data.getStringList("data.randomtp");
        dispensers.remove(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.data.set("data.randomtp", (Object)dispensers);
        this.randoms.remove(String.valueOf(location.getWorld().getName()) + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.saveData();
    }
    
    public void addRandomTpGroups(final Location location) {
        final List<String> dispensers = (List<String>)this.data.getStringList("data.randomtpGroups");
        dispensers.add(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.data.set("data.randomtpGroups", (Object)dispensers);
        this.randomsGroup.add(String.valueOf(location.getWorld().getName()) + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.saveData();
    }
    
    public void delRandomTpGroups(final Location location) {
        final List<String> dispensers = (List<String>)this.data.getStringList("data.randomtpGroups");
        dispensers.remove(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.data.set("data.randomtpGroups", (Object)dispensers);
        this.randomsGroup.remove(String.valueOf(location.getWorld().getName()) + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        this.saveData();
    }
    
    public void getRandomsTp() {
        final List<String> randoms = (List<String>)this.data.getStringList("data.randomtp");
        for (final String string : randoms) {
            this.randoms.add(string);
        }
    }
    
    public void getRandomsTpGroups() {
        final List<String> randoms = (List<String>)this.data.getStringList("data.randomtpGroups");
        for (final String string : randoms) {
            this.randomsGroup.add(string);
        }
    }
    
    public boolean isRandomTp(final Location loc) {
        final List<String> randoms = this.randoms;
        for (final String string : randoms) {
            if (string.equalsIgnoreCase(String.valueOf(loc.getWorld().getName()) + " " + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isRandomTpGroups(final Location loc) {
        final List<String> randoms = this.randomsGroup;
        for (final String string : randoms) {
            if (string.equalsIgnoreCase(String.valueOf(loc.getWorld().getName()) + " " + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ())) {
                return true;
            }
        }
        return false;
    }
}
