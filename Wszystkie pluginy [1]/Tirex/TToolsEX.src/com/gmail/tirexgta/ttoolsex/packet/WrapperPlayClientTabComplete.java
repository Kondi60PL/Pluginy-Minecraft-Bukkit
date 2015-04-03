/*  1:   */ package com.gmail.tirexgta.ttoolsex.packet;
/*  2:   */ 
/*  3:   */ import com.comphenix.protocol.PacketType;
/*  4:   */ import com.comphenix.protocol.PacketType.Play.Client;
/*  5:   */ import com.comphenix.protocol.events.PacketContainer;
/*  6:   */ import com.comphenix.protocol.reflect.StructureModifier;
/*  7:   */ 
/*  8:   */ public class WrapperPlayClientTabComplete
/*  9:   */   extends AbstractPacket
/* 10:   */ {
/* 11: 7 */   public static final PacketType TYPE = PacketType.Play.Client.TAB_COMPLETE;
/* 12:   */   
/* 13:   */   public WrapperPlayClientTabComplete()
/* 14:   */   {
/* 15:10 */     super(new PacketContainer(TYPE), TYPE);
/* 16:11 */     this.handle.getModifier().writeDefaults();
/* 17:   */   }
/* 18:   */   
/* 19:   */   public WrapperPlayClientTabComplete(PacketContainer packet)
/* 20:   */   {
/* 21:15 */     super(packet, TYPE);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getText()
/* 25:   */   {
/* 26:23 */     return (String)this.handle.getStrings().read(0);
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setText(String value)
/* 30:   */   {
/* 31:31 */     this.handle.getStrings().write(0, value);
/* 32:   */   }
/* 33:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.packet.WrapperPlayClientTabComplete
 * JD-Core Version:    0.7.0.1
 */