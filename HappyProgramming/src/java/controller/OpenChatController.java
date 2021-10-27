/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChatFriendDAO;
import dao.UserDAO;
import dao.impl.ChatFriendDAOImpl;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 *
 * This class contains method to initialize the chat box of user
 * It will load list friend messaging with user 
 * When load success it will redirect to chatbox jsp
 * Will throw Exception if there are any error
 * 
 * @author PC
 */
@WebServlet(name = "ChatController", urlPatterns = {"/openChat"})
public class OpenChatController extends HttpServlet {

    /**
     * This method will get list of friend from data for user
     * and send it to chatbox jsp
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ,Exception{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                                    
            HttpSession session = request.getSession();
            
            UserDAO userdao = new UserDAOImpl();
            ChatFriendDAO frienddao = new ChatFriendDAOImpl();
            
            int uId = 6;
            session.setAttribute("uId", uId);
            
            // check if user has login yet
//            User user = (User) session.getAttribute("currUser");
//            if(user==null) {
//                response.sendRedirect("signIn.jsp");
//            } else {
//                uId = user.getId();
//            }
            
            // get user friend list
            ArrayList<Integer> friendIdList = frienddao.getYourChatFriendId(uId);
            
            int friendId = 0;
            
            // check if user and person user want to chat are friend
            try {
                
            friendId = Integer.parseInt(request.getParameter("friendId"));
            
            frienddao.checkIf_NotFriendYet_ToAdd(uId, friendId);
            
            } catch (NumberFormatException | NullPointerException e) { // get message for the first friend in list
                friendId = friendIdList.get(0);
            }
            
            
            ArrayList<User> friendList = new ArrayList();
            
            for(int id: friendIdList) {
                friendList.add(userdao.getUserById(id));
            }
            
            request.setAttribute("friendList", friendList);
            request.setAttribute("friendId", friendId);
            
            RequestDispatcher rd = request.getRequestDispatcher("/chatbox.jsp");
            rd.forward(request, response);
            
        } catch (Exception e) {
            Logger.getLogger(OpenChatController.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(OpenChatController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OpenChatController.class.getName()).log(Level.SEVERE, null, ex);
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
