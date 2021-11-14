/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SkillDAO;
import dao.impl.SkillDAOImpl;
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
 *
 * @author Tung
 */
@WebServlet(name = "SearchSkillPublicController", urlPatterns = {"/SearchSkillPublicController"})
public class SearchSkillPublicController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchSkillPublicController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchSkillPublicController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Forward the request to the destination, catch any unexpected exceptions
     * and log it
     *
     * @param request Request of the servlet
     * @param response Response of the servlet
     * @param path Forward address
     */
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SearchSkillPublicController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            SkillDAO skillDAO = new SkillDAOImpl();
            
            String name = request.getParameter("name").trim();
            
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            
            ArrayList<Skill> sList = skillDAO.getSkillByNameFilterPaging(index, name);
            
            int count = skillDAO.getTotalSkillFilterName(name);
            int endPage = count / 8;
            if (count % 8 != 0) {
                endPage++;
            }
            // Set href of paging
            String href = "SearchSkillPublicController?";
            request.setAttribute("name", name);
            request.setAttribute("href", href);/*href paging*/
            request.setAttribute("endPage", endPage);/*end page of paging*/
            request.setAttribute("index", index);/*index/current page*/
            request.setAttribute("sList", sList); // set list of active skill
            sendDispatcher(request, response, "listSkill.jsp");
            
        } catch (Exception ex) {
            Logger.getLogger(SearchSkillPublicController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
