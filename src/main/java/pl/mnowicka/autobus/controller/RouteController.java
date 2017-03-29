package pl.mnowicka.autobus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pl.mnowicka.autobus.domain.RouteDto;
import pl.mnowicka.autobus.domain.UserDto;
import pl.mnowicka.autobus.entities.Route;
import pl.mnowicka.autobus.entities.User;
import pl.mnowicka.autobus.service.EmailExistsException;
import pl.mnowicka.autobus.service.OnRegistrationCompleteEvent;
import pl.mnowicka.autobus.service.RouteService;

import javax.validation.Valid;

/**
 * Created by magda on 2017-02-23.
 */
@Controller
public class RouteController {

    private static final Logger logger = LoggerFactory.getLogger(RouteController.class);


    @Autowired
    private RouteService service;

    @RequestMapping(value = "/addRoute", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {

        RouteDto routeDto = new RouteDto();
        model.addAttribute("route", routeDto);
        return "adminPage";
    }

    @RequestMapping(value = "/addRoute", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addRoute(@ModelAttribute("route") @Valid RouteDto routeDto,
                                            BindingResult result, WebRequest request, Errors errors)  {

        String viewName = "adminPage";


        if (!result.hasErrors()) {

            Route trasa = addRoute(routeDto, result);
            Route trasaPowrotna = addBackRoute(routeDto, result);

            viewName = "home";

        }

        return new ModelAndView(viewName, "route", routeDto);

    }


    private Route addRoute(RouteDto routeDto, BindingResult result) {
            return service.addNewRoute(routeDto);
    }
    private Route addBackRoute(RouteDto routeDto, BindingResult result) {
        return service.addNewBackRoute(routeDto);
    }


}
