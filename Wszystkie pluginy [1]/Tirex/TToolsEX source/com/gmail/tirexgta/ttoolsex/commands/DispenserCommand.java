package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class DispenserCommand implements CommandExecutor
{
    Main plugin;
    
    public DispenserCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("dispenser").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wykonana z konsoli!");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage("§cDostepne argumenty: §6add, delete");
            return true;
        }
        if (args[0].equalsIgnoreCase("add")) {
            this.plugin.dispensersListener.hasTypedCommand.put((Player)sender, "add");
            sender.sendMessage("§9Kliknij na dispenser, ktory chcesz, aby byl nieskonczony.");
            return true;
        }
        if (args[0].equalsIgnoreCase("delete")) {
            this.plugin.dispensersListener.hasTypedCommand.put((Player)sender, "delete");
            sender.sendMessage("§9Kliknij na dispenser, ktory chcesz, aby nie byl nieskonczony.");
            return true;
        }
        sender.sendMessage("§cDostepne argumenty: §6add, delete");
        return true;
    }
}
