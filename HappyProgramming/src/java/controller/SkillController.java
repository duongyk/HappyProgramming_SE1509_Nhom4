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

import dao.SkillDAO;
import entity.Skill;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.SkillDAOImpl;
import entity.User;
import java.util.ArrayList;

/**
 * Process:<br>
 * - List all skill<br>
 * - Create skill<br>
 * - Search for skill by name <br>
 * Exception:<br>
 *
 *
 * @author giangnvthe150748
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");

            SkillDAO skillDAO = new SkillDAOImpl();

            if (service == null) {
                service = "";
            }
            if (service.equalsIgnoreCase("a")) {
                sendDispatcher(request, response, "login.jsp");
            }
            /* view list of all skill */
            if (service.equalsIgnoreCase("allSkill")) {
                User x = (User) request.getSession().getAttribute("currUser");
                ArrayList<Skill> sList = skillDAO.getActiveSkill();
                request.setAttribute("sList", sList);
                sendDispatcher(request, response, "listSkill.jsp");
            }

            /* search for skill by name */
            if (service.equalsIgnoreCase("searchSkill")) {
                ArrayList<Skill> sList = skillDAO.getAllSkill();
                request.setAttribute("sList", sList);
                sendDispatcher(request, response, "listAllSkills.jsp");
            }

            /* admin create new skill */
            if (service.equalsIgnoreCase("createSkill")) {
                //get infor of the skill from Input form
                String sName = request.getParameter("sName").trim();
                String sDetail = request.getParameter("sDetail").trim();
                String sImage = request.getParameter("sImage");
                //check duplicate skill in db
                if (skillDAO.findDupSkill(sName)) {
                    String mess = "Skill existed!";
                    request.setAttribute("mess", mess);
                    sendDispatcher(request, response, "createSkill.jsp");
                } else {
                    //insert new skill into db
                    skillDAO.insert(new Skill(sName, sDetail, sImage));
                    sendDispatcher(request, response, "AdminControllerMap?service=skillManage");
                }
            }

            /* admin update skill */
            if (service.equalsIgnoreCase("updateSkill")) {
                //get infor of the skill from Input form
                int sId = Integer.parseInt(request.getParameter("sId"));
                String sName = request.getParameter("sName").trim();
                String sDetail = request.getParameter("sDetail").trim();
                String sImage = request.getParameter("sImage");
                int status = Integer.parseInt(request.getParameter("status"));
                Skill skill = new Skill(sId, sName, sDetail, sImage, status);
                skillDAO.updateSkill(skill);
                sendDispatcher(request, response, "AdminControllerMap?service=skillManage");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SkillController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SkillController.class.getName()).log(Level.SEVERE, null, ex);
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
