/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  5:   */ import org.bukkit.Server;
/*  6:   */ import org.bukkit.event.EventHandler;
/*  7:   */ import org.bukkit.event.Listener;
/*  8:   */ import org.bukkit.event.player.PlayerJoinEvent;
/*  9:   */ import org.bukkit.event.player.PlayerKickEvent;
/* 10:   */ import org.bukkit.event.player.PlayerQuitEvent;
/* 11:   */ import org.bukkit.plugin.PluginManager;
/* 12:   */ 
/* 13:   */ public class SilentJoinLeaveListener
/* 14:   */   implements Listener
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public SilentJoinLeaveListener(Main plugin)
/* 19:   */   {
/* 20:17 */     this.plugin = plugin;
/* 21:18 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 22:   */   }
/* 23:   */   
/* 24:   */   @EventHandler
/* 25:   */   public void onPlayerJoin(PlayerJoinEvent event)
/* 26:   */   {
/* 27:24 */     if (this.plugin.config.silentJoinLeave) {
/* 28:25 */       event.setJoinMessage(null);
/* 29:   */     }
/* 30:   */   }
/* 31:   */   
/* 32:   */   @EventHandler
/* 33:   */   public void onPlayerLeave(PlayerQuitEvent event)
/* 34:   */   {
/* 35:31 */     if (this.plugin.config.silentJoinLeave) {
/* 36:32 */       event.setQuitMessage(null);
/* 37:   */     }
/* 38:   */   }
/* 39:   */   
/* 40:   */   @EventHandler
/* 41:   */   public void onPlayerKick(PlayerKickEvent event)
/* 42:   */   {
/* 43:38 */     if (this.plugin.config.silentJoinLeave) {
/* 44:39 */       event.setLeaveMessage(null);
/* 45:   */     }
/* 46:   */   }
/* 47:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.SilentJoinLeaveListener
 * JD-Core Version:    0.7.0.1
 */