/*   1:    */ package com.gmail.tirexgta.ttoolsex;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.List;
/*   7:    */ import org.bukkit.Location;
/*   8:    */ import org.bukkit.World;
/*   9:    */ import org.bukkit.configuration.file.YamlConfiguration;
/*  10:    */ 
/*  11:    */ public class RandomTeleportManager
/*  12:    */ {
/*  13:    */   Main plugin;
/*  14:    */   YamlConfiguration data;
/*  15: 15 */   List<String> randoms = new ArrayList();
/*  16: 16 */   List<String> randomsGroup = new ArrayList();
/*  17:    */   
/*  18:    */   public RandomTeleportManager(Main plugin)
/*  19:    */   {
/*  20: 20 */     this.plugin = plugin;
/*  21: 21 */     this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "randomtp.yml"));
/*  22: 22 */     setupConfig();
/*  23: 23 */     getRandomsTp();
/*  24: 24 */     getRandomsTpGroups();
/*  25:    */   }
/*  26:    */   
/*  27:    */   public void saveData()
/*  28:    */   {
/*  29:    */     try
/*  30:    */     {
/*  31: 30 */       this.data.save(new File(this.plugin.getDataFolder(), "randomtp.yml"));
/*  32:    */     }
/*  33:    */     catch (Exception e)
/*  34:    */     {
/*  35: 32 */       System.out.println("Wystapil blad podczas zapisu pliku randomtp.yml");
/*  36:    */     }
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setupConfig()
/*  40:    */   {
/*  41: 38 */     if (!this.data.isConfigurationSection("data"))
/*  42:    */     {
/*  43: 40 */       this.data.createSection("data");
/*  44: 41 */       List<String> dispensers = new ArrayList();
/*  45: 42 */       this.data.set("data.randomtp", dispensers);
/*  46: 43 */       this.data.set("data.randomtpGroups", dispensers);
/*  47: 44 */       saveData();
/*  48:    */     }
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void addRandomTp(Location location)
/*  52:    */   {
/*  53: 50 */     List<String> dispensers = this.data.getStringList("data.randomtp");
/*  54: 51 */     dispensers.add(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/*  55: 52 */     this.data.set("data.randomtp", dispensers);
/*  56: 53 */     this.randoms.add(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/*  57: 54 */     saveData();
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void delRandomTp(Location location)
/*  61:    */   {
/*  62: 59 */     List<String> dispensers = this.data.getStringList("data.randomtp");
/*  63: 60 */     dispensers.remove(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/*  64: 61 */     this.data.set("data.randomtp", dispensers);
/*  65: 62 */     this.randoms.remove(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/*  66: 63 */     saveData();
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void addRandomTpGroups(Location location)
/*  70:    */   {
/*  71: 68 */     List<String> dispensers = this.data.getStringList("data.randomtpGroups");
/*  72: 69 */     dispensers.add(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/*  73: 70 */     this.data.set("data.randomtpGroups", dispensers);
/*  74: 71 */     this.randomsGroup.add(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/*  75: 72 */     saveData();
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void delRandomTpGroups(Location location)
/*  79:    */   {
/*  80: 77 */     List<String> dispensers = this.data.getStringList("data.randomtpGroups");
/*  81: 78 */     dispensers.remove(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/*  82: 79 */     this.data.set("data.randomtpGroups", dispensers);
/*  83: 80 */     this.randomsGroup.remove(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/*  84: 81 */     saveData();
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void getRandomsTp()
/*  88:    */   {
/*  89: 86 */     List<String> randoms = this.data.getStringList("data.randomtp");
/*  90: 87 */     for (String string : randoms) {
/*  91: 89 */       this.randoms.add(string);
/*  92:    */     }
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void getRandomsTpGroups()
/*  96:    */   {
/*  97: 95 */     List<String> randoms = this.data.getStringList("data.randomtpGroups");
/*  98: 96 */     for (String string : randoms) {
/*  99: 98 */       this.randomsGroup.add(string);
/* 100:    */     }
/* 101:    */   }
/* 102:    */   
/* 103:    */   public boolean isRandomTp(Location loc)
/* 104:    */   {
/* 105:104 */     List<String> randoms = this.randoms;
/* 106:105 */     for (String string : randoms) {
/* 107:107 */       if (string.equalsIgnoreCase(loc.getWorld().getName() + " " + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ())) {
/* 108:109 */         return true;
/* 109:    */       }
/* 110:    */     }
/* 111:112 */     return false;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public boolean isRandomTpGroups(Location loc)
/* 115:    */   {
/* 116:117 */     List<String> randoms = this.randomsGroup;
/* 117:118 */     for (String string : randoms) {
/* 118:120 */       if (string.equalsIgnoreCase(loc.getWorld().getName() + " " + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ())) {
/* 119:122 */         return true;
/* 120:    */       }
/* 121:    */     }
/* 122:125 */     return false;
/* 123:    */   }
/* 124:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.RandomTeleportManager
 * JD-Core Version:    0.7.0.1
 */