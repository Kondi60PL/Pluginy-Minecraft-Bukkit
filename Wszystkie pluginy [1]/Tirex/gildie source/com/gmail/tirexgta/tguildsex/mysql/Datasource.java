package com.gmail.tirexgta.tguildsex.mysql;

import com.gmail.tirexgta.tguildsex.*;
import org.bukkit.plugin.*;
import java.util.logging.*;
import org.bukkit.entity.*;
import java.sql.*;
import java.util.*;

public class Datasource
{
    Main plugin;
    public List<DataGuild> guild;
    public HashMap<String, DataGuild> guildByTag;
    public static HashMap<String, DataGuild> guildByName;
    public static HashMap<String, Integer> guildsPozycja;
    public List<DataGuildUser> user;
    public static HashMap<String, DataGuildUser> userByNick;
    private List<UpdateSet> queue;
    private final Object queueLock;
    public static List<String> top10Players;
    public static List<String> top10Guilds;
    
    static {
        Datasource.guildByName = new HashMap<String, DataGuild>();
        Datasource.guildsPozycja = new HashMap<String, Integer>();
        Datasource.userByNick = new HashMap<String, DataGuildUser>();
    }
    
    public Datasource(final Main plugin) {
        super();
        this.guild = new ArrayList<DataGuild>();
        this.guildByTag = new HashMap<String, DataGuild>();
        this.user = new ArrayList<DataGuildUser>();
        this.queue = new ArrayList<UpdateSet>();
        this.queueLock = new Object();
        this.plugin = plugin;
        this.loadAll();
        this.loadPosition();
        this.loadTop10Guilds();
        this.loadTop10Players();
        this.plugin.getServer().getScheduler().runTaskTimerAsynchronously((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Datasource.this.saveAll();
                Datasource.this.loadPosition();
                Datasource.this.loadTop10Guilds();
                Datasource.this.loadTop10Players();
            }
        }, 600L, 600L);
    }
    
    private Connection getConnection() {
        for (int i = 0; i < 5; ++i) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                final String url = "jdbc:mysql://" + this.plugin.configManager.mysqlHost + "/" + this.plugin.configManager.mysqlDb;
                return DriverManager.getConnection(url, this.plugin.configManager.mysqlUser, this.plugin.configManager.mysqlPass);
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
                this.plugin.getLogger().log(Level.INFO, "Loading guilds...");
                Statement st = conn.createStatement();
                this.createTable(st);
                ResultSet rs = st.executeQuery("SELECT * FROM tguildsex");
                while (rs.next()) {
                    final DataGuild guild = new DataGuild(this, rs);
                    this.guild.add(guild);
                    this.guildByTag.put(guild.getTag().toLowerCase(), guild);
                    Datasource.guildByName.put(guild.getName().toLowerCase(), guild);
                }
                this.plugin.getLogger().info("Loaded " + Integer.toString(this.guild.size()) + " guilds!");
                this.plugin.getLogger().log(Level.INFO, "Loading users...");
                st = conn.createStatement();
                rs = st.executeQuery("SELECT * FROM gracze_gildii");
                while (rs.next()) {
                    final DataGuildUser user = new DataGuildUser(this, rs);
                    this.user.add(user);
                    Datasource.userByNick.put(user.getNick().toLowerCase(), user);
                }
                this.plugin.getLogger().info("Loaded " + Integer.toString(this.user.size()) + " users!");
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
    
    void load(final String player) {
        final Connection conn = this.getConnection();
        if (conn != null) {
            try {
                final Statement st = conn.createStatement();
                final ResultSet rs = st.executeQuery("SELECT * FROM gracze_gildii WHERE nick LIKE '" + player + "'");
                if (rs != null) {
                    while (rs.next()) {
                        final DataGuildUser user = new DataGuildUser(this, rs);
                        this.user.add(user);
                        Datasource.userByNick.put(user.getNick().toLowerCase(), user);
                    }
                }
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
    
    public DataGuild createGuild() {
        return new DataGuild(this);
    }
    
    public DataGuild getGuildByTag(final String tag) {
        return this.guildByTag.get(tag.toLowerCase());
    }
    
    public DataGuild getGuildByNamee(final String namet) {
        return getGuildByName(namet);
    }
    
    public static DataGuild getGuildByName(final String name) {
        return Datasource.guildByName.get(name.toLowerCase());
    }
    
    public static int getGuildPostionByTag(final String tag) {
        return Datasource.guildsPozycja.get(tag.toLowerCase());
    }
    
    public DataGuildUser createUser() {
        return new DataGuildUser(this);
    }
    
    public static DataGuildUser getUserByNick(final String nick) {
        return Datasource.userByNick.get(nick.toLowerCase());
    }
    
    public DataGuildUser getUserByNickName(final String nick) {
        return getUserByNick(nick);
    }
    
    public DataGuildUser getUserByPlayer(final Player p) {
        return getUserByNick(p.getName());
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
    
    public void loadPosition() {
        Datasource.guildsPozycja.clear();
        final Connection conn = this.getConnection();
        if (conn != null) {
            try {
                int pozycja = 1;
                final Statement st = conn.createStatement();
                final ResultSet result = st.executeQuery("SELECT * FROM tguildsex ORDER BY CAST(punkty AS DECIMAL) DESC");
                while (result.next()) {
                    Datasource.guildsPozycja.put(result.getString("tag").toLowerCase(), pozycja);
                    ++pozycja;
                }
            }
            catch (SQLException localSQLException) {
                localSQLException.printStackTrace();
            }
        }
    }
    
    public void loadTop10Players() {
        final Connection conn = this.getConnection();
        if (conn != null) {
            try {
                Datasource.top10Players = new ArrayList<String>();
                final Statement st = conn.createStatement();
                final ResultSet rs = st.executeQuery("SELECT * FROM gracze_gildii ORDER BY CAST(points AS DECIMAL) DESC LIMIT 20");
                while (rs.next()) {
                    Datasource.top10Players.add(rs.getString("nick"));
                }
            }
            catch (SQLException ex) {
                this.plugin.getLogger().log(Level.SEVERE, "CANNOT LOAD DATA!", ex);
            }
        }
    }
    
    public void loadTop10Guilds() {
        final Connection conn = this.getConnection();
        if (conn != null) {
            try {
                Datasource.top10Guilds = new ArrayList<String>();
                final Statement st = conn.createStatement();
                final ResultSet rs = st.executeQuery("SELECT * FROM tguildsex ORDER BY CAST(punkty AS DECIMAL) DESC LIMIT 20");
                while (rs.next()) {
                    Datasource.top10Guilds.add(rs.getString("tag"));
                }
            }
            catch (SQLException ex) {
                this.plugin.getLogger().log(Level.SEVERE, "CANNOT LOAD DATA!", ex);
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
    
    public List<DataGuild> getGuilds() {
        return this.guild;
    }
    
    void createTable(final Statement st) {
        try {
            st.execute("CREATE TABLE IF NOT EXISTS gracze_gildii (`graczID` int(11) NOT NULL AUTO_INCREMENT, `nick` varchar(16) DEFAULT NULL, `UUID` varchar(999) DEFAULT NULL, `tag` varchar(8) DEFAULT NULL, `nazwa` varchar(32) DEFAULT NULL, `ranga` int(1) DEFAULT NULL, `kills` int(10) DEFAULT NULL, `deaths` int(10) DEFAULT NULL, `points` int(10) DEFAULT NULL, PRIMARY KEY (`graczID`))");
            st.execute("CREATE TABLE IF NOT EXISTS tguildsex (`guildID` int(11) NOT NULL AUTO_INCREMENT, `tag` varchar(8) DEFAULT NULL, `nazwa` varchar(32) DEFAULT NULL, `world` varchar(32) DEFAULT NULL, `x` int(25) DEFAULT NULL, `y` int(25) DEFAULT NULL, `z` int(25) DEFAULT NULL, `homeX` int(25) DEFAULT NULL, `homeY` int(25) DEFAULT NULL, `homeZ` int(25) DEFAULT NULL, `promien` int(25) DEFAULT NULL, `lider` varchar(16) DEFAULT NULL, `zalozono` int(100) DEFAULT NULL, `friendlyFire` int(1) DEFAULT NULL, `maxCzlonkow` int (5) DEFAULT NULL, `czlonkowie` varchar(999) DEFAULT NULL, `mistrzowie` varchar(999) DEFAULT NULL, `sojusze` varchar(999) DEFAULT NULL, `punkty` int(10) DEFAULT NULL, `zabicia` int(10) DEFAULT NULL, `zgony` int(10) DEFAULT NULL, PRIMARY KEY (`guildID`))");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
