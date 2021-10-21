/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CVDAO;
import dao.SkillDAO;
import dao.UserSkillDAO;
import dao.impl.CVDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserSkillDAOImpl;
import entity.CV;
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

/**
 * The class contain method get to redirect user to Create CV page Get all data
 * necessary to provide user and run to createCV jsp 
 * Will throw Exception and run to error jsp if any error occur
 *
 * @author thangtvhe1513077
 */
@WebServlet(name = "CreateCV", urlPatterns = {"/createCV"})
public class CreateCVController extends HttpServlet {

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
        
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CreateCVController.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String uid = request.getParameter("uId");

            SkillDAO skilldao = new SkillDAOImpl();
            ArrayList<Skill> allSkill = skilldao.getActiveSkill();
            
            request.setAttribute("uid", uid);
            request.setAttribute("allskill", allSkill);

            RequestDispatcher rd = request.getRequestDispatcher("/createCV.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(CreateCVController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", ex.getMessage());
            sendDispatcher(request, response, "/error.jsp");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            CVDAO cvdao = new CVDAOImpl();
            UserSkillDAO smdao = new UserSkillDAOImpl();

            
            int uid = Integer.parseInt(request.getParameter("uid"));
                
            String achievement = request.getParameter("achievement").trim();
            //System.out.println("achievement "+achievement);

            String  profession = request.getParameter("profession").trim();
            //System.out.println("profession "+profession);

            String professionIntro = request.getParameter("professionIntro").trim();
            //System.out.println("professionIntro "+professionIntro);

            String serviceDescription = request.getParameter("serviceDescription").trim();
            //System.out.println("serviceDescription "+serviceDescription);

            String[] skill_ids = request.getParameterValues("skills");

            CV mentorCV = new CV(uid, profession, professionIntro, serviceDescription, achievement);

            cvdao.insertCV(uid, mentorCV);
               
            smdao.updateMentorSkill(uid, skill_ids);
                
            request.setAttribute("success", "Create Mentor Successfuly");
            sendDispatcher(request, response, "/signIn.jsp");
            
        } catch (Exception e) {
            Logger.getLogger(CreateCVController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.getMessage());
            sendDispatcher(request, response, "/error.jsp");
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
