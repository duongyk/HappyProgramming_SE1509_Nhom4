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

    private int id;
    private String title;
    private String content;
    private User from;
    private User to;
    private Date deadlineDate;
    private String status;

    public Request() {
    }

    public Request(String title) {
        this.title = title;
    }

    public Request(int id, String title, String content, User from, User to, Date deadlineDate, String status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }

    public Request(String title, User from, User to, Date deadlineDate, String status) {
        this.title = title;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }

    public Request(String title, String content, User to, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.to = to;
        this.deadlineDate = deadlineDate;
    }

    public Request(String title, String content, User from, User to, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.from = from;
        this.to = to;
        this.deadlineDate = deadlineDate;
    }
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
