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
import dao.UserDAO;
import entity.Request;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface RequestDAOImpl. <br>
 * This class contains method to query select data from the table Request.<br>
 * There are Get all Request of the user in the database
 *
 * @author duongvvhe150773
 */
public class RequestDAOImpl extends DBContext implements dao.RequestDAO {

    UserDAOImpl userDAO = new UserDAOImpl();
    User user = new User();

    /**
     * Get all Request of the user in the database
     *
     * @return a list <code>Request</code> object
     */
    @Override
    public ArrayList<Request> getListByMe(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM [Request] WHERE [fromId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            rs = ps.executeQuery();
            Request r;
            int rId;
            String rTitle;
            String rContent;
            int rStatus;
            int rMentor;
            Date dlDate;

            while (rs.next()) {
                rId = rs.getInt("rId");
                rTitle = rs.getString("title");
                rContent = rs.getString("content");
                rStatus = rs.getInt("rStatus");
                rMentor = rs.getInt("toId");
                dlDate = rs.getDate("deadlineDate");
                r = new Request(rId, rTitle, rContent,
                        userDAO.getUserById(user.getId()),
                        userDAO.getUserById(rMentor), dlDate, rStatus);
                list.add(r);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return (list);
    }

    /**
     * @return a new <code>Request</code> object
     */
    @Override
    public int createRequest(Request req) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int n = 0;
        String sql = "INSERT INTO [Request](title, content, fromId, toId,"
                + " deadlineDate, rStatus) VALUES (?, ?, ?, ?, ?, 1);";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, req.getTitle());
            ps.setString(2, req.getContent());
            ps.setInt(3, req.getFrom().getId());
            ps.setInt(4, req.getTo().getId());
            ps.setDate(5, req.getDeadlineDate());
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

    public ArrayList<Request> getRequestListBy_uId_And_Status(int uid, int status) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Request> requestList = new ArrayList();
        UserDAO userdao = new UserDAOImpl();

        String sql = "select * from Request where (fromId=? or toId=?) and rStatus=? ";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, uid);
            ps.setInt(2, uid);
            ps.setInt(3, status);

            rs = ps.executeQuery();

            while (rs.next()) {
                Request req = new Request(rs.getInt("rId"), rs.getString("title"), rs.getString("content"), userdao.getUserById(rs.getInt("fromId")), userdao.getUserById(rs.getInt("toId")), Date.valueOf(rs.getString("deadlineDate")), status);

                requestList.add(req);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return requestList;
    }

    @Override
    public int getTotalRequest(int mId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT([toId]) as 'totalRequest' FROM [Request] "
                + "WHERE [fromId] = ?";

        int totalRequest = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalRequest = rs.getInt("totalRequest");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return totalRequest;
    }

    @Override
    public int getTotalRequestByStatus(int mId, int status) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT([toId]) as 'totalRequest' FROM [Request] "
                + "WHERE [fromId] = ? and [rStatus] = ?";

        int totalRequest = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            ps.setInt(2, status);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalRequest = rs.getInt("totalRequest");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return totalRequest;
    }

    @Override
    public int getTotalHourById(int mId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(deadlineHour) as 'totalHour' FROM [Request] "
                + "WHERE [fromId] = ?";

        int totalHour = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalHour = rs.getInt("totalHour");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return totalHour;
    }

    @Override
    public int getTotalHour() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(deadlineHour) as 'totalHour' FROM [Request] ";

        int totalHour = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalHour = rs.getInt("totalHour");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return totalHour;
    }

    @Override
    public int getTotalMentor(int mId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(DISTINCT [toId]) as 'totalMentor' FROM "
                + "[Request] WHERE [fromId] = ?";

        int totalMentor = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalMentor = rs.getInt("totalMentor");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return totalMentor;
    }

    @Override
    public void updateRequest(Request req) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [Request] SET [title] = ? ,[content] = ? ,"
                + "[deadlineDate] = ? ,[deadlineHour] = ? ,[rStatus] = ? WHERE "
                + "[rId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, req.getTitle());
            ps.setString(2, req.getContent());
            ps.setDate(3, req.getDeadlineDate());
            ps.setInt(4, req.getDeadlineHour());
            ps.setInt(5, req.getStatus());
            ps.setInt(6, req.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public void updateStatusRequest(Request req, int status) throws
            Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [dbo].[Request] SET [rStatus] = ? WHERE [rId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, req.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    @Override
    public Request getRequestById(int rId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [Request] WHERE [rId] = ?";
        Request req = new Request();
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, rId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return req = new Request(rs.getInt("rId"),
                        rs.getString("title"), rs.getString("content"),
                        userDAO.getUserById(rs.getInt("fromId")),
                        userDAO.getUserById(rs.getInt("toId")),
                        rs.getDate("deadlineDate"), rs.getInt("deadlineHour"),
                        rs.getInt("rStatus"));
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

    @Override
    public ArrayList<Integer> getStatistic(int mId) throws Exception {
        ArrayList<Integer> statistic = new ArrayList<>();
        int totalRequest = getTotalRequest(mId);
        statistic.add(totalRequest);
        int totalMentor = getTotalMentor(mId);
        statistic.add(totalMentor);
        int totalHour = getTotalHourById(mId);
        statistic.add(totalHour);
        int totalPending = getTotalRequestByStatus(mId, 1);
        statistic.add(totalPending);
        int totalProcessing = getTotalRequestByStatus(mId, 2);
        statistic.add(totalProcessing);
        int totalDone = getTotalRequestByStatus(mId, 3);
        statistic.add(totalDone);
        int totalCanceled = getTotalRequestByStatus(mId, 4);
        statistic.add(totalCanceled);
        return statistic;
    }

}
