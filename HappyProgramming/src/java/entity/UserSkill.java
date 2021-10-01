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

    private int uId;
    private int sId;
    private String status;

    public UserSkill() {
    }

    public UserSkill(int uId, int sId, String status) {
        this.uId = uId;
        this.sId = sId;
        this.status = status;
    }
}
