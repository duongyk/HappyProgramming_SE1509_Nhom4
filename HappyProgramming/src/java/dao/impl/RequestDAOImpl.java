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
    public ArrayList<Request> getListByMe(User user) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM [Request] WHERE [fromId] = " + user.getId() + "OR [toId] = " + user.getId();
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

            while (rs.next()) {
                rId = rs.getInt("rId");
                rTitle = rs.getString("title");
                rContent = rs.getString("content");
                rStatus = rs.getInt("rStatus");
                rMentor = rs.getInt("toId");
                dlDate = rs.getDate("deadlineDate");
                r = new Request(rId, rTitle, rContent, userDAO.getUserById(user.getId()), userDAO.getUserById(rMentor), dlDate, rStatus);
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
    public int createRequest(Request req) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int n = 0;
        String sql = "INSERT INTO [Request](title, content, fromId, toId, deadlineDate, rStatus) VALUES (?, ?, ?, ?, ?, 1);";
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

}
