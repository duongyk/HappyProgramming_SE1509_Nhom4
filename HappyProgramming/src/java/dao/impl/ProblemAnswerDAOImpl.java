/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-10-2021    1.0        DuongVV          First Deploy<br>
 */
package dao.impl;

import context.DBContext;
import entity.ProblemAnswer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface ProblemAnswerDAOImpl. <br>
 * This class contains method to query select the table ProblemAnswer.<br>
 * There are 
 *
 * @author duongvvhe150773
 */
public class ProblemAnswerDAOImpl extends DBContext implements dao.ProblemAnswerDAO {

    /**
     * Get all the Answer of a Problem
     *
     * @param index it is a<code>java.lang.Integer</code>
     * @param pId it is a<code>java.lang.Integer</code>
     * @return list of <code>Problem</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<ProblemAnswer> getProblemAnswerList(int index, int pId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;

        ArrayList<ProblemAnswer> listPA = new ArrayList<>();
        UserDAOImpl userDAO = new UserDAOImpl();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [paId])"
                + "  AS [RowNum], * FROM [ProblemAnswer] WHERE [pId] = ?) a"
                + " WHERE [RowNum] BETWEEN ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            ps.setInt(2, index * 4 - 3);
            ps.setInt(3, index * 4);
            rs = ps.executeQuery();

            while (rs.next()) {
                listPA.add(new ProblemAnswer(pId,rs.getInt("paId"),
                        userDAO.getUserById(rs.getInt("fromId")),
                        rs.getString("content"), rs.getTimestamp("date")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return (listPA);
    }

    /**
     * Insert a Answer into database
     *
     * @param pId it is a<code>java.lang.Integer</code>
     * @param fromId it is a<code>java.lang.Integer</code>
     * @param content it is a<code>java.lang.String</code>
     * @throws Exception
     */
    @Override
    public void insertProblemAnswer(int pId,int fromId, String content) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [ProblemAnswer]"
                + "([pId],[fromId],[content],[date])"
                + " VALUES (?,?,?,GETDATE())";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            ps.setInt(2, fromId);
            ps.setString(3, content);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Update a Answer in database
     *
     * @param pa it is a <code>ProblemAnswer</code> object
     * @throws Exception
     */
    @Override
    public void updateProblemAnswer(ProblemAnswer pa) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [ProblemAnswer] SET [content] = ?"
                + " WHERE [paId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pa.getContent());
            ps.setInt(2, pa.getPaId());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Get total number of Answer of a Problem
     *
     * @param pId it is a <code>ProblemAnswer</code> object
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public int countProblemAnswer(int pId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int total = 0;
        String sql = "SELECT COUNT(*) as 'total' FROM [ProblemAnswer] "
                + "WHERE [pId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
                return total;
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
}
