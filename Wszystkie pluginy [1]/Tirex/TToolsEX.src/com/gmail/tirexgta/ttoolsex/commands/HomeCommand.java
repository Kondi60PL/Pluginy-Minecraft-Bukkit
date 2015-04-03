/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  6:   */ import com.gmail.tirexgta.ttoolsex.listeners.TeleportCancelListener;
/*  7:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  8:   */ import java.util.List;
/*  9:   */ import org.bukkit.Bukkit;
/* 10:   */ import org.bukkit.Location;
/* 11:   */ import org.bukkit.command.Command;
/* 12:   */ import org.bukkit.command.CommandExecutor;
/* 13:   */ import org.bukkit.command.CommandSender;
/* 14:   */ import org.bukkit.command.PluginCommand;
/* 15:   */ import org.bukkit.entity.Player;
/* 16:   */ 
/* 17:   */ public class HomeCommand
/* 18:   */   implements CommandExecutor
/* 19:   */ {
/* 20:   */   Main plugin;
/* 21:   */   
/* 22:   */   public HomeCommand(Main plugin)
/* 23:   */   {
/* 24:20 */     this.plugin = plugin;
/* 25:21 */     this.plugin.getCommand("home").setExecutor(this);
/* 26:   */   }
/* 27:   */   
/* 28:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 29:   */   {
/* 30:28 */     if (!(sender instanceof Player))
/* 31:   */     {
/* 32:30 */       sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
/* 33:31 */       return true;
/* 34:   */     }
/* 35:33 */     Player player = (Player)sender;
/* 36:34 */     DataUser user = Datasource.getUserData(player);
/* 37:35 */     if (this.plugin.teleportCancelListener.teleport.contains(player))
/* 38:   */     {
/* 39:37 */       player.sendMessage("§cPoczekaj az sie steleportujesz!");
/* 40:38 */       return true;
/* 41:   */     }
/* 42:40 */     if (user.getHomeWorld() == null)
/* 43:   */     {
/* 44:42 */       player.sendMessage("§cNie ustawiles domu!");
/* 45:43 */       return true;
/* 46:   */     }
/* 47:45 */     Location homeLocation = new Location(Bukkit.getWorld(user.getHomeWorld()), user.getHomeX() + 0.5D, user.getHomeY(), user.getHomeZ() + 0.5D);
/* 48:46 */     if (!player.hasPermission("tirex.home.teleport"))
/* 49:   */     {
/* 50:48 */       player.sendMessage("§6Twoj kompas wskazuje teraz na dom.");
/* 51:49 */       player.sendMessage("§6Ranga ViP wymaga do teleportacji do domu!");
/* 52:50 */       player.setCompassTarget(homeLocation);
/* 53:51 */       return true;
/* 54:   */     }
/* 55:53 */     if (player.hasPermission("tirex.home.nodelay"))
/* 56:   */     {
/* 57:55 */       player.sendMessage("§6Przeteleportowano do domu!");
/* 58:56 */       player.teleport(homeLocation);
/* 59:57 */       return true;
/* 60:   */     }
/* 61:59 */     player.sendMessage("§6Teleport rozgrzewa sie...");
/* 62:60 */     if (!this.plugin.teleportCancelListener.teleport.contains(player)) {
/* 63:62 */       this.plugin.teleportCancelListener.teleport.add(player);
/* 64:   */     }
/* 65:64 */     Main.teleportPlayerWithDelay(player, this.plugin.config.teleportDelay, homeLocation, "§6Przeteleportowano do domu!", null);
/* 66:65 */     return false;
/* 67:   */   }
/* 68:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.HomeCommand
 * JD-Core Version:    0.7.0.1
 */