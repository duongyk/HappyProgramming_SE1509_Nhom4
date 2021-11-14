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
     * This GET method will get all data necessary and forward user to createCV jsp
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

            SkillDAO skilldao = new SkillDAOImpl();
            ArrayList<Skill> allSkill = skilldao.getActiveSkill();
            HttpSession session = request.getSession();
            
            try {
                request.setAttribute("allskill", allSkill);

                RequestDispatcher rd = request.getRequestDispatcher("/createCV.jsp");
                rd.forward(request, response);
            
            } catch (Exception ex) {
                Logger.getLogger(CreateCVController.class.getName()).log(Level.SEVERE, null, ex);
                session.setAttribute("error", "Cant get create CV page. Create Mentor failed");
                sendDispatcher(request, response, "/signIn.jsp");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CreateCVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This POST method will process all data
     * user submit from createCV jsp
     * and store in database
     * If success if will return to signIn jsp
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
        
        HttpSession session = request.getSession();
        CVDAO cvdao = new CVDAOImpl();
        UserSkillDAO smdao = new UserSkillDAOImpl();
        UserDAO userdao = new UserDAOImpl();
        
        try (PrintWriter out = response.getWriter()) {
            
            try {
                String achievement = request.getParameter("achievement").trim();
                //System.out.println("achievement "+achievement);

                String  profession = request.getParameter("profession").trim();
                //System.out.println("profession "+profession);

                String professionIntro = request.getParameter("professionIntro").trim();
                //System.out.println("professionIntro "+professionIntro);

                String serviceDescription = request.getParameter("serviceDescription").trim();
                //System.out.println("serviceDescription "+serviceDescription);

                String[] skill_ids = request.getParameterValues("skills");

                User newuser = (User) session.getAttribute("user");

                userdao.signUp(newuser);

                int uid = userdao.checkAccount(newuser.getUsername()).getId();

                CV mentorCV = new CV(uid, profession, professionIntro, serviceDescription, achievement);

                cvdao.insertCV(uid, mentorCV);

                smdao.updateMentorSkill(uid, skill_ids);

                session.setAttribute("success", "Create Mentor Successfuly");
                sendDispatcher(request, response, "/signIn.jsp");
            
            } catch (Exception e) {
                Logger.getLogger(CreateCVController.class.getName()).log(Level.SEVERE, null, e);
                // delete inputed information
                User newuser = (User) session.getAttribute("user");

                try {
                    User user = userdao.checkAccount(newuser.getUsername());

                    int uid = user.getId();

                    smdao.deleteUserSkill(uid);
                    cvdao.deleteCV(uid);
                    userdao.deleteUser(uid);

                    session.setAttribute("error", "Cant update to database.Create Mentor Failed");
                    sendDispatcher(request, response, "/signIn.jsp");

                } catch (Exception ex) {
                    Logger.getLogger(CreateCVController.class.getName()).log(Level.SEVERE, null, ex);
                    session.setAttribute("error", "Cant update to database.Create Mentor Failed");
                    sendDispatcher(request, response, "/signIn.jsp");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(CreateCVController.class.getName()).log(Level.SEVERE, null, e);
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
