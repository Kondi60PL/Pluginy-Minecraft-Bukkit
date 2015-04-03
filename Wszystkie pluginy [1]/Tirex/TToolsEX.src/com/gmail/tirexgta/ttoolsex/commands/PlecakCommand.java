/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.BackpackManager;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ 
/* 11:   */ public class PlecakCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public PlecakCommand(Main plugin)
/* 17:   */   {
/* 18:16 */     this.plugin = plugin;
/* 19:17 */     this.plugin.getCommand("plecak").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:23 */     if (!(sender instanceof Player)) {
/* 25:25 */       sender.sendMessage("§4Ta komenda nie moze byc wykonana z konsoli!");
/* 26:   */     }
/* 27:27 */     this.plugin.backpackManager.openPlecak((Player)sender, sender.getName(), sender.getName());
/* 28:28 */     return false;
/* 29:   */   }
/* 30:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.PlecakCommand
 * JD-Core Version:    0.7.0.1
 */