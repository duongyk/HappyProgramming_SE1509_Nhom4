/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        DuongVV          First Deploy<br>
 * 18-10-2021    2.0        DuongVV          Update<br>
 */
package controller;

import dao.RequestDAO;
import dao.impl.RequestDAOImpl;
import entity.Request;
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
 * This class has the process request of List Request by me
 *
 * @author DuongVV
 */
public class ListRequestByMe extends HttpServlet {

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
            doGet(request, response);
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
            Logger.getLogger(ListRequestByMe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method. Get all the Request of the
     * Mentee
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
            RequestDAO requestDAO = new RequestDAOImpl();
            // Get current user
            User user = (User) request.getSession().getAttribute("currUser");
            // Get index page 
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            // Get list all Request of the user
            ArrayList<Request> listRequest = requestDAO.getListByMe(user);
            // Total request for paging
            int count = listRequest.size();
            // Calculate total page for paging
            int endPage = count / 8;
            if (count % 8 != 0) {
                endPage++;
            }
            // Set href of paging
            String href = "listRequestByMe?";
            // Get list Request by page
            ArrayList<Request> rList = requestDAO.listByMePaging(index, user.getId());
            // Get statistic requests
            ArrayList<Integer> statistic = requestDAO.getStatistic(user.getId());
            // Set attribute to request
            request.setAttribute("href", href);/*href paging*/
            request.setAttribute("rList", rList);/*Request List*/
            request.setAttribute("endPage", endPage);/*end page of paging*/
            request.setAttribute("index", index);/*index/current page*/
            request.setAttribute("statistic", statistic);/*Statistic request*/
            sendDispatcher(request, response, "listRequestByMe.jsp");
        } catch (Exception e) {
            Logger.getLogger(ListRequestByMe.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
