/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        GiangNVT          First Deploy<br>
 */
package dao.impl;

import context.DBContext;
import entity.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author solov
 */
public class MessageDAOImpl extends DBContext implements dao.MessageDAO {

    @Override
    public ArrayList<Message> getMessage() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        /* Prepared statement for executing sql queries */
        ResultSet rs = null;/* Result set returned by the sqlserver */

        ArrayList<Message> listMessages = new ArrayList<>();
        String sql = "SELECT  * FROM [PRJ_SWP].[dbo].[Message]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listMessages.add(new Message(rs.getInt("mId"), rs.getString("title"), rs.getString("email"), rs.getString("content"), rs.getString("isRead")));
            }
        } catch (SQLException e) {
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }

        return (listMessages);

    }

    /**
     * Get Messages have email like txtSearch from the database
     *
     * @param txtSearch
     * @return a list <code>Rating</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Message> searchMessage(String txtSearch) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //get informations from database
        ArrayList<Message> listMessages = new ArrayList<>();
        String sql = "select * from [Message] where email like ?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                listMessages.add(new Message(rs.getInt("mId"), rs.getString("title"), rs.getString("email"), rs.getString("content"), rs.getString("isRead")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return listMessages;
    }

    @Override
    public ArrayList<Message> getUnReadMessage() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        /* Prepared statement for executing sql queries */
        ResultSet rs = null;/* Result set returned by the sqlserver */

        ArrayList<Message> listMessages = new ArrayList<>();
        String sql = "SELECT  * FROM [PRJ_SWP].[dbo].[Message] where [isRead] = '0'";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listMessages.add(new Message(rs.getInt("mId"), rs.getString("title"), rs.getString("email"), rs.getString("content"), rs.getString("isRead")));
            }
        } catch (SQLException e) {
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }

        return (listMessages);

    }

    @Override
    public void insert(Message message) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [Message] VALUES (?,?,?,0)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, message.getTitle());
            ps.setString(2, message.getEmail());
            ps.setString(3, message.getContent());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public Message getMessageById(String Id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Message message = new Message();
        String sql = "select * from [Message] where mId=" + Id;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                message.setmId(rs.getInt("mId"));
                message.setTitle(rs.getString("title"));
                message.setEmail(rs.getString("email"));
                message.setContent(rs.getString("content"));
                message.setIsRead("1");
            }

        } catch (Exception e) {
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);

        }
        return message;
    }

    @Override
    public void updateRead(String id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " UPDATE [Message] SET [isRead] = ?  WHERE [mId] = ?";
        try {
            //get informations from database
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "1");
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public void delete(String id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM [Message]\n"
                + " WHERE mId = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }
}
