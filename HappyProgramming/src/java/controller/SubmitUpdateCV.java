/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CVDAO;
import dao.UserDAO;
import dao.UserSkillDAO;
import dao.impl.CVDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.UserSkillDAOImpl;
import entity.CV;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
 * The class contain the method update to process data from Create CV form
 * Data will be trimmed before processed
 * Redirect to profile jsp with success message if success
 * Redirect to profile jsp with error message if failure
 * The method will throw Exception if any error occur
 * 
 * @author thangtvhe151307
 */
@WebServlet(name = "SubmitUpdateCV", urlPatterns = {"/submitUpdateCV"})
public class SubmitUpdateCV extends HttpServlet {

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
            UserDAO userDAO = new UserDAOImpl();
            UserSkillDAO smdao = new UserSkillDAOImpl();
            
            HttpSession session = request.getSession();
            
            // get information
                
            int uid = Integer.parseInt(request.getParameter("uid").trim());
            //System.out.println("uid "+uid);

            String fullname= request.getParameter("fullname").trim();
            //System.out.println("fullname "+fullname);

            SimpleDateFormat dateFormat = 
              new SimpleDateFormat("yyyy-MM-dd");

            Date dob = Date.valueOf(request.getParameter("dob"));

            String avatar = request.getParameter("avatar").trim();

            User user = (User) session.getAttribute("currUser");

            // if user not choose avatar
            if(avatar.equals("") || avatar == null ) { 

                avatar = user.getAvatar();
            } else  { // set new avatar in session
                user.setAvatar(avatar);
            }

            String sex = request.getParameter("sex");
            //System.out.println("sex "+sex);

            String mail = request.getParameter("mail").trim();
            //System.out.println("mail "+mail);

            String phone = request.getParameter("phone").trim();
            //System.out.println("phone "+phone);

            String achievement = request.getParameter("achievement").trim();
            //System.out.println("achievement "+achievement);

            String  profession = request.getParameter("profession").trim();
            //System.out.println("profession "+profession);

            String professionIntro = request.getParameter("professionIntro").trim();
            //System.out.println("professionIntro "+professionIntro);

            String serviceDescription = request.getParameter("serviceDescription").trim();
            //System.out.println("serviceDescription "+serviceDescription);

            String[] skill_id = request.getParameterValues("skills");

            //----------------------------------

            //       update user 

            User mentorInfo = new User(uid, "", "", fullname, mail, phone, dob, sex, avatar, 2);

            CV mentorCV = new CV(uid, profession, professionIntro, serviceDescription, achievement);
            
            // variable to check if dao update successs
            userDAO.updateUserInfo(uid, mentorInfo);
                        
            cvdao.updateCV(uid, mentorCV);
                      
            smdao.updateMentorSkill(uid, skill_id);
                       
            // ----------------------------------------
 
            request.getSession().setAttribute("currUser", mentorInfo); // set current user with updated info
            request.setAttribute("success", "Update CV success");
            sendDispatcher(request, response, "/UserControllerMap?service=profile&uId="+uid);
            
            
            
        } catch (Exception e) {
            Logger.getLogger(SubmitUpdateCV.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.getMessage());
            sendDispatcher(request, response, "/error.jsp");
        }
    }
    
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SubmitUpdateCV.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SubmitUpdateCV.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SubmitUpdateCV.class.getName()).log(Level.SEVERE, null, ex);
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
