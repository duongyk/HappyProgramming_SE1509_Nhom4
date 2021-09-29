/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.MyDAO;
import entity.Rating;
import entity.User;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public class RatingDAO extends MyDAO implements dao.RatingDAO {

    @Override
    public ArrayList<Rating> getRating(User user) {
        ArrayList<Rating> list = new ArrayList<>();
        xSql = "WITH t AS (SELECT r.[fromId], r.[toId], u.[fullname] AS [to], r.[comment], r.[ratingAmount], "
                + "r.[ratingDate] FROM [Rating] r INNER JOIN [User] u ON r.[toId]= u.[uId])\n"
                + "SELECT t.[fromId], t.[toId], u.[fullname] AS [from], t.[to], t.[comment], t.[ratingAmount],"
                + " t.[ratingDate] FROM t inner join [User] u ON t.[fromId] = u.[uId] WHERE t.[toId] = " + user.getuId();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Rating x;
            String xComment;
            String xFrom;
            String xTo;
            int xFromId, xToId, xRating;
            Timestamp xDate;

            while (rs.next()) {
                xFromId = rs.getInt("fromId");
                xToId = rs.getInt("toId");
                xFrom = rs.getString("from");
                xTo = rs.getString("to");
                xComment = rs.getString("comment");
                xRating = rs.getInt("ratingAmount");
                xDate = rs.getTimestamp("ratingDate");
                x = new Rating(xFromId, xToId, xComment, xRating, xDate, xFrom, xTo);
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
    public void insert(Rating x) {
        xSql = "insert into [Rating] values (?,?,?,?,GETDATE())";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getFromId());
            ps.setInt(2, x.getToId());
            ps.setString(3, x.getComment());
            ps.setInt(4, x.getRating());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getAvgRate(int mId) {
        ArrayList<Integer> listRating = new ArrayList();
        xSql = "SELECT * FROM [Rating] WHERE [toId] = "+mId;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int rate;
            while (rs.next()) {
                rate = rs.getInt("ratingAmount");
                listRating.add(rate);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int sum=0;
        for (int a : listRating) {
            sum+=a;
        }
        
        String avg = String.format("%.2f", (double)sum/listRating.size());
        return avg;
    }
//    
//        public static void main(String[] args) {
//        RatingDAO r = new RatingDAO();
//        UserDAO u = new UserDAO();
//        User x= u.getUserById(7);
//        ArrayList<Rating> a = r.getRating(x);
//            System.out.println(x.getFullname());
//        for (Rating rate: a){
//            System.out.println(rate.getComment());
//        }
//    }
}
