package com.gmail.tirexgta.tpigex.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.gmail.tirexgta.tpigex.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.block.*;

public class PigCommand extends Command
{
    Command cmd;
    
    public PigCommand(final String name, final String description, final String usageMessage, final List<String> aliases) {
        super(name, description, usageMessage, (List)aliases);
        (this.cmd = Main.getInstance().registerCommand(this)).setPermission("tirex.pig");
        this.cmd.setPermissionMessage("Jajeczko");
    }
    
    public boolean execute(final CommandSender sender, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("KONSOLKA ! STOP !");
            return true;
        }
        if (!sender.hasPermission("tirex.pig") && !sender.hasPermission("*")) {
            sender.sendMessage(this.cmd.getPermissionMessage());
            return true;
        }
        if (args.length == 0) {
            return true;
        }
        final Player p = (Player)sender;
        if (args[0].equalsIgnoreCase("add")) {
            if (args.length <= 3) {
                sender.sendMessage("/pig add <name> <type> [size]");
                return true;
            }
            final String name = args[1];
            final EntityType type = EntityType.fromName(args[2]);
            int ilosc = 1;
            if (args.length >= 4 && Main.getInstance().isInt(args[3])) {
                ilosc = Integer.parseInt(args[3]);
            }
            if (type == null) {
                sender.sendMessage("nie ma takiego potwora");
                return true;
            }
            final PigManager pm$1 = Main.getInstance().configManager.pigByName.get(name.toLowerCase());
            final PigManager pm$2 = new PigManager(p.getLocation(), (pm$1 != null) ? ((pm$1.locButton != null) ? pm$1.locButton : null) : null, name, type, ilosc);
            if (pm$1 != null) {
                pm$1.remove();
            }
            pm$2.insert();
            sender.sendMessage("Ustawiles spawn " + type.getName() + " na " + name);
        }
        else if (args[0].equalsIgnoreCase("set")) {
            if (args.length != 2) {
                sender.sendMessage("/pig set <name>");
                return true;
            }
            final String name = args[1];
            final PigManager pm = Main.getInstance().configManager.pigByName.get(name.toLowerCase());
            if (pm == null) {
                sender.sendMessage("musisz najpierw stworzyc");
                return true;
            }
            final Block block = p.getTargetBlock((HashSet)null, 3);
            if (!block.getType().equals((Object)Material.STONE_BUTTON) && !block.getType().equals((Object)Material.WOOD_BUTTON)) {
                sender.sendMessage("blok na ktory sie patrzysz musi byc przyciskiem!");
                return true;
            }
            pm.locButton = block.getLocation();
            pm.remove();
            pm.insert();
            sender.sendMessage("ustawiles przycisk spawnu dla " + name);
        }
        else if (args[0].equalsIgnoreCase("remove")) {
            if (args.length != 2) {
                sender.sendMessage("/pig remove <name>");
                return true;
            }
            final String name = args[1];
            final PigManager pm = Main.getInstance().configManager.pigByName.get(name.toLowerCase());
            if (pm == null) {
                sender.sendMessage("musisz najpierw stworzyc");
                return true;
            }
            pm.remove();
            sender.sendMessage("Usunales " + name);
        }
        return false;
    }
}
