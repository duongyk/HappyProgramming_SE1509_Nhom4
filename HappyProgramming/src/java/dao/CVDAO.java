/*
  * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
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
    * Get a particular CV in the database
    * 
    * @param uid of the mentor
    * @return CV of that mentor
    */
    public CV getMentorCV(int uid);

    /**
    * Create a new CV in the database
    * 
    * @param uid of the mentor
    * @param newCV from post data
    * 
    */
    public void insertCV(int uid, CV newCV);
    
    /**
    * Update a particular CV in the database
    * 
    * @param uid of the mentor
     * @param newCV from post data
    * @return 1 if update success, 0 if fail
    */
    public int updateCV(int uid, CV newCV);
    
    /**
    * Get all CV in the database
    * 
    * 
    * @return list of all CV
    */
    public ArrayList<CV> getAllMentorCV();
}
