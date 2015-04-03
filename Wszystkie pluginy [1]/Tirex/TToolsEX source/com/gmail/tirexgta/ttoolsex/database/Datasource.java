package com.gmail.tirexgta.ttoolsex.database;

import com.gmail.tirexgta.ttoolsex.*;
import org.bukkit.plugin.*;
import java.util.logging.*;
import org.bukkit.entity.*;
import java.sql.*;
import java.util.*;

public class Datasource
{
    Main plugin;
    public List<DataUser> users;
    static HashMap<String, DataUser> usersByNick;
    List<DataBan> bans;
    HashMap<String, DataBan> bansByNick;
    private ArrayList<UpdateSet> queue;
    private final Object queueLock;
    
    static {
        Datasource.usersByNick = new HashMap<String, DataUser>();
    }
    
    public Datasource(final Main plugin) {
        super();
        this.users = new ArrayList<DataUser>();
        this.bans = new ArrayList<DataBan>();
        this.bansByNick = new HashMap<String, DataBan>();
        this.queue = new ArrayList<UpdateSet>();
        this.queueLock = new Object();
        this.plugin = plugin;
        this.loadAll();
        this.plugin.getServer().getScheduler().runTaskTimerAsynchronously((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Datasource.this.saveAll();
            }
        }, 600L, 600L);
    }
    
    private Connection getConnection() {
        for (int i = 0; i < 5; ++i) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                final String url = "jdbc:mysql://" + this.plugin.config.mysqlHost + "/" + this.plugin.config.mysqlDb;
                return DriverManager.getConnection(url, this.plugin.config.mysqlUser, this.plugin.config.mysqlPass);
            }
            catch (SQLException ex) {
                this.plugin.getLogger().log(Level.SEVERE, "CANNOT CONNECT TO DATABASE!", ex);
            }
            catch (ClassNotFoundException ex2) {
                this.plugin.getLogger().log(Level.SEVERE, "JDBC IS NOT FOUND - CANNOT CONNECT TO DATABASE!", ex2);
            }
        }
        this.plugin.getLogger().log(Level.SEVERE, "CANNOT CONNECT TO DATABASE!");
        return null;
    }
    
    private void loadAll() {
        this.plugin.getLogger().info("Connecting to database...");
        final Connection conn = this.getConnection();
        if (conn != null) {
            try {
                this.plugin.getLogger().log(Level.INFO, "Loading users...");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM users");
                while (rs.next()) {
                    final DataUser player = new DataUser(this, rs);
                    this.users.add(player);
                    Datasource.usersByNick.put(player.getNick().toLowerCase(), player);
                }
                this.plugin.getLogger().info("Loaded " + Integer.toString(this.users.size()) + " users!");
                this.plugin.getLogger().log(Level.INFO, "Loading bans...");
                st = conn.createStatement();
                rs = st.executeQuery("SELECT * FROM bans");
                while (rs.next()) {
                    final DataBan ban = new DataBan(this, rs);
                    this.bans.add(ban);
                    this.bansByNick.put(ban.getUser().getNick().toLowerCase(), ban);
                }
                this.plugin.getLogger().info("Loaded " + Integer.toString(this.bans.size()) + " bans!");
                st.close();
            }
            catch (SQLException ex) {
                this.plugin.getLogger().log(Level.SEVERE, "CANNOT LOAD DATA!", ex);
            }
            try {
                conn.close();
            }
            catch (SQLException ex2) {}
        }
    }
    
    public DataUser createUser() {
        return new DataUser(this);
    }
    
    public static DataUser getUserByNick(final String nick) {
        return Datasource.usersByNick.get(nick.toLowerCase());
    }
    
    public static DataUser getUserData(final Player player) {
        return getUserByNick(player.getName());
    }
    
    public DataBan createBan() {
        return new DataBan(this);
    }
    
    public DataBan getBanData(final String nick) {
        return this.bansByNick.get(nick.toLowerCase());
    }
    
    public DataBan getBanData(final Player player) {
        return this.getBanData(player.getName());
    }
    
    protected void queueQuery(final UpdateSet query) {
        synchronized (this.queueLock) {
            this.queue.add(query);
        }
        // monitorexit(this.queueLock)
    }
    
    public void saveAll() {
        UpdateSet[] queries;
        synchronized (this.queueLock) {
            queries = new UpdateSet[this.queue.size()];
            queries = this.queue.toArray(queries);
            this.queue.clear();
        }
        // monitorexit(this.queueLock)
        if (queries.length > 0) {
            final Connection conn = this.getConnection();
            UpdateSet[] array;
            for (int length = (array = queries).length, i = 0; i < length; ++i) {
                final UpdateSet us = array[i];
                String query = "";
                try {
                    if (us.getQueryType() == UpdateSet.QueryType.INSERT) {
                        query = "INSERT INTO " + us.getTable() + " SET " + us.getValues();
                    }
                    else if (us.getQueryType() == UpdateSet.QueryType.UPDATE) {
                        query = "UPDATE " + us.getTable() + " SET " + us.getValues() + " WHERE " + us.getWhere();
                    }
                    else {
                        query = "DELETE FROM " + us.getTable() + " WHERE " + us.getWhere();
                    }
                    PreparedStatement st = conn.prepareStatement(query);
                    this.vals(st, us.getArgs(), us.getTypes());
                    st.executeUpdate();
                    st.close();
                    if (us.getQueryType() == UpdateSet.QueryType.INSERT && us.getEntry() != null) {
                        st = conn.prepareStatement("SELECT last_insert_id() as id");
                        final ResultSet rs = st.executeQuery();
                        rs.next();
                        us.getEntry().setPrimary(rs.getInt(1));
                        rs.close();
                        st.close();
                    }
                }
                catch (SQLException ex) {
                    String vs = "";
                    String comma = "";
                    for (final Object p : us.getArgs()) {
                        vs = String.valueOf(vs) + comma + p.toString();
                        comma = ", ";
                    }
                    this.plugin.getLogger().log(Level.SEVERE, "Problem while save data; query: " + query + "; wartosci: " + vs, ex);
                }
            }
        }
    }
    
    private void vals(final PreparedStatement st, final List<Object> args, final List<Integer> types) throws SQLException {
        for (int i = 0; i < args.size(); ++i) {
            final Object o = args.get(i);
            final int t = types.get(i);
            if (o != null) {
                if (o instanceof Entry) {
                    final Entry e = (Entry)o;
                    st.setObject(i + 1, e.getPrimary(), t);
                }
                else {
                    st.setObject(i + 1, o, t);
                }
            }
            else {
                st.setNull(i + 1, t);
            }
        }
    }
}
