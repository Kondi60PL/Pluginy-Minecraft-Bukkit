/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Material;
/*  5:   */ import org.bukkit.Server;
/*  6:   */ import org.bukkit.entity.Player;
/*  7:   */ import org.bukkit.event.EventHandler;
/*  8:   */ import org.bukkit.event.Listener;
/*  9:   */ import org.bukkit.event.block.Action;
/* 10:   */ import org.bukkit.event.block.BlockDispenseEvent;
/* 11:   */ import org.bukkit.event.player.PlayerInteractEvent;
/* 12:   */ import org.bukkit.event.player.PlayerItemConsumeEvent;
/* 13:   */ import org.bukkit.inventory.ItemStack;
/* 14:   */ import org.bukkit.material.MaterialData;
/* 15:   */ import org.bukkit.plugin.PluginManager;
/* 16:   */ 
/* 17:   */ public class BlockedStrenghtListener
/* 18:   */   implements Listener
/* 19:   */ {
/* 20:   */   Main plugin;
/* 21:   */   
/* 22:   */   public BlockedStrenghtListener(Main plugin)
/* 23:   */   {
/* 24:21 */     this.plugin = plugin;
/* 25:22 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 26:   */   }
/* 27:   */   
/* 28:   */   @EventHandler
/* 29:   */   public void onPlayerInteract(BlockDispenseEvent e)
/* 30:   */   {
/* 31:29 */     ItemStack item = e.getItem();
/* 32:30 */     if ((item.getType().equals(Material.POTION)) && (item.getData().getData() == 41)) {
/* 33:32 */       e.setCancelled(true);
/* 34:   */     }
/* 35:   */   }
/* 36:   */   
/* 37:   */   @EventHandler
/* 38:   */   public void onPlayerInteract(PlayerItemConsumeEvent e)
/* 39:   */   {
/* 40:40 */     ItemStack item = e.getItem();
/* 41:41 */     if ((item.getType().equals(Material.POTION)) && (item.getData().getData() == 41))
/* 42:   */     {
/* 43:43 */       Player p = e.getPlayer();
/* 44:44 */       if (!p.hasPermission("tirex.potion"))
/* 45:   */       {
/* 46:46 */         p.sendMessage("§cNie masz uprawnien, aby pic ta miksture!");
/* 47:47 */         e.setCancelled(true);
/* 48:   */       }
/* 49:   */     }
/* 50:   */   }
/* 51:   */   
/* 52:   */   @EventHandler
/* 53:   */   public void onPlayerInteract(PlayerInteractEvent e)
/* 54:   */   {
/* 55:56 */     if (e.getAction().equals(Action.RIGHT_CLICK_AIR))
/* 56:   */     {
/* 57:58 */       ItemStack item = e.getItem();
/* 58:59 */       if ((item.getType().equals(Material.POTION)) && (item.getData().getData() == 41))
/* 59:   */       {
/* 60:61 */         Player p = e.getPlayer();
/* 61:62 */         if (!p.hasPermission("tirex.potion"))
/* 62:   */         {
/* 63:64 */           p.sendMessage("§cNie masz uprawnien, aby pic ta miksture!");
/* 64:65 */           e.setCancelled(true);
/* 65:   */         }
/* 66:   */       }
/* 67:   */     }
/* 68:   */   }
/* 69:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.BlockedStrenghtListener
 * JD-Core Version:    0.7.0.1
 */