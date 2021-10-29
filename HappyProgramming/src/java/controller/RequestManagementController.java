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
@WebServlet(name = "RequestManagementController", urlPatterns = {"/requestManagement"})
public class RequestManagementController extends HttpServlet {

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
            ArrayList<Request> list = new ArrayList<Request>();
            list = requestDAO.getAllRequest();
            //get index page 
            String indexPage = request.getParameter("index");
            // index page always start at 1
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = list.size();
            //calculate total page for paging
            int endPage = count / 8; // a page will have at most 8 skills
            if (count % 8 != 0) { //if the total of skills is not divisible by 8, the last page will be added to show the remaining skills
                endPage++;
            }
            ArrayList<Request> rList = requestDAO.requestPaging(index);
            int process = requestDAO.getTotalRequestByStatus(2);
            int done = requestDAO.getTotalRequestByStatus(3);
            int canceled = requestDAO.getTotalRequestByStatus(4);
            // Set href of paging
            String href = "requestManagement?";
            request.setAttribute("rList", rList);
            request.setAttribute("list", list);
            request.setAttribute("process", process);
            request.setAttribute("done", done);
            request.setAttribute("canceled", canceled);
            request.setAttribute("href", href);/*href paging*/
            request.setAttribute("endPage", endPage);
            request.setAttribute("count", count);
            request.setAttribute("tag", index);
            sendDispatcher(request, response, "requestManagement.jsp");

        } catch (Exception e) {
            Logger.getLogger(RequestManagementController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RequestManagementController.class.getName()).log(Level.SEVERE, null, ex);
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
