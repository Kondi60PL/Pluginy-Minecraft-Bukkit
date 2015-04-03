/*   1:    */ package com.gmail.tirexgta.ttoolsex.listeners;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.DispensersManager;
/*   4:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   5:    */ import java.util.HashMap;
/*   6:    */ import org.bukkit.ChatColor;
/*   7:    */ import org.bukkit.Location;
/*   8:    */ import org.bukkit.Material;
/*   9:    */ import org.bukkit.Server;
/*  10:    */ import org.bukkit.block.Block;
/*  11:    */ import org.bukkit.block.Dispenser;
/*  12:    */ import org.bukkit.entity.Player;
/*  13:    */ import org.bukkit.event.EventHandler;
/*  14:    */ import org.bukkit.event.EventPriority;
/*  15:    */ import org.bukkit.event.Listener;
/*  16:    */ import org.bukkit.event.block.Action;
/*  17:    */ import org.bukkit.event.block.BlockBreakEvent;
/*  18:    */ import org.bukkit.event.block.BlockDispenseEvent;
/*  19:    */ import org.bukkit.event.player.PlayerInteractEvent;
/*  20:    */ import org.bukkit.inventory.Inventory;
/*  21:    */ import org.bukkit.inventory.ItemStack;
/*  22:    */ import org.bukkit.plugin.PluginManager;
/*  23:    */ 
/*  24:    */ public class DispensersListener
/*  25:    */   implements Listener
/*  26:    */ {
/*  27:    */   Main plugin;
/*  28: 25 */   public HashMap<Player, String> hasTypedCommand = new HashMap();
/*  29:    */   
/*  30:    */   public DispensersListener(Main plugin)
/*  31:    */   {
/*  32: 30 */     this.plugin = plugin;
/*  33: 31 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/*  34:    */   }
/*  35:    */   
/*  36:    */   @EventHandler(ignoreCancelled=true)
/*  37:    */   public void onPlayerInteract(PlayerInteractEvent event)
/*  38:    */   {
/*  39: 37 */     Block block = event.getClickedBlock();
/*  40: 38 */     if ((event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && (block.getType().equals(Material.DISPENSER)))
/*  41:    */     {
/*  42: 40 */       Player player = event.getPlayer();
/*  43: 41 */       if (this.hasTypedCommand.get(player) != null) {
/*  44: 42 */         if (((String)this.hasTypedCommand.get(player)).equalsIgnoreCase("add"))
/*  45:    */         {
/*  46: 44 */           event.setCancelled(true);
/*  47: 45 */           Location location = block.getLocation();
/*  48: 46 */           if (!this.plugin.dispensersManager.isUnlimitedDispenser(location))
/*  49:    */           {
/*  50: 48 */             this.plugin.dispensersManager.addDispenser(location);
/*  51: 49 */             player.sendMessage(ChatColor.BLUE + "Dodano nieskonczony dispenser!");
/*  52: 50 */             this.hasTypedCommand.remove(player);
/*  53:    */           }
/*  54:    */           else
/*  55:    */           {
/*  56: 54 */             player.sendMessage(ChatColor.RED + "Ten dispenser jest juz nieskonczony!");
/*  57: 55 */             this.hasTypedCommand.remove(player);
/*  58:    */           }
/*  59:    */         }
/*  60: 58 */         else if (((String)this.hasTypedCommand.get(player)).equalsIgnoreCase("delete"))
/*  61:    */         {
/*  62: 60 */           event.setCancelled(true);
/*  63: 61 */           Location location = block.getLocation();
/*  64: 62 */           if (this.plugin.dispensersManager.isUnlimitedDispenser(location))
/*  65:    */           {
/*  66: 64 */             this.plugin.dispensersManager.delDispenser(location);
/*  67: 65 */             player.sendMessage(ChatColor.BLUE + "Usunieto nieskonczony dispenser!");
/*  68: 66 */             this.hasTypedCommand.remove(player);
/*  69: 67 */             Dispenser dispenser = (Dispenser)event.getClickedBlock().getState();
/*  70: 68 */             dispenser.getInventory().clear();
/*  71:    */           }
/*  72:    */           else
/*  73:    */           {
/*  74: 72 */             player.sendMessage(ChatColor.RED + "Ten dispenser nie jest nieskonczony!");
/*  75: 73 */             this.hasTypedCommand.remove(player);
/*  76:    */           }
/*  77:    */         }
/*  78: 77 */         else if (!player.hasPermission("tools.dispensers.open"))
/*  79:    */         {
/*  80: 79 */           event.setCancelled(true);
/*  81:    */         }
/*  82:    */       }
/*  83:    */     }
/*  84:    */   }
/*  85:    */   
/*  86:    */   @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
/*  87:    */   public void onBlockDispense(BlockDispenseEvent event)
/*  88:    */   {
/*  89: 87 */     Location location = event.getBlock().getLocation();
/*  90: 88 */     if (this.plugin.dispensersManager.isUnlimitedDispenser(location))
/*  91:    */     {
/*  92: 90 */       Dispenser dispenser = (Dispenser)event.getBlock().getState();
/*  93: 91 */       ItemStack item = event.getItem();
/*  94: 92 */       dispenser.getInventory().addItem(new ItemStack[] { item.clone() });
/*  95:    */     }
/*  96:    */   }
/*  97:    */   
/*  98:    */   @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
/*  99:    */   public void onBlockBreak(BlockBreakEvent event)
/* 100:    */   {
/* 101: 99 */     Location location = event.getBlock().getLocation();
/* 102:100 */     if (event.getBlock().getType().equals(Material.DISPENSER))
/* 103:    */     {
/* 104:102 */       Player player = event.getPlayer();
/* 105:103 */       if (this.plugin.dispensersManager.isUnlimitedDispenser(location))
/* 106:    */       {
/* 107:105 */         event.setCancelled(true);
/* 108:106 */         player.sendMessage(ChatColor.RED + "Nie mozesz znisczyc nieskonczonego dispenser'a!");
/* 109:    */       }
/* 110:    */     }
/* 111:    */   }
/* 112:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.DispensersListener
 * JD-Core Version:    0.7.0.1
 */