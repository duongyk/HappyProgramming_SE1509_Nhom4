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
    
    
    public ArrayList<Request> getRequestListBy_uId_And_Status(int uid, int status) throws Exception;
    
    /**
     * Get the total number of request of the user
     *
     * @param mId it is an Integer number
     * @return an Integer number
     * 
     * @throws Exception
     */
    public int getTotalRequest(int mId) throws Exception;
    
    /**
     * Get the number of mentors of the user
     *
     * @param mId it is an Integer number
     * @return an Integer number
     * 
     * @throws Exception
     */
    public int getTotalMentor(int mId) throws Exception;
    
    /**
     * Get the number of request with the same status of the user
     *
     * @param mId it is an Integer number
     * @param status it is an Integer number
     * @return an Integer number
     * 
     * @throws Exception
     */
    public int getTotalRequestByStatus(int mId, int status) throws Exception;
    
    /**
     * Get the total hour of request of the user
     *
     * @param mId it is an Integer number
     * @return an Integer number
     * 
     * @throws Exception
     */
    public int getTotalHourById(int mId) throws Exception;
    
    /**
     * Get the total hour of request of all user
     *
     * @return an Integer number
     * 
     * @throws Exception
     */
    public int getTotalHour() throws Exception;
    
    /**
     * Update a request
     *
     * @param req it is an <code>Request</code> object
     * @throws Exception
     */
    public void updateRequest(Request req) throws Exception;
    
    /**
     * Update status of a request
     *
     * @param rId it is an Integer number
     * @param status it is an Integer number
     * @throws Exception
     */
    public void updateStatusRequest(int rId, int status) throws Exception;
    
    /**
     * Get request by ID
     *
     * @param rId it is an <code>Request</code> object
     * @return a <code>Request</code> object
     * @throws Exception
     */
    public Request getRequestById(int rId) throws Exception;

    /**
     * Get request statistic
     *
     * @param mId it is an Integer number
     * @return a list of Integer number
     * @throws Exception
     */
    public ArrayList<Integer> getStatistic(int mId) throws Exception;
    
    /**
     * Get Request of a Mentee by page
     *
     * @param index it is an Integer number
     * @param mId it is an Integer number
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    public ArrayList<Request> listByMePaging(int index, int mId) throws Exception;
    
    /**
     * Get Request of a Mentee by page after Filter by Skill
     *
     * @param index it is an Integer number
     * @param mId it is an Integer number
     * @param sId it is an Integer number
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    public ArrayList<Request> listByMeFilterSkillPaging(int index, int mId, int sId) throws Exception;
    
    /**
     * Get total number of Request of a Mentee by page after Filter by Skill
     *
     * @param mId it is an Integer number
     * @param sId it is an Integer number
     * @return a Integer number
     * @throws Exception
     */
    public int getTotalFilterSkill(int mId, int sId) throws Exception;
    
    /**
     * Get Request of a Mentee by page after Filter by Status
     *
     * @param index it is an Integer number
     * @param mId it is an Integer number
     * @param status it is an Integer number
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    public ArrayList<Request> listByMeFilterStatusPaging(int index, int mId, int status) throws Exception;
    
    /**
     * Get total number of Request of a Mentee by page after Filter by Status
     *
     * @param mId it is an Integer number
     * @param status it is an Integer number
     * @return a Integer number
     * @throws Exception
     */
    public int getTotalFilterStatus(int mId, int status) throws Exception;
    
    /**
     * Get Request of a Mentee by page after Filter by Skill and Status
     *
     * @param index it is an Integer number
     * @param mId it is an Integer number
     * @param sId it is an Integer number
     * @param status it is an Integer number
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    public ArrayList<Request> listByMeFilterPaging(int index, int mId, int sId, int status) throws Exception;
    
    /**
     * Get total number of Request of a Mentee by page after Filter by Skill and Status
     *
     * @param mId it is an Integer number
     * @param sId it is an Integer number
     * @param status it is an Integer number
     * @return a Integer number
     * @throws Exception
     */
    public int getTotalFilter(int mId,int sId, int status) throws Exception;
}
