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
/* 11:   */ import org.bukkit.event.player.PlayerJoinEvent;
/* 12:   */ import org.bukkit.event.player.PlayerKickEvent;
/* 13:   */ import org.bukkit.event.player.PlayerQuitEvent;
/* 14:   */ import org.bukkit.plugin.PluginManager;
/* 15:   */ 
/* 16:   */ public class UserJoinLeaveListener
/* 17:   */   implements Listener
/* 18:   */ {
/* 19:   */   Main plugin;
/* 20:   */   
/* 21:   */   public UserJoinLeaveListener(Main plugin)
/* 22:   */   {
/* 23:20 */     this.plugin = plugin;
/* 24:21 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 25:   */   }
/* 26:   */   
/* 27:   */   @EventHandler
/* 28:   */   public void onPlayerJoin(PlayerJoinEvent event)
/* 29:   */   {
/* 30:27 */     Player player = event.getPlayer();
/* 31:28 */     DataUser user = Datasource.getUserData(player);
/* 32:29 */     if (user == null)
/* 33:   */     {
/* 34:31 */       user = this.plugin.data.createUser();
/* 35:32 */       user.setNick(player.getName());
/* 36:33 */       this.plugin.exportPlayerData(user, player);
/* 37:34 */       user.insert();
/* 38:   */     }
/* 39:   */     else
/* 40:   */     {
/* 41:38 */       this.plugin.importPlayerData(user, player);
/* 42:   */     }
/* 43:   */   }
/* 44:   */   
/* 45:   */   @EventHandler
/* 46:   */   public void onPlayerLeave(PlayerQuitEvent event)
/* 47:   */   {
/* 48:45 */     leftGame(event.getPlayer());
/* 49:   */   }
/* 50:   */   
/* 51:   */   @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
/* 52:   */   public void onPlayerKick(PlayerKickEvent event)
/* 53:   */   {
/* 54:51 */     leftGame(event.getPlayer());
/* 55:   */   }
/* 56:   */   
/* 57:   */   void leftGame(Player player)
/* 58:   */   {
/* 59:56 */     DataUser user = Datasource.getUserData(player);
/* 60:57 */     if (user != null)
/* 61:   */     {
/* 62:59 */       this.plugin.exportPlayerData(user, player);
/* 63:60 */       user.update();
/* 64:   */     }
/* 65:   */   }
/* 66:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.UserJoinLeaveListener
 * JD-Core Version:    0.7.0.1
 */