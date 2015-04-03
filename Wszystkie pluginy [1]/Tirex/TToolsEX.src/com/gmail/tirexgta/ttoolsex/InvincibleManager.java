/*  1:   */ package com.gmail.tirexgta.ttoolsex;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.io.PrintStream;
/*  5:   */ import java.util.ArrayList;
/*  6:   */ import java.util.List;
/*  7:   */ import org.bukkit.configuration.file.YamlConfiguration;
/*  8:   */ import org.bukkit.entity.Entity;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ 
/* 11:   */ public class InvincibleManager
/* 12:   */ {
/* 13:   */   Main plugin;
/* 14:   */   YamlConfiguration data;
/* 15:   */   List<Integer> entities;
/* 16:16 */   List<Player> inCommand = new ArrayList();
/* 17:   */   
/* 18:   */   public InvincibleManager(Main plugin)
/* 19:   */   {
/* 20:20 */     this.plugin = plugin;
/* 21:21 */     this.data = YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "invincibles.yml"));
/* 22:22 */     if (this.data.isList("invincibles")) {
/* 23:24 */       this.entities = this.data.getIntegerList("invincibles");
/* 24:   */     } else {
/* 25:28 */       this.entities = new ArrayList();
/* 26:   */     }
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void saveData()
/* 30:   */   {
/* 31:   */     try
/* 32:   */     {
/* 33:35 */       this.data.save(new File(this.plugin.getDataFolder(), "invincibles.yml"));
/* 34:   */     }
/* 35:   */     catch (Exception e)
/* 36:   */     {
/* 37:37 */       System.out.println("Wystapil blad podczas zapisu pliku invincibles.yml");
/* 38:   */     }
/* 39:   */   }
/* 40:   */   
/* 41:   */   public boolean isInvincible(Entity entity)
/* 42:   */   {
/* 43:43 */     return this.entities.contains(Integer.valueOf(entity.getEntityId()));
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setInvincible(Entity entity, boolean flag)
/* 47:   */   {
/* 48:47 */     if (flag)
/* 49:   */     {
/* 50:49 */       if (!this.entities.contains(Integer.valueOf(entity.getEntityId()))) {
/* 51:51 */         this.entities.add(Integer.valueOf(entity.getEntityId()));
/* 52:   */       }
/* 53:   */     }
/* 54:   */     else {
/* 55:56 */       this.entities.remove(this.entities.indexOf(Integer.valueOf(entity.getEntityId())));
/* 56:   */     }
/* 57:58 */     saveData();
/* 58:   */   }
/* 59:   */   
/* 60:   */   public boolean isInCommand(Player player)
/* 61:   */   {
/* 62:63 */     return this.inCommand.contains(player);
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setInCommand(Player player, boolean flag)
/* 66:   */   {
/* 67:67 */     if (flag)
/* 68:   */     {
/* 69:69 */       if (!this.inCommand.contains(player)) {
/* 70:71 */         this.inCommand.add(player);
/* 71:   */       }
/* 72:   */     }
/* 73:   */     else {
/* 74:76 */       this.inCommand.remove(player);
/* 75:   */     }
/* 76:   */   }
/* 77:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.InvincibleManager
 * JD-Core Version:    0.7.0.1
 */