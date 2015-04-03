package pl.hugozar.fairpvp.listeners;

import org.bukkit.event.player.*;
import pl.hugozar.fairpvp.managers.*;
import me.confuser.barapi.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PlayerQuit implements Listener
{
    @EventHandler
    public void onQuit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (PvPManager.getPvPTime(p) != null) {
            PvPManager.removePvPTime(p);
            PvPManager.removeLastDamager(p);
            BarAPI.removeBar(p);
            p.setHealth(0.0);
        }
    }
}
