package me.xFreak.xFreakDrop.command;

import me.xFreak.xFreakDrop.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.confuser.barapi.*;

public class Zombi3 implements CommandExecutor
{
    public Zombi3(final Main plugin) {
        super();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("zombi3") && args.length == 0) {
            final Player p = (Player)sender;
            BarAPI.setMessage(p, "�aZombie-Giant! �8[�e3�8/�e10�8]", 100);
        }
        return false;
    }
}
