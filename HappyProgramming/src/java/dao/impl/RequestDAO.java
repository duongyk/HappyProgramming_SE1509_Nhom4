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

    @Override
    public ArrayList<Request> getListByMe(User user) {
        ArrayList<Request> list = new ArrayList<>();
        xSql = "SELECT * FROM [Request] WHERE [fromId] = " + user.getuId() + "OR [toId] = " + user.getuId();
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
                x = new Request(xId, xTitle, xContent, user.getuId(), xMentor, dlDate, xStatus);
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
            ps.setInt(3, req.getFromId());
            ps.setInt(4, req.getToId());
            ps.setDate(5, req.getDeadlineDate());
            n = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public static void main(String[] args) {
        RequestDAO dao = new RequestDAO();
        Request req = new Request("HELP", "AAAAAA", 2, 13, Date.valueOf("2021-11-12"));
        System.out.println(dao.createRequest(req));
    }
}
