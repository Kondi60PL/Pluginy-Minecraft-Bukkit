/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ 
/* 10:   */ public class ListCommand
/* 11:   */   implements CommandExecutor
/* 12:   */ {
/* 13:   */   Main plugin;
/* 14:   */   
/* 15:   */   public ListCommand(Main plugin)
/* 16:   */   {
/* 17:16 */     this.plugin = plugin;
/* 18:17 */     this.plugin.getCommand("list").setExecutor(this);
/* 19:   */   }
/* 20:   */   
/* 21:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 22:   */   {
/* 23:23 */     sender.sendMessage("§9Na serwerze obecnie jest §c" + this.plugin.slot() + "§9/§c" + this.plugin.config.slotManagerSlots + " §9graczy.");
/* 24:24 */     return false;
/* 25:   */   }
/* 26:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.ListCommand
 * JD-Core Version:    0.7.0.1
 */