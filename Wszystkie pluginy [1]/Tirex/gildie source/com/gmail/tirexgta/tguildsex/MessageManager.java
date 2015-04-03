package com.gmail.tirexgta.tguildsex;

import java.util.*;
import org.bukkit.configuration.file.*;
import java.io.*;

public class MessageManager
{
    Main plugin;
    File file;
    FileConfiguration data;
    public List<String> allowCommands;
    public List<String> allowCommandsLider;
    public String createCommand;
    public String createCorrectUsage;
    public String createWorld;
    public String createTagShort;
    public String createTagLong;
    public String createNameShort;
    public String createNameLong;
    public String createIsGuild;
    public String createCloseSpawn;
    public String createCloseGuild;
    public String createIsTag;
    public String createIsName;
    public String createNoItems;
    public String createCreate;
    public String removeCommand;
    public String removeCorrectUsage;
    public String removeNoLider;
    public String removeRemove;
    public String inviteCommand;
    public String inviteCorrectUsage;
    public String inviteIsOffline;
    public String inviteNoMistrz;
    public String inviteIsGuild;
    public String inviteIsMax;
    public List<String> inviteSendMsg;
    public List<String> inviteGetMsg;
    public List<String> inviteSendMsgCancel;
    public List<String> inviteGetMsgCancel;
    public String joinCommand;
    public String joinCorrectUsage;
    public String joinIsGuild;
    public String joinIsNoGuild;
    public String joinIsNoInvite;
    public String joinIsNoItems;
    public String joinJoin;
    public String leaveCommand;
    public String leaveCorrectUsage;
    public String leaveIsNoGuild;
    public String leaveIsLider;
    public String leaveLeave;
    public String kickCommand;
    public String kickCorrectUsage;
    public String kickIsOffline;
    public String kickIsOther;
    public String kickIsNoGuild;
    public String kickIsNoMistrz;
    public String kickIsMistrz;
    public String kickKick;
    public String liderCommand;
    public String liderCorrectUsage;
    public String liderIsOffline;
    public String liderIsNoLider;
    public String liderIsNoGuild;
    public String liderIsOther;
    public String liderIsNoItems;
    public String liderLider;
    public String mistrzCommand;
    public String mistrzCorrectUsage;
    public String mistrzIsOffline;
    public String mistrzIsNoLider;
    public String mistrzIsNoGuild;
    public String mistrzIsOther;
    public String mistrzMistrzSet;
    public String mistrzMistrzUnset;
    public String pvpCommand;
    public String pvpCorrectUsage;
    public String pvpIsNoLider;
    public List<String> pvpPvpOn;
    public List<String> pvpPvpOff;
    public String homeCommand;
    public String homeCorrectUsage;
    public String homeIsNoGuild;
    public String homeIsGuild;
    public String homeHomeBefore;
    public String homeHomeAfter;
    public String sethomeCommand;
    public String sethomeCorrectUsage;
    public String sethomeIsNoLider;
    public String sethomeIsNoGuild;
    public List<String> sethomeSethome;
    public String infoCommand;
    public String infoCorrectUsage;
    public String infoNone;
    public String infoAlliances;
    public List<String> infoMsg;
    public String ownerCommand;
    public String regionJoinEnemy;
    public String regionJoin;
    public String regionLeave;
    public String regionBreak;
    public String regionBuildExplode;
    public List<String> playerMsg;
    public String playerCorrectUsage;
    public String playerNoPlayer;
    
    public MessageManager(final Main plugin) {
        super();
        this.plugin = plugin;
        this.file = new File(this.plugin.getDataFolder(), "message.yml");
        if (!this.file.exists()) {
            this.copy(this.plugin.getResource("message.yml"), this.file);
        }
        this.data = (FileConfiguration)YamlConfiguration.loadConfiguration(this.file);
        this.save();
        this.load();
    }
    
