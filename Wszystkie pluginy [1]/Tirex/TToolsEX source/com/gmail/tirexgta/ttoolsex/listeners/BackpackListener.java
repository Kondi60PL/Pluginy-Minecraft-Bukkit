package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import com.gmail.tirexgta.ttoolsex.others.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

public class BackpackListener implements Listener
{
    final Main plugin;
    
    public BackpackListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public static void onInventoryClick(final InventoryClickEvent e) {
        final Inventory inventory = e.getInventory();
        if (inventory.getTitle().equals("Plecak")) {
            final ItemStack plecak = Recipe.itemSuperChest();
            final ItemStack przedmiot = e.getCurrentItem();
            if (przedmiot == null) {
                return;
            }
            final ItemMeta przedmiotMeta = przedmiot.getItemMeta();
            if (przedmiotMeta == null) {
                return;
            }
            if (przedmiotMeta.equals(plecak.getItemMeta())) {
                e.setCancelled(true);
                e.getWhoClicked().openInventory(inventory);
            }
        }
    }
    
    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent e) {
        final Inventory inventory = e.getInventory();
        final HumanEntity he = e.getPlayer();
        final Player p = (Player)he;
        final String namePlayerLow;
        final String namePlayer = namePlayerLow = p.getName();
        if (inventory.getName().equals("Plecak")) {
            final List<ItemStack> listMaterial = new ArrayList<ItemStack>();
            ItemStack[] contents;
            for (int length = (contents = inventory.getContents()).length, i = 0; i < length; ++i) {
                final ItemStack przedmioty = contents[i];
                if (przedmioty != null) {
                    listMaterial.add(przedmioty);
                }
            }
            if (this.plugin.backpackManager.backpackItems.containsKey(namePlayerLow)) {
                this.plugin.backpackManager.backpackItems.remove(p);
            }
            this.plugin.backpackManager.backpackItems.put((OfflinePlayer)p, listMaterial);
            this.plugin.backpackManager.setBackpack(p);
            p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0f, 1.0f);
        }
    }
    
    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            final ItemStack superchest = Recipe.itemSuperChest();
            if (e.getItem().getItemMeta().equals(superchest.getItemMeta())) {
                final Player p = e.getPlayer();
                final String namePlayerLow;
                final String namePlayer = namePlayerLow = p.getName();
                this.plugin.backpackManager.openPlecak(p, namePlayer, namePlayerLow);
                p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0f, 1.0f);
            }
        }
    }
    
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final String namePlayerLow;
        final String namePlayer = namePlayerLow = p.getName();
        if (e.getItemInHand().getItemMeta().equals(Recipe.itemSuperChest().getItemMeta())) {
            this.plugin.backpackManager.openPlecak(p, namePlayer, namePlayerLow);
            p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0f, 1.0f);
            e.setCancelled(true);
        }
    }
}
