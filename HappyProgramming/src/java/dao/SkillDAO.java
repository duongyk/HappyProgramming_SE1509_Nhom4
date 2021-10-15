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
     * Get
     *
     * @param
     * @return
     * @throws Exception
     */
    public ArrayList<Skill> getAllSkill() throws Exception;

    /**
     * Get
     *
     * @param
     * @return
     * @throws Exception
     */
    public ArrayList<Skill> getActiveSkill() throws Exception;

    /**
     * Get
     *
     * @param
     * @return
     * @throws Exception
     */
    public ArrayList<Skill> getSkillByName(String sName) throws Exception;

    /**
     * Get
     *
     * @param
     * @return
     * @throws Exception
     */
    public Skill getSkillById(int sId) throws Exception;

    /**
     * Get
     *
     * @param
     * @return
     * @throws Exception
     */
    public boolean findDupSkill(String sName) throws Exception;

    /**
     * Get
     *
     * @param
     * @return
     * @throws Exception
     */
    public void insert(Skill x) throws Exception;

    /**
     * Update a Skill
     *
     * @param skill it is an <code>Skill</code> object
     * @throws Exception
     */
    public void updateSkill(Skill skill) throws Exception;

    public int getTotalSkill();

    public ArrayList<Skill> pagingSkill(int index);
}