    void load() {
        this.allowCommands = (List<String>)this.data.getStringList("allowCommands");
        this.allowCommandsLider = (List<String>)this.data.getStringList("allowCommandsLider");
        this.createCommand = this.data.getString("create.command");
        this.createCorrectUsage = this.data.getString("create.correctUsage");
        this.createWorld = this.data.getString("create.world");
        this.createTagShort = this.data.getString("create.tagShort");
        this.createTagLong = this.data.getString("create.tagLong");
        this.createNameShort = this.data.getString("create.nameShort");
        this.createNameLong = this.data.getString("create.nameLong");
        this.createIsGuild = this.data.getString("create.isGuild");
        this.createCloseSpawn = this.data.getString("create.closeSpawn");
        this.createCloseGuild = this.data.getString("create.closeGuild");
        this.createIsTag = this.data.getString("create.isTag");
        this.createIsName = this.data.getString("create.isName");
        this.createNoItems = this.data.getString("create.noItems");
        this.createCreate = this.data.getString("create.create");
        this.removeCommand = this.data.getString("remove.command");
        this.removeCorrectUsage = this.data.getString("remove.correctUsage");
        this.removeNoLider = this.data.getString("remove.noLider");
        this.removeRemove = this.data.getString("remove.remove");
        this.inviteCommand = this.data.getString("invite.command");
        this.inviteCorrectUsage = this.data.getString("invite.correctUsage");
        this.inviteIsOffline = this.data.getString("invite.isOffline");
        this.inviteNoMistrz = this.data.getString("invite.noMistrz");
        this.inviteIsGuild = this.data.getString("invite.isGuild");
        this.inviteIsMax = this.data.getString("invite.isMax");
        this.inviteSendMsg = (List<String>)this.data.getStringList("invite.sendMsg");
        this.inviteGetMsg = (List<String>)this.data.getStringList("invite.getMsg");
        this.inviteSendMsgCancel = (List<String>)this.data.getStringList("invite.sendMsgCancel");
        this.inviteGetMsgCancel = (List<String>)this.data.getStringList("invite.getMsgCancel");
        this.joinCommand = this.data.getString("join.command");
        this.joinCorrectUsage = this.data.getString("join.correctUsage");
        this.joinIsGuild = this.data.getString("join.isGuild");
        this.joinIsNoGuild = this.data.getString("join.isNoGuild");
        this.joinIsNoInvite = this.data.getString("join.isNoInvite");
        this.joinIsNoItems = this.data.getString("join.isNoItems");
        this.joinJoin = this.data.getString("join.join");
        this.leaveCommand = this.data.getString("leave.command");
        this.leaveCorrectUsage = this.data.getString("leave.correctUsage");
        this.leaveIsNoGuild = this.data.getString("leave.isNoGuild");
        this.leaveIsLider = this.data.getString("leave.isLider");
        this.leaveLeave = this.data.getString("leave.leave");
        this.kickCommand = this.data.getString("kick.command");
        this.kickCorrectUsage = this.data.getString("kick.correctUsage");
        this.kickIsOffline = this.data.getString("kick.isOffline");
        this.kickIsOther = this.data.getString("kick.isOther");
        this.kickIsNoGuild = this.data.getString("kick.isNoGuild");
        this.kickIsNoMistrz = this.data.getString("kick.isNoMistrz");
        this.kickIsMistrz = this.data.getString("kick.isMistrz");
        this.kickKick = this.data.getString("kick.kick");
        this.liderCommand = this.data.getString("lider.command");
        this.liderCorrectUsage = this.data.getString("lider.correctUsage");
        this.liderIsOffline = this.data.getString("lider.isOffline");
        this.liderIsNoLider = this.data.getString("lider.isNoLider");
        this.liderIsNoGuild = this.data.getString("lider.isNoGuild");
        this.liderIsOther = this.data.getString("lider.isOther");
        this.liderIsNoItems = this.data.getString("lider.isNoItems");
        this.liderLider = this.data.getString("lider.lider");
        this.mistrzCommand = this.data.getString("mistrz.command");
        this.mistrzCorrectUsage = this.data.getString("mitrz.correctUsage");
        this.mistrzIsOffline = this.data.getString("mistrz.isOffline");
        this.mistrzIsNoLider = this.data.getString("mistrz.isNoLider");
        this.mistrzIsNoGuild = this.data.getString("mistrz.isNoGuild");
        this.mistrzIsOther = this.data.getString("mistrz.isOther");
        this.mistrzMistrzSet = this.data.getString("mistrz.mistrzSet");
        this.mistrzMistrzUnset = this.data.getString("mistrz.mistrzUnset");
        this.pvpCommand = this.data.getString("pvp.command");
        this.pvpCorrectUsage = this.data.getString("pvp.correctUsage");
        this.pvpIsNoLider = this.data.getString("pvp.isNoLider");
        this.pvpPvpOn = (List<String>)this.data.getStringList("pvp.pvpOn");
        this.pvpPvpOff = (List<String>)this.data.getStringList("pvp.pvpOff");
        this.homeCommand = this.data.getString("home.command");
        this.homeCorrectUsage = this.data.getString("home.correctUsage");
        this.homeIsNoGuild = this.data.getString("home.isNoGuild");
        this.homeIsGuild = this.data.getString("home.isGuild");
        this.homeHomeBefore = this.data.getString("home.homeBefore");
        this.homeHomeAfter = this.data.getString("home.homeAfter");
        this.sethomeCommand = this.data.getString("sethome.command");
        this.sethomeCorrectUsage = this.data.getString("sethome.correctUsage");
        this.sethomeIsNoLider = this.data.getString("sethome.isNoLider");
        this.sethomeIsNoGuild = this.data.getString("sethome.isNoGuild");
        this.sethomeSethome = (List<String>)this.data.getStringList("sethome.sethome");
        this.infoCommand = this.data.getString("info.command");
        this.infoCorrectUsage = this.data.getString("info.correctUsage");
        this.infoNone = this.data.getString("info.none");
        this.infoAlliances = this.data.getString("info.alliances");
        this.infoMsg = (List<String>)this.data.getStringList("info.msg");
        this.ownerCommand = this.data.getString("owner.command");
        this.regionJoinEnemy = this.data.getString("region.joinEnemy");
        this.regionJoin = this.data.getString("region.join");
        this.regionLeave = this.data.getString("region.leave");
        this.regionBreak = this.data.getString("region.break");
        this.regionBuildExplode = this.data.getString("region.buildExplode");
        this.playerMsg = (List<String>)this.data.getStringList("player.msg");
        this.playerCorrectUsage = this.data.getString("player.correctUsage");
        this.playerNoPlayer = this.data.getString("player.noPlayer");
    }
    
    void save() {
        this.saveData();
    }
    
    void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "message.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku message.yml");
        }
    }
    
    void copy(final InputStream in, final File file) {
        try {
            copyy(in, file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void copyy(final InputStream in, final File file) throws IOException {
        final OutputStream out = new FileOutputStream(file);
        final byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.close();
        in.close();
    }
}
