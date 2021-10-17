/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        DuongVV          First Deploy<br>
 */
package dao.impl;

import context.DBContext;
import dao.SkillDAO;
import entity.Request;
import entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface RequestSkillDAOImpl. <br>
 * This class contains method to query select data from the table
 * RequestSkill.<br>
 * There are
 *
 * @author
 */
public class RequestSkillDAOImpl extends DBContext implements dao.RequestSkillDAO {

    @Override
    public int getRequestMaxId() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int n = 0;
        String sql = "select MAX(rId) as id from [Request]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return n;
    }

    /**
     * @return a new list of <code>Skill</code> object
     */
    @Override
    public int skillRequest(int sId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int n = 0;
        int maxId = getRequestMaxId();
        String sql = "INSERT INTO [RequestSkill](rId,[sId]) VALUES (? ,?)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maxId);
            ps.setInt(2, sId);
            n = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return n;
    }

    @Override
    public int getTotalRequest() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int total = 0;
        String sql = "SELECT COUNT(DISTINCT [sId]) FROM [RequestSkill]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return total;
    }

    @Override
    public void updateRequestSkill(int rId, ArrayList<Integer> skillIds) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlDelete = "DELETE FROM [RequestSkill] WHERE [rId] = ?";
        String sqlInsert = "INSERT INTO [RequestSkill] ([rId],[sId]) VALUES "
                + "(?,?)";
        try {
            conn = getConnection();
            // Delete
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, rId);
            ps.executeUpdate();
            // Insert new
            ps = conn.prepareStatement(sqlInsert);
            ps.setInt(1, rId);
            for (int id : skillIds) {
                ps.setInt(2, id);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public ArrayList<Skill> getSkill(int rId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Skill skill = null;
        SkillDAO skillDAO = new SkillDAOImpl();
        ArrayList<Skill> listSkill = new ArrayList<>();
        String sql = "SELECT * FROM [RequestSkill] WHERE [rId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, rId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int sId = rs.getInt("sId");
                skill = skillDAO.getSkillById(sId);
                listSkill.add(skill);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return (listSkill);
    }
}
