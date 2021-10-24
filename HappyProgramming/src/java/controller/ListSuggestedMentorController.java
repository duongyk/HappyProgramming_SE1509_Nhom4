/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 19-10-2021    1.0        DuongVV          First Deploy<br>
 */
package controller;

import dao.RatingDAO;
import dao.RequestDAO;
import dao.UserDAO;
import dao.UserSkillDAO;
import dao.impl.RatingDAOImpl;
import dao.impl.RequestDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.UserSkillDAOImpl;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class has the process request of List All Suggested Mentor and Filter
 *
 * @author DuongVV
 */
public class ListSuggestedMentorController extends HttpServlet {

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
            out.println("<title>Servlet ListSuggestedMentorController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListSuggestedMentorController at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ListSuggestedMentorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            // initiate DAO
            UserDAO userDAO = new UserDAOImpl();
            RequestDAO requestDAO = new RequestDAOImpl();
            RatingDAO ratingDAO = new RatingDAOImpl();
            UserSkillDAO usDAO = new UserSkillDAOImpl();
            // Get current User- Mentee
            User mentee = (User) request.getSession().getAttribute("currUser");
            // Get filter
            int filter = Integer.parseInt(request.getParameter("filter"));
            // Mentor list
            ArrayList<User> mList = new ArrayList<>();
            int total = userDAO.getMaxUser();
            switch (filter) {
                // Suggested by requested Skill of the Mentee
                case 1:
                    mList = userDAO.getSuggestedMentor(mentee.getId());
                    request.setAttribute("filter", 1);/*Filter number*/
                    break;
                // Suggested by Rating
                case 2:
                    mList = userDAO.getTopMentorByRate();
                    ArrayList<String> ratingList = new ArrayList<>(Collections.nCopies(total, ""));
                    for (User mentor : mList) {
                        ratingList.set(mentor.getId(), String.format("%.2f", ratingDAO.getAvgRate(mentor.getId())));
                    }
                    request.setAttribute("ratingList", ratingList);/*Rating List*/
                    request.setAttribute("filter", 2);/*Filter number*/
                    break;
                // Suggested by popularity
                case 3:
                    mList = requestDAO.getHotMentor();
                    ArrayList<Integer> requestNumberList = new ArrayList<>(Collections.nCopies(total, 0));
                    for (User mentor : mList) {
                        requestNumberList.set(mentor.getId(), requestDAO.getTotalRequest(mentor.getId()));
                    }
                    request.setAttribute("requestNumberList", requestNumberList);/*Request number List*/
                    request.setAttribute("filter", 3);/*Filter number*/

                    break;
                // Suggested by number of Skill
                case 4:
                    mList = userDAO.getTopMentorByTotalSkill();
                    ArrayList<Integer> skillNumberList = new ArrayList<>(Collections.nCopies(total, 0));
                    for (User mentor : mList) {
                        skillNumberList.set(mentor.getId(), usDAO.getTotalSkill(mentor.getId()));
                    }
                    request.setAttribute("skillNumberList", skillNumberList);/*Skill number List*/
                    request.setAttribute("filter", 4);/*Filter number*/
                    break;
                default:
                    break;
            }

            request.setAttribute("mList", mList);/*Mentor List*/
            sendDispatcher(request, response, "listSuggestedMentor.jsp");
        } catch (Exception e) {
            Logger.getLogger(ListSuggestedMentorController.class.getName()).log(Level.SEVERE, null, e);
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
