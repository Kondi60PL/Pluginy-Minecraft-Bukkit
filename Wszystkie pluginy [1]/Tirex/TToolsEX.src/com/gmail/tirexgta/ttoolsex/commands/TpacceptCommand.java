/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.listeners.TeleportCancelListener;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  6:   */ import java.util.HashMap;
/*  7:   */ import java.util.List;
/*  8:   */ import org.bukkit.command.Command;
/*  9:   */ import org.bukkit.command.CommandExecutor;
/* 10:   */ import org.bukkit.command.CommandSender;
/* 11:   */ import org.bukkit.command.PluginCommand;
/* 12:   */ import org.bukkit.entity.Player;
/* 13:   */ 
/* 14:   */ public class TpacceptCommand
/* 15:   */   implements CommandExecutor
/* 16:   */ {
/* 17:   */   Main plugin;
/* 18:   */   
/* 19:   */   public TpacceptCommand(Main plugin)
/* 20:   */   {
/* 21:16 */     this.plugin = plugin;
/* 22:17 */     this.plugin.getCommand("tpaccept").setExecutor(this);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 26:   */   {
/* 27:23 */     if (!(sender instanceof Player))
/* 28:   */     {
/* 29:25 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 30:26 */       return true;
/* 31:   */     }
/* 32:28 */     if (args.length == 0)
/* 33:   */     {
/* 34:30 */       Player p = (Player)sender;
/* 35:31 */       if (this.plugin.teleportCancelListener.teleport.contains(p))
/* 36:   */       {
/* 37:33 */         sender.sendMessage("§cPoczekaj az sie steleportujesz!");
/* 38:34 */         return true;
/* 39:   */       }
/* 40:36 */       if (!this.plugin.tpaCommand.tpaPlayer.containsKey(p))
/* 41:   */       {
/* 42:38 */         sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
/* 43:39 */         return true;
/* 44:   */       }
/* 45:41 */       Player other = (Player)this.plugin.tpaCommand.tpaPlayer.get(p);
/* 46:42 */       if (other == null)
/* 47:   */       {
/* 48:44 */         sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
/* 49:45 */         return true;
/* 50:   */       }
/* 51:47 */       if (!this.plugin.tpaCommand.tpaTime.containsKey(other))
/* 52:   */       {
/* 53:49 */         sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
/* 54:50 */         return true;
/* 55:   */       }
/* 56:52 */       if (System.currentTimeMillis() >= ((Long)this.plugin.tpaCommand.tpaTime.get(other)).longValue())
/* 57:   */       {
/* 58:54 */         sender.sendMessage("§cNie masz oczekujacego zaproszenia do teleportacji!");
/* 59:55 */         return true;
/* 60:   */       }
/* 61:57 */       if (other.hasPermission("tirex.spawn.nodelay"))
/* 62:   */       {
/* 63:59 */         other.teleport(p.getLocation());
/* 64:60 */         other.sendMessage("§c" + other.getName() + " §6zaakceptowal prosbe teleportacji!");
/* 65:61 */         other.sendMessage("§6Przeteleportowano do §c" + p.getName() + "§6!");
/* 66:62 */         return true;
/* 67:   */       }
/* 68:64 */       Main.teleportPlayerWithDelay(other, this.plugin.config.teleportDelay, p.getLocation(), "§6Przeteleportowano do §c + " + p.getName() + "§6!", null);
/* 69:65 */       other.sendMessage("§c" + other.getName() + " §6zaakceptowal prosbe teleportacji!");
/* 70:66 */       other.sendMessage("§6Teleport rozgrzewa sie...");
/* 71:   */     }
/* 72:   */     else
/* 73:   */     {
/* 74:70 */       sender.sendMessage("§cPoprawne uzycie: §6/tpaccept");
/* 75:   */     }
/* 76:72 */     return false;
/* 77:   */   }
/* 78:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.TpacceptCommand
 * JD-Core Version:    0.7.0.1
 */