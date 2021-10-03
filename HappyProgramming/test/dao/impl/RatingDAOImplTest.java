/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Rating;
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
public class RatingDAOImplTest {
    
    public RatingDAOImplTest() {
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
     * Test of getRating method, of class RatingDAOImpl.
     */
    @Test
    public void testGetRating() throws Exception {
        System.out.println("getRating");
        User user = new User(5);
        RatingDAOImpl instance = new RatingDAOImpl();
        int expResult = 2;
        ArrayList<Rating> result = instance.getRating(user);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of insert method, of class RatingDAOImpl.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Rating rating = new Rating();
        RatingDAOImpl instance = new RatingDAOImpl();
        instance.insert(rating);
        
    }

    /**
     * Test of getAvgRate method, of class RatingDAOImpl.
     */
    @Test
    public void testGetAvgRate() throws Exception {
        System.out.println("getAvgRate");
        int mId = 5;
        RatingDAOImpl instance = new RatingDAOImpl();
        String expResult = "3.00";
        String result = instance.getAvgRate(mId);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDupRating method, of class RatingDAOImpl.
     */
    @Test
    public void testCheckDupRating() throws Exception {
        System.out.println("checkDupRating");
        int fromId = 1;
        int toId = 5;
        RatingDAOImpl instance = new RatingDAOImpl();
        boolean expResult = true;
        boolean result = instance.checkDupRating(fromId, toId);
        assertEquals(expResult, result);
    }
    
}
