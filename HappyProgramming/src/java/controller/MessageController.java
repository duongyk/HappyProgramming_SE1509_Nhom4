/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        GiangNVT          First Deploy<br>
 */
package controller;

import dao.MessageDAO;
import dao.impl.MessageDAOImpl;
import entity.Message;
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

/**
 * Process:<br>
 * - Get all message<br>
 * - View messsage<br>
 * - Delete message<br>
 * - Send message<br>
 * - Get unread message<br>
 * Exception:<br>
 *
 *
 * @author giangnvthe150748
 */
public class MessageController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request it is a object of
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            MessageDAO messageDAO = new MessageDAOImpl();
            // Set default service
            if (service == null) {
                service = "";
            }
            // Get all message
            if (service.equalsIgnoreCase("getMessage")) {
                //get index page 
                String indexPage = request.getParameter("index");
                // index page always start at 1
                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);
                int count = messageDAO.getMessage().size();
                //calculate total page for paging
                int endPage = count / 8; // a page will have at most 8 skills
                if (count % 8 != 0) { //if the total of skills is not divisible by 8, the last page will be added to show the remaining skills
                    endPage++;
                }
                // Set href of paging
                String href = "MessageControllerMap?service=getMessage?";
                ArrayList<Message> list = messageDAO.pagingMessage(index);
                ArrayList<Message> listUnReadMess = messageDAO.getUnReadMessage();
                request.setAttribute("listUnReadMess", listUnReadMess);
                request.setAttribute("listMess", list);
                request.setAttribute("href", href);/*href paging*/
                request.setAttribute("endPage", endPage);
                request.setAttribute("count", count);
                request.setAttribute("index", index);/*index/current page*/
                sendDispatcher(request, response, "listMessage.jsp");
            }
            // View messsage
            if (service.equalsIgnoreCase("viewMessage")) {
                String mId = request.getParameter("mId");
                messageDAO.updateRead(mId);
                Message message = messageDAO.getMessageById(mId);

                // System.out.println(message.toString());
                ArrayList<Message> list = new ArrayList<>();
                list.add(message);
                request.setAttribute("listMess", list);
                sendDispatcher(request, response, "viewMessage.jsp");
            }

            // Delete message
            if (service.equalsIgnoreCase("deleteMessage")) {
                String mId = request.getParameter("mId");
                String mess = "Delete Message Successfully!";
                messageDAO.delete(mId);
                request.setAttribute("mess", mess);
                sendDispatcher(request, response, "MessageControllerMap?service=getMessage");
            }
            //Get unread message
            if (service.equalsIgnoreCase("getUnReadMessage")) {
                ArrayList<Message> list = messageDAO.getMessage();
                ArrayList<Message> listUnReadMess = messageDAO.getUnReadMessage();
                request.setAttribute("listUnReadMess", listUnReadMess);
                request.setAttribute("listMess", list);
                sendDispatcher(request, response, "listUnReadMess.jsp");
            }

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
            Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void sendDispatcher(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
