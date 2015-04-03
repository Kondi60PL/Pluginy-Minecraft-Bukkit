package com.gmail.tirexgta.ttoolsex.others;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.enchantments.*;
import java.util.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;

public class Pokeball
{
    Main plugin;
    
    public Pokeball(final Main plugin) {
        super();
        this.plugin = plugin;
    }
    
    public static ItemStack pokeball(final String nazwa, final int id, final String potwor) {
        final ItemStack pokeball = new ItemStack(Material.getMaterial(175));
        final ItemMeta meta = pokeball.getItemMeta();
        meta.setDisplayName("§6Pok\u00e8ball z " + potwor + "!");
        meta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        final List<String> opis = new ArrayList<String>();
        opis.add(" §f> §6Nazwa Potwora: §6" + nazwa);
        opis.add(" §f> §6ID Moba: §6" + id);
        meta.setLore((List)opis);
        pokeball.setItemMeta(meta);
        return pokeball;
    }
    
    public static void click(final PlayerInteractEntityEvent e) {
        final ItemStack pokeball = Recipe.itemPokeBall();
        final Player p = e.getPlayer();
        if (p.getItemInHand().getItemMeta() == null) {
            return;
        }
        if (!p.getItemInHand().getItemMeta().equals(pokeball.getItemMeta())) {
            return;
        }
        final Entity potwor = e.getRightClicked();
        EntityType stwor = null;
        if (potwor.getType() == EntityType.COW) {
            stwor = potwor.getType();
        }
        else if (potwor.getType() == EntityType.PIG) {
            stwor = potwor.getType();
        }
        else if (potwor.getType() == EntityType.SHEEP) {
            stwor = potwor.getType();
        }
        else if (potwor.getType() == EntityType.HORSE) {
            stwor = potwor.getType();
        }
        else if (potwor.getType() == EntityType.CHICKEN) {
            stwor = potwor.getType();
        }
        else if (potwor.getType() == EntityType.OCELOT) {
            stwor = potwor.getType();
        }
        else if (potwor.getType() == EntityType.WOLF) {
            stwor = potwor.getType();
        }
        else if (potwor.getType() == EntityType.VILLAGER) {
            stwor = potwor.getType();
        }
        else {
            if (potwor.getType() == EntityType.PLAYER) {
                p.sendMessage("§cheheszky, to nie pok\u00e8mon!");
                return;
            }
            p.sendMessage("§cza duzy ten pok\u00e8mon!");
            return;
        }
        stwor = EntityType.ARROW;
    }
}
