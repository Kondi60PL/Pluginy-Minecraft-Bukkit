package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class PlecakCommand implements CommandExecutor
{
    Main plugin;
    
    public PlecakCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("plecak").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Ta komenda nie moze byc wykonana z konsoli!");
        }
        this.plugin.backpackManager.openPlecak((Player)sender, sender.getName(), sender.getName());
        return false;
    }
}
