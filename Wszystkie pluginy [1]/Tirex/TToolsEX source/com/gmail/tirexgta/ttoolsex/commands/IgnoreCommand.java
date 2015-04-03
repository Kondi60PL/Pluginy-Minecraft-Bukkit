package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class IgnoreCommand implements CommandExecutor
{
    Main plugin;
    
    public IgnoreCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("ignore").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage("§cPoprawne uzycie: §6/ignore <gracz>");
            return true;
        }
        final Player player = (Player)sender;
        final String ignoredNick = args[0];
        final OfflinePlayer ignored = Bukkit.getOfflinePlayer(ignoredNick);
        if (ignored == null) {
            player.sendMessage("§cTen gracz nie gral nigdy wczesniej!");
            return true;
        }
        if (!this.plugin.ignoredManager.isIgnoredByPlayer(player, ignored)) {
            this.plugin.ignoredManager.addIgnored(player, ignored);
            player.sendMessage("§6Dodano gracza §c" + ignored.getName() + " §6do ignorowanych!");
        }
        else {
            this.plugin.ignoredManager.removeIgnored(player, ignored);
            player.sendMessage("§6Usunieto gracza §c" + ignored.getName() + " §6z ignorowanych!");
        }
        return false;
    }
}
