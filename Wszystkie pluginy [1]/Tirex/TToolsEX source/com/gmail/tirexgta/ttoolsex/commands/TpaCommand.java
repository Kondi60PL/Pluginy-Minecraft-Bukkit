package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class TpaCommand implements CommandExecutor
{
    Main plugin;
    HashMap<Player, Player> tpaPlayer;
    HashMap<Player, Long> tpaTime;
    
    public TpaCommand(final Main plugin) {
        super();
        this.tpaPlayer = new HashMap<Player, Player>();
        this.tpaTime = new HashMap<Player, Long>();
        this.plugin = plugin;
        this.plugin.getCommand("tpa").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cTa komenda nie moze byc wywolana z konsoli!");
            return true;
        }
        if (args.length == 1) {
            final Player p = (Player)sender;
            final Player other = Bukkit.getPlayerExact(args[0]);
            if (other == null) {
                sender.sendMessage("§cTen gracz nie jest Online!");
                return true;
            }
            if (other.equals(p)) {
                sender.sendMessage("§cNie mozesz samemu sobie wyslac zaproszenia!");
                return true;
            }
            if (this.tpaPlayer.containsKey(other) && this.tpaTime.containsKey(this.tpaPlayer.get(other)) && System.currentTimeMillis() < this.tpaTime.get(this.tpaTime.containsKey(this.tpaPlayer.get(other)))) {
                sender.sendMessage("§cTen gracz ma juz oczekujace zaproszenie!");
                return true;
            }
            if (this.tpaPlayer.containsKey(other)) {
                this.tpaPlayer.remove(other);
            }
            if (this.tpaTime.containsKey(p)) {
                this.tpaTime.remove(p);
            }
            this.tpaPlayer.put(other, p);
            this.tpaTime.put(p, System.currentTimeMillis() + 60000L);
            sender.sendMessage("§6Wyslano prosbe teleportacji do gracza §c" + other.getName());
            other.sendMessage("§cOrzymales prosbe teleportacji od gracza §7" + p.getName() + "\n§cMasz §760 §csekund, zeby zaakceptowac zaproszenie: §7/tpaccept \n§club odrzucic zaproszenie: §7/tpdeny");
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/tpa <gracz>");
        }
        return false;
    }
}
