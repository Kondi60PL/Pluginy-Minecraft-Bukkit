/*  1:   */ package com.gmail.tirexgta.ttoolsex.database;
/*  2:   */ 
/*  3:   */ import java.util.List;
/*  4:   */ 
/*  5:   */ public class UpdateSet
/*  6:   */ {
/*  7:   */   private String table;
/*  8:   */   private String vals;
/*  9:   */   private String where;
/* 10:   */   private List<Object> args;
/* 11:   */   private List<Integer> types;
/* 12:   */   private QueryType qtype;
/* 13:   */   private Entry entry;
/* 14:   */   
/* 15:   */   public UpdateSet(String table, String vals, String where, List<Object> list, List<Integer> list2, Entry entry)
/* 16:   */   {
/* 17:17 */     this.table = table;
/* 18:18 */     this.vals = vals;
/* 19:19 */     this.where = where;
/* 20:20 */     this.args = list;
/* 21:21 */     this.types = list2;
/* 22:22 */     this.entry = entry;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getTable()
/* 26:   */   {
/* 27:25 */     return this.table;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getValues()
/* 31:   */   {
/* 32:26 */     return this.vals;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String getWhere()
/* 36:   */   {
/* 37:27 */     return this.where;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public List<Object> getArgs()
/* 41:   */   {
/* 42:28 */     return this.args;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public List<Integer> getTypes()
/* 46:   */   {
/* 47:29 */     return this.types;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public QueryType getQueryType()
/* 51:   */   {
/* 52:30 */     return this.qtype;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setQueryType(QueryType qtype)
/* 56:   */   {
/* 57:31 */     this.qtype = qtype;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public Entry getEntry()
/* 61:   */   {
/* 62:32 */     return this.entry;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public static enum QueryType
/* 66:   */   {
/* 67:33 */     INSERT,  UPDATE,  DELETE;
/* 68:   */   }
/* 69:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.database.UpdateSet
 * JD-Core Version:    0.7.0.1
 */