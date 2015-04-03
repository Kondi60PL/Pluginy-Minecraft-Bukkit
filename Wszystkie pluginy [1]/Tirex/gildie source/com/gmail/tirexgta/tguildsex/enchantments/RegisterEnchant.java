package com.gmail.tirexgta.tguildsex.enchantments;

import org.bukkit.enchantments.*;
import java.util.*;
import java.lang.reflect.*;

public class RegisterEnchant
{
    private Enchantment ench;
    private String name;
    private int id;
    
    public RegisterEnchant(final Enchantment arg0, final String arg1, final int arg2) {
        super();
        this.ench = arg0;
        this.name = arg1;
        this.id = arg2;
    }
    
    public final void register() {
        try {
            final Field byIdField = Enchantment.class.getDeclaredField("byId");
            final Field byNameField = Enchantment.class.getDeclaredField("byName");
            byIdField.setAccessible(true);
            byNameField.setAccessible(true);
            final HashMap<Integer, Enchantment> byId = (HashMap<Integer, Enchantment>)byIdField.get(null);
            final HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>)byNameField.get(null);
            if (byId.containsKey(this.id)) {
                byId.remove(this.id);
            }
            if (byName.containsKey(this.name)) {
                byName.remove(this.name);
            }
        }
        catch (Exception ignored) {
            ignored.printStackTrace();
        }
        try {
            try {
                final Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Enchantment.registerEnchantment(this.ench);
            }
            catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
