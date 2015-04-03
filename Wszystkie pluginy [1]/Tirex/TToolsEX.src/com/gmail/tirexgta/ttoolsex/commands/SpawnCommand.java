/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.LastTeleportManager;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.listeners.TeleportCancelListener;
/*  6:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  7:   */ import java.util.List;
/*  8:   */ import org.bukkit.Location;
/*  9:   */ import org.bukkit.World;
/* 10:   */ import org.bukkit.command.Command;
/* 11:   */ import org.bukkit.command.CommandExecutor;
/* 12:   */ import org.bukkit.command.CommandSender;
/* 13:   */ import org.bukkit.command.PluginCommand;
/* 14:   */ import org.bukkit.entity.Player;
/* 15:   */ 
/* 16:   */ public class SpawnCommand
/* 17:   */   implements CommandExecutor
/* 18:   */ {
/* 19:   */   Main plugin;
/* 20:   */   
/* 21:   */   public SpawnCommand(Main plugin)
/* 22:   */   {
/* 23:17 */     this.plugin = plugin;
/* 24:18 */     this.plugin.getCommand("spawn").setExecutor(this);
/* 25:   */   }
/* 26:   */   
/* 27:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 28:   */   {
/* 29:24 */     if (!(sender instanceof Player))
/* 30:   */     {
/* 31:26 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 32:27 */       return true;
/* 33:   */     }
/* 34:29 */     final Player player = (Player)sender;
/* 35:30 */     if (this.plugin.teleportCancelListener.teleport.contains(player))
/* 36:   */     {
/* 37:32 */       sender.sendMessage("§cPoczekaj az sie steleportujesz!");
/* 38:33 */       return true;
/* 39:   */     }
/* 40:35 */     long lastTeleport = this.plugin.lastTeleportManager.getPlayerLastTeleport(player).longValue();
/* 41:36 */     long waitTeleport = (lastTeleport - System.currentTimeMillis()) / 1000L;
/* 42:37 */     Location spawnLocPlayer = player.getWorld().getSpawnLocation();
/* 43:38 */     Location spawnLoc = new Location(player.getWorld(), spawnLocPlayer.getBlockX() + 0.5D, spawnLocPlayer.getBlockY(), spawnLocPlayer.getBlockZ() + 0.5D);
/* 44:40 */     if (player.hasPermission("tirex.spawn.nocooldown"))
/* 45:   */     {
/* 46:42 */       if (player.hasPermission("tirex.spawn.nodelay"))
/* 47:   */       {
/* 48:44 */         player.teleport(spawnLoc);
/* 49:45 */         player.sendMessage("§6Przeteleportowano na spawn!");
/* 50:   */       }
/* 51:   */       else
/* 52:   */       {
/* 53:49 */         Main.teleportPlayerWithDelay(player, this.plugin.config.teleportDelay, spawnLoc, "§6Przeteleportowano na spawn!", null);
/* 54:50 */         player.sendMessage("§6Teleport rozgrzewa sie...");
/* 55:   */       }
/* 56:   */     }
/* 57:53 */     else if (System.currentTimeMillis() - this.plugin.config.teleportSpawnCooldown * 1000 > lastTeleport)
/* 58:   */     {
/* 59:55 */       if (player.hasPermission("tirex.spawn.nodelay"))
/* 60:   */       {
/* 61:57 */         this.plugin.lastTeleportManager.setPlayerLastTeleport(player, Long.valueOf(System.currentTimeMillis()));
/* 62:58 */         player.teleport(spawnLoc);
/* 63:59 */         player.sendMessage("§6Przeteleportowano na spawn!");
/* 64:   */       }
/* 65:   */       else
/* 66:   */       {
/* 67:63 */         Main.teleportPlayerWithDelay(player, this.plugin.config.teleportDelay, spawnLoc, "§6Przeteleportowano na spawn!", new Runnable()
/* 68:   */         {
/* 69:   */           public void run()
/* 70:   */           {
/* 71:68 */             SpawnCommand.this.plugin.lastTeleportManager.setPlayerLastTeleport(player, Long.valueOf(System.currentTimeMillis()));
/* 72:   */           }
/* 73:70 */         });
/* 74:71 */         player.sendMessage("§6Teleport rozgrzewa sie...");
/* 75:   */       }
/* 76:   */     }
/* 77:   */     else
/* 78:   */     {
/* 79:76 */       player.sendMessage("§cNastepna teleporta na spawn za §6" + waitTeleport / 60L + " §cmin.");
/* 80:77 */       player.sendMessage("§6Koordynaty spawnu to: x: §c" + player.getWorld().getSpawnLocation().getBlockX() + " §6z: §c" + player.getWorld().getSpawnLocation().getBlockZ());
/* 81:78 */       player.sendMessage("§6Twoj kompas kieruje teraz na spawn!");
/* 82:79 */       player.setCompassTarget(player.getWorld().getSpawnLocation());
/* 83:   */     }
/* 84:81 */     return false;
/* 85:   */   }
/* 86:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.SpawnCommand
 * JD-Core Version:    0.7.0.1
 */