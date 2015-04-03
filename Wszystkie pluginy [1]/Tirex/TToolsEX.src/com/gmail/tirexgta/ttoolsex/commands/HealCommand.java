/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Bukkit;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ import org.bukkit.potion.PotionEffect;
/* 11:   */ 
/* 12:   */ public class HealCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:   */   
/* 17:   */   public HealCommand(Main plugin)
/* 18:   */   {
/* 19:18 */     this.plugin = plugin;
/* 20:19 */     this.plugin.getCommand("heal").setExecutor(this);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 24:   */   {
/* 25:26 */     if (args.length == 0)
/* 26:   */     {
/* 27:28 */       if (!(sender instanceof Player))
/* 28:   */       {
/* 29:30 */         sender.sendMessage("§cPoprawne uzycie: §6/heal <gracz>");
/* 30:31 */         return true;
/* 31:   */       }
/* 32:33 */       Player player = (Player)sender;
/* 33:34 */       player.setFoodLevel(20);
/* 34:35 */       player.setHealth(20.0D);
/* 35:36 */       player.setFireTicks(0);
/* 36:37 */       for (PotionEffect potionEffect : player.getActivePotionEffects()) {
/* 37:39 */         player.removePotionEffect(potionEffect.getType());
/* 38:   */       }
/* 39:41 */       player.sendMessage("§6Zostales uleczony!");
/* 40:   */     }
/* 41:43 */     else if (args.length == 1)
/* 42:   */     {
/* 43:45 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 44:46 */       if (other == null)
/* 45:   */       {
/* 46:48 */         sender.sendMessage("§cTen gracz nie jest Online!");
/* 47:49 */         return true;
/* 48:   */       }
/* 49:51 */       other.setFoodLevel(20);
/* 50:52 */       other.setHealth(20.0D);
/* 51:53 */       other.setFireTicks(0);
/* 52:54 */       for (PotionEffect potionEffect : other.getActivePotionEffects()) {
/* 53:56 */         other.removePotionEffect(potionEffect.getType());
/* 54:   */       }
/* 55:58 */       other.sendMessage("§6Zostales uleczony przez §c" + sender.getName() + "§6!");
/* 56:59 */       sender.sendMessage("§6Uleczyles gracza §c" + other.getName());
/* 57:   */     }
/* 58:   */     else
/* 59:   */     {
/* 60:63 */       sender.sendMessage("§cPoprawne uzycie: §6/heal <gracz>");
/* 61:   */     }
/* 62:66 */     return false;
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.HealCommand
 * JD-Core Version:    0.7.0.1
 */