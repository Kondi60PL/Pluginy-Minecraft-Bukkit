package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class hCraftShot2 implements CommandExecutor
{
    public hCraftShot2(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("poca") && sender.hasPermission("hc.adm") && args.length == 0) {
            sender.sendMessage(new StringBuilder().append(ChatColor.BOLD).append(ChatColor.GOLD).append("=-=-=-=-=-=-=-=").append(ChatColor.RED).append("CraftShot").append(ChatColor.GOLD).append("=-=-=-=-=-=-=-=").toString());
            sender.sendMessage(ChatColor.GREEN + "/livenuse" + ChatColor.GOLD + " - Info o livestream NuseGame!");
            sender.sendMessage(ChatColor.GREEN + "/cc" + ChatColor.GOLD + " - Czyszczenie chatu!");
            sender.sendMessage(ChatColor.GREEN + "/hashset" + ChatColor.GOLD + " - ustawia hashmape!");
            sender.sendMessage(ChatColor.GREEN + "/check" + ChatColor.GOLD + " - Odczytuje hashmape gracza!");
            sender.sendMessage(ChatColor.GREEN + "/liveseby" + ChatColor.GOLD + " - Odczytuje hashmape gracza!");
            sender.sendMessage(ChatColor.GREEN + "/sd lock" + ChatColor.GOLD + " - Blokuje chat!");
            sender.sendMessage(ChatColor.GREEN + "/sd unlock" + ChatColor.GOLD + " - Odblokowywuje chat!");
            sender.sendMessage(ChatColor.GREEN + "/freeze" + ChatColor.GOLD + " - Zamrazanie gracza!");
            if (args.length == 1 && args[0].equals("lista")) {
                sender.sendMessage("test");
            }
        }
        return false;
    }
}
