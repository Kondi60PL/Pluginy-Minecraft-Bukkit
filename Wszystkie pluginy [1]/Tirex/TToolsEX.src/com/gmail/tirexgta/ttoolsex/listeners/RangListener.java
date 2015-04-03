/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.RangManager;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.List;
/*  7:   */ import net.milkbowl.vault.permission.Permission;
/*  8:   */ import org.bukkit.Bukkit;
/*  9:   */ import org.bukkit.OfflinePlayer;
/* 10:   */ import org.bukkit.Server;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ import org.bukkit.event.EventHandler;
/* 13:   */ import org.bukkit.event.Listener;
/* 14:   */ import org.bukkit.event.player.PlayerJoinEvent;
/* 15:   */ import org.bukkit.plugin.PluginManager;
/* 16:   */ 
/* 17:   */ public class RangListener
/* 18:   */   implements Listener
/* 19:   */ {
/* 20:   */   Main plugin;
/* 21:   */   
/* 22:   */   public RangListener(Main plugin)
/* 23:   */   {
/* 24:20 */     this.plugin = plugin;
/* 25:21 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 26:   */   }
/* 27:   */   
/* 28:   */   @EventHandler
/* 29:   */   public void onPlayerJoin(PlayerJoinEvent e)
/* 30:   */   {
/* 31:27 */     Player p = e.getPlayer();
/* 32:   */     
/* 33:29 */     OfflinePlayer offlineP = Bukkit.getOfflinePlayer(p.getName());
/* 34:30 */     if (this.plugin.rangManager.playerByList.contains(offlineP)) {
/* 35:32 */       if (this.plugin.rangManager.rangaCzas.containsKey(offlineP))
/* 36:   */       {
/* 37:34 */         long czasRangi = ((Long)this.plugin.rangManager.rangaCzas.get(offlineP)).longValue();
/* 38:35 */         if (czasRangi > System.currentTimeMillis())
/* 39:   */         {
/* 40:37 */           Permission chat = Main.chat;
/* 41:38 */           String ranga = (String)this.plugin.rangManager.rangaNazwa.get(offlineP);
/* 42:39 */           String groupsPlayer = null;
/* 43:40 */           for (String groupPlayer : chat.getPlayerGroups(p)) {
/* 44:42 */             if (groupPlayer.equals(ranga)) {
/* 45:44 */               groupsPlayer = groupPlayer;
/* 46:   */             }
/* 47:   */           }
/* 48:47 */           if (groupsPlayer == null) {
/* 49:49 */             chat.playerAddGroup(p, ranga);
/* 50:   */           }
/* 51:   */         }
/* 52:   */         else
/* 53:   */         {
/* 54:54 */           Permission chat = Main.chat;
/* 55:55 */           chat.playerRemoveGroup(p, (String)this.plugin.rangManager.rangaNazwa.get(offlineP));
/* 56:56 */           this.plugin.rangManager.removeRang(p);
/* 57:   */         }
/* 58:   */       }
/* 59:   */     }
/* 60:   */   }
/* 61:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.RangListener
 * JD-Core Version:    0.7.0.1
 */