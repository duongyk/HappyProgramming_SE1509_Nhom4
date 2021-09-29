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

    private int rId;
    private String title;
    private String content;
    private int fromId;
    private int toId;
    private Date deadlineDate;
    //private Time deadlineHour;
    private String status;

    public Request() {
    }

    public Request(String title) {
        this.title = title;
    }

    public Request(int rId, String title, String content, int fromId, int toId, Date deadlineDate, String status) {
        this.rId = rId;
        this.title = title;
        this.content = content;
        this.fromId = fromId;
        this.toId = toId;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }

    public Request(String title, String content, int fromId, int toId, Date deadlineDate, String status) {
        this.title = title;
        this.content = content;
        this.fromId = fromId;
        this.toId = toId;
        this.deadlineDate = deadlineDate;
        this.status = status;
    }

    public Request(String title, String content, int fromId, int toId, Date deadlineDate) {
        this.title = title;
        this.content = content;
        this.fromId = fromId;
        this.toId = toId;
        this.deadlineDate = deadlineDate;
    }
    
    

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
