/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 01-10-2021    1.0        TungDT          First Deploy<br>
 */
package dao.impl;

import entity.Skill;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tung
 */
public class SkillDAOTest {
    
    public SkillDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllSkill method, of class SkillDAO.
     */
    @Test
    public void testGetAllSkill() {
        System.out.println("getAllSkill");
        SkillDAO instance = new SkillDAO();
        ArrayList<Skill> expResult = instance.getAllSkill();
        ArrayList<Skill> result = instance.getAllSkill();
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSkillByName method, of class SkillDAO.
     */
    @Test
    public void testGetSkillByName() {
        System.out.println("getSkillByName");
        String sName = "";
        SkillDAO instance = new SkillDAO();
        ArrayList<Skill> expResult = null;
        ArrayList<Skill> result = instance.getSkillByName(sName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSkillById method, of class SkillDAO.
     */
    @Test
    public void testGetSkillById() {
        System.out.println("getSkillById");
        String sId = "";
        SkillDAO instance = new SkillDAO();
        Skill expResult = null;
        Skill result = instance.getSkillById(sId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class SkillDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Skill x = null;
        SkillDAO instance = new SkillDAO();
        instance.insert(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDupSkill method, of class SkillDAO.
     */
    @Test
    public void testFindDupSkill() {
        System.out.println("findDupSkill");
        String sName = "";
        SkillDAO instance = new SkillDAO();
        boolean expResult = false;
        boolean result = instance.findDupSkill(sName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
