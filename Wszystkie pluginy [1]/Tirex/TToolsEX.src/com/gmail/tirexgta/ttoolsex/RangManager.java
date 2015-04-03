/*   1:    */ package com.gmail.tirexgta.ttoolsex;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.HashMap;
/*   7:    */ import java.util.List;
/*   8:    */ import org.bukkit.Bukkit;
/*   9:    */ import org.bukkit.OfflinePlayer;
/*  10:    */ import org.bukkit.Server;
/*  11:    */ import org.bukkit.configuration.file.FileConfiguration;
/*  12:    */ import org.bukkit.configuration.file.YamlConfiguration;
/*  13:    */ import org.bukkit.entity.Player;
/*  14:    */ 
/*  15:    */ public class RangManager
/*  16:    */ {
/*  17:    */   Main plugin;
/*  18:    */   FileConfiguration data;
/*  19: 19 */   public List<OfflinePlayer> playerByList = new ArrayList();
/*  20: 21 */   public HashMap<OfflinePlayer, String> rangaNazwa = new HashMap();
/*  21: 22 */   public HashMap<OfflinePlayer, Long> rangaCzas = new HashMap();
/*  22:    */   
/*  23:    */   public RangManager(Main plugin)
/*  24:    */   {
/*  25: 26 */     this.plugin = plugin;
/*  26: 27 */     this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "rang.yml"));
/*  27: 28 */     getPlayers();
/*  28: 29 */     for (OfflinePlayer player : this.playerByList)
/*  29:    */     {
/*  30: 31 */       this.rangaNazwa.put(player, getRangaNazwa(player));
/*  31: 32 */       this.rangaCzas.put(player, Long.valueOf(getRangaCzas(player)));
/*  32:    */     }
/*  33: 34 */     setupConfig();
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void saveData()
/*  37:    */   {
/*  38:    */     try
/*  39:    */     {
/*  40: 41 */       this.data.save(new File(this.plugin.getDataFolder(), "rang.yml"));
/*  41:    */     }
/*  42:    */     catch (Exception e)
/*  43:    */     {
/*  44: 43 */       System.out.println("Wystapil blad podczas zapisu pliku rang.yml");
/*  45:    */     }
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setupConfig()
/*  49:    */   {
/*  50: 49 */     if (!this.data.isConfigurationSection("rangi"))
/*  51:    */     {
/*  52: 51 */       this.data.createSection("rangi");
/*  53: 52 */       saveData();
/*  54:    */     }
/*  55: 54 */     if (!this.data.isList("players"))
/*  56:    */     {
/*  57: 56 */       this.data.createSection("players");
/*  58: 57 */       System.out.print("cos");
/*  59: 58 */       saveData();
/*  60:    */     }
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void getPlayers()
/*  64:    */   {
/*  65: 65 */     if (this.data.isList("players"))
/*  66:    */     {
/*  67: 67 */       List<String> listByPlayers = this.data.getStringList("players");
/*  68: 68 */       for (String player : listByPlayers) {
/*  69: 70 */         this.playerByList.add(Bukkit.getOfflinePlayer(player));
/*  70:    */       }
/*  71:    */     }
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getRangaNazwa(OfflinePlayer player)
/*  75:    */   {
/*  76: 77 */     String rangaString = "";
/*  77: 78 */     if (this.data.getString("rangi." + player.getName() + ".nazwa") != null) {
/*  78: 80 */       rangaString = this.data.getString("rangi." + player.getName() + ".nazwa");
/*  79:    */     }
/*  80: 82 */     return rangaString;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public long getRangaCzas(OfflinePlayer player)
/*  84:    */   {
/*  85: 87 */     long rangaInt = 0L;
/*  86: 88 */     if (this.data.getString("rangi." + player.getName() + ".czas") != null) {
/*  87: 90 */       rangaInt = this.data.getLong("rangi." + player.getName() + ".czas");
/*  88:    */     }
/*  89: 92 */     return rangaInt;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void removeRang(Player player)
/*  93:    */   {
/*  94: 97 */     if (!this.data.isString("rangi." + player.getName())) {
/*  95: 99 */       this.data.set("rangi." + player.getName() + ".nazwa", "");
/*  96:    */     }
/*  97:101 */     if (!this.data.isLong("rangi." + player.getName())) {
/*  98:103 */       this.data.set("rangi." + player.getName() + ".czas", Integer.valueOf(0));
/*  99:    */     }
/* 100:105 */     this.data.set("rangi." + player.getName() + ".nazwa", null);
/* 101:106 */     this.data.set("rangi." + player.getName() + ".czas", null);
/* 102:    */     
/* 103:108 */     List<String> rangiList = this.data.getStringList("players." + player.getName());
/* 104:109 */     rangiList.remove(player.getName());
/* 105:110 */     this.data.set("players", rangiList);
/* 106:112 */     if (this.rangaNazwa.containsKey(player)) {
/* 107:114 */       this.rangaNazwa.remove(player);
/* 108:    */     }
/* 109:116 */     if (this.rangaCzas.containsKey(player)) {
/* 110:118 */       this.rangaCzas.remove(player);
/* 111:    */     }
/* 112:120 */     if (this.playerByList.contains(player)) {
/* 113:122 */       this.playerByList.remove(player);
/* 114:    */     }
/* 115:124 */     saveData();
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void addRang(Player p, String ranga, long czas)
/* 119:    */   {
/* 120:130 */     if (!this.data.isString("rangi." + p.getName() + ".nazwa")) {
/* 121:132 */       this.data.set("rangi." + p.getName() + ".nazwa", "");
/* 122:    */     }
/* 123:134 */     if (!this.data.isDouble("rangi." + p.getName() + ".czas")) {
/* 124:136 */       this.data.set("rangi." + p.getName() + ".czas", Integer.valueOf(0));
/* 125:    */     }
/* 126:138 */     this.data.set("rangi." + p.getName() + ".nazwa", ranga);
/* 127:139 */     this.data.set("rangi." + p.getName() + ".czas", Long.valueOf(czas));
/* 128:    */     
/* 129:141 */     OfflinePlayer player = this.plugin.getServer().getOfflinePlayer(p.getName());
/* 130:142 */     List<String> rangiList = this.data.getStringList("players." + p.getName());
/* 131:143 */     rangiList.add(p.getName());
/* 132:144 */     this.data.set("players", rangiList);
/* 133:146 */     if (this.rangaCzas.containsKey(player)) {
/* 134:148 */       this.rangaCzas.remove(player);
/* 135:    */     }
/* 136:150 */     if (this.rangaNazwa.containsKey(player)) {
/* 137:152 */       this.rangaNazwa.remove(player);
/* 138:    */     }
/* 139:154 */     if (this.playerByList.contains(player)) {
/* 140:156 */       this.playerByList.remove(player);
/* 141:    */     }
/* 142:158 */     this.rangaNazwa.put(player, ranga);
/* 143:159 */     this.rangaCzas.put(player, Long.valueOf(czas));
/* 144:160 */     this.playerByList.add(player);
/* 145:161 */     saveData();
/* 146:    */   }
/* 147:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.RangManager
 * JD-Core Version:    0.7.0.1
 */