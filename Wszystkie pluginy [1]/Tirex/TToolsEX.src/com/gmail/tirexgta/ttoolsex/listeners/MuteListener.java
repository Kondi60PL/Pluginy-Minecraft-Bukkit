/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  6:   */ import java.text.SimpleDateFormat;
/*  7:   */ import java.util.Date;
/*  8:   */ import org.bukkit.Server;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ import org.bukkit.event.EventHandler;
/* 11:   */ import org.bukkit.event.Listener;
/* 12:   */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/* 13:   */ import org.bukkit.plugin.PluginManager;
/* 14:   */ 
/* 15:   */ public class MuteListener
/* 16:   */   implements Listener
/* 17:   */ {
/* 18:   */   Main plugin;
/* 19:   */   
/* 20:   */   public MuteListener(Main plugin)
/* 21:   */   {
/* 22:21 */     this.plugin = plugin;
/* 23:22 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 24:   */   }
/* 25:   */   
/* 26:   */   @EventHandler
/* 27:   */   public void onPlayerChat(AsyncPlayerChatEvent event)
/* 28:   */   {
/* 29:28 */     Player player = event.getPlayer();
/* 30:29 */     DataUser user = Datasource.getUserData(player);
/* 31:30 */     if (user.getMute() != null) {
/* 32:32 */       if (user.getMuteTime() != 0L) {
/* 33:34 */         if (user.getMuteTime() <= System.currentTimeMillis())
/* 34:   */         {
/* 35:36 */           player.sendMessage("§6Od tej pory mozesz juz pisac.\n§6Uwazaj, aby znow nie zostac wyciszonym!");
/* 36:37 */           user.setMute(null);
/* 37:38 */           user.setMuteTime(0L);
/* 38:   */         }
/* 39:   */         else
/* 40:   */         {
/* 41:42 */           event.setCancelled(true);
/* 42:43 */           Date date = new Date(user.getMuteTime());
/* 43:44 */           SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 44:45 */           String timeShow = dt.format(date);
/* 45:46 */           player.sendMessage("§7Zostales wyciszony do §c" + timeShow + "§7. Powod: §c" + user.getMute());
/* 46:   */         }
/* 47:   */       }
/* 48:   */     }
/* 49:   */   }
/* 50:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.MuteListener
 * JD-Core Version:    0.7.0.1
 */