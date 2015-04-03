/*   1:    */ package com.gmail.tirexgta.ttoolsex;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.HashMap;
/*   7:    */ import java.util.List;
/*   8:    */ import org.bukkit.Bukkit;
/*   9:    */ import org.bukkit.OfflinePlayer;
/*  10:    */ import org.bukkit.World;
/*  11:    */ import org.bukkit.configuration.file.FileConfiguration;
/*  12:    */ import org.bukkit.configuration.file.YamlConfiguration;
/*  13:    */ import org.bukkit.entity.Player;
/*  14:    */ import org.bukkit.inventory.Inventory;
/*  15:    */ import org.bukkit.inventory.ItemStack;
/*  16:    */ 
/*  17:    */ public class BackpackManager
/*  18:    */ {
/*  19:    */   Main plugin;
/*  20:    */   FileConfiguration data;
/*  21: 21 */   public List<OfflinePlayer> playerByList = new ArrayList();
/*  22: 23 */   public HashMap<OfflinePlayer, List<ItemStack>> backpackItems = new HashMap();
/*  23:    */   
/*  24:    */   public BackpackManager(Main plugin)
/*  25:    */   {
/*  26: 27 */     this.plugin = plugin;
/*  27: 28 */     this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "backpack.yml"));
/*  28: 30 */     for (OfflinePlayer player : getPlayers()) {
/*  29: 32 */       this.playerByList.add(player);
/*  30:    */     }
/*  31: 34 */     for (OfflinePlayer player : this.playerByList) {
/*  32: 36 */       this.backpackItems.put(player, getBackpack(player));
/*  33:    */     }
/*  34: 38 */     setupConfig();
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void saveData()
/*  38:    */   {
/*  39:    */     try
/*  40:    */     {
/*  41: 45 */       this.data.save(new File(this.plugin.getDataFolder(), "backpack.yml"));
/*  42:    */     }
/*  43:    */     catch (Exception e)
/*  44:    */     {
/*  45: 47 */       System.out.println("Wystapil blad podczas zapisu pliku backpack.yml");
/*  46:    */     }
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setupConfig()
/*  50:    */   {
/*  51: 53 */     if (!this.data.isConfigurationSection("backpack"))
/*  52:    */     {
/*  53: 55 */       this.data.createSection("backpack");
/*  54: 56 */       saveData();
/*  55:    */     }
/*  56: 58 */     if (!this.data.isList("players"))
/*  57:    */     {
/*  58: 60 */       this.data.createSection("players");
/*  59: 61 */       saveData();
/*  60:    */     }
/*  61:    */   }
/*  62:    */   
/*  63:    */   public List<OfflinePlayer> getPlayers()
/*  64:    */   {
/*  65: 68 */     List<OfflinePlayer> listPlayers = new ArrayList();
/*  66: 69 */     if (this.data.isList("players"))
/*  67:    */     {
/*  68: 71 */       List<String> listByPlayers = this.data.getStringList("players");
/*  69: 72 */       for (String player : listByPlayers) {
/*  70: 74 */         listPlayers.add(Bukkit.getOfflinePlayer(player));
/*  71:    */       }
/*  72:    */     }
/*  73: 77 */     return listPlayers;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public List<ItemStack> getBackpack(OfflinePlayer player)
/*  77:    */   {
/*  78: 83 */     return this.data.getList("backpack." + player.getName());
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setBackpack(Player player)
/*  82:    */   {
/*  83: 88 */     if (!this.data.isList("backpack." + player.getName())) {
/*  84: 90 */       this.data.set("backpack." + player.getName(), new ArrayList());
/*  85:    */     }
/*  86: 92 */     if (!this.backpackItems.containsKey(player)) {
/*  87: 94 */       this.backpackItems.put(player, new ArrayList());
/*  88:    */     }
/*  89: 96 */     this.data.set("backpack." + player.getName(), this.backpackItems.get(player));
/*  90:    */     
/*  91:    */ 
/*  92: 99 */     List<String> rangiList = this.data.getStringList("players." + player.getName());
/*  93:100 */     if (!rangiList.contains(player.getName())) {
/*  94:102 */       rangiList.add(player.getName());
/*  95:    */     }
/*  96:104 */     this.data.set("players", rangiList);
/*  97:105 */     if (!this.playerByList.contains(player)) {
/*  98:107 */       this.playerByList.add(player);
/*  99:    */     }
/* 100:109 */     saveData();
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void openPlecak(Player p, String namePlayer, String namePlayerLow)
/* 104:    */   {
/* 105:    */     Inventory eq;
/* 106:    */     Inventory eq;
/* 107:115 */     if (p.hasPermission("tirex.vip")) {
/* 108:117 */       eq = Bukkit.createInventory(null, 36, "Plecak");
/* 109:    */     } else {
/* 110:121 */       eq = Bukkit.createInventory(null, 27, "Plecak");
/* 111:    */     }
/* 112:123 */     eq.clear();
/* 113:124 */     Inventory eqPlayer = p.getInventory();
/* 114:125 */     if (this.backpackItems.containsKey(p))
/* 115:    */     {
/* 116:127 */       List<ItemStack> itemy = (List)this.backpackItems.get(p);
/* 117:128 */       if (itemy != null) {
/* 118:130 */         for (ItemStack przedmioty : itemy) {
/* 119:132 */           if (eq.firstEmpty() >= 0) {
/* 120:134 */             eq.addItem(new ItemStack[] { przedmioty });
/* 121:136 */           } else if (eqPlayer.firstEmpty() >= 0) {
/* 122:138 */             eqPlayer.addItem(new ItemStack[] { przedmioty });
/* 123:    */           } else {
/* 124:142 */             p.getWorld().dropItem(p.getLocation(), przedmioty);
/* 125:    */           }
/* 126:    */         }
/* 127:    */       }
/* 128:    */     }
/* 129:148 */     p.openInventory(eq);
/* 130:    */   }
/* 131:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.BackpackManager
 * JD-Core Version:    0.7.0.1
 */