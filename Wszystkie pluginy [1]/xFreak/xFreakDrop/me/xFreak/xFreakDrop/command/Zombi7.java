package me.xFreak.xFreakDrop.command;

import me.xFreak.xFreakDrop.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.confuser.barapi.*;

public class Zombi7 implements CommandExecutor
{
    public Zombi7(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("zombi7") && args.length == 0) {
            final Player p = (Player)sender;
            BarAPI.setMessage(p, "§aZombie-Giant! §8[§e7§8/§e10§8]", 100);
        }
        return false;
    }
}
