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
    
    UserDAO userDAO = new UserDAO();
            
    @Override
    public ArrayList<Rating> getRating(User user) {
        ArrayList<Rating> listRating = new ArrayList<>();
        xSql = "SELECT * FROM [Rating] WHERE [toId] = " + user.getId();
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            Rating rating;
            String comment;
            int fromId;
            int toId;
            int rateAmount;
            Timestamp date;

            while (rs.next()) {
                fromId = rs.getInt("fromId");
                toId = rs.getInt("toId");
                comment = rs.getString("comment");
                rateAmount = rs.getInt("ratingAmount");
                date = rs.getTimestamp("ratingDate");
                rating = new Rating(userDAO.getUserById(fromId), userDAO.getUserById(toId), comment, rateAmount, date);
                listRating.add(rating);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (listRating);
    }

    @Override
    public void insert(Rating rating) {
        xSql = "INSERT INTO [Rating] VALUES (?,?,?,?,GETDATE())";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, rating.getFrom().getId());
            ps.setInt(2, rating.getTo().getId());
            ps.setString(3, rating.getComment());
            ps.setInt(4, rating.getRateAmount());
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
