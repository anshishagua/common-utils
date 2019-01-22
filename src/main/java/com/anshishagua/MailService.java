package com.anshishagua;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class MailService {
    public static void main(String [] args) throws Exception {
        String fromEmail = "anshishagua@126.com";
        String toEmail = "anshishagua@126.com";
        String subject = "hello";
        String content = "Hello, world!";

        Properties properties = new Properties();

        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", "smtp.126.com");

        Session session = Session.getInstance(properties);
        session.setDebug(true);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));

        message.setSubject(subject);

        message.setSentDate(new Date());

        MimeBodyPart image = new MimeBodyPart();
        DataHandler handler = new DataHandler(new FileDataSource("/Users/xiaoli/Desktop/test.png"));
        image.setFileName("test.png");
        image.setDataHandler(handler);

        MimeBodyPart text = new MimeBodyPart();
        text.setContent("hello,world", "text/html;charset=UTF-8");

        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(text);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("mixed");
        message.setContent(mimeMultipart);

        Transport transport = session.getTransport();
        transport.connect(fromEmail, "aaa");
        transport.sendMessage(message, message.getAllRecipients());

        //5、关闭邮件连接
        transport.close();
    }
}
