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
/* 11:   */ public class KickallCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public KickallCommand(Main plugin)
/* 17:   */   {
/* 18:17 */     this.plugin = plugin;
/* 19:18 */     this.plugin.getCommand("kickall").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:24 */     StringBuilder sb = new StringBuilder("§8[§9Kick§aAll§8]§r\n");
/* 25:25 */     for (int i = 0; i < args.length; i++) {
/* 26:27 */       sb.append(args[i]).append(" ");
/* 27:   */     }
/* 28:29 */     String arg = sb.toString();
/* 29:30 */     for (Player online : Bukkit.getOnlinePlayers()) {
/* 30:32 */       if (!online.hasPermission("tirex.kickall.bypass")) {
/* 31:34 */         online.kickPlayer(this.plugin.fix(arg));
/* 32:   */       }
/* 33:   */     }
/* 34:37 */     return false;
/* 35:   */   }
/* 36:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.KickallCommand
 * JD-Core Version:    0.7.0.1
 */