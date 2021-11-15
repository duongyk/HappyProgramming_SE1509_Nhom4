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

import java.sql.Date;

/**
 *
 * This class represents the User table in database
 *
 * @author
 */
public class User {

    /**
     * Id of (User)
     */
    private int id;

    /**
     * username of (User)
     */
    private String username;

    /**
     * password of (User)
     */
    private String password;

    /**
     * fullname of (User)
     */
    private String fullname;

    /**
     * mail of (User)
     */
    private String mail;

    /**
     * phone of (User)
     */
    private String phone;

    /**
     * Date of birth of (User)
     */
    private Date dob;

    /**
     * gender of (User)
     */
    private String gender;

    /**
     * avatar of (User)
     */
    private String avatar;

    /**
     * role of (User)
     */
    private int role;

    /**
     * verify code of (User)
     */
    private String verify;

    /**
     * status of (User)
     *
     */
    private int status;
    /**
     * total study of (User)
     *
     */
    private int totalHour;
  /**
     * Constructor.<br>
     */
    public User() {
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * Constructor.<br>
     *
     * @param username it is a <code>java.lang.String</code>
     * @param password it is a <code>java.lang.String</code>
     *
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, int totalHour) {
        this.id = id;
        this.username = username;
        this.totalHour = totalHour;
    }

