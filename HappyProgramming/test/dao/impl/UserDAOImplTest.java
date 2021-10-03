/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

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
 * @author Duong
 */
public class UserDAOImplTest {
    
    public UserDAOImplTest() {
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
     * Test of getUserList method, of class UserDAOImpl.
     */
    @Test
    public void testGetUserList() throws Exception {
        System.out.println("getUserList");
        UserDAOImpl instance = new UserDAOImpl();
        int expResult = 17;
        ArrayList<User> result = instance.getUserList();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getUserById method, of class UserDAOImpl.
     */
    @Test
    public void testGetUserById() throws Exception {
        System.out.println("getUserById");
        int uId = 19;
        UserDAOImpl instance = new UserDAOImpl();
        String expResult = "duongvv0";
        User result = instance.getUserById(uId);
        assertEquals(expResult, result.getUsername());
    }

    /**
     * Test of getUser method, of class UserDAOImpl.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String xName = "";
        String xPass = "";
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.getUser(xName, xPass);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAccount method, of class UserDAOImpl.
     */
    @Test
    public void testCheckAccount() throws Exception {
        System.out.println("checkAccount");
        String xName = "";
        UserDAOImpl instance = new UserDAOImpl();
        User expResult = null;
        User result = instance.checkAccount(xName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of signUp method, of class UserDAOImpl.
     */
    @Test
    public void testSignUp() throws Exception {
        System.out.println("signUp");
        User user = null;
        UserDAOImpl instance = new UserDAOImpl();
        instance.signUp(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserInfo method, of class UserDAOImpl.
     */
    @Test
    public void testUpdateUserInfo() throws Exception {
        System.out.println("updateUserInfo");
        int uid = 0;
        User user = null;
        UserDAOImpl instance = new UserDAOImpl();
        int expResult = 0;
        int result = instance.updateUserInfo(uid, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByRole method, of class UserDAOImpl.
     */
    @Test
    public void testGetUserByRole() throws Exception {
        System.out.println("getUserByRole");
        int uRole = 0;
        UserDAOImpl instance = new UserDAOImpl();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getUserByRole(uRole);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
