/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.listeners.DispensersListener;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ 
/* 12:   */ public class DispenserCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:   */   
/* 17:   */   public DispenserCommand(Main plugin)
/* 18:   */   {
/* 19:16 */     this.plugin = plugin;
/* 20:17 */     this.plugin.getCommand("dispenser").setExecutor(this);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 24:   */   {
/* 25:23 */     if (!(sender instanceof Player))
/* 26:   */     {
/* 27:25 */       sender.sendMessage("§cTa komenda nie moze byc wykonana z konsoli!");
/* 28:26 */       return true;
/* 29:   */     }
/* 30:28 */     if (args.length != 1)
/* 31:   */     {
/* 32:30 */       sender.sendMessage("§cDostepne argumenty: §6add, delete");
/* 33:31 */       return true;
/* 34:   */     }
/* 35:33 */     if (args[0].equalsIgnoreCase("add"))
/* 36:   */     {
/* 37:35 */       this.plugin.dispensersListener.hasTypedCommand.put((Player)sender, "add");
/* 38:36 */       sender.sendMessage("§9Kliknij na dispenser, ktory chcesz, aby byl nieskonczony.");
/* 39:37 */       return true;
/* 40:   */     }
/* 41:39 */     if (args[0].equalsIgnoreCase("delete"))
/* 42:   */     {
/* 43:41 */       this.plugin.dispensersListener.hasTypedCommand.put((Player)sender, "delete");
/* 44:42 */       sender.sendMessage("§9Kliknij na dispenser, ktory chcesz, aby nie byl nieskonczony.");
/* 45:43 */       return true;
/* 46:   */     }
/* 47:47 */     sender.sendMessage("§cDostepne argumenty: §6add, delete");
/* 48:48 */     return true;
/* 49:   */   }
/* 50:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.DispenserCommand
 * JD-Core Version:    0.7.0.1
 */