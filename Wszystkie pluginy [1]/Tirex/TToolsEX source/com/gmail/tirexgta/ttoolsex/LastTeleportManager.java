package com.gmail.tirexgta.ttoolsex;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;

public class LastTeleportManager
{
    Main plugin;
    FileConfiguration data;
    
    public LastTeleportManager(final Main plugin) {
        super();
        this.plugin = plugin;
        this.data = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "last_teleport.yml"));
    }
    
    public void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "last_teleport.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku last_teleport.yml");
        }
    }
    
    public Long getPlayerLastTeleport(final Player player) {
        Long time = 0L;
        if (this.data.isLong("data." + player.getName())) {
            time = this.data.getLong("data." + player.getName());
        }
        return time;
    }
    
    public void setPlayerLastTeleport(final Player player, final Long time) {
        this.data.set("data." + player.getName(), (Object)time);
        this.saveData();
    }
}
