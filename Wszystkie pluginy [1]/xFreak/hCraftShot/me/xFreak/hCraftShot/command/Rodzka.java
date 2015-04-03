package me.xFreak.hCraftShot.command;

import me.xFreak.hCraftShot.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Rodzka implements CommandExecutor
{
    public Rodzka(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("rodzka") && args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "=-=-=-=-=-=-=-=-=-=-=" + ChatColor.RED + "Crafting" + ChatColor.YELLOW + "=-=-=-=-=-=-=-=-=-=-=");
            sender.sendMessage(ChatColor.YELLOW + "Rodzke robisz w craftingu!");
            sender.sendMessage(ChatColor.YELLOW + "W przekatnej dajesz 1 blok zlota, a w pozostalych 2 miejscach patyki!");
            sender.sendMessage(ChatColor.YELLOW + "Po kliknieciu czekasz 5 sekund!");
        }
        return false;
    }
}
