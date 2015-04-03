/*   1:    */ package com.gmail.tirexgta.ttoolsex.others;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.List;
/*   6:    */ import org.bukkit.Bukkit;
/*   7:    */ import org.bukkit.Material;
/*   8:    */ import org.bukkit.Server;
/*   9:    */ import org.bukkit.inventory.ItemStack;
/*  10:    */ import org.bukkit.inventory.ShapedRecipe;
/*  11:    */ import org.bukkit.inventory.meta.ItemMeta;
/*  12:    */ 
/*  13:    */ public class Recipe
/*  14:    */ {
/*  15:    */   Main plugin;
/*  16:    */   
/*  17:    */   public Recipe(Main plugin)
/*  18:    */   {
/*  19: 20 */     this.plugin = plugin;
/*  20: 21 */     registerSuperChest();
/*  21: 22 */     registerSuperStoniarka();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public static void registerSuperChest()
/*  25:    */   {
/*  26: 28 */     ItemStack superchest = itemSuperChest();
/*  27:    */     
/*  28: 30 */     ShapedRecipe recipe = new ShapedRecipe(new ItemStack(superchest))
/*  29: 31 */       .shape(new String[] {"OOO", "DCD", "OOO" })
/*  30: 32 */       .setIngredient('O', Material.OBSIDIAN)
/*  31: 33 */       .setIngredient('D', Material.DIAMOND)
/*  32: 34 */       .setIngredient('C', Material.CHEST);
/*  33: 35 */     Bukkit.getServer().addRecipe(recipe);
/*  34:    */   }
/*  35:    */   
/*  36:    */   public static void registerPokeBall()
/*  37:    */   {
/*  38: 41 */     ItemStack pokeball = itemPokeBall();
/*  39:    */     
/*  40: 43 */     ShapedRecipe recipe = new ShapedRecipe(new ItemStack(pokeball))
/*  41: 44 */       .shape(new String[] {"OGO", "RSR", "OFO" })
/*  42: 45 */       .setIngredient('O', Material.OBSIDIAN)
/*  43: 46 */       .setIngredient('G', Material.GLASS)
/*  44: 47 */       .setIngredient('R', Material.REDSTONE_BLOCK)
/*  45: 48 */       .setIngredient('S', Material.getMaterial(175))
/*  46: 49 */       .setIngredient('F', Material.FLOWER_POT_ITEM);
/*  47: 50 */     Bukkit.getServer().addRecipe(recipe);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public static void registerSuperStoniarka()
/*  51:    */   {
/*  52: 55 */     ItemStack superchest = itemSuperStoniarka();
/*  53:    */     
/*  54: 57 */     ShapedRecipe recipe = new ShapedRecipe(new ItemStack(superchest))
/*  55: 58 */       .shape(new String[] {"RPR", "DGD", "RPR" })
/*  56: 59 */       .setIngredient('R', Material.REDSTONE_BLOCK)
/*  57: 60 */       .setIngredient('D', Material.DIAMOND)
/*  58: 61 */       .setIngredient('G', Material.GLASS)
/*  59: 62 */       .setIngredient('P', Material.FLOWER_POT_ITEM);
/*  60: 63 */     Bukkit.getServer().addRecipe(recipe);
/*  61:    */   }
/*  62:    */   
/*  63:    */   public static ItemStack itemSuperChest()
/*  64:    */   {
/*  65: 68 */     ItemStack superchest = new ItemStack(Material.TRAPPED_CHEST);
/*  66: 69 */     ItemMeta meta = superchest.getItemMeta();
/*  67: 70 */     meta.setDisplayName("§6§lSuper§f§lChest!");
/*  68: 71 */     List<String> opis = new ArrayList();
/*  69: 72 */     opis.add("§bMoc Tirexa X");
/*  70: 73 */     opis.add(" §f§l> §cWcisnij Prawy Przycisk Myszy,");
/*  71: 74 */     opis.add("     §caby otworzyc Plecak!");
/*  72: 75 */     meta.setLore(opis);
/*  73: 76 */     superchest.setItemMeta(meta);
/*  74: 77 */     return superchest;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public static ItemStack itemPokeBall()
/*  78:    */   {
/*  79: 83 */     ItemStack pokeball = new ItemStack(Material.getMaterial(175));
/*  80: 84 */     ItemMeta meta = pokeball.getItemMeta();
/*  81: 85 */     meta.setDisplayName("§6Pokèball!");
/*  82: 86 */     List<String> opis = new ArrayList();
/*  83: 87 */     opis.add("§bMoc Tirexa X");
/*  84: 88 */     opis.add(" §f§l> §cNacisnij Prawym Przyciskiem Myszy");
/*  85: 89 */     opis.add("     §cna Potwora, ktorego chcesz zlapac!");
/*  86: 90 */     meta.setLore(opis);
/*  87: 91 */     pokeball.setItemMeta(meta);
/*  88: 92 */     return pokeball;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public static ItemStack itemSuperStoniarka()
/*  92:    */   {
/*  93: 97 */     ItemStack stoniarka = new ItemStack(Material.DAYLIGHT_DETECTOR);
/*  94: 98 */     ItemMeta meta = stoniarka.getItemMeta();
/*  95: 99 */     meta.setDisplayName("§b§lStone§6§lArka!");
/*  96:100 */     List<String> opis = new ArrayList();
/*  97:101 */     opis.add("§bMoc Tirexa X");
/*  98:102 */     opis.add(" §f§l> §cPoloz ten blok na ziemi, aby zaczal");
/*  99:103 */     opis.add("     §csie generowac stone!");
/* 100:104 */     meta.setLore(opis);
/* 101:105 */     stoniarka.setItemMeta(meta);
/* 102:106 */     return stoniarka;
/* 103:    */   }
/* 104:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.others.Recipe
 * JD-Core Version:    0.7.0.1
 */