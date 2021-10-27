/*
  * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0                         First Deploy<br>
 */
package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import context.DBContext;
import java.sql.Connection;

/**
 * This class contain method to interact with
 * ChatFriend table in database
 * 
 * 
 * @author thangtvhe151307
 */
public class ChatFriendDAOImpl extends DBContext implements dao.ChatFriendDAO {

    /**
    * This method will get all your chat friend id from database
    * 
     * @param yourId (your id)
     * @return ArrayList (list of your friend id)
     * @throws java.lang.Exception
    */
    @Override
    public ArrayList<Integer> getYourChatFriendId(int yourId) throws Exception {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Integer> idList = new ArrayList();
        
        String sql = "select friendId from ChatFriend where uId= ?";
               
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,yourId);
            
            rs = ps.executeQuery();
            
            int friendId = 0;
            
            while(rs.next()) {
                friendId=rs.getInt("friendId");
                idList.add(friendId);
            }
            
            ps.close();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        
        return idList;
    }
    
    /**
    * This method will check someone id
    * If they are not your chat friend yet the method
    * will add their id into ChatFriend table
    * 
     * @param yourId (your id)
     * @param friendId (friend id you want to chat)
     * @return int (1 if add chat friend success, 0 if fail)
     * @throws java.lang.Exception
    */
    @Override
    public int checkIf_NotFriendYet_ToAdd(int yourId, int friendId) throws Exception {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int status = 0;
        
        String sql = "If Not Exists(select * from ChatFriend where [uId]=? and friendId=?) \n" +
                        " Begin\n" +
                        " insert into ChatFriend values (?,?);\n" +
                        " insert into ChatFriend values (?,?);\n" +
                        " End";
               
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1,yourId);
            ps.setInt(2, friendId);
            
            ps.setInt(3, yourId);
            ps.setInt(4, friendId);
            
            ps.setInt(5, friendId);
            ps.setInt(6, yourId);
            
            status = ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        
        return status;
    }
}
