/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Duong
 */
public class User {

    private int uId;
    private String username;
    private String password;
    private String fullname;
    private String uMail;
    private String uPhone;
    private Date dob;
    private String gender;
    private String uAvatar;
    private int uRole;

    public User() {
    }

    public User(int uId) {
        this.uId = uId;
    }
    
    public User(String username, String password) {
       this.username = username;
        this.password = password;
    }

    public User(int uId, String username, String password, String fullname, String uMail, String uPhone, Date dob, String gender, String uAvatar) {
        this.uId = uId;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.uMail = uMail;
        this.uPhone = uPhone;
        this.dob = dob;
        this.gender = gender;
        this.uAvatar = uAvatar;
    }

    
    public User(int uId, String username, String password, String fullname, String uMail, String uPhone, Date dob, String gender, String uAvatar,int uRole) {
        this.uId = uId;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.uMail = uMail;
        this.uPhone = uPhone;
        this.dob = dob;
        this.gender = gender;
        this.uAvatar = uAvatar;
        this.uRole = uRole;
    }

    public Date getDob() {
        return dob;
    }

    public String getFullname() {
        return fullname;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getuAvatar() {
        return uAvatar;
    }

    public String getuMail() {
        return uMail;
    }

    public String getuPhone() {
        return uPhone;
    }

    public int getuRole() {
        return uRole;
    }

    public int getuId() {
        return uId;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setuAvatar(String uAvatar) {
        this.uAvatar = uAvatar;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public void setuRole(int uRole) {
        this.uRole = uRole;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
     
}

    