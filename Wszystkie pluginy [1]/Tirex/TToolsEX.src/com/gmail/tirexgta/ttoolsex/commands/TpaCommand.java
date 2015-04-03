/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import org.bukkit.Bukkit;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ 
/* 12:   */ public class TpaCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:16 */   HashMap<Player, Player> tpaPlayer = new HashMap();
/* 17:17 */   HashMap<Player, Long> tpaTime = new HashMap();
/* 18:   */   
/* 19:   */   public TpaCommand(Main plugin)
/* 20:   */   {
/* 21:21 */     this.plugin = plugin;
/* 22:22 */     this.plugin.getCommand("tpa").setExecutor(this);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 26:   */   {
/* 27:29 */     if (!(sender instanceof Player))
/* 28:   */     {
/* 29:31 */       sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
/* 30:32 */       return true;
/* 31:   */     }
/* 32:34 */     if (args.length == 1)
/* 33:   */     {
/* 34:36 */       Player p = (Player)sender;
/* 35:37 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 36:38 */       if (other == null)
/* 37:   */       {
/* 38:40 */         sender.sendMessage("§cTen gracz nie jest Online!");
/* 39:41 */         return true;
/* 40:   */       }
/* 41:43 */       if (other.equals(p))
/* 42:   */       {
/* 43:45 */         sender.sendMessage("§cNie mozesz samemu sobie wyslac zaproszenia!");
/* 44:46 */         return true;
/* 45:   */       }
/* 46:48 */       if (this.tpaPlayer.containsKey(other)) {
/* 47:50 */         if (this.tpaTime.containsKey(this.tpaPlayer.get(other))) {
/* 48:52 */           if (System.currentTimeMillis() < ((Long)this.tpaTime.get(Boolean.valueOf(this.tpaTime.containsKey(this.tpaPlayer.get(other))))).longValue())
/* 49:   */           {
/* 50:54 */             sender.sendMessage("§cTen gracz ma juz oczekujace zaproszenie!");
/* 51:55 */             return true;
/* 52:   */           }
/* 53:   */         }
/* 54:   */       }
/* 55:59 */       if (this.tpaPlayer.containsKey(other)) {
/* 56:61 */         this.tpaPlayer.remove(other);
/* 57:   */       }
/* 58:63 */       if (this.tpaTime.containsKey(p)) {
/* 59:65 */         this.tpaTime.remove(p);
/* 60:   */       }
/* 61:67 */       this.tpaPlayer.put(other, p);
/* 62:68 */       this.tpaTime.put(p, Long.valueOf(System.currentTimeMillis() + 60000L));
/* 63:69 */       sender.sendMessage("§6Wyslano prosbe teleportacji do gracza §c" + other.getName());
/* 64:70 */       other.sendMessage("§cOrzymales prosbe teleportacji od gracza §7" + p.getName() + "\n§cMasz §760 §csekund, zeby zaakceptowac zaproszenie: §7/tpaccept \n§club odrzucic zaproszenie: §7/tpdeny");
/* 65:   */     }
/* 66:   */     else
/* 67:   */     {
/* 68:74 */       sender.sendMessage("§cPoprawne uzycie: §6/tpa <gracz>");
/* 69:   */     }
/* 70:77 */     return false;
/* 71:   */   }
/* 72:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.TpaCommand
 * JD-Core Version:    0.7.0.1
 */