package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class InvincibleCommand implements CommandExecutor
{
    Main plugin;
    
    public InvincibleCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("invincible").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            this.plugin.invincibleManager.setInCommand(player, true);
            player.sendMessage("§9Kliknij w moba/zwierze, ktore ma byc nieznisczalne");
        }
        return true;
    }
}
