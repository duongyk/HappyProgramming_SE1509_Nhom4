/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.MyDAO;
import entity.Request;
import entity.User;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public class RequestDAO extends MyDAO implements dao.RequestDAO{
    
    UserDAO userDAO = new UserDAO();
    User user  = new User();
    
    @Override
    public ArrayList<Request> getListByMe(User user) {
        ArrayList<Request> list = new ArrayList<>();
        xSql = "SELECT * FROM [Request] WHERE [fromId] = " + user.getId() + "OR [toId] = " + user.getId();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Request x;
            int xId;
            String xTitle, xContent, xStatus;
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
