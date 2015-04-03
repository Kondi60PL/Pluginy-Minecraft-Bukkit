/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Server;
/*  5:   */ import org.bukkit.event.EventHandler;
/*  6:   */ import org.bukkit.event.Listener;
/*  7:   */ import org.bukkit.event.block.SignChangeEvent;
/*  8:   */ import org.bukkit.plugin.PluginManager;
/*  9:   */ 
/* 10:   */ public class ColorSignListener
/* 11:   */   implements Listener
/* 12:   */ {
/* 13:   */   Main plugin;
/* 14:   */   
/* 15:   */   public ColorSignListener(Main plugin)
/* 16:   */   {
/* 17:15 */     this.plugin = plugin;
/* 18:16 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 19:   */   }
/* 20:   */   
/* 21:   */   @EventHandler
/* 22:   */   public void onSignCreate(SignChangeEvent e)
/* 23:   */   {
/* 24:22 */     int i = 0;
/* 25:23 */     for (String line : e.getLines())
/* 26:   */     {
/* 27:25 */       String line2 = this.plugin.fix(line);
/* 28:26 */       if (line2 != null) {
/* 29:27 */         e.setLine(i, this.plugin.fix(line));
/* 30:   */       }
/* 31:28 */       i++;
/* 32:   */     }
/* 33:   */   }
/* 34:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.ColorSignListener
 * JD-Core Version:    0.7.0.1
 */