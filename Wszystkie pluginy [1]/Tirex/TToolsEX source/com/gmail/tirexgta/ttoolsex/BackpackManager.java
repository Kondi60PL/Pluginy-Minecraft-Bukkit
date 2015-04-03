package com.gmail.tirexgta.ttoolsex;

import java.io.*;
import org.bukkit.configuration.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class BackpackManager
{
    Main plugin;
    FileConfiguration data;
    public List<OfflinePlayer> playerByList;
    public HashMap<OfflinePlayer, List<ItemStack>> backpackItems;
    
    public BackpackManager(final Main plugin) {
        super();
        this.playerByList = new ArrayList<OfflinePlayer>();
        this.backpackItems = new HashMap<OfflinePlayer, List<ItemStack>>();
        this.plugin = plugin;
        this.data = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "backpack.yml"));
        for (final OfflinePlayer player : this.getPlayers()) {
            this.playerByList.add(player);
        }
        for (final OfflinePlayer player : this.playerByList) {
            this.backpackItems.put(player, this.getBackpack(player));
        }
        this.setupConfig();
    }
    
    public void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "backpack.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku backpack.yml");
        }
    }
    
    public void setupConfig() {
        if (!this.data.isConfigurationSection("backpack")) {
            this.data.createSection("backpack");
            this.saveData();
        }
        if (!this.data.isList("players")) {
            this.data.createSection("players");
            this.saveData();
        }
    }
    
    public List<OfflinePlayer> getPlayers() {
        final List<OfflinePlayer> listPlayers = new ArrayList<OfflinePlayer>();
        if (this.data.isList("players")) {
            final List<String> listByPlayers = (List<String>)this.data.getStringList("players");
            for (final String player : listByPlayers) {
                listPlayers.add(Bukkit.getOfflinePlayer(player));
            }
        }
        return listPlayers;
    }
    
    public List<ItemStack> getBackpack(final OfflinePlayer player) {
        return (List<ItemStack>)this.data.getList("backpack." + player.getName());
    }
    
    public void setBackpack(final Player player) {
        if (!this.data.isList("backpack." + player.getName())) {
            this.data.set("backpack." + player.getName(), (Object)new ArrayList());
        }
        if (!this.backpackItems.containsKey(player)) {
            this.backpackItems.put((OfflinePlayer)player, new ArrayList<ItemStack>());
        }
        this.data.set("backpack." + player.getName(), (Object)this.backpackItems.get(player));
        final List<String> rangiList = (List<String>)this.data.getStringList("players." + player.getName());
        if (!rangiList.contains(player.getName())) {
            rangiList.add(player.getName());
        }
        this.data.set("players", (Object)rangiList);
        if (!this.playerByList.contains(player)) {
            this.playerByList.add((OfflinePlayer)player);
        }
        this.saveData();
    }
    
    public void openPlecak(final Player p, final String namePlayer, final String namePlayerLow) {
        Inventory eq;
        if (p.hasPermission("tirex.vip")) {
            eq = Bukkit.createInventory((InventoryHolder)null, 36, "Plecak");
        }
        else {
            eq = Bukkit.createInventory((InventoryHolder)null, 27, "Plecak");
        }
        eq.clear();
        final Inventory eqPlayer = (Inventory)p.getInventory();
        if (this.backpackItems.containsKey(p)) {
            final List<ItemStack> itemy = this.backpackItems.get(p);
            if (itemy != null) {
                for (final ItemStack przedmioty : itemy) {
                    if (eq.firstEmpty() >= 0) {
                        eq.addItem(new ItemStack[] { przedmioty });
                    }
                    else if (eqPlayer.firstEmpty() >= 0) {
                        eqPlayer.addItem(new ItemStack[] { przedmioty });
                    }
                    else {
                        p.getWorld().dropItem(p.getLocation(), przedmioty);
                    }
                }
            }
        }
        p.openInventory(eq);
    }
}
