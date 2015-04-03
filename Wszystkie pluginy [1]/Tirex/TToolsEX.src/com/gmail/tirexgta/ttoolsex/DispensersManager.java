/*  1:   */ package com.gmail.tirexgta.ttoolsex;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.ArrayList;
/*  6:   */ import java.util.List;
/*  7:   */ import org.bukkit.Location;
/*  8:   */ import org.bukkit.World;
/*  9:   */ import org.bukkit.configuration.file.YamlConfiguration;
/* 10:   */ 
/* 11:   */ public class DispensersManager
/* 12:   */ {
/* 13:   */   Main plugin;
/* 14:   */   YamlConfiguration data;
/* 15:   */   
/* 16:   */   public DispensersManager(Main plugin)
/* 17:   */   {
/* 18:17 */     this.plugin = plugin;
/* 19:18 */     this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "dispensers.yml"));
/* 20:19 */     setupConfig();
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void saveData()
/* 24:   */   {
/* 25:   */     try
/* 26:   */     {
/* 27:25 */       this.data.save(new File(this.plugin.getDataFolder(), "dispensers.yml"));
/* 28:   */     }
/* 29:   */     catch (Exception e)
/* 30:   */     {
/* 31:27 */       System.out.println("Wystapil blad podczas zapisu pliku dispensers.yml");
/* 32:   */     }
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void setupConfig()
/* 36:   */   {
/* 37:32 */     if (!this.data.isConfigurationSection("data"))
/* 38:   */     {
/* 39:34 */       this.data.createSection("data");
/* 40:35 */       List<String> dispensers = new ArrayList();
/* 41:36 */       this.data.set("data.dispensers", dispensers);
/* 42:37 */       saveData();
/* 43:   */     }
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void addDispenser(Location location)
/* 47:   */   {
/* 48:43 */     List<String> dispensers = this.data.getStringList("data.dispensers");
/* 49:44 */     dispensers.add(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/* 50:45 */     this.data.set("data.dispensers", dispensers);
/* 51:46 */     saveData();
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void delDispenser(Location location)
/* 55:   */   {
/* 56:51 */     List<String> dispensers = this.data.getStringList("data.dispensers");
/* 57:52 */     dispensers.remove(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
/* 58:53 */     this.data.set("data.dispensers", dispensers);
/* 59:54 */     saveData();
/* 60:   */   }
/* 61:   */   
/* 62:   */   public boolean isUnlimitedDispenser(Location location)
/* 63:   */   {
/* 64:59 */     List<String> dispensers = this.data.getStringList("data.dispensers");
/* 65:60 */     for (String string : dispensers) {
/* 66:62 */       if (string.equalsIgnoreCase(location.getWorld().getName() + " " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ())) {
/* 67:64 */         return true;
/* 68:   */       }
/* 69:   */     }
/* 70:67 */     return false;
/* 71:   */   }
/* 72:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.DispensersManager
 * JD-Core Version:    0.7.0.1
 */