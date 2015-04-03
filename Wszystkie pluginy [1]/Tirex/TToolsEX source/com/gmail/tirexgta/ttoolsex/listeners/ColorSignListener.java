package com.gmail.tirexgta.ttoolsex.listeners;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import org.bukkit.event.block.*;
import org.bukkit.event.*;

public class ColorSignListener implements Listener
{
    Main plugin;
    
    public ColorSignListener(final Main plugin) {
        super();
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onSignCreate(final SignChangeEvent e) {
        int i = 0;
        String[] lines;
        for (int length = (lines = e.getLines()).length, j = 0; j < length; ++j) {
            final String line = lines[j];
            final String line2 = this.plugin.fix(line);
            if (line2 != null) {
                e.setLine(i, this.plugin.fix(line));
            }
            ++i;
        }
    }
}
