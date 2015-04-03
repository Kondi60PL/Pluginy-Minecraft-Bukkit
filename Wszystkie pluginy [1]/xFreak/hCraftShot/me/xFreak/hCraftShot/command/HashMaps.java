package me.xFreak.hCraftShot.command;

import java.util.*;
import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class HashMaps implements CommandExecutor
{
    private static Map<UUID, String> map;
    
    static {
        HashMaps.map = new HashMap<UUID, String>();
    }
    
    public HashMaps(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String l, final String[] args) {
        final Player p = Bukkit.getServer().getPlayer(args[0]);
        final UUID u = p.getUniqueId();
        final StringBuilder str = new StringBuilder();
        if (l.equalsIgnoreCase("hashset")) {
            for (int i = 1; i < args.length; ++i) {
                str.append(String.valueOf(args[i]) + " ");
            }
            String msg = str.toString();
            HashMaps.map.put(u, msg);
            sender.sendMessage(ChatColor.GOLD + "Warotsc " + ChatColor.AQUA + msg + ChatColor.GOLD + "zostala przypisana do gracza " + ChatColor.AQUA + p.getName());
            msg = null;
        }
        if (l.equalsIgnoreCase("check")) {
            if (HashMaps.map.containsKey(u)) {
                if (HashMaps.map.get(u) != null) {
                    sender.sendMessage(ChatColor.AQUA + p.getName() + ChatColor.GOLD + " = " + ChatColor.AQUA + HashMaps.map.get(u));
                }
                else {
                    sender.sendMessage(ChatColor.AQUA + p.getName() + ChatColor.GOLD + " = " + ChatColor.RED + "NULL");
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "Nie ma takiego obiektu w HashMapie !");
            }
        }
        return false;
    }
}
