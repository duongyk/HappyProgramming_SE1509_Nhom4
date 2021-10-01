/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Duong
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
     * Status of (Request)
     */
    private String status;

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
     * @param id it is a int number
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param from it is a <code>User</code>
     * @param to it is a <code>User</code>
     * @param date it is a <code>java.sql.Timestamp</code>
     * @param status it is a <code>java.lang.String</code>
     */
    public Request(int id, String title, String content, User from, User to, Date deadlineDate, String status) {
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
     * @param title it is a <code>java.lang.String</code>
     * @param from it is a <code>User</code>
     * @param to it is a <code>User</code>
     * @param date it is a <code>java.sql.Timestamp</code>
     * @param status it is a <code>java.lang.String</code>
     */
    public Request(String title, User from, User to, Date deadlineDate, String status) {
        this.title = title;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }

    /**
     * Constructor.<br>
     *
     * @param title it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param to it is a <code>User</code>
     * @param status it is a <code>java.lang.String</code>
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
     * @param date it is a <code>java.sql.Timestamp</code>
     */
    public Request(String title, String content, User from, User to, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
    }
    
    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return id it is a int number
     */
    public int getId() {
        return id;
    }

    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return title it is a <code>java.lang.String</code>
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return content it is a <code>java.lang.String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * Get value from attribute of Rating class. <br>
     *
     * @return from it is a <code>User</code> object
     */
    public User getFrom() {
        return from;
    }

    /**
     * Get value from attribute of Rating class. <br>
     *
     * @return to it is a <code>User</code> object
     */
    public User getTo() {
        return to;
    }

    /**
     * Get value from date attribute of Rating class. <br>
     *
     * @return deadlineDate it is a <code>java.sql.Timestamp</code>
     */
    public Date getDeadlineDate() {
        return deadlineDate;
    }

    /**
     * Get value from attribute of Rating class. <br>
     *
     * @return status it is a <code>User</code> object
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @return id it is a int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @return title it is a <code>java.lang.String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @return content it is a <code>java.lang.String</code>
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Set value from attribute of Rating class. <br>
     *
     * @return from it is a <code>User</code> object
     */
    public void setFrom(User from) {
        this.from = from;
    }

    /**
     * Set value from attribute of Rating class. <br>
     *
     * @return to it is a <code>User</code> object
     */
    public void setTo(User to) {
        this.to = to;
    }

    /**
     * Get value from date attribute of Rating class. <br>
     *
     * @return deadlineDate it is a <code>java.sql.Timestamp</code>
     */
    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    /**
     * Get value from attribute of Rating class. <br>
     *
     * @return status it is a <code>User</code> object
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
