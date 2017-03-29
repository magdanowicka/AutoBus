package pl.mnowicka.autobus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.entities.VerificationToken;
import pl.mnowicka.autobus.service.*;
import pl.mnowicka.autobus.domain.UserDto;
import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.config.ViewsAggregate;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by magda on 2017-01-24.
 */
@Controller
public class RegistrationController {

    private final static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {

        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return ViewsAggregate.REGISTER;
    }

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto,
                                            BindingResult result, WebRequest request, Errors errors) {

        String viewName = ViewsAggregate.REGISTER;
        if (!result.hasErrors()) {
            User account = createUserAccount(accountDto, result);
            if (account == null) {
                result.rejectValue("email", "message.regError");
            }
            try {
                String appUrl = "http://localhost:8080";
                eventPublisher.publishEvent(new OnRegistrationCompleteEvent(account, request.getLocale(), appUrl));
            } catch (Exception me) {
                logger.error("Bład w wysyłaniu maila");
                return new ModelAndView(ViewsAggregate.EMAILERROR, "user", accountDto);
            }
            viewName = ViewsAggregate.SUCCESSREGISTER;
        }
        return new ModelAndView(viewName, "user", accountDto);
    }


    private User createUserAccount(UserDto accountDto, BindingResult result) {
        try {
            return service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Autowired
    private IUserService serviceInterface;
    @Autowired
    private MessageSource messages;

    @RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration
            (WebRequest request, Model model, @RequestParam("token") String token) {
        Locale locale = request.getLocale();

        VerificationToken verificationToken = serviceInterface.getVerificationToken(token);
        if (verificationToken == null) {
            String message;
            message = messages.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messages.getMessage("auth.message.expired", null, locale);
            model.addAttribute("message", messageValue);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        user.setEnabled(true);
        serviceInterface.saveRegisteredUser(user);
        return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
    }
}
