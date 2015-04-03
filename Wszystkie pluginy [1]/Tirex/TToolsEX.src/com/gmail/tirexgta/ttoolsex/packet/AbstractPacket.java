/*  1:   */ package com.gmail.tirexgta.ttoolsex.packet;
/*  2:   */ 
/*  3:   */ import com.comphenix.protocol.PacketType;
/*  4:   */ import com.comphenix.protocol.ProtocolLibrary;
/*  5:   */ import com.comphenix.protocol.ProtocolManager;
/*  6:   */ import com.comphenix.protocol.events.PacketContainer;
/*  7:   */ import com.google.common.base.Objects;
/*  8:   */ import java.lang.reflect.InvocationTargetException;
/*  9:   */ import org.bukkit.entity.Player;
/* 10:   */ 
/* 11:   */ public abstract class AbstractPacket
/* 12:   */ {
/* 13:   */   protected PacketContainer handle;
/* 14:   */   
/* 15:   */   protected AbstractPacket(PacketContainer handle, PacketType type)
/* 16:   */   {
/* 17:23 */     if (handle == null) {
/* 18:24 */       throw new IllegalArgumentException("Packet handle cannot be NULL.");
/* 19:   */     }
/* 20:25 */     if (!Objects.equal(handle.getType(), type)) {
/* 21:26 */       throw new IllegalArgumentException(
/* 22:27 */         handle.getHandle() + " is not a packet of type " + type);
/* 23:   */     }
/* 24:29 */     this.handle = handle;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public PacketContainer getHandle()
/* 28:   */   {
/* 29:37 */     return this.handle;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void sendPacket(Player receiver)
/* 33:   */   {
/* 34:   */     try
/* 35:   */     {
/* 36:47 */       ProtocolLibrary.getProtocolManager().sendServerPacket(receiver, getHandle());
/* 37:   */     }
/* 38:   */     catch (InvocationTargetException e)
/* 39:   */     {
/* 40:49 */       throw new RuntimeException("Cannot send packet.", e);
/* 41:   */     }
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void recievePacket(Player sender)
/* 45:   */   {
/* 46:   */     try
/* 47:   */     {
/* 48:60 */       ProtocolLibrary.getProtocolManager().recieveClientPacket(sender, getHandle());
/* 49:   */     }
/* 50:   */     catch (Exception e)
/* 51:   */     {
/* 52:62 */       throw new RuntimeException("Cannot recieve packet.", e);
/* 53:   */     }
/* 54:   */   }
/* 55:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.packet.AbstractPacket
 * JD-Core Version:    0.7.0.1
 */