/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * This class configurate to connect data from database
 *
 * @author 
 */
public class DBContext {

    /**
     * DBContext initial
     */
    private InitialContext initial;
    /**
     * DBContext context
     */
    private Context context;
    /**
     * DBContext dbName
     */
    private String dbName;
    /**
     * DBContext serverName
     */
    private String serverName;
    /**
     * DBContext portNumber
     */
    private String portNumber;
    /**
     * DBContext image
     */
    private String image;
    /**
     * DBContext username
     */
    private String username;
    /**
     * DBContext password
     */
    private String password;

    /**
     * Constructor
     */
    public DBContext() {
        try {
            this.initial = new InitialContext();
            this.context = (Context) initial.lookup("java:comp/env");
            this.serverName = context.lookup("localhost").toString();
            this.dbName = context.lookup("PRJ_SWP").toString();
            this.portNumber = context.lookup("1433").toString();
            this.username = context.lookup("sa").toString();
            this.password = context.lookup("sa").toString();
            this.image = context.lookup("imagePath").toString();
        } catch (NamingException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get connection of your database
     *
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        //String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ_SWP";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, "sa", "sa");
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param ps it is a object of <code>java.sql.PreparedStatement</code>
     * @throws Exception
     */
    public void closePreparedStatement(PreparedStatement ps) throws Exception {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param con it is a object of <code>java.sql.Connection</code>
     * @throws Exception
     */
    public void closeConnection(Connection con) throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param rs it is a object of <code>java.sql.ResultSet</code>
     * @throws Exception
     */
    public void closeResultSet(ResultSet rs) throws Exception {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * Get path of image store in file context
     *
     * @return path of image
     * @throws Exception
     */
    public String getImagePath() throws Exception {
        return image;
    }

}

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class DBContext {
//
//    public Connection connection;
//
//    public DBContext() {
//        try {
//            //Change the username password and url to connect your own database
//            String username = "sa";
//            String password = "sa";
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ_SWP";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
