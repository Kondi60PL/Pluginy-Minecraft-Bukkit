package com.gmail.tirexgta.tguildsex.commands;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import java.util.*;

public class GraczCommand implements CommandExecutor
{
    Main plugin;
    
    public GraczCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("gracz").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.playerCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
            if (user == null) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.playerNoPlayer));
                return true;
            }
            for (final String s : this.plugin.messageManager.playerMsg) {
                sender.sendMessage(this.plugin.fixMsg(s).replace("%player%", p.getName()).replace("%kills%", Integer.toString(user.getKills())).replace("%deaths%", Integer.toString(user.getDeaths())).replace("%points%", Integer.toString(user.getPoints())));
            }
        }
        else if (args.length == 1) {
            final DataGuildUser user2 = this.plugin.data.getUserByNickName(args[0]);
            if (user2 == null) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.playerNoPlayer));
                return true;
            }
            for (final String s2 : this.plugin.messageManager.playerMsg) {
                sender.sendMessage(this.plugin.fixMsg(s2).replace("%player%", user2.getNick()).replace("%kills%", Integer.toString(user2.getKills())).replace("%deaths%", Integer.toString(user2.getDeaths())).replace("%points%", Integer.toString(user2.getPoints())));
            }
        }
        return false;
    }
}
