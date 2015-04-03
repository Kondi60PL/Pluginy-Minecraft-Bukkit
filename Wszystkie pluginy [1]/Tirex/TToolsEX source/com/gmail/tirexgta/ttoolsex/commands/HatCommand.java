package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.*;

public class HatCommand implements CommandExecutor
{
    Main plugin;
    
    public HatCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("hat").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
                return true;
            }
            final Player player = (Player)sender;
            final ItemStack item = player.getItemInHand();
            if (!item.getType().isBlock()) {
                player.sendMessage("§cTego przedmiotu nie mozna zalozyc na glowe!");
                return true;
            }
            player.getInventory().setItemInHand((ItemStack)null);
            if (player.getInventory().getHelmet() != null) {
                final ItemStack helmet = player.getInventory().getHelmet();
                player.setItemInHand(helmet);
            }
            player.getInventory().setHelmet(item);
            player.sendMessage("§6Ciesz sie nowa czapka!");
        }
        else if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
                return true;
            }
            if (!sender.hasPermission("tirex.hat.other")) {
                sender.sendMessage("§cNie masz dostepu!");
                return true;
            }
            final Player other = Bukkit.getPlayerExact(args[0]);
            final Player player2 = (Player)sender;
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            if (other == player2) {
                sender.sendMessage("§cNie mozesz dac sobie czapki!");
                return true;
            }
            final ItemStack item2 = player2.getItemInHand();
            if (!item2.getType().isBlock()) {
                player2.sendMessage("§cTego przedmiotu nie mozna zalozyc na glowe!");
                return true;
            }
            if (other.getItemInHand().getType() != Material.AIR) {
                player2.sendMessage("§cTen gracz ma pelna reke!");
                return true;
            }
            if (other.getInventory().getHelmet() != null) {
                final ItemStack helmet2 = other.getInventory().getHelmet();
                other.setItemInHand(helmet2);
            }
            player2.getInventory().setHelmet(item2);
            other.sendMessage("§6Ciesz sie nowa czapka od §c" + player2.getName() + " §6;)");
            player2.sendMessage("§c" + other.getName() + " §6cieszy sie nowa czapka!");
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/hat [gracz]");
        }
        return false;
    }
}
