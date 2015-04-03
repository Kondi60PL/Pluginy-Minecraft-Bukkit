/*   1:    */ package com.gmail.tirexgta.ttoolsex.database;
/*   2:    */ 
/*   3:    */ import com.gmail.tirexgta.ttoolsex.Main;
/*   4:    */ import com.gmail.tirexgta.ttoolsex.others.Config;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.DriverManager;
/*   7:    */ import java.sql.PreparedStatement;
/*   8:    */ import java.sql.ResultSet;
/*   9:    */ import java.sql.SQLException;
/*  10:    */ import java.sql.Statement;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ import java.util.HashMap;
/*  13:    */ import java.util.Iterator;
/*  14:    */ import java.util.List;
/*  15:    */ import java.util.logging.Level;
/*  16:    */ import java.util.logging.Logger;
/*  17:    */ import org.bukkit.Server;
/*  18:    */ import org.bukkit.entity.Player;
/*  19:    */ import org.bukkit.scheduler.BukkitScheduler;
/*  20:    */ 
/*  21:    */ public class Datasource
/*  22:    */ {
/*  23:    */   Main plugin;
/*  24: 23 */   public List<DataUser> users = new ArrayList();
/*  25: 24 */   static HashMap<String, DataUser> usersByNick = new HashMap();
/*  26: 25 */   List<DataBan> bans = new ArrayList();
/*  27: 26 */   HashMap<String, DataBan> bansByNick = new HashMap();
/*  28: 28 */   private ArrayList<UpdateSet> queue = new ArrayList();
/*  29: 29 */   private final Object queueLock = new Object();
/*  30:    */   
/*  31:    */   public Datasource(Main plugin)
/*  32:    */   {
/*  33: 33 */     this.plugin = plugin;
/*  34: 34 */     loadAll();
/*  35: 35 */     this.plugin.getServer().getScheduler().runTaskTimerAsynchronously(this.plugin, new Runnable()
/*  36:    */     {
/*  37:    */       public void run()
/*  38:    */       {
/*  39: 40 */         Datasource.this.saveAll();
/*  40:    */       }
/*  41: 42 */     }, 600L, 600L);
/*  42:    */   }
/*  43:    */   
/*  44:    */   private Connection getConnection()
/*  45:    */   {
/*  46: 47 */     for (int i = 0; i < 5; i++) {
/*  47:    */       try
/*  48:    */       {
/*  49: 51 */         Class.forName("com.mysql.jdbc.Driver");
/*  50: 52 */         String url = "jdbc:mysql://" + this.plugin.config.mysqlHost + "/" + this.plugin.config.mysqlDb;
/*  51: 53 */         return DriverManager.getConnection(url, this.plugin.config.mysqlUser, this.plugin.config.mysqlPass);
/*  52:    */       }
/*  53:    */       catch (SQLException ex)
/*  54:    */       {
/*  55: 55 */         this.plugin.getLogger().log(Level.SEVERE, "CANNOT CONNECT TO DATABASE!", ex);
/*  56:    */       }
/*  57:    */       catch (ClassNotFoundException ex)
/*  58:    */       {
/*  59: 57 */         this.plugin.getLogger().log(Level.SEVERE, "JDBC IS NOT FOUND - CANNOT CONNECT TO DATABASE!", ex);
/*  60:    */       }
/*  61:    */     }
/*  62: 60 */     this.plugin.getLogger().log(Level.SEVERE, "CANNOT CONNECT TO DATABASE!");
/*  63: 61 */     return null;
/*  64:    */   }
/*  65:    */   
/*  66:    */   private void loadAll()
/*  67:    */   {
/*  68: 66 */     this.plugin.getLogger().info("Connecting to database...");
/*  69: 67 */     Connection conn = getConnection();
/*  70: 68 */     if (conn != null)
/*  71:    */     {
/*  72:    */       try
/*  73:    */       {
/*  74: 72 */         this.plugin.getLogger().log(Level.INFO, "Loading users...");
/*  75: 73 */         Statement st = conn.createStatement();
/*  76: 74 */         ResultSet rs = st.executeQuery("SELECT * FROM users");
/*  77: 75 */         while (rs.next())
/*  78:    */         {
/*  79: 77 */           DataUser player = new DataUser(this, rs);
/*  80: 78 */           this.users.add(player);
/*  81: 79 */           usersByNick.put(player.getNick().toLowerCase(), player);
/*  82:    */         }
/*  83: 81 */         this.plugin.getLogger().info("Loaded " + Integer.toString(this.users.size()) + " users!");
/*  84: 82 */         this.plugin.getLogger().log(Level.INFO, "Loading bans...");
/*  85: 83 */         st = conn.createStatement();
/*  86: 84 */         rs = st.executeQuery("SELECT * FROM bans");
/*  87: 85 */         while (rs.next())
/*  88:    */         {
/*  89: 87 */           DataBan ban = new DataBan(this, rs);
/*  90: 88 */           this.bans.add(ban);
/*  91: 89 */           this.bansByNick.put(ban.getUser().getNick().toLowerCase(), ban);
/*  92:    */         }
/*  93: 91 */         this.plugin.getLogger().info("Loaded " + Integer.toString(this.bans.size()) + " bans!");
/*  94: 92 */         st.close();
/*  95:    */       }
/*  96:    */       catch (SQLException ex)
/*  97:    */       {
/*  98: 94 */         this.plugin.getLogger().log(Level.SEVERE, "CANNOT LOAD DATA!", ex);
/*  99:    */       }
/* 100:    */       try
/* 101:    */       {
/* 102: 96 */         conn.close();
/* 103:    */       }
/* 104:    */       catch (SQLException localSQLException1) {}
/* 105:    */     }
/* 106:    */   }
/* 107:    */   
/* 108:    */   public DataUser createUser()
/* 109:    */   {
/* 110:104 */     return new DataUser(this);
/* 111:    */   }
/* 112:    */   
/* 113:    */   public static DataUser getUserByNick(String nick)
/* 114:    */   {
/* 115:109 */     return (DataUser)usersByNick.get(nick.toLowerCase());
/* 116:    */   }
/* 117:    */   
/* 118:    */   public static DataUser getUserData(Player player)
/* 119:    */   {
/* 120:114 */     return getUserByNick(player.getName());
/* 121:    */   }
/* 122:    */   
/* 123:    */   public DataBan createBan()
/* 124:    */   {
/* 125:121 */     return new DataBan(this);
/* 126:    */   }
/* 127:    */   
/* 128:    */   public DataBan getBanData(String nick)
/* 129:    */   {
/* 130:126 */     return (DataBan)this.bansByNick.get(nick.toLowerCase());
/* 131:    */   }
/* 132:    */   
/* 133:    */   public DataBan getBanData(Player player)
/* 134:    */   {
/* 135:131 */     return getBanData(player.getName());
/* 136:    */   }
/* 137:    */   
/* 138:    */   protected void queueQuery(UpdateSet query)
/* 139:    */   {
/* 140:138 */     synchronized (this.queueLock)
/* 141:    */     {
/* 142:140 */       this.queue.add(query);
/* 143:    */     }
/* 144:    */   }
/* 145:    */   
/* 146:    */   public void saveAll()
/* 147:    */   {
/* 148:147 */     synchronized (this.queueLock)
/* 149:    */     {
/* 150:149 */       UpdateSet[] queries = new UpdateSet[this.queue.size()];
/* 151:150 */       queries = (UpdateSet[])this.queue.toArray(queries);
/* 152:151 */       this.queue.clear();
/* 153:    */     }
/* 154:    */     UpdateSet[] queries;
/* 155:153 */     if (queries.length > 0)
/* 156:    */     {
/* 157:155 */       Connection conn = getConnection();
/* 158:156 */       for (UpdateSet us : queries)
/* 159:    */       {
/* 160:158 */         String query = "";
/* 161:    */         try
/* 162:    */         {
/* 163:161 */           if (us.getQueryType() == UpdateSet.QueryType.INSERT) {
/* 164:163 */             query = "INSERT INTO " + us.getTable() + " SET " + us.getValues();
/* 165:165 */           } else if (us.getQueryType() == UpdateSet.QueryType.UPDATE) {
/* 166:167 */             query = "UPDATE " + us.getTable() + " SET " + us.getValues() + " WHERE " + us.getWhere();
/* 167:    */           } else {
/* 168:171 */             query = "DELETE FROM " + us.getTable() + " WHERE " + us.getWhere();
/* 169:    */           }
/* 170:173 */           PreparedStatement st = conn.prepareStatement(query);
/* 171:174 */           vals(st, us.getArgs(), us.getTypes());
/* 172:175 */           st.executeUpdate();
/* 173:176 */           st.close();
/* 174:178 */           if ((us.getQueryType() == UpdateSet.QueryType.INSERT) && (us.getEntry() != null))
/* 175:    */           {
/* 176:180 */             st = conn.prepareStatement("SELECT last_insert_id() as id");
/* 177:181 */             ResultSet rs = st.executeQuery();
/* 178:182 */             rs.next();
/* 179:183 */             us.getEntry().setPrimary(rs.getInt(1));
/* 180:184 */             rs.close();
/* 181:185 */             st.close();
/* 182:    */           }
/* 183:    */         }
/* 184:    */         catch (SQLException ex)
/* 185:    */         {
/* 186:190 */           String vs = "";
/* 187:191 */           String comma = "";
/* 188:192 */           for (Iterator<Object> i$ = us.getArgs().iterator(); i$.hasNext();)
/* 189:    */           {
/* 190:194 */             Object p = i$.next();
/* 191:195 */             vs = vs + comma + p.toString();
/* 192:196 */             comma = ", ";
/* 193:    */           }
/* 194:198 */           this.plugin.getLogger().log(Level.SEVERE, "Problem while save data; query: " + query + "; wartosci: " + vs, ex);
/* 195:    */         }
/* 196:    */       }
/* 197:    */     }
/* 198:    */   }
/* 199:    */   
/* 200:    */   private void vals(PreparedStatement st, List<Object> args, List<Integer> types)
/* 201:    */     throws SQLException
/* 202:    */   {
/* 203:206 */     for (int i = 0; i < args.size(); i++)
/* 204:    */     {
/* 205:208 */       Object o = args.get(i);
/* 206:209 */       int t = ((Integer)types.get(i)).intValue();
/* 207:210 */       if (o != null)
/* 208:    */       {
/* 209:212 */         if ((o instanceof Entry))
/* 210:    */         {
/* 211:214 */           Entry e = (Entry)o;
/* 212:215 */           st.setObject(i + 1, Integer.valueOf(e.getPrimary()), t);
/* 213:    */         }
/* 214:    */         else
/* 215:    */         {
/* 216:219 */           st.setObject(i + 1, o, t);
/* 217:    */         }
/* 218:    */       }
/* 219:    */       else {
/* 220:224 */         st.setNull(i + 1, t);
/* 221:    */       }
/* 222:    */     }
/* 223:    */   }
/* 224:    */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.database.Datasource
 * JD-Core Version:    0.7.0.1
 */