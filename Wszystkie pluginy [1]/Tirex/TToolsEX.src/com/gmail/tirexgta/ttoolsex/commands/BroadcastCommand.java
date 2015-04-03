/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Bukkit;
/*  5:   */ import org.bukkit.ChatColor;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ 
/* 11:   */ public class BroadcastCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public BroadcastCommand(Main plugin)
/* 17:   */   {
/* 18:16 */     this.plugin = plugin;
/* 19:17 */     plugin.getCommand("broadcast").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:23 */     if (args.length < 0)
/* 25:   */     {
/* 26:25 */       sender.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GOLD + "/broadcast <wiadomosc>");
/* 27:26 */       return true;
/* 28:   */     }
/* 29:28 */     StringBuilder sb = new StringBuilder();
/* 30:29 */     for (int i = 0; i < args.length; i++) {
/* 31:31 */       sb.append(args[i]).append(" ");
/* 32:   */     }
/* 33:33 */     String message = sb.toString();
/* 34:34 */     Bukkit.broadcastMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Ogloszenie" + ChatColor.GOLD + "] " + ChatColor.GREEN + this.plugin.fix(message));
/* 35:35 */     return false;
/* 36:   */   }
/* 37:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.BroadcastCommand
 * JD-Core Version:    0.7.0.1
 */