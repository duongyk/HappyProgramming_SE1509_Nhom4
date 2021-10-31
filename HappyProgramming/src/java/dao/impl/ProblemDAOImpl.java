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
import entity.Problem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface ProblemDAOImpl. <br>
 * This class contains method to query select data from the table Problem.<br>
 * There are
 *
 * @author duongvvhe150773
 */
public class ProblemDAOImpl extends DBContext implements dao.ProblemDAO {

    /**
     * Get all the Problem
     *
     * @param index is a <code>java.lang.Integer</code>
     * @return list of <code>Problem</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Problem> getProblemListPaging(int index) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Problem> listProblem = new ArrayList<>();
        UserDAOImpl userDAO = new UserDAOImpl();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [pId])"
                + "  AS [RowNum], * FROM [Problem]) a WHERE [RowNum] "
                + "BETWEEN ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, index * 4 - 3);
            ps.setInt(2, index * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProblem.add(new Problem(rs.getInt("pId"),
                        userDAO.getUserById(rs.getInt("fromId")),
                        rs.getString("title"), rs.getString("content"),
                        rs.getTimestamp("date"), rs.getInt("status")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return (listProblem);
    }

    /**
     * Get a Problem
     *
     * @param pId is a <code>java.lang.Integer</code>
     * @return a <code>Problem</code> object
     * @throws Exception
     */
    @Override
    public Problem getProblem(int pId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UserDAOImpl userDAO = new UserDAOImpl();
        String sql = "SELECT * FROM [Problem] WHERE [pId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Problem(rs.getInt("pId"),
                        userDAO.getUserById(rs.getInt("fromId")),
                        rs.getString("title"), rs.getString("content"),
                        rs.getTimestamp("date"), rs.getInt("status"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Get User's Problem
     *
     * @param index is a <code>java.lang.Integer</code>
     * @param mId is a <code>java.lang.Integer</code>
     * @return a list of <code>Problem</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Problem> getProblemByMePaging(int index, int mId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Problem> listProblem = new ArrayList<>();
        UserDAOImpl userDAO = new UserDAOImpl();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [pId])"
                + "  AS [RowNum], * FROM [Problem] WHERE [fromId] = ?) a"
                + " WHERE [RowNum] BETWEEN ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            ps.setInt(2, index * 4 - 3);
            ps.setInt(3, index * 4);
            rs = ps.executeQuery();

            while (rs.next()) {
                listProblem.add(new Problem(rs.getInt("pId"),
                        userDAO.getUserById(rs.getInt("fromId")),
                        rs.getString("title"), rs.getString("content"),
                        rs.getTimestamp("date"), rs.getInt("status")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return (listProblem);
    }

    /**
     * Insert a Problem into database
     *
     * @param problem it is a <code>Problem</code> object
     * @throws Exception
     */
    @Override
    public void insertProblem(Problem problem) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [Problem]"
                + "([fromId],[title],[content],[date],[status])"
                + " VALUES (?,?,?,GETDATE(),1)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, problem.getFrom().getId());
            ps.setString(2, problem.getTitle());
            ps.setString(3, problem.getContent());
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
     * Update a Problem into database
     *
     * @param problem it is a <code>Problem</code> object
     * @throws Exception
     */
    @Override
    public void updateProblem(Problem problem) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [Problem] SET [title] = ? ,[content] = ? ,"
                + ",[status] = ? WHERE [pId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, problem.getTitle());
            ps.setString(2, problem.getContent());
            ps.setInt(3, problem.getStatus());
            ps.setInt(4, problem.getId());
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
     * Close a Problem (change status into 0)
     *
     * @param pId is a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public void closeProblem(int pId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [Problem] SET [status] = 0 WHERE [pId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
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
     * Open a Problem (change status into 0)
     *
     * @param pId is a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public void openProblem(int pId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [Problem] SET [status] = 1 WHERE [pId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
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
     * Count all the Problem
     *
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public int countProblem() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int total = 0;
        String sql = "SELECT COUNT(*) as 'total' FROM [Problem]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
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

    /**
     * Count the Problem of a User
     *
     * @param uId is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public int countProblemUser(int uId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int total = 0;
        String sql = "SELECT COUNT(*) as 'total' FROM [Problem]"
                + "WHERE [fromId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, uId);
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

    /**
     * Count the Problem of a User
     *
     * @param pId is a <code>java.lang.Integer</code>
     * @param uId is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public boolean checkMyProblem(int pId, int uId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM [Problem]"
                + "WHERE [pId] = ? AND [fromId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pId);
            ps.setInt(2, uId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return false;
    }

}
