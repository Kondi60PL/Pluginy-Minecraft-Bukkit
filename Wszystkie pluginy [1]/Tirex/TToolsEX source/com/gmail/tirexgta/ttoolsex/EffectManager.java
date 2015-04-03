package com.gmail.tirexgta.ttoolsex;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.lang.reflect.*;

public enum EffectManager
{
    HUGE_EXPLOSION("HUGE_EXPLOSION", 0, "hugeexplosion", 0), 
    LARGE_EXPLODE("LARGE_EXPLODE", 1, "largeexplode", 1), 
    FIREWORKS_SPARK("FIREWORKS_SPARK", 2, "fireworksSpark", 2), 
    BUBBLE("BUBBLE", 3, "bubble", 3), 
    SUSPEND("SUSPEND", 4, "suspend", 4), 
    DEPTH_SUSPEND("DEPTH_SUSPEND", 5, "depthSuspend", 5), 
    TOWN_AURA("TOWN_AURA", 6, "townaura", 6), 
    CRIT("CRIT", 7, "crit", 7), 
    MAGIC_CRIT("MAGIC_CRIT", 8, "magicCrit", 8), 
    MOB_SPELL("MOB_SPELL", 9, "mobSpell", 9), 
    MOB_SPELL_AMBIENT("MOB_SPELL_AMBIENT", 10, "mobSpellAmbient", 10), 
    SPELL("SPELL", 11, "spell", 11), 
    INSTANT_SPELL("INSTANT_SPELL", 12, "instantSpell", 12), 
    WITCH_MAGIC("WITCH_MAGIC", 13, "witchMagic", 13), 
    NOTE("NOTE", 14, "note", 14), 
    PORTAL("PORTAL", 15, "portal", 15), 
    ENCHANTMENT_TABLE("ENCHANTMENT_TABLE", 16, "enchantmenttable", 16), 
    EXPLODE("EXPLODE", 17, "explode", 17), 
    FLAME("FLAME", 18, "flame", 18), 
    LAVA("LAVA", 19, "lava", 19), 
    FOOTSTEP("FOOTSTEP", 20, "footstep", 20), 
    SPLASH("SPLASH", 21, "splash", 21), 
    LARGE_SMOKE("LARGE_SMOKE", 22, "largesmoke", 22), 
    CLOUD("CLOUD", 23, "cloud", 23), 
    RED_DUST("RED_DUST", 24, "reddust", 24), 
    SNOWBALL_POOF("SNOWBALL_POOF", 25, "snowballpoof", 25), 
    DRIP_WATER("DRIP_WATER", 26, "dripWater", 26), 
    DRIP_LAVA("DRIP_LAVA", 27, "dripLava", 27), 
    SNOW_SHOVEL("SNOW_SHOVEL", 28, "snowshovel", 28), 
    SLIME("SLIME", 29, "slime", 29), 
    HEART("HEART", 30, "heart", 30), 
    ANGRY_VILLAGER("ANGRY_VILLAGER", 31, "angryVillager", 31), 
    HAPPY_VILLAGER("HAPPY_VILLAGER", 32, "happyVillager", 32), 
    ICONCRACK("ICONCRACK", 33, "iconcrack", 33), 
    TILECRACK("TILECRACK", 34, "tilecrack", 34);
    
    private String name;
    private int id;
    private static final Map<String, EffectManager> NAME_MAP;
    private static final Map<Integer, EffectManager> ID_MAP;
    
    static {
        NAME_MAP = new HashMap<String, EffectManager>();
        ID_MAP = new HashMap<Integer, EffectManager>();
        EffectManager[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final EffectManager effect = values[i];
            EffectManager.NAME_MAP.put(effect.name, effect);
            EffectManager.ID_MAP.put(effect.id, effect);
        }
    }
    
