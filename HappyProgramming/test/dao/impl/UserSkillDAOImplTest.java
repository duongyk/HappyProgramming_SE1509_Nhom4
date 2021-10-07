/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UserSkillDAO;
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
 * @author PC
 */
public class UserSkillDAOImplTest {
    
    public UserSkillDAOImplTest() {
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
     * Test of getAll_Skill_Mentor method, of class SkillMentorDAOImpl.
     */
    @Test
    public void testGetAll_Skill_Mentor() throws Exception {
        System.out.println("getAll_Skill_Mentor");
        int uid = 22;
        UserSkillDAO instance = new UserSkillDAOImpl();
        int expResult = 3;
        int result = instance.getAll_Skill_Mentor(uid).size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll_Id_Skill_Mentor method, of class SkillMentorDAOImpl.
     */
    @Test
    public void testGetAll_Id_Skill_Mentor() throws Exception {
        System.out.println("getAll_Id_Skill_Mentor");
        int uId = 22;
        
        UserSkillDAO instance = new UserSkillDAOImpl();
        int expResult = 3;
        int result = instance.getAll_Id_Skill_Mentor(uId).size();
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of updateMentorSkill method, of class SkillMentorDAOImpl.
     */
    @Test
    public void testUpdateMentorSkill() throws Exception {
        System.out.println("updateMentorSkill");
        int uId = 22;
        String[] skill_ids = {"2","3","4"};
        UserSkillDAO instance = new UserSkillDAOImpl();
        int expResult = 1;
        int result = instance.updateMentorSkill(uId, skill_ids);
        
        assertEquals(expResult, result);
        
    }
    
}