    /**
     * Constructor.<br>
     *
     * @param username it is a <code>java.lang.String</code>
     * @param password it is a <code>java.lang.String</code>
     * @param fullname it is a <code>java.lang.String</code>
     * @param mail it is a <code>java.lang.String</code>
     * @param phone it is a <code>java.lang.String</code>
     * @param dob it is a <code>java.sql.Date</code>
     * @param gender it is a <code>java.lang.String</code>
     * @param avatar it is a <code>java.lang.String</code>
     * @param role it is a int number
     *
     */
    public User(String username, String password, String fullname, String mail, String phone, Date dob, String gender, String avatar, int role, int status) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mail = mail;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.avatar = avatar;
        this.role = role;
        this.status = status;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     * @param username it is a <code>java.lang.String</code>
     * @param password it is a <code>java.lang.String</code>
     * @param fullname it is a <code>java.lang.String</code>
     * @param mail it is a <code>java.lang.String</code>
     * @param phone it is a <code>java.lang.String</code>
     * @param dob it is a <code>java.sql.Date</code>
     * @param gender it is a <code>java.lang.String</code>
     * @param avatar it is a <code>java.lang.String</code>
     *
     */
    public User(int id, String username, String password, String fullname, String mail, String phone, Date dob, String gender, String avatar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mail = mail;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.avatar = avatar;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     * @param username it is a <code>java.lang.String</code>
     * @param password it is a <code>java.lang.String</code>
     * @param fullname it is a <code>java.lang.String</code>
     * @param mail it is a <code>java.lang.String</code>
     * @param phone it is a <code>java.lang.String</code>
     * @param dob it is a <code>java.sql.Date</code>
     * @param gender it is a <code>java.lang.String</code>
     * @param avatar it is a <code>java.lang.String</code>
     * @param role it is a int number
     *
     */
    public User(int id, String username, String password, String fullname, String mail, String phone, Date dob, String gender, String avatar, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mail = mail;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.avatar = avatar;
        this.role = role;
    }

    /**
     * Constructor.<br>
     *
     * @param username it is a <code>java.lang.String</code>
     * @param password it is a <code>java.lang.String</code>
     * @param fullname it is a <code>java.lang.String</code>
     * @param mail it is a <code>java.lang.String</code>
     * @param phone it is a <code>java.lang.String</code>
     * @param dob it is a <code>java.sql.Date</code>
     * @param gender it is a <code>java.lang.String</code>
     * @param avatar it is a <code>java.lang.String</code>
     *
     */
    public User(String username, String password, String fullname, String mail, String phone, Date dob, String gender, String avatar) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mail = mail;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.avatar = avatar;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     * @param fullname it is a <code>java.lang.String</code>
     * @param mail it is a <code>java.lang.String</code>
     * @param phone it is a <code>java.lang.String</code>
     * @param dob it is a <code>java.sql.Date</code>
     * @param gender it is a <code>java.lang.String</code>
     * @param avatar it is a <code>java.lang.String</code>
     *
     */
    public User(int id, String fullname, String mail, String phone, Date dob, String gender, String avatar) {
        this.id = id;
        this.fullname = fullname;
        this.mail = mail;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.avatar = avatar;
    }

    /**
     * Constructor.<br>
     *
     * @param id it is a int number
     * @param username it is a <code>java.lang.String</code>
     * @param password it is a <code>java.lang.String</code>
     * @param fullname it is a <code>java.lang.String</code>
     * @param mail it is a <code>java.lang.String</code>
     * @param phone it is a <code>java.lang.String</code>
     * @param dob it is a <code>java.sql.Date</code>
     * @param gender it is a <code>java.lang.String</code>
     * @param avatar it is a <code>java.lang.String</code>
     * @param role it is a int number
     * @param status it is a int number
     *
     */
    public User(int id, String username, String password, String fullname, String mail, String phone, Date dob, String gender, String avatar, int role, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mail = mail;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.avatar = avatar;
        this.role = role;
        this.status = status;
    }

    /**
     * Get value from Id attribute of User class. <br>
     *
     * @return id it is an int number
     */
    public int getId() {
        return id;
    }

    /**
     * Get value from username attribute of User class. <br>
     *
     * @return username it is a <code>java.lang.String</code>
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get value from password attribute of User class. <br>
     *
     * @return password it is a <code>java.lang.String</code>
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get value from fullname attribute of User class. <br>
     *
     * @return fullname it is a <code>java.lang.String</code>
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Get value from mail attribute of User class. <br>
     *
     * @return mail it is a <code>java.lang.String</code>
     */
    public String getMail() {
        return mail;
    }

    /**
     * Get value from phone attribute of User class. <br>
     *
     * @return phone it is a <code>java.lang.String</code>
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get value from dob attribute of User class. <br>
     *
     * @return dob it is a <code>java.sql.Date</code>
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Get value from gender attribute of User class. <br>
     *
     * @return gender it is a <code>java.lang.String</code>
     */
    public String getGender() {
        return gender;
    }

    /**
     * Get value from avatar attribute of User class. <br>
     *
     * @return avatar it is a <code>java.lang.String</code>
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Get value from role attribute of User class. <br>
     *
     * @return role it is an int number
     */
    public int getRole() {
        return role;
    }

    /**
     * Get value from Status attribute of User class. <br>
     *
     * @return status it is an int number
     */
    public int getStatus() {
        return status;
    }

    /**
     * Set value to id attribute of User class. <br>
     *
     * @param id it is an int number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set value to username attribute of User class. <br>
     *
     * @param username it is a <code>java.lang.String</code>
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set value to password attribute of User class. <br>
     *
     * @param password it is a <code>java.lang.String</code>
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set value to fullname attribute of User class. <br>
     *
     * @param fullname it is a <code>java.lang.String</code>
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Set value to mail attribute of User class. <br>
     *
     * @param mail it is a <code>java.lang.String</code>
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Set value to phone attribute of User class. <br>
     *
     * @param phone it is a <code>java.lang.String</code>
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set value to dob attribute of User class. <br>
     *
     * @param dob it is a <code>java.sql.Date</code>
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Set value to gender attribute of User class. <br>
     *
     * @param gender it is a <code>java.lang.String</code>
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Set value to avatar attribute of User class. <br>
     *
     * @param avatar it is a <code>java.lang.String</code>
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Set value to role attribute of User class. <br>
     *
     * @param role it is an int number
     */
    public void setRole(int role) {
        this.role = role;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get value to role attribute of User class. <br>
     *
     * @param verify it is a <code>java.lang.String</code>
     */
    public String getVerify() {
        return verify;
    }

    /**
     * Set value to role attribute of User class. <br>
     *
     * @param verify it is a <code>java.lang.String</code>
     */
    public void setVerify(String verify) {
        this.verify = verify;
    }

    public int getTotalHour() {
        return totalHour;
    }

    /**
     * Constructor.<br>
     *
     */
    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }

}
