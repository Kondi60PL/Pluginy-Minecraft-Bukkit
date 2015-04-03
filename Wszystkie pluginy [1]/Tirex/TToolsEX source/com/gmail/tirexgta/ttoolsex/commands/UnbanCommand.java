package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.*;
import com.gmail.tirexgta.ttoolsex.database.*;

public class UnbanCommand implements CommandExecutor
{
    Main plugin;
    
    public UnbanCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("unban").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length > 0) {
            final DataUser user = Datasource.getUserByNick(args[0]);
            if (user == null) {
                sender.sendMessage("§cPodany gracz nie jest zbanowany!");
                return true;
            }
            final DataBan ban = this.plugin.data.getBanData(user.getNick());
            if (ban == null) {
                sender.sendMessage("§cPodany gracz nie jest zbanowany!");
                return true;
            }
            ban.delete();
            final String displayName = sender.getName();
            Bukkit.broadcastMessage("§c" + args[0] + "§7" + " zostal odbanowany przez §c" + displayName + "§7" + ".");
        }
        return false;
    }
}
