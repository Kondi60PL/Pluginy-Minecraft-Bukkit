/*   1:    */ package com.gmail.tirexgta.ttoolsex.commands;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import java.util.HashMap;
/*   5:    */ import org.bukkit.Bukkit;
/*   6:    */ import org.bukkit.World;
/*   7:    */ import org.bukkit.command.Command;
/*   8:    */ import org.bukkit.command.CommandExecutor;
/*   9:    */ import org.bukkit.command.CommandSender;
/*  10:    */ import org.bukkit.command.PluginCommand;
/*  11:    */ import org.bukkit.entity.Player;
/*  12:    */ 
/*  13:    */ public class TimeCommand
/*  14:    */   implements CommandExecutor
/*  15:    */ {
/*  16:    */   Main plugin;
/*  17: 17 */   HashMap<String, Integer> ticksAliases = new HashMap();
/*  18:    */   
/*  19:    */   public TimeCommand(Main plugin)
/*  20:    */   {
/*  21: 21 */     this.plugin = plugin;
/*  22: 22 */     this.plugin.getCommand("time").setExecutor(this);
/*  23:    */     
/*  24: 24 */     this.ticksAliases.put("dawn", Integer.valueOf(0));
/*  25: 25 */     this.ticksAliases.put("day", Integer.valueOf(6000));
/*  26: 26 */     this.ticksAliases.put("dusk", Integer.valueOf(12000));
/*  27: 27 */     this.ticksAliases.put("night", Integer.valueOf(18000));
/*  28:    */   }
/*  29:    */   
/*  30:    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*  31:    */   {
/*  32: 33 */     if (args.length == 1)
/*  33:    */     {
/*  34: 35 */       if (!(sender instanceof Player))
/*  35:    */       {
/*  36: 37 */         sender.sendMessage("§cPoprawne uzycie: §6/time <swiat> <pora>");
/*  37: 38 */         return true;
/*  38:    */       }
/*  39: 40 */       Player p = (Player)sender;
/*  40: 41 */       if (Main.isInteger(args[0]))
/*  41:    */       {
/*  42: 43 */         int czas = Integer.parseInt(args[0]);
/*  43: 44 */         if (czas <= 24)
/*  44:    */         {
/*  45: 46 */           p.getWorld().setTime(czas * 1000);
/*  46: 47 */           sender.sendMessage("§7Ustawiles czas na swiecie §c" + p.getWorld().getName() + " §7na godzine §c" + czas);
/*  47:    */         }
/*  48:    */         else
/*  49:    */         {
/*  50: 51 */           sender.sendMessage("§cDzien ma 24 godziny!");
/*  51:    */         }
/*  52:    */       }
/*  53:    */       else
/*  54:    */       {
/*  55: 56 */         if (!this.ticksAliases.containsKey(args[0]))
/*  56:    */         {
/*  57: 58 */           sender.sendMessage("§cNie ma takiej pory dnia!");
/*  58: 59 */           return true;
/*  59:    */         }
/*  60: 61 */         int czas = ((Integer)this.ticksAliases.get(args[0])).intValue();
/*  61: 62 */         p.getWorld().setTime(czas);
/*  62: 63 */         sender.sendMessage("§7Ustawiles czas na swiecie §c" + p.getWorld().getName() + " §7na godzine §c" + czas / 1000);
/*  63:    */       }
/*  64:    */     }
/*  65: 66 */     else if (args.length == 2)
/*  66:    */     {
/*  67: 68 */       World world = Bukkit.getWorld(args[0]);
/*  68: 69 */       if (world == null)
/*  69:    */       {
/*  70: 71 */         sender.sendMessage("§cNie ma takiego Swiata!");
/*  71: 72 */         return true;
/*  72:    */       }
/*  73: 74 */       if (Main.isInteger(args[1]))
/*  74:    */       {
/*  75: 76 */         int czas = Integer.parseInt(args[1]);
/*  76: 77 */         if (czas <= 24)
/*  77:    */         {
/*  78: 79 */           world.setTime(czas * 1000);
/*  79: 80 */           sender.sendMessage("§7Ustawiles czas na swiecie §c" + world.getName() + " §7na godzine §c" + czas);
/*  80:    */         }
/*  81:    */         else
/*  82:    */         {
/*  83: 84 */           sender.sendMessage("§cDzien ma 24 godziny!");
/*  84:    */         }
/*  85:    */       }
/*  86:    */       else
/*  87:    */       {
/*  88: 89 */         if (!this.ticksAliases.containsKey(args[1]))
/*  89:    */         {
/*  90: 91 */           sender.sendMessage("§cNie ma takiej pory dnia!");
/*  91: 92 */           return true;
/*  92:    */         }
/*  93: 94 */         int czas = ((Integer)this.ticksAliases.get(args[1])).intValue();
/*  94: 95 */         world.setTime(czas);
/*  95: 96 */         sender.sendMessage("§7Ustawiles czas na swiecie §c" + world.getName() + " §7na godzine §c" + czas / 1000);
/*  96:    */       }
/*  97:    */     }
/*  98:    */     else
/*  99:    */     {
/* 100:101 */       sender.sendMessage("§cPoprawne uzycie: §6/time <swiat> <pora>");
/* 101:    */     }
/* 102:104 */     return false;
/* 103:    */   }
/* 104:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.TimeCommand
 * JD-Core Version:    0.7.0.1
 */