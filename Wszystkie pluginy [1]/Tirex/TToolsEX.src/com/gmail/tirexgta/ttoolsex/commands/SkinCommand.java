/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.SkinChangeManager;
/*  5:   */ import org.bukkit.Bukkit;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ 
/* 12:   */ public class SkinCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:   */   private SkinChangeManager factory;
/* 17:   */   
/* 18:   */   public SkinCommand(Main plugin)
/* 19:   */   {
/* 20:19 */     this.plugin = plugin;
/* 21:20 */     this.plugin.getCommand("skin").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:28 */     if (args.length == 1)
/* 27:   */     {
/* 28:30 */       if (!(sender instanceof Player))
/* 29:   */       {
/* 30:32 */         sender.sendMessage("§cPoprawne uzycie: §6/skin <gracz> <skinGracza>");
/* 31:33 */         return true;
/* 32:   */       }
/* 33:35 */       Player p = (Player)sender;
/* 34:36 */       this.factory = new SkinChangeManager(this.plugin);
/* 35:37 */       this.factory.changeDisplay(p.getName(), "MrTrolekk", args[0]);
/* 36:38 */       sender.sendMessage("§aMasz teraz skin gracza §e" + args[0]);
/* 37:   */     }
/* 38:40 */     else if (args.length == 2)
/* 39:   */     {
/* 40:42 */       if (!sender.hasPermission("tirex.skin.other"))
/* 41:   */       {
/* 42:44 */         sender.sendMessage("§cPoprawne uzycie: §6/skin <skinGracza>");
/* 43:45 */         return true;
/* 44:   */       }
/* 45:47 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 46:48 */       if (other == null)
/* 47:   */       {
/* 48:50 */         sender.sendMessage("§cTen Gracz nie jest Online!");
/* 49:51 */         return true;
/* 50:   */       }
/* 51:53 */       this.factory = new SkinChangeManager(this.plugin);
/* 52:54 */       this.factory.changeDisplay("dada", "Dinnerbone", "Any name here");
/* 53:55 */       sender.sendMessage("§aUstawiles skin gracza §e" + args[1] + " §adla §e" + other.getName());
/* 54:   */     }
/* 55:59 */     else if (!(sender instanceof Player))
/* 56:   */     {
/* 57:61 */       sender.sendMessage("§cPoprawne uzycie: §6/skin <gracz> <skinGracza>");
/* 58:   */     }
/* 59:   */     else
/* 60:   */     {
/* 61:65 */       sender.sendMessage("§cPoprawne uzycie: §6/skin <skinGracza>");
/* 62:   */     }
/* 63:68 */     return false;
/* 64:   */   }
/* 65:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.SkinCommand
 * JD-Core Version:    0.7.0.1
 */