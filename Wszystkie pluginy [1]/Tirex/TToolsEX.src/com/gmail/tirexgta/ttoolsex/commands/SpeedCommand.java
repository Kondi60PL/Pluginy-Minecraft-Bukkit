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
/* 11:   */ public class SpeedCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public SpeedCommand(Main plugin)
/* 17:   */   {
/* 18:17 */     this.plugin = plugin;
/* 19:18 */     this.plugin.getCommand("speed").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:25 */     if (args.length == 1)
/* 25:   */     {
/* 26:27 */       if (!(sender instanceof Player))
/* 27:   */       {
/* 28:29 */         sender.sendMessage("§cPoprawne uzycie: §6/speed <gracz> <predkosc>");
/* 29:30 */         return true;
/* 30:   */       }
/* 31:32 */       String speedString = args[0];
/* 32:33 */       if (!Main.isDouble(speedString))
/* 33:   */       {
/* 34:35 */         sender.sendMessage("§cPoprawne uzycie: §6/speed <gracz> <predkosc>");
/* 35:36 */         return true;
/* 36:   */       }
/* 37:38 */       double speedInteger = Double.parseDouble(speedString);
/* 38:39 */       double speedIntegerFloat = speedInteger / 10.0D;
/* 39:40 */       if (speedIntegerFloat > 1.0D)
/* 40:   */       {
/* 41:42 */         sender.sendMessage("§cMaxymalna wartosc to 10");
/* 42:43 */         return true;
/* 43:   */       }
/* 44:45 */       float speed = (float)speedIntegerFloat;
/* 45:46 */       Player p = (Player)sender;
/* 46:47 */       if (p.isFlying())
/* 47:   */       {
/* 48:49 */         p.setFlySpeed(speed);
/* 49:50 */         p.sendMessage("§6Ustawiles predkosc latania na §c" + speedInteger);
/* 50:   */       }
/* 51:   */       else
/* 52:   */       {
/* 53:54 */         p.setWalkSpeed(speed);
/* 54:55 */         p.sendMessage("§6Ustawiles predkosc chodzenia na §c" + speedInteger);
/* 55:   */       }
/* 56:   */     }
/* 57:58 */     else if (args.length == 2)
/* 58:   */     {
/* 59:60 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 60:61 */       if (other == null)
/* 61:   */       {
/* 62:63 */         sender.sendMessage("§cTen gracz nie jest Online!");
/* 63:64 */         return true;
/* 64:   */       }
/* 65:66 */       String speedString = args[1];
/* 66:67 */       if (!Main.isInteger(speedString))
/* 67:   */       {
/* 68:69 */         sender.sendMessage("§cPoprawne uzycie: §6/speed <gracz> <predkosc>");
/* 69:70 */         return true;
/* 70:   */       }
/* 71:72 */       double speedInteger = Double.parseDouble(speedString);
/* 72:73 */       double speedIntegerFloat = speedInteger / 10.0D;
/* 73:74 */       if (speedIntegerFloat > 1.0D)
/* 74:   */       {
/* 75:76 */         sender.sendMessage("§cMaxymalna wartosc to 10");
/* 76:77 */         return true;
/* 77:   */       }
/* 78:79 */       float speed = (float)speedIntegerFloat;
/* 79:80 */       if (other.isFlying())
/* 80:   */       {
/* 81:82 */         other.setFlySpeed(speed);
/* 82:83 */         other.sendMessage("§6Twoja predkosc latania zostala zmieniona na §c" + speedInteger + " §6przez §c" + sender.getName());
/* 83:84 */         sender.sendMessage("§6Ustawiles predkosc latania gracza " + other.getName() + " na §c" + speedInteger);
/* 84:   */       }
/* 85:   */       else
/* 86:   */       {
/* 87:88 */         other.setWalkSpeed(speed);
/* 88:89 */         other.sendMessage("§6Twoja predkosc chodzenia zostala zmieniona na §c" + speedInteger + " §6przez §c" + sender.getName());
/* 89:90 */         sender.sendMessage("§6Ustawiles predkosc chodzenia gracza " + other.getName() + " na §c" + speedInteger);
/* 90:   */       }
/* 91:   */     }
/* 92:   */     else
/* 93:   */     {
/* 94:95 */       sender.sendMessage("§cPoprawne uzycie: §6/speed <gracz> <predkosc>");
/* 95:   */     }
/* 96:98 */     return false;
/* 97:   */   }
/* 98:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.SpeedCommand
 * JD-Core Version:    0.7.0.1
 */