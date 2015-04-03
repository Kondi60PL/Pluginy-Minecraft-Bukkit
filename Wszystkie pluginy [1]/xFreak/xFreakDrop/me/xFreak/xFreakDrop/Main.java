package me.xFreak.xFreakDrop;

import org.bukkit.plugin.java.*;
import java.util.logging.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import me.xFreak.xFreakDrop.command.*;
import org.bukkit.plugin.*;

public class Main extends JavaPlugin
{
    public final Logger logger;
    public final Drop d;
    public static Main plugin;
    
    public Main() {
        super();
        this.logger = Logger.getLogger("Minecraft");
        this.d = new Drop(this);
    }
    
    public void onDisable() {
        final PluginDescriptionFile pdf = this.getDescription();
        this.logger.info(String.valueOf(pdf.getName()) + ChatColor.RED + " Zostal Wylaczony");
    }
    
    public void onEnable() {
        final PluginDescriptionFile pdf = this.getDescription();
        this.logger.info(String.valueOf(pdf.getName()) + ChatColor.RED + " Wersja " + pdf.getVersion() + " Zostal wlaczony !");
        final PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents((Listener)this.d, (Plugin)this);
        this.getCommand("stone").setExecutor((CommandExecutor)new Stone(this));
        this.getCommand("zombi").setExecutor((CommandExecutor)new Zombi(this));
        this.getCommand("zombi2").setExecutor((CommandExecutor)new Zombi2(this));
        this.getCommand("zombi3").setExecutor((CommandExecutor)new Zombi3(this));
        this.getCommand("zombi4").setExecutor((CommandExecutor)new Zombi4(this));
        this.getCommand("zombi5").setExecutor((CommandExecutor)new Zombi5(this));
        this.getCommand("zombi6").setExecutor((CommandExecutor)new Zombi6(this));
        this.getCommand("zombi7").setExecutor((CommandExecutor)new Zombi7(this));
        this.getCommand("zombi8").setExecutor((CommandExecutor)new Zombi8(this));
        this.getCommand("zombi9").setExecutor((CommandExecutor)new Zombi9(this));
        this.getCommand("zombi10").setExecutor((CommandExecutor)new Zombi10(this));
        this.getCommand("zombixfreak").setExecutor((CommandExecutor)new Zombixfreak(this));
        this.getCommand("zombinusegame").setExecutor((CommandExecutor)new Zombinusegame(this));
        this.getCommand("zombimister").setExecutor((CommandExecutor)new Zombimister(this));
        this.getCommand("giandd").setExecutor((CommandExecutor)new Giand(this));
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }
}
