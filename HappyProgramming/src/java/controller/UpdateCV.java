/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CVDAO;
import dao.UserSkillDAO;
import dao.impl.CVDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserSkillDAOImpl;
import entity.CV;
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
import javax.servlet.http.HttpSession;

/**
 * The class contain the method insert, update to process data from Create CV form
 * Data will be trimmed before processed
 * Redirect to signIn jsp if success
 * The method will throw Exception and run to error jsp if any error occur
 * 
 * @author Trinh Viet Thang
 */
@WebServlet(name = "UpdateCV", urlPatterns = {"/updateCV"})
public class UpdateCV extends HttpServlet {

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
            
            CVDAO cvdao = new CVDAOImpl();
            UserSkillDAO smdao = new UserSkillDAOImpl();

            HttpSession session = request.getSession();
            
            int uid = Integer.parseInt(request.getParameter("uid"));
                
            CV mentorCV = cvdao.getMentorCV(uid);

            //User mentorProfile = userDAO.getUserById(uid);
            User mentorProfile = (User) session.getAttribute("currUser");

            // get all skill id from mentor
            ArrayList<String> mentorSkill = smdao.getAll_Id_Skill_Mentor(uid);

            //get all available skill
            SkillDAOImpl skilldao = new SkillDAOImpl();

            ArrayList<Skill> allSkill = skilldao.getActiveSkill();

            request.setAttribute("allskill", allSkill);
            request.setAttribute("mentorskill", mentorSkill);
            session.setAttribute("mentorprofile", mentorProfile);
            request.setAttribute("mentorcv", mentorCV);
            request.setAttribute("title","UPDATE CV");

            RequestDispatcher rd = request.getRequestDispatcher("/updateCV.jsp");
            //RequestDispatcher rd = request.getRequestDispatcher("/newUpdateCV.jsp");

            rd.forward(request, response);
        } catch (Exception ex) {
            
            request.setAttribute("errorMessage", ex.getMessage());
            sendDispatcher(request, response, "/error.jsp");
        }
    }
    
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UpdateCV.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateCV.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateCV.class.getName()).log(Level.SEVERE, null, ex);
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
