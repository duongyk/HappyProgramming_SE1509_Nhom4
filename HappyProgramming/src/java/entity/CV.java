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
 * @author thangtvhe151307
 * This class represents the CV table in database
 */
public class CV {
    
    /**
     * ID from (User)
     */
    private int id;
    /**
     * CV Profession
     */
    private String profession;
    /**
     * CV professionIntro
     */
    private String professionIntro;
    /**
     * CV serviceDescript
     */
    private String serviceDescript;
    /**
     * CV achievement
     */
    private String achivement;

    public CV() {
    }

    public CV(int id, String profession, String professionIntro, String serviceDescript, String achivement) {
        this.id = id;
        this.profession = profession;
        this.professionIntro = professionIntro;
        this.serviceDescript = serviceDescript;
        this.achivement = achivement;
    }

    public CV(String profession, String professionIntro, String serviceDescript, String achivement) {
        this.profession = profession;
        this.professionIntro = professionIntro;
        this.serviceDescript = serviceDescript;
        this.achivement = achivement;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
