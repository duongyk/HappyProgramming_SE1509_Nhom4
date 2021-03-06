/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RatingDAO;
import dao.RequestDAO;
import dao.SkillDAO;
import dao.UserDAO;
import dao.impl.RatingDAOImpl;
import dao.impl.RequestDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  This class has the process request of Allow registered users to sign in
 *
 * @author ToanPKhe151393
 */
public class LoginController extends HttpServlet {

 /**
 *  This class has the process request of Allow registered users to sign in
 *
 * 
 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            UserDAO userDAO = new UserDAOImpl();
           //Get new input 
            String userName = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            User user = userDAO.getUser(userName, password);
            //check if user exist, block
            if (user != null) {
                 if (user.getStatus() == 0) {
                request.setAttribute("mess", "sorry your account has been block");
                sendDispatcher(request, response, "signIn.jsp");
                
            }
                    
               else if (user.getRole() == 3) {
                    request.getSession().setAttribute("currUser", user);
                    sendDispatcher(request, response, "index.jsp");
                } else {
                    request.getSession().setAttribute("currUser", user);
                    sendDispatcher(request, response, "index.jsp");
                }
            } else {

                request.setAttribute("mess", "Wrong user name or password");
                sendDispatcher(request, response, "signIn.jsp");
            }

        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", ex.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
/*
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
