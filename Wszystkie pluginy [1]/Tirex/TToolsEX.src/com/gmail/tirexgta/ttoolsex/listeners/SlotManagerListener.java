/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  5:   */ import org.bukkit.ChatColor;
/*  6:   */ import org.bukkit.Server;
/*  7:   */ import org.bukkit.configuration.file.FileConfiguration;
/*  8:   */ import org.bukkit.entity.Player;
/*  9:   */ import org.bukkit.event.EventHandler;
/* 10:   */ import org.bukkit.event.EventPriority;
/* 11:   */ import org.bukkit.event.Listener;
/* 12:   */ import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
/* 13:   */ import org.bukkit.event.player.PlayerLoginEvent;
/* 14:   */ import org.bukkit.event.player.PlayerLoginEvent.Result;
/* 15:   */ import org.bukkit.event.server.ServerListPingEvent;
/* 16:   */ import org.bukkit.plugin.PluginManager;
/* 17:   */ 
/* 18:   */ public class SlotManagerListener
/* 19:   */   implements Listener
/* 20:   */ {
/* 21:   */   Main plugin;
/* 22:   */   
/* 23:   */   public SlotManagerListener(Main plugin)
/* 24:   */   {
/* 25:20 */     this.plugin = plugin;
/* 26:21 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 27:   */   }
/* 28:   */   
/* 29:   */   @EventHandler
/* 30:   */   public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent e)
/* 31:   */   {
/* 32:27 */     e.allow();
/* 33:   */   }
/* 34:   */   
/* 35:   */   @EventHandler
/* 36:   */   public void onServerListPing(ServerListPingEvent e)
/* 37:   */   {
/* 38:33 */     if (this.plugin.config.slotManagerSlots != 0) {
/* 39:35 */       e.setMaxPlayers(this.plugin.config.slotManagerSlots);
/* 40:   */     }
/* 41:37 */     if (this.plugin.getConfig().isString("config.slotmanager.motd"))
/* 42:   */     {
/* 43:39 */       String motd = this.plugin.config.slotManagerMotd;
/* 44:40 */       e.setMotd(motd.replaceAll("&", "§"));
/* 45:   */     }
/* 46:   */   }
/* 47:   */   
/* 48:   */   @EventHandler(priority=EventPriority.HIGHEST)
/* 49:   */   public void onPlayerJoin(PlayerLoginEvent e)
/* 50:   */   {
/* 51:47 */     Player p = e.getPlayer();
/* 52:48 */     if (this.plugin.slot() >= this.plugin.config.slotManagerSlots) {
/* 53:50 */       if (!p.hasPermission("tirex.joinfullserver")) {
/* 54:52 */         e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GOLD + "Serwer jest pelen. Sprobuj pozniej lub zakup range VIP!");
/* 55:   */       }
/* 56:   */     }
/* 57:   */   }
/* 58:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.SlotManagerListener
 * JD-Core Version:    0.7.0.1
 */