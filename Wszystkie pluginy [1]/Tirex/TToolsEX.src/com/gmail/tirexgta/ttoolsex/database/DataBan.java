/*   1:    */ package com.gmail.tirexgta.ttoolsex.database;
/*   2:    */ 
/*   3:    */ import java.sql.ResultSet;
/*   4:    */ import java.sql.SQLException;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.HashMap;
/*   7:    */ import java.util.List;
/*   8:    */ 
/*   9:    */ public class DataBan
/*  10:    */   extends Entry
/*  11:    */ {
/*  12:    */   public boolean cUser;
/*  13:    */   public boolean cReason;
/*  14:    */   public boolean cTime;
/*  15:    */   public boolean cAdmin;
/*  16:    */   public int banID;
/*  17:    */   public DataUser user;
/*  18:    */   public String reason;
/*  19:    */   public Long time;
/*  20:    */   public DataUser admin;
/*  21:    */   
/*  22:    */   public DataBan(Datasource db)
/*  23:    */   {
/*  24: 23 */     super(db);
/*  25:    */   }
/*  26:    */   
/*  27:    */   public DataBan(Datasource db, ResultSet rs)
/*  28:    */     throws SQLException
/*  29:    */   {
/*  30: 26 */     super(db);
/*  31: 27 */     this.banID = rs.getInt("ID");
/*  32: 28 */     this.user = Datasource.getUserByNick(rs.getString("Nick"));
/*  33: 29 */     this.reason = rs.getString("powod");
/*  34: 30 */     this.time = Long.valueOf(rs.getLong("time"));
/*  35:    */     
/*  36: 32 */     String adminBanString = rs.getString("admin");
/*  37: 33 */     if (adminBanString != null)
/*  38:    */     {
/*  39: 35 */       DataUser adminBan = Datasource.getUserByNick(adminBanString);
/*  40: 36 */       this.admin = adminBan;
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   protected void setPrimary(int id)
/*  45:    */   {
/*  46: 43 */     this.banID = id;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public int getPrimary()
/*  50:    */   {
/*  51: 49 */     return this.banID;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public DataUser getUser()
/*  55:    */   {
/*  56: 52 */     return this.user;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getReason()
/*  60:    */   {
/*  61: 53 */     return this.reason;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Long getTime()
/*  65:    */   {
/*  66: 54 */     return this.time;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public DataUser getAdmin()
/*  70:    */   {
/*  71: 55 */     return this.admin;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setUser(DataUser v)
/*  75:    */   {
/*  76: 56 */     this.user = v;this.cUser = true;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setReason(String v)
/*  80:    */   {
/*  81: 57 */     this.reason = v;this.cReason = true;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setTime(Long v)
/*  85:    */   {
/*  86: 58 */     this.time = v;this.cTime = true;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setAdmin(DataUser v)
/*  90:    */   {
/*  91: 59 */     this.admin = v;this.cAdmin = true;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public UpdateSet prepareUpdate(Boolean vals, Boolean where)
/*  95:    */   {
/*  96: 65 */     String v = "";
/*  97: 66 */     String w = "";
/*  98: 67 */     ArrayList<Object> args = new ArrayList();
/*  99: 68 */     ArrayList types = new ArrayList();
/* 100: 69 */     if (vals.booleanValue())
/* 101:    */     {
/* 102: 70 */       String comma = "";
/* 103: 71 */       if (this.cUser)
/* 104:    */       {
/* 105: 72 */         this.cUser = false;
/* 106: 73 */         v = v + comma + "nick=?";
/* 107: 74 */         args.add(this.user.getNick());
/* 108: 75 */         types.add(Integer.valueOf(12));
/* 109: 76 */         comma = ",";
/* 110:    */       }
/* 111: 78 */       if (this.cReason)
/* 112:    */       {
/* 113: 79 */         this.cReason = false;
/* 114: 80 */         v = v + comma + "powod=?";
/* 115: 81 */         args.add(this.reason);
/* 116: 82 */         types.add(Integer.valueOf(12));
/* 117: 83 */         comma = ",";
/* 118:    */       }
/* 119: 85 */       if (this.cTime)
/* 120:    */       {
/* 121: 86 */         this.cTime = false;
/* 122: 87 */         v = v + comma + "time=?";
/* 123: 88 */         args.add(this.time);
/* 124: 89 */         types.add(Integer.valueOf(-5));
/* 125: 90 */         comma = ",";
/* 126:    */       }
/* 127: 92 */       if (this.cAdmin)
/* 128:    */       {
/* 129: 93 */         this.cAdmin = false;
/* 130: 94 */         v = v + comma + "admin=?";
/* 131: 95 */         args.add(this.admin.getNick());
/* 132: 96 */         types.add(Integer.valueOf(12));
/* 133: 97 */         comma = ",";
/* 134:    */       }
/* 135:    */     }
/* 136:100 */     if (where.booleanValue())
/* 137:    */     {
/* 138:101 */       w = "banID=?";
/* 139:102 */       args.add(this);
/* 140:103 */       types.add(Integer.valueOf(4));
/* 141:    */     }
/* 142:105 */     return new UpdateSet("bans", v, w, args, types, this);
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void insert()
/* 146:    */   {
/* 147:111 */     super.insert();
/* 148:112 */     this.db.bans.add(this);
/* 149:113 */     this.db.bansByNick.put(this.user.getNick().toLowerCase(), this);
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void update()
/* 153:    */   {
/* 154:119 */     super.update();
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void delete()
/* 158:    */   {
/* 159:125 */     super.delete();
/* 160:126 */     this.db.bans.remove(this);
/* 161:127 */     this.db.bansByNick.remove(this.user.getNick().toLowerCase());
/* 162:    */   }
/* 163:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.database.DataBan
 * JD-Core Version:    0.7.0.1
 */