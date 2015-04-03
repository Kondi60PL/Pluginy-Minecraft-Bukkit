package me.xFreak.xFreakDrop.command;

import me.xFreak.xFreakDrop.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.confuser.barapi.*;

public class Zombinusegame implements CommandExecutor
{
    public Zombinusegame(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("zombinusegame") && args.length == 0) {
            final Player p = (Player)sender;
            BarAPI.setMessage(p, "§e§lNuseGame", 1);
        }
        return false;
    }
}
