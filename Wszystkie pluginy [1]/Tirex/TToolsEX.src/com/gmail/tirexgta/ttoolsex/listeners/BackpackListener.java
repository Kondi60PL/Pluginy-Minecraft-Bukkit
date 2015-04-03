/*   1:    */ package com.gmail.tirexgta.ttoolsex.listeners;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.BackpackManager;
/*   4:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   5:    */ import com.gmail.tirexgta.ttoolsex.others.Recipe;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.HashMap;
/*   8:    */ import java.util.List;
/*   9:    */ import org.bukkit.Server;
/*  10:    */ import org.bukkit.Sound;
/*  11:    */ import org.bukkit.entity.HumanEntity;
/*  12:    */ import org.bukkit.entity.Player;
/*  13:    */ import org.bukkit.event.EventHandler;
/*  14:    */ import org.bukkit.event.Listener;
/*  15:    */ import org.bukkit.event.block.Action;
/*  16:    */ import org.bukkit.event.block.BlockPlaceEvent;
/*  17:    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*  18:    */ import org.bukkit.event.inventory.InventoryCloseEvent;
/*  19:    */ import org.bukkit.event.player.PlayerInteractEvent;
/*  20:    */ import org.bukkit.inventory.Inventory;
/*  21:    */ import org.bukkit.inventory.ItemStack;
/*  22:    */ import org.bukkit.inventory.meta.ItemMeta;
/*  23:    */ import org.bukkit.plugin.PluginManager;
/*  24:    */ 
/*  25:    */ public class BackpackListener
/*  26:    */   implements Listener
/*  27:    */ {
/*  28:    */   final Main plugin;
/*  29:    */   
/*  30:    */   public BackpackListener(Main plugin)
/*  31:    */   {
/*  32: 29 */     this.plugin = plugin;
/*  33: 30 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/*  34:    */   }
/*  35:    */   
/*  36:    */   @EventHandler
/*  37:    */   public static void onInventoryClick(InventoryClickEvent e)
/*  38:    */   {
/*  39: 36 */     Inventory inventory = e.getInventory();
/*  40: 37 */     if (inventory.getTitle().equals("Plecak"))
/*  41:    */     {
/*  42: 39 */       ItemStack plecak = Recipe.itemSuperChest();
/*  43: 40 */       ItemStack przedmiot = e.getCurrentItem();
/*  44: 41 */       if (przedmiot == null) {
/*  45: 43 */         return;
/*  46:    */       }
/*  47: 45 */       ItemMeta przedmiotMeta = przedmiot.getItemMeta();
/*  48: 46 */       if (przedmiotMeta == null) {
/*  49: 48 */         return;
/*  50:    */       }
/*  51: 50 */       if (przedmiotMeta.equals(plecak.getItemMeta()))
/*  52:    */       {
/*  53: 52 */         e.setCancelled(true);
/*  54: 53 */         e.getWhoClicked().openInventory(inventory);
/*  55:    */       }
/*  56:    */     }
/*  57:    */   }
/*  58:    */   
/*  59:    */   @EventHandler
/*  60:    */   public void onInventoryClose(InventoryCloseEvent e)
/*  61:    */   {
/*  62: 61 */     Inventory inventory = e.getInventory();
/*  63: 62 */     HumanEntity he = e.getPlayer();
/*  64: 63 */     Player p = (Player)he;
/*  65: 64 */     String namePlayer = p.getName();
/*  66: 65 */     String namePlayerLow = namePlayer;
/*  67: 67 */     if (inventory.getName().equals("Plecak"))
/*  68:    */     {
/*  69: 69 */       List<ItemStack> listMaterial = new ArrayList();
/*  70: 70 */       for (ItemStack przedmioty : inventory.getContents()) {
/*  71: 72 */         if (przedmioty != null) {
/*  72: 74 */           listMaterial.add(przedmioty);
/*  73:    */         }
/*  74:    */       }
/*  75: 77 */       if (this.plugin.backpackManager.backpackItems.containsKey(namePlayerLow)) {
/*  76: 79 */         this.plugin.backpackManager.backpackItems.remove(p);
/*  77:    */       }
/*  78: 81 */       this.plugin.backpackManager.backpackItems.put(p, listMaterial);
/*  79: 82 */       this.plugin.backpackManager.setBackpack(p);
/*  80: 83 */       p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0F, 1.0F);
/*  81:    */     }
/*  82:    */   }
/*  83:    */   
/*  84:    */   @EventHandler
/*  85:    */   public void onPlayerInteract(PlayerInteractEvent e)
/*  86:    */   {
/*  87: 90 */     if (e.getAction() == Action.RIGHT_CLICK_AIR)
/*  88:    */     {
/*  89: 92 */       ItemStack superchest = Recipe.itemSuperChest();
/*  90: 94 */       if (e.getItem().getItemMeta().equals(superchest.getItemMeta()))
/*  91:    */       {
/*  92: 96 */         Player p = e.getPlayer();
/*  93: 97 */         String namePlayer = p.getName();
/*  94: 98 */         String namePlayerLow = namePlayer;
/*  95: 99 */         this.plugin.backpackManager.openPlecak(p, namePlayer, namePlayerLow);
/*  96:100 */         p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
/*  97:    */       }
/*  98:    */     }
/*  99:    */   }
/* 100:    */   
/* 101:    */   @EventHandler
/* 102:    */   public void onBlockPlace(BlockPlaceEvent e)
/* 103:    */   {
/* 104:108 */     Player p = e.getPlayer();
/* 105:109 */     String namePlayer = p.getName();
/* 106:110 */     String namePlayerLow = namePlayer;
/* 107:112 */     if (e.getItemInHand().getItemMeta().equals(Recipe.itemSuperChest().getItemMeta()))
/* 108:    */     {
/* 109:114 */       this.plugin.backpackManager.openPlecak(p, namePlayer, namePlayerLow);
/* 110:115 */       p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
/* 111:116 */       e.setCancelled(true);
/* 112:    */     }
/* 113:    */   }
/* 114:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.BackpackListener
 * JD-Core Version:    0.7.0.1
 */