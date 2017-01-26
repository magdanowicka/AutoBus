package pl.mnowicka.autobus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.service.EmailExistsException;
import pl.mnowicka.autobus.domain.UserDto;
import pl.mnowicka.autobus.service.UserService;
import pl.mnowicka.autobus.entities.User;


import javax.validation.Valid;

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
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto,
                                            BindingResult result, WebRequest request, Errors errors)  {

        String viewName = "register";

        if (!result.hasErrors()) {
            User account = createUserAccount(accountDto, result);
            if (account == null)  {
                result.rejectValue("email", "message.regError");
            }
            viewName = "successRegister";
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

}
