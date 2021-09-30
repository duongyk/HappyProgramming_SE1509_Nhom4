/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Duong
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String fullname;
    private String mail;
    private String phone;
    private Date dob;
    private String gender;
    private String avatar;
    private int role;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String username, String password, String fullname, String mail, String phone, Date dob, String gender, String avatar, int role) {
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

    public User(String username, String password) {
       this.username = username;
        this.password = password;
    }

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

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
     
}

    