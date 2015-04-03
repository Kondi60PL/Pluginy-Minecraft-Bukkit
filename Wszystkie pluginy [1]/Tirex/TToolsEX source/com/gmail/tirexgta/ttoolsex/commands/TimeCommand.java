package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TimeCommand implements CommandExecutor
{
    Main plugin;
    HashMap<String, Integer> ticksAliases;
    
    public TimeCommand(final Main plugin) {
        super();
        this.ticksAliases = new HashMap<String, Integer>();
        this.plugin = plugin;
        this.plugin.getCommand("time").setExecutor((CommandExecutor)this);
        this.ticksAliases.put("dawn", 0);
        this.ticksAliases.put("day", 6000);
        this.ticksAliases.put("dusk", 12000);
        this.ticksAliases.put("night", 18000);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/time <swiat> <pora>");
                return true;
            }
            final Player p = (Player)sender;
            if (Main.isInteger(args[0])) {
                final int czas = Integer.parseInt(args[0]);
                if (czas <= 24) {
                    p.getWorld().setTime((long)(czas * 1000));
                    sender.sendMessage("§7Ustawiles czas na swiecie §c" + p.getWorld().getName() + " §7na godzine §c" + czas);
                }
                else {
                    sender.sendMessage("§cDzien ma 24 godziny!");
                }
            }
            else {
                if (!this.ticksAliases.containsKey(args[0])) {
                    sender.sendMessage("§cNie ma takiej pory dnia!");
                    return true;
                }
                final int czas = this.ticksAliases.get(args[0]);
                p.getWorld().setTime((long)czas);
                sender.sendMessage("§7Ustawiles czas na swiecie §c" + p.getWorld().getName() + " §7na godzine §c" + czas / 1000);
            }
        }
        else if (args.length == 2) {
            final World world = Bukkit.getWorld(args[0]);
            if (world == null) {
                sender.sendMessage("§cNie ma takiego Swiata!");
                return true;
            }
            if (Main.isInteger(args[1])) {
                final int czas = Integer.parseInt(args[1]);
                if (czas <= 24) {
                    world.setTime((long)(czas * 1000));
                    sender.sendMessage("§7Ustawiles czas na swiecie §c" + world.getName() + " §7na godzine §c" + czas);
                }
                else {
                    sender.sendMessage("§cDzien ma 24 godziny!");
                }
            }
            else {
                if (!this.ticksAliases.containsKey(args[1])) {
                    sender.sendMessage("§cNie ma takiej pory dnia!");
                    return true;
                }
                final int czas = this.ticksAliases.get(args[1]);
                world.setTime((long)czas);
                sender.sendMessage("§7Ustawiles czas na swiecie §c" + world.getName() + " §7na godzine §c" + czas / 1000);
            }
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/time <swiat> <pora>");
        }
        return false;
    }
}
