package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TellCommand implements CommandExecutor
{
    Main plugin;
    
    public TellCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("tell").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        if (args.length < 2) {
            sender.sendMessage("§cPoprawne uzycie: §6/tell <gracz> <wiadomosc>");
            return true;
        }
        final Player p = (Player)sender;
        final Player other = Bukkit.getPlayerExact(args[0]);
        if (other == null) {
            sender.sendMessage("§cTen gracz nie jest Online!");
            return true;
        }
        if (this.plugin.replyCommand.lastMessageSender.containsKey(p)) {
            this.plugin.replyCommand.lastMessageSender.remove(p);
        }
        if (this.plugin.replyCommand.lastMessageSender.containsKey(other)) {
            this.plugin.replyCommand.lastMessageSender.remove(other);
        }
        this.plugin.replyCommand.lastMessageSender.put(p, other);
        this.plugin.replyCommand.lastMessageSender.put(other, p);
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
        }
        final String msg = sb.toString();
        other.sendMessage("§6[§7" + p.getName() + " §6-> §7ja §6]  §7" + this.plugin.fix(msg));
        p.sendMessage("§6[§7ja §6-> §7" + other.getName() + " §6]  §7" + this.plugin.fix(msg));
        return false;
    }
}
