/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ 
/* 11:   */ public class TpdenyCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public TpdenyCommand(Main plugin)
/* 17:   */   {
/* 18:16 */     this.plugin = plugin;
/* 19:17 */     this.plugin.getCommand("tpdeny").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:23 */     if (!(sender instanceof Player))
/* 25:   */     {
/* 26:25 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 27:26 */       return true;
/* 28:   */     }
/* 29:28 */     if (args.length == 0)
/* 30:   */     {
/* 31:30 */       Player p = (Player)sender;
/* 32:31 */       if (!this.plugin.tpaCommand.tpaPlayer.containsKey(p))
/* 33:   */       {
/* 34:33 */         sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
/* 35:34 */         return true;
/* 36:   */       }
/* 37:36 */       Player other = (Player)this.plugin.tpaCommand.tpaPlayer.get(p);
/* 38:37 */       if (other == null)
/* 39:   */       {
/* 40:39 */         sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
/* 41:40 */         return true;
/* 42:   */       }
/* 43:42 */       if (!this.plugin.tpaCommand.tpaTime.containsKey(other))
/* 44:   */       {
/* 45:44 */         sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
/* 46:45 */         return true;
/* 47:   */       }
/* 48:47 */       if (System.currentTimeMillis() >= ((Long)this.plugin.tpaCommand.tpaTime.get(other)).longValue())
/* 49:   */       {
/* 50:49 */         sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
/* 51:50 */         return true;
/* 52:   */       }
/* 53:52 */       this.plugin.tpaCommand.tpaPlayer.remove(p);
/* 54:53 */       this.plugin.tpaCommand.tpaTime.remove(other);
/* 55:54 */       p.sendMessage("§6Odrzuciles teleportacji od gracza §c" + other.getName());
/* 56:55 */       other.sendMessage("§c" + p.getName() + " §6odrzucil prosbe teleportacji!");
/* 57:   */     }
/* 58:   */     else
/* 59:   */     {
/* 60:59 */       sender.sendMessage("§cPoprawne uzycie: §6/tpdeny");
/* 61:   */     }
/* 62:61 */     return false;
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.TpdenyCommand
 * JD-Core Version:    0.7.0.1
 */