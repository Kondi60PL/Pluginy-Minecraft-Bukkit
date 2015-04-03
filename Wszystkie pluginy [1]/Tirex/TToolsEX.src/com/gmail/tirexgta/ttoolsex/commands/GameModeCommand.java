/*  1:   */ package com.gmail.tirexgta.ttoolsex.commands;
/*  2:   */ 
/*  3:   */ import com.gmail.tirexgta.ttoolsex.Main;
/*  4:   */ import org.bukkit.Bukkit;
/*  5:   */ import org.bukkit.GameMode;
/*  6:   */ import org.bukkit.command.Command;
/*  7:   */ import org.bukkit.command.CommandExecutor;
/*  8:   */ import org.bukkit.command.CommandSender;
/*  9:   */ import org.bukkit.command.PluginCommand;
/* 10:   */ import org.bukkit.entity.Player;
/* 11:   */ 
/* 12:   */ public class GameModeCommand
/* 13:   */   implements CommandExecutor
/* 14:   */ {
/* 15:   */   Main plugin;
/* 16:   */   
/* 17:   */   public GameModeCommand(Main plugin)
/* 18:   */   {
/* 19:17 */     this.plugin = plugin;
/* 20:18 */     this.plugin.getCommand("gamemode").setExecutor(this);
/* 21:   */   }
/* 22:   */   
/* 23:   */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/* 24:   */   {
/* 25:25 */     String[] survival = { "s", "0", "survival" };
/* 26:26 */     String[] creative = { "c", "1", "creative" };
/* 27:27 */     String[] adventure = { "a", "2", "adventure" };
/* 28:29 */     if (args.length == 1)
/* 29:   */     {
/* 30:31 */       String mode = args[0];
/* 31:32 */       if (!(sender instanceof Player))
/* 32:   */       {
/* 33:34 */         sender.sendMessage("§cPoprawne uzycie: §6/gamemode <gracz> <tryb>");
/* 34:35 */         return true;
/* 35:   */       }
/* 36:37 */       Player player = (Player)sender;
/* 37:38 */       if (this.plugin.containsIgnoreCase(survival, mode.toLowerCase()))
/* 38:   */       {
/* 39:40 */         player.setGameMode(GameMode.SURVIVAL);
/* 40:41 */         player.sendMessage("§6Twoj tryb zostal przelaczony na §csurvival§6!");
/* 41:42 */         return true;
/* 42:   */       }
/* 43:44 */       if (this.plugin.containsIgnoreCase(creative, mode.toLowerCase()))
/* 44:   */       {
/* 45:46 */         player.setGameMode(GameMode.CREATIVE);
/* 46:47 */         player.sendMessage("§6Twoj tryb zostal przelaczony na §ccreative§6!");
/* 47:48 */         return true;
/* 48:   */       }
/* 49:50 */       if (this.plugin.containsIgnoreCase(adventure, mode.toLowerCase()))
/* 50:   */       {
/* 51:52 */         player.setGameMode(GameMode.ADVENTURE);
/* 52:53 */         player.sendMessage("§6Twoj tryb zostal przelaczony na §cadventure§6!");
/* 53:54 */         return true;
/* 54:   */       }
/* 55:56 */       player.sendMessage("§cNiepoprawny tryb gamemode!");
/* 56:   */     }
/* 57:58 */     else if (args.length == 2)
/* 58:   */     {
/* 59:60 */       String mode = args[1];
/* 60:61 */       Player other = Bukkit.getPlayerExact(args[0]);
/* 61:62 */       if (other == null)
/* 62:   */       {
/* 63:64 */         sender.sendMessage("§cTen gracz nie jest Online");
/* 64:65 */         return true;
/* 65:   */       }
/* 66:67 */       if (this.plugin.containsIgnoreCase(survival, mode.toLowerCase()))
/* 67:   */       {
/* 68:69 */         other.setGameMode(GameMode.SURVIVAL);
/* 69:70 */         other.sendMessage("§6Twoj tryb zostal przelaczony na §csurvival §6przez §c" + sender.getName() + "§6!");
/* 70:71 */         sender.sendMessage("§6Tryb gracza §c" + other.getName() + " §6zostal przelaczony na §csurvival§6!");
/* 71:72 */         return true;
/* 72:   */       }
/* 73:74 */       if (this.plugin.containsIgnoreCase(creative, mode.toLowerCase()))
/* 74:   */       {
/* 75:76 */         other.setGameMode(GameMode.CREATIVE);
/* 76:77 */         other.sendMessage("§6Twoj tryb zostal przelaczony na §ccreative §6przez §c" + sender.getName() + "§6!");
/* 77:78 */         sender.sendMessage("§6Tryb gracza §c" + other.getName() + " §6zostal przelaczony na §ccreative§6!");
/* 78:79 */         return true;
/* 79:   */       }
/* 80:81 */       if (this.plugin.containsIgnoreCase(adventure, mode.toLowerCase()))
/* 81:   */       {
/* 82:83 */         other.setGameMode(GameMode.ADVENTURE);
/* 83:84 */         other.sendMessage("§6Twoj tryb zostal przelaczony na §cadventure §6przez §c" + sender.getName() + "§6!");
/* 84:85 */         sender.sendMessage("§6Tryb gracza §c" + other.getName() + " §6zostal przelaczony na §cadventure§6!");
/* 85:86 */         return true;
/* 86:   */       }
/* 87:88 */       sender.sendMessage("§cNiepoprawny tryb gamemode!");
/* 88:   */     }
/* 89:   */     else
/* 90:   */     {
/* 91:92 */       sender.sendMessage("§cPoprawne uzycie: §6/gamemode <gracz> <tryb>");
/* 92:   */     }
/* 93:94 */     return false;
/* 94:   */   }
/* 95:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.commands.GameModeCommand
 * JD-Core Version:    0.7.0.1
 */