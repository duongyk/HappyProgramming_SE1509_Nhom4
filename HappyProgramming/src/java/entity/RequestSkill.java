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

/**
 *
 * This class represents the RequestSkill table in database
 *
 * @author 
 */
public class RequestSkill {

    /**
     * Id of (Request)
     */
    private int rId;
    
    /**
     * Id of (Skill)
     */
    private int sId;

    /**
     * Constructor.<br>
     */
    public RequestSkill() {
    }

    /**
     * Constructor.<br>
     *
     * @param rId it is a int number
     * @param sId it is a int number
     */
    public RequestSkill(int rId, int sId) {
        this.rId = rId;
        this.sId = sId;
    }

    /**
     * Get value from attribute of RequestSkill class. <br>
     *
     * @return rId it is a int number
     */
    public int getrId() {
        return rId;
    }

    /**
     * Set value to rId attribute of RequestSkill class. <br>
     *
     * @param rId it is an int number
     */
    public void setrId(int rId) {
        this.rId = rId;
    }

    /**
     * Get value from sId attribute of RequestSkill class. <br>
     *
     * @return sId it is a int number
     */
    public int getsId() {
        return sId;
    }

    /**
     * Set value to sId attribute of RequestSkill class. <br>
     *
     * @param sId it is a an int number
     */
    public void setsId(int sId) {
        this.sId = sId;
    }
}
