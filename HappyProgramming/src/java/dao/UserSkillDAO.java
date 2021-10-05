/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
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
     */
    public ArrayList<Skill> getAll_Skill_Mentor(int uId) throws Exception;

    /**
     * Get all ID of Skill of the Mentor in the database
     *
     * @param uId of the mentor
     * @return list of all id of all skills of the mentor
     */
    public ArrayList<String> getAll_Id_Skill_Mentor(int uId) throws Exception;

    /**
     * Update new Skills for the Mentor in the database
     *
     * @param uId it is an int number
     * @param skill_ids list of id of new skills
     * @return 1 if update success, 0 if fail
     */
    public int updateMentorSkill(int uId, String[] skill_ids) throws Exception;
    
}
