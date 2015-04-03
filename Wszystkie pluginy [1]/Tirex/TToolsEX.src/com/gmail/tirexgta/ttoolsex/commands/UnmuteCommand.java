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
/* 13:   */ public class UnmuteCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public UnmuteCommand(Main plugin)
/* 19:   */   {
/* 20:19 */     this.plugin = plugin;
/* 21:20 */     this.plugin.getCommand("unmute").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:27 */     if (args.length == 1)
/* 27:   */     {
/* 28:29 */       String nick = args[0];
/* 29:30 */       Player other = Bukkit.getPlayerExact(nick);
/* 30:31 */       DataUser user = Datasource.getUserByNick(nick);
/* 31:32 */       if (user == null)
/* 32:   */       {
/* 33:34 */         sender.sendMessage("§cNie znaleziono gracza!");
/* 34:35 */         return true;
/* 35:   */       }
/* 36:37 */       if (user.getMute() == null)
/* 37:   */       {
/* 38:39 */         sender.sendMessage("§cTen gracz nie ma mute!");
/* 39:40 */         return true;
/* 40:   */       }
/* 41:42 */       user.setMute(null);
/* 42:43 */       user.setMuteTime(0L);
/* 43:44 */       if (other != null) {
/* 44:46 */         other.sendMessage("§7Zostales odciszony przez §c" + sender.getName());
/* 45:   */       }
/* 46:48 */       Bukkit.broadcastMessage("§c" + args[0] + " §7zostal odciszony przez §c" + sender.getName());
/* 47:   */     }
/* 48:   */     else
/* 49:   */     {
/* 50:52 */       sender.sendMessage("§cPoprawne uzycie: §6/unmute <gracz>");
/* 51:   */     }
/* 52:54 */     return false;
/* 53:   */   }
/* 54:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.UnmuteCommand
 * JD-Core Version:    0.7.0.1
 */