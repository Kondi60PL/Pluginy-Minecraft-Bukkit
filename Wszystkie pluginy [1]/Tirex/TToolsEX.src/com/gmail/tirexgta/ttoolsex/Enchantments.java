/*   1:    */ package com.gmail.tirexgta.ttoolsex;
/*   2:    */ 
/*   3:    */ import java.util.HashMap;
/*   4:    */ import java.util.Map;
/*   5:    */ import org.bukkit.enchantments.Enchantment;
/*   6:    */ 
/*   7:    */ public class Enchantments
/*   8:    */ {
/*   9:  9 */   public static Map<String, Enchantment> ENCHANTMENTS = new HashMap();
/*  10: 10 */   public static Map<String, Enchantment> ALIASENCHANTMENTS = new HashMap();
/*  11:    */   Main plugin;
/*  12:    */   
/*  13:    */   public Enchantments(Main plugin)
/*  14:    */   {
/*  15: 15 */     this.plugin = plugin;
/*  16: 16 */     loadEnchantments();
/*  17:    */   }
/*  18:    */   
/*  19:    */   public void loadEnchantments()
/*  20:    */   {
/*  21: 21 */     ENCHANTMENTS.put("alldamage", Enchantment.DAMAGE_ALL);
/*  22: 22 */     ALIASENCHANTMENTS.put("alldmg", Enchantment.DAMAGE_ALL);
/*  23: 23 */     ENCHANTMENTS.put("sharpness", Enchantment.DAMAGE_ALL);
/*  24: 24 */     ALIASENCHANTMENTS.put("sharp", Enchantment.DAMAGE_ALL);
/*  25: 25 */     ALIASENCHANTMENTS.put("dal", Enchantment.DAMAGE_ALL);
/*  26:    */     
/*  27: 27 */     ENCHANTMENTS.put("ardmg", Enchantment.DAMAGE_ARTHROPODS);
/*  28: 28 */     ENCHANTMENTS.put("baneofarthropods", Enchantment.DAMAGE_ARTHROPODS);
/*  29: 29 */     ALIASENCHANTMENTS.put("baneofarthropod", Enchantment.DAMAGE_ARTHROPODS);
/*  30: 30 */     ALIASENCHANTMENTS.put("arthropod", Enchantment.DAMAGE_ARTHROPODS);
/*  31: 31 */     ALIASENCHANTMENTS.put("dar", Enchantment.DAMAGE_ARTHROPODS);
/*  32:    */     
/*  33: 33 */     ENCHANTMENTS.put("undeaddamage", Enchantment.DAMAGE_UNDEAD);
/*  34: 34 */     ENCHANTMENTS.put("smite", Enchantment.DAMAGE_UNDEAD);
/*  35: 35 */     ALIASENCHANTMENTS.put("du", Enchantment.DAMAGE_UNDEAD);
/*  36:    */     
/*  37: 37 */     ENCHANTMENTS.put("digspeed", Enchantment.DIG_SPEED);
/*  38: 38 */     ENCHANTMENTS.put("efficiency", Enchantment.DIG_SPEED);
/*  39: 39 */     ALIASENCHANTMENTS.put("minespeed", Enchantment.DIG_SPEED);
/*  40: 40 */     ALIASENCHANTMENTS.put("cutspeed", Enchantment.DIG_SPEED);
/*  41: 41 */     ALIASENCHANTMENTS.put("ds", Enchantment.DIG_SPEED);
/*  42: 42 */     ALIASENCHANTMENTS.put("eff", Enchantment.DIG_SPEED);
/*  43:    */     
/*  44: 44 */     ENCHANTMENTS.put("durability", Enchantment.DURABILITY);
/*  45: 45 */     ALIASENCHANTMENTS.put("dura", Enchantment.DURABILITY);
/*  46: 46 */     ENCHANTMENTS.put("unbreaking", Enchantment.DURABILITY);
/*  47: 47 */     ALIASENCHANTMENTS.put("d", Enchantment.DURABILITY);
/*  48:    */     
/*  49: 49 */     ENCHANTMENTS.put("thorns", Enchantment.THORNS);
/*  50: 50 */     ENCHANTMENTS.put("highcrit", Enchantment.THORNS);
/*  51: 51 */     ALIASENCHANTMENTS.put("thorn", Enchantment.THORNS);
/*  52: 52 */     ALIASENCHANTMENTS.put("highercrit", Enchantment.THORNS);
/*  53: 53 */     ALIASENCHANTMENTS.put("t", Enchantment.THORNS);
/*  54:    */     
/*  55: 55 */     ENCHANTMENTS.put("fireaspect", Enchantment.FIRE_ASPECT);
/*  56: 56 */     ENCHANTMENTS.put("fire", Enchantment.FIRE_ASPECT);
/*  57: 57 */     ALIASENCHANTMENTS.put("meleefire", Enchantment.FIRE_ASPECT);
/*  58: 58 */     ALIASENCHANTMENTS.put("meleeflame", Enchantment.FIRE_ASPECT);
/*  59: 59 */     ALIASENCHANTMENTS.put("fa", Enchantment.FIRE_ASPECT);
/*  60:    */     
/*  61: 61 */     ENCHANTMENTS.put("knockback", Enchantment.KNOCKBACK);
/*  62: 62 */     ALIASENCHANTMENTS.put("kback", Enchantment.KNOCKBACK);
/*  63: 63 */     ALIASENCHANTMENTS.put("kb", Enchantment.KNOCKBACK);
/*  64: 64 */     ALIASENCHANTMENTS.put("k", Enchantment.KNOCKBACK);
/*  65:    */     
/*  66: 66 */     ALIASENCHANTMENTS.put("blockslootbonus", Enchantment.LOOT_BONUS_BLOCKS);
/*  67: 67 */     ENCHANTMENTS.put("fortune", Enchantment.LOOT_BONUS_BLOCKS);
/*  68: 68 */     ALIASENCHANTMENTS.put("fort", Enchantment.LOOT_BONUS_BLOCKS);
/*  69: 69 */     ALIASENCHANTMENTS.put("lbb", Enchantment.LOOT_BONUS_BLOCKS);
/*  70:    */     
/*  71: 71 */     ALIASENCHANTMENTS.put("mobslootbonus", Enchantment.LOOT_BONUS_MOBS);
/*  72: 72 */     ENCHANTMENTS.put("mobloot", Enchantment.LOOT_BONUS_MOBS);
/*  73: 73 */     ENCHANTMENTS.put("looting", Enchantment.LOOT_BONUS_MOBS);
/*  74: 74 */     ALIASENCHANTMENTS.put("lbm", Enchantment.LOOT_BONUS_MOBS);
/*  75:    */     
/*  76: 76 */     ALIASENCHANTMENTS.put("oxygen", Enchantment.OXYGEN);
/*  77: 77 */     ENCHANTMENTS.put("respiration", Enchantment.OXYGEN);
/*  78: 78 */     ALIASENCHANTMENTS.put("breathing", Enchantment.OXYGEN);
/*  79: 79 */     ENCHANTMENTS.put("breath", Enchantment.OXYGEN);
/*  80: 80 */     ALIASENCHANTMENTS.put("o", Enchantment.OXYGEN);
/*  81:    */     
/*  82: 82 */     ENCHANTMENTS.put("protection", Enchantment.PROTECTION_ENVIRONMENTAL);
/*  83: 83 */     ALIASENCHANTMENTS.put("prot", Enchantment.PROTECTION_ENVIRONMENTAL);
/*  84: 84 */     ENCHANTMENTS.put("protect", Enchantment.PROTECTION_ENVIRONMENTAL);
/*  85: 85 */     ALIASENCHANTMENTS.put("p", Enchantment.PROTECTION_ENVIRONMENTAL);
/*  86:    */     
/*  87: 87 */     ALIASENCHANTMENTS.put("explosionsprotection", Enchantment.PROTECTION_EXPLOSIONS);
/*  88: 88 */     ALIASENCHANTMENTS.put("explosionprotection", Enchantment.PROTECTION_EXPLOSIONS);
/*  89: 89 */     ALIASENCHANTMENTS.put("expprot", Enchantment.PROTECTION_EXPLOSIONS);
/*  90: 90 */     ALIASENCHANTMENTS.put("blastprotection", Enchantment.PROTECTION_EXPLOSIONS);
/*  91: 91 */     ENCHANTMENTS.put("blastprotect", Enchantment.PROTECTION_EXPLOSIONS);
/*  92: 92 */     ALIASENCHANTMENTS.put("pe", Enchantment.PROTECTION_EXPLOSIONS);
/*  93:    */     
/*  94: 94 */     ALIASENCHANTMENTS.put("fallprotection", Enchantment.PROTECTION_FALL);
/*  95: 95 */     ENCHANTMENTS.put("fallprot", Enchantment.PROTECTION_FALL);
/*  96: 96 */     ENCHANTMENTS.put("featherfall", Enchantment.PROTECTION_FALL);
/*  97: 97 */     ALIASENCHANTMENTS.put("featherfalling", Enchantment.PROTECTION_FALL);
/*  98: 98 */     ALIASENCHANTMENTS.put("pfa", Enchantment.PROTECTION_FALL);
/*  99:    */     
/* 100:100 */     ALIASENCHANTMENTS.put("fireprotection", Enchantment.PROTECTION_FIRE);
/* 101:101 */     ALIASENCHANTMENTS.put("flameprotection", Enchantment.PROTECTION_FIRE);
/* 102:102 */     ENCHANTMENTS.put("fireprotect", Enchantment.PROTECTION_FIRE);
/* 103:103 */     ALIASENCHANTMENTS.put("flameprotect", Enchantment.PROTECTION_FIRE);
/* 104:104 */     ENCHANTMENTS.put("fireprot", Enchantment.PROTECTION_FIRE);
/* 105:105 */     ALIASENCHANTMENTS.put("flameprot", Enchantment.PROTECTION_FIRE);
/* 106:106 */     ALIASENCHANTMENTS.put("pf", Enchantment.PROTECTION_FIRE);
/* 107:    */     
/* 108:108 */     ENCHANTMENTS.put("projectileprotection", Enchantment.PROTECTION_PROJECTILE);
/* 109:109 */     ENCHANTMENTS.put("projprot", Enchantment.PROTECTION_PROJECTILE);
/* 110:110 */     ALIASENCHANTMENTS.put("pp", Enchantment.PROTECTION_PROJECTILE);
/* 111:    */     
/* 112:112 */     ENCHANTMENTS.put("silktouch", Enchantment.SILK_TOUCH);
/* 113:113 */     ALIASENCHANTMENTS.put("softtouch", Enchantment.SILK_TOUCH);
/* 114:114 */     ALIASENCHANTMENTS.put("st", Enchantment.SILK_TOUCH);
/* 115:    */     
/* 116:116 */     ENCHANTMENTS.put("waterworker", Enchantment.WATER_WORKER);
/* 117:117 */     ENCHANTMENTS.put("aquaaffinity", Enchantment.WATER_WORKER);
/* 118:118 */     ALIASENCHANTMENTS.put("watermine", Enchantment.WATER_WORKER);
/* 119:119 */     ALIASENCHANTMENTS.put("ww", Enchantment.WATER_WORKER);
/* 120:    */     
/* 121:121 */     ALIASENCHANTMENTS.put("firearrow", Enchantment.ARROW_FIRE);
/* 122:122 */     ENCHANTMENTS.put("flame", Enchantment.ARROW_FIRE);
/* 123:123 */     ENCHANTMENTS.put("flamearrow", Enchantment.ARROW_FIRE);
/* 124:124 */     ALIASENCHANTMENTS.put("af", Enchantment.ARROW_FIRE);
/* 125:    */     
/* 126:126 */     ENCHANTMENTS.put("arrowdamage", Enchantment.ARROW_DAMAGE);
/* 127:127 */     ENCHANTMENTS.put("power", Enchantment.ARROW_DAMAGE);
/* 128:128 */     ALIASENCHANTMENTS.put("arrowpower", Enchantment.ARROW_DAMAGE);
/* 129:129 */     ALIASENCHANTMENTS.put("ad", Enchantment.ARROW_DAMAGE);
/* 130:    */     
/* 131:131 */     ENCHANTMENTS.put("arrowknockback", Enchantment.ARROW_KNOCKBACK);
/* 132:132 */     ALIASENCHANTMENTS.put("arrowkb", Enchantment.ARROW_KNOCKBACK);
/* 133:133 */     ENCHANTMENTS.put("punch", Enchantment.ARROW_KNOCKBACK);
/* 134:134 */     ALIASENCHANTMENTS.put("arrowpunch", Enchantment.ARROW_KNOCKBACK);
/* 135:135 */     ALIASENCHANTMENTS.put("ak", Enchantment.ARROW_KNOCKBACK);
/* 136:    */     
/* 137:137 */     ALIASENCHANTMENTS.put("infinitearrows", Enchantment.ARROW_INFINITE);
/* 138:138 */     ENCHANTMENTS.put("infarrows", Enchantment.ARROW_INFINITE);
/* 139:139 */     ENCHANTMENTS.put("infinity", Enchantment.ARROW_INFINITE);
/* 140:140 */     ALIASENCHANTMENTS.put("infinite", Enchantment.ARROW_INFINITE);
/* 141:141 */     ALIASENCHANTMENTS.put("unlimited", Enchantment.ARROW_INFINITE);
/* 142:142 */     ALIASENCHANTMENTS.put("unlimitedarrows", Enchantment.ARROW_INFINITE);
/* 143:143 */     ALIASENCHANTMENTS.put("ai", Enchantment.ARROW_INFINITE);
/* 144:    */   }
/* 145:    */   
/* 146:    */   public static Enchantment getEnchantment(String string)
/* 147:    */   {
/* 148:148 */     String enchantmentName = string.toLowerCase();
/* 149:149 */     if (ENCHANTMENTS.get(enchantmentName) != null) {
/* 150:151 */       return (Enchantment)ENCHANTMENTS.get(enchantmentName);
/* 151:    */     }
/* 152:153 */     if (ALIASENCHANTMENTS.get(enchantmentName) != null) {
/* 153:155 */       return (Enchantment)ALIASENCHANTMENTS.get(enchantmentName);
/* 154:    */     }
/* 155:157 */     return null;
/* 156:    */   }
/* 157:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.Enchantments
 * JD-Core Version:    0.7.0.1
 */