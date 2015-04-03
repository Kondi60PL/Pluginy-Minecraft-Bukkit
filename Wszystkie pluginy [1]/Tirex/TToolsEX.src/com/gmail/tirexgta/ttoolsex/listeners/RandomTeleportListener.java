/*   1:    */ package com.gmail.tirexgta.ttoolsex.listeners;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import com.gmail.tirexgta.ttoolsex.RandomTeleportManager;
/*   5:    */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.HashMap;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Random;
/*  10:    */ import org.bukkit.Location;
/*  11:    */ import org.bukkit.Material;
/*  12:    */ import org.bukkit.Server;
/*  13:    */ import org.bukkit.World;
/*  14:    */ import org.bukkit.block.Block;
/*  15:    */ import org.bukkit.block.BlockState;
/*  16:    */ import org.bukkit.entity.Player;
/*  17:    */ import org.bukkit.event.EventHandler;
/*  18:    */ import org.bukkit.event.EventPriority;
/*  19:    */ import org.bukkit.event.Listener;
/*  20:    */ import org.bukkit.event.block.Action;
/*  21:    */ import org.bukkit.event.block.BlockBreakEvent;
/*  22:    */ import org.bukkit.event.player.PlayerInteractEvent;
/*  23:    */ import org.bukkit.material.Button;
/*  24:    */ import org.bukkit.plugin.PluginManager;
/*  25:    */ 
/*  26:    */ public class RandomTeleportListener
/*  27:    */   implements Listener
/*  28:    */ {
/*  29:    */   Main plugin;
/*  30: 25 */   public HashMap<Player, String> hasTypedCommand = new HashMap();
/*  31:    */   
/*  32:    */   public RandomTeleportListener(Main plugin)
/*  33:    */   {
/*  34: 30 */     this.plugin = plugin;
/*  35: 31 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/*  36:    */   }
/*  37:    */   
/*  38:    */   @EventHandler(ignoreCancelled=true)
/*  39:    */   public void onPlayerInteract(PlayerInteractEvent event)
/*  40:    */   {
/*  41: 37 */     Block block = event.getClickedBlock();
/*  42: 38 */     if ((event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && (block.getType().equals(Material.STONE_BUTTON)))
/*  43:    */     {
/*  44: 40 */       Player player = event.getPlayer();
/*  45: 41 */       Location location = block.getLocation();
/*  46: 42 */       if (this.hasTypedCommand.get(player) != null)
/*  47:    */       {
/*  48: 43 */         if (((String)this.hasTypedCommand.get(player)).equalsIgnoreCase("addgroups"))
/*  49:    */         {
/*  50: 45 */           event.setCancelled(true);
/*  51: 46 */           if ((!this.plugin.randomTeleportManager.isRandomTpGroups(location)) && (!this.plugin.randomTeleportManager.isRandomTp(location)))
/*  52:    */           {
/*  53: 48 */             this.plugin.randomTeleportManager.addRandomTpGroups(location);
/*  54: 49 */             player.sendMessage("§9Dodano grupowy losowy teleport!");
/*  55: 50 */             this.hasTypedCommand.remove(player);
/*  56: 51 */             return;
/*  57:    */           }
/*  58: 55 */           player.sendMessage("§cTen guzik jest już losowym teleportem!");
/*  59: 56 */           this.hasTypedCommand.remove(player);
/*  60: 57 */           return;
/*  61:    */         }
/*  62: 60 */         if (((String)this.hasTypedCommand.get(player)).equalsIgnoreCase("deletegroups"))
/*  63:    */         {
/*  64: 62 */           event.setCancelled(true);
/*  65: 63 */           if (this.plugin.randomTeleportManager.isRandomTpGroups(location))
/*  66:    */           {
/*  67: 65 */             this.plugin.randomTeleportManager.delRandomTpGroups(location);
/*  68: 66 */             player.sendMessage("§9Usunieto grupowy losowy teleport!");
/*  69: 67 */             this.hasTypedCommand.remove(player);
/*  70: 68 */             return;
/*  71:    */           }
/*  72: 72 */           player.sendMessage("§cTen guzik nie jest losowym teleportem!");
/*  73: 73 */           this.hasTypedCommand.remove(player);
/*  74: 74 */           return;
/*  75:    */         }
/*  76: 77 */         if (((String)this.hasTypedCommand.get(player)).equalsIgnoreCase("add"))
/*  77:    */         {
/*  78: 79 */           event.setCancelled(true);
/*  79: 80 */           if ((!this.plugin.randomTeleportManager.isRandomTp(location)) && (!this.plugin.randomTeleportManager.isRandomTpGroups(location)))
/*  80:    */           {
/*  81: 82 */             this.plugin.randomTeleportManager.addRandomTp(location);
/*  82: 83 */             player.sendMessage("§9Dodano losowy teleport!");
/*  83: 84 */             this.hasTypedCommand.remove(player);
/*  84: 85 */             return;
/*  85:    */           }
/*  86: 89 */           player.sendMessage("§cTen guzik jest już losowym teleportem!");
/*  87: 90 */           this.hasTypedCommand.remove(player);
/*  88: 91 */           return;
/*  89:    */         }
/*  90: 94 */         if (((String)this.hasTypedCommand.get(player)).equalsIgnoreCase("delete"))
/*  91:    */         {
/*  92: 96 */           event.setCancelled(true);
/*  93: 97 */           if (this.plugin.randomTeleportManager.isRandomTp(location))
/*  94:    */           {
/*  95: 99 */             this.plugin.randomTeleportManager.delRandomTp(location);
/*  96:100 */             player.sendMessage("§9Usunieto losowy teleport!");
/*  97:101 */             this.hasTypedCommand.remove(player);
/*  98:102 */             return;
/*  99:    */           }
/* 100:106 */           player.sendMessage("§cTen guzik nie jest losowym teleportem!");
/* 101:107 */           this.hasTypedCommand.remove(player);
/* 102:108 */           return;
/* 103:    */         }
/* 104:    */       }
/* 105:111 */       if (this.plugin.randomTeleportManager.isRandomTpGroups(location))
/* 106:    */       {
/* 107:113 */         Button buton = (Button)block.getState().getData();
/* 108:114 */         for (Player p : getPlayersInRadius(block.getRelative(buton.getAttachedFace()).getLocation(), this.plugin.config.randomGroupRadius))
/* 109:    */         {
/* 110:116 */           int x = getRandom(this.plugin.config.randomMin, this.plugin.config.randomMax);
/* 111:117 */           int z = getRandom(this.plugin.config.randomMin, this.plugin.config.randomMax);
/* 112:118 */           Location loc = new Location(block.getWorld(), x, 0.0D, z);
/* 113:119 */           Location randomLoc = new Location(loc.getWorld(), loc.getBlockX() + 0.5D, loc.getWorld().getHighestBlockYAt(loc), loc.getBlockZ() + 0.5D);
/* 114:120 */           p.teleport(randomLoc);
/* 115:121 */           p.sendMessage("§aZostales teleportowany w losowe kordy!");
/* 116:    */         }
/* 117:    */       }
/* 118:124 */       else if (this.plugin.randomTeleportManager.isRandomTp(location))
/* 119:    */       {
/* 120:126 */         int x = getRandom(this.plugin.config.randomMin, this.plugin.config.randomMax);
/* 121:127 */         int z = getRandom(this.plugin.config.randomMin, this.plugin.config.randomMax);
/* 122:128 */         Location loc = new Location(block.getWorld(), x, 0.0D, z);
/* 123:129 */         Location randomLoc = new Location(loc.getWorld(), loc.getBlockX() + 0.5D, loc.getWorld().getHighestBlockYAt(loc), loc.getBlockZ() + 0.5D);
/* 124:130 */         player.teleport(randomLoc);
/* 125:131 */         player.sendMessage("§aZostales teleportowany w losowe kordy!");
/* 126:    */       }
/* 127:    */     }
/* 128:    */   }
/* 129:    */   
/* 130:    */   @EventHandler(priority=EventPriority.HIGH, ignoreCancelled=true)
/* 131:    */   public void onBlockBreak(BlockBreakEvent event)
/* 132:    */   {
/* 133:139 */     Location location = event.getBlock().getLocation();
/* 134:140 */     if (event.getBlock().getType().equals(Material.STONE_BUTTON))
/* 135:    */     {
/* 136:142 */       Player player = event.getPlayer();
/* 137:143 */       if ((this.plugin.randomTeleportManager.isRandomTpGroups(location)) || (this.plugin.randomTeleportManager.isRandomTp(location)))
/* 138:    */       {
/* 139:145 */         event.setCancelled(true);
/* 140:146 */         player.sendMessage("§9Nie mozesz zniszczyc losowego teleportu!");
/* 141:    */       }
/* 142:    */     }
/* 143:    */   }
/* 144:    */   
/* 145:    */   public List<Player> getPlayersInRadius(Location loc, int size)
/* 146:    */   {
/* 147:153 */     List<Player> gracze = new ArrayList();
/* 148:154 */     for (Player player : loc.getWorld().getPlayers()) {
/* 149:156 */       if (loc.distance(player.getLocation()) <= size) {
/* 150:158 */         gracze.add(player);
/* 151:    */       }
/* 152:    */     }
/* 153:161 */     return gracze;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public int getRandom(int lower, int upper)
/* 157:    */   {
/* 158:166 */     Random random = new Random();
/* 159:167 */     return random.nextInt(upper - lower + 1) + lower;
/* 160:    */   }
/* 161:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.RandomTeleportListener
 * JD-Core Version:    0.7.0.1
 */