/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0                         First Deploy<br>
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class will calculate statistic about a mentor rating 
 * include number of rating per star , percentage of rating
 * Will run to mentorRatingStatistic jsp with attribute data
 * Will throw Exception and run to error jsp if there any error
 * 
 * @author thangtvhe151307
 */
@WebServlet(name = "ViewMentorRatingStatisticController", urlPatterns = {"/viewMentorRatingStatistic"})
public class ViewMentorRatingStatisticController extends HttpServlet {

    /**
     * This method will get all rating of the mentor
     * include average rating, list of rating
     * forward to mentorRatingStatistic jsp
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RatingDAO ratingdao = new RatingDAOImpl();
            HttpSession session = request.getSession();
            UserDAO userDAO = new UserDAOImpl();
            
            try {
                User user;
                int id;
                // if user is admin    
                try{
                id = Integer.parseInt(request.getParameter("uId"));
                user = userDAO.getUserById(id);

                // if user is mentor
                } catch (Exception e) {

                user = (User) session.getAttribute("currUser");

                // not login or not mentor 
                if (user == null || user.getRole() != 2) { // return to sign in page
                    response.sendRedirect("signIn.jsp");
                    return;
                }

                id = user.getId();

                }

                // get rating statistic
                int five = ratingdao.getMentorNumberRating(id, 5);
                int four = ratingdao.getMentorNumberRating(id, 4); 
                int three = ratingdao.getMentorNumberRating(id, 3);
                int two = ratingdao.getMentorNumberRating(id, 2);
                int one = ratingdao.getMentorNumberRating(id, 1);

                int total = five + four + three + two + one;

                double average = ratingdao.getAvgRate(id);

                //set attributes

                ArrayList<Rating> ratingList = ratingdao.getRating(user);

                request.setAttribute("five", five);
                request.setAttribute("four", four);
                request.setAttribute("three", three);
                request.setAttribute("two", two);
                request.setAttribute("one", one);
                request.setAttribute("total", total);

                request.setAttribute("average", average);
                request.setAttribute("averageint", (int)average);

                request.setAttribute("ratingList", ratingList);
                request.setAttribute("user", user);
                sendDispatcher(request, response, "/mentorRatingStatistic.jsp");
            
            } catch (Exception e) {
                Logger.getLogger(ViewMentorRatingStatisticController.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("errorMessage", e.getMessage());
                sendDispatcher(request, response, "/error.jsp");
            }
        } catch (Exception e) {
            Logger.getLogger(ViewMentorRatingStatisticController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ViewMentorRatingStatisticController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ViewMentorRatingStatisticController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ViewMentorRatingStatisticController.class.getName()).log(Level.SEVERE, null, ex);
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
