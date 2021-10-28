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
     * @param xName it is a <code>java.lang.String</code>
     * @param xPass it is a <code>java.lang.String</code>
     * @return a User it is a <code>User</code> object
     * @throws Exception
     */
    public User getUser(String xName, String xPass) throws Exception;

    /**
     * Get list of User with the same role
     *
     * @param uRole it is a <code>java.lang.Integer</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> getUserByRole(int uRole) throws Exception;

    /**
     * Get a user by his/ger ID
     *
     * @param uId it is a <code>java.lang.Integer</code>
     * @return a <code>User</code> object
     * @throws Exception
     */
    public User getUserById(int uId) throws Exception;

    /**
     * Check if the account existed or not
     *
     * @param xName is a <code>java.lang.String</code>
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
     * @param uId it is a <code>java.lang.Integer</code>
     * @param user it is a <code>User</code> object
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public int updateUserInfo(int uId, User user) throws Exception;

    /**
     * Update user information
     *
     * @param email it is a <code>java.lang.String</code>
     * @return a <code>User</code> object
     * @throws Exception
     */
    public User getUserByEmail(String email) throws Exception;

    /**
     * Get user and reset that user password in database
     *
     * @param user it is a <code>User</code> object
     * @param password it is a <code>java.lang.String</code>
     * @return a <code>User</code> object
     * @throws Exception
     */
    public User resetPassword(User user, String password) throws Exception;

    public User changePass(String uMail, String newPass) throws Exception;

    /**
     * Update user information into database
     *
     * @param user it is a <code>User</code> object
     * @throws Exception
     */
    public void updateUser(User user) throws Exception;

    /**
     * Get list of User with the same role by page
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param uRole it is a <code>java.lang.Integer</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> getUserByRolePaging(int index, int uRole) throws Exception;

    /**
     * Get list of User with the same role by page after Filter by name
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param uRole it is a <code>java.lang.Integer</code>
     * @param name it is a <code>java.lang.String</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> getUserByRoleFilterPaging(int index, int uRole, String name) throws Exception;

    /**
     * Get total number of User with the same role Filter by name
     *
     * @param uRole it is a <code>java.lang.Integer</code>
     * @param name it is a <code>java.lang.String</code>
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public int getTotalFilterName(int uRole, String name) throws Exception;

    /**
     * Get list Mentor sorted by total number of Skill
     *
     * @return list of <code>User</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<User> getTopMentorByTotalSkill() throws Exception;

    /**
     * Get top Mentor by their Rating
     *
     * @return list of <code>User</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<User> getTopMentorByRate() throws Exception;

    /**
     * Get all Mentor that teach Skill which User have in Request
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return list of <code>User</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<User> getSuggestedMentor(int mId) throws Exception;

    /**
     * Get total number of User
     *
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public int getMaxUser() throws Exception;

    public int getTotalFilterSkill(int uRole, int sId) throws Exception;

    /**
     * Get list of Mentee with the username like txtSearch
     *
     * @param txtSearch
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> searchMentee(String txtSearch) throws Exception;

    /**
     * Update user's Status by user's id
     *
     * @param user it is a <code>User</code> object
     * @param status it is a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public void updateUserStatusById(User user, int status) throws Exception;

    /**
     * Get list of User with the same role by page and sorted by fullname
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param uRole it is a <code>java.lang.Integer</code>
     * @return a list of <code>User</code> object
     * @throws Exception
     */
    public ArrayList<User> getSortedUserByRolePaging(int index, int uRole) throws Exception;

}

