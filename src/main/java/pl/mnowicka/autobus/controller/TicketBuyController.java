package pl.mnowicka.autobus.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.service.SendEmailTicket;
import sun.misc.Contended;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * Created by magda on 2017-02-26.
 */
@Controller
public class TicketBuyController {

    private final static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    SendEmailTicket service;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String goHome (HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/home";
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public ModelAndView ticketBuy(@RequestParam(value = "email") String email, HttpServletRequest request, HttpServletResponse response) {

        service.sendEmailWithTicket(email);

        Integer cena = 16;


        ModelAndView mav = new ModelAndView("success");

        return mav;
    }


}
