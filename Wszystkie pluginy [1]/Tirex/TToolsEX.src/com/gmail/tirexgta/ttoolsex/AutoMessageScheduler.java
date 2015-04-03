/*  1:   */ package com.gmail.tirexgta.ttoolsex;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  4:   */ import java.util.List;
/*  5:   */ import org.bukkit.Bukkit;
/*  6:   */ import org.bukkit.ChatColor;
/*  7:   */ import org.bukkit.Server;
/*  8:   */ import org.bukkit.scheduler.BukkitScheduler;
/*  9:   */ 
/* 10:   */ public class AutoMessageScheduler
/* 11:   */ {
/* 12:   */   Main plugin;
/* 13:   */   
/* 14:   */   public AutoMessageScheduler(final Main plugin)
/* 15:   */   {
/* 16:12 */     this.plugin = plugin;
/* 17:13 */     this.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()
/* 18:   */     {
/* 19:15 */       int i = 0;
/* 20:   */       
/* 21:   */       public void run()
/* 22:   */       {
/* 23:19 */         if (this.i >= plugin.config.autoMessageMessages.size()) {
/* 24:21 */           this.i = 0;
/* 25:   */         }
/* 26:23 */         Bukkit.broadcastMessage(plugin.config.autoMessagePrefix.replace("&", "§") + " " + ChatColor.GRAY + ((String)plugin.config.autoMessageMessages.get(this.i)).replace("&", "§"));
/* 27:24 */         this.i += 1;
/* 28:   */       }
/* 29:27 */     }, 20L, 20L * this.plugin.config.autoMessageDelay);
/* 30:   */   }
/* 31:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.AutoMessageScheduler
 * JD-Core Version:    0.7.0.1
 */