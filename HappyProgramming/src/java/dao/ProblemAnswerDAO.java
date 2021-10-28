/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 */
package dao;

import entity.ProblemAnswer;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate ProblemAnswer objects in
 * the database.
 *
 * @author
 */
public interface ProblemAnswerDAO {

    /**
     * Get all the Answer of a Problem
     *
     * @param index it is a<code>java.lang.Integer</code>
     * @param pId it is a<code>java.lang.Integer</code>
     * @return list of <code>Problem</code> object
     * @throws Exception
     */
    public ArrayList<ProblemAnswer> getProblemAnswerList(int index,int pId) throws Exception;
    
    /**
     * Insert a Answer into database
     *
     * @param pId it is a<code>java.lang.Integer</code>
     * @param fromId it is a<code>java.lang.Integer</code>
     * @param content it is a<code>java.lang.String</code>
     * @throws Exception
     */
    public void insertProblemAnswer(int pId,int fromId, String content) throws Exception;
    
    /**
     * Update a Answer in database
     *
     * @param pa it is a <code>ProblemAnswer</code> object
     * @throws Exception
     */
    public void updateProblemAnswer(ProblemAnswer pa) throws Exception;
    
    /**
     * Get total number of Answer of a Problem
     *
     * @param pId it is a <code>ProblemAnswer</code> object
     * @return a <code>java.lang.Integer</code>
     * @throws Exception
     */
    public int countProblemAnswer(int pId) throws Exception;
}
