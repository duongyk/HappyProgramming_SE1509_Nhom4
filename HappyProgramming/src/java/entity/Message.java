/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author solov
 */
public class Message {

    private int mId;
    private String title;
    private String email;
    private String content;
    private String isRead;

    public Message() {
    }

    public Message(int mId, String title, String email, String content, String isRead) {
        this.mId = mId;
        this.title = title;
        this.email = email;
        this.content = content;
        this.isRead = isRead;
    }

    public Message(String title, String email, String content, String isRead) {
        this.title = title;
        this.email = email;
        this.content = content;
        this.isRead = isRead;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public Message(String title, String email, String content) {
        this.email = email;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public Message(int mId, String subject, String fullName, String content) {
        this.mId = mId;
        this.title = subject;
        this.email = fullName;
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.mId + this.content + this.email + this.title + this.isRead;
    }

}
