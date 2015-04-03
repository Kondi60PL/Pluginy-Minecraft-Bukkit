/*   1:    */ package com.gmail.tirexgta.ttoolsex.database;
/*   2:    */ 
/*   3:    */ import java.sql.ResultSet;
/*   4:    */ import java.sql.SQLException;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.HashMap;
/*   7:    */ import java.util.List;
/*   8:    */ import org.bukkit.Bukkit;
/*   9:    */ import org.bukkit.GameMode;
/*  10:    */ import org.bukkit.OfflinePlayer;
/*  11:    */ import org.bukkit.entity.Player;
/*  12:    */ 
/*  13:    */ public class DataUser
/*  14:    */   extends Entry
/*  15:    */ {
/*  16:    */   private boolean cX;
/*  17:    */   private boolean cY;
/*  18:    */   private boolean cZ;
/*  19:    */   private boolean cHomeX;
/*  20:    */   private boolean cHomeY;
/*  21:    */   private boolean cHomeZ;
/*  22:    */   private boolean cNick;
/*  23:    */   private boolean cWorld;
/*  24:    */   private boolean cMute;
/*  25:    */   private boolean cHomeWorld;
/*  26:    */   private boolean cFly;
/*  27:    */   private boolean cGod;
/*  28:    */   private boolean cMuteTime;
/*  29:    */   private boolean cGamemode;
/*  30:    */   private int userID;
/*  31:    */   private int x;
/*  32:    */   private int y;
/*  33:    */   private int z;
/*  34:    */   private int homeX;
/*  35:    */   private int homeY;
/*  36:    */   private int homeZ;
/*  37:    */   private String nick;
/*  38:    */   private String world;
/*  39:    */   private String mute;
/*  40:    */   private String homeWorld;
/*  41:    */   private byte fly;
/*  42:    */   private byte god;
/*  43:    */   private long muteTime;
/*  44:    */   private GameMode gamemode;
/*  45:    */   private String oldNick;
/*  46:    */   
/*  47:    */   public DataUser(Datasource db)
/*  48:    */   {
/*  49: 47 */     super(db);
/*  50:    */   }
/*  51:    */   
/*  52:    */   public DataUser(Datasource db, ResultSet rs)
/*  53:    */     throws SQLException
/*  54:    */   {
/*  55: 53 */     super(db);
/*  56: 54 */     this.userID = rs.getInt("userID");
/*  57: 55 */     this.x = rs.getInt("x");
/*  58: 56 */     this.y = rs.getInt("y");
/*  59: 57 */     this.z = rs.getInt("z");
/*  60: 58 */     this.homeX = rs.getInt("homeX");
/*  61: 59 */     this.homeY = rs.getInt("homeY");
/*  62: 60 */     this.homeZ = rs.getInt("homeZ");
/*  63: 61 */     this.nick = rs.getString("nick");
/*  64: 62 */     this.world = rs.getString("world");
/*  65: 63 */     this.mute = rs.getString("mute");
/*  66: 64 */     this.homeWorld = rs.getString("homeWorld");
/*  67: 65 */     this.fly = rs.getByte("fly");
/*  68: 66 */     this.god = rs.getByte("god");
/*  69: 67 */     this.muteTime = rs.getLong("muteTime");
/*  70: 68 */     this.gamemode = GameMode.getByValue(rs.getByte("gamemode"));
/*  71:    */   }
/*  72:    */   
/*  73:    */   protected void setPrimary(int id)
/*  74:    */   {
/*  75: 74 */     this.userID = id;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public int getPrimary()
/*  79:    */   {
/*  80: 80 */     return this.userID;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public int getX()
/*  84:    */   {
/*  85: 83 */     return this.x;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public int getY()
/*  89:    */   {
/*  90: 84 */     return this.y;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public int getZ()
/*  94:    */   {
/*  95: 85 */     return this.z;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public int getHomeX()
/*  99:    */   {
/* 100: 86 */     return this.homeX;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public int getHomeY()
/* 104:    */   {
/* 105: 87 */     return this.homeY;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public int getHomeZ()
/* 109:    */   {
/* 110: 88 */     return this.homeZ;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getNick()
/* 114:    */   {
/* 115: 89 */     return this.nick;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public String getWorld()
/* 119:    */   {
/* 120: 90 */     return this.world;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getMute()
/* 124:    */   {
/* 125: 91 */     return this.mute;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String getHomeWorld()
/* 129:    */   {
/* 130: 92 */     return this.homeWorld;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public boolean getFly()
/* 134:    */   {
/* 135: 93 */     return this.fly > 0;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public boolean getGod()
/* 139:    */   {
/* 140: 94 */     return this.god > 0;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public long getMuteTime()
/* 144:    */   {
/* 145: 95 */     return this.muteTime;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public GameMode getGamemode()
/* 149:    */   {
/* 150: 96 */     return this.gamemode;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setX(int v)
/* 154:    */   {
/* 155: 97 */     this.x = v;this.cX = true;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setY(int v)
/* 159:    */   {
/* 160: 98 */     this.y = v;this.cY = true;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setZ(int v)
/* 164:    */   {
/* 165: 99 */     this.z = v;this.cZ = true;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setHomeX(int v)
/* 169:    */   {
/* 170:100 */     this.homeX = v;this.cHomeX = true;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setHomeY(int v)
/* 174:    */   {
/* 175:101 */     this.homeY = v;this.cHomeY = true;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setHomeZ(int v)
/* 179:    */   {
/* 180:102 */     this.homeZ = v;this.cHomeZ = true;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setNick(String v)
/* 184:    */   {
/* 185:103 */     this.nick = v;this.cNick = true;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setWorld(String v)
/* 189:    */   {
/* 190:104 */     this.world = v;this.cWorld = true;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setMute(String v)
/* 194:    */   {
/* 195:105 */     this.mute = v;this.cMute = true;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setHomeWorld(String v)
/* 199:    */   {
/* 200:106 */     this.homeWorld = v;this.cHomeWorld = true;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void setFly(boolean v)
/* 204:    */   {
/* 205:107 */     this.fly = ((byte)(v ? 1 : 0));this.cFly = true;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public void setGod(boolean v)
/* 209:    */   {
/* 210:108 */     this.god = ((byte)(v ? 1 : 0));this.cGod = true;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public void setMuteTime(long v)
/* 214:    */   {
/* 215:109 */     this.muteTime = v;this.cMuteTime = true;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setGamemode(GameMode v)
/* 219:    */   {
/* 220:110 */     this.gamemode = v;this.cGamemode = true;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public UpdateSet prepareUpdate(Boolean vals, Boolean where)
/* 224:    */   {
/* 225:116 */     String v = "";
/* 226:117 */     String w = "";
/* 227:118 */     ArrayList args = new ArrayList();
/* 228:119 */     ArrayList types = new ArrayList();
/* 229:120 */     if (vals.booleanValue())
/* 230:    */     {
/* 231:122 */       String comma = "";
/* 232:123 */       if (this.cX)
/* 233:    */       {
/* 234:125 */         this.cX = false;
/* 235:126 */         v = v + comma + "x=?";
/* 236:127 */         args.add(Integer.valueOf(this.x));
/* 237:128 */         types.add(Integer.valueOf(4));
/* 238:129 */         comma = ", ";
/* 239:    */       }
/* 240:131 */       if (this.cY)
/* 241:    */       {
/* 242:133 */         this.cY = false;
/* 243:134 */         v = v + comma + "y=?";
/* 244:135 */         args.add(Integer.valueOf(this.y));
/* 245:136 */         types.add(Integer.valueOf(4));
/* 246:137 */         comma = ", ";
/* 247:    */       }
/* 248:139 */       if (this.cZ)
/* 249:    */       {
/* 250:141 */         this.cZ = false;
/* 251:142 */         v = v + comma + "z=?";
/* 252:143 */         args.add(Integer.valueOf(this.z));
/* 253:144 */         types.add(Integer.valueOf(4));
/* 254:145 */         comma = ", ";
/* 255:    */       }
/* 256:147 */       if (this.cHomeX)
/* 257:    */       {
/* 258:149 */         this.cHomeX = false;
/* 259:150 */         v = v + comma + "homeX=?";
/* 260:151 */         args.add(Integer.valueOf(this.homeX));
/* 261:152 */         types.add(Integer.valueOf(4));
/* 262:153 */         comma = ", ";
/* 263:    */       }
/* 264:155 */       if (this.cHomeY)
/* 265:    */       {
/* 266:157 */         this.cHomeY = false;
/* 267:158 */         v = v + comma + "homeY=?";
/* 268:159 */         args.add(Integer.valueOf(this.homeY));
/* 269:160 */         types.add(Integer.valueOf(4));
/* 270:161 */         comma = ", ";
/* 271:    */       }
/* 272:163 */       if (this.cHomeZ)
/* 273:    */       {
/* 274:165 */         this.cHomeZ = false;
/* 275:166 */         v = v + comma + "homeZ=?";
/* 276:167 */         args.add(Integer.valueOf(this.homeZ));
/* 277:168 */         types.add(Integer.valueOf(4));
/* 278:169 */         comma = ", ";
/* 279:    */       }
/* 280:171 */       if (this.cNick)
/* 281:    */       {
/* 282:173 */         this.cNick = false;
/* 283:174 */         v = v + comma + "nick=?";
/* 284:175 */         args.add(this.nick);
/* 285:176 */         types.add(Integer.valueOf(12));
/* 286:177 */         comma = ", ";
/* 287:    */       }
/* 288:179 */       if (this.cWorld)
/* 289:    */       {
/* 290:181 */         this.cWorld = false;
/* 291:182 */         v = v + comma + "world=?";
/* 292:183 */         args.add(this.world);
/* 293:184 */         types.add(Integer.valueOf(12));
/* 294:185 */         comma = ", ";
/* 295:    */       }
/* 296:187 */       if (this.cMute)
/* 297:    */       {
/* 298:189 */         this.cMute = false;
/* 299:190 */         v = v + comma + "mute=?";
/* 300:191 */         args.add(this.mute);
/* 301:192 */         types.add(Integer.valueOf(12));
/* 302:193 */         comma = ", ";
/* 303:    */       }
/* 304:195 */       if (this.cHomeWorld)
/* 305:    */       {
/* 306:197 */         this.cHomeWorld = false;
/* 307:198 */         v = v + comma + "homeWorld=?";
/* 308:199 */         args.add(this.homeWorld);
/* 309:200 */         types.add(Integer.valueOf(12));
/* 310:201 */         comma = ", ";
/* 311:    */       }
/* 312:203 */       if (this.cFly)
/* 313:    */       {
/* 314:205 */         this.cFly = false;
/* 315:206 */         v = v + comma + "fly=?";
/* 316:207 */         args.add(Byte.valueOf(this.fly));
/* 317:208 */         types.add(Integer.valueOf(-6));
/* 318:209 */         comma = ", ";
/* 319:    */       }
/* 320:211 */       if (this.cGod)
/* 321:    */       {
/* 322:213 */         this.cGod = false;
/* 323:214 */         v = v + comma + "god=?";
/* 324:215 */         args.add(Byte.valueOf(this.god));
/* 325:216 */         types.add(Integer.valueOf(-6));
/* 326:217 */         comma = ", ";
/* 327:    */       }
/* 328:219 */       if (this.cMuteTime)
/* 329:    */       {
/* 330:221 */         this.cMuteTime = false;
/* 331:222 */         v = v + comma + "muteTime=?";
/* 332:223 */         args.add(Long.valueOf(this.muteTime));
/* 333:224 */         types.add(Integer.valueOf(-5));
/* 334:225 */         comma = ", ";
/* 335:    */       }
/* 336:227 */       if (this.cGamemode)
/* 337:    */       {
/* 338:229 */         this.cGamemode = false;
/* 339:230 */         v = v + comma + "gamemode=?";
/* 340:231 */         args.add(Byte.valueOf((byte)this.gamemode.getValue()));
/* 341:232 */         types.add(Integer.valueOf(-6));
/* 342:    */       }
/* 343:    */     }
/* 344:235 */     if (where.booleanValue())
/* 345:    */     {
/* 346:237 */       w = "userID=?";
/* 347:238 */       args.add(this);
/* 348:239 */       types.add(Integer.valueOf(4));
/* 349:    */     }
/* 350:241 */     return new UpdateSet("users", v, w, args, types, this);
/* 351:    */   }
/* 352:    */   
/* 353:    */   public Player getPlayer()
/* 354:    */   {
/* 355:248 */     return Bukkit.getPlayer(getNick());
/* 356:    */   }
/* 357:    */   
/* 358:    */   public OfflinePlayer getOfflinePlayer()
/* 359:    */   {
/* 360:253 */     return Bukkit.getOfflinePlayer(getNick());
/* 361:    */   }
/* 362:    */   
/* 363:    */   public void insert()
/* 364:    */   {
/* 365:259 */     super.insert();
/* 366:260 */     this.db.users.add(this);
/* 367:261 */     Datasource.usersByNick.put(this.nick.toLowerCase(), this);
/* 368:262 */     this.oldNick = this.nick;
/* 369:    */   }
/* 370:    */   
/* 371:    */   public void update()
/* 372:    */   {
/* 373:268 */     super.update();
/* 374:269 */     if (this.cNick)
/* 375:    */     {
/* 376:271 */       Datasource.usersByNick.remove(this.oldNick.toLowerCase());
/* 377:272 */       Datasource.usersByNick.put(this.nick.toLowerCase(), this);
/* 378:273 */       this.oldNick = this.nick;
/* 379:    */     }
/* 380:    */   }
/* 381:    */   
/* 382:    */   public void delete()
/* 383:    */   {
/* 384:280 */     super.delete();
/* 385:281 */     this.db.users.remove(this);
/* 386:282 */     Datasource.usersByNick.remove(this.oldNick.toLowerCase());
/* 387:    */   }
/* 388:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.database.DataUser
 * JD-Core Version:    0.7.0.1
 */