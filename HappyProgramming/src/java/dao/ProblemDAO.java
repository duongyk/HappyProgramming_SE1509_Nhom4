/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 */
package dao;

import entity.Problem;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Problem objects in the
 * database.
 *
 * @author
 */
public interface ProblemDAO {

    /**
     * Get all the Problem with Paging
     *
     * @param index is a <code>java.lang.Integer</code>
     * @return list of <code>Problem</code> object
     * @throws Exception
     */
    public ArrayList<Problem> getProblemListPaging(int index) throws Exception;

    /**
     * Get a Problem
     *
     * @param pId is a <code>java.lang.Integer</code>
     * @return a <code>Problem</code> object
     * @throws Exception
     */
    public Problem getProblem(int pId) throws Exception;

    /**
     * Get User's Problem
     *
     * @param index is a <code>java.lang.Integer</code>
     * @param mId is a <code>java.lang.Integer</code>
     * @return a list of <code>Problem</code> object
     * @throws Exception
     */
    public ArrayList<Problem> getProblemByMePaging(int index,int mId) throws Exception;
    
    /**
     * Insert a Problem into database
     *
     * @param problem it is a <code>Problem</code> object
     * @throws Exception
     */
    public void insertProblem(Problem problem) throws Exception;
    
    /**
     * Update a Problem into database
     *
     * @param problem it is a <code>Problem</code> object
     * @throws Exception
     */
    public void updateProblem(Problem problem) throws Exception;
    
    /**
     * Close a Problem (change status into 0)
     *
     * @param pId is a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public void closeProblem(int pId) throws Exception;
    
    /**
     * Count all the Problem
     *
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public int countProblem() throws Exception;
    
    /**
     * Count the Problem of a User
     *
     * @param uId is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public int countProblemUser(int uId) throws Exception;
    
    /**
     * Count the Problem of a User
     *
     * @param pId is a <code>java.lang.Integer</code>
     * @param uId is a <code>java.lang.Integer</code>
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public boolean checkMyProblem(int pId,int uId) throws Exception;
}
