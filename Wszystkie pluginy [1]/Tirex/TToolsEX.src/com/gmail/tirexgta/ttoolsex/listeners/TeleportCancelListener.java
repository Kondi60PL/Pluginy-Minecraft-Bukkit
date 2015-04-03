/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import java.util.ArrayList;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.List;
/*  7:   */ import org.bukkit.Location;
/*  8:   */ import org.bukkit.Server;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ import org.bukkit.event.EventHandler;
/* 11:   */ import org.bukkit.event.EventPriority;
/* 12:   */ import org.bukkit.event.Listener;
/* 13:   */ import org.bukkit.event.entity.EntityDamageEvent;
/* 14:   */ import org.bukkit.event.player.PlayerMoveEvent;
/* 15:   */ import org.bukkit.plugin.PluginManager;
/* 16:   */ import org.bukkit.scheduler.BukkitTask;
/* 17:   */ 
/* 18:   */ public class TeleportCancelListener
/* 19:   */   implements Listener
/* 20:   */ {
/* 21:   */   Main plugin;
/* 22:21 */   public HashMap<Player, BukkitTask> playerTeleportLocation = new HashMap();
/* 23:22 */   public List<Player> teleport = new ArrayList();
/* 24:   */   
/* 25:   */   public TeleportCancelListener(Main plugin)
/* 26:   */   {
/* 27:26 */     this.plugin = plugin;
/* 28:27 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 29:   */   }
/* 30:   */   
/* 31:   */   @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
/* 32:   */   public void onPlayerMove(PlayerMoveEvent event)
/* 33:   */   {
/* 34:33 */     Location from = event.getFrom();
/* 35:34 */     Location to = event.getTo();
/* 36:35 */     if ((from.getBlockX() != to.getBlockX()) || (from.getBlockY() != to.getBlockY()) || (from.getBlockZ() != to.getBlockZ()) || (from.getWorld() != to.getWorld()))
/* 37:   */     {
/* 38:37 */       Player player = event.getPlayer();
/* 39:38 */       if (this.playerTeleportLocation.get(player) != null)
/* 40:   */       {
/* 41:40 */         ((BukkitTask)this.playerTeleportLocation.remove(player)).cancel();
/* 42:41 */         player.sendMessage("§cTeleportacja anulowana!");
/* 43:42 */         if (this.teleport.contains(player)) {
/* 44:44 */           this.teleport.remove(player);
/* 45:   */         }
/* 46:   */       }
/* 47:   */     }
/* 48:   */   }
/* 49:   */   
/* 50:   */   @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
/* 51:   */   public void onPlayerDamage(EntityDamageEvent event)
/* 52:   */   {
/* 53:53 */     if ((event.getEntity() instanceof Player))
/* 54:   */     {
/* 55:55 */       Player player = (Player)event.getEntity();
/* 56:56 */       if (this.playerTeleportLocation.get(player) != null)
/* 57:   */       {
/* 58:58 */         ((BukkitTask)this.playerTeleportLocation.remove(player)).cancel();
/* 59:59 */         player.sendMessage("§cTeleportacja anulowana!");
/* 60:60 */         if (this.teleport.contains(player)) {
/* 61:62 */           this.teleport.remove(player);
/* 62:   */         }
/* 63:   */       }
/* 64:   */     }
/* 65:   */   }
/* 66:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.TeleportCancelListener
 * JD-Core Version:    0.7.0.1
 */