package com.gmail.tirexgta.ttntex;

import org.bukkit.configuration.file.*;

public class ConfigManager
{
    Main plugin;
    public double chanceWater;
    public double chanceLava;
    public double chanceObsidian;
    public int radius;
    private FileConfiguration config;
    
    public ConfigManager(final Main plugin) {
        super();
        this.plugin = plugin;
        this.config = this.plugin.getConfig();
        this.getConfig().options().copyDefaults(true);
        this.plugin.saveConfig();
        this.load();
    }
    
    public void load() {
        this.chanceWater = this.getConfig().getDouble("config.chance.water");
        this.chanceLava = this.getConfig().getDouble("config.chance.lava");
        this.chanceObsidian = this.getConfig().getDouble("config.chance.obsidian");
        this.radius = this.getConfig().getInt("config.radius");
    }
    
    public FileConfiguration getConfig() {
        return this.config;
    }
}
