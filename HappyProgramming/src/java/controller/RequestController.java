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
import dao.RequestSkillDAO;
import dao.SkillDAO;
import dao.UserDAO;
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
import dao.impl.RequestDAOImpl;
import dao.impl.RequestSkillDAOImpl;
import dao.impl.SkillDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Skill;
import java.sql.Date;
import javax.servlet.http.HttpSession;

/**
 * Process:<br>
 * - Get List request by me<br>
 * - Load request from database<br>
 * - Create new request and insert into database<br>
 *
 * @author
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String service = request.getParameter("service");

            UserDAO userDao = new UserDAOImpl();
            RequestDAO requestDAO = new RequestDAOImpl();
            RequestSkillDAO requestSkillDAO = new RequestSkillDAOImpl();
            SkillDAO skillDAO = new SkillDAOImpl();

            HttpSession session = request.getSession();
            
            if (service == null) {
                service = "";
            }

            // Get list request of the user (Mentee/mentor) and Statistic requests
            if (service.equalsIgnoreCase("listRequestByMe")) {
                //get current user
                User user = (User) request.getSession().getAttribute("currUser");
                //get list request of the user
                ArrayList<Request> listRequest = requestDAO.getListByMe(user);
                // get statistic requests
                ArrayList<Integer> statistic = requestDAO.getStatistic(user.getId());

                request.setAttribute("listRequest", listRequest);
                request.setAttribute("statistic", statistic);
                sendDispatcher(request, response, "listRequestByMe.jsp");
            }
            /* load create request screen */
            if (service.equalsIgnoreCase("loadRequest")) {
                ArrayList<Skill> sList = skillDAO.getActiveSkill();
                request.setAttribute("sList", sList);
                ArrayList<User> mentor = userDao.getUserByRole(2);
                request.setAttribute("mList", mentor);
                sendDispatcher(request, response, "createReq.jsp");
            }

            /* create a new request */
            if (service.equalsIgnoreCase("createRequest")) {

                User x = (User) request.getSession().getAttribute("currUser");

                String title = request.getParameter("title").trim();
                String content = request.getParameter("content").trim();
                int deadlineHour = Integer.parseInt(request.getParameter("deadlineHour"));
                int to = Integer.parseInt(request.getParameter("toId"));
                User toId = userDao.getUserById(to);

                String date = request.getParameter("deadlineDate");
                Date deadlineDate = Date.valueOf(date);

                Request req = new Request(title, content, x, toId, deadlineDate, deadlineHour);
                requestDAO.createRequest(req);

                String arr[] = request.getParameterValues("skill");
                for (String str : arr) {  //insert into arr[] checked values
                    requestSkillDAO.skillRequest(Integer.parseInt(str));
                }

                sendDispatcher(request, response, "index.jsp");
            }

            /* view detail of a Request */
            if (service.equalsIgnoreCase("viewRequest")) {
                // get request
                int rId = Integer.parseInt(request.getParameter("rId"));
                Request req = requestDAO.getRequestById(rId);

                ArrayList<Skill> sList = requestSkillDAO.getSkill(rId);

                request.setAttribute("sList", sList);
                request.setAttribute("req", req);
                sendDispatcher(request, response, "viewRequest.jsp");
            }

            /* Show form to edit detail of a Request */
            if (service.equalsIgnoreCase("editRequestForm")) {
                // get request
                int rId = Integer.parseInt(request.getParameter("rId"));
                Request req = requestDAO.getRequestById(rId);
                if (req.getStatus() == 3 || req.getStatus() == 4) {
                    request.setAttribute("mess", "You can not update Done or Canceled Request!");
                    sendDispatcher(request, response, "RequestControllerMap?service=viewRequest&rId="+req.getId());
                } else {
                    // get all skill for choosing
                    ArrayList<Skill> sListAll = skillDAO.getAllSkill();
                    // get all Mentor for choosing
                    ArrayList<User> mList = userDao.getUserByRole(2);
                    // get list chosen skills
                    ArrayList<Skill> sList = requestSkillDAO.getSkill(rId);

                    request.setAttribute("sList", sList);
                    request.setAttribute("sListAll", sListAll);
                    request.setAttribute("mList", mList);
                    request.setAttribute("req", req);
                    sendDispatcher(request, response, "editRequest.jsp");
                }

            }

            /* Edit detail of a Request */
            if (service.equalsIgnoreCase("editRequest")) {
                // get request ID
                int rId = Integer.parseInt(request.getParameter("rId"));
                // get new input information
                String title = request.getParameter("title").trim();
                String content = request.getParameter("content").trim();
                Date deadlineDate = Date.valueOf(request.getParameter("deadlineDate"));
                int deadlineHour = Integer.parseInt(request.getParameter("deadlineHour"));
                int status = Integer.parseInt(request.getParameter("status"));
                String skillIds[] = request.getParameterValues("skill");
                ArrayList<Integer> sIdList = new ArrayList<>();
                for (String id : skillIds) {
                    int sId = Integer.parseInt(id);
                    sIdList.add(sId);
                }
                Request req = new Request(rId, title, content, deadlineDate, deadlineHour, status);
                requestDAO.updateRequest(req);
                requestSkillDAO.updateRequestSkill(rId, sIdList);

                sendDispatcher(request, response, "RequestControllerMap?service=viewRequest&rId=" + rId);
            }

            /* View Mentor Request */
            if (service.equalsIgnoreCase("viewMentorRequest")) {
                
                // get status from URL
                int status = Integer.parseInt(request.getParameter("status"));

                // get Mentor ID from Sessiom
                int uid = (Integer) session.getAttribute("uId");

                // Get all Request from database
                RequestDAO requestdao = new RequestDAOImpl();

                ArrayList<Request> requestList = requestdao.getRequestListBy_uId_And_Status(uid, status);

                request.setAttribute("requestlist", requestList);

                if (status == 1) {
                    request.setAttribute("status", "Inviting");
                } else if (status == 2) {
                    request.setAttribute("status", "Following");
                } else if (status == 3) {
                    request.setAttribute("status", "Done");
                } else if (status == 4) {
                    request.setAttribute("status", "Canceled");
                }

                sendDispatcher(request,response, "/mentorRequestList.jsp");
                //out.println("<h3>view Mentor Request chưa xong</h3>");
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
            Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RequestController.class.getName()).log(Level.SEVERE, null, ex);
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
