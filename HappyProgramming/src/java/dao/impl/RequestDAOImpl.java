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

    /**
     * Get all Request of the user in the database
     *
     * @param user it is an <code>User</code> object
     * @return a list <code>Request</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Request> getListByMe(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UserDAOImpl userDAO = new UserDAOImpl();
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
     * Get all Request of all user in the database
     *
     * @return a list <code>Request</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Request> getAllRequest() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UserDAOImpl userDAO = new UserDAOImpl();
        ArrayList<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM [Request] ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            Request r;
            int rId;
            String rTitle;
            String rContent;
            int rStatus;
            int rMentor;
            Date dlDate;
            int rMentee;

            while (rs.next()) {
                rId = rs.getInt("rId");
                rTitle = rs.getString("title");
                rContent = rs.getString("content");
                rStatus = rs.getInt("rStatus");
                rMentor = rs.getInt("toId");
                rMentee = rs.getInt("fromId");
                dlDate = rs.getDate("deadlineDate");
                r = new Request(rId, rTitle, rContent,
                        userDAO.getUserById(rMentee),
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
     * Get the number of request with the same status of all user
     *
     * @param status
     * @param txtSearch
     * @return a <code>java.lang.Integer</code>
     *
     * @throws Exception
     */
    @Override
    public ArrayList<Request> searchAllRequestByStatus(int status, String txtSearch) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Request> requestList = new ArrayList();
        UserDAO userdao = new UserDAOImpl();

        String sql = "select * from Request where rStatus=? and title like ? ";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setString(2, "%" + txtSearch + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Request req = new Request(rs.getInt("rId"), rs.getString("title"), rs.getString("content"), userdao.getUserById(rs.getInt("fromId")), userdao.getUserById(rs.getInt("toId")), Date.valueOf(rs.getString("deadlineDate")), rs.getInt("deadlineHour"), status);

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

    /**
     * Get the number of request with the same status of all user
     *
     * @param txtSearch
     * @return a <code>java.lang.Integer</code>
     *
     * @throws Exception
     */
    @Override
    public ArrayList<Request> searchAllRequest(String txtSearch) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Request> requestList = new ArrayList();
        UserDAO userdao = new UserDAOImpl();

        String sql = "select * from Request where title like ? ";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Request req = new Request(rs.getInt("rId"), rs.getString("title"), rs.getString("content"), userdao.getUserById(rs.getInt("fromId")), userdao.getUserById(rs.getInt("toId")), Date.valueOf(rs.getString("deadlineDate")), rs.getInt("deadlineHour"), rs.getInt("rStatus"));

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

    /**
     * Get Request of all Mentee by page
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Request> requestPaging(int index) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UserDAO userDAO = new UserDAOImpl();
        ArrayList<Request> list = new ArrayList<>();
        Request req = null;
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [rId])"
                + " AS [RowNum], * FROM [Request]) a WHERE "
                + "RowNum BETWEEN ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, index * 8 - 7);
            ps.setInt(2, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                req = new Request(rs.getInt("rId"),
                        rs.getString("title"), rs.getString("content"),
                        userDAO.getUserById(rs.getInt("fromId")),
                        userDAO.getUserById(rs.getInt("toId")),
                        rs.getDate("deadlineDate"), rs.getInt("deadlineHour"),
                        rs.getInt("rStatus"));
                list.add(req);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * Insert new request into the database
     *
     * @param req it is a <code>Request</code> object
     * @throws Exception
     */
    @Override
    public int createRequest(Request req) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int n = 0;
        String sql = "INSERT INTO [Request](title, content, fromId, toId,"
                + " deadlineDate, deadlineHour, rStatus) VALUES (?, ?, ?, ?, ?, ?,1);";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, req.getTitle());
            ps.setString(2, req.getContent());
            ps.setInt(3, req.getFrom().getId());
            ps.setInt(4, req.getTo().getId());
            ps.setDate(5, req.getDeadlineDate());
            ps.setInt(6, req.getDeadlineHour());
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

    /**
     * Get the total number of request of the user
     *
     * @param uid (id of user )
     * @param status (status of request)
     * @return ArrayList of Request
     *
     * @throws Exception
     */
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
                Request req = new Request(rs.getInt("rId"), rs.getString("title"), rs.getString("content"), userdao.getUserById(rs.getInt("fromId")), userdao.getUserById(rs.getInt("toId")), Date.valueOf(rs.getString("deadlineDate")), rs.getInt("deadlineHour"), status);

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

    /**
     * Get the total number of request of the Mentee
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     *
     * @throws Exception
     */
    @Override
    public int getTotalRequest(int mId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT([toId]) as 'totalRequest' FROM [Request] "
                + "WHERE [fromId] = ? OR [toId] = ?";

        int totalRequest = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            ps.setInt(2, mId);
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

    /**
     * Get the number of request with the same status of the user
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @param status it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     *
     * @throws Exception
     */
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

    /**
     * Get the number of request with the same status of all user
     *
     * @param status it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     *
     * @throws Exception
     */
    @Override
    public int getTotalRequestByStatus(int status) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT([toId]) as 'totalRequest' FROM [Request] "
                + "WHERE [rStatus] = ?";

        int totalRequest = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
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

    /**
     * Get the total hour of request of the user
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     *
     * @throws Exception
     */
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

    /**
     * Get the total hour of request of all user
     *
     * @return an <code>java.lang.Integer</code>
     *
     * @throws Exception
     */
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

    /**
     * Get the number of mentors of the user
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     *
     * @throws Exception
     */
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

    /**
     * Update a request
     *
     * @param req it is a <code>Request</code> object
     * @throws Exception
     */
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

    /**
     * Update status of a request
     *
     * @param rId it is a <code>java.lang.Integer</code>
     * @param status it is a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public void updateStatusRequest(int rId, int status) throws
            Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [Request] SET [rStatus] = ? WHERE [rId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, rId);
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
     * Get request by ID
     *
     * @param rId it is a <code>java.lang.Integer</code>
     * @return a <code>Request</code> object
     * @throws Exception
     */
    @Override
    public Request getRequestById(int rId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UserDAOImpl userDAO = new UserDAOImpl();
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

    /**
     * Get request statistic
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a list of <code>java.lang.Integer</code>
     * @throws Exception
     */
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

    /**
     * Get Request of a Mentee by page
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param mId it is a <code>java.lang.Integer</code>
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Request> listByMePaging(int index, int mId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UserDAO userDAO = new UserDAOImpl();
        ArrayList<Request> list = new ArrayList<>();
        Request req = null;
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [rId])"
                + " AS [RowNum], * FROM [Request] WHERE [fromId] = ?) a WHERE "
                + "RowNum BETWEEN ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            ps.setInt(2, index * 8 - 7);
            ps.setInt(3, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                req = new Request(rs.getInt("rId"),
                        rs.getString("title"), rs.getString("content"),
                        userDAO.getUserById(rs.getInt("fromId")),
                        userDAO.getUserById(rs.getInt("toId")),
                        rs.getDate("deadlineDate"), rs.getInt("deadlineHour"),
                        rs.getInt("rStatus"));
                list.add(req);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * Get Request of a Mentee by page after Filter by Status
     *
     * @param index it is a <code>java.lang.Integer</code>
     * @param mId it is a <code>java.lang.Integer</code>
     * @param status it is a <code>java.lang.Integer</code>
     * @return a list of <code>Request</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Request> listByMeFilterStatusPaging(int index, int mId, int status) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UserDAO userDAO = new UserDAOImpl();
        ArrayList<Request> list = new ArrayList<>();
        Request req = null;
        String sql = "SELECT * FROM (SELECT ROW_NUMBER () OVER (ORDER BY [rId])"
                + " AS [RowNum], * FROM [Request] WHERE [fromId] = ? and"
                + " [rStatus] = ?) a WHERE RowNum BETWEEN ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            ps.setInt(2, status);
            ps.setInt(3, index * 8 - 7);
            ps.setInt(4, index * 8);
            rs = ps.executeQuery();
            while (rs.next()) {
                req = new Request(rs.getInt("rId"),
                        rs.getString("title"), rs.getString("content"),
                        userDAO.getUserById(rs.getInt("fromId")),
                        userDAO.getUserById(rs.getInt("toId")),
                        rs.getDate("deadlineDate"), rs.getInt("deadlineHour"),
                        rs.getInt("rStatus"));
                list.add(req);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * Get total number of Request of a Mentee by page after Filter by Status
     *
     * @param mId it is a <code>java.lang.Integer</code>
     * @param status it is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public int getTotalFilterStatus(int mId, int status) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int total = 0;
        String sql = "SELECT COUNT([rId]) as 'total' FROM [Request] WHERE "
                + "[fromId] = ? AND [rStatus] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            ps.setInt(2, status);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
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
     * Get Total Request of the Mentor by the status
     *
     * @return a Integer number
     * @throws Exception
     */
    @Override
    public int get_Mentor_TotalRequestByStatus(int mentorId, int status) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT([toId]) as 'totalRequest' FROM [Request] "
                + "WHERE [toId] = ? and [rStatus] = ?";

        int totalRequest = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mentorId);
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

    /**
     * Get Requested Mentor sorted by number of Request
     *
     * @return a list of <code>java.lang.Integer</code>
     * @throws Exception
     */
    @Override
    public ArrayList<User> getHotMentor() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        UserDAO userDAO = new UserDAOImpl();
        ArrayList<User> list = new ArrayList<>();
        String sql = "SELECT DISTINCT([toId]),(SELECT COUNT([toId]) "
                + "FROM [Request] WHERE [toId] = a.[toId]) as 'total' "
                + "FROM [Request] a ORDER BY [total] DESC";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(userDAO.getUserById(rs.getInt("toId")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }

    @Override
    public int getNumberOfRequest() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int total = 0;
        String sql = "SELECT COUNT([rId]) as 'totalRequest' FROM [Request]";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("totalRequest");
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
