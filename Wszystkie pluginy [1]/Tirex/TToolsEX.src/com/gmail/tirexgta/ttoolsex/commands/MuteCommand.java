/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  6:   */ import java.text.SimpleDateFormat;
/*  7:   */ import java.util.Date;
/*  8:   */ import org.bukkit.Bukkit;
/*  9:   */ import org.bukkit.command.Command;
/* 10:   */ import org.bukkit.command.CommandExecutor;
/* 11:   */ import org.bukkit.command.CommandSender;
/* 12:   */ import org.bukkit.command.PluginCommand;
/* 13:   */ import org.bukkit.entity.Player;
/* 14:   */ 
/* 15:   */ public class MuteCommand
/* 16:   */   implements CommandExecutor
/* 17:   */ {
/* 18:   */   Main plugin;
/* 19:   */   
/* 20:   */   public MuteCommand(Main plugin)
/* 21:   */   {
/* 22:23 */     this.plugin = plugin;
/* 23:24 */     this.plugin.getCommand("mute").setExecutor(this);
/* 24:   */   }
/* 25:   */   
/* 26:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 27:   */   {
/* 28:31 */     if (args.length <= 2)
/* 29:   */     {
/* 30:33 */       sender.sendMessage("§cPoprawne uzycie: §6/mute <gracz> <czas> <powod>");
/* 31:34 */       return true;
/* 32:   */     }
/* 33:36 */     String nick = args[0];
/* 34:37 */     Player other = Bukkit.getPlayerExact(nick);
/* 35:38 */     if (other != null) {
/* 36:40 */       if (other.hasPermission("tirex.mute.bypass"))
/* 37:   */       {
/* 38:42 */         sender.sendMessage("§cTego gracza nie mozna zmutowac!");
/* 39:43 */         return true;
/* 40:   */       }
/* 41:   */     }
/* 42:46 */     DataUser user = Datasource.getUserByNick(nick);
/* 43:47 */     if (user == null)
/* 44:   */     {
/* 45:49 */       sender.sendMessage("§cNie znaleziono gracza!");
/* 46:50 */       return true;
/* 47:   */     }
/* 48:52 */     StringBuilder sb = new StringBuilder();
/* 49:53 */     for (int i = 2; i < args.length; i++) {
/* 50:55 */       sb.append(args[i]).append(" ");
/* 51:   */     }
/* 52:57 */     String muteReason = sb.toString();
/* 53:58 */     long muteTime = Main.stringToTime(args[1]) + System.currentTimeMillis();
/* 54:59 */     user.setMute(muteReason);
/* 55:60 */     user.setMuteTime(muteTime);
/* 56:61 */     user.update();
/* 57:62 */     Date date = new Date(muteTime);
/* 58:63 */     SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 59:64 */     String timeMuteShow = dt.format(date);
/* 60:65 */     if (other != null) {
/* 61:67 */       other.sendMessage("§7Zostales wyciszony przez §c" + sender.getName() + " §7do §c" + timeMuteShow + "§7. Powod: §c" + muteReason);
/* 62:   */     }
/* 63:69 */     Bukkit.broadcastMessage("§c" + args[0] + " §7zostal wyciszony przez §c" + sender.getName() + " §7do §c" + timeMuteShow + "§7. Powod: §c" + muteReason);
/* 64:   */     
/* 65:71 */     return false;
/* 66:   */   }
/* 67:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.MuteCommand
 * JD-Core Version:    0.7.0.1
 */