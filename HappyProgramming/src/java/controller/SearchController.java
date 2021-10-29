/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 27-10-2021    1.0        TungDT          First Deploy<br>
 */
package controller;

import dao.MessageDAO;
import dao.SkillDAO;
import dao.UserDAO;
import dao.impl.MessageDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Message;
import entity.Skill;
import entity.User;
import java.io.IOException;
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
 * @author solov
 */
@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

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
        SkillDAO skillDAO = new SkillDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        MessageDAO messDAO = new MessageDAOImpl();
        try {
            String category = request.getParameter("category");
            String txtSearch = request.getParameter("txtSearch");
            if (category.equalsIgnoreCase("Skill")) { // search skill name
                ArrayList<Skill> list = skillDAO.searchSkill(txtSearch); // get list of skill by name
                request.setAttribute("sList", list); // set attribute list
                request.setAttribute("txt", txtSearch); // set attribute txtSearch
                request.setAttribute("category", category); // set attribute category
                sendDispatcher(request, response, "searchSkill.jsp");
            }
            if (category.equalsIgnoreCase("Mentee")) { // search mentee name
                ArrayList<User> mList = userDAO.searchMentee(txtSearch); // get list of mentee by name
                request.setAttribute("mList", mList); // set attribute list
                request.setAttribute("category", category); // set attribute category
                request.setAttribute("txt", txtSearch); // set attribute txtSearch
                System.out.println(category);
                sendDispatcher(request, response, "searchMentee.jsp");
            }
            if (category.equalsIgnoreCase("Message")) { // search message name
                ArrayList<Message> mList = messDAO.searchMessage(txtSearch); // get list of message by name
                request.setAttribute("mList", mList); // set attribute list
                request.setAttribute("txt", txtSearch); //set attribute txtSearch
                request.setAttribute("category", category); // set attribute category
                sendDispatcher(request, response, "searchMessage.jsp");
            }
            if (category.equalsIgnoreCase("Mentor")) { // search mentor name
                ArrayList<User> mentorList = userDAO.searchMentor(txtSearch); // get list of mentor by name
                request.setAttribute("mentorList", mentorList); // set attribute list
                request.setAttribute("category", category); // set attribute category
                request.setAttribute("txt", txtSearch); //set attribute txtSearch
                System.out.println(category);
                sendDispatcher(request, response, "searchMentor.jsp");
            }

        } catch (Exception e) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
    }

    private void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
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
