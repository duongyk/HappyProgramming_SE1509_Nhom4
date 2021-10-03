/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 */
package dao.impl;

import context.DBContext;
import entity.CV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author thangtvhe151307 This class contains all methods to interact with CV
 * table in the database
 */
public class CVDAOImpl extends DBContext implements dao.CVDAO {

    /**
     * Get a particular CV in the database
     *
     * @param uid of the mentor
     * @return CV of that mentor
     * @throws Exception
     */
    @Override
    public CV getMentorCV(int uid) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CV cv = new CV();

        String sql = "select * from [CV] where uid='" + uid + "'";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                cv.setId(rs.getInt("uId"));
                cv.setProfession(rs.getString("profession"));
                cv.setProfessionIntro(rs.getString("professionIntro"));
                cv.setServiceDescript(rs.getString("serviceDescript"));
                cv.setAchivement(rs.getString("achievement"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return cv;
    }

    /**
     * Create a new CV in the database
     *
     * @param uid of the mentor
     * @param newCV
     * @throws Exception
     *
     */
    @Override
    public void insertCV(int uid, CV newCV) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into [CV] (uid, profession, professionIntro, serviceDescript, achievement)"
                + " values (?, ?, ?, ?, ?) ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, uid);
            ps.setString(2, newCV.getProfession());
            ps.setString(3, newCV.getProfessionIntro());
            ps.setString(4, newCV.getProfessionIntro());
            ps.setString(5, newCV.getAchivement());

            ps.executeQuery();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Update a particular CV in the database
     *
     * @param uid of the mentor
     * @param newCV from post data
     * @return 1 if update success, 0 if fail
     * @throws Exception
     *
     */
    @Override
    public int updateCV(int uid, CV newCV) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int status = 0;

        String sql = "update [CV]"
                + " set profession=?"
                + " , professionIntro=?"
                + " , serviceDescript=?"
                + " , achievement=?"
                + " where uid=?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, newCV.getProfession());
            ps.setString(2, newCV.getProfessionIntro());
            ps.setString(3, newCV.getServiceDescript());
            ps.setString(4, newCV.getAchivement());
            ps.setInt(5, uid);

            status = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return status;
    }

    /**
     * Get all CV in the database
     *
     * @return list of all CV
     * @throws Exception
     *
     */
    @Override
    public ArrayList<CV> getAllMentorCV() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CV> cvList = new ArrayList<>();

        CV cv = new CV();

        String sql = "select * from [CV] ";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
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

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return cvList;
    }
}
