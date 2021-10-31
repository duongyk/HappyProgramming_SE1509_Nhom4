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
 * This class has the process request of Forum
 *
 * @author DuongVV
 */
public class ForumController extends HttpServlet {

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
            Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            // initiate DAO
            ProblemDAO pDAO = new ProblemDAOImpl();
            ProblemAnswerDAO paDAO = new ProblemAnswerDAOImpl();
            // Get index page 
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            // Total request for paging
            int count = pDAO.countProblem();
            // Calculate total page for paging
            int endPage = count / 4;
            if (count % 4 != 0) {
                endPage++;
            }
            // Get Problem list
            ArrayList<Problem> pList = pDAO.getProblemListPaging(index);
            // Set list of total number answer
            ArrayList<Integer> answerNumber = new ArrayList<>();
            for (Problem p : pList) {
                answerNumber.add(paDAO.countProblemAnswer(p.getId()));
            }
            // Set href of paging
            String href = "forum?";
            request.setAttribute("href", href);/*href paging*/
            request.setAttribute("endPage", endPage);/*end page of paging*/
            request.setAttribute("index", index);/*index/current page*/
            request.setAttribute("pList", pList);/*Problem List*/
            request.setAttribute("answerNumber", answerNumber);/*List number of Answer*/
            sendDispatcher(request, response, "forum.jsp");
        } catch (Exception e) {
            Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
