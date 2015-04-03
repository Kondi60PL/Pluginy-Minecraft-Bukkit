/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.command.Command;
/*  5:   */ import org.bukkit.command.CommandExecutor;
/*  6:   */ import org.bukkit.command.CommandSender;
/*  7:   */ import org.bukkit.command.PluginCommand;
/*  8:   */ 
/*  9:   */ public class RangiCommand
/* 10:   */   implements CommandExecutor
/* 11:   */ {
/* 12:   */   Main plugin;
/* 13:   */   
/* 14:   */   public RangiCommand(Main plugin)
/* 15:   */   {
/* 16:15 */     this.plugin = plugin;
/* 17:16 */     this.plugin.getCommand("rangi").setExecutor(this);
/* 18:   */   }
/* 19:   */   
/* 20:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 21:   */   {
/* 22:23 */     sender.sendMessage("§3Dostepne Rangi:");
/* 23:24 */     sender.sendMessage("§3/vip - §7Informacje o ViPie!");
/* 24:25 */     return false;
/* 25:   */   }
/* 26:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.RangiCommand
 * JD-Core Version:    0.7.0.1
 */