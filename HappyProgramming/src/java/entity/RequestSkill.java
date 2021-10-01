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
     * Get value from attribute of Skill class. <br>
     *
     * @return rId it is a int number
     */
    public int getrId() {
        return rId;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @return rId it is a int number
     */
    public void setrId(int rId) {
        this.rId = rId;
    }

    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return sId it is a int number
     */
    public int getsId() {
        return sId;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @return sId it is a int number
     */
    public void setsId(int sId) {
        this.sId = sId;
    }
}
