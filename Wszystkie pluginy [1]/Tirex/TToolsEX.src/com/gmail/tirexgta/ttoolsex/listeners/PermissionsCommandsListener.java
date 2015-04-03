/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Server;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.entity.Player;
/*  7:   */ import org.bukkit.event.EventHandler;
/*  8:   */ import org.bukkit.event.Listener;
/*  9:   */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/* 10:   */ import org.bukkit.help.HelpMap;
/* 11:   */ import org.bukkit.help.HelpTopic;
/* 12:   */ import org.bukkit.plugin.Plugin;
/* 13:   */ import org.bukkit.plugin.PluginManager;
/* 14:   */ 
/* 15:   */ public class PermissionsCommandsListener
/* 16:   */   implements Listener
/* 17:   */ {
/* 18:   */   Main plugin;
/* 19:   */   Plugin[] plugins;
/* 20:   */   
/* 21:   */   public PermissionsCommandsListener(Main plugin)
/* 22:   */   {
/* 23:20 */     this.plugin = plugin;
/* 24:21 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 25:   */   }
/* 26:   */   
/* 27:   */   @EventHandler
/* 28:   */   public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e)
/* 29:   */   {
/* 30:27 */     String msg = e.getMessage();
/* 31:28 */     if (msg.length() >= 1)
/* 32:   */     {
/* 33:30 */       String[] msgSplit = msg.split(" ");
/* 34:31 */       String commandString = msgSplit[0].replace("/", "");
/* 35:32 */       Player sender = e.getPlayer();
/* 36:33 */       Command command = this.plugin.getServer().getPluginCommand(commandString);
/* 37:34 */       if (command == null)
/* 38:   */       {
/* 39:36 */         HelpTopic topic = this.plugin.getServer().getHelpMap().getHelpTopic(msgSplit[0]);
/* 40:37 */         if (topic == null)
/* 41:   */         {
/* 42:39 */           sender.sendMessage(" §9⊙  §cNie odnaleziono komendy...");
/* 43:40 */           sender.sendMessage(" §9⊙  §cAby otrzymac pomoc uzyj: §7/pomoc§c.");
/* 44:41 */           e.setCancelled(true);
/* 45:   */         }
/* 46:   */       }
/* 47:   */       else
/* 48:   */       {
/* 49:46 */         String commandPermission = command.getPermission();
/* 50:47 */         if (commandPermission != null) {
/* 51:49 */           command.setPermissionMessage(" §9⊙  §cNie masz uprawnien. §7(" + commandPermission + "§7)");
/* 52:   */         }
/* 53:   */       }
/* 54:   */     }
/* 55:   */   }
/* 56:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.PermissionsCommandsListener
 * JD-Core Version:    0.7.0.1
 */