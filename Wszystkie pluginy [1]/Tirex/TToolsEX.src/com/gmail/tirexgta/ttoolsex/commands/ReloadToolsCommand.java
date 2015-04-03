/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ 
/* 10:   */ public class ReloadToolsCommand
/* 11:   */   implements CommandExecutor
/* 12:   */ {
/* 13:   */   Main plugin;
/* 14:   */   
/* 15:   */   public ReloadToolsCommand(Main plugin)
/* 16:   */   {
/* 17:15 */     this.plugin = plugin;
/* 18:16 */     this.plugin.getCommand("reloadtools").setExecutor(this);
/* 19:   */   }
/* 20:   */   
/* 21:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 22:   */   {
/* 23:22 */     this.plugin.config.save();
/* 24:23 */     this.plugin.config.reload();
/* 25:24 */     sender.sendMessage("§aPlik konfiguracyjny zostal przeladowany!");
/* 26:25 */     return false;
/* 27:   */   }
/* 28:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.ReloadToolsCommand
 * JD-Core Version:    0.7.0.1
 */