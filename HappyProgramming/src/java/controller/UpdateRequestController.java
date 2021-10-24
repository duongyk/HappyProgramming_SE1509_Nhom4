/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        DuongVV          First Deploy<br>
 * 18-10-2021    2.0        DuongVV          Update<br>
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
 * This class has the process request of Update Request
 *
 * @author DuongVV
 */
public class UpdateRequestController extends HttpServlet {

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
            Logger.getLogger(UpdateRequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * Display update Request Form
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // initiate DAO
            UserDAO userDAO = new UserDAOImpl();
            RequestDAO requestDAO = new RequestDAOImpl();
            RequestSkillDAO requestSkillDAO = new RequestSkillDAOImpl();
            SkillDAO skillDAO = new SkillDAOImpl();
            // get Request
            int rId = Integer.parseInt(request.getParameter("rId"));
            Request req = requestDAO.getRequestById(rId);
            // Check Sstatus of Request
            if (req.getStatus() == 3 || req.getStatus() == 4) {
                request.setAttribute("mess", "You can not update Done or Canceled Request!");
                sendDispatcher(request, response, "viewRequest?rId=" + req.getId());
            } else {
                // get all skill for choosing
                ArrayList<Skill> sListAll = skillDAO.getAllSkill();
                // get all Mentor for choosing
                ArrayList<User> mList = userDAO.getUserByRole(2);
                // get list chosen skills
                ArrayList<Skill> sList = requestSkillDAO.getSkill(rId);

                request.setAttribute("sList", sList);/*List skill of request*/
                request.setAttribute("sListAll", sListAll);/*List all Skill for choosing*/
                request.setAttribute("mList", mList);/*List Mentor for choosing*/
                request.setAttribute("req", req);/*Request*/
                sendDispatcher(request, response, "updateRequest.jsp");
            }
        } catch (Exception e) {
            Logger.getLogger(UpdateRequestController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Get new information and Update the Request
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // initiate DAO
            RequestDAO requestDAO = new RequestDAOImpl();
            RequestSkillDAO requestSkillDAO = new RequestSkillDAOImpl();

            // Get request ID
            int rId = Integer.parseInt(request.getParameter("rId"));
            // Get new input information
            String title = request.getParameter("title").trim();
            String content = request.getParameter("content").trim();
            Date deadlineDate = Date.valueOf(request.getParameter("deadlineDate"));
            int deadlineHour = Integer.parseInt(request.getParameter("deadlineHour"));
            int status = Integer.parseInt(request.getParameter("status"));
            String skillIds[] = request.getParameterValues("skill");
            // get new chosen Skills
            ArrayList<Integer> sIdList = new ArrayList<>();
            if (skillIds != null) {
                for (String id : skillIds) {
                    int sId = Integer.parseInt(id);
                    sIdList.add(sId);
                }
                // get old Skills
            } else {
                ArrayList<Skill> sList = requestSkillDAO.getSkill(rId);
                for (Skill s : sList) {
                    sIdList.add(s.getId());
                }
            }
            // Update Request
            Request req = new Request(rId, title, content, deadlineDate, deadlineHour, status);
            requestDAO.updateRequest(req);
            // Update RequestSkill
            requestSkillDAO.updateRequestSkill(rId, sIdList);
            request.setAttribute("messSucc", "Update successful!");
            
//            // get Skills in Request
//            ArrayList<Skill> sList = requestSkillDAO.getSkill(rId);
//            // get new Request
//            Request reqUpdated = requestDAO.getRequestById(rId);
//            request.setAttribute("sList", sList);/*Skill list of Request*/
//            request.setAttribute("req", reqUpdated);/*Request*/
//            sendDispatcher(request, response, "viewRequest.jsp");
            sendDispatcher(request, response, "viewRequest");
        } catch (Exception e) {
            Logger.getLogger(UpdateRequestController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
