package com.revature.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	 private static final String SMTP_GMAIL_COM = "smtp.gmail.com";
	public static void sendMailUsingTLS(String host,
	            String username, String password, String from,
	            String to, String subject, String text) {
	         Properties properties = new Properties();
	         properties.put("mail.smtp.host", host);
	         properties.put("mail.smtp.auth", "true");
	         properties.put("mail.smtp.starttls.enable", "true");
	         properties.put("mail.smtp.port", "587");
	         properties.put("mail.smtp.ssl.trust", SMTP_GMAIL_COM);
	         sendMail(properties, username, password, from, to,
	            subject, text);
	      }
	      public static void sendMailUsingSSL(String host,
	            String username, String password, String from,
	            String to, String subject, String text) {
	         Properties properties = new Properties();
	         properties.put("mail.smtp.host", SMTP_GMAIL_COM);
	         properties.put("mail.smtp.socketFactory.port", "465");
	         properties.put("mail.smtp.socketFactory.class",
	            "javax.net.ssl.SSLSocketFactory");
	         properties.put("mail.smtp.auth", "true");
	         properties.put("mail.smtp.port", "465");
	         sendMail(properties, username, password, from, to,
	            subject, text);
	      }
	      public static void sendMail(Properties properties,
	            final String username, final String password,
	            String fromEmailAddress, String toEmailAddress,
	            String subject, String messageText) {
	         Session session = Session.getInstance(properties,
	               new Authenticator() {
	            @Override
	            protected PasswordAuthentication
	                  getPasswordAuthentication() {
	               return new PasswordAuthentication(username,
	                  password);
	            }
	         });
	         try {
	            Message msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress(fromEmailAddress));
	            msg.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(toEmailAddress));
	            msg.setSubject(subject);
	            msg.setText(messageText);
	            Transport.send(msg);
	         } catch (Exception ex) {
	            ex.printStackTrace();
	         }
	      }
	      public static void main(String[] args) {
	         String host = SMTP_GMAIL_COM;
	         String username = "keyne.loui@gmail.com";
	         String password = "zzxkrzecjtcnmzsq"; 
	         String fromAddress = "keyne.loui@gmail.com";
	         String toAddress = "katherinmaria04@gmail.com";
	         String subject = "Test mail";
	         String text = "This is a sample message. Thank you.";
	         MailUtil.sendMailUsingTLS(host, username, password,
	         fromAddress, toAddress, subject, text);
	         MailUtil.sendMailUsingSSL(host, username, password, fromAddress, toAddress,
	        subject, text);
	      }

}
