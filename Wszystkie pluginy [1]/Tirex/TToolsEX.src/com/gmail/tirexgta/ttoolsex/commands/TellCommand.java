/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import org.bukkit.Bukkit;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ 
/* 12:   */ public class TellCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:   */   
/* 17:   */   public TellCommand(Main plugin)
/* 18:   */   {
/* 19:17 */     this.plugin = plugin;
/* 20:18 */     this.plugin.getCommand("tell").setExecutor(this);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 24:   */   {
/* 25:25 */     if (!(sender instanceof Player))
/* 26:   */     {
/* 27:27 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 28:28 */       return true;
/* 29:   */     }
/* 30:30 */     if (args.length < 2)
/* 31:   */     {
/* 32:32 */       sender.sendMessage("§cPoprawne uzycie: §6/tell <gracz> <wiadomosc>");
/* 33:33 */       return true;
/* 34:   */     }
/* 35:35 */     Player p = (Player)sender;
/* 36:36 */     Player other = Bukkit.getPlayerExact(args[0]);
/* 37:37 */     if (other == null)
/* 38:   */     {
/* 39:39 */       sender.sendMessage("§cTen gracz nie jest Online!");
/* 40:40 */       return true;
/* 41:   */     }
/* 42:42 */     if (this.plugin.replyCommand.lastMessageSender.containsKey(p)) {
/* 43:44 */       this.plugin.replyCommand.lastMessageSender.remove(p);
/* 44:   */     }
/* 45:46 */     if (this.plugin.replyCommand.lastMessageSender.containsKey(other)) {
/* 46:48 */       this.plugin.replyCommand.lastMessageSender.remove(other);
/* 47:   */     }
/* 48:50 */     this.plugin.replyCommand.lastMessageSender.put(p, other);
/* 49:51 */     this.plugin.replyCommand.lastMessageSender.put(other, p);
/* 50:   */     
/* 51:53 */     StringBuilder sb = new StringBuilder();
/* 52:55 */     for (int i = 1; i < args.length; i++) {
/* 53:57 */       sb.append(args[i]).append(" ");
/* 54:   */     }
/* 55:59 */     String msg = sb.toString();
/* 56:60 */     other.sendMessage("§6[§7" + p.getName() + " §6-> §7ja §6]  §7" + this.plugin.fix(msg));
/* 57:61 */     p.sendMessage("§6[§7ja §6-> §7" + other.getName() + " §6]  §7" + this.plugin.fix(msg));
/* 58:   */     
/* 59:63 */     return false;
/* 60:   */   }
/* 61:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.TellCommand
 * JD-Core Version:    0.7.0.1
 */