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

import dao.RequestDAO;
import dao.RequestSkillDAO;
import dao.impl.RequestDAOImpl;
import dao.impl.RequestSkillDAOImpl;
import entity.Request;
import entity.Skill;
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
 * The class contains method get data from Request and RequestSkill table
 * Request Detail is get through rId from URL
 * Run to viewRequestMentor jsp if success 
 * Will throw Exception if any error occur
 * 
 * @author thangtvhe151307
 */
@WebServlet(name = "ViewMentorRequestDetail", urlPatterns = {"/viewMentorRequestDetail"})
public class ViewMentorRequestDetailController extends HttpServlet {

    /**
     * This method will get the detail about the request for mentor
     * and process to viewRequestMentor jsp
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDAO requestDAO = new RequestDAOImpl();
        RequestSkillDAO requestSkillDAO = new RequestSkillDAOImpl(); 
        HttpSession session = request.getSession();
        
        try (PrintWriter out = response.getWriter()) {
            
        // get request
        int rId = Integer.parseInt(request.getParameter("rId"));
        Request req = requestDAO.getRequestById(rId);

        // get request skill
        ArrayList<Skill> sList = requestSkillDAO.getSkill(rId);

        request.setAttribute("sList", sList);
        request.setAttribute("req", req);
        sendDispatcher(request, response, "viewRequestMentor.jsp");
        } catch (Exception e) {
            Logger.getLogger(ViewMentorRequestDetailController.class.getName()).log(Level.SEVERE, null, e);
            
            session.setAttribute("error", "Cant view request detail");
            String referer = request.getHeader("Referer");
            response.sendRedirect(referer);
            
        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ViewMentorRequestDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewMentorRequestDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewMentorRequestDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
