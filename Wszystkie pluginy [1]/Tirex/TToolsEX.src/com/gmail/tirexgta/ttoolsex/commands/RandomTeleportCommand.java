/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.listeners.RandomTeleportListener;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ 
/* 12:   */ public class RandomTeleportCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:   */   
/* 17:   */   public RandomTeleportCommand(Main plugin)
/* 18:   */   {
/* 19:17 */     this.plugin = plugin;
/* 20:18 */     this.plugin.getCommand("randomtp").setExecutor(this);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 24:   */   {
/* 25:24 */     if (!(sender instanceof Player))
/* 26:   */     {
/* 27:26 */       sender.sendMessage("§cTa komenda nie moze byc wykonana z konsoli!");
/* 28:27 */       return true;
/* 29:   */     }
/* 30:29 */     if (args.length != 1)
/* 31:   */     {
/* 32:31 */       sender.sendMessage("§cDostepne argumenty: §6add, delete, addgroups, deletegroups");
/* 33:32 */       return true;
/* 34:   */     }
/* 35:34 */     if (args[0].equalsIgnoreCase("add"))
/* 36:   */     {
/* 37:36 */       if (!this.plugin.randomTeleportListener.hasTypedCommand.containsKey((Player)sender)) {
/* 38:37 */         this.plugin.randomTeleportListener.hasTypedCommand.put((Player)sender, "add");
/* 39:   */       }
/* 40:38 */       sender.sendMessage("§9Kliknij na guzik, ktory chcesz, aby byl losowym teleporterem.");
/* 41:39 */       return true;
/* 42:   */     }
/* 43:41 */     if (args[0].equalsIgnoreCase("delete"))
/* 44:   */     {
/* 45:43 */       if (!this.plugin.randomTeleportListener.hasTypedCommand.containsKey((Player)sender)) {
/* 46:44 */         this.plugin.randomTeleportListener.hasTypedCommand.put((Player)sender, "delete");
/* 47:   */       }
/* 48:45 */       sender.sendMessage("§9Kliknij na guzik, ktory chcesz, aby nie byl losowym teleporterem.");
/* 49:46 */       return true;
/* 50:   */     }
/* 51:48 */     if (args[0].equalsIgnoreCase("addgroups"))
/* 52:   */     {
/* 53:50 */       if (!this.plugin.randomTeleportListener.hasTypedCommand.containsKey((Player)sender)) {
/* 54:51 */         this.plugin.randomTeleportListener.hasTypedCommand.put((Player)sender, "addgroups");
/* 55:   */       }
/* 56:52 */       sender.sendMessage("§9Kliknij na guzik, ktory chcesz, aby byl grupowym losowym teleporterem.");
/* 57:53 */       return true;
/* 58:   */     }
/* 59:55 */     if (args[0].equalsIgnoreCase("deletegroups"))
/* 60:   */     {
/* 61:57 */       if (!this.plugin.randomTeleportListener.hasTypedCommand.containsKey((Player)sender)) {
/* 62:58 */         this.plugin.randomTeleportListener.hasTypedCommand.put((Player)sender, "deletegroups");
/* 63:   */       }
/* 64:59 */       sender.sendMessage("§9Kliknij na guzik, ktory chcesz, aby nie byl grupowym losowym teleporterem.");
/* 65:60 */       return true;
/* 66:   */     }
/* 67:64 */     sender.sendMessage("§cDostepne argumenty: §6add, delete, addgroups, deletegroups");
/* 68:65 */     return true;
/* 69:   */   }
/* 70:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.RandomTeleportCommand
 * JD-Core Version:    0.7.0.1
 */