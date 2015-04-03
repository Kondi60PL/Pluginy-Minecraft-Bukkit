package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class SetSpawnCommand implements CommandExecutor
{
    Main plugin;
    
    public SetSpawnCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("setspawn").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Ta komenda nie jest dostepna z konsoli!");
            return true;
        }
        final Location loc = ((Player)sender).getLocation();
        ((Player)sender).getWorld().setSpawnLocation(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        sender.sendMessage("§aUstawiles lokalizacje §6spawnu!");
        return false;
    }
}
