/*   1:    */ package com.gmail.tirexgta.ttoolsex;
/*   2:    */ 
/*   3:    */ import java.lang.reflect.Constructor;
/*   4:    */ import java.lang.reflect.Field;
/*   5:    */ import java.lang.reflect.Method;
/*   6:    */ import java.util.HashMap;
/*   7:    */ import java.util.Map;
/*   8:    */ import java.util.Map.Entry;
/*   9:    */ import org.bukkit.Bukkit;
/*  10:    */ import org.bukkit.Location;
/*  11:    */ import org.bukkit.entity.Player;
/*  12:    */ 
/*  13:    */ public enum EffectManager
/*  14:    */ {
/*  15: 14 */   HUGE_EXPLOSION("hugeexplosion", 0),  LARGE_EXPLODE("largeexplode", 1),  FIREWORKS_SPARK("fireworksSpark", 2),  BUBBLE("bubble", 3),  SUSPEND("suspend", 4),  DEPTH_SUSPEND("depthSuspend", 5),  TOWN_AURA("townaura", 6),  CRIT("crit", 7),  MAGIC_CRIT("magicCrit", 8),  MOB_SPELL("mobSpell", 9),  MOB_SPELL_AMBIENT("mobSpellAmbient", 10),  SPELL("spell", 11),  INSTANT_SPELL("instantSpell", 12),  WITCH_MAGIC("witchMagic", 13),  NOTE("note", 14),  PORTAL("portal", 15),  ENCHANTMENT_TABLE("enchantmenttable", 16),  EXPLODE("explode", 17),  FLAME("flame", 18),  LAVA("lava", 19),  FOOTSTEP("footstep", 20),  SPLASH("splash", 21),  LARGE_SMOKE("largesmoke", 22),  CLOUD("cloud", 23),  RED_DUST("reddust", 24),  SNOWBALL_POOF("snowballpoof", 25),  DRIP_WATER("dripWater", 26),  DRIP_LAVA("dripLava", 27),  SNOW_SHOVEL("snowshovel", 28),  SLIME("slime", 29),  HEART("heart", 30),  ANGRY_VILLAGER("angryVillager", 31),  HAPPY_VILLAGER("happyVillager", 32),  ICONCRACK("iconcrack", 33),  TILECRACK("tilecrack", 34);
/*  16:    */   
/*  17:    */   private String name;
/*  18:    */   private int id;
/*  19:    */   private static final Map<String, EffectManager> NAME_MAP;
/*  20:    */   private static final Map<Integer, EffectManager> ID_MAP;
/*  21:    */   
/*  22:    */   private EffectManager(String name, int id)
/*  23:    */   {
/*  24: 18 */     this.name = name;
/*  25: 19 */     this.id = id;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public String getName()
/*  29:    */   {
/*  30: 22 */     return this.name;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public int getId()
/*  34:    */   {
/*  35: 25 */     return this.id;
/*  36:    */   }
/*  37:    */   
/*  38:    */   static
/*  39:    */   {
/*  40: 27 */     NAME_MAP = new HashMap();
/*  41: 28 */     ID_MAP = new HashMap();
/*  42: 30 */     for (EffectManager effect : values())
/*  43:    */     {
/*  44: 31 */       NAME_MAP.put(effect.name, effect);
/*  45: 32 */       ID_MAP.put(Integer.valueOf(effect.id), effect);
/*  46:    */     }
/*  47:    */   }
/*  48:    */   
/*  49:    */   public static EffectManager fromName(String name)
/*  50:    */   {
/*  51: 36 */     if (name == null) {
/*  52: 37 */       return null;
/*  53:    */     }
/*  54: 39 */     for (Map.Entry<String, EffectManager> e : NAME_MAP.entrySet()) {
/*  55: 40 */       if (((String)e.getKey()).equalsIgnoreCase(name)) {
/*  56: 41 */         return (EffectManager)e.getValue();
/*  57:    */       }
/*  58:    */     }
/*  59: 44 */     return null;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public static EffectManager fromId(int id)
/*  63:    */   {
/*  64: 47 */     return (EffectManager)ID_MAP.get(Integer.valueOf(id));
/*  65:    */   }
/*  66:    */   
/*  67:    */   public static void sendToPlayer(EffectManager effect, Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count)
/*  68:    */     throws Exception
/*  69:    */   {
/*  70: 50 */     Object packet = createPacket(effect, location, offsetX, offsetY, offsetZ, speed, count);
/*  71: 51 */     sendPacket(player, packet);
/*  72:    */   }
/*  73:    */   
/*  74:    */   public static void sendToLocation(EffectManager effect, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count)
/*  75:    */     throws Exception
/*  76:    */   {
/*  77: 54 */     Object packet = createPacket(effect, location, offsetX, offsetY, offsetZ, speed, count);
/*  78: 55 */     for (Player player : Bukkit.getOnlinePlayers()) {
/*  79: 56 */       sendPacket(player, packet);
/*  80:    */     }
/*  81:    */   }
/*  82:    */   
/*  83:    */   public static void sendCrackToPlayer(boolean icon, int id, byte data, Player player, Location location, float offsetX, float offsetY, float offsetZ, int count)
/*  84:    */     throws Exception
/*  85:    */   {
/*  86: 60 */     Object packet = createCrackPacket(icon, id, data, location, offsetX, offsetY, offsetZ, count);
/*  87: 61 */     sendPacket(player, packet);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public static void sendCrackToLocation(boolean icon, int id, byte data, Location location, float offsetX, float offsetY, float offsetZ, int count)
/*  91:    */     throws Exception
/*  92:    */   {
/*  93: 64 */     Object packet = createCrackPacket(icon, id, data, location, offsetX, offsetY, offsetZ, count);
/*  94: 65 */     for (Player player : Bukkit.getOnlinePlayers()) {
/*  95: 66 */       sendPacket(player, packet);
/*  96:    */     }
/*  97:    */   }
/*  98:    */   
/*  99:    */   public static Object createPacket(EffectManager effect, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count)
/* 100:    */     throws Exception
/* 101:    */   {
/* 102: 70 */     if (count <= 0) {
/* 103: 71 */       count = 1;
/* 104:    */     }
/* 105: 72 */     Object packet = getPacketPlayOutWorldParticles();
/* 106: 73 */     setValue(packet, "a", effect.name);
/* 107: 74 */     setValue(packet, "b", Float.valueOf((float)location.getX()));
/* 108: 75 */     setValue(packet, "c", Float.valueOf((float)location.getY()));
/* 109: 76 */     setValue(packet, "d", Float.valueOf((float)location.getZ()));
/* 110: 77 */     setValue(packet, "e", Float.valueOf(offsetX));
/* 111: 78 */     setValue(packet, "f", Float.valueOf(offsetY));
/* 112: 79 */     setValue(packet, "g", Float.valueOf(offsetZ));
/* 113: 80 */     setValue(packet, "h", Float.valueOf(speed));
/* 114: 81 */     setValue(packet, "i", Integer.valueOf(count));
/* 115: 82 */     return packet;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public static Object createCrackPacket(boolean icon, int id, byte data, Location location, float offsetX, float offsetY, float offsetZ, int count)
/* 119:    */     throws Exception
/* 120:    */   {
/* 121: 85 */     if (count <= 0) {
/* 122: 86 */       count = 1;
/* 123:    */     }
/* 124: 87 */     Object packet = getPacketPlayOutWorldParticles();
/* 125: 88 */     String modifier = "iconcrack_" + id;
/* 126: 89 */     if (!icon) {
/* 127: 90 */       modifier = "tilecrack_" + id + "_" + data;
/* 128:    */     }
/* 129: 92 */     setValue(packet, "a", modifier);
/* 130: 93 */     setValue(packet, "b", Float.valueOf((float)location.getX()));
/* 131: 94 */     setValue(packet, "c", Float.valueOf((float)location.getY()));
/* 132: 95 */     setValue(packet, "d", Float.valueOf((float)location.getZ()));
/* 133: 96 */     setValue(packet, "e", Float.valueOf(offsetX));
/* 134: 97 */     setValue(packet, "f", Float.valueOf(offsetY));
/* 135: 98 */     setValue(packet, "g", Float.valueOf(offsetZ));
/* 136: 99 */     setValue(packet, "h", Float.valueOf(0.1F));
/* 137:100 */     setValue(packet, "i", Integer.valueOf(count));
/* 138:101 */     return packet;
/* 139:    */   }
/* 140:    */   
/* 141:    */   private static void setValue(Object instance, String fieldName, Object value)
/* 142:    */     throws Exception
/* 143:    */   {
/* 144:104 */     Field field = instance.getClass().getDeclaredField(fieldName);
/* 145:105 */     field.setAccessible(true);
/* 146:106 */     field.set(instance, value);
/* 147:    */   }
/* 148:    */   
/* 149:    */   private static Object getEntityPlayer(Player p)
/* 150:    */     throws Exception
/* 151:    */   {
/* 152:109 */     Method getHandle = p.getClass().getMethod("getHandle", new Class[0]);
/* 153:110 */     return getHandle.invoke(p, new Object[0]);
/* 154:    */   }
/* 155:    */   
/* 156:    */   private static String getPackageName()
/* 157:    */   {
/* 158:113 */     return "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
/* 159:    */   }
/* 160:    */   
/* 161:    */   private static Object getPacketPlayOutWorldParticles()
/* 162:    */     throws Exception
/* 163:    */   {
/* 164:116 */     Class<?> packet = Class.forName(getPackageName() + ".PacketPlayOutWorldParticles");
/* 165:117 */     return packet.getConstructors()[0].newInstance(new Object[0]);
/* 166:    */   }
/* 167:    */   
/* 168:    */   private static void sendPacket(Player p, Object packet)
/* 169:    */     throws Exception
/* 170:    */   {
/* 171:120 */     Object eplayer = getEntityPlayer(p);
/* 172:121 */     Field playerConnectionField = eplayer.getClass().getField("playerConnection");
/* 173:122 */     Object playerConnection = playerConnectionField.get(eplayer);
/* 174:123 */     for (Method m : playerConnection.getClass().getMethods()) {
/* 175:124 */       if (m.getName().equalsIgnoreCase("sendPacket"))
/* 176:    */       {
/* 177:125 */         m.invoke(playerConnection, new Object[] { packet });
/* 178:126 */         return;
/* 179:    */       }
/* 180:    */     }
/* 181:    */   }
/* 182:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.EffectManager
 * JD-Core Version:    0.7.0.1
 */