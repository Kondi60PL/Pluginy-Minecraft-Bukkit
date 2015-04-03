/*  1:   */ package com.gmail.tirexgta.ttoolsex.packet;
/*  2:   */ 
/*  3:   */ import com.comphenix.protocol.PacketType;
/*  4:   */ import com.comphenix.protocol.PacketType.Play.Server;
/*  5:   */ import com.comphenix.protocol.events.PacketContainer;
/*  6:   */ import com.comphenix.protocol.reflect.StructureModifier;
/*  7:   */ 
/*  8:   */ public class WrapperPlayServerExperience
/*  9:   */   extends AbstractPacket
/* 10:   */ {
/* 11: 7 */   public static final PacketType TYPE = PacketType.Play.Server.EXPERIENCE;
/* 12:   */   
/* 13:   */   public WrapperPlayServerExperience()
/* 14:   */   {
/* 15:10 */     super(new PacketContainer(TYPE), TYPE);
/* 16:11 */     this.handle.getModifier().writeDefaults();
/* 17:   */   }
/* 18:   */   
/* 19:   */   public WrapperPlayServerExperience(PacketContainer packet)
/* 20:   */   {
/* 21:15 */     super(packet, TYPE);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public float getExperienceBar()
/* 25:   */   {
/* 26:23 */     return ((Float)this.handle.getFloat().read(0)).floatValue();
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setExperienceBar(float value)
/* 30:   */   {
/* 31:31 */     this.handle.getFloat().write(0, Float.valueOf(value));
/* 32:   */   }
/* 33:   */   
/* 34:   */   public short getLevel()
/* 35:   */   {
/* 36:39 */     return ((Integer)this.handle.getIntegers().read(1)).shortValue();
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setLevel(short value)
/* 40:   */   {
/* 41:47 */     this.handle.getIntegers().write(1, Integer.valueOf(value));
/* 42:   */   }
/* 43:   */   
/* 44:   */   public short getTotalExperience()
/* 45:   */   {
/* 46:55 */     return ((Integer)this.handle.getIntegers().read(0)).shortValue();
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setTotalExperience(short value)
/* 50:   */   {
/* 51:63 */     this.handle.getIntegers().write(0, Integer.valueOf(value));
/* 52:   */   }
/* 53:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.packet.WrapperPlayServerExperience
 * JD-Core Version:    0.7.0.1
 */