/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 *               1.0                         First Deploy<br>
 */
package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * This class represents the ProblemAnswer table in database
 *
 * @author
 */
public class ProblemAnswer {

    /**
     * Id of (ProblemAnswer)
     */
    private int pId;

    /**
     * Id of (ProblemAnswer)
     */
    private int paId;
    
    /**
     * User From of (ProblemAnswer) who answered the Problem
     */
    private User from;

    /**
     * Content of (ProblemAnswer)
     */
    private String content;

    /**
     * Date publication of (ProblemAnswer)
     */
    private Timestamp date;

    /**
     * Constructor.<br>
     */
    public ProblemAnswer() {
    }

    /**
     * Constructor.<br>
     *
     * @param pId it is a <code>java.lang.Integer</code>
     * @param paId it is a <code>java.lang.Integer</code>
     * @param from it is a <code>User</code> object
     * @param content it is a <code>java.lang.String</code>
     * @param date it is a <code>java.sql.Timestamp</code>
     */
    public ProblemAnswer(int pId, int paId, User from, String content, Timestamp date) {
        this.pId = pId;
        this.from = from;
        this.content = content;
        this.date = date;
    }

    /**
     * Constructor.<br>
     *
     * @param pId it is a <code>java.lang.Integer</code>
     * @param from it is a <code>User</code> object
     * @param content it is a <code>java.lang.String</code>
     * @param date it is a <code>java.sql.Timestamp</code>
     */
    public ProblemAnswer(int pId, User from, String content, Timestamp date) {
        this.pId = pId;
        this.from = from;
        this.content = content;
        this.date = date;
    }

    /**
     * Constructor.<br>
     *
     * @param pId it is a <code>java.lang.Integer</code>
     * @param from it is a <code>User</code> object
     * @param content it is a <code>java.lang.String</code>
     */
    public ProblemAnswer(int pId, User from, String content) {
        this.from = from;
        this.content = content;
    }

    /**
     * Get value from pId attribute of ProblemAnswer class. <br>
     *
     * @return pId it is a <code>java.lang.Integer</code>
     */
    public int getpId() {
        return pId;
    }

    /**
     * Set value to pId attribute of ProblemAnswer class. <br>
     *
     * @param pId it is a <code>java.lang.Integer</code>
     */
    public void setpId(int pId) {
        this.pId = pId;
    }

    /**
     * Get value from paId attribute of ProblemAnswer class. <br>
     *
     * @return paId it is a <code>java.lang.Integer</code>
     */
    public int getPaId() {
        return paId;
    }

    /**
     * Set value to paId attribute of ProblemAnswer class. <br>
     *
     * @param paId it is a <code>java.lang.Integer</code>
     */
    public void setPaId(int paId) {
        this.paId = paId;
    }

    /**
     * Get value from From attribute of ProblemAnswer class. <br>
     *
     * @return from it is a <code>User</code> object
     */
    public User getFrom() {
        return from;
    }

    /**
     * Set value to From attribute of ProblemAnswer class. <br>
     *
     * @param from it is a <code>User</code> object
     */
    public void setFrom(User from) {
        this.from = from;
    }

    /**
     * Get value from Content attribute of ProblemAnswer class. <br>
     *
     * @return content it is a <code>java.lang.String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value to Content attribute of ProblemAnswer class. <br>
     *
     * @param content it is a <code>java.lang.String</code>
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get value from Date attribute of ProblemAnswer class. <br>
     *
     * @return date it is a <code>java.sql.Timestamp</code>
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Set value to Date attribute of ProblemAnswer class. <br>
     *
     * @param date it is a <code>java.sql.Timestamp</code>
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Set value date attribute of ProblemAnswer class into String for display. <br>
     *
     * @return dateToString it is a <code>java.lang.String</code>
     */
    @Override
    public String toString() {
        String dateToString = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return dateToString;
    }
}
