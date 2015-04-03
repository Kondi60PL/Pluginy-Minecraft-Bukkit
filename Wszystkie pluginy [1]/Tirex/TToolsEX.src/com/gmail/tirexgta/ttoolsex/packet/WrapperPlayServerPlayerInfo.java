/*  1:   */ package com.gmail.tirexgta.ttoolsex.packet;
/*  2:   */ 
/*  3:   */ import com.comphenix.protocol.PacketType;
/*  4:   */ import com.comphenix.protocol.PacketType.Play.Server;
/*  5:   */ import com.comphenix.protocol.events.PacketContainer;
/*  6:   */ import com.comphenix.protocol.reflect.StructureModifier;
/*  7:   */ 
/*  8:   */ public class WrapperPlayServerPlayerInfo
/*  9:   */   extends AbstractPacket
/* 10:   */ {
/* 11: 7 */   public static final PacketType TYPE = PacketType.Play.Server.PLAYER_INFO;
/* 12:   */   
/* 13:   */   public WrapperPlayServerPlayerInfo()
/* 14:   */   {
/* 15:10 */     super(new PacketContainer(TYPE), TYPE);
/* 16:11 */     this.handle.getModifier().writeDefaults();
/* 17:   */   }
/* 18:   */   
/* 19:   */   public WrapperPlayServerPlayerInfo(PacketContainer packet)
/* 20:   */   {
/* 21:15 */     super(packet, TYPE);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getPlayerName()
/* 25:   */   {
/* 26:25 */     return (String)this.handle.getStrings().read(0);
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setPlayerName(String value)
/* 30:   */   {
/* 31:35 */     this.handle.getStrings().write(0, value);
/* 32:   */   }
/* 33:   */   
/* 34:   */   public boolean getOnline()
/* 35:   */   {
/* 36:43 */     return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setOnline(boolean value)
/* 40:   */   {
/* 41:51 */     this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
/* 42:   */   }
/* 43:   */   
/* 44:   */   public short getPing()
/* 45:   */   {
/* 46:59 */     return ((Integer)this.handle.getIntegers().read(0)).shortValue();
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setPing(short value)
/* 50:   */   {
/* 51:67 */     this.handle.getIntegers().write(0, Integer.valueOf(value));
/* 52:   */   }
/* 53:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.packet.WrapperPlayServerPlayerInfo
 * JD-Core Version:    0.7.0.1
 */