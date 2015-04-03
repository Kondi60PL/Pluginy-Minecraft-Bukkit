package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import com.gmail.tirexgta.ttoolsex.database.*;

public class SethomeCommand implements CommandExecutor
{
    Main plugin;
    
    public SethomeCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("sethome").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        final Player p = (Player)sender;
        final Location loc = p.getLocation();
        final int locX = loc.getBlockX();
        final int locY = loc.getBlockY();
        final int locZ = loc.getBlockZ();
        final String world = loc.getWorld().getName();
        final DataUser user = Datasource.getUserData(p);
        user.setHomeX(locX);
        user.setHomeY(locY);
        user.setHomeZ(locZ);
        user.setHomeWorld(world);
        user.update();
        sender.sendMessage("§aUstawiles swoj dom!");
        return false;
    }
}
