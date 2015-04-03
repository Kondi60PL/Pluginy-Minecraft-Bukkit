package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import java.util.*;

public class HealCommand implements CommandExecutor
{
    Main plugin;
    
    public HealCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("heal").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/heal <gracz>");
                return true;
            }
            final Player player = (Player)sender;
            player.setFoodLevel(20);
            player.setHealth(20.0);
            player.setFireTicks(0);
            for (final PotionEffect potionEffect : player.getActivePotionEffects()) {
                player.removePotionEffect(potionEffect.getType());
            }
            player.sendMessage("§6Zostales uleczony!");
        }
        else if (args.length == 1) {
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            other.setFoodLevel(20);
            other.setHealth(20.0);
            other.setFireTicks(0);
            for (final PotionEffect potionEffect : other.getActivePotionEffects()) {
                other.removePotionEffect(potionEffect.getType());
            }
            other.sendMessage("§6Zostales uleczony przez §c" + sender.getName() + "§6!");
            sender.sendMessage("§6Uleczyles gracza §c" + other.getName());
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/heal <gracz>");
        }
        return false;
    }
}
