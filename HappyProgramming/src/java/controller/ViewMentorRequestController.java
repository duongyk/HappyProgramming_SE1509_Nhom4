/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RatingDAO;
import dao.RequestDAO;
import dao.impl.RatingDAOImpl;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The class contains method get data from Request table
 * Request List is get through status from URL and mentor id from session
 * Run to mentorRequestList jsp if success
 * Will throw Exception if any error occur
 * 
 * @author thangtvhe151307
 */
@WebServlet(name = "ViewMentorRequest", urlPatterns = {"/viewMentorRequest"})
public class ViewMentorRequestController extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        RequestDAO requestdao = new RequestDAOImpl();
    
        // get status from URL
        int status = Integer.parseInt(request.getParameter("status"));

        // get Mentor ID from Session
        User user = (User) session.getAttribute("currUser");
        int uid = 0;
        if (user == null) { // return to sign in page
            response.sendRedirect("signIn.jsp");
        } else {
            uid = user.getId();
        }

        // Get all Request from database

        ArrayList<Request> requestList = requestdao.getRequestListBy_uId_And_Status(uid, status);

        switch (status) {
            case 1:
                request.setAttribute("status", "Inviting");
                break;
            case 2:
                request.setAttribute("status", "Following");
                break;
            case 3:
                request.setAttribute("status", "Done");
                break;
            case 4:
                request.setAttribute("status", "Canceled");
                break;
            default:
                break;
        }
        
        request.setAttribute("requestlist", requestList);
        sendDispatcher(request, response, "/mentorRequestList.jsp");
        
        } catch (Exception e) {
            Logger.getLogger(ViewMentorRequestController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.getMessage());
            sendDispatcher(request, response, "/error.jsp");
        }
    }
    
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ViewMentorRequestController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewMentorRequestController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewMentorRequestController.class.getName()).log(Level.SEVERE, null, ex);
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
