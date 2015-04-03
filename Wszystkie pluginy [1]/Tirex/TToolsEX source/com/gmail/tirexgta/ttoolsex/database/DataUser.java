package com.gmail.tirexgta.ttoolsex.database;

import java.sql.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class DataUser extends Entry
{
    private boolean cX;
    private boolean cY;
    private boolean cZ;
    private boolean cHomeX;
    private boolean cHomeY;
    private boolean cHomeZ;
    private boolean cNick;
    private boolean cWorld;
    private boolean cMute;
    private boolean cHomeWorld;
    private boolean cFly;
    private boolean cGod;
    private boolean cMuteTime;
    private boolean cGamemode;
    private int userID;
    private int x;
    private int y;
    private int z;
    private int homeX;
    private int homeY;
    private int homeZ;
    private String nick;
    private String world;
    private String mute;
    private String homeWorld;
    private byte fly;
    private byte god;
    private long muteTime;
    private GameMode gamemode;
    private String oldNick;
    
    public DataUser(final Datasource db) {
        super(db);
    }
    
    public DataUser(final Datasource db, final ResultSet rs) throws SQLException {
        super(db);
        this.userID = rs.getInt("userID");
        this.x = rs.getInt("x");
        this.y = rs.getInt("y");
        this.z = rs.getInt("z");
        this.homeX = rs.getInt("homeX");
        this.homeY = rs.getInt("homeY");
        this.homeZ = rs.getInt("homeZ");
        this.nick = rs.getString("nick");
        this.world = rs.getString("world");
        this.mute = rs.getString("mute");
        this.homeWorld = rs.getString("homeWorld");
        this.fly = rs.getByte("fly");
        this.god = rs.getByte("god");
        this.muteTime = rs.getLong("muteTime");
        this.gamemode = GameMode.getByValue((int)rs.getByte("gamemode"));
    }
    
    @Override
    protected void setPrimary(final int id) {
        this.userID = id;
    }
    
    @Override
    public int getPrimary() {
        return this.userID;
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
    
    public String getNick() {
        return this.nick;
    }
    
    public String getWorld() {
        return this.world;
    }
    
    public String getMute() {
        return this.mute;
    }
    
    public String getHomeWorld() {
        return this.homeWorld;
    }
    
    public boolean getFly() {
        return this.fly > 0;
    }
    
    public boolean getGod() {
        return this.god > 0;
    }
    
    public long getMuteTime() {
        return this.muteTime;
    }
    
    public GameMode getGamemode() {
        return this.gamemode;
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
    
    public void setNick(final String v) {
        this.nick = v;
        this.cNick = true;
    }
    
    public void setWorld(final String v) {
        this.world = v;
        this.cWorld = true;
    }
    
    public void setMute(final String v) {
        this.mute = v;
        this.cMute = true;
    }
    
    public void setHomeWorld(final String v) {
        this.homeWorld = v;
        this.cHomeWorld = true;
    }
    
    public void setFly(final boolean v) {
        this.fly = (byte)(v ? 1 : 0);
        this.cFly = true;
    }
    
    public void setGod(final boolean v) {
        this.god = (byte)(v ? 1 : 0);
        this.cGod = true;
    }
    
    public void setMuteTime(final long v) {
        this.muteTime = v;
        this.cMuteTime = true;
    }
    
    public void setGamemode(final GameMode v) {
        this.gamemode = v;
        this.cGamemode = true;
    }
    
    @Override
    public UpdateSet prepareUpdate(final Boolean vals, final Boolean where) {
        String v = "";
        String w = "";
        final ArrayList args = new ArrayList();
        final ArrayList types = new ArrayList();
        if (vals) {
            String comma = "";
            if (this.cX) {
                this.cX = false;
                v = String.valueOf(v) + comma + "x=?";
                args.add(this.x);
                types.add(4);
                comma = ", ";
            }
            if (this.cY) {
                this.cY = false;
                v = String.valueOf(v) + comma + "y=?";
                args.add(this.y);
                types.add(4);
                comma = ", ";
            }
            if (this.cZ) {
                this.cZ = false;
                v = String.valueOf(v) + comma + "z=?";
                args.add(this.z);
                types.add(4);
                comma = ", ";
            }
            if (this.cHomeX) {
                this.cHomeX = false;
                v = String.valueOf(v) + comma + "homeX=?";
                args.add(this.homeX);
                types.add(4);
                comma = ", ";
            }
            if (this.cHomeY) {
                this.cHomeY = false;
                v = String.valueOf(v) + comma + "homeY=?";
                args.add(this.homeY);
                types.add(4);
                comma = ", ";
            }
            if (this.cHomeZ) {
                this.cHomeZ = false;
                v = String.valueOf(v) + comma + "homeZ=?";
                args.add(this.homeZ);
                types.add(4);
                comma = ", ";
            }
            if (this.cNick) {
                this.cNick = false;
                v = String.valueOf(v) + comma + "nick=?";
                args.add(this.nick);
                types.add(12);
                comma = ", ";
            }
            if (this.cWorld) {
                this.cWorld = false;
                v = String.valueOf(v) + comma + "world=?";
                args.add(this.world);
                types.add(12);
                comma = ", ";
            }
            if (this.cMute) {
                this.cMute = false;
                v = String.valueOf(v) + comma + "mute=?";
                args.add(this.mute);
                types.add(12);
                comma = ", ";
            }
            if (this.cHomeWorld) {
                this.cHomeWorld = false;
                v = String.valueOf(v) + comma + "homeWorld=?";
                args.add(this.homeWorld);
                types.add(12);
                comma = ", ";
            }
            if (this.cFly) {
                this.cFly = false;
                v = String.valueOf(v) + comma + "fly=?";
                args.add(this.fly);
                types.add(-6);
                comma = ", ";
            }
            if (this.cGod) {
                this.cGod = false;
                v = String.valueOf(v) + comma + "god=?";
                args.add(this.god);
                types.add(-6);
                comma = ", ";
            }
            if (this.cMuteTime) {
                this.cMuteTime = false;
                v = String.valueOf(v) + comma + "muteTime=?";
                args.add(this.muteTime);
                types.add(-5);
                comma = ", ";
            }
            if (this.cGamemode) {
                this.cGamemode = false;
                v = String.valueOf(v) + comma + "gamemode=?";
                args.add((byte)this.gamemode.getValue());
                types.add(-6);
            }
        }
        if (where) {
            w = "userID=?";
            args.add(this);
            types.add(4);
        }
        return new UpdateSet("users", v, w, args, types, this);
    }
    
    public Player getPlayer() {
        return Bukkit.getPlayer(this.getNick());
    }
    
    public OfflinePlayer getOfflinePlayer() {
        return Bukkit.getOfflinePlayer(this.getNick());
    }
    
    @Override
    public void insert() {
        super.insert();
        this.db.users.add(this);
        Datasource.usersByNick.put(this.nick.toLowerCase(), this);
        this.oldNick = this.nick;
    }
    
    @Override
    public void update() {
        super.update();
        if (this.cNick) {
            Datasource.usersByNick.remove(this.oldNick.toLowerCase());
            Datasource.usersByNick.put(this.nick.toLowerCase(), this);
            this.oldNick = this.nick;
        }
    }
    
    @Override
    public void delete() {
        super.delete();
        this.db.users.remove(this);
        Datasource.usersByNick.remove(this.oldNick.toLowerCase());
    }
}
