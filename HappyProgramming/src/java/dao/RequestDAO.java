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
     * @param user it is an object User
     * @return a list <code>Request</code> object
     */
    public ArrayList<Request> getListByMe(User user);
    
    /**
     *
     *
     * @param 
     * @return 
     */
    public int createRequest(Request req);
}
