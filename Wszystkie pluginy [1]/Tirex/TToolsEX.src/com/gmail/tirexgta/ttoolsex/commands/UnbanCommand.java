/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.DataBan;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.database.DataUser;
/*  6:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  7:   */ import org.bukkit.Bukkit;
/*  8:   */ import org.bukkit.command.Command;
/*  9:   */ import org.bukkit.command.CommandExecutor;
/* 10:   */ import org.bukkit.command.CommandSender;
/* 11:   */ import org.bukkit.command.PluginCommand;
/* 12:   */ 
/* 13:   */ public class UnbanCommand
/* 14:   */   implements CommandExecutor
/* 15:   */ {
/* 16:   */   Main plugin;
/* 17:   */   
/* 18:   */   public UnbanCommand(Main plugin)
/* 19:   */   {
/* 20:19 */     this.plugin = plugin;
/* 21:20 */     this.plugin.getCommand("unban").setExecutor(this);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 25:   */   {
/* 26:26 */     if (args.length > 0)
/* 27:   */     {
/* 28:28 */       DataUser user = Datasource.getUserByNick(args[0]);
/* 29:29 */       if (user == null)
/* 30:   */       {
/* 31:31 */         sender.sendMessage("§cPodany gracz nie jest zbanowany!");
/* 32:32 */         return true;
/* 33:   */       }
/* 34:34 */       DataBan ban = this.plugin.data.getBanData(user.getNick());
/* 35:35 */       if (ban == null)
/* 36:   */       {
/* 37:37 */         sender.sendMessage("§cPodany gracz nie jest zbanowany!");
/* 38:38 */         return true;
/* 39:   */       }
/* 40:40 */       ban.delete();
/* 41:41 */       String displayName = sender.getName();
/* 42:42 */       Bukkit.broadcastMessage("§c" + args[0] + "§7" + " zostal odbanowany przez §c" + displayName + "§7" + ".");
/* 43:   */     }
/* 44:44 */     return false;
/* 45:   */   }
/* 46:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.UnbanCommand
 * JD-Core Version:    0.7.0.1
 */