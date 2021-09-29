/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Request;
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
import dao.impl.RequestDAO;
import dao.impl.RequestSkillDAO;
import dao.impl.SkillDAO;
import dao.impl.UserDAO;
import entity.Skill;
import java.sql.Date;

/**
 *
 * @author Tung
 */
public class RequestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UserDAO userDao = new UserDAO();
    RequestDAO requestDAO = new RequestDAO();
    RequestSkillDAO requestSkillDAO = new RequestSkillDAO();
    SkillDAO skillDAO = new SkillDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            
            if (service == null) {
                service = "listbyme";
            }
            if (service.equalsIgnoreCase("listRequestByMe")) {
                User x = (User) request.getSession().getAttribute("currUser");
                ArrayList<Request> listRequest = requestDAO.getListByMe(x);
                request.setAttribute("listRequest", listRequest);
                sendDispatcher(request, response, "ListRequestByMe.jsp");
            }
            /* load create request screen */
            if(service.equalsIgnoreCase("loadRequest")) {
                ArrayList<Skill> sList = skillDAO.getAllSkill();
                request.setAttribute("sList", sList);
                ArrayList<User> mentor = userDao.getUserByRole(2);
                request.setAttribute("mList", mentor);
                sendDispatcher(request, response, "createRequest.jsp");
            }
            
            /* create a new request */
            if (service.equalsIgnoreCase("createRequest")) {

                User x = (User) request.getSession().getAttribute("currUser");

                String title = request.getParameter("title");
                String content = request.getParameter("content");
                int fromId = x.getuId();
                
                int toId = Integer.parseInt(request.getParameter("toId"));

                String deadline = request.getParameter("deadlineDate");
                Date deadlineDate = Date.valueOf(deadline); //bug
                
                Request req = new Request(title, content, fromId, toId, deadlineDate);
                requestDAO.createRequest(req);
                
                String arr[] = request.getParameterValues("skill");
                for (String str : arr) {
                    requestSkillDAO.skillRequest(Integer.parseInt(str));
                }
                
                sendDispatcher(request, response, "index.jsp");
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
