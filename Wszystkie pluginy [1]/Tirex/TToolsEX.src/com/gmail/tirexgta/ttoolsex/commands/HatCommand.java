/*   1:    */ package com.gmail.tirexgta.ttoolsex.commands;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import org.bukkit.Bukkit;
/*   5:    */ import org.bukkit.Material;
/*   6:    */ import org.bukkit.command.Command;
/*   7:    */ import org.bukkit.command.CommandExecutor;
/*   8:    */ import org.bukkit.command.CommandSender;
/*   9:    */ import org.bukkit.command.PluginCommand;
/*  10:    */ import org.bukkit.entity.Player;
/*  11:    */ import org.bukkit.inventory.ItemStack;
/*  12:    */ import org.bukkit.inventory.PlayerInventory;
/*  13:    */ 
/*  14:    */ public class HatCommand
/*  15:    */   implements CommandExecutor
/*  16:    */ {
/*  17:    */   Main plugin;
/*  18:    */   
/*  19:    */   public HatCommand(Main plugin)
/*  20:    */   {
/*  21: 20 */     this.plugin = plugin;
/*  22: 21 */     this.plugin.getCommand("hat").setExecutor(this);
/*  23:    */   }
/*  24:    */   
/*  25:    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*  26:    */   {
/*  27: 29 */     if (args.length == 0)
/*  28:    */     {
/*  29: 31 */       if (!(sender instanceof Player))
/*  30:    */       {
/*  31: 33 */         sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
/*  32: 34 */         return true;
/*  33:    */       }
/*  34: 36 */       Player player = (Player)sender;
/*  35: 37 */       ItemStack item = player.getItemInHand();
/*  36: 38 */       if (!item.getType().isBlock())
/*  37:    */       {
/*  38: 40 */         player.sendMessage("§cTego przedmiotu nie mozna zalozyc na glowe!");
/*  39: 41 */         return true;
/*  40:    */       }
/*  41: 43 */       player.getInventory().setItemInHand(null);
/*  42: 44 */       if (player.getInventory().getHelmet() != null)
/*  43:    */       {
/*  44: 46 */         ItemStack helmet = player.getInventory().getHelmet();
/*  45: 47 */         player.setItemInHand(helmet);
/*  46:    */       }
/*  47: 49 */       player.getInventory().setHelmet(item);
/*  48: 50 */       player.sendMessage("§6Ciesz sie nowa czapka!");
/*  49:    */     }
/*  50: 52 */     else if (args.length == 1)
/*  51:    */     {
/*  52: 54 */       if (!(sender instanceof Player))
/*  53:    */       {
/*  54: 56 */         sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
/*  55: 57 */         return true;
/*  56:    */       }
/*  57: 59 */       if (!sender.hasPermission("tirex.hat.other"))
/*  58:    */       {
/*  59: 61 */         sender.sendMessage("§cNie masz dostepu!");
/*  60: 62 */         return true;
/*  61:    */       }
/*  62: 64 */       Player other = Bukkit.getPlayerExact(args[0]);
/*  63: 65 */       Player player = (Player)sender;
/*  64: 66 */       if (other == null)
/*  65:    */       {
/*  66: 68 */         sender.sendMessage("§cTen gracz nie jest Online!");
/*  67: 69 */         return true;
/*  68:    */       }
/*  69: 71 */       if (other == player)
/*  70:    */       {
/*  71: 73 */         sender.sendMessage("§cNie mozesz dac sobie czapki!");
/*  72: 74 */         return true;
/*  73:    */       }
/*  74: 76 */       ItemStack item = player.getItemInHand();
/*  75: 77 */       if (!item.getType().isBlock())
/*  76:    */       {
/*  77: 79 */         player.sendMessage("§cTego przedmiotu nie mozna zalozyc na glowe!");
/*  78: 80 */         return true;
/*  79:    */       }
/*  80: 82 */       if (other.getItemInHand().getType() != Material.AIR)
/*  81:    */       {
/*  82: 84 */         player.sendMessage("§cTen gracz ma pelna reke!");
/*  83: 85 */         return true;
/*  84:    */       }
/*  85: 87 */       if (other.getInventory().getHelmet() != null)
/*  86:    */       {
/*  87: 89 */         ItemStack helmet = other.getInventory().getHelmet();
/*  88: 90 */         other.setItemInHand(helmet);
/*  89:    */       }
/*  90: 92 */       player.getInventory().setHelmet(item);
/*  91: 93 */       other.sendMessage("§6Ciesz sie nowa czapka od §c" + player.getName() + " §6;)");
/*  92: 94 */       player.sendMessage("§c" + other.getName() + " §6cieszy sie nowa czapka!");
/*  93:    */     }
/*  94:    */     else
/*  95:    */     {
/*  96: 98 */       sender.sendMessage("§cPoprawne uzycie: §6/hat [gracz]");
/*  97:    */     }
/*  98:101 */     return false;
/*  99:    */   }
/* 100:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.HatCommand
 * JD-Core Version:    0.7.0.1
 */