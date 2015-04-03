/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.InvincibleManager;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  5:   */ import org.bukkit.command.Command;
/*  6:   */ import org.bukkit.command.CommandExecutor;
/*  7:   */ import org.bukkit.command.CommandSender;
/*  8:   */ import org.bukkit.command.PluginCommand;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ 
/* 11:   */ public class InvincibleCommand
/* 12:   */   implements CommandExecutor
/* 13:   */ {
/* 14:   */   Main plugin;
/* 15:   */   
/* 16:   */   public InvincibleCommand(Main plugin)
/* 17:   */   {
/* 18:16 */     this.plugin = plugin;
/* 19:17 */     this.plugin.getCommand("invincible").setExecutor(this);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 23:   */   {
/* 24:24 */     if ((sender instanceof Player))
/* 25:   */     {
/* 26:26 */       Player player = (Player)sender;
/* 27:27 */       this.plugin.invincibleManager.setInCommand(player, true);
/* 28:28 */       player.sendMessage("§9Kliknij w moba/zwierze, ktore ma byc nieznisczalne");
/* 29:   */     }
/* 30:30 */     return true;
/* 31:   */   }
/* 32:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.InvincibleCommand
 * JD-Core Version:    0.7.0.1
 */