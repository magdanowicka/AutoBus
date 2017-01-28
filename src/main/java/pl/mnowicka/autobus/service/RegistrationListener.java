package pl.mnowicka.autobus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import pl.mnowicka.autobus.entities.User;

import java.util.UUID;

@Component
public class RegistrationListener extends JavaMailSenderImpl implements ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    private IUserService service;
    @Autowired
    private MessageSource messages;
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) {

        User user = event.getUser();

        String token = UUID.randomUUID().toString();

        //service.createVerificationToken(user, token);


        String recipientAddress = user.getEmail();

        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getAppUrl() + "/regitrationConfirm.html?token=" + token;

        //String message = messages.getMessage("message.regSucc", null, event.getLocale());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);

        email.setText("kurwa kliknij" + "http://localhost:8080" + confirmationUrl);

        mailSender.send(email);
    }
}

