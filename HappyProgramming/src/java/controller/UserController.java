/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Rating;
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
import dao.impl.RatingDAO;
import dao.impl.SkillDAO;
import dao.impl.UserDAO;
import dao.impl.RequestDAO;
import entity.Request;

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
    UserDAO userDAO = new UserDAO();
    RatingDAO ratingDAO = new RatingDAO();
    RequestDAO requestDAO = new RequestDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");

            if (service == null) {
                service = "login";
            }

            if (service.equalsIgnoreCase("get")) {
                ArrayList<User> userlist = userDAO.getUserList();
                request.setAttribute("userlist", userlist);
                sendDispatcher(request, response, "newjsp.jsp");
            }

            if (service.equalsIgnoreCase("login")) {
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                User user = userDAO.getUser(userName, password);
                String mess = "";
                if (user != null) {
                    if (user.getuRole() == 3) {
                        request.getSession().setAttribute("currUser", user);
                        sendDispatcher(request, response, "adminDashboard.jsp");
                    } else {
                        request.getSession().setAttribute("currUser", user);
                        sendDispatcher(request, response, "index.jsp");
                    }
                } else {
                    mess = "login failed";
                    request.setAttribute("mess", mess);
                    sendDispatcher(request, response, "Sign-in.jsp");
                }

            }

            if (service.equalsIgnoreCase("sign-up")) {
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                String mail = request.getParameter("mail");
                String repass = request.getParameter("confirm");
                String fname = request.getParameter("fullname");
                String phone = request.getParameter("phone");
                String address = request.getParameter("text-1");
                String sex = request.getParameter("sex");
                String DOB = request.getParameter("text-4");
                Integer role = Integer.parseInt(request.getParameter("role"));
                if (!password.equals(repass)) {
                    // js: ko trung pass
                    sendDispatcher(request, response, "Sign-up.jsp");
                }
                
                User a = userDAO.checkAccount(userName);
                if (a == null) { // check xem ton tai chua, chua thi dc sign up
                    userDAO.signup(userName, repass, mail, fname, phone, address, sex, DOB, role);
                    if (role==1) {
                        response.sendRedirect("Sign-in.jsp");
                    } else {
                        response.sendRedirect("Sign-in.jsp");
                        //response.sendRedirect("CVControllerMap?service=createCV&uId="+a.getuId());
                    }
                    // khi dang ki hoan tat se cha nguoi dung ve page login
                } else { //neu co roi se day ve trang sighn up
                    // mess= "user name existed!"
                    sendDispatcher(request, response, "Sign-up.jsp");
                }

            }

            if (service.equalsIgnoreCase("logout")) {

            }


            if (service.equalsIgnoreCase("profile")) {
                request.setAttribute("user", request.getSession().getAttribute("currUser"));
                sendDispatcher(request, response, "profile.jsp");
            }

            if (service.equalsIgnoreCase("info")) {
                Integer uId = Integer.parseInt(request.getParameter("uId"));
                User user = userDAO.getUserById(uId);
                request.setAttribute("user", user);

                sendDispatcher(request, response, "profile.jsp");
            }

            if (service.equalsIgnoreCase("listRequest")) {
                User x = (User) request.getSession().getAttribute("currUser");
                ArrayList<Request> rList = requestDAO.getListByMe(x);
                request.setAttribute("rList", rList);
                sendDispatcher(request, response, "request.jsp");
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
