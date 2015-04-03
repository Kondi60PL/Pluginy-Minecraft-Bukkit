package com.gmail.tirexgta.tguildsex.tags;

import java.util.*;
import com.gmail.tirexgta.tguildsex.packet.*;

public class TagManager
{
    String nick;
    HashMap<String, WrapperPlayServerScoreboardTeam> tags;
    TagListener data;
    
    public TagManager(final TagListener data, final String nick) {
        super();
        this.tags = new HashMap<String, WrapperPlayServerScoreboardTeam>();
        this.nick = nick;
        this.data = data;
    }
    
    public String getNick() {
        return this.nick;
    }
    
    public void setNick(final String v) {
        this.nick = v;
    }
    
    public HashMap<String, WrapperPlayServerScoreboardTeam> getTags() {
        return this.tags;
    }
    
    public void setTags(final HashMap<String, WrapperPlayServerScoreboardTeam> arg0) {
        this.tags = arg0;
    }
    
    public WrapperPlayServerScoreboardTeam get(final String arg0) {
        return this.tags.get(arg0.toLowerCase());
    }
    
    public void put(final String arg0, final WrapperPlayServerScoreboardTeam arg1) {
        this.tags.put(arg0.toLowerCase(), arg1);
    }
    
    public void remove(final String arg0) {
        this.tags.remove(arg0.toLowerCase());
    }
    
    public boolean isContainsKey(final String v) {
        return this.tags.containsKey(v.toLowerCase());
    }
    
    public boolean isContainsValue(final WrapperPlayServerScoreboardTeam v) {
        return this.tags.containsValue(v);
    }
    
    public void insert() {
        if (!this.data.wrapper.contains(this)) {
            this.data.wrapper.add(this);
        }
        if (!this.data.wrapperByNick.containsKey(this.nick)) {
            this.data.wrapperByNick.put(this.nick.toLowerCase(), this);
        }
    }
    
    public void delete() {
        if (this.data.wrapper.contains(this)) {
            this.data.wrapper.remove(this);
        }
        if (this.data.wrapperByNick.containsKey(this.nick)) {
            this.data.wrapperByNick.remove(this.nick.toLowerCase());
        }
    }
}
