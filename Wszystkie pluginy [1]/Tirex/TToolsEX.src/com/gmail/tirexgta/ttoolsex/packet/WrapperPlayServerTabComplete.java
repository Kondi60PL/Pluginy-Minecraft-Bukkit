/*  1:   */ package com.gmail.tirexgta.ttoolsex.packet;
/*  2:   */ 
/*  3:   */ import com.comphenix.protocol.PacketType;
/*  4:   */ import com.comphenix.protocol.PacketType.Play.Server;
/*  5:   */ import com.comphenix.protocol.events.PacketContainer;
/*  6:   */ import com.comphenix.protocol.reflect.StructureModifier;
/*  7:   */ 
/*  8:   */ public class WrapperPlayServerTabComplete
/*  9:   */   extends AbstractPacket
/* 10:   */ {
/* 11: 8 */   public static final PacketType TYPE = PacketType.Play.Server.TAB_COMPLETE;
/* 12:   */   
/* 13:   */   public WrapperPlayServerTabComplete()
/* 14:   */   {
/* 15:11 */     super(new PacketContainer(TYPE), TYPE);
/* 16:12 */     this.handle.getModifier().writeDefaults();
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String[] getText()
/* 20:   */   {
/* 21:20 */     return (String[])this.handle.getStringArrays().read(0);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setText(String[] value)
/* 25:   */   {
/* 26:28 */     this.handle.getStringArrays().write(0, value);
/* 27:   */   }
/* 28:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.packet.WrapperPlayServerTabComplete
 * JD-Core Version:    0.7.0.1
 */