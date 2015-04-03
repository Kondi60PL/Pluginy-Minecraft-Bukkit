package com.gmail.tirexgta.ttoolsex.commands;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class HeadCommand implements CommandExecutor
{
    Main plugin;
    
    public HeadCommand(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getCommand("head").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
                return true;
            }
            final Player player = (Player)sender;
            final ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
            final SkullMeta meta = (SkullMeta)item.getItemMeta();
            meta.setOwner(player.getName());
            item.setItemMeta((ItemMeta)meta);
            player.getInventory().addItem(new ItemStack[] { item });
            player.sendMessage("§6Glowa gracza §c" + player.getName() + " §6zostala dodana do twojego ekwipunku!");
        }
        else if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cTej komendy nie mozna uzywac z poziomu konsoli!");
                return true;
            }
            final Player player = (Player)sender;
            final String otherName = args[0];
            final ItemStack item2 = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
            final SkullMeta meta2 = (SkullMeta)item2.getItemMeta();
            meta2.setOwner(otherName);
            item2.setItemMeta((ItemMeta)meta2);
            player.getInventory().addItem(new ItemStack[] { item2 });
            player.sendMessage("§6Glowa gracza §c" + otherName + " §6zostala dodana do twojego ekwipunku!");
        }
        else {
            sender.sendMessage("§cPoprawne uzycie: §6/head [gracz]");
        }
        return false;
    }
}
