package pl.hugozar.fairpvp.managers;

import org.bukkit.entity.*;
import java.util.*;

public class PvPManager
{
    private static HashMap<Player, Integer> pvpTime;
    private static HashMap<Player, Entity> lastDamager;
    private static HashMap<Player, Float> noPvPTime;
    private static ArrayList<String> allowCmds;
    
    static {
        PvPManager.pvpTime = new HashMap<Player, Integer>();
        PvPManager.lastDamager = new HashMap<Player, Entity>();
        PvPManager.noPvPTime = new HashMap<Player, Float>();
        PvPManager.allowCmds = new ArrayList<String>();
    }
    
    public static void setPvPTime(final Player p, final Integer time) {
        PvPManager.pvpTime.put(p, time);
    }
    
    public static void setLastDamager(final Player p, final Entity entity) {
        PvPManager.lastDamager.put(p, entity);
    }
    
    public static void setNoPvPTime(final Player p, final float time) {
        PvPManager.noPvPTime.put(p, time);
    }
    
    public static void removePvPTime(final Player p) {
        PvPManager.pvpTime.remove(p);
    }
    
    public static void removeLastDamager(final Player p) {
        PvPManager.lastDamager.remove(p);
    }
    
    public static void removeNoPvPTime(final Player p) {
        PvPManager.noPvPTime.remove(p);
    }
    
    public static Integer getPvPTime(final Player p) {
        return PvPManager.pvpTime.get(p);
    }
    
    public static Entity getLastDamage(final Player p) {
        return PvPManager.lastDamager.get(p);
    }
    
    public static Float getNoPvPTime(final Player p) {
        return PvPManager.noPvPTime.get(p);
    }
    
    public static ArrayList<String> getAllowCmds() {
        return PvPManager.allowCmds;
    }
}
