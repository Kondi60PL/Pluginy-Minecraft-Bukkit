/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Enchantments;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  5:   */ import org.bukkit.ChatColor;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.enchantments.Enchantment;
/* 11:   */ import org.bukkit.entity.Player;
/* 12:   */ import org.bukkit.inventory.ItemStack;
/* 13:   */ 
/* 14:   */ public class EnchantCommand
/* 15:   */   implements CommandExecutor
/* 16:   */ {
/* 17:   */   Main plugin;
/* 18:   */   
/* 19:   */   public EnchantCommand(Main plugin)
/* 20:   */   {
/* 21:20 */     this.plugin = plugin;
/* 22:21 */     this.plugin.getCommand("enchant").setExecutor(this);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 26:   */   {
/* 27:27 */     if (!(sender instanceof Player))
/* 28:   */     {
/* 29:29 */       sender.sendMessage("§cTa komenda nie moze byc wykonana z konsoli!");
/* 30:30 */       return true;
/* 31:   */     }
/* 32:32 */     if ((args.length < 1) || (args.length > 2))
/* 33:   */     {
/* 34:34 */       sender.sendMessage("§cPoprawne uzycie: §6/enchant <enchant> [poziom]");
/* 35:35 */       return true;
/* 36:   */     }
/* 37:37 */     Player player = (Player)sender;
/* 38:38 */     ItemStack item = player.getItemInHand();
/* 39:39 */     String enchantmentName = args[0];
/* 40:40 */     Enchantment enchant = Enchantments.getEnchantment(enchantmentName);
/* 41:41 */     if (enchant == null)
/* 42:   */     {
/* 43:43 */       player.sendMessage("§cNie znaleziono podanego enchantu!");
/* 44:44 */       return true;
/* 45:   */     }
/* 46:46 */     int level = enchant.getMaxLevel();
/* 47:47 */     if (args.length == 2) {
/* 48:49 */       level = Integer.parseInt(args[1]);
/* 49:   */     }
/* 50:51 */     item.addUnsafeEnchantment(enchant, level);
/* 51:52 */     player.sendMessage(ChatColor.GOLD + "Zaklecie " + ChatColor.RED + enchant.getName() + ChatColor.GOLD + " zostalo nalozone na przedmiot w rece.");
/* 52:53 */     return false;
/* 53:   */   }
/* 54:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.EnchantCommand
 * JD-Core Version:    0.7.0.1
 */