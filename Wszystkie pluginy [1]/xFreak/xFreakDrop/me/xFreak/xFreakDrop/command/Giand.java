package me.xFreak.xFreakDrop.command;

import me.xFreak.xFreakDrop.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Giand implements CommandExecutor
{
    public Giand(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("giandd") && args.length == 0) {
            final Player p = (Player)sender;
            Bukkit.broadcastMessage("§7[§6Giant-Zombie§7] §cGracz " + p.getName() + " §czabil" + " §aGiant-Zombie!");
        }
        return false;
    }
}
