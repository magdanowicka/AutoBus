package pl.mnowicka.autobus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("sendEmail")
public class SendEmailAPI extends JavaMailSenderImpl {


    @Autowired
    private MailSender emailSender;

    public void sendEmailReadyToSendEmail(String fromAddress, String name, String msgBody) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(fromAddress);
        email.setTo("autobuspomoc@gmail.com");
        email.setSubject("Waidomośc od użytkownika o imieniu " + name);
        email.setText(msgBody + " || mail do kontaktu: " + fromAddress);
        emailSender.send(email);
    }
}
