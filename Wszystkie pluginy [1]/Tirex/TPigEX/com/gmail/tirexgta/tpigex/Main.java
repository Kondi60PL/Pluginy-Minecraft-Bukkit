package com.gmail.tirexgta.tpigex;

import org.bukkit.plugin.java.*;
import com.gmail.tirexgta.tpigex.commands.*;
import java.util.*;
import com.gmail.tirexgta.tpigex.listeners.*;
import org.bukkit.command.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import java.lang.reflect.*;

public class Main extends JavaPlugin
{
    private static Main instance;
    private CommandMap cm;
    public ConfigManager configManager;
    PigCommand pigCommand;
    
    public void onEnable() {
        Main.instance = this;
        this.configManager = new ConfigManager();
        new PigCommand("pig", "", "", new ArrayList<String>());
        new SpawnPigListener();
    }
    
    public void onDisable() {
        this.configManager.save();
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
    
    public Command registerCommand(final Command cmd) {
        if (this.cm == null) {
            this.cm = this.getCommandMap();
        }
        this.cm.register("k", cmd);
        return this.cm.getCommand(cmd.getName());
    }
    
    private CommandMap getCommandMap() {
        try {
            final Field field = SimplePluginManager.class.getDeclaredField("commandMap");
            field.setAccessible(true);
            return (CommandMap)field.get(Bukkit.getServer().getPluginManager());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean isInt(final String s) {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
