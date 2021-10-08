/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.User;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author Tung
 */
public class SendEmail {
    public int sendEmail(User user) {
        
        int n = 0;
        String toEmail = user.getMail();
        String fromEmail = "tungduong91101@gmail.com";
        String password = "Tung0911";
        
        try {

            // your host email smtp server details
            Properties pr = new Properties();
            // option1:
            pr.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            pr.put("mail.smtp.port", "587"); //TLS Port
            pr.put("mail.smtp.auth", "true"); //enable authentication
            pr.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
 
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            //set email message details
            Message msg = new MimeMessage(session);
            
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            //set from email address
            msg.setFrom(new InternetAddress(fromEmail, "Administrator"));
            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            //set to email address or destination email address
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            
            //set email subject
            msg.setSubject("Forgot password code");
            
            //set message text
            msg.setText("Hello, " + user.getUsername() + ". Please use this code to login and change new pasword: " + user.getPassword());
            //send the message
            Transport.send(msg);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
