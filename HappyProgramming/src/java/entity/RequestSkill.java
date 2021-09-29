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
public class RequestSkill {

    private int rId;
    private int sId;

    public RequestSkill() {
    }

    public RequestSkill(int rId, int sId) {
        this.rId = rId;
        this.sId = sId;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }
}
