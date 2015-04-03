package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class WeatherCommand implements CommandExecutor
{
    Main plugin;
    String[] sun;
    String[] rain;
    String[] thunder;
    
    public WeatherCommand(final Main plugin) {
        super();
        this.sun = new String[] { "sky", "sun", "clear", "slonce", "1" };
        this.rain = new String[] { "rain", "storm", "deszcz", "2" };
        this.thunder = new String[] { "thunder", "thundering", "lightning", "burza", "3" };
        this.plugin = plugin;
        this.plugin.getCommand("weather").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1 || args.length == 2) {
                final Player p = (Player)sender;
                final String weather = args[0];
                final World world = p.getWorld();
                if (this.plugin.containsIgnoreCase(this.sun, weather)) {
                    world.setStorm(false);
                    world.setThundering(false);
                    sender.sendMessage("§6Ustawiles sloneczna pogode w §c" + world.getName());
                }
                else if (this.plugin.containsIgnoreCase(this.rain, weather)) {
                    world.setThundering(false);
                    world.setStorm(true);
                    sender.sendMessage("§6Ustawiles deszczowa pogode w §c" + world.getName());
                }
                else if (this.plugin.containsIgnoreCase(this.thunder, weather)) {
                    int time = 300;
                    if (args.length == 2 && Main.isInteger(args[1])) {
                        time = Integer.parseInt(args[1]);
                    }
                    world.setThunderDuration(time);
                    sender.sendMessage("§6Ustawiles burzliwa pogode w §c" + world.getName());
                }
                else {
                    sender.sendMessage("§cPoprawne uzycie: §6/weather <pogoda> [czas burzy]");
                }
            }
            else {
                sender.sendMessage("§cPoprawne uzycie: §6/weather <pogoda> [czas burzy]");
            }
        }
        else if (args.length == 2 || args.length == 3) {
            final String weather2 = args[1];
            final World world2 = Bukkit.getWorld(args[0]);
            if (world2 == null) {
                sender.sendMessage("§cNie ma takiego swiata!");
                return true;
            }
            if (this.plugin.containsIgnoreCase(this.sun, weather2)) {
                world2.setStorm(false);
                world2.setThundering(false);
                sender.sendMessage("§6Ustawiles sloneczna pogode w §c" + world2.getName());
            }
            else if (this.plugin.containsIgnoreCase(this.rain, weather2)) {
                world2.setThundering(false);
                world2.setStorm(true);
                sender.sendMessage("§6Ustawiles deszczowa pogode w §c" + world2.getName());
            }
            else if (this.plugin.containsIgnoreCase(this.thunder, weather2)) {
                int time2 = 300;
                if (args.length == 3 && Main.isInteger(args[2])) {
                    time2 = Integer.parseInt(args[2]);
                }
                world2.setThunderDuration(time2);
                sender.sendMessage("§6Ustawiles burzliwa pogode w §c" + world2.getName());
            }
            else {
                sender.sendMessage("§cPoprawne uzycie: §6/weather <swiat> <pogoda> [czas burzy]");
            }
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/weather <swiat> <pogoda> [czas burzy]");
        }
        return false;
    }
}
