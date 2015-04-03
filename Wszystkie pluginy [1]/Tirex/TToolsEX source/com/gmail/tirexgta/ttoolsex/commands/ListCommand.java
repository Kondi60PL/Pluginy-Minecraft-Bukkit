package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;

public class ListCommand implements CommandExecutor
{
    Main plugin;
    
    public ListCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("list").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        sender.sendMessage("§9Na serwerze obecnie jest §c" + this.plugin.slot() + "§9/§c" + this.plugin.config.slotManagerSlots + " §9graczy.");
        return false;
    }
}
