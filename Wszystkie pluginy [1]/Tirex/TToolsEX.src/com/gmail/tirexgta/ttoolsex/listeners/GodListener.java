/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  6:   */ import org.bukkit.Server;
/*  7:   */ import org.bukkit.entity.Player;
/*  8:   */ import org.bukkit.event.EventHandler;
/*  9:   */ import org.bukkit.event.EventPriority;
/* 10:   */ import org.bukkit.event.Listener;
/* 11:   */ import org.bukkit.event.entity.EntityDamageEvent;
/* 12:   */ import org.bukkit.plugin.PluginManager;
/* 13:   */ 
/* 14:   */ public class GodListener
/* 15:   */   implements Listener
/* 16:   */ {
/* 17:   */   Main plugin;
/* 18:   */   
/* 19:   */   public GodListener(Main plugin)
/* 20:   */   {
/* 21:18 */     this.plugin = plugin;
/* 22:19 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 23:   */   }
/* 24:   */   
/* 25:   */   @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
/* 26:   */   public void onEntityDamage(EntityDamageEvent event)
/* 27:   */   {
/* 28:25 */     if ((event.getEntity() instanceof Player))
/* 29:   */     {
/* 30:27 */       Player player = (Player)event.getEntity();
/* 31:28 */       if (Datasource.getUserData(player).getGod()) {
/* 32:29 */         event.setCancelled(true);
/* 33:   */       }
/* 34:   */     }
/* 35:   */   }
/* 36:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.GodListener
 * JD-Core Version:    0.7.0.1
 */