/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        DuongVV          First Deploy<br>
 */
package dao;

import entity.Request;
import entity.User;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Request objects in the
 * database.
 *
 * @author duongvvhe150773
 */
public interface RequestDAO {
    /**
     * Get all Request of the user in the database
     *
     * @param user it is an <code>User</code> object
     * @return a list <code>Request</code> object
     * @throws Exception
     */
    public ArrayList<Request> getListByMe(User user) throws Exception;
    
    /**
     * Insert new request into the database
     *
     * @param req it is an <code>Request</code> object
     * @throws Exception
     */
    public int createRequest(Request req) throws Exception;
    
    public ArrayList<Request> getRequestListBy_Id_And_Status(int uid, int status) throws Exception;
    
    
    
}
