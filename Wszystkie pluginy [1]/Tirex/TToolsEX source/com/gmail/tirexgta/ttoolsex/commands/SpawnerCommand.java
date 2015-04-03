package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.block.*;

public class SpawnerCommand implements CommandExecutor
{
    Main plugin;
    
    public SpawnerCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("spawner").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage("§cPoprawne uzycie: §6/spawner <zwierze>");
            return true;
        }
        final Player p = (Player)sender;
        final String spawnerType = args[0].toLowerCase();
        final Block targetBlock = p.getTargetBlock((HashSet)null, 10);
        if (!targetBlock.getType().equals((Object)Material.MOB_SPAWNER)) {
            sender.sendMessage("§cTen blok nie jest spawnerem!");
            return true;
        }
        final CreatureSpawner spawner = (CreatureSpawner)targetBlock.getState();
        spawner.setCreatureTypeByName(spawnerType);
        sender.sendMessage("§6Zmieniono typ spawnera na §c" + spawner.getCreatureTypeName());
        return false;
    }
}
