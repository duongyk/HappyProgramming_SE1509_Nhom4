/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.CV;
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
public class CVDAOImplTest {
    
    public CVDAOImplTest() {
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
     * Test of insertCV method, of class CVDAOImpl.
     */
    @Test
    public void testInsertCV() throws Exception {
        System.out.println("insertCV");
        int uid = 22;
        CV newCV = new CV(22,"avenger","earth heroes","shooting web","defeat thanos");
        CVDAOImpl instance = new CVDAOImpl();
        instance.insertCV(uid, newCV);
                 
    }
    
    /**
     * Test of getMentorCV method, of class CVDAOImpl.
     */
    @Test
    public void testGetMentorCV() throws Exception {
        System.out.println("getMentorCV");
        int uid = 22;
        CVDAOImpl instance = new CVDAOImpl();
        int expId = 22;
        String expProfession = "avenger";
        String expProfessionIntro = "earth heroes";
        String expService = "shooting web";
        String expAchievement = "defeat thanos";
        
        int id = instance.getMentorCV(uid).getId();
        String profession= instance.getMentorCV(uid).getProfession();
        String professionIntro = instance.getMentorCV(uid).getProfessionIntro();
        String service = instance.getMentorCV(uid).getServiceDescript();
        String achievement = instance.getMentorCV(uid).getAchivement();
        
        assertEquals(expId, id);
        assertEquals(expProfession, profession);
        assertEquals(expProfessionIntro, professionIntro);
        assertEquals(expService, service);
        
    }

    

    /**
     * Test of updateCV method, of class CVDAOImpl.
     */
    @Test
    public void testUpdateCV() throws Exception {
        System.out.println("updateCV");
        int uid = 22;
        CV newCV = new CV(22,"spider warrior","earth heroes","shooting web and strong","save earth");
        CVDAOImpl instance = new CVDAOImpl();
        int expResult = 1;
        int result = instance.updateCV(uid, newCV);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAllMentorCV method, of class CVDAOImpl.
     */
    @Test
    public void testGetAllMentorCV() throws Exception {
        System.out.println("getAllMentorCV");
        CVDAOImpl instance = new CVDAOImpl();
        int expResult = 11;
        int result = instance.getAllMentorCV().size();
        assertEquals(expResult, result);
        
    }
    
}
