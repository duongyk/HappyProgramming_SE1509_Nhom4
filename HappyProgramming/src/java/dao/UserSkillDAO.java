/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
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
    public ArrayList<Skill> getAll_Skill_Mentor(int uId) throws Exception;

    /**
     * Get all ID of Skill of the Mentor in the database
     *
     * @param uId of the mentor
     * @return list of all id of all skills of the mentor
     * @throws java.lang.Exception
     */
    public ArrayList<String> getAll_Id_Skill_Mentor(int uId) throws Exception;

    /**
     * Update new Skills for the Mentor in the database
     *
     * @param uId it is an an Integer number
     * @param skill_ids list of id of new skills
     * @return 1 if update success, 0 if fail
     * @throws java.lang.Exception
     */
    public int updateMentorSkill(int uId, String[] skill_ids) throws Exception;
    
    /**
     * Get all Skill of the User(Mentee/Mentor) in the database
     *
     * @param uId is an Integer number
     * @return list of all skills of the mentor
     * @throws java.lang.Exception
     */
    public ArrayList<Skill> getAllSkillUser(int uId) throws Exception;
    
    /**
     * Update new Skills of the User in the database
     *
     * @param uId it is an an Integer number
     * @param sIdList is a list of Integer number
     * @throws java.lang.Exception
     */
    public void updateUserSkill(int uId, ArrayList<Integer> sIdList) throws Exception;
}
