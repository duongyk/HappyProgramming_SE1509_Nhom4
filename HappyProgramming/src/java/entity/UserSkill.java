/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Duong
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
