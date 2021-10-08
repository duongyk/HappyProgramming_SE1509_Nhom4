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
public class RequestDAOImplTest {
    
    public RequestDAOImplTest() {
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
     * Test of getListByMe method, of class RequestDAOImpl.
     */
    @Test
    public void testGetListByMe() throws Exception {
        System.out.println("getListByMe");
        User user = new User(1);
        RequestDAOImpl instance = new RequestDAOImpl();
        int expResult = 4;
        ArrayList<Request> result = instance.getListByMe(user);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of createRequest method, of class RequestDAOImpl.
     */
    @Test
    public void testCreateRequest() throws Exception {
        System.out.println("createRequest");
        Request req = null;
        RequestDAOImpl instance = new RequestDAOImpl();
        int expResult = 0;
        int result = instance.createRequest(req);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRequestListBy_Id_And_Status method, of class RequestDAOImpl.
     */
    @Test
    public void testGetRequestListBy_Id_And_Status() throws Exception {
        System.out.println("getRequestListBy_Id_And_Status");
        int uid = 1;
        int status = 1;
        
        RequestDAOImpl instance = new RequestDAOImpl();
        int expResult = 1;
        ArrayList<Request> list = instance.getRequestListBy_uId_And_Status(uid, status);
        
        int result = list.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
