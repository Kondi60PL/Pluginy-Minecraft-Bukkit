package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;

public class ReloadToolsCommand implements CommandExecutor
{
    Main plugin;
    
    public ReloadToolsCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("reloadtools").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        this.plugin.config.save();
        this.plugin.config.reload();
        sender.sendMessage("§aPlik konfiguracyjny zostal przeladowany!");
        return false;
    }
}
