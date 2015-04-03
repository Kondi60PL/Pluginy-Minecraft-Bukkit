/*   1:    */ package com.gmail.tirexgta.ttoolsex;
/*   2:    */ 
/*   3:    */ import com.comphenix.protocol.AsynchronousManager;
/*   4:    */ import com.comphenix.protocol.PacketType;
/*   5:    */ import com.comphenix.protocol.PacketType.Play.Server;
/*   6:    */ import com.comphenix.protocol.ProtocolLibrary;
/*   7:    */ import com.comphenix.protocol.ProtocolManager;
/*   8:    */ import com.comphenix.protocol.async.AsyncListenerHandler;
/*   9:    */ import com.comphenix.protocol.events.ListenerPriority;
/*  10:    */ import com.comphenix.protocol.events.PacketAdapter;
/*  11:    */ import com.comphenix.protocol.events.PacketContainer;
/*  12:    */ import com.comphenix.protocol.events.PacketEvent;
/*  13:    */ import com.comphenix.protocol.reflect.StructureModifier;
/*  14:    */ import com.comphenix.protocol.wrappers.WrappedGameProfile;
/*  15:    */ import com.google.common.base.Charsets;
/*  16:    */ import com.google.common.base.Objects;
/*  17:    */ import com.google.common.cache.Cache;
/*  18:    */ import com.google.common.cache.CacheBuilder;
/*  19:    */ import com.google.common.cache.CacheLoader;
/*  20:    */ import com.google.common.collect.Maps;
/*  21:    */ import com.google.common.io.CharStreams;
/*  22:    */ import com.google.common.io.InputSupplier;
/*  23:    */ import java.io.IOException;
/*  24:    */ import java.io.InputStreamReader;
/*  25:    */ import java.net.URL;
/*  26:    */ import java.net.URLConnection;
/*  27:    */ import java.util.Map;
/*  28:    */ import java.util.UUID;
/*  29:    */ import java.util.concurrent.ConcurrentMap;
/*  30:    */ import java.util.concurrent.TimeUnit;
/*  31:    */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*  32:    */ import net.minecraft.util.com.mojang.authlib.properties.Property;
/*  33:    */ import net.minecraft.util.com.mojang.authlib.properties.PropertyMap;
/*  34:    */ import org.bukkit.Bukkit;
/*  35:    */ import org.bukkit.OfflinePlayer;
/*  36:    */ import org.bukkit.entity.Player;
/*  37:    */ import org.bukkit.plugin.Plugin;
/*  38:    */ import org.json.simple.JSONArray;
/*  39:    */ import org.json.simple.JSONObject;
/*  40:    */ import org.json.simple.parser.JSONParser;
/*  41:    */ 
/*  42:    */ public class SkinChangeManager
/*  43:    */ {
/*  44:    */   private static final String PROFILE_URL = "https://sessionserver.mojang.com/session/minecraft/profile/";
/*  45:    */   private static final int WORKER_THREADS = 4;
/*  46:    */   private ProtocolManager protocolManager;
/*  47: 51 */   private ConcurrentMap<String, String> skinNames = Maps.newConcurrentMap();
/*  48: 52 */   private ConcurrentMap<String, String> displayNames = Maps.newConcurrentMap();
/*  49: 54 */   private Cache<String, String> profileCache = CacheBuilder.newBuilder()
/*  50: 55 */     .maximumSize(500)
/*  51: 56 */     .expireAfterWrite(4L, TimeUnit.HOURS)
/*  52: 57 */     .build(new CacheLoader()
/*  53:    */   {
/*  54:    */     public String load(String name)
/*  55:    */       throws Exception
/*  56:    */     {
/*  57: 59 */       return SkinChangeManager.this.getProfileJson(name);
/*  58:    */     }
/*  59: 57 */   });
/*  60:    */   
/*  61:    */   public SkinChangeManager(Plugin plugin)
/*  62:    */   {
/*  63: 64 */     this.protocolManager = ProtocolLibrary.getProtocolManager();
/*  64: 65 */     this.protocolManager.getAsynchronousManager().registerAsyncHandler(
/*  65: 66 */       new PacketAdapter(plugin, ListenerPriority.NORMAL, new PacketType[] {
/*  66:    */       
/*  67: 68 */       PacketType.Play.Server.NAMED_ENTITY_SPAWN, 
/*  68:    */       
/*  69:    */ 
/*  70: 71 */       PacketType.Play.Server.ENTITY_EFFECT, 
/*  71: 72 */       PacketType.Play.Server.ENTITY_EQUIPMENT, 
/*  72: 73 */       PacketType.Play.Server.ENTITY_METADATA, 
/*  73: 74 */       PacketType.Play.Server.UPDATE_ATTRIBUTES, 
/*  74: 75 */       PacketType.Play.Server.ATTACH_ENTITY, 
/*  75: 76 */       PacketType.Play.Server.BED })
/*  76:    */       {
/*  77:    */         public void onPacketSending(PacketEvent event)
/*  78:    */         {
/*  79: 82 */           if (event.getPacketType() != PacketType.Play.Server.NAMED_ENTITY_SPAWN) {
/*  80: 83 */             return;
/*  81:    */           }
/*  82: 86 */           Player toDisplay = (Player)event.getPacket().getEntityModifier(event).read(0);
/*  83: 87 */           String skinName = (String)SkinChangeManager.this.skinNames.get(toDisplay.getName());
/*  84: 88 */           String displayName = (String)SkinChangeManager.this.displayNames.get(toDisplay.getName());
/*  85: 90 */           if ((skinName == null) && (displayName == null)) {
/*  86: 91 */             return;
/*  87:    */           }
/*  88: 93 */           StructureModifier<WrappedGameProfile> profiles = event.getPacket().getGameProfiles();
/*  89: 94 */           WrappedGameProfile original = (WrappedGameProfile)profiles.read(0);
/*  90: 95 */           WrappedGameProfile result = new WrappedGameProfile(SkinChangeManager.this.extractUUID(original.getName()), displayName != null ? displayName : original.getName());
/*  91:    */           
/*  92: 97 */           SkinChangeManager.this.updateSkin(result, skinName != null ? skinName : result.getName());
/*  93: 98 */           profiles.write(0, result);
/*  94:    */         }
/*  95:100 */       }).start(4);
/*  96:    */   }
/*  97:    */   
/*  98:    */   private UUID extractUUID(String playerName)
/*  99:    */   {
/* 100:105 */     return Bukkit.getOfflinePlayer(playerName).getUniqueId();
/* 101:    */   }
/* 102:    */   
/* 103:    */   private String getProfileJson(String name)
/* 104:    */     throws IOException
/* 105:    */   {
/* 106:110 */     URL url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + extractUUID(name).toString().replace("-", ""));
/* 107:111 */     final URLConnection uc = url.openConnection();
/* 108:    */     
/* 109:113 */     CharStreams.toString(new InputSupplier()
/* 110:    */     {
/* 111:    */       public InputStreamReader getInput()
/* 112:    */         throws IOException
/* 113:    */       {
/* 114:116 */         return new InputStreamReader(uc.getInputStream(), Charsets.UTF_8);
/* 115:    */       }
/* 116:    */     });
/* 117:    */   }
/* 118:    */   
/* 119:    */   private void updateSkin(WrappedGameProfile profile, String skinOwner)
/* 120:    */   {
/* 121:    */     try
/* 122:    */     {
/* 123:123 */       JSONObject json = (JSONObject)new JSONParser().parse((String)this.profileCache.get(skinOwner));
/* 124:124 */       JSONArray properties = (JSONArray)json.get("properties");
/* 125:126 */       for (int i = 0; i < properties.size(); i++)
/* 126:    */       {
/* 127:127 */         JSONObject property = (JSONObject)properties.get(i);
/* 128:128 */         String name = (String)property.get("name");
/* 129:129 */         String value = (String)property.get("value");
/* 130:130 */         String signature = (String)property.get("signature");
/* 131:    */         
/* 132:    */ 
/* 133:    */ 
/* 134:134 */         ((GameProfile)profile.getHandle()).getProperties().put(name, new Property(name, value, signature));
/* 135:    */       }
/* 136:    */     }
/* 137:    */     catch (Exception e)
/* 138:    */     {
/* 139:138 */       throw new RuntimeException("Cannot fetch profile for " + skinOwner, e);
/* 140:    */     }
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void changeDisplay(String string, String toSkin)
/* 144:    */   {
/* 145:143 */     changeDisplay(string, toSkin, null);
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void changeDisplay(Player player, String toSkin, String toName)
/* 149:    */   {
/* 150:148 */     if ((updateMap(this.skinNames, player.getName(), toSkin) | updateMap(this.displayNames, player.getName(), toName))) {
/* 151:149 */       refreshPlayer(player);
/* 152:    */     }
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void changeDisplay(String playerName, String toSkin, String toName)
/* 156:    */   {
/* 157:155 */     if ((updateMap(this.skinNames, playerName, toSkin) | updateMap(this.displayNames, playerName, toName))) {
/* 158:156 */       refreshPlayer(playerName);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void removeChanges(Player player)
/* 163:    */   {
/* 164:161 */     changeDisplay(player.getName(), null, null);
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void removeChanges(String playerName)
/* 168:    */   {
/* 169:165 */     changeDisplay(playerName, null, null);
/* 170:    */   }
/* 171:    */   
/* 172:    */   private <T, U> boolean updateMap(Map<T, U> map, T key, U value)
/* 173:    */   {
/* 174:176 */     if (value == null) {
/* 175:177 */       return map.remove(key) != null;
/* 176:    */     }
/* 177:179 */     return !Objects.equal(value, map.put(key, value));
/* 178:    */   }
/* 179:    */   
/* 180:    */   private void refreshPlayer(String name)
/* 181:    */   {
/* 182:185 */     Player player = Bukkit.getPlayer(name);
/* 183:187 */     if (player != null) {
/* 184:188 */       refreshPlayer(player);
/* 185:    */     }
/* 186:    */   }
/* 187:    */   
/* 188:    */   private void refreshPlayer(Player player)
/* 189:    */   {
/* 190:194 */     this.protocolManager.updateEntity(player, this.protocolManager.getEntityTrackers(player));
/* 191:    */   }
/* 192:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.SkinChangeManager
 * JD-Core Version:    0.7.0.1
 */