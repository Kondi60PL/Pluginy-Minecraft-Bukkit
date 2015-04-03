/*   1:    */ package com.gmail.tirexgta.ttoolsex.others;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.List;
/*   6:    */ import org.bukkit.Material;
/*   7:    */ import org.bukkit.enchantments.Enchantment;
/*   8:    */ import org.bukkit.entity.Entity;
/*   9:    */ import org.bukkit.entity.EntityType;
/*  10:    */ import org.bukkit.entity.Player;
/*  11:    */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*  12:    */ import org.bukkit.inventory.ItemStack;
/*  13:    */ import org.bukkit.inventory.meta.ItemMeta;
/*  14:    */ 
/*  15:    */ public class Pokeball
/*  16:    */ {
/*  17:    */   Main plugin;
/*  18:    */   
/*  19:    */   public Pokeball(Main plugin)
/*  20:    */   {
/*  21: 23 */     this.plugin = plugin;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public static ItemStack pokeball(String nazwa, int id, String potwor)
/*  25:    */   {
/*  26: 29 */     ItemStack pokeball = new ItemStack(Material.getMaterial(175));
/*  27: 30 */     ItemMeta meta = pokeball.getItemMeta();
/*  28: 31 */     meta.setDisplayName("§6Pokèball z " + potwor + "!");
/*  29: 32 */     meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
/*  30: 33 */     List<String> opis = new ArrayList();
/*  31: 34 */     opis.add(" §f> §6Nazwa Potwora: §6" + nazwa);
/*  32: 35 */     opis.add(" §f> §6ID Moba: §6" + id);
/*  33: 36 */     meta.setLore(opis);
/*  34: 37 */     pokeball.setItemMeta(meta);
/*  35: 38 */     return pokeball;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public static void click(PlayerInteractEntityEvent e)
/*  39:    */   {
/*  40: 43 */     ItemStack pokeball = Recipe.itemPokeBall();
/*  41: 44 */     Player p = e.getPlayer();
/*  42: 45 */     if (p.getItemInHand().getItemMeta() == null) {
/*  43: 47 */       return;
/*  44:    */     }
/*  45: 49 */     if (!p.getItemInHand().getItemMeta().equals(pokeball.getItemMeta())) {
/*  46: 51 */       return;
/*  47:    */     }
/*  48: 53 */     Entity potwor = e.getRightClicked();
/*  49:    */     
/*  50:    */ 
/*  51:    */ 
/*  52: 57 */     EntityType stwor = null;
/*  53: 58 */     if (potwor.getType() == EntityType.COW)
/*  54:    */     {
/*  55: 60 */       stwor = potwor.getType();
/*  56:    */     }
/*  57: 62 */     else if (potwor.getType() == EntityType.PIG)
/*  58:    */     {
/*  59: 64 */       stwor = potwor.getType();
/*  60:    */     }
/*  61: 66 */     else if (potwor.getType() == EntityType.SHEEP)
/*  62:    */     {
/*  63: 68 */       stwor = potwor.getType();
/*  64:    */     }
/*  65: 70 */     else if (potwor.getType() == EntityType.HORSE)
/*  66:    */     {
/*  67: 72 */       stwor = potwor.getType();
/*  68:    */     }
/*  69: 74 */     else if (potwor.getType() == EntityType.CHICKEN)
/*  70:    */     {
/*  71: 76 */       stwor = potwor.getType();
/*  72:    */     }
/*  73: 78 */     else if (potwor.getType() == EntityType.OCELOT)
/*  74:    */     {
/*  75: 80 */       stwor = potwor.getType();
/*  76:    */     }
/*  77: 82 */     else if (potwor.getType() == EntityType.WOLF)
/*  78:    */     {
/*  79: 84 */       stwor = potwor.getType();
/*  80:    */     }
/*  81: 86 */     else if (potwor.getType() == EntityType.VILLAGER)
/*  82:    */     {
/*  83: 88 */       stwor = potwor.getType();
/*  84:    */     }
/*  85:    */     else
/*  86:    */     {
/*  87: 90 */       if (potwor.getType() == EntityType.PLAYER)
/*  88:    */       {
/*  89: 92 */         p.sendMessage("§cheheszky, to nie pokèmon!");
/*  90: 93 */         return;
/*  91:    */       }
/*  92: 97 */       p.sendMessage("§cza duzy ten pokèmon!");
/*  93: 98 */       return;
/*  94:    */     }
/*  95:100 */     stwor = EntityType.ARROW;
/*  96:    */   }
/*  97:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.others.Pokeball
 * JD-Core Version:    0.7.0.1
 */