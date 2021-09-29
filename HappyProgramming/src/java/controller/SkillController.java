/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Skill;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.SkillDAO;
import entity.User;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public class SkillController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    SkillDAO skillDAO = new SkillDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) { 
            String service = request.getParameter("service");
            if (service == null) {
                service = "a";
            }
            if (service.equalsIgnoreCase("a")) {
                sendDispatcher(request, response, "login.jsp");
            }
             /* view list of all skill */
            if (service.equalsIgnoreCase("allSkill")) {
                User x = (User) request.getSession().getAttribute("currUser");
                ArrayList<Skill> sList = skillDAO.getAllSkill();
                request.setAttribute("sList", sList);
                sendDispatcher(request, response, "All-skills.jsp");
            }
            
            
            /* search for skill by name */
            if (service.equalsIgnoreCase("searchSkill")) {
                ArrayList<Skill> sList = skillDAO.getAllSkill();
                request.setAttribute("sList", sList);
                sendDispatcher(request, response, "All-skills.jsp");
            }
            
            
            if (service.equalsIgnoreCase("createSkill")) {
                String sName = request.getParameter("sName");
                String sDetail = request.getParameter("sDetail");
                String sImage = request.getParameter("sImage");
                if (skillDAO.findDupSkill(sName)) {
                    String mess = "Skill existed!";
                    request.setAttribute("mess", mess);
                    sendDispatcher(request, response, "createSkill.jsp");
                } else {
                    skillDAO.insert(new Skill(sName, sDetail, sImage));
                    sendDispatcher(request, response, "SkillControllerMap?service=allSkill");
                }
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
