package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;

public class SlotManagerCommand implements CommandExecutor
{
    Main plugin;
    
    public SlotManagerCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("slotmanager").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length < 1) {
            sender.sendMessage("§cPoprawne uzycie: §6/slotmanager <argument>");
            return true;
        }
        if (args[0].equalsIgnoreCase("motd")) {
            if (args.length < 2) {
                sender.sendMessage("§cPoprawne uzycie: §6/slotmanager motd <motd>");
                return true;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.length; ++i) {
                sb.append(args[i]).append(" ");
            }
            final String motd = sb.toString();
            this.plugin.config.slotManagerMotd = motd.replace("$n", "\n");
            this.plugin.config.save();
            sender.sendMessage("§6Nowe motd: " + this.plugin.fix(motd).replace("$n", "\n"));
        }
        else if (args[0].equalsIgnoreCase("sloty")) {
            if (args.length < 2) {
                sender.sendMessage("§cPoprawne uzycie: §6/slotmanager sloty <sloty>");
                return true;
            }
            final String slotyString = args[1];
            if (!Main.isInteger(slotyString)) {
                sender.sendMessage("§cPoprawne uzycie: §6/slotmanager sloty <sloty>");
                return true;
            }
            final int sloty = Integer.parseInt(slotyString);
            this.plugin.config.slotManagerSlots = sloty;
            this.plugin.config.save();
            sender.sendMessage("§6Aktualnie jest §c" + sloty + " §6slotow.");
        }
        else {
            sender.sendMessage("§cDostepne argumenty: §6motd, sloty");
        }
        return false;
    }
}
