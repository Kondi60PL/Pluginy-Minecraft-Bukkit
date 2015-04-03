package com.gmail.tirexgta.tpigex;

import org.bukkit.configuration.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.apache.commons.lang.*;
import java.util.*;

public class PigManager
{
    public ConfigurationSection cs;
    public Location loc;
    public Location locButton;
    public String name;
    public EntityType type;
    public int size;
    
    public PigManager(final Location loc, final Location locButton, final String name, final EntityType type, final int size) {
        super();
        this.loc = loc;
        this.locButton = locButton;
        this.name = name;
        this.type = type;
        this.size = size;
    }
    
    public PigManager(final ConfigurationSection cs) {
        super();
        this.cs = cs;
        this.name = cs.getName();
        this.type = EntityType.fromName(cs.getString("type"));
        this.locButton = this.getLocation(cs.getString("locButton"));
        this.loc = this.getLocation(cs.getString("loc"));
        this.size = cs.getInt("size");
    }
    
    Location getLocation(final String s) {
        final String[] splitS = s.split("\\:");
        final World world = Bukkit.getWorld(splitS[0]);
        final int x = Integer.parseInt(splitS[1]);
        final int y = Integer.parseInt(splitS[2]);
        final int z = Integer.parseInt(splitS[3]);
        return new Location(world, (double)x, (double)y, (double)z);
    }
    
    String setLocation(final Location loc) {
        final List<String> list = new ArrayList<String>();
        list.add(loc.getWorld().getName());
        list.add(Integer.toString(loc.getBlockX()));
        list.add(Integer.toString(loc.getBlockY()));
        list.add(Integer.toString(loc.getBlockZ()));
        return StringUtils.join((Collection)list, ":");
    }
    
    public boolean save() {
        if (this.cs == null) {
            Main.getInstance().getConfig().createSection("spawned." + this.name);
            this.cs = Main.getInstance().getConfig().getConfigurationSection("spawned." + this.name);
        }
        this.cs.set("type", (Object)this.type.getName());
        this.cs.set("loc", (Object)this.setLocation(this.loc));
        this.cs.set("locButton", (Object)this.setLocation(this.locButton));
        this.cs.set("size", (Object)this.size);
        return true;
    }
    
    public boolean insert() {
        Main.getInstance().configManager.pigs.add(this);
        Main.getInstance().configManager.pigByName.put(this.name.toLowerCase(), this);
        if (!Main.getInstance().configManager.pigByLocation.containsKey(this.locButton)) {
            final List<PigManager> list = new ArrayList<PigManager>();
            list.add(this);
            Main.getInstance().configManager.pigByLocation.put(this.locButton, list);
        }
        else {
            final List<PigManager> list = Main.getInstance().configManager.pigByLocation.get(this.locButton);
            list.add(this);
            Main.getInstance().configManager.pigByLocation.remove(this.locButton);
            Main.getInstance().configManager.pigByLocation.put(this.locButton, list);
        }
        return true;
    }
    
    public boolean remove() {
        Main.getInstance().configManager.pigs.remove(this);
        Main.getInstance().configManager.pigByName.remove(this.name.toLowerCase());
        Main.getInstance().configManager.pigByLocation.remove(this.locButton);
        if (Main.getInstance().configManager.pigByLocation.containsKey(this.loc)) {
            if (Main.getInstance().configManager.pigByLocation.get(this.locButton).size() == 1) {
                Main.getInstance().configManager.pigByLocation.remove(this.locButton);
            }
            else {
                final List<PigManager> list = Main.getInstance().configManager.pigByLocation.get(this.locButton);
                list.remove(this);
                Main.getInstance().configManager.pigByLocation.remove(this.locButton);
                Main.getInstance().configManager.pigByLocation.put(this.locButton, list);
            }
        }
        return true;
    }
}
