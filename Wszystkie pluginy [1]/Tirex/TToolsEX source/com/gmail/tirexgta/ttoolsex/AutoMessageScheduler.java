package com.gmail.tirexgta.ttoolsex;

import org.bukkit.*;
import org.bukkit.plugin.*;

public class AutoMessageScheduler
{
    Main plugin;
    
    public AutoMessageScheduler(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this.plugin, (Runnable)new Runnable() {
            int i = 0;
            
            @Override
            public void run() {
                if (this.i >= plugin.config.autoMessageMessages.size()) {
                    this.i = 0;
                }
                Bukkit.broadcastMessage(String.valueOf(plugin.config.autoMessagePrefix.replace("&", "§")) + " " + ChatColor.GRAY + plugin.config.autoMessageMessages.get(this.i).replace("&", "§"));
                ++this.i;
            }
        }, 20L, 20L * this.plugin.config.autoMessageDelay);
    }
}
