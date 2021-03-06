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

import entity.Skill;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate RequestSkill objects in the
 * database.
 *
 * @author 
 */
public interface RequestSkillDAO {
    /**
     * Get
     *
     * @param 
     * @return 
     * @throws Exception
     */
    public int getRequestMaxId() throws Exception;
    
    /**
     * Get
     *
     * @param 
     * @return 
     * @throws Exception
     */
    public int skillRequest(int sId) throws Exception;
    
    /**
     * Get total number skill of all request
     *
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public int getTotalRequest() throws Exception;
    
    /**
     * Get all the Skills by the Request ID
     * @param rId is a <code>java.lang.Integer</code>
     * @return a list <code>Skill</code> object 
     *@throws Exception
     */
    public ArrayList<Skill> getSkill(int rId) throws Exception;
    
    /**
     * Update RequestSkill table
     * @param rId is a <code>java.lang.Integer</code>
     * @param skillIds is a list of a <code>java.lang.Integer</code>
     *@throws Exception
     */
    public void updateRequestSkill(int rId, ArrayList<Integer> skillIds) throws Exception;
    
    /**
     * Get all the Skills that the Mentee had Requested
     * @param mId is a <code>java.lang.Integer</code>
     * @return a list <code>Skill</code> object 
     *@throws Exception
     */
    public ArrayList<Skill> getSkillByMentee(int mId) throws Exception;
}