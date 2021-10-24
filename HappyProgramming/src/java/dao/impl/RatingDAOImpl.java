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
import entity.Rating;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * This class implements from class interface RatingDAOImpl. <br>
 * This class contains method to query select data from the table Rating.<br>
 * There are Get all Rating of the user in the database, Insert new Rating into
 * the database, Get average rating of the Mentor, Check if Mentee has rated and
 * commented on Mentor or not
 *
 * @author duongvvhe150773
 */
public class RatingDAOImpl extends DBContext implements dao.RatingDAO {

    /**
     * Get all Rating of the user in the database
     *
     * @param user it is an object User
     * @return a list <code>Rating</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Rating> getRating(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;

        ArrayList<Rating> listRating = new ArrayList<>();
        UserDAOImpl userDAO = new UserDAOImpl();
        String sql = "SELECT * FROM [Rating] WHERE [toId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
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
                rating = new Rating(userDAO.getUserById(fromId),
                        userDAO.getUserById(toId), comment, rateAmount, date);
                listRating.add(rating);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return (listRating);
    }

    /**
     * Insert new Rating into the database
     *
     */
    @Override
    public void insert(Rating rating) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [Rating] VALUES (?,?,?,?,GETDATE())";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, rating.getFrom().getId());
            ps.setInt(2, rating.getTo().getId());
            ps.setString(3, rating.getComment());
            ps.setInt(4, rating.getRateAmount());
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
     * Get average rating of the Mentor
     *
     * @param mId it is an <code>java.lang.Integer</code>
     * @return a String .It is a <code>java.lang.String</code>
     * @throws Exception
     */
    @Override
    public double getAvgRate(int mId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Integer> listRating = new ArrayList();
        String sql = "SELECT * FROM [Rating] WHERE [toId] = ?";
        int sum = 0;
        double avg = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mId);
            rs = ps.executeQuery();
            int rate;
            while (rs.next()) {
                rate = rs.getInt("ratingAmount");
                sum+=rate;
                listRating.add(rate);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        if (!listRating.isEmpty()) {
            avg = (double) sum / listRating.size();
        }
        return avg;
    }

    /**
     * Check if Mentee has rated and commented on Mentor or not
     *
     * @param fromId it is an <code>java.lang.Integer</code>
     * @param toId it is an <code>java.lang.Integer</code>
     * @return a boolean value
     * @throws Exception
     */
    @Override
    public boolean checkDupRating(int fromId, int toId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [Rating] WHERE [fromId] = ? and [toId] = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fromId);
            ps.setInt(2, toId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();
            ps.close();
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
