/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Process:<br>
 *genarate new password for user has signed in
 *   
 * @author ToanPKHE151393
 */
public class ChangePasswordController extends HttpServlet {

    /**
     * The class contain method get to redirect user to ChangePassword page Get all
     * data necessary to provide user and run to ChangePassword.jsp Will throw
     * Exception and run to error jsp if any error occur
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            UserDAO userDAO = new UserDAOImpl();
            // Get old password, new password and repeat of new password 
            String oldPass = request.getParameter("password").trim();
            String newPass = request.getParameter("newPassword").trim();
            String rePass = request.getParameter("rePassword").trim();
            // Get the user from session
            User u = (User) session.getAttribute("currUser");
            String mail = u.getMail();
            //if the old password not match to the password in database send erro message 
            if (!u.getPassword().equals(oldPass)) {
                session.setAttribute("error", "wrong Password");
                sendDispatcher(request, response, "changePassword.jsp");
            } else {
                if (!newPass.equals(rePass)) {//if the confim password not match the new password send erro mesage
                    session.setAttribute("error", "confirm password must match the new password");
                    sendDispatcher(request, response, "changePassword.jsp");
                } else {// if all corect send messgae and head to signIn.jsp

                    userDAO.changePass(mail, newPass);
                    session.setAttribute("success", "change password successfully");
                    sendDispatcher(request, response, "signIn.jsp");
                }
            }

        } catch (Exception e) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.getMessage());
            sendDispatcher(request, response, "/error.jsp");
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
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
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
