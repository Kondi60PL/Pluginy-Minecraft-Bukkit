package com.gmail.tirexgta.tguildsex;

import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;

public class ConfigManager
{
    Main plugin;
    public String mysqlHost;
    public String mysqlUser;
    public String mysqlPass;
    public String mysqlDb;
    public List<ItemStack> guildCreateItems;
    public String guildCreateWorld;
    public int guildCreateSpawn;
    public int guildCreateGuild;
    public int guildCreatePromien;
    public int guildMaxPlayersMin;
    public int guildMaxPlayersMax;
    public int guildMaxPlayersResizeUp;
    public int guildTeleportDelay;
    public int guildCostJoinDiamond;
    public int guildSojuszMax;
    public int guildSojuszCostGold;
    public int guildExplodeTime;
    public List<ItemStack> guildSetLider;
    public int userStartPoints;
    public String tagFormat;
    
    public ConfigManager(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getConfig().options().copyDefaults(true);
        this.plugin.saveConfig();
        this.load();
    }
    
    public void load() {
        this.mysqlHost = this.plugin.getConfig().getString("MySQL.Host");
        this.mysqlUser = this.plugin.getConfig().getString("MySQL.Username");
        this.mysqlPass = this.plugin.getConfig().getString("MySQL.Password");
        this.mysqlDb = this.plugin.getConfig().getString("MySQL.Database");
        this.guildCreateItems = this.getCreateItem(this.plugin.getConfig().getStringList("config.guild.items"));
        this.guildCreateWorld = this.plugin.getConfig().getString("config.guild.world");
        this.guildCreateSpawn = this.plugin.getConfig().getInt("config.guild.spawn");
        this.guildCreateGuild = this.plugin.getConfig().getInt("config.guild.guild");
        this.guildCreatePromien = this.plugin.getConfig().getInt("config.guild.promien");
        this.guildMaxPlayersMin = this.plugin.getConfig().getInt("config.guild.maxPlayers.min");
        this.guildMaxPlayersMax = this.plugin.getConfig().getInt("config.guild.maxPlayers.max");
        this.guildMaxPlayersResizeUp = this.plugin.getConfig().getInt("config.guild.maxPlayers.resizeUp");
        this.guildTeleportDelay = this.plugin.getConfig().getInt("config.guild.teleport.delay");
        this.guildCostJoinDiamond = this.plugin.getConfig().getInt("config.guild.join.cost");
        this.guildSojuszMax = this.plugin.getConfig().getInt("config.guild.alliance.max");
        this.guildSojuszCostGold = this.plugin.getConfig().getInt("config.guild.alliance.cost");
        this.guildExplodeTime = this.plugin.getConfig().getInt("config.guild.explode.time");
        this.guildSetLider = this.getCreateItem(this.plugin.getConfig().getStringList("config.guild.setlider"));
        this.userStartPoints = this.plugin.getConfig().getInt("config.user.startPoints");
        this.tagFormat = this.plugin.getConfig().getString("config.tag");
    }
    
    public void save() {
        this.plugin.getConfig().set("MySQL.Host", (Object)this.mysqlHost);
        this.plugin.getConfig().set("MySQL.Username", (Object)this.mysqlUser);
        this.plugin.getConfig().set("MySQL.Password", (Object)this.mysqlPass);
        this.plugin.getConfig().set("MySQL.Database", (Object)this.mysqlDb);
        this.plugin.getConfig().set("config.guild.items", (Object)this.setCreateItem(this.guildCreateItems));
        this.plugin.getConfig().set("config.guild.world", (Object)this.guildCreateWorld);
        this.plugin.getConfig().set("config.guild.spawn", (Object)this.guildCreateSpawn);
        this.plugin.getConfig().set("config.guild.guild", (Object)this.guildCreateGuild);
        this.plugin.getConfig().set("config.guild.promien", (Object)this.guildCreatePromien);
        this.plugin.getConfig().set("config.guild.maxPlayers.min", (Object)this.guildMaxPlayersMin);
        this.plugin.getConfig().set("config.guild.maxPlayers.max", (Object)this.guildMaxPlayersMax);
        this.plugin.getConfig().set("config.guild.maxPlayers.resizeUp", (Object)this.guildMaxPlayersResizeUp);
        this.plugin.getConfig().set("config.guild.teleport.delay", (Object)this.guildMaxPlayersResizeUp);
        this.plugin.getConfig().set("config.guild.cost.join", (Object)this.guildCostJoinDiamond);
        this.plugin.getConfig().set("config.guild.alliance.max", (Object)this.guildSojuszMax);
        this.plugin.getConfig().set("config.guild.alliance.cost", (Object)this.guildSojuszCostGold);
        this.plugin.getConfig().set("config.guild.explode.time", (Object)this.guildExplodeTime);
        this.plugin.getConfig().set("config.guild.setlider", (Object)this.setCreateItem(this.guildSetLider));
        this.plugin.getConfig().set("config.user.startPoints", (Object)this.userStartPoints);
        this.plugin.saveConfig();
    }
    
    public void reload() {
        this.load();
    }
    
    public List<ItemStack> getCreateItem(final List<String> listsString) {
        final List<ItemStack> przedmioty = new ArrayList<ItemStack>();
        for (final String listString : listsString) {
            final String[] idAndDataAmount = listString.split(":");
            final String[] dataAndAmount = idAndDataAmount[1].split(" ");
            final Material material = Material.getMaterial(Integer.parseInt(idAndDataAmount[0]));
            final int amount = Integer.valueOf(dataAndAmount[1]);
            final short data = Short.valueOf(dataAndAmount[0]);
            przedmioty.add(new ItemStack(material, amount, data));
        }
        return przedmioty;
    }
    
    public List<String> setCreateItem(final List<ItemStack> listsItemStack) {
        final List<String> przedmioty = new ArrayList<String>();
        for (final ItemStack itemStack : listsItemStack) {
            final int material = itemStack.getType().getId();
            final int amount = itemStack.getAmount();
            final Short data = (Short)itemStack.getData().getData();
            przedmioty.add(String.valueOf(material) + ":" + data + "|" + amount);
        }
        return przedmioty;
    }
}
