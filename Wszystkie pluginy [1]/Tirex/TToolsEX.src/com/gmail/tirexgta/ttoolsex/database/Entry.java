/*  1:   */ package com.gmail.tirexgta.ttoolsex.database;
/*  2:   */ 
/*  3:   */ public abstract class Entry
/*  4:   */ {
/*  5:   */   Datasource db;
/*  6:   */   
/*  7:   */   public Entry(Datasource db)
/*  8:   */   {
/*  9: 9 */     this.db = db;
/* 10:   */   }
/* 11:   */   
/* 12:   */   public abstract UpdateSet prepareUpdate(Boolean paramBoolean1, Boolean paramBoolean2);
/* 13:   */   
/* 14:   */   protected abstract void setPrimary(int paramInt);
/* 15:   */   
/* 16:   */   public abstract int getPrimary();
/* 17:   */   
/* 18:   */   public void insert()
/* 19:   */   {
/* 20:20 */     UpdateSet us = prepareUpdate(Boolean.valueOf(true), Boolean.valueOf(false));
/* 21:21 */     us.setQueryType(UpdateSet.QueryType.INSERT);
/* 22:22 */     this.db.queueQuery(us);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void update()
/* 26:   */   {
/* 27:27 */     UpdateSet us = prepareUpdate(Boolean.valueOf(true), Boolean.valueOf(true));
/* 28:28 */     us.setQueryType(UpdateSet.QueryType.UPDATE);
/* 29:29 */     this.db.queueQuery(us);
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void delete()
/* 33:   */   {
/* 34:34 */     UpdateSet us = prepareUpdate(Boolean.valueOf(false), Boolean.valueOf(true));
/* 35:35 */     us.setQueryType(UpdateSet.QueryType.DELETE);
/* 36:36 */     this.db.queueQuery(us);
/* 37:   */   }
/* 38:   */ }


/* Location:           C:\Users\Nala_Alan\Desktop\Inne\Pluginy\---- 3GILDIE ----\Tirex\TToolsEX.jar
 * Qualified Name:     com.gmail.tirexgta.ttoolsex.database.Entry
 * JD-Core Version:    0.7.0.1
 */