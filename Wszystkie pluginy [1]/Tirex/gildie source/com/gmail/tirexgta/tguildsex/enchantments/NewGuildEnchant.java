package com.gmail.tirexgta.tguildsex.enchantments;

import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;

public class NewGuildEnchant extends Enchantment
{
    public NewGuildEnchant(final int id) {
        super(id);
    }
    
    public boolean canEnchantItem(final ItemStack arg0) {
        return true;
    }
    
    public boolean conflictsWith(final Enchantment arg0) {
        return false;
    }
    
    public EnchantmentTarget getItemTarget() {
        return null;
    }
    
    public int getMaxLevel() {
        return 69;
    }
    
    public String getName() {
        return "Moc Zakladania Gildii";
    }
    
    public int getStartLevel() {
        return 1;
    }
}
