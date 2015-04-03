package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class Msg implements CommandExecutor
{
    public Msg(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String l, final String[] args) {
        if (l.equalsIgnoreCase("msg")) {
            final StringBuilder str = new StringBuilder();
            if (args.length <= 1) {
                sender.sendMessage(ChatColor.RED + "Za malo argumentow!");
            }
            else if (Bukkit.getServer().getPlayer(args[0]) != null) {
                if (sender instanceof Player) {
                    final Player p = (Player)sender;
                    final Player pt = Bukkit.getServer().getPlayer(args[0]);
                    final String pn = p.getName();
                    for (int i = 1; i < args.length; ++i) {
                        str.append(String.valueOf(args[i]) + " ");
                    }
                    String msg = str.toString();
                    pt.sendMessage(ChatColor.DARK_AQUA + "[" + pn + " -> ja] " + ChatColor.AQUA + msg);
                    msg = null;
                }
                else {
                    final Player pt2 = Bukkit.getServer().getPlayer(args[0]);
                    for (int j = 1; j < args.length; ++j) {
                        str.append(String.valueOf(args[j]) + " ");
                    }
                    String msg2 = str.toString();
                    pt2.sendMessage(ChatColor.DARK_AQUA + "[Console -> ja] " + ChatColor.AQUA + msg2);
                    msg2 = null;
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "Gracz jest offline!");
            }
        }
        return false;
    }
}
