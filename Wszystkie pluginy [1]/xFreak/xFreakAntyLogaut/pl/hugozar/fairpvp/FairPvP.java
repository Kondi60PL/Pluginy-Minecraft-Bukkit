package pl.hugozar.fairpvp;

import org.bukkit.plugin.java.*;
import pl.hugozar.fairpvp.commands.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import pl.hugozar.fairpvp.listeners.*;
import pl.hugozar.fairpvp.managers.*;

public class FairPvP extends JavaPlugin
{
    private static FairPvP inst;
    
    public void onEnable() {
        (FairPvP.inst = this).saveDefaultConfig();
        this.getCommand("fairpvp").setExecutor((CommandExecutor)new FairPvPCmd());
        Bukkit.getPluginManager().registerEvents((Listener)new EntityDamageByEntity(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerCommandPreprocess(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerDeath(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerQuit(), (Plugin)this);
        TimerManager.startTimer();
    }
    
    public static FairPvP getInst() {
        return FairPvP.inst;
    }
}
