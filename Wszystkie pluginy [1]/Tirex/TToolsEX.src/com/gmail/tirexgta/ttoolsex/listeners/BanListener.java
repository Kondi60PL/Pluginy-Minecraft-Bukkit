/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.DataBan;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  6:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  7:   */ import java.text.SimpleDateFormat;
/*  8:   */ import java.util.Date;
/*  9:   */ import org.bukkit.Server;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ import org.bukkit.event.EventHandler;
/* 12:   */ import org.bukkit.event.EventPriority;
/* 13:   */ import org.bukkit.event.Listener;
/* 14:   */ import org.bukkit.event.player.PlayerLoginEvent;
/* 15:   */ import org.bukkit.event.player.PlayerLoginEvent.Result;
/* 16:   */ import org.bukkit.plugin.PluginManager;
/* 17:   */ 
/* 18:   */ public class BanListener
/* 19:   */   implements Listener
/* 20:   */ {
/* 21:   */   final Main plugin;
/* 22:   */   
/* 23:   */   public BanListener(Main plugin)
/* 24:   */   {
/* 25:22 */     this.plugin = plugin;
/* 26:23 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 27:   */   }
/* 28:   */   
/* 29:   */   @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
/* 30:   */   public void onPlayerLogin(PlayerLoginEvent event)
/* 31:   */   {
/* 32:30 */     DataUser user = Datasource.getUserData(event.getPlayer());
/* 33:31 */     DataBan ban = this.plugin.data.getBanData(event.getPlayer());
/* 34:32 */     if ((user != null) && (ban != null) && (!event.getPlayer().hasPermission("tools.ban.bypass"))) {
/* 35:33 */       if (ban.getTime().longValue() <= System.currentTimeMillis())
/* 36:   */       {
/* 37:35 */         ban.delete();
/* 38:   */       }
/* 39:   */       else
/* 40:   */       {
/* 41:39 */         Date date = new Date(ban.getTime().longValue());
/* 42:40 */         SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 43:41 */         String timeShow = dt.format(date);
/* 44:42 */         DataUser banAdmin = ban.admin;
/* 45:43 */         String banAdminString = "";
/* 46:44 */         if (banAdmin == null) {
/* 47:46 */           banAdminString = "CONSOLE";
/* 48:   */         } else {
/* 49:50 */           banAdminString = banAdmin.getNick();
/* 50:   */         }
/* 51:52 */         event.disallow(PlayerLoginEvent.Result.KICK_BANNED, "§cZostales zbanowany do: §6" + timeShow + "§c.\n§cPowod: §6" + ban.getReason() + "\n§cPrzez: §6" + banAdminString);
/* 52:   */       }
/* 53:   */     }
/* 54:   */   }
/* 55:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.BanListener
 * JD-Core Version:    0.7.0.1
 */