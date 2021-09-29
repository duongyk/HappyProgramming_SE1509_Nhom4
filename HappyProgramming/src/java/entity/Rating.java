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

    private User from;
    private User to;
    private String comment;
    private int rateAmount;
    private Timestamp date;

    public Rating() {
    }

    public Rating(User from, User to, String comment, int rateAmount, Timestamp date) {
        this.from = from;
        this.to = to;
        this.comment = comment;
        this.rateAmount = rateAmount;
        this.date = date;
    }

    public Rating(User from, User to, String comment, int rateAmount) {
        this.from = from;
        this.to = to;
        this.comment = comment;
        this.rateAmount = rateAmount;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRateAmount() {
        return rateAmount;
    }

    public void setRateAmount(int rateAmount) {
        this.rateAmount = rateAmount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
