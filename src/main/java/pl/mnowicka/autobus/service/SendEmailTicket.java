package pl.mnowicka.autobus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("sendEmailTicket")
public class SendEmailTicket extends JavaMailSenderImpl {

    @Autowired
    private MailSender emailSender;

    public void sendEmailWithTicket(String to) {

        SimpleMailMessage emiailTicket = new SimpleMailMessage();

        emiailTicket.setTo(to);
        emiailTicket.setSubject("AutoBus - bilet elektroniczny");

        emiailTicket.setText("Kupiłeś bilet na przejazd trasą Białystok-Warszawa dnia 2017-01-23 o godzinie 6:60." +
                "Numer Twojego biletu to: 6391, a numer siedzenia: 23. Przy wsiadaniu do autobusu nalęży podać kierowcy numer biletu. ");

        emailSender.send(emiailTicket);
    }
}
