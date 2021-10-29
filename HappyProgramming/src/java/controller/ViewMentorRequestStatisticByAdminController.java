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
import dao.RequestDAO;
import dao.impl.RatingDAOImpl;
import dao.impl.RequestDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "ViewMentorRequestStatisticByAdmin", urlPatterns = {"/viewMentorRequestStatisticByAdmin"})
public class ViewMentorRequestStatisticByAdminController extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            RequestDAO requestdao = new RequestDAOImpl();
            
            int uId = Integer.parseInt(request.getParameter("uId"));
                        
            // get request statistic
            
            int invited = 0;
            int following = 0;
            int completed = 0;
            int canceled = 0;
            
            invited = requestdao.getMentorTotalRequestByStatus(uId, 1);
            following = requestdao.getMentorTotalRequestByStatus(uId, 2);
            completed = requestdao.getMentorTotalRequestByStatus(uId, 3);
            canceled = requestdao.getMentorTotalRequestByStatus(uId, 4);

            int total = invited+following+completed+canceled;

            double canceledpercentage = (double)(canceled) / (double)total * 100;
            double completedpercentage = (double) (completed) / (double)total * 100;

            // get mentor average rating
            RatingDAO ratingdao = new RatingDAOImpl();
            double rating = ratingdao.getAvgRate(uId);

            //set attributes

            request.setAttribute("invited", invited);
            request.setAttribute("following", following);
            request.setAttribute("completed", completed);
            request.setAttribute("canceled", canceled);

            request.setAttribute("canceledpercentage", Math.floor(canceledpercentage* 100) / 100);
            request.setAttribute("completedpercentage",Math.floor(completedpercentage * 100) / 100);
            
            request.setAttribute("rating", rating);
                                    
            sendDispatcher(request, response, "/statisticRequestMentorForAdmin.jsp");
        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ViewMentorRequestStatisticController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewMentorRequestStatisticByAdminController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewMentorRequestStatisticByAdminController.class.getName()).log(Level.SEVERE, null, ex);
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
