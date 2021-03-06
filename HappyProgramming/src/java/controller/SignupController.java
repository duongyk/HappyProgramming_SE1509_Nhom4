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
import javax.servlet.http.HttpSession;

/**
 * This class has the process request of create new use to be a mentor or a mentee
 *
 * @author ToanPKhe151393
 */
@WebServlet(name = "SignupController", urlPatterns = {"/Signup"})
public class SignupController extends HttpServlet {

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
        try {
            UserDAO userDAO = new UserDAOImpl();
            HttpSession session  = request.getSession();
            //take infomation in signUp.jsp then trim
            String userName = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String mail = request.getParameter("mail").trim();
            String repass = request.getParameter("confirm").trim();
            String fname = request.getParameter("fullname").trim();
            String phone = request.getParameter("phone").trim();
            String sex = request.getParameter("sex");
            //check date
            Date dob = Date.valueOf(request.getParameter("dob"));
            Integer role = Integer.parseInt(request.getParameter("role"));
            // create a new user with default avata
            User user = new User(userName, password, fname, mail, phone, dob, sex, "default-avatar.png", role, 1);
            // ??f the password not match the confirm password stay at the signUp.jsp
           
            if(userDAO.getUserByEmail(mail) != null){
               session.setAttribute("error", "Your mail has been used. please input another one");
                response.sendRedirect("signUp.jsp");
                
            }else{
            if (!password.equals(repass)) {
                  session.setAttribute("error", "Your repeat password is not match to your password");
                response.sendRedirect("signUp.jsp");
            } else {

                User a = userDAO.checkAccount(userName);
                //checking if the user are alredy exist
                if (a == null) { 
                    if (role == 1) {
                        userDAO.signUp(user);
                        session.setAttribute("success", "Create Mentee account successfullly");
                        response.sendRedirect("signIn.jsp");
                    } else {
                        //response.sendRedirect("signIn.jsp");
                        session.setAttribute("user", user);
                        response.sendRedirect("createCV");
                    }
                    // khi dang ki hoan tat se cha nguoi dung ve page login
                } else { 
                     session.setAttribute("error", "Your user Name has existed try another one");
                    response.sendRedirect("signUp.jsp");
                }
            }
            }

        }catch (Exception e) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
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
