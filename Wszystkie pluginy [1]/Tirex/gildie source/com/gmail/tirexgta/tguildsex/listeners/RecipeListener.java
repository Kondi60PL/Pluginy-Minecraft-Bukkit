package com.gmail.tirexgta.tguildsex.listeners;

import org.bukkit.event.*;
import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;

public class RecipeListener implements Listener
{
    Main plugin;
    
    public RecipeListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
}
