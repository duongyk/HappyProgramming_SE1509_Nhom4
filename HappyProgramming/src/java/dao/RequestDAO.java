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
     * @param req it is a <code>Request</code> object
     * @throws Exception
     */
    public int createRequest(Request req) throws Exception;
    
    
    public ArrayList<Request> getRequestListBy_uId_And_Status(int uid, int status) throws Exception;
    
    /**
     * Get the total number of request of the user
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * 
     * @throws Exception
     */
    public int getTotalRequest(int mId) throws Exception;
    
    /**
     * Get the number of mentors of the user
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * 
     * @throws Exception
     */
    public int getTotalMentor(int mId) throws Exception;
    
    /**
     * Get the number of request with the same status of the user
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @param status it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * 
     * @throws Exception
     */
    public int getTotalRequestByStatus(int mId, int status) throws Exception;
    
    /**
     * Get the total hour of request of the user
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * 
     * @throws Exception
     */
    public int getTotalHourById(int mId) throws Exception;
    
    /**
     * Get the total hour of request of all user
     *
     * @return an <code>java.lang.Integer</code>
     * 
     * @throws Exception
     */
    public int getTotalHour() throws Exception;
    
    /**
     * Update a request
     *
     * @param req it is a <code>Request</code> object
     * @throws Exception
     */
    public void updateRequest(Request req) throws Exception;
    
    /**
     * Update status of a request
     *
     * @param rId it is a <code>java.lang.Integer</code>
     * @param status it is a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public void updateStatusRequest(int rId, int status) throws Exception;
    
    /**
     * Get request by ID
     *
     * @param rId it is a <code>java.lang.Integer</code>
     * @return a <code>Request</code> object
     * @throws Exception
     */
    public Request getRequestById(int rId) throws Exception;

    /**
     * Get request statistic
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a list of <code>java.lang.Integer</code>
     * @throws Exception
     */
    public ArrayList<Integer> getStatistic(int mId) throws Exception;
    
    /**
     * Get Request of a Mentee by page
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    public ArrayList<Request> listByMePaging(int index, int mId) throws Exception;
   
    /**
     * Get Request of a Mentee by page after Filter by Status
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param mId it is a <code>java.lang.Integer</code>
     * @param status it is a <code>java.lang.Integer</code>
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    public ArrayList<Request> listByMeFilterStatusPaging(int index, int mId, int status) throws Exception;
    
    /**
     * Get total number of Request of a Mentee by page after Filter by Status
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @param status it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public int getTotalFilterStatus(int mId, int status) throws Exception;
    
    /**
     * Get the number of request with the same status of the user
     *
     * @param mentorId it is an Integer number
     * @param status it is an Integer number
     * @return an Integer number
     * 
     * @throws Exception
     */
    public int get_Mentor_TotalRequestByStatus(int mentorId, int status) throws Exception;
}
