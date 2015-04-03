package pl.hugozar.fairpvp.listeners;

import org.bukkit.event.entity.*;
import pl.hugozar.fairpvp.managers.*;
import me.confuser.barapi.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PlayerDeath implements Listener
{
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (PvPManager.getPvPTime(p) != null) {
            PvPManager.removePvPTime(p);
            PvPManager.removeLastDamager(p);
            BarAPI.removeBar(p);
        }
    }
}
