package com.gmail.tirexgta.tpigex.listeners;

import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.material.*;
import com.gmail.tirexgta.tpigex.*;
import org.bukkit.block.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class SpawnPigListener implements Listener
{
    Main plugin;
    
    public SpawnPigListener() {
        super();
        this.plugin = Main.getInstance();
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        if (!e.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK)) {
            return;
        }
        final Block block = e.getClickedBlock();
        if (!block.getType().equals((Object)Material.STONE_BUTTON) && !block.getType().equals((Object)Material.WOOD_BUTTON)) {
            return;
        }
        final Location locButton = block.getLocation();
        if (!Main.getInstance().configManager.pigByLocation.containsKey(locButton)) {
            return;
        }
        final Button button = (Button)block.getState().getData();
        if (button.isPowered()) {
            return;
        }
        for (final PigManager pm : Main.getInstance().configManager.pigByLocation.get(locButton)) {
            this.spawn(e.getPlayer(), pm, locButton);
        }
    }
    
    void spawn(final Player p, final PigManager pm, final Location locButton) {
        if (pm == null) {
            return;
        }
        if (pm.name == null) {
            System.out.println("=====ERROR=====");
            System.out.println("W spawnie swin (null) nie ma ustawionej nazwy!");
            System.out.println("=====ERROR=====");
            return;
        }
        if (pm.locButton == null) {
            System.out.println("=====ERROR=====");
            System.out.println("W spawnie swin (" + pm.name + ") nie jest ustawiona lokalizacja przycisku!");
            System.out.println("=====ERROR=====");
            return;
        }
        if (!pm.locButton.equals((Object)locButton)) {
            return;
        }
        if (pm.loc == null) {
            System.out.println("=====ERROR=====");
            System.out.println("W spawnie swin (" + pm.name + ") nie jest ustawiona lokalizacja spawnu!");
            System.out.println("=====ERROR=====");
            return;
        }
        if (pm.type == null) {
            System.out.println("=====ERROR=====");
            System.out.println("W spawnie swin (" + pm.name + ") nie jest ustawiony typ potwora!");
            System.out.println("=====ERROR=====");
            return;
        }
        final Location loc = pm.loc;
        final World world = loc.getWorld();
        for (int i = pm.size; i != 0; --i) {
            final Entity tnt = world.spawnEntity(loc, pm.type);
            tnt.setFireTicks(400);
            tnt.setVelocity(tnt.getVelocity().multiply(2));
        }
    }
}
