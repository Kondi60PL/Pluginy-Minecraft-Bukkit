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
/* 13:   */ public class RepairCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:15 */   Material[] canRepair = { Material.DIAMOND_PICKAXE, Material.DIAMOND_SWORD, Material.DIAMOND_SPADE, Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.IRON_PICKAXE, Material.IRON_SWORD, Material.IRON_SPADE, Material.IRON_AXE, Material.IRON_HOE, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.GOLD_PICKAXE, Material.GOLD_SWORD, Material.GOLD_SPADE, Material.GOLD_AXE, Material.GOLD_HOE, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, Material.STONE_PICKAXE, Material.STONE_SWORD, Material.STONE_SPADE, Material.STONE_AXE, Material.STONE_HOE, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, Material.WOOD_PICKAXE, Material.WOOD_SWORD, Material.WOOD_SPADE, Material.WOOD_AXE, Material.WOOD_HOE, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.FLINT_AND_STEEL, Material.SHEARS, Material.BOW, Material.FISHING_ROD, Material.ANVIL };
/* 18:   */   
/* 19:   */   public RepairCommand(Main plugin)
/* 20:   */   {
/* 21:19 */     this.plugin = plugin;
/* 22:20 */     this.plugin.getCommand("repair").setExecutor(this);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 26:   */   {
/* 27:26 */     if (!(sender instanceof Player))
/* 28:   */     {
/* 29:28 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 30:29 */       return true;
/* 31:   */     }
/* 32:31 */     if (args.length == 0)
/* 33:   */     {
/* 34:33 */       Player p = (Player)sender;
/* 35:34 */       ItemStack itemHand = p.getItemInHand();
/* 36:35 */       if (itemHand == null)
/* 37:   */       {
/* 38:37 */         sender.sendMessage("§cNie masz zadnego przedmiotu w rece!");
/* 39:38 */         return true;
/* 40:   */       }
/* 41:40 */       if (itemHand.getDurability() < 1)
/* 42:   */       {
/* 43:42 */         sender.sendMessage("§cNie masz przedmiotu w rece, ktorego moglbys naprawic!");
/* 44:43 */         return true;
/* 45:   */       }
/* 46:45 */       short durability = 0;
/* 47:46 */       itemHand.setDurability(durability);
/* 48:47 */       sender.sendMessage("§6Pomyslnie naprawiono przedmiot, ktory trzymasz w rece!");
/* 49:   */     }
/* 50:49 */     else if (args.length == 1)
/* 51:   */     {
/* 52:51 */       Player p = (Player)sender;
/* 53:52 */       if (args[0].equalsIgnoreCase("all"))
/* 54:   */       {
/* 55:54 */         int ilosc = 0;
/* 56:55 */         for (ItemStack item : p.getInventory().getContents()) {
/* 57:57 */           if (item != null) {
/* 58:59 */             if (item.getDurability() > 0)
/* 59:   */             {
/* 60:61 */               short durability = 0;
/* 61:62 */               item.setDurability(durability);
/* 62:63 */               ilosc++;
/* 63:   */             }
/* 64:   */           }
/* 65:   */         }
/* 66:67 */         for (ItemStack item : p.getInventory().getArmorContents()) {
/* 67:69 */           if (item != null) {
/* 68:71 */             if (item.getDurability() > 0)
/* 69:   */             {
/* 70:73 */               short durability = 0;
/* 71:74 */               item.setDurability(durability);
/* 72:75 */               ilosc++;
/* 73:   */             }
/* 74:   */           }
/* 75:   */         }
/* 76:79 */         if (ilosc != 0) {
/* 77:81 */           sender.sendMessage("§6Pomyslnie naprawiono §c" + ilosc + " §6przedmiotow!");
/* 78:   */         } else {
/* 79:85 */           sender.sendMessage("§cNie masz przedmiotow, ktore moglbys naprawic!");
/* 80:   */         }
/* 81:   */       }
/* 82:   */       else
/* 83:   */       {
/* 84:90 */         sender.sendMessage("§cDostepne argumenty: §6all");
/* 85:   */       }
/* 86:   */     }
/* 87:   */     else
/* 88:   */     {
/* 89:95 */       sender.sendMessage("§cPoprawne uzycie: §6/repair [argument]");
/* 90:   */     }
/* 91:97 */     return false;
/* 92:   */   }
/* 93:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.RepairCommand
 * JD-Core Version:    0.7.0.1
 */