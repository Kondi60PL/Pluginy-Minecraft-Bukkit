package com.gmail.tirexgta.tguildsex;

import org.bukkit.plugin.java.*;
import java.util.logging.*;
import org.bukkit.scoreboard.*;
import com.gmail.tirexgta.tguildsex.tags.*;
import com.gmail.tirexgta.tguildsex.listeners.*;
import com.gmail.tirexgta.tguildsex.commands.*;
import com.comphenix.protocol.*;
import com.gmail.tirexgta.tguildsex.enchantments.*;
import org.bukkit.enchantments.*;
import org.bukkit.block.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.plugin.*;
import org.bukkit.scheduler.*;
import org.bukkit.*;

public class Main extends JavaPlugin
{
    public static Main pluginn;
    Main plugin;
    Logger log;
    public ProtocolManager prot;
    public static ScoreboardManager sbManager;
    public static Scoreboard sb;
    public ConfigManager configManager;
    public InfoManager infoManager;
    RecipeManager recipeManager;
    public MessageManager messageManager;
    public TabManager tabManager;
    UserJoinLeaveListener userJoinLeaveListener;
    InviteListener inviteListener;
    FriendlyFireListener friendlyFireListener;
    EnemyListener enemyListener;
    TeleportCancelListener teleportCancelListener;
    public TagListener tagListener;
    ExplodeListener explodeListener;
    public ChatListener chatListener;
    public TabListener tabListener;
    RankingListener rankingListener;
    public GuildCommand guildCommand;
    SojuszCommand sojuszCommand;
    GraczCommand graczCommand;
    public Datasource data;
    public static NewGuildEnchant newGuildEnchant;
    public NewGuildEnchant newGuildEnchantt;
    
    static {
        Main.newGuildEnchant = new NewGuildEnchant(69);
    }
    
    public Main() {
        super();
        this.newGuildEnchantt = Main.newGuildEnchant;
    }
    
    public void onEnable() {
        Main.pluginn = this;
        this.plugin = this;
        this.log = this.getLogger();
        this.prot = ProtocolLibrary.getProtocolManager();
        Main.sbManager = this.getServer().getScoreboardManager();
        Main.sb = Main.sbManager.getMainScoreboard();
        this.configManager = new ConfigManager(this);
        this.infoManager = new InfoManager(this);
        this.recipeManager = new RecipeManager(this);
        this.messageManager = new MessageManager(this);
        this.tabManager = new TabManager(this);
        this.userJoinLeaveListener = new UserJoinLeaveListener(this);
        this.inviteListener = new InviteListener(this);
        this.friendlyFireListener = new FriendlyFireListener(this);
        this.enemyListener = new EnemyListener(this);
        this.teleportCancelListener = new TeleportCancelListener(this);
        this.tagListener = new TagListener(this);
        this.explodeListener = new ExplodeListener(this);
        this.chatListener = new ChatListener(this);
        this.tabListener = new TabListener(this);
        this.rankingListener = new RankingListener(this);
        this.guildCommand = new GuildCommand(this);
        this.sojuszCommand = new SojuszCommand(this);
        this.graczCommand = new GraczCommand(this);
        this.data = new Datasource(this);
        final RegisterEnchant register = new RegisterEnchant(this.newGuildEnchantt, this.newGuildEnchantt.getName(), this.newGuildEnchantt.getId());
        register.register();
    }
    
    public Datasource getData() {
        return this.data;
    }
    
    public DataGuild getGildiaByBlock(final Block block) {
        final int x = block.getX();
        final int z = block.getZ();
        for (final DataGuild gildia : this.data.guild) {
            if (block.getWorld().getName().equals(gildia.getWorld())) {
                final int bazaX = gildia.getX();
                final int bazaZ = gildia.getZ();
                final int maxX = Math.max(x, bazaX);
                final int minX = Math.min(x, bazaX);
                final int maxZ = Math.max(z, bazaZ);
                final int minZ = Math.min(z, bazaZ);
                if (maxX - minX <= gildia.getPromien() && maxZ - minZ <= gildia.getPromien()) {
                    return gildia;
                }
                continue;
            }
        }
        return null;
    }
    
