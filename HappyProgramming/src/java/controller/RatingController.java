/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        DuongVV          First Deploy<br>
 */
package controller;

import dao.impl.RatingDAO;
import dao.impl.RequestDAO;
import dao.impl.UserDAO;
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
 * Process:<br>
 * - Get Rating and comment of Mentor<br>
 * - Create new Rating and comment<br>
 *
 * Exception:<br>
 * - If output failed, it will return to error page.
 *
 * @author duongvvhe150773
 */
public class RatingController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request it is a object of
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");
            UserDAO userDAO = new UserDAO();
            RatingDAO ratingDAO = new RatingDAO();
            RequestDAO requestDAO = new RequestDAO();

            // Set default service
            if (service == null) {
                service = "";
            }

            // Get a Mentor's ratings
            if (service.equalsIgnoreCase("getRating")) {
                // get Mentor
                int mId = Integer.parseInt(request.getParameter("uId"));
                User mentor = userDAO.getUserById(mId);
                // get list Rating from Mentor
                ArrayList<Rating> listRating = ratingDAO.getRating(mentor);
                // get avarage rating
                String avg = ratingDAO.getAvgRate(mId);

                request.setAttribute("avg", avg);
                request.setAttribute("mentor", mentor);
                request.setAttribute("listRating", listRating);

                sendDispatcher(request, response, "rating.jsp");
            }

            // Mentee rates Mentor
            if (service.equalsIgnoreCase("rateMentor")) {
                // Get current user/ Mentee who rates the Mentor
                User user = (User) request.getSession().getAttribute("currUser");
                // Get Mentor
                int mId = Integer.parseInt(request.getParameter("mId"));

                //int mId= 6;
                User mentor = userDAO.getUserById(mId);
                // Get rate and comment
                int rate = Integer.parseInt(request.getParameter("rate"));
                String comment = request.getParameter("comment").trim();
                // Create and insert rate
                Rating rating = new Rating(user, mentor, comment, rate);
                ratingDAO.insert(rating);

                sendDispatcher(request, response, "RatingControllerMap?service=getRating&uId=" + mId);
            }
        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
