package com.gmail.tirexgta.tguildsex.mysql;

import java.util.*;

public class UpdateSet
{
    private String table;
    private String vals;
    private String where;
    private List<Object> args;
    private List<Integer> types;
    private QueryType qtype;
    private Entry entry;
    
    public UpdateSet(final String table, final String vals, final String where, final List<Object> list, final List<Integer> list2, final Entry entry) {
        super();
        this.table = table;
        this.vals = vals;
        this.where = where;
        this.args = list;
        this.types = list2;
        this.entry = entry;
    }
    
    public String getTable() {
        return this.table;
    }
    
    public String getValues() {
        return this.vals;
    }
    
    public String getWhere() {
        return this.where;
    }
    
    public List<Object> getArgs() {
        return this.args;
    }
    
    public List<Integer> getTypes() {
        return this.types;
    }
    
    public QueryType getQueryType() {
        return this.qtype;
    }
    
    public void setQueryType(final QueryType qtype) {
        this.qtype = qtype;
    }
    
    public Entry getEntry() {
        return this.entry;
    }
    
    public enum QueryType
    {
        INSERT("INSERT", 0), 
        UPDATE("UPDATE", 1), 
        DELETE("DELETE", 2);
    }
}
