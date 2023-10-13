package com.example.FeedbackandSupportService;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class FeedbackSupportService {
    private final String smtpHost = "your-smtp-host"; // SES SMTP host
    private final int smtpPort = 587; // SES SMTP port
    private final String smtpUsername = "your-smtp-username"; // SES SMTP username
    private final String smtpPassword = "your-smtp-password"; // SES SMTP password

    public void sendFeedback(String senderEmail, String feedbackText) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", smtpHost);
            properties.put("mail.smtp.port", smtpPort);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(smtpUsername, smtpPassword);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("feedback@yourdomain.com")); // Replace with your feedback email address
            message.setSubject("Feedback Received");
            message.setText("Feedback from: " + senderEmail + "\n\n" + feedbackText);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendSupportRequest(String senderEmail, String supportText) {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", smtpHost);
            properties.put("mail.smtp.port", smtpPort);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(smtpUsername, smtpPassword);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("support@yourdomain.com")); // Replace with your support email address
            message.setSubject("Support Request");
            message.setText("Support request from: " + senderEmail + "\n\n" + supportText);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
