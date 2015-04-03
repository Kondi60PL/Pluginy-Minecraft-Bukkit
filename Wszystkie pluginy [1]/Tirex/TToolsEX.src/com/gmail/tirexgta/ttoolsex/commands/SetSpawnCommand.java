/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Location;
/*  5:   */ import org.bukkit.World;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ 
/* 12:   */ public class SetSpawnCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:   */   
/* 17:   */   public SetSpawnCommand(Main plugin)
/* 18:   */   {
/* 19:17 */     this.plugin = plugin;
/* 20:18 */     this.plugin.getCommand("setspawn").setExecutor(this);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 24:   */   {
/* 25:24 */     if (!(sender instanceof Player))
/* 26:   */     {
/* 27:26 */       sender.sendMessage("§4Ta komenda nie jest dostepna z konsoli!");
/* 28:27 */       return true;
/* 29:   */     }
/* 30:29 */     Location loc = ((Player)sender).getLocation();
/* 31:30 */     ((Player)sender).getWorld().setSpawnLocation(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
/* 32:31 */     sender.sendMessage("§aUstawiles lokalizacje §6spawnu!");
/* 33:32 */     return false;
/* 34:   */   }
/* 35:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.SetSpawnCommand
 * JD-Core Version:    0.7.0.1
 */