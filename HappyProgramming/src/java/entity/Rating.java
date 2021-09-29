/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author Duong
 */
public class Rating {

    private int fromId;
    private int toId;
    private String comment;
    private int rating;
    private Timestamp date;
    private String fromName;
    private String toName;

    public Rating() {
    }

    public Rating(int fromId, int toId, String comment, int rating, Timestamp date, String fromName, String toName) {
        this.fromId = fromId;
        this.toId = toId;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.fromName = fromName;
        this.toName = toName;
    }

    public Rating(int fromId, int toId, String comment, int rating, Timestamp date) {
        this.fromId = fromId;
        this.toId = toId;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
    }

    public Rating(int fromId, int toId, String comment, int rating) {
        this.fromId = fromId;
        this.toId = toId;
        this.comment = comment;
        this.rating = rating;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

}
