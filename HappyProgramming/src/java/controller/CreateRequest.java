/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RequestDAO;
import dao.RequestSkillDAO;
import dao.SkillDAO;
import dao.UserDAO;
import dao.impl.RequestDAOImpl;
import dao.impl.RequestSkillDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Request;
import entity.Skill;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tung
 */
public class CreateRequest extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateRequest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateRequest at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            UserDAO userDao = new UserDAOImpl();
            SkillDAO skillDAO = new SkillDAOImpl();
            
            ArrayList<Skill> sList = skillDAO.getActiveSkill(); // get list of current active skills
            request.setAttribute("sList", sList); // set list of active skills
            ArrayList<User> mentor = userDao.getUserByRole(2); // get list of user who role = 2(mentor)
            request.setAttribute("mList", mentor); // set list of mentor
            sendDispatcher(request, response, "createRequest.jsp");
        } catch (Exception e) {
            Logger.getLogger(UpdateRequest.class.getName()).log(Level.SEVERE, null, e);
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
        try {
            UserDAO userDao = new UserDAOImpl();
            RequestDAO requestDAO = new RequestDAOImpl();
            RequestSkillDAO requestSkillDAO = new RequestSkillDAOImpl();
            
            User x = (User) request.getSession().getAttribute("currUser"); // get current login user

            String title = request.getParameter("title").trim(); // get request title user input
            String content = request.getParameter("content").trim(); // get request content user input
            int deadlineHour = Integer.parseInt(request.getParameter("deadlineHour")); // get request deadline hour user selected
            int to = Integer.parseInt(request.getParameter("toId")); // get mentor id user want to send request to
            User toId = userDao.getUserById(to); // get mentor by id

            String date = request.getParameter("deadlineDate"); // get request deadline date user selected
            Date deadlineDate = Date.valueOf(date); // get values of deadline date

            Request req = new Request(title, content, x, toId, deadlineDate, deadlineHour); // create new request
            requestDAO.createRequest(req); // add created request into database

            String arr[] = request.getParameterValues("skill"); // get array of skills user want to request 
            for (String str : arr) {  //insert into arr[] checked values
                requestSkillDAO.skillRequest(Integer.parseInt(str)); // add selected skills into database
            }

            sendDispatcher(request, response, "listRequestByMe");
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
