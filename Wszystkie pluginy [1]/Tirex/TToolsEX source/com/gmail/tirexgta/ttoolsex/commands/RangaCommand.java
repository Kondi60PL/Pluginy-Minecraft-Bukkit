package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import com.gmail.tirexgta.ttoolsex.others.*;
import org.bukkit.command.*;
import net.milkbowl.vault.permission.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class RangaCommand implements CommandExecutor
{
    Main plugin;
    Config config;
    
    public RangaCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("ranga").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length != 3) {
            sender.sendMessage("§cPoprawne uzycie: §6/ranga <gracz> <czas> <ranga>");
            return true;
        }
        final String name = args[0];
        final String nameLow = name.toLowerCase();
        final String ranga = args[2];
        final Permission chat = Main.chat;
        String groups = null;
        String[] groups2;
        for (int length = (groups2 = chat.getGroups()).length, i = 0; i < length; ++i) {
            final String group = groups2[i];
            if (group.equals(ranga)) {
                groups = group;
            }
        }
        if (groups == null) {
            sender.sendMessage("§4Nie ma takiej rangi!");
            return true;
        }
        final Player p = Bukkit.getPlayerExact(nameLow);
        if (p == null) {
            sender.sendMessage("§4Tego gracza nie ma online!");
            return true;
        }
        final OfflinePlayer offlineP = this.plugin.getServer().getOfflinePlayer(p.getName());
        String groupsPlayer = "";
        String[] playerGroups;
        for (int length2 = (playerGroups = chat.getPlayerGroups(p)).length, j = 0; j < length2; ++j) {
            final String groupPlayer = playerGroups[j];
            if (groupPlayer.toLowerCase().equals(this.plugin.rangManager.getRangaNazwa(offlineP).toLowerCase())) {
                groupsPlayer = groupPlayer;
            }
        }
        if (!groupsPlayer.equals("")) {
            chat.playerRemoveGroup(p, groupsPlayer);
        }
        chat.playerAddGroup(p, groups);
        final long time = Main.stringToTime(args[1]) + System.currentTimeMillis();
        this.plugin.rangManager.addRang(p, ranga, time);
        p.sendMessage("§aOtrzymales range " + ranga + ".\nNie masz uprawnien? Relognij!");
        sender.sendMessage("§aPomyslnie dodano range Graczowi!");
        return false;
    }
}
