/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 */
package dao.impl;

import context.MyDAO;
import entity.CV;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thangtvhe151307
 * This class contains all methods to interact with CV table in the database
 */
public class CVDAO extends MyDAO implements dao.CVDAO {
    
    /**
    * Get a particular CV in the database
    * 
    * @param uid of the mentor
    * @return CV of that mentor
    */
    @Override
    public CV getMentorCV(int uid) {

        CV cv = new CV();

        xSql = "select * from [CV] where uid='" + uid + "'";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                cv.setProfession(rs.getString("profession"));
                cv.setProfessionIntro(rs.getString("professionIntro"));
                cv.setServiceDescript(rs.getString("serviceDescript"));
                cv.setAchivement(rs.getString("achievement"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cv;
    }
    
    /**
    * Create a new CV in the database
    * 
    * @param uid of the mentor
    * @param newCV
    * 
    */
    @Override
    public void insertCV(int uid, CV newCV) {
        xSql = "insert into [CV] (uid, profession, professionIntro, serviceDescript, achievement)"
                + " values (?, ?, ?, ?, ?) ";

        try {
            ps = con.prepareStatement(xSql);
            
            ps.setInt(1, uid);
            ps.setString(2, newCV.getProfession());
            ps.setString(3, newCV.getProfessionIntro());
            ps.setString(4, newCV.getProfessionIntro());
            ps.setString(5, newCV.getAchivement());

            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * Update a particular CV in the database
    * 
    * @param uid of the mentor
     * @param newCV from post data
    * @return 1 if update success, 0 if fail
    */
    @Override
    public int updateCV(int uid, CV newCV) {
        int status = 0;
        
        xSql = "update [CV]"
                + " set profession=?"
                + " , professionIntro=?"
                + " , serviceDescript=?"
                + " , achievement=?"
                + " where uid=?";

        try {
            ps = con.prepareStatement(xSql);
            
            ps.setString(1, newCV.getProfession());
            ps.setString(2, newCV.getProfessionIntro());
            ps.setString(3, newCV.getServiceDescript());
            ps.setString(4, newCV.getAchivement());
            ps.setInt(5, uid);
            
            status = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    /**
    * Get all CV in the database
    * 
    * 
    * @return list of all CV
    */
    @Override
    public ArrayList<CV> getAllMentorCV() {
        ArrayList<CV> cvList = new ArrayList<>();
        
        CV cv = new CV();
        
        xSql = "select * from [CV] ";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cv.setId(rs.getInt("uId"));
                cv.setProfession(rs.getString("profession"));
                cv.setProfessionIntro(rs.getString("professionIntro"));
                cv.setServiceDescript(rs.getString("serviceDescript"));
                cv.setAchivement(rs.getString("achievement"));
                
                cvList.add(cv);
                cv = new CV();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cvList;
    }
}
