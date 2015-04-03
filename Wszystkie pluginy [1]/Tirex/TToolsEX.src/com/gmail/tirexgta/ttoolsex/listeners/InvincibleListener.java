/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.InvincibleManager;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  5:   */ import org.bukkit.Server;
/*  6:   */ import org.bukkit.entity.Entity;
/*  7:   */ import org.bukkit.entity.Player;
/*  8:   */ import org.bukkit.event.EventHandler;
/*  9:   */ import org.bukkit.event.Listener;
/* 10:   */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/* 11:   */ import org.bukkit.event.entity.EntityDamageEvent;
/* 12:   */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/* 13:   */ import org.bukkit.plugin.PluginManager;
/* 14:   */ 
/* 15:   */ public class InvincibleListener
/* 16:   */   implements Listener
/* 17:   */ {
/* 18:   */   Main plugin;
/* 19:   */   
/* 20:   */   public InvincibleListener(Main plugin)
/* 21:   */   {
/* 22:19 */     this.plugin = plugin;
/* 23:20 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 24:   */   }
/* 25:   */   
/* 26:   */   @EventHandler(ignoreCancelled=true)
/* 27:   */   public void onPlayerInteractEntity(PlayerInteractEntityEvent event)
/* 28:   */   {
/* 29:26 */     if ((!(event.getRightClicked() instanceof Player)) && (interact(event.getPlayer(), event.getRightClicked()))) {
/* 30:28 */       event.setCancelled(true);
/* 31:   */     }
/* 32:   */   }
/* 33:   */   
/* 34:   */   @EventHandler(ignoreCancelled=true)
/* 35:   */   public void onEntityDamage(EntityDamageEvent event)
/* 36:   */   {
/* 37:35 */     if ((event instanceof EntityDamageByEntityEvent)) {
/* 38:37 */       return;
/* 39:   */     }
/* 40:39 */     if ((!(event.getEntity() instanceof Player)) && (interact(null, event.getEntity()))) {
/* 41:41 */       event.setCancelled(true);
/* 42:   */     }
/* 43:   */   }
/* 44:   */   
/* 45:   */   @EventHandler(ignoreCancelled=true)
/* 46:   */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
/* 47:   */   {
/* 48:48 */     if ((!(event.getEntity() instanceof Player)) && ((event.getDamager() instanceof Player)) && (interact((Player)event.getDamager(), event.getEntity()))) {
/* 49:50 */       event.setCancelled(true);
/* 50:   */     }
/* 51:   */   }
/* 52:   */   
/* 53:   */   public boolean interact(Player player, Entity clicked)
/* 54:   */   {
/* 55:56 */     if (player != null)
/* 56:   */     {
/* 57:58 */       if (this.plugin.invincibleManager.isInCommand(player))
/* 58:   */       {
/* 59:60 */         this.plugin.invincibleManager.setInCommand(player, false);
/* 60:61 */         if (this.plugin.invincibleManager.isInvincible(clicked))
/* 61:   */         {
/* 62:63 */           this.plugin.invincibleManager.setInvincible(clicked, false);
/* 63:64 */           player.sendMessage("§9Ten mob nie jest juz niesmietelny!");
/* 64:   */         }
/* 65:   */         else
/* 66:   */         {
/* 67:68 */           this.plugin.invincibleManager.setInvincible(clicked, true);
/* 68:69 */           player.sendMessage("§9Zrobiles tego moba niesmiertelnym!");
/* 69:   */         }
/* 70:71 */         return true;
/* 71:   */       }
/* 72:73 */       if (player.hasPermission("tirex.invincible.interact")) {
/* 73:75 */         return false;
/* 74:   */       }
/* 75:   */     }
/* 76:78 */     return this.plugin.invincibleManager.isInvincible(clicked);
/* 77:   */   }
/* 78:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.InvincibleListener
 * JD-Core Version:    0.7.0.1
 */