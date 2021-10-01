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

import context.MyDAO;
import entity.Request;
import entity.User;
import java.sql.Date;
import java.util.ArrayList;

/**
 * This class implements from class interface RequestDAO. <br>
 * This class contains method to query select data from the table Request.<br>
 * There are Get all Request of the user in the database 
 *
 * @author duongvvhe150773
 */

public class RequestDAO extends MyDAO implements dao.RequestDAO{
    
    UserDAO userDAO = new UserDAO();
    User user  = new User();
    
    
    /**
     * Get all Request of the user in the database
     *
     * @return a list <code>Request</code> object
     */
    @Override
    public ArrayList<Request> getListByMe(User user) {
        ArrayList<Request> list = new ArrayList<>();
        xSql = "SELECT * FROM [Request] WHERE [fromId] = " + user.getId() + "OR [toId] = " + user.getId();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Request x;
            int xId;
            String xTitle;
            String xContent;
            String xStatus;
            int xMentor;
            Date dlDate;

            while (rs.next()) {
                xId = rs.getInt("rId");
                xTitle = rs.getString("title");
                xContent = rs.getString("content");
                xStatus = rs.getString("rStatus");
                xMentor = rs.getInt("toId");
                dlDate = rs.getDate("deadlineDate");
                x = new Request(xId, xTitle, xContent, userDAO.getUserById(user.getId()), userDAO.getUserById(xMentor), dlDate, xStatus);
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);
    }
    
    @Override
    public int createRequest(Request req) {
        int n = 0;
        xSql = "INSERT INTO [Request](title, content, fromId, toId, deadlineDate, rStatus) VALUES (?, ?, ?, ?, ?, 'pending');";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, req.getTitle());
            ps.setString(2, req.getContent());
            ps.setInt(3, req.getFrom().getId());
            ps.setInt(4, req.getTo().getId());
            ps.setDate(5, req.getDeadlineDate());
            n = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
}
