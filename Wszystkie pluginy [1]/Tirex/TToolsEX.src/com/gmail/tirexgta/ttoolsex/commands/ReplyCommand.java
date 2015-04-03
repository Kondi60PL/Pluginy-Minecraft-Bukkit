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
/* 12:   */ public class ReplyCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:16 */   public HashMap<Player, Player> lastMessageSender = new HashMap();
/* 17:   */   
/* 18:   */   public ReplyCommand(Main plugin)
/* 19:   */   {
/* 20:20 */     this.plugin = plugin;
/* 21:21 */     this.plugin.getCommand("reply").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:28 */     if (!(sender instanceof Player))
/* 27:   */     {
/* 28:30 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 29:31 */       return true;
/* 30:   */     }
/* 31:33 */     if (args.length < 1)
/* 32:   */     {
/* 33:35 */       sender.sendMessage("§cPoprawne uzycie: §6/r <wiadomosc>");
/* 34:36 */       return true;
/* 35:   */     }
/* 36:38 */     Player player = (Player)sender;
/* 37:39 */     if (!this.lastMessageSender.containsKey(player))
/* 38:   */     {
/* 39:41 */       sender.sendMessage("§cNie masz komu odpisac!");
/* 40:42 */       return true;
/* 41:   */     }
/* 42:44 */     Player other = Bukkit.getPlayerExact(((Player)this.lastMessageSender.get(player)).getName());
/* 43:45 */     if (other == null)
/* 44:   */     {
/* 45:47 */       sender.sendMessage("§cTen gracz nie jest Online!");
/* 46:48 */       return true;
/* 47:   */     }
/* 48:50 */     if (this.lastMessageSender.containsKey(player)) {
/* 49:52 */       this.lastMessageSender.remove(player);
/* 50:   */     }
/* 51:54 */     if (this.lastMessageSender.containsKey(other)) {
/* 52:56 */       this.lastMessageSender.remove(other);
/* 53:   */     }
/* 54:58 */     this.lastMessageSender.put(player, other);
/* 55:59 */     this.lastMessageSender.put(other, player);
/* 56:60 */     StringBuilder sb = new StringBuilder();
/* 57:62 */     for (int i = 0; i < args.length; i++) {
/* 58:64 */       sb.append(args[i]).append(" ");
/* 59:   */     }
/* 60:66 */     String msg = sb.toString();
/* 61:67 */     other.sendMessage("§6[§7" + player.getName() + " §6-> §7ja §6]  §7" + this.plugin.fix(msg));
/* 62:68 */     player.sendMessage("§6[§7ja §6-> §7" + other.getName() + " §6]  §7" + this.plugin.fix(msg));
/* 63:   */     
/* 64:70 */     return false;
/* 65:   */   }
/* 66:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.ReplyCommand
 * JD-Core Version:    0.7.0.1
 */