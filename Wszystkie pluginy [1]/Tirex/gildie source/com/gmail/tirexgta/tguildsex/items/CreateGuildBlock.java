package com.gmail.tirexgta.tguildsex.items;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;
import java.util.*;

public class CreateGuildBlock
{
    Main plugin;
    
    public CreateGuildBlock(final Main plugin) {
        super();
        this.plugin = plugin;
    }
    
    public final ItemStack getItem() {
        final ItemStack item = new ItemStack(Material.BED);
        item.addUnsafeEnchantment((Enchantment)this.plugin.newGuildEnchantt, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("dasd");
        final String[] lore = { "§cPostaw na ziemi,", "§czeby zalozyc gildie!" };
        meta.setLore((List)this.getLore(lore));
        item.setItemMeta(meta);
        return item;
    }
    
    public final Recipe getRecipe() {
        return null;
    }
    
    private final List<String> getLore(final String[] arg0) {
        final List<String> lore = new ArrayList<String>();
        for (final String s : arg0) {
            lore.add(s);
        }
        return lore;
    }
}
