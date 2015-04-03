/*   1:    */ package com.gmail.tirexgta.ttoolsex.commands;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import com.gmail.tirexgta.ttoolsex.database.DataBan;
/*   5:    */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*   6:    */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*   7:    */ import java.text.SimpleDateFormat;
/*   8:    */ import java.util.Date;
/*   9:    */ import org.bukkit.Bukkit;
/*  10:    */ import org.bukkit.GameMode;
/*  11:    */ import org.bukkit.command.Command;
/*  12:    */ import org.bukkit.command.CommandExecutor;
/*  13:    */ import org.bukkit.command.CommandSender;
/*  14:    */ import org.bukkit.command.PluginCommand;
/*  15:    */ import org.bukkit.entity.Player;
/*  16:    */ 
/*  17:    */ public class BanCommand
/*  18:    */   implements CommandExecutor
/*  19:    */ {
/*  20:    */   Main plugin;
/*  21:    */   
/*  22:    */   public BanCommand(Main plugin)
/*  23:    */   {
/*  24: 24 */     this.plugin = plugin;
/*  25: 25 */     this.plugin.getCommand("ban").setExecutor(this);
/*  26:    */   }
/*  27:    */   
/*  28:    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*  29:    */   {
/*  30: 32 */     if (args.length > 2)
/*  31:    */     {
/*  32: 34 */       Player other = Bukkit.getPlayer(args[0]);
/*  33: 35 */       if (other != null) {
/*  34: 37 */         if (other.hasPermission("tirex.ban.bypass"))
/*  35:    */         {
/*  36: 39 */           sender.sendMessage("§cTego gracze nie mozesz zbanowac!");
/*  37: 40 */           return true;
/*  38:    */         }
/*  39:    */       }
/*  40: 44 */       StringBuilder sb = new StringBuilder();
/*  41: 45 */       for (int i = 2; i < args.length; i++) {
/*  42: 47 */         sb.append(args[i]).append(" ");
/*  43:    */       }
/*  44: 49 */       String banReason = sb.toString();
/*  45: 50 */       String bannedDisplayName = args[0];
/*  46: 51 */       if (other != null) {
/*  47: 53 */         bannedDisplayName = other.getDisplayName();
/*  48:    */       }
/*  49: 55 */       DataBan ban = this.plugin.data.getBanData(args[0]);
/*  50: 56 */       boolean isBanned = ban != null;
/*  51: 57 */       if ((ban != null) && (ban.getTime().longValue() != 0L))
/*  52:    */       {
/*  53: 59 */         sender.sendMessage("§cGracz o podanym nicku jest juz zbanowany!");
/*  54: 60 */         return true;
/*  55:    */       }
/*  56: 62 */       DataUser user = Datasource.getUserByNick(args[0]);
/*  57: 63 */       if (user == null)
/*  58:    */       {
/*  59: 65 */         user = this.plugin.data.createUser();
/*  60: 66 */         user.setNick(args[0]);
/*  61: 67 */         user.setFly(false);
/*  62: 68 */         user.setGod(false);
/*  63: 69 */         user.setGamemode(GameMode.SURVIVAL);
/*  64: 70 */         user.setWorld("world");
/*  65: 71 */         user.setX(0);
/*  66: 72 */         user.setY(0);
/*  67: 73 */         user.setZ(0);
/*  68: 74 */         user.insert();
/*  69:    */       }
/*  70: 76 */       if (!isBanned) {
/*  71: 78 */         ban = this.plugin.data.createBan();
/*  72:    */       }
/*  73: 80 */       long banTime = System.currentTimeMillis() + Main.stringToTime(args[1]);
/*  74: 81 */       ban.setReason(banReason);
/*  75: 82 */       ban.setTime(Long.valueOf(banTime));
/*  76: 83 */       ban.setUser(user);
/*  77: 84 */       DataUser admin = Datasource.getUserByNick(sender.getName());
/*  78: 85 */       if (admin != null) {
/*  79: 87 */         ban.setAdmin(admin);
/*  80:    */       }
/*  81: 90 */       if (isBanned) {
/*  82: 92 */         ban.update();
/*  83:    */       } else {
/*  84: 96 */         ban.insert();
/*  85:    */       }
/*  86: 98 */       Date date = new Date(ban.getTime().longValue());
/*  87: 99 */       SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  88:100 */       String timeShow = dt.format(date);
/*  89:    */       
/*  90:102 */       String displayName = "CONSOLE";
/*  91:103 */       if ((sender instanceof Player)) {
/*  92:105 */         displayName = sender.getName();
/*  93:    */       }
/*  94:107 */       if (other != null) {
/*  95:109 */         other.kickPlayer("§cZostales zbanowany do §6" + timeShow + "§c.\n§cPowod: §6" + banReason + "\n§cPrzez: §6" + displayName);
/*  96:    */       }
/*  97:111 */       Bukkit.broadcastMessage("§c" + bannedDisplayName + " §7zostal zbanowany przez §c" + displayName + "§7. Powod: §c" + banReason + "§7. Do: §c" + timeShow);
/*  98:    */     }
/*  99:    */     else
/* 100:    */     {
/* 101:115 */       sender.sendMessage("§cPoprawne uzycie: §6/ban <nick> <czas> <powod>");
/* 102:116 */       return true;
/* 103:    */     }
/* 104:118 */     return false;
/* 105:    */   }
/* 106:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.BanCommand
 * JD-Core Version:    0.7.0.1
 */