package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class SpeedCommand implements CommandExecutor
{
    Main plugin;
    
    public SpeedCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("speed").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cPoprawne uzycie: §6/speed <gracz> <predkosc>");
                return true;
            }
            final String speedString = args[0];
            if (!Main.isDouble(speedString)) {
                sender.sendMessage("§cPoprawne uzycie: §6/speed <gracz> <predkosc>");
                return true;
            }
            final double speedInteger = Double.parseDouble(speedString);
            final double speedIntegerFloat = speedInteger / 10.0;
            if (speedIntegerFloat > 1.0) {
                sender.sendMessage("§cMaxymalna wartosc to 10");
                return true;
            }
            final float speed = (float)speedIntegerFloat;
            final Player p = (Player)sender;
            if (p.isFlying()) {
                p.setFlySpeed(speed);
                p.sendMessage("§6Ustawiles predkosc latania na §c" + speedInteger);
            }
            else {
                p.setWalkSpeed(speed);
                p.sendMessage("§6Ustawiles predkosc chodzenia na §c" + speedInteger);
            }
        }
        else if (args.length == 2) {
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            final String speedString2 = args[1];
            if (!Main.isInteger(speedString2)) {
                sender.sendMessage("§cPoprawne uzycie: §6/speed <gracz> <predkosc>");
                return true;
            }
            final double speedInteger2 = Double.parseDouble(speedString2);
            final double speedIntegerFloat2 = speedInteger2 / 10.0;
            if (speedIntegerFloat2 > 1.0) {
                sender.sendMessage("§cMaxymalna wartosc to 10");
                return true;
            }
            final float speed2 = (float)speedIntegerFloat2;
            if (other.isFlying()) {
                other.setFlySpeed(speed2);
                other.sendMessage("§6Twoja predkosc latania zostala zmieniona na §c" + speedInteger2 + " §6przez §c" + sender.getName());
                sender.sendMessage("§6Ustawiles predkosc latania gracza " + other.getName() + " na §c" + speedInteger2);
            }
            else {
                other.setWalkSpeed(speed2);
                other.sendMessage("§6Twoja predkosc chodzenia zostala zmieniona na §c" + speedInteger2 + " §6przez §c" + sender.getName());
                sender.sendMessage("§6Ustawiles predkosc chodzenia gracza " + other.getName() + " na §c" + speedInteger2);
            }
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/speed <gracz> <predkosc>");
        }
        return false;
    }
}
