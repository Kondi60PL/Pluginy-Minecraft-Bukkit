package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import java.util.*;

public class HelpCommand implements CommandExecutor
{
    Main plugin;
    
    public HelpCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("help").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        for (final String help : this.plugin.config.helpMessages) {
            sender.sendMessage(this.plugin.fix(help));
        }
        return false;
    }
}
