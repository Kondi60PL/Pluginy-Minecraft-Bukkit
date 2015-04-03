/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.RangManager;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  6:   */ import net.milkbowl.vault.permission.Permission;
/*  7:   */ import org.bukkit.Bukkit;
/*  8:   */ import org.bukkit.OfflinePlayer;
/*  9:   */ import org.bukkit.Server;
/* 10:   */ import org.bukkit.command.Command;
/* 11:   */ import org.bukkit.command.CommandExecutor;
/* 12:   */ import org.bukkit.command.CommandSender;
/* 13:   */ import org.bukkit.command.PluginCommand;
/* 14:   */ import org.bukkit.entity.Player;
/* 15:   */ 
/* 16:   */ public class RangaCommand
/* 17:   */   implements CommandExecutor
/* 18:   */ {
/* 19:   */   Main plugin;
/* 20:   */   Config config;
/* 21:   */   
/* 22:   */   public RangaCommand(Main plugin)
/* 23:   */   {
/* 24:23 */     this.plugin = plugin;
/* 25:24 */     this.plugin.getCommand("ranga").setExecutor(this);
/* 26:   */   }
/* 27:   */   
/* 28:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 29:   */   {
/* 30:32 */     if (args.length != 3)
/* 31:   */     {
/* 32:34 */       sender.sendMessage("§cPoprawne uzycie: §6/ranga <gracz> <czas> <ranga>");
/* 33:35 */       return true;
/* 34:   */     }
/* 35:37 */     String name = args[0];
/* 36:38 */     String nameLow = name.toLowerCase();
/* 37:39 */     String ranga = args[2];
/* 38:   */     
/* 39:41 */     Permission chat = Main.chat;
/* 40:42 */     String groups = null;
/* 41:43 */     for (String group : chat.getGroups()) {
/* 42:45 */       if (group.equals(ranga)) {
/* 43:47 */         groups = group;
/* 44:   */       }
/* 45:   */     }
/* 46:50 */     if (groups == null)
/* 47:   */     {
/* 48:52 */       sender.sendMessage("§4Nie ma takiej rangi!");
/* 49:53 */       return true;
/* 50:   */     }
/* 51:56 */     Player p = Bukkit.getPlayerExact(nameLow);
/* 52:57 */     if (p == null)
/* 53:   */     {
/* 54:59 */       sender.sendMessage("§4Tego gracza nie ma online!");
/* 55:60 */       return true;
/* 56:   */     }
/* 57:62 */     OfflinePlayer offlineP = this.plugin.getServer().getOfflinePlayer(p.getName());
/* 58:63 */     String groupsPlayer = "";
/* 59:64 */     for (String groupPlayer : chat.getPlayerGroups(p)) {
/* 60:66 */       if (groupPlayer.toLowerCase().equals(this.plugin.rangManager.getRangaNazwa(offlineP).toLowerCase())) {
/* 61:68 */         groupsPlayer = groupPlayer;
/* 62:   */       }
/* 63:   */     }
/* 64:71 */     if (!groupsPlayer.equals("")) {
/* 65:73 */       chat.playerRemoveGroup(p, groupsPlayer);
/* 66:   */     }
/* 67:75 */     chat.playerAddGroup(p, groups);
/* 68:76 */     long time = Main.stringToTime(args[1]) + System.currentTimeMillis();
/* 69:77 */     this.plugin.rangManager.addRang(p, ranga, time);
/* 70:78 */     p.sendMessage("§aOtrzymales range " + ranga + ".\nNie masz uprawnien? Relognij!");
/* 71:79 */     sender.sendMessage("§aPomyslnie dodano range Graczowi!");
/* 72:80 */     return false;
/* 73:   */   }
/* 74:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.RangaCommand
 * JD-Core Version:    0.7.0.1
 */