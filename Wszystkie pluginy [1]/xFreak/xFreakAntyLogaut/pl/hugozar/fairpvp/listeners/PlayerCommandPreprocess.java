package pl.hugozar.fairpvp.listeners;

import org.bukkit.event.player.*;
import pl.hugozar.fairpvp.managers.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;

public class PlayerCommandPreprocess implements Listener
{
    @EventHandler
    public void onQuit(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (PvPManager.getPvPTime(p) != null) {
            for (final String cmd : PvPManager.getAllowCmds()) {
                if (e.getMessage().startsWith("/" + cmd)) {
                    e.setCancelled(true);
                    p.sendMessage(Utils.fixColors("&cNie mozesz uzywac tej komendy podczas pvp."));
                    break;
                }
            }
        }
    }
}
