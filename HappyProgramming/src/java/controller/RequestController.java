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

import dao.RatingDAO;
import dao.RequestDAO;
import dao.RequestSkillDAO;
import dao.SkillDAO;
import dao.UserDAO;
import dao.UserSkillDAO;
import dao.impl.RatingDAOImpl;
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
import dao.impl.UserSkillDAOImpl;
import entity.Skill;
import java.sql.Date;
import javax.servlet.http.HttpSession;

/**
 * Process:<br>
 * - Get List request by me<br>
 * - Load request from database<br>
 * - Create new request and insert into database<br>
 * - View Detail of Request<br>
 * - Load the Update Request Form<br>
 * - Update Request
 *
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
            UserSkillDAO usDAO = new UserSkillDAOImpl();
            HttpSession session = request.getSession();

            if (service == null) {
                service = "";
            }

            /**
             * Service listRequestByMe: Get list request of the user
             * (Mentee/mentor) and Statistic requests
             */
            if (service.equalsIgnoreCase("listRequestByMe")) {
                // Get current user
                User user = (User) request.getSession().getAttribute("currUser");
                // Get index page 
                String indexPage = request.getParameter("index");
                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);
                // Get list all Request of the user
                ArrayList<Request> listRequest = requestDAO.getListByMe(user);
                int count = listRequest.size();
                // Calculate total page for paging
                int endPage = count / 8;
                if (count % 8 != 0) {
                    endPage++;
                }
                // Get list Request by page
                ArrayList<Request> rList = requestDAO.listByMePaging(index, user.getId());
                // Get statistic requests
                ArrayList<Integer> statistic = requestDAO.getStatistic(user.getId());
                // Get all Skill for Filter
                ArrayList<Skill> sList = skillDAO.getActiveSkill();

                request.setAttribute("sList", sList);
                request.setAttribute("rList", rList);
                request.setAttribute("endPage", endPage);
                request.setAttribute("index", index);
                request.setAttribute("statistic", statistic);
                sendDispatcher(request, response, "listRequestByMe.jsp");
            }

            /**
             * Service filerListByMe: Get list request of the user using Filter
             */
            if (service.equalsIgnoreCase("filerListByMe")) {
                // Get current user
                User user = (User) request.getSession().getAttribute("currUser");
                // Get skill ID for Filter
                int sId = Integer.parseInt(request.getParameter("sId"));
                // Get Status for Filter
                int status = Integer.parseInt(request.getParameter("status"));
                
                // Filter by Skill
                if (sId != 0 && status == 0) {
                    // Get index page 
                    String indexPage = request.getParameter("index");
                    if (indexPage == null) {
                        indexPage = "1";
                    }
                    int index = Integer.parseInt(indexPage);
                    // Get list Request after Filter 
                    ArrayList<Request> rList = requestDAO.listByMeFilterSkillPaging(index, user.getId(), sId);

                    // Calculate total page for paginig
                    int count = requestDAO.getTotalFilterSkill(user.getId(), sId);
                    int endPage = count / 8;
                    if (count % 8 != 0) {
                        endPage++;
                    }
                    // Get all Skill for Filter
                    ArrayList<Skill> sList = skillDAO.getActiveSkill();

                    request.setAttribute("sList", sList);
                    request.setAttribute("endPage", endPage);
                    request.setAttribute("index", index);
                    request.setAttribute("rList", rList);
                    sendDispatcher(request, response, "listRequestByMe.jsp");

                    // Filter by Status
                } else if (sId == 0 && status !=0) {
                    // Get index page 
                    String indexPage = request.getParameter("index");
                    if (indexPage == null) {
                        indexPage = "1";
                    }
                    int index = Integer.parseInt(indexPage);
                    // Get list Request after Filter 
                    ArrayList<Request> rList = requestDAO.listByMeFilterStatusPaging(index, user.getId(), status);

                    // Calculate total page for paginig
                    int count = requestDAO.getTotalFilterStatus(user.getId(), status);
                    int endPage = count / 8;
                    if (count % 8 != 0) {
                        endPage++;
                    }
                    // Get all Skill for Filter
                    ArrayList<Skill> sList = skillDAO.getActiveSkill();

                    request.setAttribute("rList", sList);
                    request.setAttribute("endPage", endPage);
                    request.setAttribute("index", index);
                    request.setAttribute("rList", rList);
                    sendDispatcher(request, response, "listRequestByMe.jsp");

                    //Filter by both Skill and Status
                } else if (sId != 0 && status != 0) {
                    // Get index page 
                    String indexPage = request.getParameter("index");
                    if (indexPage == null) {
                        indexPage = "1";
                    }
                    int index = Integer.parseInt(indexPage);
                    // Get list Request after Filter 
                    ArrayList<Request> rList = requestDAO.listByMeFilterPaging(index, user.getId(), sId, status);

                    // Calculate total page for paginig
                    int count = requestDAO.getTotalFilter(user.getId(), sId, status);
                    int endPage = count / 8;
                    if (count % 8 != 0) {
                        endPage++;
                    }
                    // Get all Skill for Filter
                    ArrayList<Skill> sList = skillDAO.getActiveSkill();

                    request.setAttribute("sList", sList);
                    request.setAttribute("endPage", endPage);
                    request.setAttribute("index", index);
                    request.setAttribute("rList", rList);
                    sendDispatcher(request, response, "listRequestByMe.jsp");

                    // No Filter
                } else {
                    // Get index page 
                    String indexPage = request.getParameter("index");
                    if (indexPage == null) {
                        indexPage = "1";
                    }
                    int index = Integer.parseInt(indexPage);
                    // Get list all Request of the user
                    ArrayList<Request> listRequest = requestDAO.getListByMe(user);
                    int count = listRequest.size();
                    // Calculate total page for paging
                    int endPage = count / 8;
                    if (count % 8 != 0) {
                        endPage++;
                    }
                    // Get list Request by page
                    ArrayList<Request> rList = requestDAO.listByMePaging(index, user.getId());
                    // Get statistic requests
                    ArrayList<Integer> statistic = requestDAO.getStatistic(user.getId());
                    // Get all Skill for Filter
                    ArrayList<Skill> sList = skillDAO.getActiveSkill();

                    request.setAttribute("sList", sList);
                    request.setAttribute("rList", rList);
                    request.setAttribute("endPage", endPage);
                    request.setAttribute("index", index);
                    request.setAttribute("statistic", statistic);
                    sendDispatcher(request, response, "listRequestByMe.jsp");
                }
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

            /**
             * Service viewRequest: View detail of a Request
             */
            if (service.equalsIgnoreCase("viewRequest")) {
                // get request
                int rId = Integer.parseInt(request.getParameter("rId"));
                Request req = requestDAO.getRequestById(rId);

                ArrayList<Skill> sList = requestSkillDAO.getSkill(rId);

                request.setAttribute("sList", sList);
                request.setAttribute("req", req);
                sendDispatcher(request, response, "viewRequest.jsp");
            }

            /**
             * Service updateRequestForm: Show form to update detail of a
             * Request
             */
            if (service.equalsIgnoreCase("updateRequestForm")) {
                // get request
                int rId = Integer.parseInt(request.getParameter("rId"));
                Request req = requestDAO.getRequestById(rId);
                if (req.getStatus() == 3 || req.getStatus() == 4) {
                    request.setAttribute("mess", "You can not update Done or Canceled Request!");
                    sendDispatcher(request, response, "RequestControllerMap?service=viewRequest&rId=" + req.getId());
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
                    sendDispatcher(request, response, "updateRequest.jsp");
                }

            }

            /**
             * Service updateRequest: Update detail of a Request
             */
            if (service.equalsIgnoreCase("updateRequest")) {
                // Get request ID
                int rId = Integer.parseInt(request.getParameter("rId"));
                // Get new input information
                String title = request.getParameter("title").trim();
                String content = request.getParameter("content").trim();
                Date deadlineDate = Date.valueOf(request.getParameter("deadlineDate"));
                int deadlineHour = Integer.parseInt(request.getParameter("deadlineHour"));
                int status = Integer.parseInt(request.getParameter("status"));
                String skillIds[] = request.getParameterValues("skill");
                ArrayList<Integer> sIdList = new ArrayList<>();

                if (skillIds != null) {
                    for (String id : skillIds) {
                        int sId = Integer.parseInt(id);
                        sIdList.add(sId);
                    }
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
                sendDispatcher(request, response, "RequestControllerMap?service=viewRequest&rId=" + rId);
            }

            /* View Mentor Request */
            if (service.equalsIgnoreCase("viewMentorRequest")) {

                // get status from URL
                int status = Integer.parseInt(request.getParameter("status"));

                // get Mentor ID from Session
                User user = (User) session.getAttribute("currUser");
                int uid = 0;
                if (user == null) { // return to sign in page
                    response.sendRedirect("signIn.jsp");
                } else {
                    uid = user.getId();
                }

                // Get all Request from database
                RequestDAO requestdao = new RequestDAOImpl();

                ArrayList<Request> requestList = requestdao.getRequestListBy_uId_And_Status(uid, status);

                // get request statistic
            
                int invited = requestdao.get_Mentor_TotalRequestByStatus(uid, 1);
                int following = requestdao.get_Mentor_TotalRequestByStatus(uid, 2);
                int completed = requestdao.get_Mentor_TotalRequestByStatus(uid, 3);
                int canceled = requestdao.get_Mentor_TotalRequestByStatus(uid, 4);
                
                int total = invited+following+completed+canceled;
                
                double canceledpercentage = (double) (canceled/total);
                double completedpercentage = (double) (completed/total);
                
                // get mentor average rating
                RatingDAO ratingdao = new RatingDAOImpl();
                String rating = ratingdao.getAvgRate(uid);
                
                //set attributes
                request.setAttribute("requestlist", requestList);

                request.setAttribute("invited", invited);
                request.setAttribute("following", following);
                request.setAttribute("completed", completed);
                request.setAttribute("canceled", canceled);
                
                request.setAttribute("canceledpercentage", canceledpercentage);
                request.setAttribute("completedpercentage", completedpercentage);
                
                request.setAttribute("rating", rating);
                
                
                switch (status) {
                    case 1:
                        request.setAttribute("status", "Inviting");
                        break;
                    case 2:
                        request.setAttribute("status", "Following");
                        break;
                    case 3:
                        request.setAttribute("status", "Done");
                        break;
                    case 4:
                        request.setAttribute("status", "Canceled");
                        break;
                    default:
                        break;
                }

                sendDispatcher(request, response, "/mentorRequestList.jsp");
                //out.println("<h3>view Mentor Request chưa xong</h3>");
            }

            /* Mentor Accept / Reject Request */
            if (service.equalsIgnoreCase("mentorUpdateStatus")) {
                // get status and request id from URL
                int status = Integer.parseInt(request.getParameter("status"));

                int rid = Integer.parseInt(request.getParameter("rid"));

                // using dao update request
                RequestDAO requestdao = new RequestDAOImpl();

                requestdao.updateStatusRequest(rid, status);

                //sendDispatcher(request, response, "/demoMentorList.jsp");
                if (status == 2) {
                    // if accept run to following request
                    response.sendRedirect("RequestControllerMap?service=viewMentorRequest&status=2");
                } else if (status == 4) {
                    // if reject run to inviting request
                    response.sendRedirect("RequestControllerMap?service=viewMentorRequest&status=1");
                }
            }

            /**
             * Service viewRequestMentor: View detail of a Request for Mentor
             */
            if (service.equalsIgnoreCase("viewRequestMentor")) {
                // get request
                int rId = Integer.parseInt(request.getParameter("rId"));
                Request req = requestDAO.getRequestById(rId);

                // get request skill
                ArrayList<Skill> sList = requestSkillDAO.getSkill(rId);

                request.setAttribute("sList", sList);
                request.setAttribute("req", req);
                sendDispatcher(request, response, "viewRequestMentor.jsp");
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
