package com.gmail.tirexgta.tguildsex;

import java.util.*;
import org.bukkit.configuration.file.*;
import java.io.*;

public class TabManager
{
    Main plugin;
    File file;
    FileConfiguration data;
    public List<String> tab;
    public String time;
    public String kills;
    public String deaths;
    public String points;
    public String nick;
    public String guildTag;
    public String guildKills;
    public String guildDeaths;
    public String guildPoints;
    public String topGuild;
    public String topPlayer;
    public String noneTopGuild;
    public String noneTopPlayer;
    
    public TabManager(final Main plugin) {
        super();
        this.plugin = plugin;
        this.file = new File(this.plugin.getDataFolder(), "tab.yml");
        if (!this.file.exists()) {
            this.copy(this.plugin.getResource("tab.yml"), this.file);
        }
        this.data = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
        this.save();
        this.load();
    }
    
    void load() {
        this.tab = (List<String>)this.data.getStringList("tab");
        this.time = this.data.getString("variables.time");
        this.kills = this.data.getString("variables.kills");
        this.deaths = this.data.getString("variables.deaths");
        this.points = this.data.getString("variables.points");
        this.nick = this.data.getString("variables.nick");
        this.guildTag = this.data.getString("variables.guildTag");
        this.guildKills = this.data.getString("variables.guildKills");
        this.guildDeaths = this.data.getString("variables.guildDeaths");
        this.guildPoints = this.data.getString("variables.guildPoints");
        this.topGuild = this.data.getString("variables.topGuild");
        this.topPlayer = this.data.getString("variables.topPlayer");
        this.noneTopGuild = this.data.getString("variables.noneTopGuild");
        this.noneTopPlayer = this.data.getString("variables.noneTopPlayer");
    }
    
    void save() {
        this.saveData();
    }
    
    void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "tab.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku tab.yml");
        }
    }
    
    void copy(final InputStream in, final File file) {
        try {
            copyy(in, file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void copyy(final InputStream in, final File file) throws IOException {
        final OutputStream out = new FileOutputStream(file);
        final byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.close();
        in.close();
    }
}
