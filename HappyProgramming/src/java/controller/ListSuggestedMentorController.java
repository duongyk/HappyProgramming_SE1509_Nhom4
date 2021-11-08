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
import dao.RequestSkillDAO;
import dao.UserDAO;
import dao.UserSkillDAO;
import dao.impl.RatingDAOImpl;
import dao.impl.RequestDAOImpl;
import dao.impl.RequestSkillDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.UserSkillDAOImpl;
import entity.Skill;
import entity.User;
import entity.UserSkill;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
     * Get Suggested Mentor by Filter.
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
            RequestSkillDAO rsDAO = new RequestSkillDAOImpl();
            RequestDAO requestDAO = new RequestDAOImpl();
            RatingDAO ratingDAO = new RatingDAOImpl();
            UserSkillDAO usDAO = new UserSkillDAOImpl();
            // Get current User- Mentee
            User mentee = (User) request.getSession().getAttribute("currUser");
            // Get filter
            int filter = Integer.parseInt(request.getParameter("filter"));
            // Mentor list
            ArrayList<User> mList = new ArrayList<>();
            switch (filter) {

                case 1:/* Suggested by requested Skill of the Mentee*/
                    ArrayList<Integer> listId = new ArrayList<>();
                    // get Skill of the Mentee have in all Requests
                    ArrayList<Skill> skillList = rsDAO.getSkillByMentee(mentee.getId());
                    // get all Mentor-Skill
                    ArrayList<UserSkill> mentorSkillList = usDAO.getMentorSkill();
                    // Add Skill ID to ID list
                    for (UserSkill us : mentorSkillList) {
                        for (Skill s : skillList) {
                            if (!listId.contains(us.getuId())) {
                                if (us.getsId() == s.getId()) {
                                    listId.add(us.getuId());
                                }
                            }
                        }
                    }
                    // Add Skill to Skill list
                    for (int id : listId) {
                        mList.add(userDAO.getUserById(id));
                    }
                    request.setAttribute("filter", 1);/*Filter number*/
                    break;

                case 2:/*Suggested by Rating*/
                    ArrayList<User> mentorList = userDAO.getUserByRole(2);
                    // HashMap contain rating of Mentor ((K,V)-(Mentor ID, avarage rating))
                    HashMap<Integer, Double> avg = new HashMap<>();
                    for (User mentor : mentorList) {
                        if (ratingDAO.getAvgRate(mentor.getId()) != 0) {
                            avg.put(mentor.getId(), ratingDAO.getAvgRate(mentor.getId()));
                        }
                    }
                    // Create a list from elements of HashMap
                    List<HashMap.Entry<Integer, Double>> listEntry
                            = new LinkedList<>(avg.entrySet());
                    // Sort the list
                    Collections.sort(listEntry, (HashMap.Entry<Integer, Double> o1,
                            HashMap.Entry<Integer, Double> o2)
                            -> (o2.getValue()).compareTo(o1.getValue()));
                    // Get list Mentor
                    for (HashMap.Entry<Integer, Double> entry : listEntry) {
                        mList.add(userDAO.getUserById(entry.getKey()));
                    }
                    // Set list Average rating
                    ArrayList<String> ratingList = new ArrayList<>();
                    for (User mentor : mList) {
                        ratingList.add(String.format("%.2f", ratingDAO.getAvgRate(mentor.getId())));
                    }
                    request.setAttribute("ratingList", ratingList);/*Rating List*/
                    request.setAttribute("filter", 2);/*Filter number*/
                    break;
                    
                case 3:/* Suggested by popularity*/
                    // Get Mentor list
                    mList = requestDAO.getHotMentor();
                    // Set list Number of Request
                    ArrayList<Integer> requestNumberList = new ArrayList<>();
                    for (User mentor : mList) {
                        requestNumberList.add(requestDAO.getTotalRequest(mentor.getId()));
                    }
                    request.setAttribute("requestNumberList", requestNumberList);/*Request number List*/
                    request.setAttribute("filter", 3);/*Filter number*/
                    break;
                    
                case 4:/* Suggested by number of Skill*/
                    ArrayList<UserSkill> usList = usDAO.getMentorSkill();
                    // HashMap cout skill of Mentor ((K,V)-(Mentor ID, number of Skill))
                    HashMap<Integer, Integer> countSkill = new HashMap<>();
                    for (UserSkill us : usList) {
                        if (!countSkill.containsKey(us.getuId())) {
                            countSkill.put(us.getuId(), 1);
                        } else {
                            countSkill.put(us.getuId(), countSkill.get(us.getuId()) + 1);
                        }
                    }
                    // Create a list from elements of HashMap
                    List<HashMap.Entry<Integer, Integer>> listEntry2
                            = new LinkedList<>(countSkill.entrySet());
                    // Sort the list
                    Collections.sort(listEntry2, (HashMap.Entry<Integer, Integer> o1,
                            HashMap.Entry<Integer, Integer> o2)
                            -> (o2.getValue()).compareTo(o1.getValue()));
                    // Get list Mentor
                    for (HashMap.Entry<Integer, Integer> entry : listEntry2) {
                        mList.add(userDAO.getUserById(entry.getKey()));
                    }

                    //Set list Number of Skill
                    ArrayList<Integer> skillNumberList = new ArrayList<>();
                    for (User mentor : mList) {
                        skillNumberList.add(usDAO.getTotalSkill(mentor.getId()));
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
}
