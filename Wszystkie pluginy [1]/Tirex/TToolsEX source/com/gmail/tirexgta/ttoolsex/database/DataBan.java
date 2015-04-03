package com.gmail.tirexgta.ttoolsex.database;

import java.sql.*;
import java.util.*;

public class DataBan extends Entry
{
    public boolean cUser;
    public boolean cReason;
    public boolean cTime;
    public boolean cAdmin;
    public int banID;
    public DataUser user;
    public String reason;
    public Long time;
    public DataUser admin;
    
    public DataBan(final Datasource db) {
        super(db);
    }
    
    public DataBan(final Datasource db, final ResultSet rs) throws SQLException {
        super(db);
        this.banID = rs.getInt("ID");
        this.user = Datasource.getUserByNick(rs.getString("Nick"));
        this.reason = rs.getString("powod");
        this.time = rs.getLong("time");
        final String adminBanString = rs.getString("admin");
        if (adminBanString != null) {
            final DataUser adminBan = Datasource.getUserByNick(adminBanString);
            this.admin = adminBan;
        }
    }
    
    @Override
    protected void setPrimary(final int id) {
        this.banID = id;
    }
    
    @Override
    public int getPrimary() {
        return this.banID;
    }
    
    public DataUser getUser() {
        return this.user;
    }
    
    public String getReason() {
        return this.reason;
    }
    
    public Long getTime() {
        return this.time;
    }
    
    public DataUser getAdmin() {
        return this.admin;
    }
    
    public void setUser(final DataUser v) {
        this.user = v;
        this.cUser = true;
    }
    
    public void setReason(final String v) {
        this.reason = v;
        this.cReason = true;
    }
    
    public void setTime(final Long v) {
        this.time = v;
        this.cTime = true;
    }
    
    public void setAdmin(final DataUser v) {
        this.admin = v;
        this.cAdmin = true;
    }
    
    @Override
    public UpdateSet prepareUpdate(final Boolean vals, final Boolean where) {
        String v = "";
        String w = "";
        final ArrayList<Object> args = new ArrayList<Object>();
        final ArrayList types = new ArrayList();
        if (vals) {
            String comma = "";
            if (this.cUser) {
                this.cUser = false;
                v = String.valueOf(v) + comma + "nick=?";
                args.add(this.user.getNick());
                types.add(12);
                comma = ",";
            }
            if (this.cReason) {
                this.cReason = false;
                v = String.valueOf(v) + comma + "powod=?";
                args.add(this.reason);
                types.add(12);
                comma = ",";
            }
            if (this.cTime) {
                this.cTime = false;
                v = String.valueOf(v) + comma + "time=?";
                args.add(this.time);
                types.add(-5);
                comma = ",";
            }
            if (this.cAdmin) {
                this.cAdmin = false;
                v = String.valueOf(v) + comma + "admin=?";
                args.add(this.admin.getNick());
                types.add(12);
                comma = ",";
            }
        }
        if (where) {
            w = "banID=?";
            args.add(this);
            types.add(4);
        }
        return new UpdateSet("bans", v, w, args, types, this);
    }
    
    @Override
    public void insert() {
        super.insert();
        this.db.bans.add(this);
        this.db.bansByNick.put(this.user.getNick().toLowerCase(), this);
    }
    
    @Override
    public void update() {
        super.update();
    }
    
    @Override
    public void delete() {
        super.delete();
        this.db.bans.remove(this);
        this.db.bansByNick.remove(this.user.getNick().toLowerCase());
    }
}
