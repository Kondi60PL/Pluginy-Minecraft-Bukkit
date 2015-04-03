/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Material;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ import org.bukkit.inventory.ItemStack;
/* 11:   */ import org.bukkit.inventory.PlayerInventory;
/* 12:   */ import org.bukkit.inventory.meta.SkullMeta;
/* 13:   */ 
/* 14:   */ public class HeadCommand
/* 15:   */   implements CommandExecutor
/* 16:   */ {
/* 17:   */   Main plugin;
/* 18:   */   
/* 19:   */   public HeadCommand(Main plugin)
/* 20:   */   {
/* 21:19 */     this.plugin = plugin;
/* 22:20 */     this.plugin.getCommand("head").setExecutor(this);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 26:   */   {
/* 27:26 */     if (args.length == 0)
/* 28:   */     {
/* 29:28 */       if (!(sender instanceof Player))
/* 30:   */       {
/* 31:30 */         sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
/* 32:31 */         return true;
/* 33:   */       }
/* 34:33 */       Player player = (Player)sender;
/* 35:34 */       ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
/* 36:35 */       SkullMeta meta = (SkullMeta)item.getItemMeta();
/* 37:36 */       meta.setOwner(player.getName());
/* 38:37 */       item.setItemMeta(meta);
/* 39:38 */       player.getInventory().addItem(new ItemStack[] { item });
/* 40:39 */       player.sendMessage("§6Glowa gracza §c" + player.getName() + " §6zostala dodana do twojego ekwipunku!");
/* 41:   */     }
/* 42:41 */     else if (args.length == 1)
/* 43:   */     {
/* 44:43 */       if (!(sender instanceof Player))
/* 45:   */       {
/* 46:45 */         sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
/* 47:46 */         return true;
/* 48:   */       }
/* 49:48 */       Player player = (Player)sender;
/* 50:49 */       String otherName = args[0];
/* 51:50 */       ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
/* 52:51 */       SkullMeta meta = (SkullMeta)item.getItemMeta();
/* 53:52 */       meta.setOwner(otherName);
/* 54:53 */       item.setItemMeta(meta);
/* 55:54 */       player.getInventory().addItem(new ItemStack[] { item });
/* 56:55 */       player.sendMessage("§6Glowa gracza §c" + otherName + " §6zostala dodana do twojego ekwipunku!");
/* 57:   */     }
/* 58:   */     else
/* 59:   */     {
/* 60:59 */       sender.sendMessage("§cPoprawne uzycie: §6/head [gracz]");
/* 61:   */     }
/* 62:62 */     return false;
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.HeadCommand
 * JD-Core Version:    0.7.0.1
 */