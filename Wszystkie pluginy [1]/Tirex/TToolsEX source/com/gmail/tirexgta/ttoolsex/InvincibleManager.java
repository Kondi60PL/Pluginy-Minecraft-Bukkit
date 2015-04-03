package com.gmail.tirexgta.ttoolsex;

import org.bukkit.configuration.file.*;
import java.util.*;
import java.io.*;
import org.bukkit.entity.*;

public class InvincibleManager
{
    Main plugin;
    YamlConfiguration data;
    List<Integer> entities;
    List<Player> inCommand;
    
    public InvincibleManager(final Main plugin) {
        super();
        this.inCommand = new ArrayList<Player>();
        this.plugin = plugin;
        this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "invincibles.yml"));
        if (this.data.isList("invincibles")) {
            this.entities = (List<Integer>)this.data.getIntegerList("invincibles");
        }
        else {
            this.entities = new ArrayList<Integer>();
        }
    }
    
    public void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "invincibles.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku invincibles.yml");
        }
    }
    
    public boolean isInvincible(final Entity entity) {
        return this.entities.contains(entity.getEntityId());
    }
    
    public void setInvincible(final Entity entity, final boolean flag) {
        if (flag) {
            if (!this.entities.contains(entity.getEntityId())) {
                this.entities.add(entity.getEntityId());
            }
        }
        else {
            this.entities.remove(this.entities.indexOf(entity.getEntityId()));
        }
        this.saveData();
    }
    
    public boolean isInCommand(final Player player) {
        return this.inCommand.contains(player);
    }
    
    public void setInCommand(final Player player, final boolean flag) {
        if (flag) {
            if (!this.inCommand.contains(player)) {
                this.inCommand.add(player);
            }
        }
        else {
            this.inCommand.remove(player);
        }
    }
}
