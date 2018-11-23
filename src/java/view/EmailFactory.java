/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import transferobjects.Host;
import transferobjects.Renter;

/**
 *
 * @author chris
 */
public class EmailFactory {
    
    private static final String FROM_EMAIL = "donotreplycst8334@gmail.com";
    private static final String PASSWORD = "ahometoshare";
    
    public static void sendConfirmationEmail(String sendToEmail, String name) {

        String toEmail = sendToEmail;
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        try{
            //create Authenticator object to pass in Session.getInstance argument
            Authenticator authentication = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
                }
            };
            Session session = Session.getInstance(properties, authentication);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("A Home to Share Registration Confirmation");
            message.setText(
                "Hello " + name + ",\n\n"
                + "This is an email to confirm that you have successfully registered with A Home to Share."
                + "You can now login to start using our website. We hope that you find everything that you're looking for!\n\n"
                + "If you have any questions, be sure to visit our F.A.Q. page, or click on \"How we work\".\n\n"
                + "Sincerely,\n\n"
                + "'A Home to Share' Team"
            );

            Transport.send(message);
            System.out.println("Email sent.");
        }catch(Exception e){
            System.out.println("Email failed to send.");
            System.out.println(e);
        }
    }
    
    public static void sendPasswordResetEmail(String sendToEmail, String name, String newPassword) {

        String toEmail = sendToEmail;
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        try{
            //create Authenticator object to pass in Session.getInstance argument
            Authenticator authentication = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
                }
            };
            Session session = Session.getInstance(properties, authentication);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("A Home to Share Registration Confirmation");
            message.setText(
                "Hello " + name + ",\n\n"
                + "Your password has been reset to:\n\n"
                + "\t" + newPassword + "\n\n"
                + "You can now use your new password to login. If you would like to change this password:\n"
                + "1. After logging in, click the 'My Account' tab in the top right hand corner.\n"
                + "2. Click 'Account Settings' in the side bar menu on the left.\n"
                + "3. For the field 'Old Password', enter the new password that we've provided above.\n"
                + "4. Enter in your desired password and confirm it in the text fields below.\n"
                + "5. Click the 'Change Password' button.\n\n"
                + "Sincerely,\n\n"
                + "'A Home to Share' Team"
            );

            Transport.send(message);
            System.out.println("Email sent.");
        }catch(Exception e){
            System.out.println("Email failed to send.");
            System.out.println(e);
        }
    }
    
    
    public static void sendBookingRequest(String sendToEmail, Renter renter, Host host) {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        try{
            //create Authenticator object to pass in Session.getInstance argument
            Authenticator authentication = new Authenticator() {
                //override the getPasswordAuthentication method
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
                }
            };
            Session session = Session.getInstance(properties, authentication);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendToEmail));
            message.setSubject("Renter Booking Request");
            message.setText(
                "Hello, " + "\n\n"
                + renter.getFirstName() + " " + renter.getLastName() + " (" + renter.getEmail() + ") " + "would like to request a booking with "
                + host.getFirstName() + " " + host.getLastName() + " (" + host.getEmail() + ")."
                + "\n\n This is an automated message from generated by A Home to Share website."
            );

            Transport.send(message);
            System.out.println("Email sent.");
        }catch(Exception e){
            System.out.println("Email failed to send.");
            System.out.println(e);
        }
    }
    
}
