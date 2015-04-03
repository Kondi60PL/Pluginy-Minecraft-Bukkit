package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;

public class RangiCommand implements CommandExecutor
{
    Main plugin;
    
    public RangiCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("rangi").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        sender.sendMessage("§3Dostepne Rangi:");
        sender.sendMessage("§3/vip - §7Informacje o ViPie!");
        return false;
    }
}
