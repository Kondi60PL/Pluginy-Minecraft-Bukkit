/*  1:   */ package com.gmail.tirexgta.ttoolsex.listeners;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import com.gmail.tirexgta.ttoolsex.database.Datasource;
/*  5:   */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*  6:   */ import java.util.List;
/*  7:   */ import org.bukkit.Server;
/*  8:   */ import org.bukkit.World;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ import org.bukkit.event.EventHandler;
/* 11:   */ import org.bukkit.event.EventPriority;
/* 12:   */ import org.bukkit.event.Listener;
/* 13:   */ import org.bukkit.event.player.PlayerJoinEvent;
/* 14:   */ import org.bukkit.plugin.PluginManager;
/* 15:   */ 
/* 16:   */ public class WelcomeMessageListener
/* 17:   */   implements Listener
/* 18:   */ {
/* 19:   */   Main plugin;
/* 20:   */   
/* 21:   */   public WelcomeMessageListener(Main plugin)
/* 22:   */   {
/* 23:17 */     this.plugin = plugin;
/* 24:18 */     this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
/* 25:   */   }
/* 26:   */   
/* 27:   */   @EventHandler(priority=EventPriority.HIGHEST)
/* 28:   */   public void onPlayerJoin(PlayerJoinEvent event)
/* 29:   */   {
/* 30:24 */     Player player = event.getPlayer();
/* 31:25 */     if (!player.hasPlayedBefore()) {
/* 32:26 */       player.teleport(player.getWorld().getSpawnLocation());
/* 33:   */     }
/* 34:27 */     if (player.hasPermission("tirex.welcomemessage")) {
/* 35:29 */       for (String line : this.plugin.config.welcomeMessage)
/* 36:   */       {
/* 37:31 */         line = line.replace("&", "§");
/* 38:32 */         line = line.replace("{odwiedzilo}", String.valueOf(this.plugin.data.users.size()));
/* 39:33 */         line = line.replace("{playername}", player.getName());
/* 40:34 */         line = line.replace("{online}", String.valueOf(this.plugin.slot()));
/* 41:35 */         player.sendMessage(line);
/* 42:   */       }
/* 43:   */     }
/* 44:   */   }
/* 45:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.listeners.WelcomeMessageListener
 * JD-Core Version:    0.7.0.1
 */