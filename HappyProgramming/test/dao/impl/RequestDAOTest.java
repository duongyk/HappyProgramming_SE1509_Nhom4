/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 01-10-2021    1.0                         First Deploy<br>
 */
package dao.impl;

import entity.Request;
import entity.User;
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
public class RequestDAOTest {
    
    public RequestDAOTest() {
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
     * Test of getListByMe method, of class RequestDAO.
     */
    @Test
    public void testGetListByMe() {
        System.out.println("getListByMe");
        User user = new User(1);
        RequestDAO instance = new RequestDAO();
        int expResult = 4;
        ArrayList<Request> result = instance.getListByMe(user);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of createRequest method, of class RequestDAO.
     */
    @Test
    public void testCreateRequest() {
        System.out.println("createRequest");
        Request req = null;
        RequestDAO instance = new RequestDAO();
        int expResult = 0;
        int result = instance.createRequest(req);
        assertEquals(expResult, result);
        
    }
    
}
