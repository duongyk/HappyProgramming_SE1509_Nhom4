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
 * This class represents the Skill table in database
 *
 * @author
 */
public class Skill {

    /**
     * Id of (Skill)
     */
    private int id;

    /**
     * Name from (Skill)
     */
    private String name;

    /**
     * Detail of (Skill)
     */
    private String detail;

    /**
     * Image link of (Skill)
     */
    private String image;

    /**
     * Video link of (Skill)
     */
    private String link;
    
    /**
     * Image link of (Skill)
     */
    private int status;

    private int total;

    /**
     * Constructor.<br>
     */
    public Skill() {
    }

    /**
     * Constructor.<br>
     *
     * @param id it is an int number
     */
    public Skill(int id) {
        this.id = id;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     * @param name it is a <code>java.lang.String</code>
     * @param detail it is a <code>java.lang.String</code>
     * @param image <code>java.lang.String</code>
     * @param status it is a int number
     */
    public Skill(int id, String name, String detail, String image, int status) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.image = image;
        this.status = status;
    }

    /**
     * Constructor.<br>
     *
     * @param name it is a <code>java.lang.String</code>
     * @param detail it is a <code>java.lang.String</code>
     * @param image <code>java.lang.String</code>
     */
    public Skill(String name, String detail, String image) {
        this.name = name;
        this.detail = detail;
        this.image = image;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     * @param name it is a <code>java.lang.String</code>
     * @param detail it is a <code>java.lang.String</code>
     * @param image <code>java.lang.String</code>
     * @param status it is a int number
     */
    public Skill(int id, String name, String detail, String image, int status, int total) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.image = image;
        this.status = status;
        this.total = total;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     * @param name it is a <code>java.lang.String</code>
     * @param detail it is a <code>java.lang.String</code>
     * @param image <code>java.lang.String</code>
     */
    public Skill(int id, String name, String detail, String image) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.image = image;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     * @param name it is a <code>java.lang.String</code>
     * @param detail it is a <code>java.lang.String</code>
     * @param image <code>java.lang.String</code>
     * @param status it is a int number
     * @param link <code>java.lang.String</code>
     */
    public Skill(int id, String name, String detail, String image, String link, int status) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.image = image;
        this.link = link;
        this.status = status;
    }
    
    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return id it is a int number
     */
    public int getId() {
        return id;
    }

    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return name it is a <code>java.lang.String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return detail it is a <code>java.lang.String</code>
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return image it is a <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return link it is a <code>java.lang.String</code>
     */
    public String getLink() {
        return link;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }
    
    /**
     * Get value from attribute of Skill class. <br>
     *
     * @return status it is a int number
     */
    public int getStatus() {
        return status;
    }

    /**
     * Set value from attribute of Skill class. <br>
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return this.name + this.total;
    }

}
