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
/* 11:   */ public class FlyCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public FlyCommand(Main plugin)
/* 17:   */   {
/* 18:17 */     this.plugin = plugin;
/* 19:18 */     this.plugin.getCommand("fly").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:26 */     if (args.length == 0)
/* 25:   */     {
/* 26:28 */       if (!(sender instanceof Player))
/* 27:   */       {
/* 28:30 */         sender.sendMessage("§cPoprawne uzycie: §6/fly <gracz>");
/* 29:31 */         return true;
/* 30:   */       }
/* 31:33 */       Player player = (Player)sender;
/* 32:34 */       if (!player.getAllowFlight())
/* 33:   */       {
/* 34:36 */         player.setAllowFlight(true);
/* 35:37 */         player.sendMessage("§6Tryb latania §awlaczony§6!");
/* 36:38 */         return true;
/* 37:   */       }
/* 38:40 */       player.setAllowFlight(false);
/* 39:41 */       player.sendMessage("§6Tryb latania §cwylaczony§6!");
/* 40:42 */       return true;
/* 41:   */     }
/* 42:44 */     if (args.length == 1)
/* 43:   */     {
/* 44:46 */       if (!sender.hasPermission("tirex.fly"))
/* 45:   */       {
/* 46:48 */         sender.sendMessage("§cNie masz uprawnien!");
/* 47:49 */         return true;
/* 48:   */       }
/* 49:51 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 50:52 */       if (other == null)
/* 51:   */       {
/* 52:54 */         sender.sendMessage("§cTen gracz nie jest Online!");
/* 53:55 */         return true;
/* 54:   */       }
/* 55:57 */       if (!other.getAllowFlight())
/* 56:   */       {
/* 57:59 */         other.setAllowFlight(true);
/* 58:60 */         other.sendMessage("§6Tryb latania §awlaczony §6przez §c" + sender.getName() + " §6!");
/* 59:61 */         sender.sendMessage("§6Tryb latania §awlaczony §6dla §c" + other.getName() + "§6!");
/* 60:62 */         return true;
/* 61:   */       }
/* 62:64 */       other.setAllowFlight(false);
/* 63:65 */       other.sendMessage("§6Tryb latania §cwylaczony §6przez §c" + sender.getName() + " §6!");
/* 64:66 */       sender.sendMessage("§6Tryb latania §cwylaczony §6dla §c" + other.getName() + "§6!");
/* 65:67 */       return true;
/* 66:   */     }
/* 67:72 */     sender.sendMessage("§cPoprawne uzycie: §6/fly <gracz>");
/* 68:73 */     return true;
/* 69:   */   }
/* 70:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.FlyCommand
 * JD-Core Version:    0.7.0.1
 */