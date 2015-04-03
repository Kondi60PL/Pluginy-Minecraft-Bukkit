package me.xFreak.xFreakCommand;

import org.bukkit.plugin.java.*;
import java.util.logging.*;
import org.bukkit.*;
import org.bukkit.command.*;
import me.xFreak.xFreakCommand.command.*;
import org.bukkit.plugin.*;

public class Main extends JavaPlugin
{
    public static String getPrefix;
    public final Logger logger;
    public static Main plugin;
    
    static {
        Main.getPrefix = "§7[§6CraftShot§7]";
    }
    
    public Main() {
        super();
        this.logger = Logger.getLogger("Minecraft");
    }
    
    public void onDisable() {
        final PluginDescriptionFile pdf = this.getDescription();
        this.logger.info(String.valueOf(pdf.getName()) + ChatColor.RED + " Zostal wylaczony !");
        this.saveConfig();
    }
    
    public void onEnable() {
        final PluginDescriptionFile pdf = this.getDescription();
        this.logger.info(String.valueOf(pdf.getName()) + ChatColor.RED + " Wersja " + pdf.getVersion() + " Zostal wlaczony !");
        final PluginManager pm = this.getServer().getPluginManager();
        this.getCommand("pl").setExecutor((CommandExecutor)new Plugins(this));
        this.getCommand("?").setExecutor((CommandExecutor)new Plugins2(this));
        this.getCommand("plugins").setExecutor((CommandExecutor)new Plugins3(this));
        this.getCommand("help").setExecutor((CommandExecutor)new Help(this));
    }
}
