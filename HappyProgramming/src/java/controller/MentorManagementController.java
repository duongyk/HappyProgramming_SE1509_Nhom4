/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 28-10-2021    1.0        TungDT          First Deploy<br>
 */
package controller;

import dao.RequestDAO;
import dao.UserDAO;
import dao.impl.RequestDAOImpl;
import dao.impl.UserDAOImpl;
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

/**
 *
 * @author Tung
 */
@WebServlet(name = "MentorManagementController", urlPatterns = {"/MentorManagementController"})
public class MentorManagementController extends HttpServlet {

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
            
        }
    }
    
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(MentorManagementController.class.getName()).log(Level.SEVERE, null, ex);
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
            RequestDAO requestDAO = new RequestDAOImpl();
            
            //get index page 
            String indexPage = request.getParameter("index");
            // index page always start at 1
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = userDAO.getUserByRole(2).size();
            int endPage = count / 8;
            if (count % 8 != 0) {
                endPage++;
            }
            
            String href = "MentorManagementController?"; // Set href of paging
            
            ArrayList<User> mentorList = userDAO.getUserByRolePaging(index ,2); // get list of user whose role = 2/Mentor
            int totalRequest = requestDAO.getNumberOfRequest(); // get total number of request sent to user
            int totalHour = requestDAO.getTotalHour(); // get total number of hour requested to user
            
            request.setAttribute("mentorList", mentorList); // set mentor list to display
            request.setAttribute("totalRequestedHour", totalHour); // set mentor list to display
            request.setAttribute("numberOfRequest", totalRequest); // set mentor list to display
            
            //send informations to menteeManagement.jsp
            request.setAttribute("href", href);//href paging
            request.setAttribute("endPage", endPage); //end page of paging
            request.setAttribute("count", count); // count for page number
            request.setAttribute("tag", index); //current page
            
            sendDispatcher(request, response, "mentorManagement.jsp");
        }
        catch (Exception ex) {
            Logger.getLogger(MentorManagementController.class.getName()).log(Level.SEVERE, null, ex);
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
        }
        catch (Exception ex) {
            Logger.getLogger(MentorManagementController.class.getName()).log(Level.SEVERE, null, ex);
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
