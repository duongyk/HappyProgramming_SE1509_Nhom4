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
 * This class represents the SkillMentor table in database
 *
 * @author 
 */
public class SkillMentor {
    
    /**
    * Id of (User)
    */
    private int uId;
    
    /**
    * Id of (Skill)
    */
    private int sId;

    public SkillMentor() {
    }

    public SkillMentor(int uId, int sId) {
        this.uId = uId;
        this.sId = sId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

}
