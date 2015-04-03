/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  6:   */ import org.bukkit.Bukkit;
/*  7:   */ import org.bukkit.command.Command;
/*  8:   */ import org.bukkit.command.CommandExecutor;
/*  9:   */ import org.bukkit.command.CommandSender;
/* 10:   */ import org.bukkit.command.PluginCommand;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ 
/* 13:   */ public class GodCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public GodCommand(Main plugin)
/* 19:   */   {
/* 20:19 */     this.plugin = plugin;
/* 21:20 */     this.plugin.getCommand("god").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:27 */     if (args.length == 0)
/* 27:   */     {
/* 28:29 */       if (!(sender instanceof Player))
/* 29:   */       {
/* 30:31 */         sender.sendMessage("§cPoprawne uzycie: §6/god <gracz>");
/* 31:32 */         return true;
/* 32:   */       }
/* 33:34 */       Player player = (Player)sender;
/* 34:36 */       if (!Datasource.getUserData(player).getGod())
/* 35:   */       {
/* 36:38 */         Datasource.getUserData(player).setGod(true);
/* 37:39 */         player.sendMessage("§6GodMode §awlaczony§6!");
/* 38:   */       }
/* 39:41 */       else if (Datasource.getUserData(player).getGod())
/* 40:   */       {
/* 41:43 */         Datasource.getUserData(player).setGod(false);
/* 42:44 */         player.sendMessage("§6GodMode §cwylaczony§6!");
/* 43:   */       }
/* 44:   */     }
/* 45:47 */     else if (args.length == 1)
/* 46:   */     {
/* 47:49 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 48:50 */       if (other == null)
/* 49:   */       {
/* 50:52 */         sender.sendMessage("§cTen gracz nie jest Online!");
/* 51:53 */         return true;
/* 52:   */       }
/* 53:56 */       if (!Datasource.getUserData(other).getGod())
/* 54:   */       {
/* 55:58 */         Datasource.getUserData(other).setGod(true);
/* 56:59 */         other.sendMessage("§6GodMode §awlaczony §6przez gracza §c" + sender.getName());
/* 57:60 */         sender.sendMessage("§6GodMode §awlaczony §6dla gracza §c" + other.getName());
/* 58:   */       }
/* 59:62 */       else if (Datasource.getUserData(other).getGod())
/* 60:   */       {
/* 61:64 */         Datasource.getUserData(other).setGod(false);
/* 62:65 */         other.sendMessage("§6GodMode §cwylaczony §6przez gracza §c" + sender.getName());
/* 63:66 */         sender.sendMessage("§6GodMode §cwylaczony §6dla gracza §c" + other.getName());
/* 64:   */       }
/* 65:   */     }
/* 66:   */     else
/* 67:   */     {
/* 68:71 */       sender.sendMessage("§cPoprawne uzycie: §6/god <gracz>");
/* 69:   */     }
/* 70:74 */     return false;
/* 71:   */   }
/* 72:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.GodCommand
 * JD-Core Version:    0.7.0.1
 */