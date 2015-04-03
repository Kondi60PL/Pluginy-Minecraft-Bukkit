/*   1:    */ package com.gmail.tirexgta.ttoolsex.packet;
/*   2:    */ 
/*   3:    */ import com.comphenix.protocol.PacketType;
/*   4:    */ import com.comphenix.protocol.PacketType.Play.Server;
/*   5:    */ import com.comphenix.protocol.events.PacketContainer;
/*   6:    */ import com.comphenix.protocol.reflect.IntEnum;
/*   7:    */ import com.comphenix.protocol.reflect.StructureModifier;
/*   8:    */ import java.util.Collection;
/*   9:    */ 
/*  10:    */ public class WrapperPlayServerScoreboardTeam
/*  11:    */   extends AbstractPacket
/*  12:    */ {
/*  13: 10 */   public static final PacketType TYPE = PacketType.Play.Server.SCOREBOARD_TEAM;
/*  14:    */   
/*  15:    */   public static class Modes
/*  16:    */     extends IntEnum
/*  17:    */   {
/*  18:    */     public static final int TEAM_CREATED = 0;
/*  19:    */     public static final int TEAM_REMOVED = 1;
/*  20:    */     public static final int TEAM_UPDATED = 2;
/*  21:    */     public static final int PLAYERS_ADDED = 3;
/*  22:    */     public static final int PLAYERS_REMOVED = 4;
/*  23: 24 */     private static final Modes INSTANCE = new Modes();
/*  24:    */     
/*  25:    */     public static Modes getInstance()
/*  26:    */     {
/*  27: 27 */       return INSTANCE;
/*  28:    */     }
/*  29:    */   }
/*  30:    */   
/*  31:    */   public WrapperPlayServerScoreboardTeam()
/*  32:    */   {
/*  33: 32 */     super(new PacketContainer(TYPE), TYPE);
/*  34: 33 */     this.handle.getModifier().writeDefaults();
/*  35:    */   }
/*  36:    */   
/*  37:    */   public WrapperPlayServerScoreboardTeam(PacketContainer packet)
/*  38:    */   {
/*  39: 37 */     super(packet, TYPE);
/*  40:    */   }
/*  41:    */   
/*  42:    */   public String getTeamName()
/*  43:    */   {
/*  44: 45 */     return (String)this.handle.getStrings().read(0);
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setTeamName(String value)
/*  48:    */   {
/*  49: 53 */     this.handle.getStrings().write(0, value);
/*  50:    */   }
/*  51:    */   
/*  52:    */   public byte getPacketMode()
/*  53:    */   {
/*  54: 63 */     return ((Integer)this.handle.getIntegers().read(0)).byteValue();
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setPacketMode(byte value)
/*  58:    */   {
/*  59: 73 */     this.handle.getIntegers().write(0, Integer.valueOf(value));
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getTeamDisplayName()
/*  63:    */   {
/*  64: 83 */     return (String)this.handle.getStrings().read(1);
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setTeamDisplayName(String value)
/*  68:    */   {
/*  69: 93 */     this.handle.getStrings().write(1, value);
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String getTeamPrefix()
/*  73:    */   {
/*  74:103 */     return (String)this.handle.getStrings().read(2);
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setTeamPrefix(String value)
/*  78:    */   {
/*  79:113 */     this.handle.getStrings().write(2, value);
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getTeamSuffix()
/*  83:    */   {
/*  84:123 */     return (String)this.handle.getStrings().read(3);
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setTeamSuffix(String value)
/*  88:    */   {
/*  89:133 */     this.handle.getStrings().write(3, value);
/*  90:    */   }
/*  91:    */   
/*  92:    */   public byte getFriendlyFire()
/*  93:    */   {
/*  94:143 */     return ((Integer)this.handle.getIntegers().read(1)).byteValue();
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setFriendlyFire(byte value)
/*  98:    */   {
/*  99:153 */     this.handle.getIntegers().write(1, Integer.valueOf(value));
/* 100:    */   }
/* 101:    */   
/* 102:    */   public Collection<String> getPlayers()
/* 103:    */   {
/* 104:169 */     return (Collection)this.handle.getSpecificModifier(Collection.class).read(0);
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setPlayers(Collection<String> players)
/* 108:    */   {
/* 109:184 */     this.handle.getSpecificModifier(Collection.class).write(0, players);
/* 110:    */   }
/* 111:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.packet.WrapperPlayServerScoreboardTeam
 * JD-Core Version:    0.7.0.1
 */