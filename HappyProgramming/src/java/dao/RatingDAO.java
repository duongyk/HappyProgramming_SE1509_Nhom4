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

import entity.Rating;
import entity.User;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Rating objects in the
 * database.
 *
 * @author duongvvhe150773
 */
public interface RatingDAO {
    /**
     * Get all Rating of the user in the database
     *
     * @param user it is an object User
     * @return a list <code>Rating</code> object
     */
    public ArrayList<Rating> getRating(User user);
    
    /**
     * Insert new Rating into the database
     *
     * @param rating it is an object Rating
     */
    public void insert(Rating rating);
    
    /**
     * Get average rating of the Mentor
     *
     * @param mId it is an int number
     * @return a String .It is a <code>java.lang.String</code>
     */
    public String getAvgRate(int mId);
    
    /**
     * Check if Mentee has rated and commented on Mentor or not
     *
     * @param fromId is an int number
     * @param toId is an int number
     * @return a boolean value
     */
    public boolean checkDupRating(int fromId, int toId);
}
