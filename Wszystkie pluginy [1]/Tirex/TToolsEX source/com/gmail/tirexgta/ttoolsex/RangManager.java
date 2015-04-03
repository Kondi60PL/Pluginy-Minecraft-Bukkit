package com.gmail.tirexgta.ttoolsex;

import java.io.*;
import org.bukkit.configuration.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class RangManager
{
    Main plugin;
    FileConfiguration data;
    public List<OfflinePlayer> playerByList;
    public HashMap<OfflinePlayer, String> rangaNazwa;
    public HashMap<OfflinePlayer, Long> rangaCzas;
    
    public RangManager(final Main plugin) {
        super();
        this.playerByList = new ArrayList<OfflinePlayer>();
        this.rangaNazwa = new HashMap<OfflinePlayer, String>();
        this.rangaCzas = new HashMap<OfflinePlayer, Long>();
        this.plugin = plugin;
        this.data = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "rang.yml"));
        this.getPlayers();
        for (final OfflinePlayer player : this.playerByList) {
            this.rangaNazwa.put(player, this.getRangaNazwa(player));
            this.rangaCzas.put(player, this.getRangaCzas(player));
        }
        this.setupConfig();
    }
    
    public void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "rang.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku rang.yml");
        }
    }
    
    public void setupConfig() {
        if (!this.data.isConfigurationSection("rangi")) {
            this.data.createSection("rangi");
            this.saveData();
        }
        if (!this.data.isList("players")) {
            this.data.createSection("players");
            System.out.print("cos");
            this.saveData();
        }
    }
    
    public void getPlayers() {
        if (this.data.isList("players")) {
            final List<String> listByPlayers = (List<String>)this.data.getStringList("players");
            for (final String player : listByPlayers) {
                this.playerByList.add(Bukkit.getOfflinePlayer(player));
            }
        }
    }
    
    public String getRangaNazwa(final OfflinePlayer player) {
        String rangaString = "";
        if (this.data.getString("rangi." + player.getName() + ".nazwa") != null) {
            rangaString = this.data.getString("rangi." + player.getName() + ".nazwa");
        }
        return rangaString;
    }
    
    public long getRangaCzas(final OfflinePlayer player) {
        long rangaInt = 0L;
        if (this.data.getString("rangi." + player.getName() + ".czas") != null) {
            rangaInt = this.data.getLong("rangi." + player.getName() + ".czas");
        }
        return rangaInt;
    }
    
    public void removeRang(final Player player) {
        if (!this.data.isString("rangi." + player.getName())) {
            this.data.set("rangi." + player.getName() + ".nazwa", (Object)"");
        }
        if (!this.data.isLong("rangi." + player.getName())) {
            this.data.set("rangi." + player.getName() + ".czas", (Object)0);
        }
        this.data.set("rangi." + player.getName() + ".nazwa", (Object)null);
        this.data.set("rangi." + player.getName() + ".czas", (Object)null);
        final List<String> rangiList = (List<String>)this.data.getStringList("players." + player.getName());
        rangiList.remove(player.getName());
        this.data.set("players", (Object)rangiList);
        if (this.rangaNazwa.containsKey(player)) {
            this.rangaNazwa.remove(player);
        }
        if (this.rangaCzas.containsKey(player)) {
            this.rangaCzas.remove(player);
        }
        if (this.playerByList.contains(player)) {
            this.playerByList.remove(player);
        }
        this.saveData();
    }
    
    public void addRang(final Player p, final String ranga, final long czas) {
        if (!this.data.isString("rangi." + p.getName() + ".nazwa")) {
            this.data.set("rangi." + p.getName() + ".nazwa", (Object)"");
        }
        if (!this.data.isDouble("rangi." + p.getName() + ".czas")) {
            this.data.set("rangi." + p.getName() + ".czas", (Object)0);
        }
        this.data.set("rangi." + p.getName() + ".nazwa", (Object)ranga);
        this.data.set("rangi." + p.getName() + ".czas", (Object)czas);
        final OfflinePlayer player = this.plugin.getServer().getOfflinePlayer(p.getName());
        final List<String> rangiList = (List<String>)this.data.getStringList("players." + p.getName());
        rangiList.add(p.getName());
        this.data.set("players", (Object)rangiList);
        if (this.rangaCzas.containsKey(player)) {
            this.rangaCzas.remove(player);
        }
        if (this.rangaNazwa.containsKey(player)) {
            this.rangaNazwa.remove(player);
        }
        if (this.playerByList.contains(player)) {
            this.playerByList.remove(player);
        }
        this.rangaNazwa.put(player, ranga);
        this.rangaCzas.put(player, czas);
        this.playerByList.add(player);
        this.saveData();
    }
}
