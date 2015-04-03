/*   1:    */ package com.gmail.tirexgta.ttoolsex.others;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import java.util.List;
/*   5:    */ import org.bukkit.configuration.file.FileConfiguration;
/*   6:    */ import org.bukkit.configuration.file.FileConfigurationOptions;
/*   7:    */ 
/*   8:    */ public class Config
/*   9:    */ {
/*  10:    */   public Main plugin;
/*  11:    */   public static FileConfiguration config;
/*  12:    */   public int autoSaveDelay;
/*  13:    */   public List<String> autoMessageMessages;
/*  14:    */   public int autoMessageDelay;
/*  15:    */   public String autoMessagePrefix;
/*  16:    */   public int slotManagerSlots;
/*  17:    */   public String slotManagerMotd;
/*  18:    */   public List<String> helpMessages;
/*  19:    */   public int teleportDelay;
/*  20:    */   public int teleportSpawnCooldown;
/*  21:    */   public boolean silentJoinLeave;
/*  22:    */   public List<String> welcomeMessage;
/*  23:    */   public String mysqlHost;
/*  24:    */   public String mysqlUser;
/*  25:    */   public String mysqlPass;
/*  26:    */   public String mysqlDb;
/*  27:    */   public int randomMin;
/*  28:    */   public int randomMax;
/*  29:    */   public int randomGroupRadius;
/*  30:    */   
/*  31:    */   public Config(Main plugin)
/*  32:    */   {
/*  33: 44 */     this.plugin = plugin;
/*  34: 45 */     this.plugin.getConfig().options().copyDefaults(true);
/*  35: 46 */     this.plugin.saveConfig();
/*  36: 47 */     load();
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void load()
/*  40:    */   {
/*  41: 52 */     this.autoSaveDelay = this.plugin.getConfig().getInt("config.auto-save.delay");
/*  42:    */     
/*  43: 54 */     this.autoMessageMessages = this.plugin.getConfig().getStringList("config.automessage.messages");
/*  44: 55 */     this.autoMessageDelay = this.plugin.getConfig().getInt("config.automessage.delay");
/*  45: 56 */     this.autoMessagePrefix = this.plugin.getConfig().getString("config.automessage.prefix");
/*  46:    */     
/*  47: 58 */     this.slotManagerSlots = this.plugin.getConfig().getInt("config.slotmanager.slots");
/*  48: 59 */     this.slotManagerMotd = this.plugin.getConfig().getString("config.slotmanager.motd");
/*  49:    */     
/*  50: 61 */     this.helpMessages = this.plugin.getConfig().getStringList("config.helpMessages");
/*  51: 62 */     this.teleportDelay = this.plugin.getConfig().getInt("config.teleport.delay");
/*  52: 63 */     this.teleportSpawnCooldown = this.plugin.getConfig().getInt("config.teleport.spawn.cooldown");
/*  53: 64 */     this.silentJoinLeave = this.plugin.getConfig().getBoolean("config.silentjoinleave");
/*  54: 65 */     this.welcomeMessage = this.plugin.getConfig().getStringList("config.welcomemessage");
/*  55:    */     
/*  56: 67 */     this.mysqlHost = this.plugin.getConfig().getString("MySQL.Host");
/*  57: 68 */     this.mysqlUser = this.plugin.getConfig().getString("MySQL.Username");
/*  58: 69 */     this.mysqlPass = this.plugin.getConfig().getString("MySQL.Password");
/*  59: 70 */     this.mysqlDb = this.plugin.getConfig().getString("MySQL.Database");
/*  60:    */     
/*  61: 72 */     this.randomMin = this.plugin.getConfig().getInt("config.randomtp.min");
/*  62: 73 */     this.randomMax = this.plugin.getConfig().getInt("config.randomtp.max");
/*  63: 74 */     this.randomGroupRadius = this.plugin.getConfig().getInt("config.randomtp.groups.radius");
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void save()
/*  67:    */   {
/*  68: 79 */     this.plugin.getConfig().set("config.auto-save.delay", Integer.valueOf(this.autoSaveDelay));
/*  69: 80 */     this.plugin.getConfig().set("config.automessage.messages", this.autoMessageMessages);
/*  70: 81 */     this.plugin.getConfig().set("config.automessage.delay", Integer.valueOf(this.autoMessageDelay));
/*  71: 82 */     this.plugin.getConfig().set("config.automessage.prefix", this.autoMessagePrefix);
/*  72: 83 */     this.plugin.getConfig().set("config.slotmanager.slots", Integer.valueOf(this.slotManagerSlots));
/*  73: 84 */     this.plugin.getConfig().set("config.slotmanager.motd", this.slotManagerMotd);
/*  74: 85 */     this.plugin.getConfig().set("config.helpMessages", this.helpMessages);
/*  75: 86 */     this.plugin.getConfig().set("config.teleport.delay", Integer.valueOf(this.teleportDelay));
/*  76: 87 */     this.plugin.getConfig().set("config.teleport.spawn.cooldown", Integer.valueOf(this.teleportSpawnCooldown));
/*  77: 88 */     this.plugin.getConfig().set("config.silentjoinleave", Boolean.valueOf(this.silentJoinLeave));
/*  78: 89 */     this.plugin.getConfig().set("config.welcomemessage", this.welcomeMessage);
/*  79: 90 */     this.plugin.getConfig().set("MySQL.Host", this.mysqlHost);
/*  80: 91 */     this.plugin.getConfig().set("MySQL.Username", this.mysqlUser);
/*  81: 92 */     this.plugin.getConfig().set("MySQL.Password", this.mysqlPass);
/*  82: 93 */     this.plugin.getConfig().set("MySQL.Database", this.mysqlDb);
/*  83: 94 */     this.plugin.getConfig().set("config.randomtp.min", Integer.valueOf(this.randomMin));
/*  84: 95 */     this.plugin.getConfig().set("config.randomtp.max", Integer.valueOf(this.randomMax));
/*  85: 96 */     this.plugin.getConfig().set("config.randomtp.groups.radius", Integer.valueOf(this.randomGroupRadius));
/*  86: 97 */     this.plugin.saveConfig();
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void reload()
/*  90:    */   {
/*  91:102 */     load();
/*  92:    */   }
/*  93:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.others.Config
 * JD-Core Version:    0.7.0.1
 */