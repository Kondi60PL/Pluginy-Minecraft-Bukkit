package com.gmail.tirexgta.ttoolsex;

import org.bukkit.plugin.*;
import com.google.common.collect.*;
import java.util.concurrent.*;
import com.google.common.cache.*;
import com.comphenix.protocol.*;
import com.comphenix.protocol.wrappers.*;
import com.comphenix.protocol.reflect.*;
import com.comphenix.protocol.events.*;
import org.bukkit.*;
import java.net.*;
import java.io.*;
import com.google.common.io.*;
import org.json.simple.parser.*;
import org.json.simple.*;
import net.minecraft.util.com.mojang.authlib.*;
import net.minecraft.util.com.mojang.authlib.properties.*;
import java.util.*;
import com.google.common.base.*;
import org.bukkit.entity.*;

public class SkinChangeManager
{
    private static final String PROFILE_URL = "https://sessionserver.mojang.com/session/minecraft/profile/";
    private static final int WORKER_THREADS = 4;
    private ProtocolManager protocolManager;
    private ConcurrentMap<String, String> skinNames;
    private ConcurrentMap<String, String> displayNames;
    private Cache<String, String> profileCache;
    
    public SkinChangeManager(final Plugin plugin) {
        super();
        this.skinNames = (ConcurrentMap<String, String>)Maps.newConcurrentMap();
        this.displayNames = (ConcurrentMap<String, String>)Maps.newConcurrentMap();
        this.profileCache = (Cache<String, String>)CacheBuilder.newBuilder().maximumSize(500).expireAfterWrite(4L, TimeUnit.HOURS).build((CacheLoader)new CacheLoader<String, String>() {
            public String load(final String name) throws Exception {
                return SkinChangeManager.this.getProfileJson(name);
            }
        });
        this.protocolManager = ProtocolLibrary.getProtocolManager();
        this.protocolManager.getAsynchronousManager().registerAsyncHandler((PacketListener)new PacketAdapter(plugin, ListenerPriority.NORMAL, new PacketType[] { PacketType.Play.Server.NAMED_ENTITY_SPAWN, PacketType.Play.Server.ENTITY_EFFECT, PacketType.Play.Server.ENTITY_EQUIPMENT, PacketType.Play.Server.ENTITY_METADATA, PacketType.Play.Server.UPDATE_ATTRIBUTES, PacketType.Play.Server.ATTACH_ENTITY, PacketType.Play.Server.BED }) {
            public void onPacketSending(final PacketEvent event) {
                if (event.getPacketType() != PacketType.Play.Server.NAMED_ENTITY_SPAWN) {
                    return;
                }
                final Player toDisplay = (Player)event.getPacket().getEntityModifier(event).read(0);
                final String skinName = (String)SkinChangeManager.this.skinNames.get(toDisplay.getName());
                final String displayName = (String)SkinChangeManager.this.displayNames.get(toDisplay.getName());
                if (skinName == null && displayName == null) {
                    return;
                }
                final StructureModifier<WrappedGameProfile> profiles = (StructureModifier<WrappedGameProfile>)event.getPacket().getGameProfiles();
                final WrappedGameProfile original = (WrappedGameProfile)profiles.read(0);
                final WrappedGameProfile result = new WrappedGameProfile(SkinChangeManager.this.extractUUID(original.getName()), (displayName != null) ? displayName : original.getName());
                SkinChangeManager.this.updateSkin(result, (skinName != null) ? skinName : result.getName());
                profiles.write(0, (Object)result);
            }
        }).start(4);
    }
    
    private UUID extractUUID(final String playerName) {
        return Bukkit.getOfflinePlayer(playerName).getUniqueId();
    }
    
    private String getProfileJson(final String name) throws IOException {
        final URL url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + this.extractUUID(name).toString().replace("-", ""));
        final URLConnection uc = url.openConnection();
        return CharStreams.toString((InputSupplier)new InputSupplier<InputStreamReader>() {
            public InputStreamReader getInput() throws IOException {
                return new InputStreamReader(uc.getInputStream(), Charsets.UTF_8);
            }
        });
    }
    
    private void updateSkin(final WrappedGameProfile profile, final String skinOwner) {
        try {
            final JSONObject json = (JSONObject)new JSONParser().parse((String)this.profileCache.get((Object)skinOwner));
            final JSONArray properties = (JSONArray)json.get((Object)"properties");
            for (int i = 0; i < properties.size(); ++i) {
                final JSONObject property = (JSONObject)properties.get(i);
                final String name = (String)property.get((Object)"name");
                final String value = (String)property.get((Object)"value");
                final String signature = (String)property.get((Object)"signature");
                ((GameProfile)profile.getHandle()).getProperties().put((Object)name, (Object)new Property(name, value, signature));
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Cannot fetch profile for " + skinOwner, e);
        }
    }
    
    public void changeDisplay(final String string, final String toSkin) {
        this.changeDisplay(string, toSkin, null);
    }
    
    public void changeDisplay(final Player player, final String toSkin, final String toName) {
        if (this.updateMap(this.skinNames, player.getName(), toSkin) | this.updateMap(this.displayNames, player.getName(), toName)) {
            this.refreshPlayer(player);
        }
    }
    
    public void changeDisplay(final String playerName, final String toSkin, final String toName) {
        if (this.updateMap(this.skinNames, playerName, toSkin) | this.updateMap(this.displayNames, playerName, toName)) {
            this.refreshPlayer(playerName);
        }
    }
    
    public void removeChanges(final Player player) {
        this.changeDisplay(player.getName(), null, null);
    }
    
    public void removeChanges(final String playerName) {
        this.changeDisplay(playerName, null, null);
    }
    
    private <T, U> boolean updateMap(final Map<T, U> map, final T key, final U value) {
        if (value == null) {
            return map.remove(key) != null;
        }
        return !Objects.equal((Object)value, (Object)map.put(key, value));
    }
    
    private void refreshPlayer(final String name) {
        final Player player = Bukkit.getPlayer(name);
        if (player != null) {
            this.refreshPlayer(player);
        }
    }
    
    private void refreshPlayer(final Player player) {
        this.protocolManager.updateEntity((Entity)player, this.protocolManager.getEntityTrackers((Entity)player));
    }
}
