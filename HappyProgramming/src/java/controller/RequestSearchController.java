/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RequestDAO;
import dao.impl.RequestDAOImpl;
import entity.Request;
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
 * @author solov
 */
@WebServlet(name = "RequestSearchController", urlPatterns = {"/requestSearch"})
public class RequestSearchController extends HttpServlet {

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
        RequestDAO requestDAO = new RequestDAOImpl();
        try {
            String category = request.getParameter("category");
            String txtSearch = request.getParameter("txtSearch");
            ArrayList<Request> rList = new ArrayList<Request>();
            if (category.equalsIgnoreCase("All")) {
                rList = requestDAO.searchAllRequest(txtSearch);
                request.setAttribute("rList", rList);
                request.setAttribute("txt", txtSearch);
                request.setAttribute("category", category);
                sendDispatcher(request, response, "searchRequest.jsp");
            }
            if (category.equalsIgnoreCase("Pending")) {
                rList = requestDAO.searchAllRequestByStatus(1, txtSearch);
                request.setAttribute("rList", rList);
                request.setAttribute("txt", txtSearch);
                request.setAttribute("category", category);
                sendDispatcher(request, response, "searchRequest.jsp");
            }
            if (category.equalsIgnoreCase("In process")) {
                rList = requestDAO.searchAllRequestByStatus(2, txtSearch);
                request.setAttribute("rList", rList);
                request.setAttribute("txt", txtSearch);
                request.setAttribute("category", category);
                sendDispatcher(request, response, "searchRequest.jsp");
            }
            if (category.equalsIgnoreCase("Done")) {
                rList = requestDAO.searchAllRequestByStatus(3, txtSearch);
                request.setAttribute("rList", rList);
                request.setAttribute("txt", txtSearch);
                request.setAttribute("category", category);
                sendDispatcher(request, response, "searchRequest.jsp");
            }
            if (category.equalsIgnoreCase("Canceled")) {
                rList = requestDAO.searchAllRequestByStatus(4, txtSearch);
                request.setAttribute("rList", rList);
                request.setAttribute("txt", txtSearch);
                request.setAttribute("category", category);
                sendDispatcher(request, response, "searchRequest.jsp");
            }

        } catch (Exception e) {
            Logger.getLogger(RequestSearchController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }

    }

    private void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
