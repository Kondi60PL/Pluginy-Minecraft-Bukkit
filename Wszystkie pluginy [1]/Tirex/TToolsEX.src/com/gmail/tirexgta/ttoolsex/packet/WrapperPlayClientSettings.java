/*   1:    */ package com.gmail.tirexgta.ttoolsex.packet;
/*   2:    */ 
/*   3:    */ import com.comphenix.protocol.PacketType;
/*   4:    */ import com.comphenix.protocol.PacketType.Play.Client;
/*   5:    */ import com.comphenix.protocol.events.PacketContainer;
/*   6:    */ import com.comphenix.protocol.reflect.StructureModifier;
/*   7:    */ import com.comphenix.protocol.wrappers.EnumWrappers.ChatVisibility;
/*   8:    */ import com.comphenix.protocol.wrappers.EnumWrappers.Difficulty;
/*   9:    */ 
/*  10:    */ public class WrapperPlayClientSettings
/*  11:    */   extends AbstractPacket
/*  12:    */ {
/*  13:  9 */   public static final PacketType TYPE = PacketType.Play.Client.SETTINGS;
/*  14:    */   
/*  15:    */   public WrapperPlayClientSettings()
/*  16:    */   {
/*  17: 12 */     super(new PacketContainer(TYPE), TYPE);
/*  18: 13 */     this.handle.getModifier().writeDefaults();
/*  19:    */   }
/*  20:    */   
/*  21:    */   public WrapperPlayClientSettings(PacketContainer packet)
/*  22:    */   {
/*  23: 17 */     super(packet, TYPE);
/*  24:    */   }
/*  25:    */   
/*  26:    */   public String getLocale()
/*  27:    */   {
/*  28: 25 */     return (String)this.handle.getStrings().read(0);
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void setLocale(String value)
/*  32:    */   {
/*  33: 33 */     this.handle.getStrings().write(0, value);
/*  34:    */   }
/*  35:    */   
/*  36:    */   public byte getViewDistance()
/*  37:    */   {
/*  38: 41 */     return ((Integer)this.handle.getIntegers().read(0)).byteValue();
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setViewDistance(byte value)
/*  42:    */   {
/*  43: 49 */     this.handle.getIntegers().write(0, Integer.valueOf(value));
/*  44:    */   }
/*  45:    */   
/*  46:    */   public EnumWrappers.ChatVisibility getChatVisibility()
/*  47:    */   {
/*  48: 57 */     return (EnumWrappers.ChatVisibility)this.handle.getChatVisibilities().read(0);
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setChatFlags(EnumWrappers.ChatVisibility value)
/*  52:    */   {
/*  53: 65 */     this.handle.getChatVisibilities().write(0, value);
/*  54:    */   }
/*  55:    */   
/*  56:    */   public boolean getChatColours()
/*  57:    */   {
/*  58: 73 */     return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setChatColours(boolean value)
/*  62:    */   {
/*  63: 81 */     this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
/*  64:    */   }
/*  65:    */   
/*  66:    */   public EnumWrappers.Difficulty getDifficulty()
/*  67:    */   {
/*  68: 89 */     return (EnumWrappers.Difficulty)this.handle.getDifficulties().read(0);
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setDifficulty(EnumWrappers.Difficulty difficulty)
/*  72:    */   {
/*  73: 97 */     this.handle.getDifficulties().write(0, difficulty);
/*  74:    */   }
/*  75:    */   
/*  76:    */   public boolean getShowCape()
/*  77:    */   {
/*  78:105 */     return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(1)).booleanValue();
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setShowCape(boolean value)
/*  82:    */   {
/*  83:113 */     this.handle.getSpecificModifier(Boolean.TYPE).write(1, Boolean.valueOf(value));
/*  84:    */   }
/*  85:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.packet.WrapperPlayClientSettings
 * JD-Core Version:    0.7.0.1
 */