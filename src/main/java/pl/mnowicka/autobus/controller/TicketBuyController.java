package pl.mnowicka.autobus.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.service.SendEmailTicket;
import pl.mnowicka.autobus.config.ViewsAggregate;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by magda on 2017-02-26.
 */
@Controller
public class TicketBuyController {

    private final static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    SendEmailTicket service;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goHome(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/home";
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public ModelAndView ticketBuy(@RequestParam(value = "email") String email, HttpServletRequest request, HttpServletResponse response) {

        service.sendEmailWithTicket(email);
        ModelAndView mav = new ModelAndView(ViewsAggregate.SUCCESS);
        return mav;
    }
}
