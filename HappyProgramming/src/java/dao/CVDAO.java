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

import entity.CV;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public interface CVDAO {
    
    /**
    * Delete a particular CV in the database
    * 
    * @param uid of the mentor
    * @return number of rows deleted (expected 1)
    * @throws Exception
    */
    public int deleteCV(int uid) throws Exception ;
    
    /**
    * Get a particular CV in the database
    * 
    * @param uid of the mentor
    * @return CV of that mentor
    * @throws Exception
    */
    public CV getMentorCV(int uid) throws Exception;

    /**
    * Create a new CV in the database
    * 
    * @param uid of the mentor
    * @param newCV from post data
    * @throws Exception
    */
    public void insertCV(int uid, CV newCV) throws Exception;
    
    /**
    * Update a particular CV in the database
    * 
    * @param uid of the mentor
    * @param newCV from post data
    * @return 1 if update success, 0 if fail
    * @throws Exception
    */
    public int updateCV(int uid, CV newCV) throws Exception ;
    
    /**
    * Get all CV in the database
    * 
    * @return list of all CV
    * @throws Exception
    */
    public ArrayList<CV> getAllMentorCV() throws Exception ;  
}
