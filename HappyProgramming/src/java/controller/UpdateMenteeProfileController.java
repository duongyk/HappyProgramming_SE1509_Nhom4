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
import java.sql.Date;
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
@WebServlet(name = "UpdateMenteeProfileController", urlPatterns = {"/UpdateMenteeProfileController"})
public class UpdateMenteeProfileController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
        }
        catch (Exception e) {
            Logger.getLogger(UpdateMenteeProfileController.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(UpdateMenteeProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
            UserDAO userDAO = new UserDAOImpl();
            int uId = Integer.parseInt(request.getParameter("uId"));
            User user = userDAO.getUserById(uId);
            request.setAttribute("currUser", user);
            sendDispatcher(request, response, "profileUpdate.jsp");
        }
        catch (Exception ex) {
            Logger.getLogger(UpdateMenteeProfileController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMessage", ex.toString());
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
        try {
            UserDAO userDAO = new UserDAOImpl();
            int id = Integer.parseInt(request.getParameter("uId")); //get user information by user id

            String fullname = request.getParameter("fullname").trim(); // get user fullname input from web
            String email = request.getParameter("email").trim(); // get user email input from web
            String phone = request.getParameter("phone").trim();// get user phone input from web

            String date = request.getParameter("dob"); // get user dob input from web
            Date dob = Date.valueOf(date); // get values of user dob

            String gender = request.getParameter("gender"); // // get user gender input from web
            String avatar = request.getParameter("avatar").trim(); // get user avatar input from web
            if (avatar.isEmpty()) { // check if user dont chose any new picture file
                User s = (User) request.getSession().getAttribute("currUser"); // get current user
                avatar = s.getAvatar(); // then set old avatar as updated avatar 
            }

            User user = new User(id, "", "", fullname, email, phone, dob, gender, avatar, 1);
            userDAO.updateUser(user); // update user info into DB
            request.getSession().setAttribute("currUser", user); // set current user with updated info
            sendDispatcher(request, response, "UserProfileController?uId="+id); // return to user profile page
        } catch (Exception ex) {
            Logger.getLogger(UpdateMenteeProfileController.class.getName()).log(Level.SEVERE, null, ex);
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
