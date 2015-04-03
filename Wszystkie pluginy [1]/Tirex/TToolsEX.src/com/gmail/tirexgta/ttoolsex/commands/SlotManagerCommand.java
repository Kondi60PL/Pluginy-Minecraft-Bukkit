/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ 
/* 10:   */ public class SlotManagerCommand
/* 11:   */   implements CommandExecutor
/* 12:   */ {
/* 13:   */   Main plugin;
/* 14:   */   
/* 15:   */   public SlotManagerCommand(Main plugin)
/* 16:   */   {
/* 17:15 */     this.plugin = plugin;
/* 18:16 */     this.plugin.getCommand("slotmanager").setExecutor(this);
/* 19:   */   }
/* 20:   */   
/* 21:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 22:   */   {
/* 23:22 */     if (args.length < 1)
/* 24:   */     {
/* 25:24 */       sender.sendMessage("§cPoprawne uzycie: §6/slotmanager <argument>");
/* 26:25 */       return true;
/* 27:   */     }
/* 28:27 */     if (args[0].equalsIgnoreCase("motd"))
/* 29:   */     {
/* 30:29 */       if (args.length < 2)
/* 31:   */       {
/* 32:31 */         sender.sendMessage("§cPoprawne uzycie: §6/slotmanager motd <motd>");
/* 33:32 */         return true;
/* 34:   */       }
/* 35:34 */       StringBuilder sb = new StringBuilder();
/* 36:36 */       for (int i = 1; i < args.length; i++) {
/* 37:38 */         sb.append(args[i]).append(" ");
/* 38:   */       }
/* 39:40 */       String motd = sb.toString();
/* 40:   */       
/* 41:42 */       this.plugin.config.slotManagerMotd = motd.replace("$n", "\n");
/* 42:43 */       this.plugin.config.save();
/* 43:44 */       sender.sendMessage("§6Nowe motd: " + this.plugin.fix(motd).replace("$n", "\n"));
/* 44:   */     }
/* 45:46 */     else if (args[0].equalsIgnoreCase("sloty"))
/* 46:   */     {
/* 47:48 */       if (args.length < 2)
/* 48:   */       {
/* 49:50 */         sender.sendMessage("§cPoprawne uzycie: §6/slotmanager sloty <sloty>");
/* 50:51 */         return true;
/* 51:   */       }
/* 52:53 */       String slotyString = args[1];
/* 53:54 */       if (!Main.isInteger(slotyString))
/* 54:   */       {
/* 55:56 */         sender.sendMessage("§cPoprawne uzycie: §6/slotmanager sloty <sloty>");
/* 56:57 */         return true;
/* 57:   */       }
/* 58:59 */       int sloty = Integer.parseInt(slotyString);
/* 59:   */       
/* 60:61 */       this.plugin.config.slotManagerSlots = sloty;
/* 61:62 */       this.plugin.config.save();
/* 62:   */       
/* 63:64 */       sender.sendMessage("§6Aktualnie jest §c" + sloty + " §6slotow.");
/* 64:   */     }
/* 65:   */     else
/* 66:   */     {
/* 67:68 */       sender.sendMessage("§cDostepne argumenty: §6motd, sloty");
/* 68:   */     }
/* 69:70 */     return false;
/* 70:   */   }
/* 71:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.SlotManagerCommand
 * JD-Core Version:    0.7.0.1
 */