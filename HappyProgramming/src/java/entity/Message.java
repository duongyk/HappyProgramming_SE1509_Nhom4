/*
 * Copyright (C) 2021, FPT University<br>
 * SWP391 - SE1509 - Group 4<br>
 * Happyprogramming<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 20-09-2021    1.0        GiangNVT          First Deploy<br>
 */
package entity;

/**
 *
 * This class represents the Message table in database
 *
 * @author Giangnvthe150748
 */
public class Message {

    /**
     * Message ID
     */
    private int mId;
    /**
     * Message Title
     */
    private String title;
    /**
     * email of Message
     */
    private String email;
    /**
     * Message content
     */
    private String content;
    /**
     * Status of message: is read or unread
     */
    private String isRead;

    /**
     * Constructor
     */
    public Message() {
    }

    /**
     * Constructor.<br>
     *
     * @param mId it is an int number
     * @param title it is a <code>java.lang.String</code>
     * @param email it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param isRead it is a <code>java.lang.String</code>
     */
    public Message(int mId, String title, String email, String content, String isRead) {
        this.mId = mId;
        this.title = title;
        this.email = email;
        this.content = content;
        this.isRead = isRead;
    }

    /**
     * Constructor.<br>
     *
     * @param title it is a <code>java.lang.String</code>
     * @param email it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     * @param isRead it is a <code>java.lang.String</code>
     */
    public Message(String title, String email, String content, String isRead) {
        this.title = title;
        this.email = email;
        this.content = content;
        this.isRead = isRead;
    }

    /**
     * Constructor.<br>
     *
     * @param title it is a <code>java.lang.String</code>
     * @param email it is a <code>java.lang.String</code>
     * @param content it is a <code>java.lang.String</code>
     */
    public Message(String title, String email, String content) {
        this.email = email;
        this.title = title;
        this.content = content;
    }

    /**
     * Get value from mID attribute of Message class. <br>
     *
     * @return from it is an int number
     */
    public int getmId() {
        return mId;
    }

    /**
     * Set value to mID attribute of Message class. <br>
     *
     * @param mId it is an int number
     */
    public void setmId(int mId) {
        this.mId = mId;
    }

    /**
     * Get value from mID attribute of Message class. <br>
     *
     * @return isRead it is a <code>java.lang.String</code>
     */
    public String getIsRead() {
        return isRead;
    }

    /**
     * Set value to isRead attribute of Message class. <br>
     *
     * @param isRead
     */
    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    /**
     * Get value from Title attribute of Message class. <br>
     *
     * @return Title it is a <code>java.lang.String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set value to Title attribute of Message class. <br>
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get value from Title attribute of Message class. <br>
     *
     * @return Title it is a <code>java.lang.String</code>
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value to Title attribute of Message class. <br>
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get value from Title attribute of Message class. <br>
     *
     * @return Title it is a <code>java.lang.String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value to Content attribute of Message class. <br>
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Print value of Message. <br>
     *
     * @return a <code>java.lang.String</code>
     */
    @Override
    public String toString() {
        return this.mId + this.content + this.email + this.title + this.isRead;
    }

}
