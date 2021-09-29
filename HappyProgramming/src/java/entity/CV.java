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
public class CV {

    private int uId;
    private String profession;
    private String professionIntro;
    private String serviceDescript;
    private String achivement;

    public CV() {
    }

    public CV(int uId, String profession, String professionIntro, String serviceDescript, String achivement) {
        this.uId = uId;
        this.profession = profession;
        this.professionIntro = professionIntro;
        this.serviceDescript = serviceDescript;
        this.achivement = achivement;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfessionIntro() {
        return professionIntro;
    }

    public void setProfessionIntro(String professionIntro) {
        this.professionIntro = professionIntro;
    }

    public String getServiceDescript() {
        return serviceDescript;
    }

    public void setServiceDescript(String serviceDescript) {
        this.serviceDescript = serviceDescript;
    }

    public String getAchivement() {
        return achivement;
    }

    public void setAchivement(String achivement) {
        this.achivement = achivement;
    }

}