    private EffectManager(final String s, final int n, final String name, final int id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getId() {
        return this.id;
    }
    
    public static EffectManager fromName(final String name) {
        if (name == null) {
            return null;
        }
        for (final Map.Entry<String, EffectManager> e : EffectManager.NAME_MAP.entrySet()) {
            if (e.getKey().equalsIgnoreCase(name)) {
                return e.getValue();
            }
        }
        return null;
    }
    
    public static EffectManager fromId(final int id) {
        return EffectManager.ID_MAP.get(id);
    }
    
    public static void sendToPlayer(final EffectManager effect, final Player player, final Location location, final float offsetX, final float offsetY, final float offsetZ, final float speed, final int count) throws Exception {
        final Object packet = createPacket(effect, location, offsetX, offsetY, offsetZ, speed, count);
        sendPacket(player, packet);
    }
    
    public static void sendToLocation(final EffectManager effect, final Location location, final float offsetX, final float offsetY, final float offsetZ, final float speed, final int count) throws Exception {
        final Object packet = createPacket(effect, location, offsetX, offsetY, offsetZ, speed, count);
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player player = onlinePlayers[i];
            sendPacket(player, packet);
        }
    }
    
    public static void sendCrackToPlayer(final boolean icon, final int id, final byte data, final Player player, final Location location, final float offsetX, final float offsetY, final float offsetZ, final int count) throws Exception {
        final Object packet = createCrackPacket(icon, id, data, location, offsetX, offsetY, offsetZ, count);
        sendPacket(player, packet);
    }
    
    public static void sendCrackToLocation(final boolean icon, final int id, final byte data, final Location location, final float offsetX, final float offsetY, final float offsetZ, final int count) throws Exception {
        final Object packet = createCrackPacket(icon, id, data, location, offsetX, offsetY, offsetZ, count);
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player player = onlinePlayers[i];
            sendPacket(player, packet);
        }
    }
    
    public static Object createPacket(final EffectManager effect, final Location location, final float offsetX, final float offsetY, final float offsetZ, final float speed, int count) throws Exception {
        if (count <= 0) {
            count = 1;
        }
        final Object packet = getPacketPlayOutWorldParticles();
        setValue(packet, "a", effect.name);
        setValue(packet, "b", (float)location.getX());
        setValue(packet, "c", (float)location.getY());
        setValue(packet, "d", (float)location.getZ());
        setValue(packet, "e", offsetX);
        setValue(packet, "f", offsetY);
        setValue(packet, "g", offsetZ);
        setValue(packet, "h", speed);
        setValue(packet, "i", count);
        return packet;
    }
    
    public static Object createCrackPacket(final boolean icon, final int id, final byte data, final Location location, final float offsetX, final float offsetY, final float offsetZ, int count) throws Exception {
        if (count <= 0) {
            count = 1;
        }
        final Object packet = getPacketPlayOutWorldParticles();
        String modifier = "iconcrack_" + id;
        if (!icon) {
            modifier = "tilecrack_" + id + "_" + data;
        }
        setValue(packet, "a", modifier);
        setValue(packet, "b", (float)location.getX());
        setValue(packet, "c", (float)location.getY());
        setValue(packet, "d", (float)location.getZ());
        setValue(packet, "e", offsetX);
        setValue(packet, "f", offsetY);
        setValue(packet, "g", offsetZ);
        setValue(packet, "h", 0.1f);
        setValue(packet, "i", count);
        return packet;
    }
    
    private static void setValue(final Object instance, final String fieldName, final Object value) throws Exception {
        final Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(instance, value);
    }
    
    private static Object getEntityPlayer(final Player p) throws Exception {
        final Method getHandle = p.getClass().getMethod("getHandle", (Class<?>[])new Class[0]);
        return getHandle.invoke(p, new Object[0]);
    }
    
    private static String getPackageName() {
        return "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }
    
    private static Object getPacketPlayOutWorldParticles() throws Exception {
        final Class<?> packet = Class.forName(String.valueOf(getPackageName()) + ".PacketPlayOutWorldParticles");
        return packet.getConstructors()[0].newInstance(new Object[0]);
    }
    
    private static void sendPacket(final Player p, final Object packet) throws Exception {
        final Object eplayer = getEntityPlayer(p);
        final Field playerConnectionField = eplayer.getClass().getField("playerConnection");
        final Object playerConnection = playerConnectionField.get(eplayer);
        Method[] methods;
        for (int length = (methods = playerConnection.getClass().getMethods()).length, i = 0; i < length; ++i) {
            final Method m = methods[i];
            if (m.getName().equalsIgnoreCase("sendPacket")) {
                m.invoke(playerConnection, packet);
                return;
            }
        }
    }
}
