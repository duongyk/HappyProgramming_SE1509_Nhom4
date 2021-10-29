/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-10-2021    1.0        DuongVV          First Deploy<br>
 */
package controller;

import dao.ProblemAnswerDAO;
import dao.ProblemDAO;
import dao.impl.ProblemAnswerDAOImpl;
import dao.impl.ProblemDAOImpl;
import entity.Problem;
import entity.ProblemAnswer;
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
 * This class has the process request of Post a Answer to a Problem
 *
 * @author DuongVV
 */
public class PostAnswerController extends HttpServlet {

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
            out.println("<title>Servlet PostAnswerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostAnswerController at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(PostAnswerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            // initiate DAO
            ProblemDAO pDAO = new ProblemDAOImpl();
            ProblemAnswerDAO paDAO = new ProblemAnswerDAOImpl();
            // Get current user
            User user = (User) request.getSession().getAttribute("currUser");
            // Get input and Insert new Answer
            int pId = Integer.parseInt(request.getParameter("pId"));
            String content = request.getParameter("content").trim();
            paDAO.insertProblemAnswer(pId, user.getId(), content);
            // Get Problem
            Problem problem = pDAO.getProblem(pId);
            // Set index page 
            int index = 1;
            // Total request for paging
            int count = paDAO.countProblemAnswer(pId);
            // Calculate total page for paging
            int endPage = count / 4;
            if (count % 4 != 0) {
                endPage++;
            }
            // Get Problem Answer
            ArrayList<ProblemAnswer> paList = paDAO.getProblemAnswerList(index, pId);
            // Get number of Answer
            int answerNumber = paDAO.countProblemAnswer(pId);
            //Set href paging
            String href = "viewProblem?pId="+pId+"&";
            
            request.setAttribute("href", href);/*href paging*/
            request.setAttribute("endPage", endPage);/*end page of paging*/
            request.setAttribute("index", index);/*index/current page*/
            request.setAttribute("problem", problem);/*Problem*/
            request.setAttribute("answerNumber", answerNumber);/*Problem*/
            request.setAttribute("messSucc", "Post Answer Successfully");/*messSucc*/
            request.setAttribute("paList", paList);/*ProblemAnswer List*/
            sendDispatcher(request, response, "viewProblem.jsp");
        } catch (Exception e) {
            Logger.getLogger(PostAnswerController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
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
