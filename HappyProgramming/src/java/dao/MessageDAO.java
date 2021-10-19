/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        GiangNVT          First Deploy<br>
 */
package dao;

import entity.Message;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Rating objects in the
 * database.
 *
 * @author duongvvhe150773
 */
public interface MessageDAO {

    /**
     * Get all Rating of the user in the database
     *
     * @return a list <code>Rating</code> object
     * @throws Exception
     */
    public ArrayList<Message> getMessage() throws Exception;

    /**
     * Insert new Message into the database
     *
     * @param message
     * @throws Exception
     */
    public void insert(Message message) throws Exception;
     /**
     * Update new Message into the database
     *
     * @param id
     * @throws Exception
     */

    public void updateRead(String id) throws Exception;
 /**
     * get  Message from the database
     *
     * @param Id
     * @return 
     * @throws Exception
     */
    public Message getMessageById(String Id) throws Exception;
 /**
     * Delete  Message from the database
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;
    
    
    
    public ArrayList<Message> getUnReadMessage() throws Exception;
}
