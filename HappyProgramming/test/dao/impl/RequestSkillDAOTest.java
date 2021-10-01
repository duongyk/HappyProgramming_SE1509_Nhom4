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
public class RequestSkillDAOTest {
    
    public RequestSkillDAOTest() {
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
     * Test of getRequestMaxId method, of class RequestSkillDAO.
     */
    @Test
    public void testGetRequestMaxId() {
        System.out.println("getRequestMaxId");
        RequestSkillDAO instance = new RequestSkillDAO();
        int expResult = 0;
        int result = instance.getRequestMaxId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skillRequest method, of class RequestSkillDAO.
     */
    @Test
    public void testSkillRequest() {
        System.out.println("skillRequest");
        int sId = 0;
        RequestSkillDAO instance = new RequestSkillDAO();
        int expResult = 0;
        int result = instance.skillRequest(sId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
