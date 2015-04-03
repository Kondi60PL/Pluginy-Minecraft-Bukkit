package com.gmail.tirexgta.tguildsex.mysql;

import java.sql.*;
import java.util.*;

public class DataGuild extends Entry
{
    Datasource data;
    public boolean cTag;
    public boolean cNazwa;
    public boolean cWorld;
    public boolean cX;
    public boolean cY;
    public boolean cZ;
    public boolean cHomeX;
    public boolean cHomeY;
    public boolean cHomeZ;
    public boolean cPromien;
    public boolean cLider;
    public boolean cZalozono;
    public boolean cFriendlyFire;
    public boolean cMaxCzlonkow;
    public boolean cCzlonkowie;
    public boolean cMistrzowie;
    public boolean cSojusze;
    public boolean cPunkty;
    public boolean cZabicia;
    public boolean cZgony;
    public int guildID;
    public String tag;
    public String nazwa;
    public String world;
    public int x;
    public int y;
    public int z;
    public int homeX;
    public int homeY;
    public int homeZ;
    public int promien;
    public String lider;
    public long zalozono;
    public int friendlyFire;
    public int maxCzlonkow;
    public List<String> czlonkowie;
    public List<String> mistrzowie;
    public List<String> sojusze;
    public int punkty;
    public int zabicia;
    public int zgony;
    public long lastExplode;
    public List<String> zaproszaniaSojusze;
    
    public DataGuild(final Datasource db) {
        super(db);
        this.czlonkowie = new ArrayList<String>();
        this.mistrzowie = new ArrayList<String>();
        this.sojusze = new ArrayList<String>();
        this.zaproszaniaSojusze = new ArrayList<String>();
    }
    
    public DataGuild(final Datasource db, final ResultSet rs) throws SQLException {
        super(db);
        this.czlonkowie = new ArrayList<String>();
        this.mistrzowie = new ArrayList<String>();
        this.sojusze = new ArrayList<String>();
        this.zaproszaniaSojusze = new ArrayList<String>();
        this.guildID = rs.getInt("guildID");
        this.tag = rs.getString("tag");
        this.nazwa = rs.getString("nazwa");
        this.world = rs.getString("world");
        this.x = rs.getInt("x");
        this.y = rs.getInt("y");
        this.z = rs.getInt("z");
        this.homeX = rs.getInt("homeX");
        this.homeY = rs.getInt("homeY");
        this.homeZ = rs.getInt("homeZ");
        this.promien = rs.getInt("promien");
        this.lider = rs.getString("lider");
        this.zalozono = rs.getLong("zalozono");
        this.friendlyFire = rs.getInt("friendlyFire");
        this.maxCzlonkow = rs.getInt("maxCzlonkow");
        final String czlonkowie = rs.getString("czlonkowie");
        if (czlonkowie != null) {
            String[] split;
            for (int length = (split = czlonkowie.split(",")).length, i = 0; i < length; ++i) {
                final String player = split[i];
                if (!player.equals("")) {
                    this.czlonkowie.add(player);
                }
            }
        }
        final String mistrzowie = rs.getString("mistrzowie");
        if (mistrzowie != null) {
            String[] split2;
            for (int length2 = (split2 = mistrzowie.split(",")).length, j = 0; j < length2; ++j) {
                final String player2 = split2[j];
                if (!player2.equals("")) {
                    this.mistrzowie.add(player2);
                }
            }
        }
        final String sojusze = rs.getString("sojusze");
        if (sojusze != null) {
            String[] split3;
            for (int length3 = (split3 = sojusze.split(",")).length, k = 0; k < length3; ++k) {
                final String player3 = split3[k];
                if (!player3.equals("")) {
                    this.sojusze.add(player3);
                }
            }
        }
        this.punkty = rs.getInt("punkty");
        this.zabicia = rs.getInt("zabicia");
        this.zgony = rs.getInt("zgony");
    }
    
    @Override
    protected void setPrimary(final int id) {
        this.guildID = id;
    }
    
    @Override
    public int getPrimary() {
        return this.guildID;
    }
    
    public String getTag() {
        return this.tag;
    }
    
    public String getName() {
        return this.nazwa;
    }
    
