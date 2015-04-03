/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Material;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ import org.bukkit.inventory.ItemStack;
/* 11:   */ import org.bukkit.inventory.PlayerInventory;
/* 12:   */ 
/* 13:   */ public class ItemCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public ItemCommand(Main plugin)
/* 19:   */   {
/* 20:18 */     this.plugin = plugin;
/* 21:19 */     this.plugin.getCommand("item").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:25 */     if (!(sender instanceof Player))
/* 27:   */     {
/* 28:27 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 29:28 */       return true;
/* 30:   */     }
/* 31:30 */     Player player = (Player)sender;
/* 32:31 */     if ((args.length == 1) || (args.length == 2))
/* 33:   */     {
/* 34:33 */       String[] idAndData = args[0].split(":");
/* 35:34 */       Material material = Main.getMaterial(idAndData[0]);
/* 36:35 */       if (material == null)
/* 37:   */       {
/* 38:37 */         sender.sendMessage("§cNie rozpoznano nazwy przedmiotu!");
/* 39:38 */         return true;
/* 40:   */       }
/* 41:40 */       Short data = Short.valueOf((short)0);
/* 42:41 */       if (idAndData.length > 1) {
/* 43:43 */         data = Short.valueOf(idAndData[1]);
/* 44:   */       }
/* 45:45 */       int amount = 64;
/* 46:46 */       if (args.length == 2) {
/* 47:48 */         if (Main.isInteger(args[1])) {
/* 48:50 */           amount = Integer.parseInt(args[1]);
/* 49:   */         }
/* 50:   */       }
/* 51:53 */       ItemStack item = new ItemStack(material, amount, data.shortValue());
/* 52:54 */       if (player.getInventory().firstEmpty() < 0)
/* 53:   */       {
/* 54:56 */         sender.sendMessage("§cNie masz miejsca w swoim ekwipunku!");
/* 55:57 */         return true;
/* 56:   */       }
/* 57:59 */       player.getInventory().addItem(new ItemStack[] { item });
/* 58:60 */       player.sendMessage("§6Otrzymales §c" + material.name() + "§6:§c" + data + "§6(§c" + amount + "§6)");
/* 59:   */     }
/* 60:   */     else
/* 61:   */     {
/* 62:64 */       sender.sendMessage("§cPoprawne uzycie: §6/item <id> [ilosc]");
/* 63:   */     }
/* 64:67 */     return false;
/* 65:   */   }
/* 66:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.ItemCommand
 * JD-Core Version:    0.7.0.1
 */