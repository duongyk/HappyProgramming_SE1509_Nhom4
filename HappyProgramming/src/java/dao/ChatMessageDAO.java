/*
  * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0                         First Deploy<br>
 */
package dao;

import entity.ChatMessage;
import java.util.ArrayList;

/**
 * This class contains method to
 * interact with ChatMessage table in database
 * 
 * @author thangtvhe151307
 */
public interface ChatMessageDAO {
    
    /**
    * This method will insert new message into database
    * 
    * @param mes (message need to insert)
    * @return int (1 if insert success, 0 if fail)
    * @throws java.lang.Exception
    */
    
    public int insertMessage(ChatMessage mes) throws Exception ;
    
    /**
    * This method will get all message between two friend
    * 
    * @param yourId (your id)
    * @param friendId (your friend id)
    * @return ArrayList (list of message between two)
    * @throws java.lang.Exception
    */
    
    public ArrayList<ChatMessage> getListMessageThroughTwoFriendId(int yourId,int friendId) throws Exception ;
    
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
    public ArrayList<ChatMessage> get_New_MessageThroughTwoFriendId(int yourId,int friendId,int offset) throws Exception ;
}