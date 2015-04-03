/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Bukkit;
/*  5:   */ import org.bukkit.ChatColor;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ import org.bukkit.inventory.PlayerInventory;
/* 12:   */ 
/* 13:   */ public class ClearCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public ClearCommand(Main plugin)
/* 19:   */   {
/* 20:18 */     this.plugin = plugin;
/* 21:19 */     this.plugin.getCommand("clear").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:26 */     if (args.length == 0)
/* 27:   */     {
/* 28:28 */       if (!(sender instanceof Player))
/* 29:   */       {
/* 30:30 */         sender.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GOLD + " /clear <gracz>");
/* 31:31 */         return true;
/* 32:   */       }
/* 33:33 */       Player other = Bukkit.getPlayerExact(sender.getName());
/* 34:34 */       other.getInventory().clear();
/* 35:35 */       other.getInventory().setHelmet(null);
/* 36:36 */       other.getInventory().setChestplate(null);
/* 37:37 */       other.getInventory().setLeggings(null);
/* 38:38 */       other.getInventory().setBoots(null);
/* 39:39 */       other.getInventory().setHeldItemSlot(0);
/* 40:40 */       other.sendMessage("§6Twoj ekwipunek zostal wyczyszczony!");
/* 41:41 */       return true;
/* 42:   */     }
/* 43:43 */     if (args.length == 1)
/* 44:   */     {
/* 45:45 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 46:46 */       if (other == null)
/* 47:   */       {
/* 48:48 */         sender.sendMessage("§cTen gracz nie jest Online!");
/* 49:49 */         return true;
/* 50:   */       }
/* 51:51 */       other.getInventory().clear();
/* 52:52 */       other.getInventory().setHelmet(null);
/* 53:53 */       other.getInventory().setChestplate(null);
/* 54:54 */       other.getInventory().setLeggings(null);
/* 55:55 */       other.getInventory().setBoots(null);
/* 56:56 */       other.getInventory().setHeldItemSlot(0);
/* 57:57 */       other.sendMessage("§6Twoj ekwipunek zostal wyczyszczony przez gracza §c" + sender.getName() + "§6!");
/* 58:58 */       sender.sendMessage(ChatColor.GOLD + "Ekwipunek gracza " + ChatColor.RED + other.getName() + ChatColor.GOLD + " zostal wyczyszczony!");
/* 59:59 */       return true;
/* 60:   */     }
/* 61:61 */     return false;
/* 62:   */   }
/* 63:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.ClearCommand
 * JD-Core Version:    0.7.0.1
 */