/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        DuongVV          First Deploy<br>
 * 18-10-2021    2.0        DuongVV          Update<br>
 */
package controller;

import dao.RatingDAO;
import dao.UserDAO;
import dao.impl.RatingDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Rating;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class has the process request of Rate and Comment
 *
 * @author DuongVV
 */
public class RateCommentController extends HttpServlet {

    /**
     * Forward the request to the destination, catch any unexpected exceptions
     * and log it
     *
     * @param request Request of the servlet
     * @param response Response of the servlet
     * @param path Forward address
     */
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RateCommentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get all the Rate and Comment of the Mentor.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // initiate DAO
            UserDAO userDAO = new UserDAOImpl();
            RatingDAO ratingDAO = new RatingDAOImpl();
            // get Mentor
            int mId = Integer.parseInt(request.getParameter("mId"));
            User mentor = userDAO.getUserById(mId);
            // get list Rating from Mentor
            ArrayList<Rating> listRating = ratingDAO.getRating(mentor);
            // get avarage rating
            double avg = ratingDAO.getAvgRate(mId);
            request.setAttribute("avg", String.format("%.2f", avg));/*Avarage rating*/
            request.setAttribute("mentor", mentor);/*Mentor*/
            request.setAttribute("listRating", listRating);/*List Rate and Comment*/

            sendDispatcher(request, response, "rateComment.jsp");
        } catch (Exception e) {
            Logger.getLogger(RateCommentController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Create new Rate and Comment and insert it into the Database.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // initiate DAO
            UserDAO userDAO = new UserDAOImpl();
            RatingDAO ratingDAO = new RatingDAOImpl();
            // Get current User/ Mentee who rates the Mentor
            User user = (User) request.getSession().getAttribute("currUser");
            // Get Mentor
            int mId = Integer.parseInt(request.getParameter("mId"));
            User mentor = userDAO.getUserById(mId);
            // Check if the User had rated the Mentor or not
            if (ratingDAO.checkDupRating(user.getId(), mId)) {
                String mess = "You have already Rated and commented";
                request.setAttribute("mess", mess);
                // get list Rating from Mentor
                ArrayList<Rating> listRating = ratingDAO.getRating(mentor);
                // get avarage rating
                double avg = ratingDAO.getAvgRate(mId);

                request.setAttribute("avg", String.format("%.2f", avg));/*Avarage rating*/
                request.setAttribute("mentor", mentor);/*Mentor*/
                request.setAttribute("listRating", listRating);/*List rating*/

                sendDispatcher(request, response, "rateComment.jsp");
            } else {
                // Get rate and comment
                int rate = Integer.parseInt(request.getParameter("rate"));
                String comment = request.getParameter("comment").trim();

                // Create and insert rate
                Rating rating = new Rating(user, mentor, comment, rate);
                ratingDAO.insert(rating);

                // get list Rating from Mentor
                ArrayList<Rating> listRating = ratingDAO.getRating(mentor);
                // get avarage rating
                double avg = ratingDAO.getAvgRate(mId);

                request.setAttribute("avg", String.format("%.2f", avg));/*Avarage rating*/
                request.setAttribute("mentor", mentor);/*Mentor*/
                request.setAttribute("listRating", listRating);/*List rating*/

                sendDispatcher(request, response, "rateComment.jsp");
            }
        } catch (Exception e) {
            Logger.getLogger(RateCommentController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
