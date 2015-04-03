package com.gmail.tirexgta.ttoolsex;

import org.bukkit.plugin.java.*;
import java.util.logging.*;
import net.milkbowl.vault.permission.*;
import org.bukkit.scoreboard.*;
import com.gmail.tirexgta.ttoolsex.commands.*;
import com.gmail.tirexgta.ttoolsex.others.*;
import com.gmail.tirexgta.ttoolsex.listeners.*;
import com.gmail.tirexgta.ttoolsex.database.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import java.util.*;
import java.util.regex.*;
import org.bukkit.*;
import org.bukkit.event.player.*;
import org.bukkit.scheduler.*;

public class Main extends JavaPlugin
{
    public static Main plugin;
    public static Logger log;
    public static Permission chat;
    public static ScoreboardManager manager;
    public static Scoreboard board;
    Plugin[] plugins;
    public Config config;
    DispenserCommand dispenserCommand;
    BanCommand banCommand;
    KickallCommand kickallCommand;
    RangaCommand rangaCommand;
    SetSpawnCommand setspawnCommand;
    UnbanCommand unbanCommand;
    WymianaCommand wymianaCommand;
    BroadcastCommand broadcastCommand;
    ClearCommand clearCommand;
    EnchantCommand enchantCommand;
    FlyCommand flyCommand;
    GameModeCommand gameModeCommand;
    GiveCommand giveCommand;
    public GodCommand godCommand;
    HatCommand hatCommand;
    HeadCommand headCommand;
    HealCommand healCommand;
    HelpCommand helpCommand;
    HomeCommand homeCommand;
    IgnoreCommand ignoreCommand;
    PlecakCommand plecakCommand;
    InvincibleCommand invincibleCommand;
    ItemCommand itemCommand;
    KickCommand kickCommand;
    ListCommand listcommand;
    MessageCommand messageCommand;
    MuteCommand muteCommand;
    RepairCommand repairCommand;
    public ReplyCommand replyCommand;
    SethomeCommand sethomeCommand;
    SlotManagerCommand slotManagerCommand;
    SpawnCommand spawnCommand;
    SpawnerCommand spawnerCommand;
    SpeedCommand speedCommand;
    TellCommand tellCommand;
    TimeCommand timeCommand;
    ReloadToolsCommand reloadToolsCommand;
    TpCommand tpCommand;
    public TpaCommand tpaCommand;
    TpacceptCommand tpacceptCommand;
    TpdenyCommand tpdenyCommand;
    TpposCommand tpposCommand;
    UnmuteCommand unmuteCommand;
    WeatherCommand weatherCommand;
    RandomTeleportCommand randomTeleportCommand;
    SkinCommand skinCommand;
    RangiCommand rangiCommand;
    Recipe recipe;
    Pokeball pokeball;
    AutoMessageScheduler autoMessageScheduler;
    SaveScheduler saveScheduler;
    public DispensersManager dispensersManager;
    public EffectManager effectManager;
    public Enchantments enchantments;
    public IgnoredManager ignoredManager;
    public RangManager rangManager;
    public BackpackManager backpackManager;
    public InvincibleManager invincibleManager;
    public LastTeleportManager lastTeleportManager;
    public RandomTeleportManager randomTeleportManager;
    public DispensersListener dispensersListener;
    public SlotManagerListener slotManagerListener;
    public GodListener godListener;
    public TeleportCancelListener teleportCancelListener;
    BanListener banListener;
    RangListener rangListener;
    BackpackListener backpackListener;
    SilentJoinLeaveListener silentJoinLeaveListener;
    UserJoinLeaveListener userJoinLeaveListener;
    WelcomeMessageListener welcomeMessageListener;
    InvincibleListener invincibleListener;
    MuteListener muteListener;
    PermissionsCommandsListener permissionsCommandsListener;
    StoneGeneratorListener stoneGeneratorListener;
    RegenerationHeartListener regenerationHeartListener;
    public RandomTeleportListener randomTeleportListener;
    ColorSignListener colorSignListener;
    BlockedStrenghtListener blockedStrenghtListener;
    public Datasource data;
    DataUser dataUser;
    
    static {
        Main.chat = null;
    }
    
