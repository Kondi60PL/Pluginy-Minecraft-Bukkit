/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  5:   */ import java.util.List;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ 
/* 11:   */ public class MessageCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public MessageCommand(Main plugin)
/* 17:   */   {
/* 18:16 */     this.plugin = plugin;
/* 19:17 */     this.plugin.getCommand("message").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:23 */     if (args.length == 0)
/* 25:   */     {
/* 26:25 */       sender.sendMessage("§cPoprawne uzycie: §6/message <argument>");
/* 27:26 */       return true;
/* 28:   */     }
/* 29:28 */     if (args[0].equalsIgnoreCase("add"))
/* 30:   */     {
/* 31:30 */       if (args.length <= 1)
/* 32:   */       {
/* 33:32 */         sender.sendMessage("§cPoprawne uzycie: §6/message add <wiadomosc>");
/* 34:33 */         return true;
/* 35:   */       }
/* 36:35 */       StringBuilder sb = new StringBuilder();
/* 37:37 */       for (int i = 1; i < args.length; i++) {
/* 38:39 */         sb.append(args[i]).append(" ");
/* 39:   */       }
/* 40:41 */       String message = sb.toString();
/* 41:42 */       this.plugin.config.autoMessageMessages.add(message);
/* 42:43 */       int index = this.plugin.config.autoMessageMessages.indexOf(message);
/* 43:44 */       this.plugin.config.save();
/* 44:45 */       sender.sendMessage("§9Dodales wiadomosc numer §c" + (index + 1) + "§9!");
/* 45:   */     }
/* 46:47 */     else if (args[0].equalsIgnoreCase("delete"))
/* 47:   */     {
/* 48:49 */       if (args.length <= 1)
/* 49:   */       {
/* 50:51 */         sender.sendMessage("§cPoprawne uzycie: §6/message delete <numer>");
/* 51:52 */         return true;
/* 52:   */       }
/* 53:54 */       String indexString = args[1];
/* 54:55 */       if (!Main.isInteger(indexString)) {
/* 55:57 */         sender.sendMessage("§cPoprawne uzycie: §6/message <");
/* 56:   */       }
/* 57:59 */       int index = Integer.parseInt(args[1]) - 1;
/* 58:60 */       this.plugin.config.autoMessageMessages.remove(index);
/* 59:61 */       this.plugin.config.save();
/* 60:62 */       sender.sendMessage("§9Usunieto wiadomosc numer §c" + (index + 1) + "§9!");
/* 61:   */     }
/* 62:64 */     else if (args[0].equalsIgnoreCase("reload"))
/* 63:   */     {
/* 64:66 */       if (args.length != 1)
/* 65:   */       {
/* 66:68 */         sender.sendMessage("§cPoprawne uzycie: §6/message reload");
/* 67:69 */         return true;
/* 68:   */       }
/* 69:71 */       this.plugin.config.reload();
/* 70:72 */       sender.sendMessage("§9Plik konfiguracyjny zostal przeladowany");
/* 71:   */     }
/* 72:   */     else
/* 73:   */     {
/* 74:76 */       sender.sendMessage("§cDostepne argumenty: §6add, delete, reload");
/* 75:   */     }
/* 76:79 */     return false;
/* 77:   */   }
/* 78:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.MessageCommand
 * JD-Core Version:    0.7.0.1
 */