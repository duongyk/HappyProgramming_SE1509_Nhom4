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
}
