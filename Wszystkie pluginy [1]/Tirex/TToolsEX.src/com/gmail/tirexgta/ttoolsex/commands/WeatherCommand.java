/*   1:    */ package com.gmail.tirexgta.ttoolsex.commands;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import org.bukkit.Bukkit;
/*   5:    */ import org.bukkit.World;
/*   6:    */ import org.bukkit.command.Command;
/*   7:    */ import org.bukkit.command.CommandExecutor;
/*   8:    */ import org.bukkit.command.CommandSender;
/*   9:    */ import org.bukkit.command.PluginCommand;
/*  10:    */ import org.bukkit.entity.Player;
/*  11:    */ 
/*  12:    */ public class WeatherCommand
/*  13:    */   implements CommandExecutor
/*  14:    */ {
/*  15:    */   Main plugin;
/*  16: 15 */   String[] sun = { "sky", "sun", "clear", "slonce", "1" };
/*  17: 16 */   String[] rain = { "rain", "storm", "deszcz", "2" };
/*  18: 17 */   String[] thunder = { "thunder", "thundering", "lightning", "burza", "3" };
/*  19:    */   
/*  20:    */   public WeatherCommand(Main plugin)
/*  21:    */   {
/*  22: 21 */     this.plugin = plugin;
/*  23: 22 */     this.plugin.getCommand("weather").setExecutor(this);
/*  24:    */   }
/*  25:    */   
/*  26:    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*  27:    */   {
/*  28: 28 */     if ((sender instanceof Player))
/*  29:    */     {
/*  30: 30 */       if ((args.length == 1) || (args.length == 2))
/*  31:    */       {
/*  32: 32 */         Player p = (Player)sender;
/*  33: 33 */         String weather = args[0];
/*  34: 34 */         World world = p.getWorld();
/*  35: 35 */         if (this.plugin.containsIgnoreCase(this.sun, weather))
/*  36:    */         {
/*  37: 37 */           world.setStorm(false);
/*  38: 38 */           world.setThundering(false);
/*  39: 39 */           sender.sendMessage("§6Ustawiles sloneczna pogode w §c" + world.getName());
/*  40:    */         }
/*  41: 41 */         else if (this.plugin.containsIgnoreCase(this.rain, weather))
/*  42:    */         {
/*  43: 43 */           world.setThundering(false);
/*  44: 44 */           world.setStorm(true);
/*  45: 45 */           sender.sendMessage("§6Ustawiles deszczowa pogode w §c" + world.getName());
/*  46:    */         }
/*  47: 47 */         else if (this.plugin.containsIgnoreCase(this.thunder, weather))
/*  48:    */         {
/*  49: 49 */           int time = 300;
/*  50: 50 */           if (args.length == 2) {
/*  51: 52 */             if (Main.isInteger(args[1])) {
/*  52: 54 */               time = Integer.parseInt(args[1]);
/*  53:    */             }
/*  54:    */           }
/*  55: 57 */           world.setThunderDuration(time);
/*  56: 58 */           sender.sendMessage("§6Ustawiles burzliwa pogode w §c" + world.getName());
/*  57:    */         }
/*  58:    */         else
/*  59:    */         {
/*  60: 62 */           sender.sendMessage("§cPoprawne uzycie: §6/weather <pogoda> [czas burzy]");
/*  61:    */         }
/*  62:    */       }
/*  63:    */       else
/*  64:    */       {
/*  65: 67 */         sender.sendMessage("§cPoprawne uzycie: §6/weather <pogoda> [czas burzy]");
/*  66:    */       }
/*  67:    */     }
/*  68: 72 */     else if ((args.length == 2) || (args.length == 3))
/*  69:    */     {
/*  70: 74 */       String weather = args[1];
/*  71: 75 */       World world = Bukkit.getWorld(args[0]);
/*  72: 76 */       if (world == null)
/*  73:    */       {
/*  74: 78 */         sender.sendMessage("§cNie ma takiego swiata!");
/*  75: 79 */         return true;
/*  76:    */       }
/*  77: 81 */       if (this.plugin.containsIgnoreCase(this.sun, weather))
/*  78:    */       {
/*  79: 83 */         world.setStorm(false);
/*  80: 84 */         world.setThundering(false);
/*  81: 85 */         sender.sendMessage("§6Ustawiles sloneczna pogode w §c" + world.getName());
/*  82:    */       }
/*  83: 87 */       else if (this.plugin.containsIgnoreCase(this.rain, weather))
/*  84:    */       {
/*  85: 89 */         world.setThundering(false);
/*  86: 90 */         world.setStorm(true);
/*  87: 91 */         sender.sendMessage("§6Ustawiles deszczowa pogode w §c" + world.getName());
/*  88:    */       }
/*  89: 93 */       else if (this.plugin.containsIgnoreCase(this.thunder, weather))
/*  90:    */       {
/*  91: 95 */         int time = 300;
/*  92: 96 */         if (args.length == 3) {
/*  93: 98 */           if (Main.isInteger(args[2])) {
/*  94:100 */             time = Integer.parseInt(args[2]);
/*  95:    */           }
/*  96:    */         }
/*  97:103 */         world.setThunderDuration(time);
/*  98:104 */         sender.sendMessage("§6Ustawiles burzliwa pogode w §c" + world.getName());
/*  99:    */       }
/* 100:    */       else
/* 101:    */       {
/* 102:108 */         sender.sendMessage("§cPoprawne uzycie: §6/weather <swiat> <pogoda> [czas burzy]");
/* 103:    */       }
/* 104:    */     }
/* 105:    */     else
/* 106:    */     {
/* 107:113 */       sender.sendMessage("§cPoprawne uzycie: §6/weather <swiat> <pogoda> [czas burzy]");
/* 108:    */     }
/* 109:117 */     return false;
/* 110:    */   }
/* 111:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.WeatherCommand
 * JD-Core Version:    0.7.0.1
 */