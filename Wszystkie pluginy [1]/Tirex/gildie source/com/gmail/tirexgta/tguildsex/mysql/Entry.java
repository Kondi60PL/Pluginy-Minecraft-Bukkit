package com.gmail.tirexgta.tguildsex.mysql;

public abstract class Entry
{
    Datasource db;
    
    public Entry(final Datasource db) {
        super();
        this.db = db;
    }
    
    public abstract UpdateSet prepareUpdate(final Boolean p0, final Boolean p1);
    
    protected abstract void setPrimary(final int p0);
    
    public abstract int getPrimary();
    
    public void insert() {
        final UpdateSet us = this.prepareUpdate(true, false);
        us.setQueryType(UpdateSet.QueryType.INSERT);
        this.db.queueQuery(us);
    }
    
    public void update() {
        final UpdateSet us = this.prepareUpdate(true, true);
        us.setQueryType(UpdateSet.QueryType.UPDATE);
        this.db.queueQuery(us);
    }
    
    public void delete() {
        final UpdateSet us = this.prepareUpdate(false, true);
        us.setQueryType(UpdateSet.QueryType.DELETE);
        this.db.queueQuery(us);
    }
}
