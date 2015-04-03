/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.IgnoredManager;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  5:   */ import org.bukkit.Bukkit;
/*  6:   */ import org.bukkit.OfflinePlayer;
/*  7:   */ import org.bukkit.command.Command;
/*  8:   */ import org.bukkit.command.CommandExecutor;
/*  9:   */ import org.bukkit.command.CommandSender;
/* 10:   */ import org.bukkit.command.PluginCommand;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ 
/* 13:   */ public class IgnoreCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public IgnoreCommand(Main plugin)
/* 19:   */   {
/* 20:18 */     this.plugin = plugin;
/* 21:19 */     this.plugin.getCommand("ignore").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:26 */     if (!(sender instanceof Player))
/* 27:   */     {
/* 28:28 */       sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
/* 29:29 */       return true;
/* 30:   */     }
/* 31:31 */     if (args.length != 1)
/* 32:   */     {
/* 33:33 */       sender.sendMessage("§cPoprawne uzycie: §6/ignore <gracz>");
/* 34:34 */       return true;
/* 35:   */     }
/* 36:36 */     Player player = (Player)sender;
/* 37:37 */     String ignoredNick = args[0];
/* 38:38 */     OfflinePlayer ignored = Bukkit.getOfflinePlayer(ignoredNick);
/* 39:39 */     if (ignored == null)
/* 40:   */     {
/* 41:41 */       player.sendMessage("§cTen gracz nie gral nigdy wczesniej!");
/* 42:42 */       return true;
/* 43:   */     }
/* 44:44 */     if (!this.plugin.ignoredManager.isIgnoredByPlayer(player, ignored))
/* 45:   */     {
/* 46:46 */       this.plugin.ignoredManager.addIgnored(player, ignored);
/* 47:47 */       player.sendMessage("§6Dodano gracza §c" + ignored.getName() + " §6do ignorowanych!");
/* 48:   */     }
/* 49:   */     else
/* 50:   */     {
/* 51:51 */       this.plugin.ignoredManager.removeIgnored(player, ignored);
/* 52:52 */       player.sendMessage("§6Usunieto gracza §c" + ignored.getName() + " §6z ignorowanych!");
/* 53:   */     }
/* 54:55 */     return false;
/* 55:   */   }
/* 56:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.IgnoreCommand
 * JD-Core Version:    0.7.0.1
 */