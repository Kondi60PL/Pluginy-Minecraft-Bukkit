package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;

public class MessageCommand implements CommandExecutor
{
    Main plugin;
    
    public MessageCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("message").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cPoprawne uzycie: §6/message <argument>");
            return true;
        }
        if (args[0].equalsIgnoreCase("add")) {
            if (args.length <= 1) {
                sender.sendMessage("§cPoprawne uzycie: §6/message add <wiadomosc>");
                return true;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.length; ++i) {
                sb.append(args[i]).append(" ");
            }
            final String message = sb.toString();
            this.plugin.config.autoMessageMessages.add(message);
            final int index = this.plugin.config.autoMessageMessages.indexOf(message);
            this.plugin.config.save();
            sender.sendMessage("§9Dodales wiadomosc numer §c" + (index + 1) + "§9!");
        }
        else if (args[0].equalsIgnoreCase("delete")) {
            if (args.length <= 1) {
                sender.sendMessage("§cPoprawne uzycie: §6/message delete <numer>");
                return true;
            }
            final String indexString = args[1];
            if (!Main.isInteger(indexString)) {
                sender.sendMessage("§cPoprawne uzycie: §6/message <");
            }
            final int index2 = Integer.parseInt(args[1]) - 1;
            this.plugin.config.autoMessageMessages.remove(index2);
            this.plugin.config.save();
            sender.sendMessage("§9Usunieto wiadomosc numer §c" + (index2 + 1) + "§9!");
        }
        else if (args[0].equalsIgnoreCase("reload")) {
            if (args.length != 1) {
                sender.sendMessage("§cPoprawne uzycie: §6/message reload");
                return true;
            }
            this.plugin.config.reload();
            sender.sendMessage("§9Plik konfiguracyjny zostal przeladowany");
        }
        else {
            sender.sendMessage("§cDostepne argumenty: §6add, delete, reload");
        }
        return false;
    }
}
