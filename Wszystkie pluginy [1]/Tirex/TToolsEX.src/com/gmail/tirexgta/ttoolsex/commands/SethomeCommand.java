/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  6:   */ import org.bukkit.Location;
/*  7:   */ import org.bukkit.World;
/*  8:   */ import org.bukkit.command.Command;
/*  9:   */ import org.bukkit.command.CommandExecutor;
/* 10:   */ import org.bukkit.command.CommandSender;
/* 11:   */ import org.bukkit.command.PluginCommand;
/* 12:   */ import org.bukkit.entity.Player;
/* 13:   */ 
/* 14:   */ public class SethomeCommand
/* 15:   */   implements CommandExecutor
/* 16:   */ {
/* 17:   */   Main plugin;
/* 18:   */   
/* 19:   */   public SethomeCommand(Main plugin)
/* 20:   */   {
/* 21:20 */     this.plugin = plugin;
/* 22:21 */     this.plugin.getCommand("sethome").setExecutor(this);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 26:   */   {
/* 27:27 */     if (!(sender instanceof Player))
/* 28:   */     {
/* 29:29 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 30:30 */       return true;
/* 31:   */     }
/* 32:32 */     Player p = (Player)sender;
/* 33:33 */     Location loc = p.getLocation();
/* 34:34 */     int locX = loc.getBlockX();
/* 35:35 */     int locY = loc.getBlockY();
/* 36:36 */     int locZ = loc.getBlockZ();
/* 37:37 */     String world = loc.getWorld().getName();
/* 38:38 */     DataUser user = Datasource.getUserData(p);
/* 39:39 */     user.setHomeX(locX);
/* 40:40 */     user.setHomeY(locY);
/* 41:41 */     user.setHomeZ(locZ);
/* 42:42 */     user.setHomeWorld(world);
/* 43:43 */     user.update();
/* 44:44 */     sender.sendMessage("§aUstawiles swoj dom!");
/* 45:45 */     return false;
/* 46:   */   }
/* 47:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.SethomeCommand
 * JD-Core Version:    0.7.0.1
 */