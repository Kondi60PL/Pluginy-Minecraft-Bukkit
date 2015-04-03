package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class RandomTeleportCommand implements CommandExecutor
{
    Main plugin;
    
    public RandomTeleportCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("randomtp").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wykonana z konsoli!");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage("§cDostepne argumenty: §6add, delete, addgroups, deletegroups");
            return true;
        }
        if (args[0].equalsIgnoreCase("add")) {
            if (!this.plugin.randomTeleportListener.hasTypedCommand.containsKey(sender)) {
                this.plugin.randomTeleportListener.hasTypedCommand.put((Player)sender, "add");
            }
            sender.sendMessage("§9Kliknij na guzik, ktory chcesz, aby byl losowym teleporterem.");
            return true;
        }
        if (args[0].equalsIgnoreCase("delete")) {
            if (!this.plugin.randomTeleportListener.hasTypedCommand.containsKey(sender)) {
                this.plugin.randomTeleportListener.hasTypedCommand.put((Player)sender, "delete");
            }
            sender.sendMessage("§9Kliknij na guzik, ktory chcesz, aby nie byl losowym teleporterem.");
            return true;
        }
        if (args[0].equalsIgnoreCase("addgroups")) {
            if (!this.plugin.randomTeleportListener.hasTypedCommand.containsKey(sender)) {
                this.plugin.randomTeleportListener.hasTypedCommand.put((Player)sender, "addgroups");
            }
            sender.sendMessage("§9Kliknij na guzik, ktory chcesz, aby byl grupowym losowym teleporterem.");
            return true;
        }
        if (args[0].equalsIgnoreCase("deletegroups")) {
            if (!this.plugin.randomTeleportListener.hasTypedCommand.containsKey(sender)) {
                this.plugin.randomTeleportListener.hasTypedCommand.put((Player)sender, "deletegroups");
            }
            sender.sendMessage("§9Kliknij na guzik, ktory chcesz, aby nie byl grupowym losowym teleporterem.");
            return true;
        }
        sender.sendMessage("§cDostepne argumenty: §6add, delete, addgroups, deletegroups");
        return true;
    }
}
