/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Bukkit;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ import org.bukkit.event.inventory.InventoryType;
/* 11:   */ import org.bukkit.inventory.Inventory;
/* 12:   */ 
/* 13:   */ public class WymianaCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public WymianaCommand(Main plugin)
/* 19:   */   {
/* 20:19 */     this.plugin = plugin;
/* 21:20 */     this.plugin.getCommand("wymiana").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:26 */     if (!(sender instanceof Player))
/* 27:   */     {
/* 28:28 */       sender.sendMessage("§4Tej komendy nie mozna wykonac z poziomu konsoli!");
/* 29:29 */       return true;
/* 30:   */     }
/* 31:32 */     Player p = (Player)sender;
/* 32:   */     
/* 33:34 */     Inventory eq = Bukkit.createInventory(null, InventoryType.MERCHANT);
/* 34:   */     
/* 35:36 */     p.openInventory(eq);
/* 36:   */     
/* 37:   */ 
/* 38:39 */     return false;
/* 39:   */   }
/* 40:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.WymianaCommand
 * JD-Core Version:    0.7.0.1
 */