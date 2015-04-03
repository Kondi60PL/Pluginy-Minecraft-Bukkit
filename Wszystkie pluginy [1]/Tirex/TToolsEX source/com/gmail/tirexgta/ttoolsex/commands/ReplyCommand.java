package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class ReplyCommand implements CommandExecutor
{
    Main plugin;
    public HashMap<Player, Player> lastMessageSender;
    
    public ReplyCommand(final Main plugin) {
        super();
        this.lastMessageSender = new HashMap<Player, Player>();
        this.plugin = plugin;
        this.plugin.getCommand("reply").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("§cPoprawne uzycie: §6/r <wiadomosc>");
            return true;
        }
        final Player player = (Player)sender;
        if (!this.lastMessageSender.containsKey(player)) {
            sender.sendMessage("§cNie masz komu odpisac!");
            return true;
        }
        final Player other = Bukkit.getPlayerExact(this.lastMessageSender.get(player).getName());
        if (other == null) {
            sender.sendMessage("§cTen gracz nie jest Online!");
            return true;
        }
        if (this.lastMessageSender.containsKey(player)) {
            this.lastMessageSender.remove(player);
        }
        if (this.lastMessageSender.containsKey(other)) {
            this.lastMessageSender.remove(other);
        }
        this.lastMessageSender.put(player, other);
        this.lastMessageSender.put(other, player);
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
        }
        final String msg = sb.toString();
        other.sendMessage("§6[§7" + player.getName() + " §6-> §7ja §6]  §7" + this.plugin.fix(msg));
        player.sendMessage("§6[§7ja §6-> §7" + other.getName() + " §6]  §7" + this.plugin.fix(msg));
        return false;
    }
}
