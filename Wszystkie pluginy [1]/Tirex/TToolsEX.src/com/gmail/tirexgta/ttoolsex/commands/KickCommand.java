/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Bukkit;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ 
/* 11:   */ public class KickCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public KickCommand(Main plugin)
/* 17:   */   {
/* 18:17 */     this.plugin = plugin;
/* 19:18 */     this.plugin.getCommand("kick").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:25 */     if (args.length <= 1)
/* 25:   */     {
/* 26:27 */       sender.sendMessage("§cPoprawne uzycie: §6/kick <gracz> <powod>");
/* 27:28 */       return true;
/* 28:   */     }
/* 29:30 */     Player other = Bukkit.getPlayerExact(args[0]);
/* 30:31 */     if (other == null)
/* 31:   */     {
/* 32:33 */       sender.sendMessage("§cTen gracz nie jest Online!");
/* 33:34 */       return true;
/* 34:   */     }
/* 35:36 */     if (other.hasPermission("tirex.kick.bypass"))
/* 36:   */     {
/* 37:38 */       sender.sendMessage("§cTen gracz nie moze byc wyrzucony!");
/* 38:39 */       return true;
/* 39:   */     }
/* 40:42 */     StringBuilder sb = new StringBuilder();
/* 41:43 */     for (int i = 1; i < args.length; i++) {
/* 42:45 */       sb.append(args[i]).append(" ");
/* 43:   */     }
/* 44:47 */     String kickReason = sb.toString();
/* 45:48 */     other.kickPlayer("§cZostales wyrzucony z serwera.\n§cPowod: §6" + kickReason + "\n§cPrzez: §6" + sender.getName());
/* 46:49 */     Bukkit.broadcastMessage("§c" + other.getName() + "§7 zostal wyrzucony przez §c" + sender.getName() + "§7. Powod: §c" + kickReason);
/* 47:50 */     return false;
/* 48:   */   }
/* 49:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.KickCommand
 * JD-Core Version:    0.7.0.1
 */