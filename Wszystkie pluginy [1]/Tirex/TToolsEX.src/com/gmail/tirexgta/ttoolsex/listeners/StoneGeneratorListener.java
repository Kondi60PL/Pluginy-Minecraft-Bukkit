/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Bukkit;
/*  5:   */ import org.bukkit.Location;
/*  6:   */ import org.bukkit.Material;
/*  7:   */ import org.bukkit.Server;
/*  8:   */ import org.bukkit.block.Block;
/*  9:   */ import org.bukkit.event.EventHandler;
/* 10:   */ import org.bukkit.event.Listener;
/* 11:   */ import org.bukkit.event.block.BlockBreakEvent;
/* 12:   */ import org.bukkit.event.block.BlockPlaceEvent;
/* 13:   */ import org.bukkit.inventory.ItemStack;
/* 14:   */ import org.bukkit.plugin.PluginManager;
/* 15:   */ import org.bukkit.scheduler.BukkitScheduler;
/* 16:   */ 
/* 17:   */ public class StoneGeneratorListener
/* 18:   */   implements Listener
/* 19:   */ {
/* 20:   */   Main plugin;
/* 21:   */   
/* 22:   */   public StoneGeneratorListener(Main plugin)
/* 23:   */   {
/* 24:19 */     this.plugin = plugin;
/* 25:20 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 26:   */   }
/* 27:   */   
/* 28:   */   @EventHandler
/* 29:   */   public static void onBlockBreak(BlockBreakEvent e)
/* 30:   */   {
/* 31:26 */     Location loc = e.getBlock().getLocation();
/* 32:27 */     Location locBlock = new Location(loc.getWorld(), loc.getX(), loc.getY() - 1.0D, loc.getZ());
/* 33:28 */     if (locBlock.getBlock().getType().equals(Material.DAYLIGHT_DETECTOR)) {
/* 34:30 */       Bukkit.getScheduler().runTaskLater(Main.getThis(), new Runnable()
/* 35:   */       {
/* 36:   */         public void run()
/* 37:   */         {
/* 38:35 */           if (StoneGeneratorListener.this.getBlock().getType().equals(Material.AIR)) {
/* 39:36 */             StoneGeneratorListener.this.getBlock().setType(Material.STONE);
/* 40:   */           }
/* 41:   */         }
/* 42:38 */       }, 60L);
/* 43:   */     }
/* 44:   */   }
/* 45:   */   
/* 46:   */   @EventHandler
/* 47:   */   public void onBlockPlace(BlockPlaceEvent e)
/* 48:   */   {
/* 49:45 */     if (e.getItemInHand().getType().equals(Material.DAYLIGHT_DETECTOR))
/* 50:   */     {
/* 51:47 */       Location loc = e.getBlock().getLocation();
/* 52:48 */       final Location locBlock = new Location(loc.getWorld(), loc.getX(), loc.getY() + 1.0D, loc.getZ());
/* 53:49 */       if (locBlock.getBlock().getType().equals(Material.AIR)) {
/* 54:51 */         Bukkit.getScheduler().runTaskLater(Main.getThis(), new Runnable()
/* 55:   */         {
/* 56:   */           public void run()
/* 57:   */           {
/* 58:56 */             if (locBlock.getBlock().getType().equals(Material.AIR)) {
/* 59:57 */               locBlock.getBlock().setType(Material.STONE);
/* 60:   */             }
/* 61:   */           }
/* 62:59 */         }, 10L);
/* 63:   */       }
/* 64:   */     }
/* 65:   */   }
/* 66:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.StoneGeneratorListener
 * JD-Core Version:    0.7.0.1
 */