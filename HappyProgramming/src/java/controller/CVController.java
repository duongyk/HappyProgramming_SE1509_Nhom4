/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.CVDAO;
import dao.impl.SkillDAO;
import dao.impl.SkillMentorDAO;
import dao.impl.UserDAO;
import entity.CV;
import entity.Skill;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class CVController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            
            CVDAO cvdao = new CVDAO();
            UserDAO userdao = new UserDAO();
            SkillMentorDAO smdao = new SkillMentorDAO();
            
            HttpSession session = request.getSession();
            
            if(service.equals("updateCV")) {
                int uid = Integer.parseInt(request.getParameter("uid"));
                
                CV mentorCV = cvdao.getMentorCV(uid);
                
                User mentorProfile = userdao.getUserById(uid);
                
                // get all skill id from mentor
                ArrayList<String> mentorSkill = smdao.getAll_Id_Skill_Mentor(uid);
                
                //get all available skill
                SkillDAO skilldao = new SkillDAO();
                
                ArrayList<Skill> allSkill = skilldao.getAllSkill();
                
                request.setAttribute("allskill", allSkill);
                request.setAttribute("mentorskill", mentorSkill);
                session.setAttribute("mentorprofile", mentorProfile);
                request.setAttribute("mentorcv", mentorCV);
                request.setAttribute("title","UPDATE CV");
                
                RequestDispatcher rd = request.getRequestDispatcher("/updateCV.jsp");
                
                rd.forward(request, response);

            }
            
            /*
            if(service.equals("submitFormUpdate")) {
                String[] skill_id_list = request.getParameterValues("skills");
                
                SkillDAO skilldao = new SkillDAO();
                
                for(String id: skill_id_list) {
                    
                    Skill skill = skilldao.getSkillById(id);
                    
                    out.println("<h3>"+skill.getsName()+"</h3>");
                }
            }
            */
            
            if(service.equals("submitFormUpdate")) {
                
                // get information
                
                int uid = Integer.parseInt(request.getParameter("uid"));
                //System.out.println("uid "+uid);
                
                String username = request.getParameter("username");
                //System.out.println("username "+username);

                
                String fullname= request.getParameter("fullname");
                //System.out.println("fullname "+fullname);
                
                SimpleDateFormat dateFormat = 
                  new SimpleDateFormat("yyyy-MM-dd");
                
                Date dob = new Date();
                
                try {
                    dob = dateFormat.parse(request.getParameter("dob"));
                    //System.out.println(dateFormat.format(dob));
                } catch (ParseException ex) {
                    Logger.getLogger(CVController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String sex = request.getParameter("sex");
                //System.out.println("sex "+sex);
                
                String mail = request.getParameter("mail");
                //System.out.println("mail "+mail);
                
                String phone = request.getParameter("phone");
                //System.out.println("phone "+phone);
                
                String achievement = request.getParameter("achievement");
                //System.out.println("achievement "+achievement);
                
                String  profession = request.getParameter("profession");
                //System.out.println("profession "+profession);
                
                String professionIntro = request.getParameter("professionIntro");
                //System.out.println("professionIntro "+professionIntro);
                
                String serviceDescription = request.getParameter("serviceDescription");
                //System.out.println("serviceDescription "+serviceDescription);
                
                String[] skill_id = request.getParameterValues("skills");
                
                //----------------------------------
                
                //       update user 
                
                User mentorInfo = new User(uid, "", "", fullname, mail, phone, dob, sex, "", 2);
                
                CV mentorCV = new CV(uid, profession, professionIntro, serviceDescription, achievement);
          
                userdao.updateUserInfo(uid, mentorInfo);
                cvdao.updateCV(uid, mentorCV);
                smdao.updateMentorSkill(uid, skill_id);
                
                // ----------------------------------------
                
                response.sendRedirect("demoMentorList.jsp");
            }
            
            
            if(service.equals("viewCVSkill")) {
                
                int uid = Integer.parseInt(request.getParameter("uid"));
                                
                ArrayList<Skill> skillList = smdao.getAll_Skill_Mentor(uid);
                
                request.setAttribute("skilllist", skillList);
                request.setAttribute("uid", uid);
                
                RequestDispatcher rd = request.getRequestDispatcher("/demoMentorSkill.jsp");
                rd.forward(request, response);
                
                
            }
            
            if(service.equals("createCV")) {
                
                int uid = Integer.parseInt(request.getParameter("uid"));
                
                request.setAttribute("uid", uid);
                
                SkillDAO skilldao = new SkillDAO();
                ArrayList<Skill> allSkill = skilldao.getAllSkill();
                request.setAttribute("allSkill", allSkill);
                
                RequestDispatcher rd = request.getRequestDispatcher("/createCV.jsp");
                rd.forward(request, response);
                
            }
            
            if(service.equals("submitCreateForm")) {
                
                int uid = Integer.parseInt(request.getParameter("uid"));
                
                String achievement = request.getParameter("achievement");
                //System.out.println("achievement "+achievement);
                
                String  profession = request.getParameter("profession");
                //System.out.println("profession "+profession);
                
                String professionIntro = request.getParameter("professionIntro");
                //System.out.println("professionIntro "+professionIntro);
                
                String serviceDescription = request.getParameter("serviceDescription");
                //System.out.println("serviceDescription "+serviceDescription);
                
                String[] skill_id = request.getParameterValues("skills");
                
                CV mentorCV = new CV(uid, profession, professionIntro, serviceDescription, achievement);
                
                cvdao.insertCV(uid, mentorCV);
                
                smdao.updateMentorSkill(uid, skill_id);
                
                response.sendRedirect("demoMentorList.jsp");
                
            }
            
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