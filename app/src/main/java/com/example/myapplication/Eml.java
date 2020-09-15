package com.example.myapplication;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Eml {
    private static String from;
    private static String to;
    private static String pswd;
    private static Properties prop;
    private static Session session;

    public Eml(String destination, String source, String pswd){
        this.to = destination;
        this.from = source;
        this.pswd = pswd;
        this.prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.setProperty("mail.transport.protocol", "smtp");	//smtp
        prop.setProperty("mail.smtp.host", "smtp.qq.com");
        prop.setProperty("mail.smtp.port", "465");				//port = 465
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.smtp.socketFactory.port", "465");

        session = Session.getInstance(prop);
        session.setDebug(true);
    }

    public void send (String subject, String content){
        try {
            MimeMessage msg = new MimeMessage(this.session);

            msg.setFrom(new InternetAddress(this.from));    //set from

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(this.to));    //set to
            msg.setSubject(subject, "UTF-8");
            msg.setContent(content, "text/html;charset=UTF-8");
            msg.setSentDate(new Date());

            Transport transport = session.getTransport();
            transport.connect(this.from, this.pswd);
            transport.sendMessage(msg, new Address[]{new InternetAddress(this.to)});

        } catch (MessagingException e){
            e.printStackTrace();
        }
    }

}
