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
    
    /**
     * Constructor.<br>
     *
     * @param id it is an Integer
     * @param profession it is a <code>java.lang.String</code>
     * @param professionIntro it is a <code>java.lang.String</code>
     * @param serviceDescript it is a <code>java.lang.String</code>
     * @param achivement it is a <code>java.lang.String</code>
     */
    
    public CV(int id, String profession, String professionIntro, String serviceDescript, String achivement) {
        this.id = id;
        this.profession = profession;
        this.professionIntro = professionIntro;
        this.serviceDescript = serviceDescript;
        this.achivement = achivement;
    }
    
    /**
     * Constructor.<br>
     *
     * @param profession it is a <code>java.lang.String</code>
     * @param professionIntro it is a <code>java.lang.String</code>
     * @param serviceDescript it is a <code>java.lang.String</code>
     * @param achivement it is a <code>java.lang.String</code>
     */
    
    public CV(String profession, String professionIntro, String serviceDescript, String achivement) {
        this.profession = profession;
        this.professionIntro = professionIntro;
        this.serviceDescript = serviceDescript;
        this.achivement = achivement;
    }

    /**
     * Get value from Id attribute of CV class. <br>
     *
     * @return id it is an Integer
     */   
    public int getId() {
        return id;
    }
    
    /**
     * set value to Id attribute of CV class. <br>
     *
     * @param id is an Integer
     */   
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get value from Profession attribute of CV class. <br>
     *
     * @return profession it is a <code>java.lang.String</code>
     */
    public String getProfession() {
        return profession;
    }
    
    /**
     * Set value to Profession attribute of CV class. <br>
     *
     * @param profession it is a <code>java.lang.String</code>
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    /**
     * Get value from ProfessionIntro attribute of CV class. <br>
     *
     * @return professionIntro it is a <code>java.lang.String</code>
     */
    public String getProfessionIntro() {
        return professionIntro;
    }

    /**
     * Set value to ProfessionIntro attribute of CV class. <br>
     *
     * @param professionIntro it is a <code>java.lang.String</code>
     */
    public void setProfessionIntro(String professionIntro) {
        this.professionIntro = professionIntro;
    }
    
    /**
     * Get value from ServiceDescript attribute of CV class. <br>
     *
     * @return serviceDescript it is a <code>java.lang.String</code>
     */
    public String getServiceDescript() {
        return serviceDescript;
    }

    /**
     * Set value to ServiceDescript attribute of CV class. <br>
     *
     * @param serviceDescript it is a <code>java.lang.String</code>
     */
    public void setServiceDescript(String serviceDescript) {
        this.serviceDescript = serviceDescript;
    }
    
    /**
     * Get value from Achivement attribute of CV class. <br>
     *
     * @return achivement it is a <code>java.lang.String</code>
     */
    public String getAchivement() {
        return achivement;
    }
    
    /**
     * Set value to Achivement attribute of CV class. <br>
     *
     * @param achivement it is a <code>java.lang.String</code>
     */
    public void setAchivement(String achivement) {
        this.achivement = achivement;
    }
   

}
