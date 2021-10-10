/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmailService;
import dao.RatingDAO;
import dao.RequestDAO;
import dao.UserDAO;
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
import dao.impl.RatingDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.RequestDAOImpl;
import entity.Request;
import java.sql.Date;
import javax.servlet.http.HttpSession;
import util.SendEmail;

/**
 *
 * @author Duong
 */
public class UserController extends HttpServlet {

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

            String service = request.getParameter("service");

            UserDAO userDAO = new UserDAOImpl();
            RatingDAO ratingDAO = new RatingDAOImpl();
            RequestDAO requestDAO = new RequestDAOImpl();

            if (service == null) {
                service = "login";
            }

            if (service.equalsIgnoreCase("get")) {
                ArrayList<User> userlist = userDAO.getUserList();
                request.setAttribute("userlist", userlist);
                sendDispatcher(request, response, "newjsp.jsp");
            }

            if (service.equalsIgnoreCase("login")) {
                String userName = request.getParameter("username").trim();
                String password = request.getParameter("password").trim();
                User user = userDAO.getUser(userName, password);

                if (user != null) {
                    if (user.getRole() == 3) {
                        request.getSession().setAttribute("currUser", user);
                        sendDispatcher(request, response, "adminDashboard.jsp");
                    } else {
                        request.getSession().setAttribute("currUser", user);
                        sendDispatcher(request, response, "index.jsp");
                    }
                } else {

                    request.setAttribute("mess", "login fail pls check your username and password");
                    sendDispatcher(request, response, "signIn.jsp");
                }

            }

            if (service.equalsIgnoreCase("signUp")) {
                String userName = request.getParameter("username").trim();
                String password = request.getParameter("password").trim();
                String mail = request.getParameter("mail").trim();
                String repass = request.getParameter("confirm").trim();
                String fname = request.getParameter("fullname").trim();
                String phone = request.getParameter("phone").trim();
                String sex = request.getParameter("sex");
                Date dob = Date.valueOf(request.getParameter("dob"));
                Integer role = Integer.parseInt(request.getParameter("role"));
                User user = new User(userName, password, fname, mail, phone, dob, sex, "", 1);
                if (!password.equals(repass)) {
                    // js: ko trung pass
                    response.sendRedirect("signUp.jsp");
                } else {

                    User a = userDAO.checkAccount(userName);
                    if (a == null) { // check xem ton tai chua, chua thi dc sign up
                        userDAO.signUp(user);
                        if (role == 1) {
                            response.sendRedirect("signIn.jsp");
                        } else {
                            response.sendRedirect("signIn.jsp");
                            //response.sendRedirect("CVControllerMap?service=createCV&uId="+a.getuId());
                        }
                        // khi dang ki hoan tat se cha nguoi dung ve page login
                    } else { //neu co roi se day ve trang sighn up
                        // mess= "user name existed!"
                        response.sendRedirect("signUp.jsp");
                    }
                }
            }
            
            
            if (service.equals("changepass")) {
                HttpSession session =request.getSession();
//                String oldPass = request.getParameter("old pass");
                 String newPass = request.getParameter("password");
                 String rePass = request.getParameter("rePassword");
                 User u = (User) session.getAttribute("u");
                 String mail=u.getMail();
                 if(!u.getPassword().equals(newPass)){
                     request.setAttribute("mess", "wrong Password");
                     sendDispatcher(request, response, "changePassword.jsp");
                     
                 }else{
                     if (!newPass.equals(rePass)){
                      request.setAttribute("mess", "confim password must match the new password");
                    sendDispatcher(request, response, "changePassword.jsp");
                     }else {
                         userDAO.changePass(mail, newPass) ;
                         sendDispatcher(request, response, "signIn.jsp");
                     }
                 }
               
                
                

            }

            if (service.equalsIgnoreCase("logOut")) {
                request.getSession().removeAttribute("currUser");
                sendDispatcher(request, response, "index.jsp");
            }

            if (service.equalsIgnoreCase("profile")) {
                int uId = Integer.parseInt(request.getParameter("uId"));
                User user = userDAO.getUserById(uId);
                request.setAttribute("user", user);
                
                sendDispatcher(request, response, "profile.jsp");
            }

            if (service.equalsIgnoreCase("info")) {
                Integer uId = Integer.parseInt(request.getParameter("uId"));
                User user = userDAO.getUserById(uId);
                request.setAttribute("user", user);

                sendDispatcher(request, response, "profile.jsp");
            }

            if (service.equalsIgnoreCase("listAllMentor")) {
                ArrayList<User> mList = userDAO.getUserByRole(2);
                request.setAttribute("mList", mList);
                sendDispatcher(request, response, "allMentor.jsp");
            }
            
            if (service.equalsIgnoreCase("sendEmail")) {
                SendEmail se = new SendEmail();
                String code = se.generateVerifyCode();
                request.getSession().setAttribute("verify", code);
                
                String mail = request.getParameter("email").trim();
                
                User user = userDAO.getUserByEmail(mail);
                if(user != null) {
                    User a = userDAO.getUserByEmail(mail);
                    a.setVerify(code);
                    int send = se.sendEmail(a);
                    request.getSession().setAttribute("currMail", a);
                    sendDispatcher(request, response, "verifyAccount.jsp");
                }
            }
            
            if (service.equalsIgnoreCase("verifyCode")) {
                User x = (User) request.getSession().getAttribute("currMail");
                String verify = (String) request.getSession().getAttribute("verify");
                
                String code = request.getParameter("code").trim();
                
                if(verify.equalsIgnoreCase(code)) {
                    sendDispatcher(request, response, "resetPassword.jsp");
                }
                if(!verify.equalsIgnoreCase(code)) {
                    sendDispatcher(request, response, "resetPassword.jsp");
                }
            }
            
            if (service.equalsIgnoreCase("resetPass")) {
                String password = request.getParameter("password").trim();
                String confirmPassword = request.getParameter("confirm").trim();
                
                User x = (User) request.getSession().getAttribute("currMail");
                
                if(password.equalsIgnoreCase(confirmPassword)) {
                    User user = userDAO.resetPassword(x, password);
                    sendDispatcher(request, response, "index.jsp");
                }
            }
        }
    }

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
