package com.gmail.tirexgta.tguildsex.commands;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import com.gmail.tirexgta.tguildsex.listeners.*;
import com.gmail.tirexgta.tguildsex.mysql.*;

public class SojuszCommand implements CommandExecutor
{
    Main plugin;
    Datasource guild;
    
    public SojuszCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("sojusz").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("§3/sojusz zapros - §7Komenda od zapraszania sojuszy.");
            sender.sendMessage("§3/sojusz zerwij - §7Komenda od zrywania sojuszy.");
            return true;
        }
        if (args[0].equalsIgnoreCase("zapros")) {
            if (args.length != 2) {
                sender.sendMessage("§cPoprawne uzycie: §6/sojusz zapros <tag>");
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
            if (user.getRanga() != 3) {
                sender.sendMessage("§4Blad: §cNie masz Lidera w zadnej Gildii!");
                return true;
            }
            final String tagSojusz = args[1];
            final DataGuild gildiaSojusz = this.plugin.data.getGuildByTag(tagSojusz);
            final DataGuild gildia = this.plugin.data.getGuildByTag(user.getTag());
            if (gildiaSojusz == null) {
                sender.sendMessage("§4Blad: §cNie ma takiej Gildii!");
                return true;
            }
            if (gildiaSojusz.getTag().equals(gildia.getTag())) {
                sender.sendMessage("§4Blad: §cNie mozesz dac sojuszu swojej gildii!");
                return true;
            }
            if (gildia.getSojusze().contains(gildiaSojusz.getTag())) {
                sender.sendMessage("§4Blad: §cTwoja gildia ma juz sojusz z ta gildia!");
                return true;
            }
            final Player liderSojusz = Bukkit.getPlayerExact(gildiaSojusz.getLider());
            if (liderSojusz == null) {
                sender.sendMessage("§4Blad: §cLider tej gildii nie jest online!");
                return true;
            }
            if (gildia.getSojusze().size() >= this.plugin.configManager.guildSojuszMax) {
                sender.sendMessage("§4Blad: §cTwoja gildia ma za duzo sojuszy!");
                return true;
            }
            if (gildiaSojusz.getSojusze().size() >= this.plugin.configManager.guildSojuszMax) {
                sender.sendMessage("§4Blad: §cTa gildia ma za duzo sojuszy!");
                return true;
            }
            if (gildia.getZaproszeniaSojusze().contains(gildiaSojusz.getTag().toLowerCase())) {
                gildia.removeZaproszeniaSojusze(gildiaSojusz.getTag().toLowerCase());
                gildia.addSojusze(gildiaSojusz.getTag());
                gildiaSojusz.addSojusze(gildia.getTag());
                gildia.update();
                gildiaSojusz.update();
                Bukkit.broadcastMessage("§aGildia §e[" + gildia.getTag() + "] " + gildia.getName() + " §azawarla sojusz z §e[" + gildiaSojusz.getTag() + "] " + gildiaSojusz.getName() + "§a!");
            }
            else {
                gildiaSojusz.addZaproszeniaSojusze(gildia.getTag().toLowerCase());
                liderSojusz.sendMessage("§aTwoja gildia dostala zaproszenie do sojuszu od §e[" + gildia.getTag() + "] " + gildia.getName() + "§a!");
                liderSojusz.sendMessage("§aAby przyjac sojusz wpisz §f/sojusz zapros " + gildia.getTag());
                p.sendMessage("§aWyslales Zaproszenie do sojuszu!");
            }
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                final Player online = onlinePlayers[i];
                UserJoinLeaveListener.refresh(online);
            }
        }
        else if (args[0].equalsIgnoreCase("zerwij")) {
            if (args.length != 2) {
                sender.sendMessage("§cPoprawne uzycie: §6/sojusz zerwij <tag>");
                return true;
            }
            final Player p = (Player)sender;
            final DataGuildUser user = this.plugin.data.getUserByPlayer(p);
            if (user.getRanga() != 3) {
                sender.sendMessage("§4Blad: §cNie masz Lidera w zadnej Gildii!");
                return true;
            }
            final String tagSojusz = args[1];
            final DataGuild gildiaSojusz = this.plugin.data.getGuildByTag(tagSojusz);
            final DataGuild gildia = this.plugin.data.getGuildByTag(user.getTag());
            if (gildiaSojusz == null) {
                sender.sendMessage("§4Blad: §cNie ma takiej Gildii!");
                return true;
            }
            if (!gildia.getSojusze().contains(gildiaSojusz.getTag())) {
                sender.sendMessage("§4Blad: §cTwoja gildia nie ma sojuszu z ta gildia!");
                return true;
            }
            gildia.removeSojusze(gildiaSojusz.getTag());
            gildiaSojusz.removeSojusze(gildia.getTag());
            gildia.update();
            gildiaSojusz.update();
            Bukkit.broadcastMessage("§aGildia §e[" + gildia.getTag() + "] " + gildia.getName() + " §azerwala sojusz z §e[" + gildiaSojusz.getTag() + "] " + gildiaSojusz.getName() + "§a!");
            Player[] onlinePlayers2;
            for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                final Player online2 = onlinePlayers2[j];
                UserJoinLeaveListener.refresh(online2);
            }
        }
        else {
            sender.sendMessage("§3/sojusz zapros - §7Komenda od zapraszania sojuszy.");
            sender.sendMessage("§3/sojusz zerwij - §7Komenda od zrywania sojuszy.");
        }
        return false;
    }
}
