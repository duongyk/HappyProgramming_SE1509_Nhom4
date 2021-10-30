/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0                         First Deploy<br>
 */

package controller;

import dao.RequestDAO;
import dao.UserDAO;
import dao.impl.RequestDAOImpl;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
 * This class will calculate statistic about a mentor requests 
 * include number of request , percentage of request
 * Will run to mentorRequestStatistic jsp with attribute data
 * Will throw Exception and run to error jsp if there any error
 * 
 * @author thangtvhe151307
 */
@WebServlet(name = "ViewMentorRequestStatisticController", urlPatterns = {"/viewMentorRequestStatistic"})
public class ViewMentorRequestStatisticController extends HttpServlet {

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
            RequestDAO requestdao = new RequestDAOImpl();
            HttpSession session = request.getSession();
            UserDAO userDAO = new UserDAOImpl();
            
            // check if mentor login
            int id = Integer.parseInt(request.getParameter("uId"));
            User user = userDAO.getUserById(id);
            request.setAttribute("user", user);
            if (user == null) { // return to sign in page
                response.sendRedirect("signIn.jsp");
                return;
            } 
            
//            User user = new User();
//            user.setId(6);
//            user.setUsername("mentor01");
            
            // get top 5 mentor request statistic
            
            HashMap<String,HashMap<Integer,Integer>> statisticMap = requestdao.getStatisticTopFive();
            
            // replace username of your mentor wiht "You" if user in top 5
            if(statisticMap.containsKey(user.getFullname())) {
                
                for(String key: new ArrayList<>(statisticMap.keySet())) {
                    if(user.getFullname().equalsIgnoreCase(key)) {
                       statisticMap.put("You", statisticMap.remove(key));
                    } else {
                       statisticMap.put(key, statisticMap.remove(key));
                    }
                }
                
            } else { // if user not in top 5
                HashMap<Integer,Integer> userStatistic = requestdao.getMentorRequestStatistic(user.getId());
                
                statisticMap.put("You", userStatistic);
            }
            
            request.setAttribute("statisticMap", statisticMap); 
            
            sendDispatcher(request, response, "/mentorRequestStatistic.jsp");
        } catch (Exception e) {
            Logger.getLogger(ViewMentorRequestStatisticController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.getMessage());
            sendDispatcher(request, response, "/error.jsp");
        }
    }
    
    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ViewMentorRequestStatisticController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewMentorRequestStatisticController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewMentorRequestStatisticController.class.getName()).log(Level.SEVERE, null, ex);
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
