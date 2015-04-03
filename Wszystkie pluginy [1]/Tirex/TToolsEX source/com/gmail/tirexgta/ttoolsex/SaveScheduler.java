package com.gmail.tirexgta.ttoolsex;

import org.bukkit.plugin.*;

public class SaveScheduler
{
    Main plugin;
    
    public SaveScheduler(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                plugin.saveMap();
            }
        }, 20L * this.plugin.config.autoSaveDelay, 20L * this.plugin.config.autoSaveDelay);
    }
}
