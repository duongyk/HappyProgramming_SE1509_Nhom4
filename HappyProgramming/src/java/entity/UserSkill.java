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
 * This class represents the UserSkill table in database
 *
 * @author 
 */
public class UserSkill {
    
    /**
     * Id of (User)
     */
    private int uId;
    
    /**
     * Id of (Skill)
     */
    private int sId;
    
    /**
     * Status of (UserSkill)
     */
    private String status;
    
    /**
     * Constructor.<br>
     *
     */
    public UserSkill() {
    }

    /**
     * Constructor.<br>
     *
     * @param uId it is an Integer
     * @param sId it is an Integer
     * @param status it is a <code>java.lang.String</code>
     */
    public UserSkill(int uId, int sId, String status) {
        this.uId = uId;
        this.sId = sId;
        this.status = status;
    }
    
    /**
     * Get value from uId attribute of UserSkill class. <br>
     *
     * @return uId it is an Integer
     */   
    public int getuId() {
        return uId;
    }

    /**
     * set value to uId attribute of UserSkill class. <br>
     *
     * @param uId is an Integer
     */ 
    public void setuId(int uId) {
        this.uId = uId;
    }
    
    /**
     * Get value from sId attribute of UserSkill class. <br>
     *
     * @return sId it is an Integer
     */   
    public int getsId() {
        return sId;
    }

    /**
     * set value to sId attribute of UserSkill class. <br>
     *
     * @param sId is an Integer
     */ 
    public void setsId(int sId) {
        this.sId = sId;
    }

    /**
    * Get value from Status attribute of UserSkill class. <br>
    *
    * @return status it is a <code>java.lang.String</code>
    */
    public String getStatus() {
        return status;
    }

    /**
     * Set value to Status attribute of CV class. <br>
     *
     * @param status it is a <code>java.lang.String</code>
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
