package pl.hugozar.fairpvp.managers;

import org.bukkit.scheduler.*;
import org.bukkit.*;
import me.confuser.barapi.*;
import org.bukkit.entity.*;
import pl.hugozar.fairpvp.*;
import org.bukkit.plugin.*;

public class TimerManager
{
    static BukkitTask timer;
    
    public static void startTimer() {
        TimerManager.timer = new BukkitRunnable() {
            public void run() {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player p = onlinePlayers[i];
                    if (BarAPI.hasBar(p)) {
                        if (BarAPI.getMessage(p).equals(Utils.fixColors("&cANTY-LOGOUT"))) {
                            int time = PvPManager.getPvPTime(p) - 20;
                            int timePercent = PvPManager.getPvPTime(p) / 2 - 10;
                            if (PvPManager.getLastDamage(p) != null && PvPManager.getLastDamage(p) instanceof Player) {
                                if (p.getLocation().distance(PvPManager.getLastDamage(p).getLocation()) >= 50.0) {
                                    time = PvPManager.getPvPTime(p) - 10;
                                    timePercent = PvPManager.getPvPTime(p) / 2 - 5;
                                }
                                else {
                                    time = PvPManager.getPvPTime(p) - 4;
                                    timePercent = PvPManager.getPvPTime(p) / 2 - 2;
                                }
                            }
                            if (time < 1) {
                                PvPManager.removePvPTime(p);
                                PvPManager.removeLastDamager(p);
                                PvPManager.setNoPvPTime(p, 1.0f);
                                BarAPI.removeBar(p);
                                BarAPI.setMessage(p, Utils.fixColors("&aANTY-LOGOUT"));
                                BarAPI.setHealth(p, 1.0f);
                            }
                            else {
                                PvPManager.setPvPTime(p, time);
                                BarAPI.setHealth(p, (float)timePercent);
                            }
                        }
                        else if (BarAPI.getMessage(p).equals(Utils.fixColors("&aANTY-LOGOUT"))) {
                            final float time2 = (float)(PvPManager.getNoPvPTime(p) - 0.2);
                            final float timePercent2 = (float)(PvPManager.getNoPvPTime(p) / 2.0f - 0.1);
                            if (time2 < 0.0f) {
                                PvPManager.removeNoPvPTime(p);
                                BarAPI.removeBar(p);
                            }
                            else {
                                PvPManager.setNoPvPTime(p, time2);
                                BarAPI.setHealth(p, timePercent2);
                            }
                        }
                    }
                }
            }
        }.runTaskTimer((Plugin)FairPvP.getInst(), 20L, 20L);
    }
    
    public void stopTimer() {
        TimerManager.timer.cancel();
    }
}
