/*  1:   */ package com.gmail.tirexgta.ttoolsex;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  4:   */ import org.bukkit.Server;
/*  5:   */ import org.bukkit.scheduler.BukkitScheduler;
/*  6:   */ 
/*  7:   */ public class SaveScheduler
/*  8:   */ {
/*  9:   */   Main plugin;
/* 10:   */   
/* 11:   */   public SaveScheduler(final Main plugin)
/* 12:   */   {
/* 13:10 */     this.plugin = plugin;
/* 14:11 */     this.plugin.getServer().getScheduler().runTaskTimer(plugin, new Runnable()
/* 15:   */     {
/* 16:   */       public void run()
/* 17:   */       {
/* 18:16 */         plugin.saveMap();
/* 19:   */       }
/* 20:18 */     }, 20L * this.plugin.config.autoSaveDelay, 20L * this.plugin.config.autoSaveDelay);
/* 21:   */   }
/* 22:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.SaveScheduler
 * JD-Core Version:    0.7.0.1
 */