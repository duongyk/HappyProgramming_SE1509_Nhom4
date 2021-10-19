/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RatingDAO;
import dao.RequestDAO;
import dao.RequestSkillDAO;
import dao.SkillDAO;
import dao.UserDAO;
import dao.UserSkillDAO;
import dao.impl.RatingDAOImpl;
import dao.impl.RequestDAOImpl;
import dao.impl.RequestSkillDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.UserSkillDAOImpl;
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
        try {
            UserDAO userDAO = new UserDAOImpl();
            RatingDAO ratingDAO = new RatingDAOImpl();
            // get Mentor
            int mId = Integer.parseInt(request.getParameter("mId"));
            User mentor = userDAO.getUserById(mId);
            // get list Rating from Mentor
            ArrayList<Rating> listRating = ratingDAO.getRating(mentor);
            // get avarage rating
            String avg = ratingDAO.getAvgRate(mId);

            request.setAttribute("mId", mId);
            request.setAttribute("avg", avg);
            request.setAttribute("mentor", mentor);
            request.setAttribute("listRating", listRating);

            sendDispatcher(request, response, "rateComment.jsp");
        } catch (Exception e) {
            Logger.getLogger(RateComment.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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

                request.setAttribute("mId", mId);
                request.setAttribute("avg", avg);
                request.setAttribute("mentor", mentor);
                request.setAttribute("listRating", listRating);

                sendDispatcher(request, response, "rateComment.jsp");
            } else {
                // Get rate and comment
                int rate = Integer.parseInt(request.getParameter("rate"));
                String comment = request.getParameter("comment").trim();
                // Check comment blank
                if (comment.equals("")) {
                    String messBlank = "Comment contains only space, please Re-input";
                    request.setAttribute("messBlank", messBlank);

                    // get list Rating from Mentor
                    ArrayList<Rating> listRating = ratingDAO.getRating(mentor);
                    // get avarage rating
                    String avg = ratingDAO.getAvgRate(mId);

                    request.setAttribute("mId", mId);
                    request.setAttribute("avg", avg);
                    request.setAttribute("mentor", mentor);
                    request.setAttribute("listRating", listRating);

                    sendDispatcher(request, response, "rateComment.jsp");
                } else {
                    // Create and insert rate
                    Rating rating = new Rating(user, mentor, comment, rate);
                    ratingDAO.insert(rating);

                    // get list Rating from Mentor
                    ArrayList<Rating> listRating = ratingDAO.getRating(mentor);
                    // get avarage rating
                    String avg = ratingDAO.getAvgRate(mId);

                    request.setAttribute("mId", mId);
                    request.setAttribute("avg", avg);
                    request.setAttribute("mentor", mentor);
                    request.setAttribute("listRating", listRating);

                    sendDispatcher(request, response, "rateComment.jsp");
                }
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