    public void onEnable() {
        Main.plugin = this;
        Main.log = this.getLogger();
        Main.manager = Bukkit.getScoreboardManager();
        Main.board = Main.manager.getMainScoreboard();
        this.plugins = this.getPlugins();
        this.config = new Config(this);
        this.recipe = new Recipe(this);
        this.pokeball = new Pokeball(this);
        this.giveCommand = new GiveCommand(this);
        this.gameModeCommand = new GameModeCommand(this);
        this.flyCommand = new FlyCommand(this);
        this.enchantCommand = new EnchantCommand(this);
        this.dispenserCommand = new DispenserCommand(this);
        this.banCommand = new BanCommand(this);
        this.kickallCommand = new KickallCommand(this);
        this.plecakCommand = new PlecakCommand(this);
        this.rangaCommand = new RangaCommand(this);
        this.setspawnCommand = new SetSpawnCommand(this);
        this.unbanCommand = new UnbanCommand(this);
        this.wymianaCommand = new WymianaCommand(this);
        this.broadcastCommand = new BroadcastCommand(this);
        this.clearCommand = new ClearCommand(this);
        this.godCommand = new GodCommand(this);
        this.hatCommand = new HatCommand(this);
        this.headCommand = new HeadCommand(this);
        this.healCommand = new HealCommand(this);
        this.helpCommand = new HelpCommand(this);
        this.homeCommand = new HomeCommand(this);
        this.ignoreCommand = new IgnoreCommand(this);
        this.invincibleCommand = new InvincibleCommand(this);
        this.itemCommand = new ItemCommand(this);
        this.kickCommand = new KickCommand(this);
        this.listcommand = new ListCommand(this);
        this.messageCommand = new MessageCommand(this);
        this.muteCommand = new MuteCommand(this);
        this.repairCommand = new RepairCommand(this);
        this.replyCommand = new ReplyCommand(this);
        this.sethomeCommand = new SethomeCommand(this);
        this.slotManagerCommand = new SlotManagerCommand(this);
        this.spawnCommand = new SpawnCommand(this);
        this.spawnerCommand = new SpawnerCommand(this);
        this.speedCommand = new SpeedCommand(this);
        this.tellCommand = new TellCommand(this);
        this.timeCommand = new TimeCommand(this);
        this.reloadToolsCommand = new ReloadToolsCommand(this);
        this.tpCommand = new TpCommand(this);
        this.tpaCommand = new TpaCommand(this);
        this.tpacceptCommand = new TpacceptCommand(this);
        this.tpdenyCommand = new TpdenyCommand(this);
        this.tpposCommand = new TpposCommand(this);
        this.unmuteCommand = new UnmuteCommand(this);
        this.weatherCommand = new WeatherCommand(this);
        this.randomTeleportCommand = new RandomTeleportCommand(this);
        this.skinCommand = new SkinCommand(this);
        this.dispensersListener = new DispensersListener(this);
        this.slotManagerListener = new SlotManagerListener(this);
        this.godListener = new GodListener(this);
        this.teleportCancelListener = new TeleportCancelListener(this);
        this.rangListener = new RangListener(this);
        this.backpackListener = new BackpackListener(this);
        this.userJoinLeaveListener = new UserJoinLeaveListener(this);
        this.silentJoinLeaveListener = new SilentJoinLeaveListener(this);
        this.welcomeMessageListener = new WelcomeMessageListener(this);
        this.banListener = new BanListener(this);
        this.invincibleListener = new InvincibleListener(this);
        this.muteListener = new MuteListener(this);
        this.permissionsCommandsListener = new PermissionsCommandsListener(this);
        this.stoneGeneratorListener = new StoneGeneratorListener(this);
        this.regenerationHeartListener = new RegenerationHeartListener(this);
        this.randomTeleportListener = new RandomTeleportListener(this);
        this.colorSignListener = new ColorSignListener(this);
        this.blockedStrenghtListener = new BlockedStrenghtListener(this);
        this.dispensersManager = new DispensersManager(this);
        this.autoMessageScheduler = new AutoMessageScheduler(this);
        this.saveScheduler = new SaveScheduler(this);
        this.enchantments = new Enchantments(this);
        this.ignoredManager = new IgnoredManager(this);
        this.rangManager = new RangManager(this);
        this.backpackManager = new BackpackManager(this);
        this.invincibleManager = new InvincibleManager(this);
        this.lastTeleportManager = new LastTeleportManager(this);
        this.randomTeleportManager = new RandomTeleportManager(this);
        this.data = new Datasource(this);
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = this.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player player = onlinePlayers[i];
            DataUser user = Datasource.getUserData(player);
            if (user == null) {
                user = this.data.createUser();
                user.setNick(player.getName());
                this.exportPlayerData(user, player);
                user.insert();
            }
            else {
                this.importPlayerData(user, player);
            }
        }
        this.setupChat();
    }
    
    public void onDisable() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player online = onlinePlayers[i];
            final DataUser user = Datasource.getUserData(online);
            if (user != null) {
                this.exportPlayerData(user, online);
                user.update();
            }
        }
        this.saveMap();
        this.data.saveAll();
        this.config.save();
        this.backpackManager.saveData();
        this.rangManager.saveData();
        this.ignoredManager.saveData();
        this.dispensersManager.saveData();
        this.invincibleManager.saveData();
    }
    
    public static Main getThis() {
        return Main.plugin;
    }
    
    private boolean setupChat() {
        final RegisteredServiceProvider<Permission> chatProvider = (RegisteredServiceProvider<Permission>)this.getServer().getServicesManager().getRegistration((Class)Permission.class);
        if (chatProvider != null) {
            Main.chat = (Permission)chatProvider.getProvider();
        }
        else {
            Main.log.info("§4Na serwerze nie ma pluginu §9Vault §4Plugin moze nie dzialac w 100% poprawnie!");
        }
        return Main.chat != null;
    }
    
    public void saveMap() {
        Bukkit.broadcastMessage(ChatColor.BLUE + "Trwa zapisywanie swiata...");
        Bukkit.savePlayers();
        for (final World world : Bukkit.getWorlds()) {
            world.save();
        }
        Bukkit.broadcastMessage(ChatColor.BLUE + "Swiat zostal pomyslnie zapisany.");
    }
    
    public String fix(final String s) {
        if (s != null) {
            return ChatColor.translateAlternateColorCodes('&', s);
        }
        return null;
    }
    
    public int slot() {
        return this.getServer().getOnlinePlayers().length;
    }
    
    public boolean containsIgnoreCase(final String[] board, final String string) {
        for (final String otherstring : board) {
            if (otherstring.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }
    
    public static Material getMaterial(final String materialName) {
        Material returnMaterial = null;
        if (isInteger(materialName)) {
            final int id = Integer.parseInt(materialName);
            returnMaterial = Material.getMaterial(id);
        }
        else {
            returnMaterial = Material.matchMaterial(materialName);
        }
        return returnMaterial;
    }
    
    public static boolean isDouble(final String s) {
        try {
            Double.parseDouble(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static boolean isInteger(final String s) {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static boolean isFloat(final String s) {
        try {
            Float.parseFloat(s);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static long stringToTime(final String time) {
        final Pattern timePattern = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2);
        final Matcher m = timePattern.matcher(time);
        long seconds = 0L;
        boolean found = false;
        while (m.find()) {
            if (m.group() != null && !m.group().isEmpty()) {
                for (int i = 0; i < m.groupCount(); ++i) {
                    if (m.group(i) != null && !m.group(i).isEmpty()) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    continue;
                }
                if (m.group(1) != null && !m.group(1).isEmpty()) {
                    seconds += 31556926 * Integer.parseInt(m.group(1));
                }
                if (m.group(2) != null && !m.group(2).isEmpty()) {
                    seconds += 2629743 * Integer.parseInt(m.group(2));
                }
                if (m.group(3) != null && !m.group(3).isEmpty()) {
                    seconds += 604800 * Integer.parseInt(m.group(3));
                }
                if (m.group(4) != null && !m.group(4).isEmpty()) {
                    seconds += 86400 * Integer.parseInt(m.group(4));
                }
                if (m.group(5) != null && !m.group(5).isEmpty()) {
                    seconds += 3600 * Integer.parseInt(m.group(5));
                }
                if (m.group(6) != null && !m.group(6).isEmpty()) {
                    seconds += 60 * Integer.parseInt(m.group(6));
                }
                if (m.group(7) == null || m.group(7).isEmpty()) {
                    continue;
                }
                seconds += Integer.parseInt(m.group(7));
            }
        }
        if (!found) {
            return -1L;
        }
        return seconds * 1000L;
    }
    
    public static void teleportPlayerWithDelay(final Player player, final int delayTime, final Location location, final String messageAfterTp, final Runnable postTeleport) {
        if (Main.plugin.teleportCancelListener.playerTeleportLocation.get(player) != null) {
            Main.plugin.teleportCancelListener.playerTeleportLocation.remove(player);
        }
        final BukkitTask task = Main.plugin.getServer().getScheduler().runTaskLater((Plugin)Main.plugin, (Runnable)new Runnable(player) {
            private Player val$player = val$player;
            
            @Override
            public void run() {
                if (this.val$player.isOnline()) {
                    this.val$player.teleport(location, PlayerTeleportEvent.TeleportCause.COMMAND);
                    if (Main.plugin.teleportCancelListener.teleport.contains(this.val$player)) {
                        Main.plugin.teleportCancelListener.teleport.remove(this.val$player);
                    }
                    Main.plugin.teleportCancelListener.playerTeleportLocation.remove(this.val$player);
                    if (messageAfterTp != null) {
                        this.val$player.sendMessage(messageAfterTp);
                    }
                    if (postTeleport != null) {
                        postTeleport.run();
                    }
                }
            }
        }, (long)(delayTime * 20));
        Main.plugin.teleportCancelListener.playerTeleportLocation.put(player, task);
    }
    
    public void exportPlayerData(final DataUser user, final Player player) {
        final Location loc = player.getLocation();
        user.setWorld(loc.getWorld().getName());
        user.setX(loc.getBlockX());
        user.setY(loc.getBlockY());
        user.setZ(loc.getBlockZ());
        user.setGamemode(player.getGameMode());
        user.setFly(player.getAllowFlight());
    }
    
    public void importPlayerData(final DataUser user, final Player player) {
        player.setGameMode(user.getGamemode());
        player.setAllowFlight(user.getFly());
    }
    
    public Plugin[] getPlugins() {
        return this.getServer().getPluginManager().getPlugins();
    }
}
