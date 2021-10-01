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
public class UserDAOTest {
    
    public UserDAOTest() {
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
     * Test of getUserList method, of class UserDAO.
     */
    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        UserDAO instance = new UserDAO();
        int expResult = 17;
        ArrayList<User> result = instance.getUserList();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of getUserById method, of class UserDAO.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        int uId = 19;
        UserDAO instance = new UserDAO();
        String expResult = "duongvv0";
        User result = instance.getUserById(uId);
        assertEquals(expResult, result.getUsername());
    }

    /**
     * Test of getUser method, of class UserDAO.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String xName = "";
        String xPass = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUser(xName, xPass);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAccount method, of class UserDAO.
     */
    @Test
    public void testCheckAccount() {
        System.out.println("checkAccount");
        String xName = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.checkAccount(xName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of signUp method, of class UserDAO.
     */
    @Test
    public void testSignUp() {
        System.out.println("signUp");
        User user = null;
        UserDAO instance = new UserDAO();
        instance.signUp(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserInfo method, of class UserDAO.
     */
    @Test
    public void testUpdateUserInfo() {
        System.out.println("updateUserInfo");
        int uid = 0;
        User user = null;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.updateUserInfo(uid, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByRole method, of class UserDAO.
     */
    @Test
    public void testGetUserByRole() {
        System.out.println("getUserByRole");
        int uRole = 0;
        UserDAO instance = new UserDAO();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getUserByRole(uRole);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
