package com.gmail.tirexgta.tguildsex.mysql;

import java.util.*;
import java.sql.*;

public class DataGuildUser extends Entry
{
    Datasource data;
    public boolean cUUID;
    public boolean cNick;
    public boolean cTag;
    public boolean cNazwa;
    public boolean cRanga;
    public boolean cKills;
    public boolean cDeaths;
    public boolean cPoints;
    public int userID;
    public String nick;
    public String uuid;
    public String tag;
    public String nazwa;
    public int ranga;
    public int kills;
    public int deaths;
    public int points;
    public long lastAttack;
    public String lastAttacker;
    public List<String> teams;
    
    public DataGuildUser(final Datasource db) {
        super(db);
        this.teams = new ArrayList<String>();
    }
    
    public DataGuildUser(final Datasource db, final ResultSet rs) throws SQLException {
        super(db);
        this.teams = new ArrayList<String>();
        this.userID = rs.getInt("graczID");
        this.nick = rs.getString("nick");
        this.uuid = rs.getString("UUID");
        this.tag = rs.getString("tag");
        this.nazwa = rs.getString("nazwa");
        this.ranga = rs.getInt("ranga");
        this.kills = rs.getInt("kills");
        this.deaths = rs.getInt("deaths");
        this.points = rs.getInt("points");
        this.lastAttack = 0L;
        this.lastAttacker = "";
    }
    
    @Override
    protected void setPrimary(final int id) {
        this.userID = id;
    }
    
    @Override
    public int getPrimary() {
        return this.userID;
    }
    
    public String getUUID() {
        return this.uuid;
    }
    
    public String getNick() {
        return this.nick;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    public String getNazwa() {
        return this.nazwa;
    }
    
    public int getRanga() {
        return this.ranga;
    }
    
    public int getKills() {
        return this.kills;
    }
    
    public int getDeaths() {
        return this.deaths;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public long getLastAttack() {
        return this.lastAttack;
    }
    
    public String getLastAttacker() {
        return this.lastAttacker;
    }
    
    public List<String> getTeams() {
        return this.teams;
    }
    
    public void setUUID(final String v) {
        this.uuid = v;
        this.cUUID = true;
    }
    
    public void setNick(final String v) {
        this.nick = v;
        this.cNick = true;
    }
    
    public void setTag(final String v) {
        this.tag = v;
        this.cTag = true;
    }
    
    public void setNazwa(final String v) {
        this.nazwa = v;
        this.cNazwa = true;
    }
    
    public void setRanga(final int v) {
        this.ranga = v;
        this.cRanga = true;
    }
    
    public void setKills(final int v) {
        this.kills = v;
        this.cKills = true;
    }
    
    public void setDeaths(final int v) {
        this.deaths = v;
        this.cDeaths = true;
    }
    
    public void setPoints(final int v) {
        this.points = v;
        this.cPoints = true;
    }
    
    public void setLastAttack(final long v) {
        this.lastAttack = v;
    }
    
    public void setLastAttacker(final String v) {
        this.lastAttacker = v;
    }
    
    public void setTeams(final List<String> v) {
        this.teams = v;
    }
    
    public void addTeams(final String v) {
        if (!this.teams.contains(v)) {
            this.teams.add(v);
        }
    }
    
    @Override
    public UpdateSet prepareUpdate(final Boolean vals, final Boolean where) {
        String v = "";
        String w = "";
        final ArrayList<Object> args = new ArrayList<Object>();
        final ArrayList types = new ArrayList();
        if (vals) {
            String comma = "";
            if (this.cUUID) {
                this.cUUID = false;
                v = String.valueOf(v) + comma + "UUID=?";
                args.add(this.uuid);
                types.add(12);
                comma = ",";
            }
            if (this.cNick) {
                this.cNick = false;
                v = String.valueOf(v) + comma + "nick=?";
                args.add(this.nick);
                types.add(12);
                comma = ",";
            }
            if (this.cTag) {
                this.cTag = false;
                v = String.valueOf(v) + comma + "tag=?";
                args.add(this.tag);
                types.add(12);
                comma = ",";
            }
            if (this.cNazwa) {
                this.cNazwa = false;
                v = String.valueOf(v) + comma + "nazwa=?";
                args.add(this.nazwa);
                types.add(12);
                comma = ",";
            }
            if (this.cRanga) {
                this.cRanga = false;
                v = String.valueOf(v) + comma + "ranga=?";
                args.add(this.ranga);
                types.add(4);
                comma = ",";
            }
            if (this.cKills) {
                this.cKills = false;
                v = String.valueOf(v) + comma + "kills=?";
                args.add(this.kills);
                types.add(4);
                comma = ",";
            }
            if (this.cDeaths) {
                this.cDeaths = false;
                v = String.valueOf(v) + comma + "deaths=?";
                args.add(this.deaths);
                types.add(4);
                comma = ",";
            }
            if (this.cPoints) {
                this.cPoints = false;
                v = String.valueOf(v) + comma + "points=?";
                args.add(this.points);
                types.add(4);
                comma = ",";
            }
        }
        if (where) {
            w = "graczID=?";
            args.add(this);
            types.add(4);
        }
        return new UpdateSet("gracze_gildii", v, w, args, types, this);
    }
    
    @Override
    public void insert() {
        super.insert();
        this.db.user.add(this);
        Datasource.userByNick.put(this.getNick().toLowerCase(), this);
    }
    
    @Override
    public void update() {
        super.update();
    }
    
    @Override
    public void delete() {
        super.delete();
        this.db.user.remove(this);
        Datasource.userByNick.remove(this.getNick().toLowerCase());
    }
    
    public void deleteMap() {
        this.db.user.remove(this);
        Datasource.userByNick.remove(this.getNick().toLowerCase());
    }
}
