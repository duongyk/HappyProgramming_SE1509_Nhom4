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

import dao.ProblemDAO;
import dao.impl.ProblemDAOImpl;
import entity.Problem;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class has the process request of Change status of a Problem
 *
 * @author DuongVV
 */
public class ActiveProblemController extends HttpServlet {

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
            Logger.getLogger(ActiveProblemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Change the Status of a Problem by given ID.
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
            // get Problem
            int pId = Integer.parseInt(request.getParameter("pId"));
            Problem problem = pDAO.getProblem(pId);
            if (problem.getStatus() == 0) {
                pDAO.openProblem(pId);
            } else {
                pDAO.closeProblem(pId);
            }
            sendDispatcher(request, response, "viewProblem?pId=" + pId);
        } catch (Exception e) {
            Logger.getLogger(ActiveProblemController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
