package pl.mnowicka.autobus.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.service.SendEmailAPI;

import javax.servlet.http.HttpServletResponse;


@Controller
public class ContactController {

    @Autowired
    SendEmailAPI service;

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView contactForm(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email, @RequestParam(value = "message") String message, HttpServletRequest request, HttpServletResponse response) {


        service.sendEmailReadyToSendEmail(email, name, message);

        ModelAndView mav = new ModelAndView("home");

        return mav;

    }



}
