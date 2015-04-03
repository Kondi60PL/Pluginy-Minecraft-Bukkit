package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class GameModeCommand implements CommandExecutor
{
    Main plugin;
    
    public GameModeCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("gamemode").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final String[] survival = { "s", "0", "survival" };
        final String[] creative = { "c", "1", "creative" };
        final String[] adventure = { "a", "2", "adventure" };
        if (args.length == 1) {
            final String mode = args[0];
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/gamemode <gracz> <tryb>");
                return true;
            }
            final Player player = (Player)sender;
            if (this.plugin.containsIgnoreCase(survival, mode.toLowerCase())) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("§6Twoj tryb zostal przelaczony na §csurvival§6!");
                return true;
            }
            if (this.plugin.containsIgnoreCase(creative, mode.toLowerCase())) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("§6Twoj tryb zostal przelaczony na §ccreative§6!");
                return true;
            }
            if (this.plugin.containsIgnoreCase(adventure, mode.toLowerCase())) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("§6Twoj tryb zostal przelaczony na §cadventure§6!");
                return true;
            }
            player.sendMessage("§cNiepoprawny tryb gamemode!");
        }
        else if (args.length == 2) {
            final String mode = args[1];
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online");
                return true;
            }
            if (this.plugin.containsIgnoreCase(survival, mode.toLowerCase())) {
                other.setGameMode(GameMode.SURVIVAL);
                other.sendMessage("§6Twoj tryb zostal przelaczony na §csurvival §6przez §c" + sender.getName() + "§6!");
                sender.sendMessage("§6Tryb gracza §c" + other.getName() + " §6zostal przelaczony na §csurvival§6!");
                return true;
            }
            if (this.plugin.containsIgnoreCase(creative, mode.toLowerCase())) {
                other.setGameMode(GameMode.CREATIVE);
                other.sendMessage("§6Twoj tryb zostal przelaczony na §ccreative §6przez §c" + sender.getName() + "§6!");
                sender.sendMessage("§6Tryb gracza §c" + other.getName() + " §6zostal przelaczony na §ccreative§6!");
                return true;
            }
            if (this.plugin.containsIgnoreCase(adventure, mode.toLowerCase())) {
                other.setGameMode(GameMode.ADVENTURE);
                other.sendMessage("§6Twoj tryb zostal przelaczony na §cadventure §6przez §c" + sender.getName() + "§6!");
                sender.sendMessage("§6Tryb gracza §c" + other.getName() + " §6zostal przelaczony na §cadventure§6!");
                return true;
            }
            sender.sendMessage("§cNiepoprawny tryb gamemode!");
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/gamemode <gracz> <tryb>");
        }
        return false;
    }
}
