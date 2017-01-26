package pl.mnowicka.autobus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.EmailExistsException;
import pl.mnowicka.autobus.UserDto;
import pl.mnowicka.autobus.UserService;
import pl.mnowicka.autobus.entities.User;


import javax.validation.Valid;

/**
 * Created by magda on 2017-01-24.
 */
@Controller
public class RegistrationController {

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

        User registered = new User();
        if (!result.hasErrors()) {
            System.out.println("createacount");
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            System.out.println("error");
            return new ModelAndView("register", "user", accountDto);

        }
        else {
            System.out.println("udalo sie");
            return new ModelAndView("successRegister", "user", accountDto);


        }
    }

    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
            UserService service = new UserService();
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }

}
