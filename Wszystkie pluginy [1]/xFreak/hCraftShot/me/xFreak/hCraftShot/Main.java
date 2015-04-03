package me.xFreak.hCraftShot;

import org.bukkit.plugin.java.*;
import java.util.logging.*;
import org.bukkit.command.*;
import me.xFreak.hCraftShot.command.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.*;

public class Main extends JavaPlugin
{
    public static String getPrefix;
    public final Logger logger;
    public static Main plugin;
    
    static {
        Main.getPrefix = "§1[§7Alert§1]";
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
        this.getCommand("pomoc").setExecutor((CommandExecutor)new hCraftShot(this));
        this.getCommand("livenuse").setExecutor((CommandExecutor)new Broadcast(this));
        this.getCommand("enderchest").setExecutor((CommandExecutor)new Enderchest(this));
        this.getCommand("stoniarka").setExecutor((CommandExecutor)new Stoniarka(this));
        this.getCommand("poca").setExecutor((CommandExecutor)new hCraftShot2(this));
        this.getCommand("msg").setExecutor((CommandExecutor)new Msg(this));
        this.getCommand("check").setExecutor((CommandExecutor)new HashMaps(this));
        this.getCommand("hashset").setExecutor((CommandExecutor)new HashMaps(this));
        this.getCommand("liveseby").setExecutor((CommandExecutor)new BroadcastLive2(this));
        this.getCommand("tp").setExecutor((CommandExecutor)new Tp(this));
        this.getCommand("rodzka").setExecutor((CommandExecutor)new Rodzka(this));
        this.getCommand("heal").setExecutor((CommandExecutor)new Healed(this));
        this.getCommand("alert").setExecutor((CommandExecutor)new BroadcastAlert(this));
        final ShapedRecipe enderchest = new ShapedRecipe(new ItemStack(Material.ENDER_CHEST, 1)).shape(new String[] { "&&&", "&%&", "&&&" }).setIngredient('&', Material.OBSIDIAN).setIngredient('%', Material.ENDER_PEARL);
        final ShapedRecipe siodlo = new ShapedRecipe(new ItemStack(Material.SADDLE)).shape(new String[] { " & ", "&%&", " & " }).setIngredient('&', Material.LEATHER).setIngredient('%', Material.STRING);
        this.getServer().addRecipe((Recipe)enderchest);
        this.getServer().addRecipe((Recipe)siodlo);
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }
}
