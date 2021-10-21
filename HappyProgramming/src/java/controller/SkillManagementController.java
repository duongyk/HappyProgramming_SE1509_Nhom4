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
import dao.UserDAO;
import dao.impl.SkillDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Skill;
import entity.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Process:<br>
 * - Create new skill (admin)<br>
 * - List all skill<br>
 * - Paging<br>
 * Exception:<br>
 *
 *
 * @author giangnvthe150748
 */
public class SkillManagementController extends HttpServlet {

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
        SkillDAO skillDAO = new SkillDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        try {
            //get index page 
            String indexPage = request.getParameter("index");
            // index page always start at 1
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = skillDAO.getTotalSkill();
            //calculate total page for paging
            int endPage = count / 8; // a page will have at most 8 skills
            if (count % 8 != 0) { //if the total of skills is not divisible by 8, the last page will be added to show the remaining skills
                endPage++;
            }
            ArrayList<Skill> list = skillDAO.pagingSkill(index);
            ArrayList<User> menteeList = userDAO.getMenteeListSorted();
            //send informations to skillManagement.jsp
            request.setAttribute("sList", list);
            request.setAttribute("endPage", endPage);
              request.setAttribute("count", count);
            request.setAttribute("tag", index);
            request.setAttribute("menteeList", menteeList);
            request.getRequestDispatcher("skillManagement.jsp").forward(request, response);
        } catch (Exception e) {
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
