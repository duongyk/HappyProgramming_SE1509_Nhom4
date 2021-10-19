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
 * This class contains methods to help us manipulate Skill objects in the
 * database.
 *
 * @author
 */
public interface SkillDAO {

    /**
     * Get all Skill in the database
     *
     * @return a list <code>Skill</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<Skill> getAllSkill() throws Exception;

    /**
     * Get all Active Skill of the user in the database
     *
     * @return a list <code>Skill</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<Skill> getActiveSkill() throws Exception;

    /**
     * Find Skill in the database
     *
     * @param sName. It is a <code>java.lang.String</code>
     * @return a list <code>Skill</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<Skill> getSkillByName(String sName) throws Exception;

    /**
     * Find skill by Id in db
     *
     * @param sId .It is an int number
     * @return a list <code>Skill</code> object
     * @throws Exception
     */
    public Skill getSkillById(int sId) throws Exception;

    /**
     * check the skill has existed in db or not
     *
     * @param sName .It is a <code>java.lang.String</code>
     * @return boolean value
     * @throws Exception
     */
    public boolean findDupSkill(String sName) throws Exception;

    /**
     * Insert new Rating into the database
     *
     * @param x is a <code>Skill</code> object
     * @throws java.lang.Exception
     */
    public void insert(Skill x) throws Exception;

    /**
     * Update a Skill
     *
     * @param skill it is an <code>Skill</code> object
     * @throws Exception
     */
    public void updateSkill(Skill skill) throws Exception;

    /**
     * Get number of all Skill of all user in the database
     *
     * @return an int number
     */
    public int getTotalSkill();

    /**
     * Paging skill
     *
     * @param index is an int number
     * @return a list <code>Skill</code> object
     */
    public ArrayList<Skill> pagingSkill(int index);

}
