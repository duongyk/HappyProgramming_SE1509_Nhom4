/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import javax.servlet.ServletContext;

/**
 *
 * @author Tung
 */
public interface EmailService {
    /**
     * Get send email to the user
     *
     * @param context
     * @param recipient 
     * @param type
     */
    void sendEmail(ServletContext context, User recipient, String type);
}
