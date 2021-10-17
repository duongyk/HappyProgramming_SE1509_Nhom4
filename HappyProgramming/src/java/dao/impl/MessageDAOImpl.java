/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.DBContext;
import entity.Message;
import entity.Rating;
import entity.User;
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

    public static void main(String[] args) throws Exception {
        MessageDAOImpl dao = new MessageDAOImpl();
        ArrayList<Message> list = new ArrayList<>();
        dao.insert(new Message("JOJO", "GNV@gmail.com", "PumaNi"));
        list = dao.getMessage();
        for (Message message : list) {
            System.out.println(message);
        }
        Message mess = dao.getMessageById("3");
        dao.updateRead("3");
        System.out.println(mess.toString());
    }

}
