package by.epam.finalTask.util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class MailSender {
    private static final Logger logger = LogManager.getLogger();
    private static final String CONFIG_FILEPATH = "mail.properties";
    private static final String USER_MAIL = "mail.user.mail";
    private static final String USER_PASSWORD = "mail.user.password";

    private MailSender() {
    }

    public static void sendMail(String recipientAddress, String text) {

        try {
            Properties properties = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream(CONFIG_FILEPATH);
            try {
                properties.load(stream);
            } catch (IOException e) {
                logger.log(Level.ERROR, "Error occurred when email sending, problem with mail api properties data", e);
            }
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String passwordGlobal = (String) properties.get(USER_PASSWORD);

                    return new PasswordAuthentication((String) properties.get(USER_MAIL),
                            passwordGlobal);
                }
            });
            String subject = "activate code";
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String) properties.get(USER_MAIL)));
            message.setSubject(subject);
            message.setText(text);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));
            Transport.send(message);
        } catch (MessagingException e) {
            logger.log(Level.ERROR, "Error occurred when email sending to " + recipientAddress, e);
        }
    }

}