    public String getWorld() {
        return this.world;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getZ() {
        return this.z;
    }
    
    public int getHomeX() {
        return this.homeX;
    }
    
    public int getHomeY() {
        return this.homeY;
    }
    
    public int getHomeZ() {
        return this.homeZ;
    }
    
    public int getPromien() {
        return this.promien;
    }
    
    public String getLider() {
        return this.lider;
    }
    
    public long getZalozono() {
        return this.zalozono;
    }
    
    public int getFriendlyFire() {
        return this.friendlyFire;
    }
    
    public int getMaxCzlonkow() {
        return this.maxCzlonkow;
    }
    
    public List<String> getCzlonkowie() {
        return this.czlonkowie;
    }
    
    public List<String> getMistrzowie() {
        return this.mistrzowie;
    }
    
    public List<String> getSojusze() {
        return this.sojusze;
    }
    
    public int getPunkty() {
        return this.punkty;
    }
    
    public int getZabicia() {
        return this.zabicia;
    }
    
    public int getZgony() {
        return this.zgony;
    }
    
    public long getLastExplode() {
        return this.lastExplode;
    }
    
    public List<String> getZaproszeniaSojusze() {
        return this.zaproszaniaSojusze;
    }
    
    public void setTag(final String v) {
        this.tag = v;
        this.cTag = true;
    }
    
    public void setName(final String v) {
        this.nazwa = v;
        this.cNazwa = true;
    }
    
    public void setWorld(final String v) {
        this.world = v;
        this.cWorld = true;
    }
    
    public void setX(final int v) {
        this.x = v;
        this.cX = true;
    }
    
    public void setY(final int v) {
        this.y = v;
        this.cY = true;
    }
    
    public void setZ(final int v) {
        this.z = v;
        this.cZ = true;
    }
    
    public void setHomeX(final int v) {
        this.homeX = v;
        this.cHomeX = true;
    }
    
    public void setHomeY(final int v) {
        this.homeY = v;
        this.cHomeY = true;
    }
    
    public void setHomeZ(final int v) {
        this.homeZ = v;
        this.cHomeZ = true;
    }
    
    public void setPromien(final int v) {
        this.promien = v;
        this.cPromien = true;
    }
    
    public void setLider(final String v) {
        this.lider = v;
        this.cLider = true;
    }
    
    public void setZalozono(final long v) {
        this.zalozono = v;
        this.cZalozono = true;
    }
    
    public void setFriendlyFire(final int v) {
        this.friendlyFire = v;
        this.cFriendlyFire = true;
    }
    
    public void setMaxCzlonkow(final int v) {
        this.maxCzlonkow = v;
        this.cMaxCzlonkow = true;
    }
    
    public void setCzlonkowie(final List<String> v) {
        this.czlonkowie = v;
        this.cCzlonkowie = true;
    }
    
    public void setMistrzowie(final List<String> v) {
        this.mistrzowie = v;
        this.cMistrzowie = true;
    }
    
    public void setSojusze(final List<String> v) {
        this.sojusze = v;
        this.cSojusze = true;
    }
    
    public void setPunkty(final int v) {
        this.punkty = v;
        this.cPunkty = true;
    }
    
    public void setZabicia(final int v) {
        this.zabicia = v;
        this.cZabicia = true;
    }
    
    public void setZgony(final int v) {
        this.zgony = v;
        this.cZgony = true;
    }
    
    public void setLastExplode(final long v) {
        this.lastExplode = v;
    }
    
    public void setZaproszeniaSojusze(final List<String> v) {
        this.zaproszaniaSojusze = v;
    }
    
    public void addCzlonkowie(final String v) {
        if (!this.czlonkowie.contains(v)) {
            this.czlonkowie.add(v);
        }
        this.cCzlonkowie = true;
    }
    
    public void addMistrzowie(final String v) {
        if (!this.mistrzowie.contains(v)) {
            this.mistrzowie.add(v);
        }
        this.cMistrzowie = true;
    }
    
    public void addSojusze(final String v) {
        if (!this.sojusze.contains(v)) {
            this.sojusze.add(v);
        }
        this.cSojusze = true;
    }
    
    public void addZaproszeniaSojusze(final String v) {
        if (!this.zaproszaniaSojusze.contains(v)) {
            this.zaproszaniaSojusze.add(v);
        }
    }
    
    public void removeCzlonkowie(final String v) {
        if (this.czlonkowie.contains(v)) {
            this.czlonkowie.remove(v);
        }
        this.cCzlonkowie = true;
    }
    
    public void removeMistrzowie(final String v) {
        if (this.mistrzowie.contains(v)) {
            this.mistrzowie.remove(v);
        }
        this.cMistrzowie = true;
    }
    
    public void removeSojusze(final String v) {
        if (this.sojusze.contains(v)) {
            this.sojusze.remove(v);
        }
        this.cSojusze = true;
    }
    
    public void removeZaproszeniaSojusze(final String v) {
        if (this.zaproszaniaSojusze.contains(v)) {
            this.zaproszaniaSojusze.remove(v);
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
            if (this.cWorld) {
                this.cWorld = false;
                v = String.valueOf(v) + comma + "world=?";
                args.add(this.world);
                types.add(12);
                comma = ",";
            }
            if (this.cX) {
                this.cX = false;
                v = String.valueOf(v) + comma + "x=?";
                args.add(this.x);
                types.add(4);
                comma = ",";
            }
            if (this.cY) {
                this.cY = false;
                v = String.valueOf(v) + comma + "y=?";
                args.add(this.y);
                types.add(4);
                comma = ",";
            }
            if (this.cZ) {
                this.cZ = false;
                v = String.valueOf(v) + comma + "z=?";
                args.add(this.z);
                types.add(4);
                comma = ",";
            }
            if (this.cHomeX) {
                this.cHomeX = false;
                v = String.valueOf(v) + comma + "homeX=?";
                args.add(this.homeX);
                types.add(4);
                comma = ",";
            }
            if (this.cHomeY) {
                this.cHomeY = false;
                v = String.valueOf(v) + comma + "homeY=?";
                args.add(this.homeY);
                types.add(4);
                comma = ",";
            }
            if (this.cHomeZ) {
                this.cHomeZ = false;
                v = String.valueOf(v) + comma + "homeZ=?";
                args.add(this.homeZ);
                types.add(4);
                comma = ",";
            }
            if (this.cPromien) {
                this.cPromien = false;
                v = String.valueOf(v) + comma + "promien=?";
                args.add(this.promien);
                types.add(4);
                comma = ",";
            }
            if (this.cLider) {
                this.cLider = false;
                v = String.valueOf(v) + comma + "lider=?";
                args.add(this.lider);
                types.add(12);
                comma = ",";
            }
            if (this.cZalozono) {
                this.cZalozono = false;
                v = String.valueOf(v) + comma + "zalozono=?";
                args.add(this.zalozono);
                types.add(4);
                comma = ",";
            }
            if (this.cFriendlyFire) {
                this.cFriendlyFire = false;
                v = String.valueOf(v) + comma + "friendlyfire=?";
                args.add(this.friendlyFire);
                types.add(4);
                comma = ",";
            }
            if (this.cMaxCzlonkow) {
                this.cMaxCzlonkow = false;
                v = String.valueOf(v) + comma + "maxCzlonkow=?";
                args.add(this.maxCzlonkow);
                types.add(4);
                comma = ",";
            }
            if (this.cCzlonkowie) {
                final StringBuilder sbCzlonkowie = new StringBuilder();
                int ilosc = 1;
                for (final String player : this.czlonkowie) {
                    if (ilosc == this.czlonkowie.size()) {
                        sbCzlonkowie.append(player);
                    }
                    else {
                        sbCzlonkowie.append(player).append(",");
                    }
                    ++ilosc;
                }
                this.cCzlonkowie = false;
                v = String.valueOf(v) + comma + "czlonkowie=?";
                args.add(sbCzlonkowie.toString());
                types.add(12);
                comma = ",";
            }
            if (this.cMistrzowie) {
                final StringBuilder sbMistrzowie = new StringBuilder();
                int ilosc = 1;
                for (final String player : this.mistrzowie) {
                    if (ilosc == this.mistrzowie.size()) {
                        sbMistrzowie.append(player);
                    }
                    else {
                        sbMistrzowie.append(player).append(",");
                    }
                    ++ilosc;
                }
                this.cMistrzowie = false;
                v = String.valueOf(v) + comma + "mistrzowie=?";
                args.add(sbMistrzowie.toString());
                types.add(12);
                comma = ",";
            }
            if (this.cSojusze) {
                final StringBuilder sbSojusze = new StringBuilder();
                int ilosc = 1;
                for (final String player : this.sojusze) {
                    if (ilosc == this.sojusze.size()) {
                        sbSojusze.append(player);
                    }
                    else {
                        sbSojusze.append(player).append(",");
                    }
                    ++ilosc;
                }
                this.cSojusze = false;
                v = String.valueOf(v) + comma + "sojusze=?";
                args.add(sbSojusze.toString());
                types.add(12);
                comma = ",";
            }
            if (this.cPunkty) {
                this.cPunkty = false;
                v = String.valueOf(v) + comma + "punkty=?";
                args.add(this.punkty);
                types.add(4);
                comma = ",";
            }
            if (this.cZabicia) {
                this.cZabicia = false;
                v = String.valueOf(v) + comma + "zabicia=?";
                args.add(this.zabicia);
                types.add(4);
                comma = ",";
            }
            if (this.cZgony) {
                this.cZgony = false;
                v = String.valueOf(v) + comma + "zgony=?";
                args.add(this.zgony);
                types.add(4);
                comma = ",";
            }
        }
        if (where) {
            w = "guildID=?";
            args.add(this);
            types.add(4);
        }
        return new UpdateSet("tguildsex", v, w, args, types, this);
    }
    
    @Override
    public void insert() {
        super.insert();
        this.db.guild.add(this);
        this.db.guildByTag.put(this.getTag().toLowerCase(), this);
        Datasource.guildByName.put(this.getName().toLowerCase(), this);
    }
    
    @Override
    public void update() {
        super.update();
    }
    
    @Override
    public void delete() {
        super.delete();
        this.db.guild.remove(this);
        this.db.guildByTag.remove(this.getTag().toLowerCase());
        Datasource.guildByName.remove(this.getName().toLowerCase());
    }
}
