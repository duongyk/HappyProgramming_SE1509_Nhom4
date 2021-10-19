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
import java.io.PrintWriter;
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
public class RateComment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RateComment</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RateComment at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
            Logger.getLogger(RateComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method. Get all the Rate and Comment of
     * the Mentor
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
            String avg = ratingDAO.getAvgRate(mId);

            request.setAttribute("avg", avg);
            /*Avarage rating*/
            request.setAttribute("mentor", mentor);
            /*Mentor*/
            request.setAttribute("listRating", listRating);

            sendDispatcher(request, response, "rateComment.jsp");
        } catch (Exception e) {
            Logger.getLogger(RateComment.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method. Create new Rate and Comment
     * and insert it into the Database
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
                String avg = ratingDAO.getAvgRate(mId);

                request.setAttribute("avg", avg);/*Avarage rating*/
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
                String avg = ratingDAO.getAvgRate(mId);

                request.setAttribute("avg", avg);/*Avarage rating*/
                request.setAttribute("mentor", mentor);/*Mentor*/
                request.setAttribute("listRating", listRating);/*List rating*/

                sendDispatcher(request, response, "rateComment.jsp");
            }
        } catch (Exception e) {
            Logger.getLogger(RateComment.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
