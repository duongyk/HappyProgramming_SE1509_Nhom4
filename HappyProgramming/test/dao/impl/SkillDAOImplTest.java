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
public class SkillDAOImplTest {
    
    public SkillDAOImplTest() {
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
     * Test of getAllSkill method, of class SkillDAOImpl.
     */
    @Test
    public void testGetAllSkill() throws Exception {
        System.out.println("getAllSkill");
        SkillDAOImpl instance = new SkillDAOImpl();
        ArrayList<Skill> expResult = instance.getAllSkill();
        ArrayList<Skill> result = instance.getAllSkill();
        assertEquals(expResult.size(), result.size());
        
    }

    /**
     * Test of getSkillByName method, of class SkillDAOImpl.
     */
    @Test
    public void testGetSkillByName() throws Exception {
        System.out.println("getSkillByName");
        String sName = "c";
        SkillDAOImpl instance = new SkillDAOImpl();
        int expResult = 3;
        ArrayList<Skill> result = instance.getSkillByName(sName);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getSkillById method, of class SkillDAOImpl.
     */
    @Test
    public void testGetSkillById() throws Exception {
        System.out.println("getSkillById");
        int sId =0;
        SkillDAOImpl instance = new SkillDAOImpl();
        Skill expResult = null;
        Skill result = instance.getSkillById(sId);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class SkillDAOImpl.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Skill x = null;
        SkillDAOImpl instance = new SkillDAOImpl();
        instance.insert(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDupSkill method, of class SkillDAOImpl.
     */
    @Test
    public void testFindDupSkill() throws Exception {
        System.out.println("findDupSkill");
        String sName = "Java";
        SkillDAOImpl instance = new SkillDAOImpl();
        boolean expResult = true;
        boolean result = instance.findDupSkill(sName);
        assertEquals(expResult, result);
    }
    
}
