/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        DuongVV          First Deploy<br>
 */
package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * This class represents the Rating table in database
 *
 * @author duongvvhe150773
 */
public class Rating {
    
    /**
     * Rating from (Mentee)
     */
    private User from;
    
    /**
     * Rating to (Mentor)
     */
    private User to;
    
    /**
     * Rating comment
     */
    private String comment;
    
    /**
     * Rating ratingAmount
     */
    private int rateAmount;
    
    /**
     * Rating date
     */
    private Timestamp date;

    /**
     * Constructor
     */
    public Rating() {
    }

    /**
     * Constructor.<br>
     *
     * @param from it is a <code>User</code> object
     * @param to it is a <code>User</code>
     * @param comment it is a <code>java.lang.String</code>
     * @param rateAmount it is an int number
     * @param date it is a <code>java.sql.Timestamp</code>
     */
    public Rating(User from, User to, String comment, int rateAmount, Timestamp date) {
        this.from = from;
        this.to = to;
        this.comment = comment;
        this.rateAmount = rateAmount;
        this.date = date;
    }

    /**
     * Constructor.<br>
     *
     * @param from it is a <code>User</code> object
     * @param to it is a <code>User</code>
     * @param comment it is a <code>java.lang.String</code>
     * @param rateAmount it is an int number
     */
    public Rating(User from, User to, String comment, int rateAmount) {
        this.from = from;
        this.to = to;
        this.comment = comment;
        this.rateAmount = rateAmount;
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
     * Set value to From attribute of Rating class. <br>
     *
     * @param from it is a <code>User</code> object
     */
    public void setFrom(User from) {
        this.from = from;
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
     * Set value to To attribute of Rating class. <br>
     *
     * @param to it is a <code>User</code> object
     */
    public void setTo(User to) {
        this.to = to;
    }

    /**
     * Get value from Comment attribute of Rating class. <br>
     *
     * @return comment it is a <code>java.lang.String</code>
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set value to Comment attribute of Rating class. <br>
     *
     * @param comment it is a <code>java.lang.String</code>
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Get value from rateAmount attribute of Rating class. <br>
     *
     * @return rateAmount it is a int number
     */
    public int getRateAmount() {
        return rateAmount;
    }

    /**
     * Set value to rateAmount attribute of Rating class. <br>
     *
     * @param  rateAmount it is a int number
     */
    public void setRateAmount(int rateAmount) {
        this.rateAmount = rateAmount;
    }

    /**
     * Get value from date attribute of Rating class. <br>
     *
     * @return date it is a <code>java.sql.Timestamp</code>
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Set value to date attribute of Rating class. <br>
     *
     * @param  date it is a <code>java.sql.Timestamp</code>
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Set value date attribute of Rating class into String for display. <br>
     *
     * @return dateToString it is a <code>java.lang.String</code>
     */
    @Override
    public String toString() {
        String dateToString = new SimpleDateFormat("dd/MM/yyyy").format(date);
        return dateToString;
    }
    
    
}
