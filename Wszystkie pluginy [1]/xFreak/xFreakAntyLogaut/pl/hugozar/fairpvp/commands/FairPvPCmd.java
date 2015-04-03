package pl.hugozar.fairpvp.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import pl.hugozar.fairpvp.managers.*;

public class FairPvPCmd implements CommandExecutor
{
    public boolean onCommand(final CommandSender cs, final Command cmd, final String arg, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("fairpvp") && cs instanceof Player) {
            final Player p = (Player)cs;
            p.sendMessage(Utils.fixColors("&7Mozliwosc wyjscia z gry&8: " + ((PvPManager.getPvPTime(p) == null) ? "&aTAK" : "&cNIE") + " &8(&6" + ((PvPManager.getPvPTime(p) == null) ? "0" : PvPManager.getPvPTime(p)) + "&7/&6200&8)&7."));
        }
        return false;
    }
}
