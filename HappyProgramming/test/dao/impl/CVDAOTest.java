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
public class CVDAOTest {
    
    public CVDAOTest() {
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
     * Test of insertCV method, of class CVDAO.
     */
    @Test
    public void testInsertCV() {
        System.out.println("insertCV");
        int uid = 22;
        CV newCV = new CV(22,"avenger","earth heroes","shooting web","defeat thanos");
        CVDAO instance = new CVDAO();
        instance.insertCV(uid, newCV);
                 
    }
    
    /**
     * Test of getMentorCV method, of class CVDAO.
     */
    @Test
    public void testGetMentorCV() {
        System.out.println("getMentorCV");
        int uid = 22;
        CVDAO instance = new CVDAO();
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
     * Test of updateCV method, of class CVDAO.
     */
    @Test
    public void testUpdateCV() {
        System.out.println("updateCV");
        int uid = 22;
        CV newCV = new CV(22,"avenger","earth heroes","shooting web","defeat thanos");
        CVDAO instance = new CVDAO();
        int expResult = 1;
        int result = instance.updateCV(uid, newCV);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAllMentorCV method, of class CVDAO.
     */
    @Test
    public void testGetAllMentorCV() {
        System.out.println("getAllMentorCV");
        CVDAO instance = new CVDAO();
        int expResult = 11;
        int result = instance.getAllMentorCV().size();
        assertEquals(expResult, result);
        
    }
    
}
