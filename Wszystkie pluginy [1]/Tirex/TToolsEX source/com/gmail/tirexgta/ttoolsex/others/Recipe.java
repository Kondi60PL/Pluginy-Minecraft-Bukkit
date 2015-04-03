package com.gmail.tirexgta.ttoolsex.others;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class Recipe
{
    Main plugin;
    
    public Recipe(final Main plugin) {
        super();
        this.plugin = plugin;
        registerSuperChest();
        registerSuperStoniarka();
    }
    
    public static void registerSuperChest() {
        final ItemStack superchest = itemSuperChest();
        final ShapedRecipe recipe = new ShapedRecipe(new ItemStack(superchest)).shape(new String[] { "OOO", "DCD", "OOO" }).setIngredient('O', Material.OBSIDIAN).setIngredient('D', Material.DIAMOND).setIngredient('C', Material.CHEST);
        Bukkit.getServer().addRecipe((org.bukkit.inventory.Recipe)recipe);
    }
    
    public static void registerPokeBall() {
        final ItemStack pokeball = itemPokeBall();
        final ShapedRecipe recipe = new ShapedRecipe(new ItemStack(pokeball)).shape(new String[] { "OGO", "RSR", "OFO" }).setIngredient('O', Material.OBSIDIAN).setIngredient('G', Material.GLASS).setIngredient('R', Material.REDSTONE_BLOCK).setIngredient('S', Material.getMaterial(175)).setIngredient('F', Material.FLOWER_POT_ITEM);
        Bukkit.getServer().addRecipe((org.bukkit.inventory.Recipe)recipe);
    }
    
    public static void registerSuperStoniarka() {
        final ItemStack superchest = itemSuperStoniarka();
        final ShapedRecipe recipe = new ShapedRecipe(new ItemStack(superchest)).shape(new String[] { "RPR", "DGD", "RPR" }).setIngredient('R', Material.REDSTONE_BLOCK).setIngredient('D', Material.DIAMOND).setIngredient('G', Material.GLASS).setIngredient('P', Material.FLOWER_POT_ITEM);
        Bukkit.getServer().addRecipe((org.bukkit.inventory.Recipe)recipe);
    }
    
    public static ItemStack itemSuperChest() {
        final ItemStack superchest = new ItemStack(Material.TRAPPED_CHEST);
        final ItemMeta meta = superchest.getItemMeta();
        meta.setDisplayName("§6§lSuper§f§lChest!");
        final List<String> opis = new ArrayList<String>();
        opis.add("§bMoc Tirexa X");
        opis.add(" §f§l> §cWcisnij Prawy Przycisk Myszy,");
        opis.add("     §caby otworzyc Plecak!");
        meta.setLore((List)opis);
        superchest.setItemMeta(meta);
        return superchest;
    }
    
    public static ItemStack itemPokeBall() {
        final ItemStack pokeball = new ItemStack(Material.getMaterial(175));
        final ItemMeta meta = pokeball.getItemMeta();
        meta.setDisplayName("§6Pok\u00e8ball!");
        final List<String> opis = new ArrayList<String>();
        opis.add("§bMoc Tirexa X");
        opis.add(" §f§l> §cNacisnij Prawym Przyciskiem Myszy");
        opis.add("     §cna Potwora, ktorego chcesz zlapac!");
        meta.setLore((List)opis);
        pokeball.setItemMeta(meta);
        return pokeball;
    }
    
    public static ItemStack itemSuperStoniarka() {
        final ItemStack stoniarka = new ItemStack(Material.DAYLIGHT_DETECTOR);
        final ItemMeta meta = stoniarka.getItemMeta();
        meta.setDisplayName("§b§lStone§6§lArka!");
        final List<String> opis = new ArrayList<String>();
        opis.add("§bMoc Tirexa X");
        opis.add(" §f§l> §cPoloz ten blok na ziemi, aby zaczal");
        opis.add("     §csie generowac stone!");
        meta.setLore((List)opis);
        stoniarka.setItemMeta(meta);
        return stoniarka;
    }
}
