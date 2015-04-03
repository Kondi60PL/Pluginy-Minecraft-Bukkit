package com.gmail.tirexgta.ttntex;

import org.bukkit.plugin.java.*;
import com.gmail.tirexgta.ttntex.listeners.*;

public class Main extends JavaPlugin
{
    Main plugin;
    static Main plugiN;
    private ConfigManager configManager;
    ExplodeListener explodeListener;
    
    public void onEnable() {
        this.plugin = this;
        Main.plugiN = this.plugin;
        this.configManager = new ConfigManager(this);
        this.explodeListener = new ExplodeListener(this);
    }
    
    public void onDisable() {
    }
    
    public ConfigManager getConfigManager() {
        return this.configManager;
    }
}
