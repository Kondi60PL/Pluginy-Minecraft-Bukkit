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
/*  14:    */ public class GiveCommand
/*  15:    */   implements CommandExecutor
/*  16:    */ {
/*  17:    */   Main plugin;
/*  18:    */   
/*  19:    */   public GiveCommand(Main plugin)
/*  20:    */   {
/*  21: 18 */     this.plugin = plugin;
/*  22: 19 */     this.plugin.getCommand("give").setExecutor(this);
/*  23:    */   }
/*  24:    */   
/*  25:    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*  26:    */   {
/*  27: 25 */     if (args.length == 3)
/*  28:    */     {
/*  29: 27 */       senderPlayerAndConsole(sender, args);
/*  30:    */     }
/*  31: 29 */     else if (args.length == 2)
/*  32:    */     {
/*  33: 31 */       if ((sender instanceof Player))
/*  34:    */       {
/*  35: 33 */         senderOnlyPlayer(sender, args);
/*  36: 34 */         return true;
/*  37:    */       }
/*  38: 36 */       senderPlayerAndConsole(sender, args);
/*  39:    */     }
/*  40: 38 */     else if (args.length == 1)
/*  41:    */     {
/*  42: 40 */       if (!(sender instanceof Player))
/*  43:    */       {
/*  44: 42 */         sender.sendMessage("§cPoprawne uzycie: §6/give <gracz> <id> [ilosc]");
/*  45: 43 */         return true;
/*  46:    */       }
/*  47: 45 */       senderOnlyPlayer(sender, args);
/*  48:    */     }
/*  49:    */     else
/*  50:    */     {
/*  51: 49 */       sender.sendMessage("§cPoprawne uzycie: §6/give <gracz> <id> [ilosc]");
/*  52:    */     }
/*  53: 52 */     return false;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public boolean senderOnlyPlayer(CommandSender sender, String[] args)
/*  57:    */   {
/*  58: 58 */     Player player = (Player)sender;
/*  59: 59 */     String[] idAndData = args[0].split(":");
/*  60: 60 */     Material material = Main.getMaterial(idAndData[0]);
/*  61: 61 */     Player other = null;
/*  62: 63 */     if (material == null)
/*  63:    */     {
/*  64: 65 */       if (args.length == 2)
/*  65:    */       {
/*  66: 67 */         idAndData = args[1].split(":");
/*  67: 68 */         other = Bukkit.getPlayerExact(args[0]);
/*  68:    */       }
/*  69: 70 */       material = Main.getMaterial(idAndData[0]);
/*  70: 71 */       if (material == null)
/*  71:    */       {
/*  72: 73 */         player.sendMessage("§cNie rozpoznano nazwy przedmiotu!");
/*  73: 74 */         return true;
/*  74:    */       }
/*  75:    */     }
/*  76: 77 */     if (other == null) {
/*  77: 79 */       if (Main.isInteger(args[0]))
/*  78:    */       {
/*  79: 81 */         if (args.length == 2)
/*  80:    */         {
/*  81: 83 */           other = Bukkit.getPlayerExact(player.getName());
/*  82: 84 */           if (other == null)
/*  83:    */           {
/*  84: 86 */             player.sendMessage("§cTen gracz nie jest Online!");
/*  85: 87 */             return true;
/*  86:    */           }
/*  87:    */         }
/*  88:    */       }
/*  89:    */       else
/*  90:    */       {
/*  91: 93 */         player.sendMessage("§cTen gracz nie jest Online!");
/*  92: 94 */         return true;
/*  93:    */       }
/*  94:    */     }
/*  95: 97 */     Short data = Short.valueOf((short)0);
/*  96: 98 */     if (idAndData.length > 1) {
/*  97:100 */       data = Short.valueOf(idAndData[1]);
/*  98:    */     }
/*  99:102 */     int amount = 64;
/* 100:103 */     if (Bukkit.getPlayerExact(args[0]) != other) {
/* 101:105 */       if (args.length == 2) {
/* 102:107 */         if (Main.isInteger(args[1])) {
/* 103:109 */           amount = Integer.parseInt(args[1]);
/* 104:    */         }
/* 105:    */       }
/* 106:    */     }
/* 107:113 */     if (args.length == 1) {
/* 108:115 */       other = Bukkit.getPlayerExact(player.getName());
/* 109:    */     }
/* 110:117 */     ItemStack item = new ItemStack(material, amount, data.shortValue());
/* 111:118 */     if (player.getInventory().firstEmpty() >= 0)
/* 112:    */     {
/* 113:120 */       other.getInventory().addItem(new ItemStack[] { item });
/* 114:121 */       other.sendMessage("§6Otrzymales §c" + material.name() + "§6(§c" + amount + "§6).");
/* 115:122 */       player.sendMessage("§c" + other.getName() + " §6otrzymal §c" + material.name() + "§6(§c" + amount + "§6).");
/* 116:    */     }
/* 117:    */     else
/* 118:    */     {
/* 119:126 */       player.sendMessage("§c" + player.getName() + " §6nie ma miejsca w swoim ekwipunku!");
/* 120:    */     }
/* 121:128 */     return false;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public boolean senderPlayerAndConsole(CommandSender sender, String[] args)
/* 125:    */   {
/* 126:134 */     Player other = Bukkit.getPlayerExact(args[0]);
/* 127:135 */     if (other == null)
/* 128:    */     {
/* 129:137 */       sender.sendMessage("§cTen gracz nie jest Online!");
/* 130:138 */       return true;
/* 131:    */     }
/* 132:140 */     String[] idAndData = args[1].split(":");
/* 133:141 */     Material material = Main.getMaterial(idAndData[0]);
/* 134:142 */     if (material == null)
/* 135:    */     {
/* 136:144 */       sender.sendMessage("§cNie rozpoznano nazwy przedmiotu!");
/* 137:145 */       return true;
/* 138:    */     }
/* 139:147 */     Short data = Short.valueOf((short)0);
/* 140:148 */     if (idAndData.length > 1) {
/* 141:150 */       data = Short.valueOf(idAndData[1]);
/* 142:    */     }
/* 143:152 */     int amount = 64;
/* 144:153 */     if (args.length == 3) {
/* 145:155 */       if (Main.isInteger(args[2])) {
/* 146:157 */         amount = Integer.parseInt(args[2]);
/* 147:    */       }
/* 148:    */     }
/* 149:160 */     ItemStack item = new ItemStack(material, amount, data.shortValue());
/* 150:161 */     if (other.getInventory().firstEmpty() >= 0)
/* 151:    */     {
/* 152:163 */       other.getInventory().addItem(new ItemStack[] { item });
/* 153:164 */       other.sendMessage("§6Otrzymales §c" + material.name() + "§6(§c" + amount + "§6).");
/* 154:165 */       sender.sendMessage("§c" + other.getName() + " §6otrzymal §c" + material.name() + "§6(§c" + amount + "§6).");
/* 155:    */     }
/* 156:    */     else
/* 157:    */     {
/* 158:169 */       sender.sendMessage("§c" + other.getName() + " §6nie ma miejsca w swoim ekwipunku!");
/* 159:    */     }
/* 160:171 */     return false;
/* 161:    */   }
/* 162:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.GiveCommand
 * JD-Core Version:    0.7.0.1
 */