/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Duong
 */
public class CVDAO extends MyDAO implements dao.CVDAO {
    
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

    @Override
    public void insertCV(String uid, CV newCV) {
        xSql = "insert into [CV] (uid, profession, professionIntro, serviceDescript, achievement)"
                + " value (" + uid + ", ?, ?, ?, ?) ";

        try {
            ps = con.prepareStatement(xSql);

            ps.setString(0, newCV.getProfession());
            ps.setString(1, newCV.getProfessionIntro());
            ps.setString(2, newCV.getProfessionIntro());
            ps.setString(3, newCV.getAchivement());

            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int updateCV(int uid, CV newCV) {
        int status = 0;
        
        xSql = "update [CV]"
                + " set profession='"+newCV.getProfession()+"'"
                + " , professionIntro='"+newCV.getProfessionIntro()+"'"
                + " , serviceDescript='"+newCV.getServiceDescript()+"'"
                + " , achievement='"+newCV.getAchivement()+"'"
                + " where uid='"+uid+"'";

        try {
            ps = con.prepareStatement(xSql);

            status = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    @Override
    public ArrayList<CV> getAllMentorCV() {
        ArrayList<CV> cvList = new ArrayList<>();
        
        CV cv = new CV();
        
        xSql = "select * from [CV] ";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cv.setuId(rs.getInt("uId"));
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
