/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 */
package dao;

import entity.User;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Skill objects in the
 * database.
 *
 * @author
 */
public interface UserDAO {
    /**
     * Get all the User
     *
     * @return list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> getUserList() throws Exception;
    
    /**
     * Get all the Mentee listed by Name
     *
     * @return list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> getMenteeListSorted() throws Exception;
    
    /**
     * Get User by username and password
     *
     * @param xName it is a String
     * @param xPass it is a String
     * @return a User it is a <code>User</code> object
     * @throws Exception
     */
    public User getUser(String xName, String xPass) throws Exception;
    
    /**
     * Get list of User with the same role
     *
     * @param uRole it is an int number
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> getUserByRole(int uRole) throws Exception;
    
    /**
     * Get a user by his/ger ID
     *
     * @param uId it is an int number
     * @return a <code>User</code> object
     * @throws Exception
     */
    public User getUserById(int uId) throws Exception;
    
    /**
     * Check if the account existed or not
     *
     * @param xName is a String
     * @return a <code>User</code> object
     * @throws Exception
     */
    public User checkAccount(String xName) throws Exception;
    
    /**
     * Create and insert new User account into the database
     *
     * @param user it is a <code>User</code> object
     * @throws Exception
     */
    public void signUp(User user) throws Exception;
    
    /**
     * Update user information
     *
     * @param uId it is an int number
     * @param user it is a <code>User</code> object
     * @return an int number
     * @throws Exception
     */
    public int updateUserInfo(int uId, User user) throws Exception;
    
    public User getUserByEmail(String email) throws Exception;
    
    public User resetPassword(User user, String password) throws Exception;
    
    public  User changePass (String uMail, String newPass) throws Exception;
    
    public void updateUser(User user) throws Exception;
}
