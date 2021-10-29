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

import context.DBContext;
import entity.ChatMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 * This class contains method to
 * interact with ChatMessage table in database
 * 
 * @author thangtvhe151307
 */
public class ChatMessageDAOImpl extends DBContext implements dao.ChatMessageDAO {
    
    /**
    * This method will insert new message into database
    * 
    * @param mes (message need to insert)
    * @return int (1 if insert success, 0 if fail)
    * @throws java.lang.Exception
    */
    @Override
    public int insertMessage(ChatMessage mes) throws Exception {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int status = 0;
        String sql = "insert into ChatMessage(fromId,toId,content,status) values(?,?,?,?)";
               
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, mes.getFromId());
            ps.setInt(2, mes.getToId());
            ps.setString(3, mes.getContent());          
            ps.setInt(4, 1);
            
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
    
    /**
    * This method will get all message between two friend
    * 
    * @param yourId (your id)
    * @param friendId (your friend id)
    * @return ArrayList (list of message between two)
    * @throws java.lang.Exception
    */
    @Override
    public ArrayList<ChatMessage> getListMessageThroughTwoFriendId(int yourId,int friendId) throws Exception {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<ChatMessage> messList = new ArrayList<>();
        String sql = "select top 1 * from [ChatMessage] where (fromId= ? and toId= ?) or (fromId= ? and toId= ?) order by dateCreated asc";
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, yourId);
            ps.setInt(2, friendId);
            ps.setInt(3, friendId);          
            ps.setInt(4, yourId);
            
            rs = getData(sql);
            
            while(rs.next()) {
                ChatMessage mess = new ChatMessage(rs.getInt("mId"),rs.getInt("fromId"),rs.getInt("toId"),rs.getString("content"),rs.getDate("dateCreated"),rs.getInt("status"));
                messList.add(mess);
            } 
            
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        
        return messList;
        
    }
    
    /**
    * This method will ignore some first messages
    * and load new message between two friend
    * 
     * @param yourId (your id)
     * @param friendId (your friend id)
     * @param offset (number of message to ignore)
     * @return ArrayList (list of message between two friend)
     * @throws java.lang.Exception
    */
    @Override
    public ArrayList<ChatMessage> getNewMessageThroughTwoFriendId(int yourId,int friendId,int offset) throws Exception {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<ChatMessage> messList = new ArrayList<>();
        String sql = "select * from [ChatMessage] where (fromId= ? and toId= ?) or (fromId= ? and toId= ?) order by dateCreated asc offset ? ROWS";
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, yourId);
            ps.setInt(2, friendId);
            ps.setInt(3, friendId);          
            ps.setInt(4, yourId);
            ps.setInt(5, offset);
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                ChatMessage mess = new ChatMessage(rs.getInt("mId"),rs.getInt("fromId"),rs.getInt("toId"),rs.getString("content"),rs.getDate("dateCreated"),rs.getInt("status"));
                messList.add(mess);
            }
        
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        
        return messList;
        
    }
    
    /**
    * This method will return latest message between two friend
    * 
     * @param yourId (your id)
     * @param friendId (your friend id)
     * @return ChatMessage (latest message between two friend)
     * @throws java.lang.Exception
    */
    @Override
    public ChatMessage getLatestMessageThroughTwoFriendId(int yourId,int friendId) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ChatMessage mess = new ChatMessage();
        String sql = "select top 1 * from [ChatMessage] where (fromId= ? and toId= ?) or (fromId= ? and toId= ?) order by dateCreated desc";
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, yourId);
            ps.setInt(2, friendId);
            ps.setInt(3, friendId);          
            ps.setInt(4, yourId);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                mess = new ChatMessage(rs.getInt("mId"),rs.getInt("fromId"),rs.getInt("toId"),rs.getString("content"),rs.getDate("dateCreated"),rs.getInt("status"));
            }
        
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        
        return mess;
    }
}
