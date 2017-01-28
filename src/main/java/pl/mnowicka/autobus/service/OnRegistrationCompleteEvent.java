package pl.mnowicka.autobus.service;


import org.springframework.context.ApplicationEvent;

import pl.mnowicka.autobus.entities.User;

import java.util.Locale;
import java.util.logging.Logger;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private final String appUrl;
    private final Locale locale;
    private final User user;


    public OnRegistrationCompleteEvent(
            User user, Locale locale, String appUrl) {
        super(user);
        System.out.println("weszlo do on registration complete event");
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
        System.out.println(user);
        System.out.println(locale);
        System.out.println(appUrl);
    }



    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public User getUser() {
        return user;
    }


}