package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class WymianaCommand implements CommandExecutor
{
    Main plugin;
    
    public WymianaCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("wymiana").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Tej komendy nie mozna wykonac z poziomu konsoli!");
            return true;
        }
        final Player p = (Player)sender;
        final Inventory eq = Bukkit.createInventory((InventoryHolder)null, InventoryType.MERCHANT);
        p.openInventory(eq);
        return false;
    }
}
