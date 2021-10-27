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
import dao.impl.SkillDAOImpl;
import entity.Skill;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Process:<br>
 * - Create new skill<br>
 *
 * @author giangnvthe150748
 */
public class CreateSkillController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request it is a object of
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        SkillDAO skillDAO = new SkillDAOImpl();
        try {
            //get infor of the skill from Input form
            String sName = request.getParameter("sName").trim();
            String sDetail = request.getParameter("sDetail").trim();
            String sImage = request.getParameter("sImage");
            //check duplicate skill in db
            if (skillDAO.findDupSkill(sName)) {
                String mess = "Skill existed!";
                request.setAttribute("mess", mess);
                request.setAttribute("sName", sName);
                request.setAttribute("sDetail", sDetail);
                request.setAttribute("sImage", sImage);
                sendDispatcher(request, response, "createSkill.jsp");
            } else {
                //insert new skill into db
                skillDAO.insert(new Skill(sName, sDetail, sImage));
                sendDispatcher(request, response, "skillManagement");
            }

        } catch (Exception e) {
            Logger.getLogger(CreateSkillController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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

    private void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
