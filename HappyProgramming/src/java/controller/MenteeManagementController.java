/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        GiangNVT          First Deploy<br>
 */
package controller;

import dao.RequestDAO;
import dao.RequestSkillDAO;
import dao.UserDAO;
import dao.impl.RequestDAOImpl;
import dao.impl.RequestSkillDAOImpl;
import dao.impl.UserDAOImpl;
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
 * Process:<br>
 * - List all mentee(admin)<br>
 * - Statistic all mentee<br>
 * - Paging<br>
 * - Change status of mentee<br>
 * Exception:<br>
 *
 *
 * @author giangnvthe150748
 */
public class MenteeManagementController extends HttpServlet {

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
        UserDAO userDAO = new UserDAOImpl();
        RequestDAO requestDAO = new RequestDAOImpl();
        RequestSkillDAO requestSkillDAO = new RequestSkillDAOImpl();
        try {
            //get index page 
            String indexPage = request.getParameter("index");
            // index page always start at 1
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = userDAO.getUserByRole(1).size();
            int endPage = count / 8;  // a page will have at most 8 skills
            if (count % 8 != 0) { //if the total of skills is not divisible by 8, the last page will be added to show the remaining skills
                endPage++;
            }
            // Set href of paging
            String href = "menteeManagement?";
            //list all User that are Mentee have in database
            ArrayList<User> menteeList = userDAO.getUserByRolePaging(index, 1);
            //get total study hours from db
            int totalHour = requestDAO.getTotalHour();
            //get total skill from db
            int totalSkill = requestSkillDAO.getTotalRequest();
            //send informations to menteeManagement.jsp
            request.setAttribute("href", href);/*href paging*/
            request.setAttribute("endPage", endPage);
            request.setAttribute("count", count);
            request.setAttribute("index", index);
            request.setAttribute("totalHour", totalHour);
            request.setAttribute("totalSkill", totalSkill);
            request.setAttribute("menteeList", menteeList);
            sendDispatcher(request, response, "menteeManagement.jsp");
        } catch (Exception e) {
            Logger.getLogger(MenteeManagementController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(MenteeManagementController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MenteeManagementController.class.getName()).log(Level.SEVERE, null, ex);
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
