/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CVDAO;
import dao.SkillDAO;
import dao.UserDAO;
import dao.UserSkillDAO;
import dao.impl.CVDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.UserSkillDAOImpl;
import entity.CV;
import entity.Skill;
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
 * - get skill <br>
 * - get mentor's ìnfomation<br>
 * Exception:<br>
 *
 *
 * @author ToanPKHE151393
 */
public class CVProfileController extends HttpServlet {

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
        try {
            CVDAO cvdao = new CVDAOImpl();
            UserDAO userDAO = new UserDAOImpl();
            SkillDAO skillDAO = new SkillDAOImpl();
            // get information
            UserSkillDAO smdao = new UserSkillDAOImpl();
            int mId = Integer.parseInt(request.getParameter("mId"));
            int sId = Integer.parseInt(request.getParameter("sId"));
            Skill skill = skillDAO.getSkillById(sId);
            User mentor = userDAO.getUserById(mId);
            ArrayList<Skill> sList = smdao.getAllSkillMentor(mId);
            // get information of user mentor
            CV cv = cvdao.getMentorCV(mId);
            request.setAttribute("cv", cv);
             // get information of user mentor's skill
            request.setAttribute("sList", sList);
            request.setAttribute("mentor", mentor);
            request.setAttribute("skill", skill);
            sendDispatcher(request, response, "cvMentor.jsp");
        } catch (Exception e) {

        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CVProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
