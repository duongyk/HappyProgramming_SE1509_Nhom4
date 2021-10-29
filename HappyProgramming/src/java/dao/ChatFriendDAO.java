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

import java.util.ArrayList;

/**
 * This class contain method to interact with
 * ChatFriend table in database
 * 
 * 
 * @author thangtvhe151307
 */
public interface ChatFriendDAO {
    
    /**
    * This method will get all your chat friend id from database
    * 
     * @param yourId (your id)
     * @return ArrayList (list of your friend id)
     * @throws java.lang.Exception
    */
    
    public ArrayList<Integer> getYourChatFriendId(int yourId) throws Exception ;
    
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
    
    public int checkIfNotFriendYetToAdd(int yourId, int friendId) throws Exception ;    
}
