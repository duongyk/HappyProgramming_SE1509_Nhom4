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

import entity.Skill;
import entity.UserSkill;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate UserSkill objects in the
 * database.
 *
 * @author
 */
public interface UserSkillDAO {
    
    /**
     * Get all Skill of the Mentor in the database
     *
     * @param uId of the mentor
     * @return list of all skills of the mentor
     * @throws java.lang.Exception
     */
    public ArrayList<Skill> getAllSkillMentor(int uId) throws Exception;

    /**
     * Get all ID of Skill of the Mentor in the database
     *
     * @param uId of the mentor
     * @return list of all id of all skills of the mentor
     * @throws java.lang.Exception
     */
    public ArrayList<String> getAllIdSkillMentor(int uId) throws Exception;

    /**
     * Update new Skills for the Mentor in the database
     *
     * @param uId it is an an Integer number
     * @param skillids list of id of new skills
     * @return 1 if update success, 0 if fail
     * @throws java.lang.Exception
     */
    public int updateMentorSkill(int uId, String[] skillids) throws Exception;
    
    /**
     * Get all Skill of the User(Mentee/Mentor) in the database
     *
     * @param uId is a <code>java.lang.Integer</code>
     * @return list of all skills of the mentor
     * @throws java.lang.Exception
     */
    public ArrayList<Skill> getAllSkillUser(int uId) throws Exception;
    
    /**
     * Update new Skills of the User in the database
     *
     * @param uId it is a <code>java.lang.Integer</code>
     * @param sIdList is a list of <code>java.lang.Integer</code>
     * @throws java.lang.Exception
     */
    public void updateUserSkill(int uId, ArrayList<Integer> sIdList) throws Exception;
    
    /**
     * Get all User and Skill that User is Mentor in the database
     *
     * @return list of <code>UserSkill</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<UserSkill> getMentorSkill() throws Exception;
    
    /**
     * Get total number of Skill that User have
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * @throws java.lang.Exception
     */
    public int getTotalSkill(int mId) throws Exception;
}
