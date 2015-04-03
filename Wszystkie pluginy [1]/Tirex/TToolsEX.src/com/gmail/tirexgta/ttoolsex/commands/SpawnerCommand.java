/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Material;
/*  5:   */ import org.bukkit.block.Block;
/*  6:   */ import org.bukkit.block.CreatureSpawner;
/*  7:   */ import org.bukkit.command.Command;
/*  8:   */ import org.bukkit.command.CommandExecutor;
/*  9:   */ import org.bukkit.command.CommandSender;
/* 10:   */ import org.bukkit.command.PluginCommand;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ 
/* 13:   */ public class SpawnerCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public SpawnerCommand(Main plugin)
/* 19:   */   {
/* 20:20 */     this.plugin = plugin;
/* 21:21 */     this.plugin.getCommand("spawner").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:27 */     if (!(sender instanceof Player))
/* 27:   */     {
/* 28:29 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 29:30 */       return true;
/* 30:   */     }
/* 31:32 */     if (args.length != 1)
/* 32:   */     {
/* 33:34 */       sender.sendMessage("§cPoprawne uzycie: §6/spawner <zwierze>");
/* 34:35 */       return true;
/* 35:   */     }
/* 36:37 */     Player p = (Player)sender;
/* 37:38 */     String spawnerType = args[0].toLowerCase();
/* 38:   */     
/* 39:40 */     Block targetBlock = p.getTargetBlock(null, 10);
/* 40:41 */     if (!targetBlock.getType().equals(Material.MOB_SPAWNER))
/* 41:   */     {
/* 42:43 */       sender.sendMessage("§cTen blok nie jest spawnerem!");
/* 43:44 */       return true;
/* 44:   */     }
/* 45:46 */     CreatureSpawner spawner = (CreatureSpawner)targetBlock.getState();
/* 46:47 */     spawner.setCreatureTypeByName(spawnerType);
/* 47:48 */     sender.sendMessage("§6Zmieniono typ spawnera na §c" + spawner.getCreatureTypeName());
/* 48:49 */     return false;
/* 49:   */   }
/* 50:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.SpawnerCommand
 * JD-Core Version:    0.7.0.1
 */