package com.gmail.tirexgta.ttoolsex;

import org.bukkit.enchantments.*;
import java.util.*;

public class Enchantments
{
    public static Map<String, Enchantment> ENCHANTMENTS;
    public static Map<String, Enchantment> ALIASENCHANTMENTS;
    Main plugin;
    
    static {
        Enchantments.ENCHANTMENTS = new HashMap<String, Enchantment>();
        Enchantments.ALIASENCHANTMENTS = new HashMap<String, Enchantment>();
    }
    
    public Enchantments(final Main plugin) {
        super();
        this.plugin = plugin;
        this.loadEnchantments();
    }
    
    public void loadEnchantments() {
        Enchantments.ENCHANTMENTS.put("alldamage", Enchantment.DAMAGE_ALL);
        Enchantments.ALIASENCHANTMENTS.put("alldmg", Enchantment.DAMAGE_ALL);
        Enchantments.ENCHANTMENTS.put("sharpness", Enchantment.DAMAGE_ALL);
        Enchantments.ALIASENCHANTMENTS.put("sharp", Enchantment.DAMAGE_ALL);
        Enchantments.ALIASENCHANTMENTS.put("dal", Enchantment.DAMAGE_ALL);
        Enchantments.ENCHANTMENTS.put("ardmg", Enchantment.DAMAGE_ARTHROPODS);
        Enchantments.ENCHANTMENTS.put("baneofarthropods", Enchantment.DAMAGE_ARTHROPODS);
        Enchantments.ALIASENCHANTMENTS.put("baneofarthropod", Enchantment.DAMAGE_ARTHROPODS);
        Enchantments.ALIASENCHANTMENTS.put("arthropod", Enchantment.DAMAGE_ARTHROPODS);
        Enchantments.ALIASENCHANTMENTS.put("dar", Enchantment.DAMAGE_ARTHROPODS);
        Enchantments.ENCHANTMENTS.put("undeaddamage", Enchantment.DAMAGE_UNDEAD);
        Enchantments.ENCHANTMENTS.put("smite", Enchantment.DAMAGE_UNDEAD);
        Enchantments.ALIASENCHANTMENTS.put("du", Enchantment.DAMAGE_UNDEAD);
        Enchantments.ENCHANTMENTS.put("digspeed", Enchantment.DIG_SPEED);
        Enchantments.ENCHANTMENTS.put("efficiency", Enchantment.DIG_SPEED);
        Enchantments.ALIASENCHANTMENTS.put("minespeed", Enchantment.DIG_SPEED);
        Enchantments.ALIASENCHANTMENTS.put("cutspeed", Enchantment.DIG_SPEED);
        Enchantments.ALIASENCHANTMENTS.put("ds", Enchantment.DIG_SPEED);
        Enchantments.ALIASENCHANTMENTS.put("eff", Enchantment.DIG_SPEED);
        Enchantments.ENCHANTMENTS.put("durability", Enchantment.DURABILITY);
        Enchantments.ALIASENCHANTMENTS.put("dura", Enchantment.DURABILITY);
        Enchantments.ENCHANTMENTS.put("unbreaking", Enchantment.DURABILITY);
        Enchantments.ALIASENCHANTMENTS.put("d", Enchantment.DURABILITY);
        Enchantments.ENCHANTMENTS.put("thorns", Enchantment.THORNS);
        Enchantments.ENCHANTMENTS.put("highcrit", Enchantment.THORNS);
        Enchantments.ALIASENCHANTMENTS.put("thorn", Enchantment.THORNS);
        Enchantments.ALIASENCHANTMENTS.put("highercrit", Enchantment.THORNS);
        Enchantments.ALIASENCHANTMENTS.put("t", Enchantment.THORNS);
        Enchantments.ENCHANTMENTS.put("fireaspect", Enchantment.FIRE_ASPECT);
        Enchantments.ENCHANTMENTS.put("fire", Enchantment.FIRE_ASPECT);
        Enchantments.ALIASENCHANTMENTS.put("meleefire", Enchantment.FIRE_ASPECT);
        Enchantments.ALIASENCHANTMENTS.put("meleeflame", Enchantment.FIRE_ASPECT);
        Enchantments.ALIASENCHANTMENTS.put("fa", Enchantment.FIRE_ASPECT);
        Enchantments.ENCHANTMENTS.put("knockback", Enchantment.KNOCKBACK);
        Enchantments.ALIASENCHANTMENTS.put("kback", Enchantment.KNOCKBACK);
        Enchantments.ALIASENCHANTMENTS.put("kb", Enchantment.KNOCKBACK);
        Enchantments.ALIASENCHANTMENTS.put("k", Enchantment.KNOCKBACK);
        Enchantments.ALIASENCHANTMENTS.put("blockslootbonus", Enchantment.LOOT_BONUS_BLOCKS);
        Enchantments.ENCHANTMENTS.put("fortune", Enchantment.LOOT_BONUS_BLOCKS);
        Enchantments.ALIASENCHANTMENTS.put("fort", Enchantment.LOOT_BONUS_BLOCKS);
        Enchantments.ALIASENCHANTMENTS.put("lbb", Enchantment.LOOT_BONUS_BLOCKS);
        Enchantments.ALIASENCHANTMENTS.put("mobslootbonus", Enchantment.LOOT_BONUS_MOBS);
        Enchantments.ENCHANTMENTS.put("mobloot", Enchantment.LOOT_BONUS_MOBS);
        Enchantments.ENCHANTMENTS.put("looting", Enchantment.LOOT_BONUS_MOBS);
        Enchantments.ALIASENCHANTMENTS.put("lbm", Enchantment.LOOT_BONUS_MOBS);
        Enchantments.ALIASENCHANTMENTS.put("oxygen", Enchantment.OXYGEN);
        Enchantments.ENCHANTMENTS.put("respiration", Enchantment.OXYGEN);
        Enchantments.ALIASENCHANTMENTS.put("breathing", Enchantment.OXYGEN);
        Enchantments.ENCHANTMENTS.put("breath", Enchantment.OXYGEN);
        Enchantments.ALIASENCHANTMENTS.put("o", Enchantment.OXYGEN);
        Enchantments.ENCHANTMENTS.put("protection", Enchantment.PROTECTION_ENVIRONMENTAL);
        Enchantments.ALIASENCHANTMENTS.put("prot", Enchantment.PROTECTION_ENVIRONMENTAL);
        Enchantments.ENCHANTMENTS.put("protect", Enchantment.PROTECTION_ENVIRONMENTAL);
        Enchantments.ALIASENCHANTMENTS.put("p", Enchantment.PROTECTION_ENVIRONMENTAL);
        Enchantments.ALIASENCHANTMENTS.put("explosionsprotection", Enchantment.PROTECTION_EXPLOSIONS);
        Enchantments.ALIASENCHANTMENTS.put("explosionprotection", Enchantment.PROTECTION_EXPLOSIONS);
        Enchantments.ALIASENCHANTMENTS.put("expprot", Enchantment.PROTECTION_EXPLOSIONS);
        Enchantments.ALIASENCHANTMENTS.put("blastprotection", Enchantment.PROTECTION_EXPLOSIONS);
        Enchantments.ENCHANTMENTS.put("blastprotect", Enchantment.PROTECTION_EXPLOSIONS);
        Enchantments.ALIASENCHANTMENTS.put("pe", Enchantment.PROTECTION_EXPLOSIONS);
        Enchantments.ALIASENCHANTMENTS.put("fallprotection", Enchantment.PROTECTION_FALL);
        Enchantments.ENCHANTMENTS.put("fallprot", Enchantment.PROTECTION_FALL);
        Enchantments.ENCHANTMENTS.put("featherfall", Enchantment.PROTECTION_FALL);
        Enchantments.ALIASENCHANTMENTS.put("featherfalling", Enchantment.PROTECTION_FALL);
        Enchantments.ALIASENCHANTMENTS.put("pfa", Enchantment.PROTECTION_FALL);
        Enchantments.ALIASENCHANTMENTS.put("fireprotection", Enchantment.PROTECTION_FIRE);
        Enchantments.ALIASENCHANTMENTS.put("flameprotection", Enchantment.PROTECTION_FIRE);
        Enchantments.ENCHANTMENTS.put("fireprotect", Enchantment.PROTECTION_FIRE);
        Enchantments.ALIASENCHANTMENTS.put("flameprotect", Enchantment.PROTECTION_FIRE);
        Enchantments.ENCHANTMENTS.put("fireprot", Enchantment.PROTECTION_FIRE);
        Enchantments.ALIASENCHANTMENTS.put("flameprot", Enchantment.PROTECTION_FIRE);
        Enchantments.ALIASENCHANTMENTS.put("pf", Enchantment.PROTECTION_FIRE);
        Enchantments.ENCHANTMENTS.put("projectileprotection", Enchantment.PROTECTION_PROJECTILE);
        Enchantments.ENCHANTMENTS.put("projprot", Enchantment.PROTECTION_PROJECTILE);
        Enchantments.ALIASENCHANTMENTS.put("pp", Enchantment.PROTECTION_PROJECTILE);
        Enchantments.ENCHANTMENTS.put("silktouch", Enchantment.SILK_TOUCH);
        Enchantments.ALIASENCHANTMENTS.put("softtouch", Enchantment.SILK_TOUCH);
        Enchantments.ALIASENCHANTMENTS.put("st", Enchantment.SILK_TOUCH);
        Enchantments.ENCHANTMENTS.put("waterworker", Enchantment.WATER_WORKER);
        Enchantments.ENCHANTMENTS.put("aquaaffinity", Enchantment.WATER_WORKER);
        Enchantments.ALIASENCHANTMENTS.put("watermine", Enchantment.WATER_WORKER);
        Enchantments.ALIASENCHANTMENTS.put("ww", Enchantment.WATER_WORKER);
        Enchantments.ALIASENCHANTMENTS.put("firearrow", Enchantment.ARROW_FIRE);
        Enchantments.ENCHANTMENTS.put("flame", Enchantment.ARROW_FIRE);
        Enchantments.ENCHANTMENTS.put("flamearrow", Enchantment.ARROW_FIRE);
        Enchantments.ALIASENCHANTMENTS.put("af", Enchantment.ARROW_FIRE);
        Enchantments.ENCHANTMENTS.put("arrowdamage", Enchantment.ARROW_DAMAGE);
        Enchantments.ENCHANTMENTS.put("power", Enchantment.ARROW_DAMAGE);
        Enchantments.ALIASENCHANTMENTS.put("arrowpower", Enchantment.ARROW_DAMAGE);
        Enchantments.ALIASENCHANTMENTS.put("ad", Enchantment.ARROW_DAMAGE);
        Enchantments.ENCHANTMENTS.put("arrowknockback", Enchantment.ARROW_KNOCKBACK);
        Enchantments.ALIASENCHANTMENTS.put("arrowkb", Enchantment.ARROW_KNOCKBACK);
        Enchantments.ENCHANTMENTS.put("punch", Enchantment.ARROW_KNOCKBACK);
        Enchantments.ALIASENCHANTMENTS.put("arrowpunch", Enchantment.ARROW_KNOCKBACK);
        Enchantments.ALIASENCHANTMENTS.put("ak", Enchantment.ARROW_KNOCKBACK);
        Enchantments.ALIASENCHANTMENTS.put("infinitearrows", Enchantment.ARROW_INFINITE);
        Enchantments.ENCHANTMENTS.put("infarrows", Enchantment.ARROW_INFINITE);
        Enchantments.ENCHANTMENTS.put("infinity", Enchantment.ARROW_INFINITE);
        Enchantments.ALIASENCHANTMENTS.put("infinite", Enchantment.ARROW_INFINITE);
        Enchantments.ALIASENCHANTMENTS.put("unlimited", Enchantment.ARROW_INFINITE);
        Enchantments.ALIASENCHANTMENTS.put("unlimitedarrows", Enchantment.ARROW_INFINITE);
        Enchantments.ALIASENCHANTMENTS.put("ai", Enchantment.ARROW_INFINITE);
    }
    
    public static Enchantment getEnchantment(final String string) {
        final String enchantmentName = string.toLowerCase();
        if (Enchantments.ENCHANTMENTS.get(enchantmentName) != null) {
            return Enchantments.ENCHANTMENTS.get(enchantmentName);
        }
        if (Enchantments.ALIASENCHANTMENTS.get(enchantmentName) != null) {
            return Enchantments.ALIASENCHANTMENTS.get(enchantmentName);
        }
        return null;
    }
}
