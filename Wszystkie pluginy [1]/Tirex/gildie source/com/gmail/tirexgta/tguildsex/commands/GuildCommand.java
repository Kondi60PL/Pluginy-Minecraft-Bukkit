package com.gmail.tirexgta.tguildsex.commands;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import java.text.*;
import org.bukkit.inventory.*;
import com.gmail.tirexgta.tguildsex.listeners.*;
import org.bukkit.*;
import com.gmail.tirexgta.tguildsex.packet.*;
import java.util.*;
import com.gmail.tirexgta.tguildsex.mysql.*;
import org.bukkit.block.*;
import org.bukkit.scoreboard.*;

public class GuildCommand implements CommandExecutor
{
    Main plugin;
    WrapperPlayServerScoreboardTeam team;
    private HashMap<String, List<Player>> invites;
    
    public GuildCommand(final Main plugin) {
        super();
        this.invites = new HashMap<String, List<Player>>();
        this.plugin = plugin;
        this.plugin.getCommand("guild").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
            return true;
        }
        if (args.length < 1) {
            for (final String s : this.plugin.messageManager.allowCommands) {
                sender.sendMessage(this.plugin.fixMsg(s));
            }
            return true;
        }
        if (args[0].equalsIgnoreCase(this.plugin.messageManager.createCommand)) {
            if (args.length != 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            String tag = args[1];
            String nazwa = args[2];
            tag = tag.replaceAll("[^a-zA-Z0-9]+", "");
            nazwa = nazwa.replaceAll("[^a-zA-Z0-9]+", "");
            tag = Normalizer.normalize(tag, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            nazwa = Normalizer.normalize(nazwa, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            if (!p.getWorld().getName().equals(this.plugin.configManager.guildCreateWorld)) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createWorld));
                return true;
            }
            if (tag.length() < 2) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createTagShort));
                return true;
            }
            if (tag.length() > 5) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createTagLong));
                return true;
            }
            if (nazwa.length() < 6) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createNameShort));
                return true;
            }
            if (nazwa.length() > 32) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createNameLong));
                return true;
            }
            final DataGuildUser user = Datasource.getUserByNick(p.getName());
            if (user.getRanga() != 0) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createIsGuild));
                return true;
            }
            if (this.plugin.closeSpawn(p)) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createCloseSpawn));
                return true;
            }
            if (this.plugin.closeGuild(p)) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createCloseGuild));
                return true;
            }
            if (this.plugin.data.getGuildByTag(tag) != null) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createIsTag));
                return true;
            }
            if (this.plugin.data.getGuildByNamee(nazwa) != null) {
                p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createIsName));
                return true;
            }
            final List<ItemStack> items = this.plugin.configManager.guildCreateItems;
            for (final ItemStack item : items) {
                if (!p.getInventory().containsAtLeast(item, item.getAmount())) {
                    p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.createNoItems));
                    return true;
                }
            }
            DataGuildUser userData = Datasource.getUserByNick(p.getName());
            if (userData == null) {
                userData = this.plugin.data.createUser();
            }
            userData.setTag(tag);
            userData.setNazwa(nazwa);
            userData.setRanga(3);
            userData.update();
            final DataGuild gildia = this.plugin.data.createGuild();
            gildia.setTag(tag);
            gildia.setName(nazwa);
            gildia.setWorld(p.getWorld().getName());
            gildia.setX(p.getLocation().getBlockX());
            gildia.setY(p.getLocation().getBlockY());
            gildia.setZ(p.getLocation().getBlockZ());
            gildia.setHomeX(p.getLocation().getBlockX());
            gildia.setHomeY(p.getLocation().getBlockY());
            gildia.setHomeZ(p.getLocation().getBlockZ());
            gildia.setPromien(this.plugin.configManager.guildCreatePromien);
            gildia.setLider(p.getName());
            gildia.setZalozono(System.currentTimeMillis());
            gildia.setFriendlyFire(0);
            gildia.setMaxCzlonkow(this.plugin.configManager.guildMaxPlayersMin);
            final List<String> czlonkowie = new ArrayList<String>();
            czlonkowie.add(p.getName());
            gildia.setCzlonkowie(czlonkowie);
            final DataGuildUser ranking = this.plugin.data.getUserByPlayer(p);
            gildia.setPunkty(ranking.getPoints());
            gildia.setZabicia(ranking.getKills());
            gildia.setZgony(ranking.getDeaths());
            gildia.insert();
            this.plugin.data.saveAll();
            for (final ItemStack item2 : this.plugin.configManager.guildCreateItems) {
                p.getInventory().removeItem(new ItemStack[] { item2 });
            }
            this.plugin.data.loadPosition();
            final Block block = p.getLocation().getBlock();
            block.setType(Material.BEDROCK);
            Bukkit.broadcastMessage(this.plugin.fixMsg(this.plugin.messageManager.createCreate).replace("%tag%", tag).replace("%name%", nazwa).replace("%player%", p.getName()));
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
                final Player online = onlinePlayers[j];
                UserJoinLeaveListener.refresh(online);
            }
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.removeCommand)) {
            if (args.length != 2) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.removeCorrectUsage));
                return true;
            }
            if (!args[1].equalsIgnoreCase("potwierdz")) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.removeCorrectUsage));
                return true;
            }
            final DataGuildUser user2 = Datasource.getUserByNick(sender.getName());
            if (user2.getRanga() != 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.removeNoLider));
                return true;
            }
            final DataGuild gildia2 = this.plugin.data.getGuildByTag(user2.getTag());
            final String tag2 = user2.getTag();
            final String nazwa2 = user2.getNazwa();
            if (gildia2.getCzlonkowie().size() > 0) {
                for (final String czlonek : gildia2.getCzlonkowie()) {
                    final DataGuildUser czlonekUser = Datasource.getUserByNick(czlonek);
                    czlonekUser.setTag("");
                    czlonekUser.setNazwa("");
                    czlonekUser.setRanga(0);
                    czlonekUser.update();
                }
            }
            if (gildia2.getSojusze().size() > 0) {
                for (final String sojusz : gildia2.getSojusze()) {
                    final DataGuild sojuszData = this.plugin.data.getGuildByTag(sojusz);
                    if (sojuszData != null) {
                        sojuszData.removeSojusze(gildia2.getName());
                        sojuszData.update();
                    }
                }
            }
            final Location loc = new Location(Bukkit.getWorld(gildia2.getWorld()), (double)gildia2.getX(), (double)gildia2.getY(), (double)gildia2.getZ());
            final Block block2 = loc.getBlock();
            block2.setType(Material.AIR);
            gildia2.delete();
            Bukkit.broadcastMessage(this.plugin.fixMsg(this.plugin.messageManager.removeRemove).replace("%tag%", tag2).replace("%name%", nazwa2).replace("%player%", sender.getName()));
            Player[] onlinePlayers2;
            for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, k = 0; k < length2; ++k) {
                final Player online2 = onlinePlayers2[k];
                UserJoinLeaveListener.refresh(online2);
            }
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.inviteCommand)) {
            if (args.length != 2) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.inviteCorrectUsage));
                return true;
            }
            final Player other = Bukkit.getPlayerExact(args[1]);
            if (other == null) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.inviteIsOffline));
                return true;
            }
            final DataGuildUser user3 = Datasource.getUserByNick(sender.getName());
            final DataGuildUser userOther = this.plugin.data.getUserByPlayer(other);
            if (user3.getRanga() < 2) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.inviteNoMistrz));
                return true;
            }
            if (userOther.getRanga() != 0) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.inviteIsGuild));
                return true;
            }
            final String tag3 = user3.getTag();
            final String nazwa3 = user3.getNazwa();
            final DataGuild gildia3 = this.plugin.data.getGuildByTag(tag3);
            if (gildia3.getCzlonkowie().size() >= gildia3.getMaxCzlonkow()) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.inviteIsMax));
                return true;
            }
            if (!this.getInvites().containsKey(tag3.toLowerCase())) {
                this.getInvites().put(tag3.toLowerCase(), new ArrayList<Player>());
            }
            if (!this.getInvites().get(tag3.toLowerCase()).contains(other)) {
                final List<Player> players = this.getInvites().get(tag3.toLowerCase());
                players.add(other);
                this.getInvites().remove(tag3.toLowerCase());
                this.getInvites().put(tag3.toLowerCase(), players);
                final int koszt = this.plugin.configManager.guildCostJoinDiamond * gildia3.getCzlonkowie().size();
                for (final String s2 : this.plugin.messageManager.inviteSendMsg) {
                    sender.sendMessage(this.plugin.fixMsg(s2).replace("%player%", other.getName()));
                }
                for (final String s2 : this.plugin.messageManager.inviteGetMsg) {
                    other.sendMessage(this.plugin.fixMsg(s2).replace("%tag%", tag3).replace("%name%", nazwa3).replace("%cost%", Integer.toString(koszt)));
                }
            }
            else {
                final List<Player> players = this.getInvites().get(tag3.toLowerCase());
                players.remove(other);
                this.getInvites().remove(tag3.toLowerCase());
                this.getInvites().put(tag3.toLowerCase(), players);
                for (final String s3 : this.plugin.messageManager.inviteSendMsgCancel) {
                    sender.sendMessage(this.plugin.fixMsg(s3).replace("%player%", other.getName()));
                }
                for (final String s3 : this.plugin.messageManager.inviteGetMsgCancel) {
                    other.sendMessage(this.plugin.fixMsg(s3).replace("%tag%", tag3).replace("%name%", nazwa3));
                }
            }
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.joinCommand)) {
            if (args.length != 2) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.joinCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
            final String tag2 = args[1];
            final DataGuild gildia4 = this.plugin.data.getGuildByTag(tag2);
            if (user3.getRanga() != 0) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.joinIsGuild));
                return true;
            }
            if (gildia4 == null) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.joinIsNoGuild));
                return true;
            }
            if (!this.getInvites().containsKey(tag2.toLowerCase())) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.joinIsNoInvite));
                return true;
            }
            if (!this.getInvites().get(tag2.toLowerCase()).contains(p)) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.joinIsNoInvite));
                return true;
            }
            final int koszt2 = this.plugin.configManager.guildCostJoinDiamond * gildia4.getCzlonkowie().size();
            if (!p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), koszt2)) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.joinIsNoItems).replace("%cost%", Integer.toString(koszt2)));
                return true;
            }
            final DataGuildUser ranking2 = this.plugin.data.getUserByPlayer(p);
            final List<Player> players = this.getInvites().get(tag2.toLowerCase());
            players.remove(p);
            this.getInvites().remove(tag2.toLowerCase());
            this.getInvites().put(tag2.toLowerCase(), players);
            user3.setTag(gildia4.getTag());
            user3.setNazwa(gildia4.getName());
            user3.setRanga(1);
            user3.update();
            final List<String> czlonkowie = gildia4.getCzlonkowie();
            czlonkowie.add(p.getName());
            gildia4.setCzlonkowie(czlonkowie);
            gildia4.setPunkty(ranking2.getPoints() + gildia4.getPunkty());
            gildia4.setZabicia(ranking2.getKills() + gildia4.getZabicia());
            gildia4.setZgony(ranking2.getDeaths() + gildia4.getZgony());
            gildia4.addCzlonkowie(p.getName());
            gildia4.update();
            p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.DIAMOND, koszt2) });
            Bukkit.broadcastMessage(this.plugin.fixMsg(this.plugin.messageManager.joinJoin).replace("%tag%", gildia4.getTag()).replace("%name%", gildia4.getName()).replace("%player%", p.getName()));
            Player[] onlinePlayers3;
            for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, l = 0; l < length3; ++l) {
                final Player online3 = onlinePlayers3[l];
                UserJoinLeaveListener.refresh(online3);
            }
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.leaveCommand)) {
            if (args.length != 1) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.leaveCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
            if (user3.getRanga() == 0) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.leaveIsNoGuild));
                return true;
            }
            if (user3.getRanga() == 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.leaveIsLider));
                return true;
            }
            final DataGuild gildia5 = this.plugin.data.getGuildByTag(user3.getTag());
            final DataGuildUser ranking3 = this.plugin.data.getUserByPlayer(p);
            gildia5.setPunkty(gildia5.getPunkty() - ranking3.getPoints());
            gildia5.setZabicia(gildia5.getZabicia() - ranking3.getKills());
            gildia5.setZgony(gildia5.getZgony() - ranking3.getDeaths());
            gildia5.removeCzlonkowie(p.getName());
            gildia5.removeMistrzowie(p.getName());
            gildia5.update();
            user3.setTag("");
            user3.setNazwa("");
            user3.setRanga(0);
            user3.update();
            Bukkit.broadcastMessage(this.plugin.fixMsg(this.plugin.messageManager.leaveLeave).replace("%player%", p.getName()).replace("%tag%", gildia5.getTag()).replace("%name%", gildia5.getName()));
            Player[] onlinePlayers4;
            for (int length4 = (onlinePlayers4 = Bukkit.getOnlinePlayers()).length, n = 0; n < length4; ++n) {
                final Player online4 = onlinePlayers4[n];
                UserJoinLeaveListener.refresh(online4);
            }
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.kickCommand)) {
            if (args.length != 2) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.kickCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
            final Player other2 = Bukkit.getPlayerExact(args[1]);
            if (other2 == null) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.kickIsOffline));
            }
            final DataGuildUser userOther2 = this.plugin.data.getUserByPlayer(other2);
            if (user3.equals(userOther2)) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.kickIsOther));
                return true;
            }
            if (!user3.getTag().toLowerCase().equals(userOther2.getTag().toLowerCase())) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.kickIsNoGuild));
                return true;
            }
            if (user3.getRanga() < 2) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.kickIsNoMistrz));
                return true;
            }
            if (userOther2.getRanga() > 1) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.kickIsMistrz));
                return true;
            }
            final DataGuild gildia6 = this.plugin.data.getGuildByTag(userOther2.getTag());
            final DataGuildUser ranking2 = this.plugin.data.getUserByPlayer(p);
            gildia6.setPunkty(gildia6.getPunkty() - ranking2.getPoints());
            gildia6.setZabicia(gildia6.getZabicia() - ranking2.getKills());
            gildia6.setZgony(gildia6.getZgony() - ranking2.getDeaths());
            gildia6.removeCzlonkowie(other2.getName());
            gildia6.removeMistrzowie(other2.getName());
            gildia6.update();
            userOther2.setTag("");
            userOther2.setNazwa("");
            userOther2.setRanga(0);
            userOther2.update();
            Bukkit.broadcastMessage(this.plugin.fixMsg(this.plugin.messageManager.kickKick).replace("%player%", other2.getName()).replace("%tag%", gildia6.getTag()).replace("%name%", gildia6.getName()).replace("%kicker%", p.getName()));
            Bukkit.broadcastMessage("§aGracz §e" + other2.getName() + " §azostal wyrzucony z gildii §e[" + gildia6.getTag() + "] " + gildia6.getName() + " §aprzez §e" + p.getName() + " §a!");
            Player[] onlinePlayers5;
            for (int length5 = (onlinePlayers5 = Bukkit.getOnlinePlayers()).length, n2 = 0; n2 < length5; ++n2) {
                final Player online2 = onlinePlayers5[n2];
                UserJoinLeaveListener.refresh(online2);
            }
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.liderCommand)) {
            if (args.length != 2) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.liderCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
            final Player other2 = Bukkit.getPlayerExact(args[1]);
            if (other2 == null) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.liderIsOffline));
                return true;
            }
            final DataGuildUser userOther2 = this.plugin.data.getUserByPlayer(other2);
            if (user3.getRanga() != 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.liderIsNoLider));
                return true;
            }
            if (!user3.getTag().toLowerCase().equals(userOther2.getTag().toLowerCase())) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.liderIsNoGuild));
                return true;
            }
            if (userOther2.getRanga() == 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.liderIsOther));
                return true;
            }
            for (final ItemStack i : this.plugin.configManager.guildSetLider) {
                if (p.getInventory().containsAtLeast(i, i.getAmount())) {
                    sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.liderIsNoItems));
                    return true;
                }
            }
            final DataGuild gildia6 = this.plugin.data.getGuildByTag(userOther2.getTag());
            user3.setRanga(1);
            userOther2.setRanga(3);
            gildia6.setLider(other2.getName());
            user3.update();
            userOther2.update();
            gildia6.update();
            Bukkit.broadcastMessage(this.plugin.fixMsg(this.plugin.messageManager.liderLider).replace("%newlider%", other2.getName()).replace("%lider%", p.getName()).replace("%tag%", gildia6.getTag()).replace("%name%", gildia6.getName()));
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.mistrzCommand)) {
            if (args.length != 2) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.mistrzCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
            final Player other2 = Bukkit.getPlayerExact(args[1]);
            if (other2 == null) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.mistrzIsOffline));
                return true;
            }
            final DataGuildUser userOther2 = this.plugin.data.getUserByPlayer(other2);
            if (user3.getRanga() != 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.mistrzIsNoLider));
                return true;
            }
            if (!user3.getTag().toLowerCase().equals(userOther2.getTag().toLowerCase())) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.mistrzIsNoGuild));
                return true;
            }
            if (userOther2.getRanga() == 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.mistrzIsOther));
                return true;
            }
            final DataGuild gildia6 = this.plugin.data.getGuildByTag(user3.getTag());
            if (userOther2.getRanga() == 2) {
                userOther2.setRanga(1);
                final List<String> mistrzowie = gildia6.getMistrzowie();
                if (mistrzowie.contains(other2.getName())) {
                    mistrzowie.remove(other2.getName());
                }
                gildia6.setMistrzowie(mistrzowie);
                Bukkit.broadcastMessage(this.plugin.fixMsg(this.plugin.messageManager.mistrzMistrzUnset).replace("%player%", other2.getName()).replace("%tag%", gildia6.getTag()).replace("%name%", gildia6.getName()));
            }
            else if (userOther2.getRanga() == 1) {
                userOther2.setRanga(2);
                final List<String> mistrzowie = gildia6.getMistrzowie();
                mistrzowie.add(other2.getName());
                gildia6.setMistrzowie(mistrzowie);
                Bukkit.broadcastMessage(this.plugin.fixMsg(this.plugin.messageManager.mistrzMistrzSet).replace("%player%", other2.getName()).replace("%tag%", gildia6.getTag()).replace("%name%", gildia6.getName()));
            }
            userOther2.update();
            gildia6.update();
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.pvpCommand)) {
            if (args.length != 1) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.pvpCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
            if (user3.getRanga() != 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.pvpIsNoLider));
                return true;
            }
            final DataGuild gildia5 = this.plugin.data.getGuildByTag(user3.getTag());
            if (gildia5.getFriendlyFire() == 0) {
                gildia5.setFriendlyFire(1);
                for (final String czlonkowie2 : gildia5.getCzlonkowie()) {
                    final Player online5 = Bukkit.getPlayerExact(czlonkowie2);
                    if (online5 != null) {
                        for (final String s4 : this.plugin.messageManager.pvpPvpOn) {
                            online5.sendMessage(this.plugin.fixMsg(s4));
                        }
                    }
                }
            }
            else {
                gildia5.setFriendlyFire(0);
                for (final String czlonkowie2 : gildia5.getCzlonkowie()) {
                    final Player online5 = Bukkit.getPlayerExact(czlonkowie2);
                    if (online5 != null) {
                        for (final String s4 : this.plugin.messageManager.pvpPvpOff) {
                            online5.sendMessage(this.plugin.fixMsg(s4));
                        }
                    }
                }
            }
            gildia5.update();
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.homeCommand)) {
            if (args.length != 1) {
                sender.sendMessage("§cPoprawne uzycie: §6/gildia dom");
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
            if (user3.ranga == 0) {
                sender.sendMessage("§4Blad: §cNie posiadasz Gildii!");
                return true;
            }
            final DataGuild locGuild = this.plugin.getGildiaByLocation(p.getLocation());
            if (locGuild != null && !locGuild.getTag().toLowerCase().equals(user3.getTag().toLowerCase())) {
                sender.sendMessage("§4Blad: §cNie mozesz teleportowac sie na terenie innej Gildii!");
                return true;
            }
            final DataGuild gildia4 = this.plugin.data.getGuildByTag(user3.getTag());
            p.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.homeHomeBefore).replace("%time%", Integer.toString(this.plugin.configManager.guildTeleportDelay)));
            final Location guildHomeLocation = new Location(Bukkit.getWorld(gildia4.getWorld()), gildia4.getHomeX() + 0.5, (double)gildia4.getHomeY(), gildia4.getHomeZ() + 0.5);
            this.plugin.teleportPlayerWithDelay(p, this.plugin.configManager.guildTeleportDelay, guildHomeLocation, this.plugin.fixMsg(this.plugin.messageManager.homeHomeAfter), null);
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.sethomeCommand)) {
            if (args.length != 1) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.sethomeCorrectUsage));
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
            if (user3.getRanga() != 3) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.sethomeIsNoLider));
                return true;
            }
            final Location loc2 = p.getLocation();
            final DataGuild locGildia = this.plugin.getGildiaByLocation(loc2);
            if (locGildia == null) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.sethomeIsNoGuild));
                return true;
            }
            if (!locGildia.getTag().toLowerCase().equals(user3.getTag().toLowerCase())) {
                sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.sethomeIsNoGuild));
                return true;
            }
            final DataGuild gildia6 = this.plugin.data.getGuildByTag(user3.getTag());
            gildia6.setHomeX(loc2.getBlockX());
            gildia6.setHomeY(loc2.getBlockY());
            gildia6.setHomeZ(loc2.getBlockZ());
            gildia6.update();
            for (final String czlonek2 : gildia6.getCzlonkowie()) {
                final Player online6 = Bukkit.getPlayerExact(czlonek2);
                if (online6 != null) {
                    for (final String s2 : this.plugin.messageManager.sethomeSethome) {
                        online6.sendMessage(this.plugin.fixMsg(s2).replace("%x%", Integer.toString(loc2.getBlockX())).replace("%y%", Integer.toString(loc2.getBlockY())).replace("%z%", Integer.toString(loc2.getBlockZ())));
                    }
                }
            }
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.infoCommand)) {
            final Player p = (Player)sender;
            if (args.length == 1) {
                final DataGuildUser user3 = this.plugin.data.getUserByPlayer(p);
                if (this.plugin.infoManager.getPlayerGuild(user3)) {
                    sender.sendMessage(this.plugin.fixMsg(this.plugin.messageManager.infoCorrectUsage));
                    return true;
                }
                final DataGuild gildia5 = this.plugin.data.getGuildByTag(user3.getTag());
                this.plugin.infoManager.info(gildia5, p, gildia5.getTag());
            }
            else if (args.length == 2) {
                final String tag = args[1];
                final DataGuild gildia5 = this.plugin.data.getGuildByTag(tag);
                this.plugin.infoManager.info(gildia5, p, tag);
            }
        }
        else if (args[0].equalsIgnoreCase(this.plugin.messageManager.ownerCommand)) {
            for (final String s : this.plugin.messageManager.allowCommandsLider) {
                sender.sendMessage(this.plugin.fixMsg(s));
            }
        }
        else if (args[0].equalsIgnoreCase("tab")) {
            final WrapperPlayServerPlayerInfo tab = new WrapperPlayServerPlayerInfo();
            final Player p2 = (Player)sender;
            final Scoreboard sb = p2.getScoreboard();
            final Team team = sb.registerNewTeam("jajco");
            team.setSuffix("jajeczko");
            team.addPlayer(Bukkit.getOfflinePlayer("jajco"));
            tab.setPing((short)5);
            tab.setPlayerName("jajco");
            tab.setOnline(true);
            tab.sendPacket(p2);
        }
        else {
            for (final String s : this.plugin.messageManager.allowCommands) {
                sender.sendMessage(this.plugin.fixMsg(s));
            }
        }
        return false;
    }
    
    public HashMap<String, List<Player>> getInvites() {
        return this.invites;
    }
    
    public void setInvites(final HashMap<String, List<Player>> invites) {
        this.invites = invites;
    }
}
