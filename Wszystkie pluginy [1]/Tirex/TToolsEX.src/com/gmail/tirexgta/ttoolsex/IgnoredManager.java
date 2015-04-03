/*  1:   */ package com.gmail.tirexgta.ttoolsex;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.ArrayList;
/*  6:   */ import java.util.List;
/*  7:   */ import org.bukkit.Bukkit;
/*  8:   */ import org.bukkit.OfflinePlayer;
/*  9:   */ import org.bukkit.configuration.file.FileConfiguration;
/* 10:   */ import org.bukkit.configuration.file.YamlConfiguration;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ 
/* 13:   */ public class IgnoredManager
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:   */   FileConfiguration data;
/* 17:   */   
/* 18:   */   public IgnoredManager(Main plugin)
/* 19:   */   {
/* 20:20 */     this.plugin = plugin;
/* 21:21 */     this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "ignored.yml"));
/* 22:22 */     setupConfig();
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void saveData()
/* 26:   */   {
/* 27:   */     try
/* 28:   */     {
/* 29:29 */       this.data.save(new File(this.plugin.getDataFolder(), "ignored.yml"));
/* 30:   */     }
/* 31:   */     catch (Exception e)
/* 32:   */     {
/* 33:31 */       System.out.println("Wystapil blad podczas zapisu pliku ignored.yml");
/* 34:   */     }
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setupConfig()
/* 38:   */   {
/* 39:37 */     if (!this.data.isConfigurationSection("ignored"))
/* 40:   */     {
/* 41:39 */       this.data.createSection("ignored");
/* 42:40 */       saveData();
/* 43:   */     }
/* 44:   */   }
/* 45:   */   
/* 46:   */   public boolean isIgnoredByPlayer(Player player, OfflinePlayer ignored)
/* 47:   */   {
/* 48:46 */     return getIgnored(player).contains(ignored);
/* 49:   */   }
/* 50:   */   
/* 51:   */   public List<OfflinePlayer> getIgnored(Player player)
/* 52:   */   {
/* 53:52 */     List<OfflinePlayer> ignored = new ArrayList();
/* 54:53 */     if (this.data.getStringList("ignored." + player.getName()) != null)
/* 55:   */     {
/* 56:55 */       List<String> ignoredStringList = this.data.getStringList("ignored." + player.getName());
/* 57:56 */       for (String ignoredNickName : ignoredStringList) {
/* 58:58 */         ignored.add(Bukkit.getOfflinePlayer(ignoredNickName));
/* 59:   */       }
/* 60:   */     }
/* 61:61 */     return ignored;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void removeIgnored(Player player, OfflinePlayer ignored)
/* 65:   */   {
/* 66:66 */     if (!this.data.isList("ignored." + player.getName())) {
/* 67:68 */       this.data.set("ignored." + player.getName(), new ArrayList());
/* 68:   */     }
/* 69:70 */     List<String> ignoredList = this.data.getStringList("ignored." + player.getName());
/* 70:71 */     ignoredList.remove(ignored.getName());
/* 71:72 */     this.data.set("ignored." + player.getName(), ignoredList);
/* 72:73 */     saveData();
/* 73:   */   }
/* 74:   */   
/* 75:   */   public void addIgnored(Player player, OfflinePlayer ignored)
/* 76:   */   {
/* 77:78 */     if (!this.data.isList("ignored." + player.getName())) {
/* 78:80 */       this.data.set("ignored." + player.getName(), new ArrayList());
/* 79:   */     }
/* 80:82 */     List<String> ignoredList = this.data.getStringList("ignored." + player.getName());
/* 81:83 */     ignoredList.add(ignored.getName());
/* 82:84 */     this.data.set("ignored." + player.getName(), ignoredList);
/* 83:85 */     saveData();
/* 84:   */   }
/* 85:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.IgnoredManager
 * JD-Core Version:    0.7.0.1
 */