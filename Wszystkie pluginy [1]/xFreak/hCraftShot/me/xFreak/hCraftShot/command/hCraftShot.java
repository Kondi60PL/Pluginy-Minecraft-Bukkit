package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class hCraftShot implements CommandExecutor
{
    public hCraftShot(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("pomoc") && sender.hasPermission("hc.pomoc") && args.length == 0) {
            sender.sendMessage(new StringBuilder().append(ChatColor.BOLD).append(ChatColor.GOLD).append("=-=-=-=-=-=-=-=").append(ChatColor.RED).append("CraftShot").append(ChatColor.GOLD).append("=-=-=-=-=-=-=-=").toString());
            sender.sendMessage(ChatColor.GREEN + "/g pomoc" + ChatColor.GOLD + " - Wszystkie komendy dotyczace gildii!");
            sender.sendMessage(ChatColor.GREEN + "/helpop" + ChatColor.GOLD + " - Wiadomosc do administracji!");
            sender.sendMessage(ChatColor.GREEN + "/enderchest" + ChatColor.GOLD + " - Crafting enderchesta!");
            sender.sendMessage(ChatColor.GREEN + "/stoniarka" + ChatColor.GOLD + " - Crafting stoniarki!");
            sender.sendMessage(ChatColor.GREEN + "/rodzka" + ChatColor.GOLD + " - Crafting rodzki na spawn!");
            sender.sendMessage(ChatColor.GREEN + "/stone" + ChatColor.GOLD + " - Wykaz dropu ze stona!");
            sender.sendMessage(ChatColor.GREEN + "/poca" + ChatColor.GOLD + " - Komendy Administracji!");
            if (args.length == 1 && args[0].equals("lista")) {
                sender.sendMessage("test");
            }
        }
        return false;
    }
}
