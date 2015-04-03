/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ 
/* 10:   */ public class HelpCommand
/* 11:   */   implements CommandExecutor
/* 12:   */ {
/* 13:   */   Main plugin;
/* 14:   */   
/* 15:   */   public HelpCommand(Main plugin)
/* 16:   */   {
/* 17:15 */     this.plugin = plugin;
/* 18:16 */     this.plugin.getCommand("help").setExecutor(this);
/* 19:   */   }
/* 20:   */   
/* 21:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 22:   */   {
/* 23:22 */     for (String help : this.plugin.config.helpMessages) {
/* 24:24 */       sender.sendMessage(this.plugin.fix(help));
/* 25:   */     }
/* 26:27 */     return false;
/* 27:   */   }
/* 28:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.HelpCommand
 * JD-Core Version:    0.7.0.1
 */