/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            if (category.equalsIgnoreCase("Skill")) {
                ArrayList<Skill> list = skillDAO.searchSkill(txtSearch);
                request.setAttribute("sList", list);
                request.setAttribute("txt", txtSearch);
                sendDispatcher(request, response, "searchSkill.jsp");
            }
            if (category.equalsIgnoreCase("Mentee")) {
                ArrayList<User> mList = userDAO.searchMentee(txtSearch);
                request.setAttribute("mList", mList);
                request.setAttribute("txt", txtSearch);
                sendDispatcher(request, response, "searchMentee.jsp");
            }
            if (category.equalsIgnoreCase("Message")) {
                ArrayList<Message> mList = messDAO.searchMessage(txtSearch);
                request.setAttribute("mList", mList);
                request.setAttribute("txt", txtSearch);
                sendDispatcher(request, response, "searchMessage.jsp");
            }

        } catch (Exception e) {
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