    public DataGuild getGildiaByLocation(final Location loc) {
        final int x = loc.getBlockX();
        final int z = loc.getBlockZ();
        for (final DataGuild gildia : this.data.guild) {
            if (loc.getWorld().getName().equals(gildia.getWorld())) {
                final int bazaX = gildia.getX();
                final int bazaZ = gildia.getZ();
                final int maxX = Math.max(x, bazaX);
                final int minX = Math.min(x, bazaX);
                final int maxZ = Math.max(z, bazaZ);
                final int minZ = Math.min(z, bazaZ);
                if (maxX - minX <= gildia.getPromien() && maxZ - minZ <= gildia.getPromien()) {
                    return gildia;
                }
                continue;
            }
        }
        return null;
    }
    
    public void teleportPlayerWithDelay(final Player player, final int delayTime, final Location location, final String messageAfterTp, final Runnable postTeleport) {
        if (this.plugin.teleportCancelListener.playerTeleportLocation.get(player) != null) {
            this.plugin.teleportCancelListener.playerTeleportLocation.remove(player);
        }
        final BukkitTask task = this.plugin.getServer().getScheduler().runTaskLater((Plugin)this.plugin, (Runnable)new Runnable(player) {
            private Player val$player = val$player;
            
            @Override
            public void run() {
                if (this.val$player.isOnline()) {
                    this.val$player.teleport(location, PlayerTeleportEvent.TeleportCause.COMMAND);
                    if (Main.this.plugin.teleportCancelListener.teleport.contains(this.val$player)) {
                        Main.this.plugin.teleportCancelListener.teleport.remove(this.val$player);
                    }
                    Main.this.teleportCancelListener.playerTeleportLocation.remove(this.val$player);
                    if (messageAfterTp != null) {
                        this.val$player.sendMessage(messageAfterTp);
                    }
                    if (postTeleport != null) {
                        postTeleport.run();
                    }
                }
            }
        }, (long)(delayTime * 20));
        this.plugin.teleportCancelListener.playerTeleportLocation.put(player, task);
    }
    
    public Datasource getDatasource() {
        return this.data;
    }
    
    public boolean closeSpawn(final Player p) {
        final int x = p.getLocation().getBlockX();
        final int z = p.getLocation().getBlockZ();
        final int spawnX = p.getWorld().getSpawnLocation().getBlockX();
        final int spawnZ = p.getWorld().getSpawnLocation().getBlockZ();
        final int maxX = Math.max(x, spawnX);
        final int minX = Math.min(x, spawnX);
        final int maxZ = Math.max(z, spawnZ);
        final int minZ = Math.min(z, spawnZ);
        return maxX - minX <= this.plugin.configManager.guildCreateSpawn && maxZ - minZ <= this.plugin.configManager.guildCreateSpawn;
    }
    
    public boolean closeGuild(final Player p) {
        final int x = p.getLocation().getBlockX();
        final int z = p.getLocation().getBlockZ();
        for (final DataGuild gildia : this.plugin.data.guild) {
            if (p.getWorld().getName().equals(gildia.getWorld())) {
                final int bazaX = gildia.getX();
                final int bazaZ = gildia.getZ();
                final int maxX = Math.max(x, bazaX);
                final int minX = Math.min(x, bazaX);
                final int maxZ = Math.max(z, bazaZ);
                final int minZ = Math.min(z, bazaZ);
                if (maxX - minX <= this.plugin.configManager.guildCreateGuild && maxZ - minZ <= this.plugin.configManager.guildCreateGuild) {
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public String fixMsg(final String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    
    public Scoreboard getScoreboard() {
        return Main.sb;
    }
}
