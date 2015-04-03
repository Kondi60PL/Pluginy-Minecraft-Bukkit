/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.EffectManager;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  5:   */ import org.bukkit.Location;
/*  6:   */ import org.bukkit.Server;
/*  7:   */ import org.bukkit.entity.Entity;
/*  8:   */ import org.bukkit.entity.Player;
/*  9:   */ import org.bukkit.event.EventHandler;
/* 10:   */ import org.bukkit.event.Listener;
/* 11:   */ import org.bukkit.event.entity.EntityRegainHealthEvent;
/* 12:   */ import org.bukkit.plugin.PluginManager;
/* 13:   */ 
/* 14:   */ public class RegenerationHeartListener
/* 15:   */   implements Listener
/* 16:   */ {
/* 17:   */   Main plugin;
/* 18:   */   
/* 19:   */   public RegenerationHeartListener(Main plugin)
/* 20:   */   {
/* 21:19 */     this.plugin = plugin;
/* 22:20 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 23:   */   }
/* 24:   */   
/* 25:   */   @EventHandler
/* 26:   */   public void onEntityRegainHealth(EntityRegainHealthEvent e)
/* 27:   */   {
/* 28:26 */     Entity victimNoPlayer = e.getEntity();
/* 29:27 */     if (!(victimNoPlayer instanceof Player)) {
/* 30:29 */       return;
/* 31:   */     }
/* 32:31 */     Player victim = ((Player)victimNoPlayer).getPlayer();
/* 33:   */     
/* 34:   */ 
/* 35:34 */     Location loc = victim.getLocation();
/* 36:   */     try
/* 37:   */     {
/* 38:36 */       EffectManager.sendToLocation(EffectManager.HEART, loc, 0.5F, 1.0F, 0.5F, 0.1F, 2);
/* 39:   */     }
/* 40:   */     catch (Exception e1)
/* 41:   */     {
/* 42:39 */       e1.printStackTrace();
/* 43:   */     }
/* 44:   */   }
/* 45:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.RegenerationHeartListener
 * JD-Core Version:    0.7.0.1
 */