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
/* 11:   */ public class TpCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public TpCommand(Main plugin)
/* 17:   */   {
/* 18:17 */     this.plugin = plugin;
/* 19:18 */     this.plugin.getCommand("tp").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:25 */     if (args.length == 1)
/* 25:   */     {
/* 26:27 */       if (!(sender instanceof Player))
/* 27:   */       {
/* 28:29 */         sender.sendMessage("§cPoprawne uzycie: §6/tp <gracz> <gracz>");
/* 29:30 */         return true;
/* 30:   */       }
/* 31:32 */       Player p = (Player)sender;
/* 32:33 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 33:34 */       if (other == null)
/* 34:   */       {
/* 35:36 */         sender.sendMessage("§cTen gracz nie jest Online!");
/* 36:37 */         return true;
/* 37:   */       }
/* 38:39 */       p.teleport(other.getLocation());
/* 39:40 */       sender.sendMessage("§6Steleportowales sie do §c" + other.getName());
/* 40:   */     }
/* 41:42 */     else if (args.length == 2)
/* 42:   */     {
/* 43:44 */       Player p = Bukkit.getPlayerExact(args[0]);
/* 44:45 */       Player other = Bukkit.getPlayerExact(args[1]);
/* 45:46 */       if (p == null)
/* 46:   */       {
/* 47:48 */         sender.sendMessage("§c" + args[0] + " nie jest Online!");
/* 48:49 */         return true;
/* 49:   */       }
/* 50:51 */       if (other == null)
/* 51:   */       {
/* 52:53 */         sender.sendMessage("§c" + args[1] + " nie jest Online!");
/* 53:54 */         return true;
/* 54:   */       }
/* 55:56 */       p.teleport(other.getLocation());
/* 56:57 */       other.sendMessage("§6Zostales steleportowany do §c" + other.getName() + " §6przez §c" + sender.getName());
/* 57:58 */       sender.sendMessage("§6Steleportowales §c" + p.getName() + " §6do §c" + other.getName());
/* 58:   */     }
/* 59:   */     else
/* 60:   */     {
/* 61:62 */       sender.sendMessage("§cPoprawne uzycie: §6/tp <gracz> <gracz>");
/* 62:   */     }
/* 63:65 */     return false;
/* 64:   */   }
/* 65:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.TpCommand
 * JD-Core Version:    0.7.0.1
 */