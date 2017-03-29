package pl.mnowicka.autobus.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.repositories.UserRepository;
import pl.mnowicka.autobus.config.ViewsAggregate;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by magda on 2017-02-26.
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/email", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView emailUpdate(@RequestParam(value = "email") String email, HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User user = userRepository.findOneByUsername(name);
        user.setEmail(email);
        userRepository.save(user);

        ModelAndView mav = new ModelAndView(ViewsAggregate.USERPAGE);
        return mav;
    }

    @RequestMapping(value = "/phone", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView phoneUpdate(@RequestParam(value = "phone") String phone, HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User user = userRepository.findOneByUsername(name);
        user.setPhone(phone);
        userRepository.save(user);

        ModelAndView mav = new ModelAndView(ViewsAggregate.USERPAGE);
        return mav;
    }
}
