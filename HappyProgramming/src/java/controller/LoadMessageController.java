/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChatMessageDAO;
import dao.impl.ChatMessageDAOImpl;
import entity.ChatMessage;
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
 * This class contain method to load message and send to user chat page It will
 * be called automatically to load message for the user and update if there new
 * message Can insert message posted by user into database through post
 *
 *
 * @author thangtvhe151307
 */
@WebServlet(name = "LoadMessageController", urlPatterns = {"/loadMessage"})
public class LoadMessageController extends HttpServlet {

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
     * This get method will load new message for the user and send to ajax and
     * load newly inserted messages if they have not been shown
     *
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();

            ChatMessageDAO messdao = new ChatMessageDAOImpl();

            try {
                //throw new Exception("message");    

                int offset = Integer.parseInt(request.getParameter("offset"));

                User user = (User) session.getAttribute("currUser");
                int uId = user.getId();

                int friendId = Integer.parseInt(request.getParameter("friendId"));

                ArrayList<ChatMessage> messageList = messdao.getNewMessageThroughTwoFriendId(uId, friendId, offset);

                for (ChatMessage message : messageList) {
                    if (message.getFromId() == uId) {
                        out.println("<div class=\"outgoing_msg\">\n"
                                + "                  <div class=\"sent_msg\">\n"
                                + "                    <p>" + message.getContent() + "</p>\n"
                                + "                    <span class=\"time_date\">" + message.getDateCreated() + "</span>\n"
                                + "                  </div>\n"
                                + "                </div>");
                    } else {
                            out.println("<div class=\"incoming_msg\">\n"
                                + "                  <div class=\"received_msg\">\n"
                                + "                    <div class=\"received_withd_msg\">\n"
                                + "                      <p>" + message.getContent() + "</p>\n"
                                + "                      <span class=\"time_date\">" + message.getDateCreated() + "</span>\n"
                                + "                    </div>\n"
                                + "                  </div>\n"
                                + "                </div>");
                    }
                }          
            
            } catch (Exception e) {
                Logger.getLogger(LoadMessageController.class.getName()).log(Level.SEVERE, null, e);
                response.sendError(400);
            }

        } catch (Exception e) {
            Logger.getLogger(LoadMessageController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This post method will get message which user post and insert it into
     * database
     *
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

            HttpSession session = request.getSession();

            ChatMessageDAO messdao = new ChatMessageDAOImpl();

            try {
                String message = request.getParameter("message");
                //System.out.println(message);

                User user = (User) session.getAttribute("currUser");
                int uId = user.getId();

                int friendId = Integer.parseInt(request.getParameter("friendId"));

                ChatMessage mess = new ChatMessage(uId, friendId, message);

                messdao.insertMessage(mess);
            } catch (Exception e) {
                Logger.getLogger(LoadMessageController.class.getName()).log(Level.SEVERE, null, e);
                response.sendError(400);
            }
        } catch (Exception e) {
            Logger.getLogger(LoadMessageController.class.getName()).log(Level.SEVERE, null, e);
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
