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
 * This class contains methods to help us manipulate Messaging objects in the
 * database.
 *
 * @author giangnvthe150748
 */
public interface MessageDAO {

    /**
     * Get all Message of all user in the database
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
     * get Message from the database
     *
     * @param Id
     * @return Message
     * @throws Exception
     */
    public Message getMessageById(String Id) throws Exception;

    /**
     * Delete Message from the database
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     * Get Unread Message from the database
     *
     * @return a list <code>Rating</code> object
     * @throws Exception
     */
    public ArrayList<Message> getUnReadMessage() throws Exception;

    /**
     * Get Messages have email like txtSearch from the database
     *
     * @param txtSearch
     * @return a list <code>Rating</code> object
     * @throws Exception
     */
    public ArrayList<Message> searchMessage(String txtSearch) throws Exception;

    /**
     * Paging Message
     *
     * @param index is an int number
     * @return a list <code>Message</code> object
     */
    public ArrayList<Message> pagingMessage(int index);
}
