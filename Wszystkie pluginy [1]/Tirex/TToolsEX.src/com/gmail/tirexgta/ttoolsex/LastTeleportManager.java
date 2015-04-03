/*  1:   */ package com.gmail.tirexgta.ttoolsex;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import org.bukkit.configuration.file.FileConfiguration;
/*  6:   */ import org.bukkit.configuration.file.YamlConfiguration;
/*  7:   */ import org.bukkit.entity.Player;
/*  8:   */ 
/*  9:   */ public class LastTeleportManager
/* 10:   */ {
/* 11:   */   Main plugin;
/* 12:   */   FileConfiguration data;
/* 13:   */   
/* 14:   */   public LastTeleportManager(Main plugin)
/* 15:   */   {
/* 16:16 */     this.plugin = plugin;
/* 17:17 */     this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "last_teleport.yml"));
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void saveData()
/* 21:   */   {
/* 22:   */     try
/* 23:   */     {
/* 24:24 */       this.data.save(new File(this.plugin.getDataFolder(), "last_teleport.yml"));
/* 25:   */     }
/* 26:   */     catch (Exception e)
/* 27:   */     {
/* 28:26 */       System.out.println("Wystapil blad podczas zapisu pliku last_teleport.yml");
/* 29:   */     }
/* 30:   */   }
/* 31:   */   
/* 32:   */   public Long getPlayerLastTeleport(Player player)
/* 33:   */   {
/* 34:32 */     Long time = Long.valueOf(0L);
/* 35:33 */     if (this.data.isLong("data." + player.getName())) {
/* 36:35 */       time = Long.valueOf(this.data.getLong("data." + player.getName()));
/* 37:   */     }
/* 38:37 */     return time;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setPlayerLastTeleport(Player player, Long time)
/* 42:   */   {
/* 43:42 */     this.data.set("data." + player.getName(), time);
/* 44:43 */     saveData();
/* 45:   */   }
/* 46:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.LastTeleportManager
 * JD-Core Version:    0.7.0.1
 */