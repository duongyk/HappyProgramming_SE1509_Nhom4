/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 *              1.0                          First Deploy<br>
 */
package entity;

import java.sql.Date;

/**
 *
 * This class represents the Request table in database
 *
 * @author 
 */
public class Request {
    
    /**
     * Id of (Request)
     */
    private int id;
    
    /**
     * Title of (Request)
     */
    private String title;
    
    /**
     * Content of (Request)
     */
    private String content;
    
    /**
     * Request from (User)
     */
    private User from;
    
    /**
     * Request to (User)
     */
    private User to;
    
    /**
     * deadlineDate of (Request)
     */
    private Date deadlineDate;
    
    /**
     * deadlineDate of (Request)
     */
    private int deadlineHour;
    
    /**
     * Status of (Request)
     */
    private int status;

    /**
     * Constructor.<br>
     */
    public Request() {
    }
    
    /**
     * Constructor.<br>
     *
     * @param title it is a <code>java.lang.String</code>
     */
    public Request(String title) {
        this.title = title;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a Integer number
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param from it is a <code>User</code> object
     * @param to it is a <code>User</code> object
     * @param deadlineDate it is a <code>java.sql.Date</code>
     * @param status it is a <code>java.lang.String</code>
     */
    public Request(int id, String title, String content, User from, User to, Date deadlineDate, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }
    
    /**
     * Constructor.<br>
     *
     * @param id it is a Integer number
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param from it is a <code>User</code> object
     * @param to it is a <code>User</code> object
     * @param deadlineDate it is a <code>java.sql.Date</code>
     * @param deadlineHour it is a Integer number
     * @param status it is a <code>java.lang.String</code>
     */
    public Request(int id, String title, String content, User from, User to, Date deadlineDate, int deadlineHour, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
        this.deadlineHour = deadlineHour;
        this.status = status;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a Integer number
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param deadlineDate it is a <code>java.sql.Date</code>
     * @param deadlineHour it is a Integer number
     * @param status it is a <code>java.lang.String</code>
     */
    public Request(int id, String title, String content, Date deadlineDate, int deadlineHour, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.deadlineDate = deadlineDate;
        this.deadlineHour = deadlineHour;
        this.status = status;
    }

    /**
     * Constructor.<br>
     *
     * @param title it is a <code>java.lang.String</code>
     * @param from it is a <code>User</code> object
     * @param to it is a <code>User</code> object
     * @param deadlineDate it is a <code>java.sql.Date</code>
     * @param deadlineHour it is a Integer number
     * @param status it is a <code>java.lang.String</code>
     */
    public Request(String title, String content, User from, User to, Date deadlineDate, int deadlineHour) {    
        this.title = title;
        this.content = content;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
        this.deadlineHour = deadlineHour;
    }

    /**
     * Constructor.<br>
     *
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param to it is a <code>User</code> object
     * @param deadlineDate it is a <code>java.sql.Date</code>
     */
    public Request(String title, String content, User to, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.to = to;
        this.deadlineDate = deadlineDate;
    }

    /**
     * Constructor.<br>
     *
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param from it is a <code>User</code>
     * @param to it is a <code>User</code>
     * @param deadlineDate it is a <code>java.sql.Date</code>
     */
    public Request(String title, String content, User from, User to, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
    }
    
    /**
     * Get value from Id attribute of Skill class. <br>
     *
     * @return id it is a Integer number
     */
    public int getId() {
        return id;
    }

    /**
     * Get value from Title attribute of Skill class. <br>
     *
     * @return title it is a <code>java.lang.String</code>
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Get value from Content attribute of Skill class. <br>
     *
     * @return content it is a <code>java.lang.String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * Get value from From attribute of Rating class. <br>
     *
     * @return from it is a <code>User</code> object
     */
    public User getFrom() {
        return from;
    }

    /**
     * Get value from To attribute of Rating class. <br>
     *
     * @return to it is a <code>User</code> object
     */
    public User getTo() {
        return to;
    }

    /**
     * Get value from deadlineDate attribute of Rating class. <br>
     *
     * @return deadlineDate it is a <code>java.sql.Date</code>
     */
    public Date getDeadlineDate() {
        return deadlineDate;
    }

    /**
     * Get value from deadlineHour attribute of Rating class. <br>
     *
     * @return deadlineDate it is an Integer number
     */
    public int getDeadlineHour() {
        return deadlineHour;
    }

    /**
     * Set value to deadlineHour attribute of Skill class. <br>
     *
     * @param deadlineHour it is an Integer number
     */
    public void setDeadlineHour(int deadlineHour) {
        this.deadlineHour = deadlineHour;
    }

    /**
     * Get value from Status attribute of Rating class. <br>
     *
     * @return status it is a <code>User</code> object
     */
    public int getStatus() {
        return status;
    }

    /**
     * Set value to Id attribute of Skill class. <br>
     *
     * @param id it is an Integer number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set value to Title attribute of Skill class. <br>
     *
     * @param title it is a <code>java.lang.String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set value to Content attribute of Skill class. <br>
     *
     * @param content it is a <code>java.lang.String</code>
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Set value to From attribute of Rating class. <br>
     *
     * @param from it is a <code>User</code> object
     */
    public void setFrom(User from) {
        this.from = from;
    }

    /**
     * Set value to To attribute of Rating class. <br>
     *
     * @param to it is a <code>User</code> object
     */
    public void setTo(User to) {
        this.to = to;
    }

    /**
     * Set value to Date attribute of Rating class. <br>
     *
     * @param deadlineDate it is a <code>java.sql.Date</code>
     */
    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    /**
     * Set value to Status attribute of Rating class. <br>
     *
     * @param status it is a <code>java.lang.String</code>
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
}
