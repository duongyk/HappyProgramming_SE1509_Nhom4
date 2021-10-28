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
 * This class represents the Problem table in database
 *
 * @author
 */
public class Problem {

    /**
     * Id of (Problem)
     */
    private int id;

    /**
     * User From of (Problem) who posted the Problem
     */
    private User from;
    
    /**
     * Title of (Problem)
     */
    private String title;
    
    /**
     * Content of (Problem)
     */
    private String content;
    
    /**
     * Date publication of (Problem)
     */
    private Timestamp date;
    
    /**
     * Status of (Problem)
     */
    private int status;

    /**
     * Constructor.<br>
     *
     */
    public Problem() {
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a <code>java.lang.Integer</code>
     * @param from it is a <code>User</code> object
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param date it is a <code>java.sql.Timestamp</code>
     * @param status it is a <code>java.lang.Integer</code>
     */
    public Problem(int id, User from, String title, String content, Timestamp date, int status) {
        this.id = id;
        this.from = from;
        this.title = title;
        this.content = content;
        this.date = date;
        this.status = status;
    }

    /**
     * Constructor.<br>
     *
     * @param from it is a <code>User</code> object
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param date it is a <code>java.sql.Timestamp</code>
     * @param status it is a <code>java.lang.Integer</code>
     */
    public Problem(User from, String title, String content, Timestamp date, int status) {
        this.from = from;
        this.title = title;
        this.content = content;
        this.date = date;
        this.status = status;
    }

    /**
     * Constructor.<br>
     *
     * @param from it is a <code>User</code> object
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param status it is a <code>java.lang.Integer</code>
     */
    public Problem(User from, String title, String content, int status) {
        this.from = from;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    /**
     * Constructor.<br>
     *
     * @param from it is a <code>User</code> object
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     */
    public Problem(User from, String title, String content) {
        this.from = from;
        this.title = title;
        this.content = content;
    }

    /**
     * Get value from Id attribute of Problem class. <br>
     *
     * @return id it is a <code>java.lang.Integer</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to Id attribute of Problem class. <br>
     *
     * @param id it is a <code>java.lang.Integer</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from From attribute of Problem class. <br>
     *
     * @return from it is a <code>User</code> object
     */
    public User getFrom() {
        return from;
    }

    /**
     * Set value to From attribute of Problem class. <br>
     *
     * @param from it is a <code>User</code> object
     */
    public void setFrom(User from) {
        this.from = from;
    }

    /**
     * Get value from Title attribute of Problem class. <br>
     *
     * @return title it is a <code>java.lang.String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set value to Title attribute of Problem class. <br>
     *
     * @param title it is a <code>java.lang.String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get value from Content attribute of Problem class. <br>
     *
     * @return content it is a <code>java.lang.String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value to Content attribute of Problem class. <br>
     *
     * @param content it is a <code>java.lang.String</code>
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get value from Date attribute of Problem class. <br>
     *
     * @return date it is a <code>java.sql.Timestamp</code>
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Set value to Date attribute of Problem class. <br>
     *
     * @param date it is a <code>java.sql.Timestamp</code>
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Get value from Status attribute of Problem class. <br>
     *
     * @return status it is a <code>java.lang.Integer</code>
     */
    public int getStatus() {
        return status;
    }

    /**
     * Set value to Status attribute of Problem class. <br>
     *
     * @param status it is a <code>java.lang.Integer</code>
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    /**
     * Set value date attribute of Problem class into String for display. <br>
     *
     * @return dateToString it is a <code>java.lang.String</code>
     */
    @Override
    public String toString() {
        String dateToString = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return dateToString;
    }
}
