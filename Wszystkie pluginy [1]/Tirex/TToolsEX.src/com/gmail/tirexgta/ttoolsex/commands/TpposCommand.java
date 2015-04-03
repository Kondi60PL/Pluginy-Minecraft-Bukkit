/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  5:   */ import org.bukkit.Location;
/*  6:   */ import org.bukkit.World;
/*  7:   */ import org.bukkit.command.Command;
/*  8:   */ import org.bukkit.command.CommandExecutor;
/*  9:   */ import org.bukkit.command.CommandSender;
/* 10:   */ import org.bukkit.command.PluginCommand;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ 
/* 13:   */ public class TpposCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public TpposCommand(Main plugin)
/* 19:   */   {
/* 20:17 */     this.plugin = plugin;
/* 21:18 */     this.plugin.getCommand("tppos").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:24 */     if (!(sender instanceof Player))
/* 27:   */     {
/* 28:26 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 29:27 */       return true;
/* 30:   */     }
/* 31:29 */     if (args.length == 2)
/* 32:   */     {
/* 33:31 */       Player p = (Player)sender;
/* 34:32 */       if (!Main.isInteger(args[0]))
/* 35:   */       {
/* 36:34 */         sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <z>");
/* 37:35 */         return true;
/* 38:   */       }
/* 39:37 */       if (!Main.isInteger(args[1]))
/* 40:   */       {
/* 41:39 */         sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <z>");
/* 42:40 */         return true;
/* 43:   */       }
/* 44:42 */       int x = Integer.parseInt(args[0]);
/* 45:43 */       int z = Integer.parseInt(args[1]);
/* 46:44 */       int y = p.getWorld().getHighestBlockYAt(x, z);
/* 47:45 */       Location loc = new Location(p.getWorld(), x + 0.5D, y, z + 0.5D);
/* 48:46 */       if (p.hasPermission("tirex.tppos.nodelay"))
/* 49:   */       {
/* 50:48 */         p.teleport(loc);
/* 51:49 */         p.sendMessage("§6Przeteleportowales sie na koordynaty\n§6x: §c" + x + " §6y: §c" + y + " §6z: §c" + z);
/* 52:50 */         return true;
/* 53:   */       }
/* 54:52 */       p.sendMessage("§6Teleport rozgrzewa sie...");
/* 55:53 */       Main.teleportPlayerWithDelay(p, this.plugin.config.teleportDelay, loc, "§6Przeteleportowales sie na koordynaty\n§6x: §c" + x + " §6y: §c" + y + " §6z: §c" + z, null);
/* 56:   */     }
/* 57:55 */     else if (args.length == 3)
/* 58:   */     {
/* 59:57 */       Player p = (Player)sender;
/* 60:58 */       if (!Main.isInteger(args[0]))
/* 61:   */       {
/* 62:60 */         sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <y> <z>");
/* 63:61 */         return true;
/* 64:   */       }
/* 65:63 */       if (!Main.isInteger(args[1]))
/* 66:   */       {
/* 67:65 */         sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <y> <z>");
/* 68:66 */         return true;
/* 69:   */       }
/* 70:68 */       if (!Main.isInteger(args[2]))
/* 71:   */       {
/* 72:70 */         sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> <y> <z>");
/* 73:71 */         return true;
/* 74:   */       }
/* 75:73 */       int x = Integer.parseInt(args[0]);
/* 76:74 */       int y = Integer.parseInt(args[1]);
/* 77:75 */       int z = Integer.parseInt(args[2]);
/* 78:76 */       Location loc = new Location(p.getWorld(), x + 0.5D, y, z + 0.5D);
/* 79:77 */       if (p.hasPermission("tirex.tppos.nodelay"))
/* 80:   */       {
/* 81:79 */         p.teleport(loc);
/* 82:80 */         p.sendMessage("§6Przeteleportowales sie na koordynaty\n§6x: §c" + x + " §6y: §c" + y + " §6z: §c" + z);
/* 83:81 */         return true;
/* 84:   */       }
/* 85:83 */       p.sendMessage("§6Teleport rozgrzewa sie...");
/* 86:84 */       Main.teleportPlayerWithDelay(p, this.plugin.config.teleportDelay, loc, "§6Przeteleportowales sie na koordynaty\n§6x: §c" + x + " §6y: §c" + y + " §6z: §c" + z, null);
/* 87:   */     }
/* 88:   */     else
/* 89:   */     {
/* 90:88 */       sender.sendMessage("§cPoprawne uzycie: §6/tppos <x> [y] <z>");
/* 91:   */     }
/* 92:90 */     return false;
/* 93:   */   }
/* 94:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.TpposCommand
 * JD-Core Version:    0.7.0.1
 */