/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Duong
 */
public class RatingController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UserDAO userDAO = new UserDAO();
    RatingDAO ratingDAO = new RatingDAO();
    RequestDAO requestDAO = new RequestDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");

            if (service == null) {
                service = "getRating";
            }
            // get a Mentor's ratings
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

                sendDispatcher(request, response, "Rating.jsp");
            }

            // Mentee rates Mentor
            if (service.equalsIgnoreCase("rateMentor")) {
                // get current user/ Mentee who rates the Mentor
                User user = (User) request.getSession().getAttribute("currUser");
                // get Mentor
                int mId = Integer.parseInt(request.getParameter("mId"));
                
                //int mId= 6;
                User mentor = userDAO.getUserById(mId);
                // get rate and comment
                int rate = Integer.parseInt(request.getParameter("rate"));
                String comment = request.getParameter("comment");
                // create and insert rate
                Rating rating = new Rating(user, mentor, comment, rate);
                ratingDAO.insert(rating);

                sendDispatcher(request, response, "RatingControllerMap?service=getRating&uId="+mId);
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
