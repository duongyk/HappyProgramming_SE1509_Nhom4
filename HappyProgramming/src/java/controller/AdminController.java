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
import dao.SkillDAO;
import dao.UserDAO;
import dao.impl.RequestDAOImpl;
import dao.impl.RequestSkillDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Skill;
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
 * Process:<br>
 * - Create new skill (admin)<br>
 * - Skill Management<br>
 *
 * Exception:<br>
 *
 *
 * @author giangnvthe150748
 */
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request it is a object of
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            SkillDAO skillDAO = new SkillDAOImpl();
            UserDAO userDAO = new UserDAOImpl();
            RequestDAO requestDAO = new RequestDAOImpl();
            RequestSkillDAO requestSkillDAO = new RequestSkillDAOImpl();

            String service = request.getParameter("service");

            // Set default service
            if (service == null) {
                service = "dashboard";
            }

            if (service.equalsIgnoreCase("dashboard")) {
                ArrayList<User> menteeList = userDAO.getUserByRole(1);
                ArrayList<User> mentorList = userDAO.getUserByRole(2);
                ArrayList<Skill> skillList = skillDAO.getAllSkill();

                request.setAttribute("menteeList", menteeList);
                request.setAttribute("mentorList", mentorList);
                request.setAttribute("skillList", skillList);
                sendDispatcher(request, response, "adminDashboard.jsp");
            }

            //direct user to create skill page
            if (service.equalsIgnoreCase("createSkill")) {
                sendDispatcher(request, response, "createSkill.jsp");
            }

            if (service.equalsIgnoreCase("updateSkill")) {
                int sId = Integer.parseInt(request.getParameter("sId"));
                Skill skill = skillDAO.getSkillById(sId);

                request.setAttribute("skill", skill);
                sendDispatcher(request, response, "updateSkill.jsp");
            }
            //admin manage skills
            if (service.equalsIgnoreCase("skillManage")) {
                //list all skills that have in database
                ArrayList<Skill> sList = skillDAO.getAllSkill();
                request.setAttribute("sList", sList);
                sendDispatcher(request, response, "skillManagement.jsp");
            }

            //admin manage skills
            if (service.equalsIgnoreCase("filterName")) {
                //list all skills that have in database
                ArrayList<User> menteeList = userDAO.getMenteeListSorted();
                
                int totalHour = requestDAO.getTotalHour();
                int totalSkill = requestSkillDAO.getTotalRequest();
                
                request.setAttribute("menteeList", menteeList);
                request.setAttribute("totalHour", totalHour);
                request.setAttribute("totalSkill", totalSkill);
                sendDispatcher(request, response, "menteeManagement.jsp");
            }
            
            if (service.equalsIgnoreCase("menteeManage")) {
                //list all User that are Mentee have in database
                ArrayList<User> menteeList = userDAO.getUserByRole(1);
                int totalHour = requestDAO.getTotalHour();
                int totalSkill = requestSkillDAO.getTotalRequest();

                request.setAttribute("totalHour", totalHour);
                request.setAttribute("totalSkill", totalSkill);
                request.setAttribute("menteeList", menteeList);
                sendDispatcher(request, response, "menteeManagement.jsp");
            }
        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
